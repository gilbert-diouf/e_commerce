package sn.edu.gub.ipsl.e_commerce_application.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sn.edu.gub.ipsl.e_commerce_application.service.UserService;

import java.io.IOException;


@Component
@NoArgsConstructor
public class JwtAuthentificationFilter extends OncePerRequestFilter {

    private JwtUnit jwtUnit;

    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        /*Recuperer le header*/
        final String authHeader=request.getHeader("Authorization");

        /* Verifier si le authHeader existe et commence par Bearer*/
        if (authHeader== null && !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }

        /* Recuperer le token*/
        String token= authHeader.substring(7);

        /* Extraire le userName*/
        String username= jwtUnit.extractedUsername(token);

        /* Verifier si l'utilisateur ne s'est pas deja connecter*/
        if (username != null && SecurityContextHolder.getContext().getAuthentication()==null){

            UserDetails userDetails =userService.loadUserByUsername(username);

            /* Verifier si le token est valide*/
            if (jwtUnit.validateToken(token,userDetails)){

                UsernamePasswordAuthenticationToken authenticationToken= UsernamePasswordAuthenticationToken.authenticated(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                
                /* Dire a token que l'utilisateur s'est deja connecter*/
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        /* Continuer la requette*/
        filterChain.doFilter(request,response);
    }
}

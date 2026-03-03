package sn.edu.gub.ipsl.e_commerce_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.gub.ipsl.e_commerce_application.DTO.AuthRequest;
import sn.edu.gub.ipsl.e_commerce_application.config.JwtUnit;

@RestController
@RequestMapping("/auth")
@Component
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUnit jwtUnit;

    @Autowired
    private UserDetailsService userDetailsService;

    public String login (@PathVariable AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserDetails user = userDetailsService
                .loadUserByUsername(request.getEmail());

        return jwtUnit.generatedToken(String.valueOf(user));
    }
}

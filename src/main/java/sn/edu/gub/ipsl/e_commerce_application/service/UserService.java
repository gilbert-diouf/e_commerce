package sn.edu.gub.ipsl.e_commerce_application.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sn.edu.gub.ipsl.e_commerce_application.entity.Role;
import sn.edu.gub.ipsl.e_commerce_application.entity.User;
import sn.edu.gub.ipsl.e_commerce_application.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> findByAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User createUser(User user) throws ApiError{
        if (user.getNom()==null || user.getNom().isBlank()){
            throw  new ApiError(404,"le nom est obligatoire");
        }
        if (user.getEmail()==null || user.getEmail().isEmpty()){
            throw new ApiError(404,"L'email est obligatoire");
        }
        return userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public User update(User user){
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")){
            return (UserDetails) User.builder()
                    .nom("admin")
                    .password(new BCryptPasswordEncoder().encode("passer123"))
                    .role(Role.Admin)
                    .build();
        }
        throw new UsernameNotFoundException("Utilisateur non trouve");
    }
}

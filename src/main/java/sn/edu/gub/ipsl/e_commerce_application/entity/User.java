package sn.edu.gub.ipsl.e_commerce_application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 25)
    private String nom;

    @Column(nullable = false,unique = true,length = 25)
    private String email;

    @Column(nullable = false,length = 16)
    private String password;

    private Role role;
}

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
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 30)
    private String nom;

    @Column(nullable = false,length = 100)
    private String description;

    @Column(nullable = false,length = 40)
    private double prix;

    @Column(length = 30)
    private Integer stock;
}

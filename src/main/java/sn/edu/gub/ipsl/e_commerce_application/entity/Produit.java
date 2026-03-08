package sn.edu.gub.ipsl.e_commerce_application.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 30)
    private String nom;

    @Column(nullable = false,length = 100)
    private String description;

    @Column(nullable = false,length = 40)
    private double prix;

    @Column(length = 30)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "commande")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "panier")
    private Panier panier;
}

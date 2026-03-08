package sn.edu.gub.ipsl.e_commerce_application.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Panier {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "panier",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Produit> produits;

    private LocalDateTime dateCreation;

    private LocalDateTime dateMiseJour;
}

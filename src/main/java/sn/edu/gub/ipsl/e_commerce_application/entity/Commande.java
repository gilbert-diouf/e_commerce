package sn.edu.gub.ipsl.e_commerce_application.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Produit> itemsProduits;

    private BigDecimal montantTotal;

    public enum STATUS{
        EN_COURS,
        VALIDEE,
        LIVREE
    }

    private LocalDateTime dateCreation;

    private LocalDateTime dateMiseJour;

}

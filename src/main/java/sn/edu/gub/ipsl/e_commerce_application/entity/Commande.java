package sn.edu.gub.ipsl.e_commerce_application.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
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

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime dateCreation;

    private LocalDateTime dateMiseJour;

}

package sn.edu.gub.ipsl.e_commerce_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.gub.ipsl.e_commerce_application.entity.Produit;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

    @Override
    Optional<Produit> findById(Long id);
}

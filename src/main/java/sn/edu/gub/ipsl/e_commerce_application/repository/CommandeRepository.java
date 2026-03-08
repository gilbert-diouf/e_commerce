package sn.edu.gub.ipsl.e_commerce_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.gub.ipsl.e_commerce_application.entity.Commande;

import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

    @Override
    Optional<Commande> findById(Long id);
}

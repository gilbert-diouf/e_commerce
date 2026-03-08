package sn.edu.gub.ipsl.e_commerce_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.gub.ipsl.e_commerce_application.entity.Panier;

import java.util.Optional;

public interface PanierRepository extends JpaRepository<Panier,Long> {

    @Override
    Optional<Panier> findById(Long id);
}

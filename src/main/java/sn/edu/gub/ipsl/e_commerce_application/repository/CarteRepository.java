package sn.edu.gub.ipsl.e_commerce_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.gub.ipsl.e_commerce_application.entity.Carte;

import java.util.Optional;

public interface CarteRepository extends JpaRepository<Carte,Long> {

    @Override
    Optional<Carte> findById(Long id);
}

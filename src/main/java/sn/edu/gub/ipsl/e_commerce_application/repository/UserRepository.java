package sn.edu.gub.ipsl.e_commerce_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.gub.ipsl.e_commerce_application.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    Optional<User> findById(Long id);
}

package sn.edu.gub.ipsl.e_commerce_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.gub.ipsl.e_commerce_application.entity.Order;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Override
    Optional<Order> findById(Long id);
}

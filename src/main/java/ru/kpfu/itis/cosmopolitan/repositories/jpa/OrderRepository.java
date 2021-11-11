package ru.kpfu.itis.cosmopolitan.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.cosmopolitan.models.Order;
import ru.kpfu.itis.cosmopolitan.models.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUser(User user);
}

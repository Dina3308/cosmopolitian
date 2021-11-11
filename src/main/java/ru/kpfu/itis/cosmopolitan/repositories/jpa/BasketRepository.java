package ru.kpfu.itis.cosmopolitan.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.cosmopolitan.models.Basket;
import ru.kpfu.itis.cosmopolitan.models.BasketToProduct;
import ru.kpfu.itis.cosmopolitan.models.User;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findBasketByUser(User user);

}

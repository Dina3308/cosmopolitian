package ru.kpfu.itis.cosmopolitan.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.cosmopolitan.models.Basket;
import ru.kpfu.itis.cosmopolitan.models.BasketToProduct;

import java.util.List;

public interface BasketToProductRepository extends JpaRepository<BasketToProduct, Long> {

    List<BasketToProduct> findAllByBasket(Basket basket);

}

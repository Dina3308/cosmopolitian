package ru.kpfu.itis.cosmopolitan.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.itis.cosmopolitan.dto.ProductSold;
import ru.kpfu.itis.cosmopolitan.models.OrderToProduct;

import java.util.List;

public interface OrderToProductRepository extends JpaRepository<OrderToProduct, Long> {

}

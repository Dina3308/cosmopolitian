package ru.kpfu.itis.cosmopolitan.repositories.jpa;

import org.hibernate.Session;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.cosmopolitan.dto.ProductSold;
import ru.kpfu.itis.cosmopolitan.models.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long aLong);

    List<Product> findProductsByProductCountGreaterThan(int productCount);

    @Query(nativeQuery = true, value = "SELECT p.Id, p.product_name, p.category, p.product_price, p.product_count, p.product_Img, p.description\n" +
            "FROM order_product op\n" +
            "         join products p on p.Id = op.product_id\n" +
            "where p.product_count > 0\n" +
            "group by p.id, p.product_name, p.category, p.product_price, p.product_count, p.product_Img, p.description\n" +
            "ORDER BY SUM(\"count\") DESC, p.id desc ")
    List<Product> findProductsByCategoryDescByCount();

    List<Product> findProductsByCategoryAndProductCountGreaterThan(String category, int productCount);

    @Query(nativeQuery = true, value = "SELECT p.Id, SUM(\"count\") FROM order_product op join products p on p.Id = op.product_id group by p.id order by p.id desc ")
    List<Object[]> getCountOfProductsSold();


}

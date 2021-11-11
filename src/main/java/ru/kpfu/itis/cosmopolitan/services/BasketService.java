package ru.kpfu.itis.cosmopolitan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.cosmopolitan.dto.BasketDto;
import ru.kpfu.itis.cosmopolitan.models.Basket;
import ru.kpfu.itis.cosmopolitan.models.BasketToProduct;
import ru.kpfu.itis.cosmopolitan.models.Product;
import ru.kpfu.itis.cosmopolitan.models.User;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.BasketRepository;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.BasketToProductRepository;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.ProductRepository;
import java.util.List;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BasketToProductRepository basketToProductRepository;

    public List<BasketDto> read(User user) {
        Basket basket = basketRepository.findBasketByUser(user);
        return BasketDto.from(basketToProductRepository.findAllByBasket(basket));
    }

    public void delete(Long id) {
        basketToProductRepository.deleteById(id);
    }

    public BasketDto update(Long id, int count) {
        BasketToProduct basketToProduct = basketToProductRepository.findById(id).get();
        basketToProduct.setCount(count);
        basketToProductRepository.save(basketToProduct);
        return BasketDto.from(basketToProduct);
    }

    public void create(User user, int count, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);

        Basket basket = basketRepository.findBasketByUser(user);

        basketToProductRepository.save(BasketToProduct.builder().product(product).count(count).basket(basket).build());
    }

}

package ru.kpfu.itis.cosmopolitan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.cosmopolitan.dto.DataFillingForm;
import ru.kpfu.itis.cosmopolitan.dto.OrderDto;
import ru.kpfu.itis.cosmopolitan.models.*;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.BasketRepository;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.OrderRepository;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.BasketToProductRepository;
import ru.kpfu.itis.cosmopolitan.repositories.jpa.OrderToProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ApiService apiService;

    @Autowired
    BasketToProductRepository basketToProductRepository;

    @Autowired
    OrderToProductRepository orderToProductRepository;

    @Autowired
    ProductService productService;

    public void createOrder(User user, DataFillingForm form){
        Basket basket = basketRepository.findBasketByUser(user);
        List<BasketToProduct> baskets = basketToProductRepository.findAllByBasket(basket);
        List<OrderToProduct> orderToProducts = new ArrayList<>();

        Order order = Order.builder()
                .city(form.getCity())
                .email(form.getEmail())
                .name(form.getName())
                .phoneNumber(form.getNumberPhone())
                .region(form.getRegion())
                .street(form.getStreet())
                .surname(form.getSurname())
                .user(user)
                .build();

        for(BasketToProduct b : baskets){
            int price = apiService.convertToRub(b.getProduct().getProductPrice());

            OrderToProduct orderToProduct = OrderToProduct.builder()
                    .product(b.getProduct())
                    .count(b.getCount())
                    .price(price)
                    .order(order)
                    .build();

            orderToProducts.add(orderToProduct);
            productService.update(b.getProduct().getId(), b.getProduct().getProductCount() - b.getCount());
        }

        orderRepository.save(order);
        orderToProductRepository.saveAll(orderToProducts);
        basketToProductRepository.deleteAll();
    }

    public List<OrderDto> readOrders(User user){
        return OrderDto.from(orderRepository.findAllByUser(user));
    }

}

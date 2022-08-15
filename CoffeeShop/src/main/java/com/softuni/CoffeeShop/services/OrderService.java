package com.softuni.CoffeeShop.services;

import com.softuni.CoffeeShop.models.Category;
import com.softuni.CoffeeShop.models.Order;
import com.softuni.CoffeeShop.models.OrderType;
import com.softuni.CoffeeShop.models.User;
import com.softuni.CoffeeShop.models.dto.CreateOrderDTO;
import com.softuni.CoffeeShop.models.dto.OrderDTO;
import com.softuni.CoffeeShop.repositories.CategoryRepository;
import com.softuni.CoffeeShop.repositories.OrderRepository;
import com.softuni.CoffeeShop.repositories.UserRepository;
import com.softuni.CoffeeShop.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        CategoryRepository categoryRepository,
                        LoggedUser loggedUser,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean create(CreateOrderDTO createOrderDTO) {

        Optional<Order> byName =
                this.orderRepository.findByName(createOrderDTO.getName());

        if (byName.isPresent()) {
            return false;
        }


        OrderType type = createOrderDTO.getCategory();
        Category category = this.categoryRepository.findByName(type);
        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());

        Order order = new Order();
        order.setCategory(category);
        order.setDescription(createOrderDTO.getDescription());
        order.setName(createOrderDTO.getName());
        order.setPrice(createOrderDTO.getPrice());
        order.setTime(createOrderDTO.getTime());
        order.setUser(owner.get());

        this.orderRepository.save(order);

        return true;
    }

    public List<OrderDTO> getOrdersOwnedBy(long ownerId) {
        return this.orderRepository.findByUserId(ownerId)
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }


    public List<OrderDTO> getOrdersNotOwnedBy(long ownerId) {
        return this.orderRepository.findByUserIdNot(ownerId)
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    public List<OrderDTO> findAllOrderOrderByPriceDesc() {
        return this.orderRepository.findByOrderByPriceDesc()
                .stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    public void readyOrder(Long id) {
       this.orderRepository.deleteById(id);
    }
}

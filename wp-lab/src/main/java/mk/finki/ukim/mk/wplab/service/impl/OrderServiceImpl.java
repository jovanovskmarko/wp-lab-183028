package mk.finki.ukim.mk.wplab.service.impl;

import mk.finki.ukim.mk.wplab.model.Order;
import mk.finki.ukim.mk.wplab.repository.OrderRepository;
import mk.finki.ukim.mk.wplab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> listAllOrders() {
        return orderRepository.listAllOrders();
    }

    @Override
    public Order addNewOrder(String color, String clientName, String clientAddress) {
        return orderRepository.addNewOrder(color, clientName, clientAddress);
    }


}

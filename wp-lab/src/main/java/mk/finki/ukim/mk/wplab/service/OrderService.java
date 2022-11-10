package mk.finki.ukim.mk.wplab.service;

import mk.finki.ukim.mk.wplab.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> listAllOrders();

    Order addNewOrder(String color, String clientName, String clientAddress);

}

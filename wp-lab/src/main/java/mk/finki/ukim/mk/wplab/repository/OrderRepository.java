package mk.finki.ukim.mk.wplab.repository;

import mk.finki.ukim.mk.wplab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wplab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    public List<Order> listAllOrders() {
        return DataHolder.orders;
    }


    public Order addNewOrder(String color, String clientName, String clientAddress) {
        Order o = new Order(color, clientName, clientAddress);
        DataHolder.orders.add(o);
        return o;
    }
}

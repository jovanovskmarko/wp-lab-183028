package mk.finki.ukim.mk.wplab.web.controller;

import mk.finki.ukim.mk.wplab.model.Order;
import mk.finki.ukim.mk.wplab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrders(Model model) {
        List<Order> orders = this.orderService.listAllOrders();

        model.addAttribute("orders", orders);
        return "userOrders";
    }
}

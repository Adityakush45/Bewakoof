package com.bewkoof.demo.Controller;

import com.bewkoof.demo.Model.Order;
import com.bewkoof.demo.Model.OrderItem;
import com.bewkoof.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

        @PostMapping ("/placeOrder/{id}")
        public void placeOrder(@PathVariable int id){

            orderService.placeOrder(id);

        }

        @GetMapping("/allOrders/{id}")
        public List<OrderItem> allOrders(@PathVariable int id){

            return orderService.allOrders(id);
        }
}

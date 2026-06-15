package com.bewkoof.demo.Service;

import com.bewkoof.demo.Model.*;
import com.bewkoof.demo.Repo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderItemRepo orderItemRepo;

    @Autowired
    CartItemRepo cartItemRepo;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    ProductRepo productRepo;

   @Transactional
    public void placeOrder(int id) {

        Cart cart = cartRepo.findByUserId(id).orElse(null);

        List<CartItem> cartItems = cartItemRepo.findByCart_cartid(cart.getCartid());
        int price = 0;

        for(CartItem cartItem : cartItems){

            price += cartItem.getProduct().getPrice()*cartItem.getQuantity();

        }

        Order order = new Order();
        order.setStatus("Accepted");
        order.setUser(cart.getUser());
        order.setTotalprice(price);

        Order order1 = orderRepo.save(order);

        for(CartItem cartItem : cartItems){

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order1);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItemRepo.save(orderItem);
            Product product = cartItem.getProduct();
            product.setQuantity(product.getQuantity() - cartItem.getQuantity());
            if(product.getQuantity() <= 0){
                product.setAvailable(false);
                product.setQuantity(0);
            }
            productRepo.save(product);

            cartItemRepo.delete(cartItem);

        }

        cartRepo.delete(cart);




    }

    public List<OrderItem> allOrders(int userId) {

        List<Order> orders = orderRepo.findByUser_Id(userId);

        if (orders.isEmpty()) return new ArrayList<>();

        List<OrderItem> allItems = new ArrayList<>();

        for (Order order : orders) {
            List<OrderItem> items = orderItemRepo.findByOrder_orderId(order.getOrderId());
            allItems.addAll(items);
        }

        return allItems;
    }
}

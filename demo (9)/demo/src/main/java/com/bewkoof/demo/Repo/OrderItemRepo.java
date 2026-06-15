package com.bewkoof.demo.Repo;

import com.bewkoof.demo.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {


    List<OrderItem> findByOrder_orderId(int orderId);
}

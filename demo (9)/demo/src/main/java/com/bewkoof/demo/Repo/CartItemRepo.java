package com.bewkoof.demo.Repo;

import com.bewkoof.demo.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItem,Integer> {

    List<CartItem> findByCart_cartid(int cartid);

    void deleteByCart_cartidAndProduct_prodId(int cartid,int prodid);
    List<CartItem> findByProduct_prodId(int prodId);
}

package com.bewkoof.demo.Repo;

import com.bewkoof.demo.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart,Integer> {

    Optional<Cart> findByUserId(Integer integer);


}

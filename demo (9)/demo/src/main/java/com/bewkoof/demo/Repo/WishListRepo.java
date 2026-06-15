package com.bewkoof.demo.Repo;

import com.bewkoof.demo.Model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepo extends JpaRepository<WishList,Integer> {
    WishList findByUserId(int id);
}

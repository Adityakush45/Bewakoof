package com.bewkoof.demo.Repo;

import com.bewkoof.demo.Model.WishListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishListItemRepo extends JpaRepository<WishListItem,Integer> {


    @Query("SELECT w FROM WishListItem w WHERE w.wishList.WishListId = :id")
    List<WishListItem> findByWishListId(@Param("id") int id);
}

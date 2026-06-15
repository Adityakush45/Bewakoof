package com.bewkoof.demo.Controller;


import com.bewkoof.demo.Model.Product;
import com.bewkoof.demo.Service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class WishListController {

    @Autowired
    WishListService wishListService;

    @PostMapping("/addToWishlist/{userId}/{prodId}")
    public void addToWishlist(@PathVariable int userId,@PathVariable int prodId){

        wishListService.addToWishList(userId,prodId);


    }

    @GetMapping("/goToWishlist/{userId}")
    public List<Product> goToWishList(@PathVariable int userId){

       return wishListService.goToWishList(userId);

    }

}

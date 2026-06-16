package com.bewkoof.demo.Controller;

import com.bewkoof.demo.DTO.CartRequestDTO;
import com.bewkoof.demo.DTO.CartResponseDTO;
import com.bewkoof.demo.Model.CartItem;
import com.bewkoof.demo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CartController {

    @Autowired
    CartService cartService;


     @PostMapping("/AddToCart")
    public String addToCart(@RequestBody CartRequestDTO cartRequestDTO){

        return cartService.addToCart(cartRequestDTO);



    }

    @DeleteMapping("/deleteFromCart/{prodId}/{id}")
    public void deleteFromCart(@PathVariable int prodId,@PathVariable int id){
        System.out.println("hello");
         cartService.deleteFromCart(id,prodId);
    }

    @GetMapping("/goToCart/{id}")
    public List<CartResponseDTO> goToCart(@PathVariable int id){

        return cartService.goToCart(id);
    }

}

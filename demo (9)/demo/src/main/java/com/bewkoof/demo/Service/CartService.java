package com.bewkoof.demo.Service;

import com.bewkoof.demo.DTO.CartRequestDTO;
import com.bewkoof.demo.DTO.CartResponseDTO;
import com.bewkoof.demo.Model.Cart;
import com.bewkoof.demo.Model.CartItem;
import com.bewkoof.demo.Model.Product;
import com.bewkoof.demo.Model.User;
import com.bewkoof.demo.Repo.CartItemRepo;
import com.bewkoof.demo.Repo.CartRepo;
import com.bewkoof.demo.Repo.ProductRepo;
import com.bewkoof.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CartItemRepo cartItemRepo;
    @Autowired
    ProductRepo productRepo;

    public String addToCart(CartRequestDTO cartItem) {

        Cart cart = isExist(cartItem.userId());

        if(cart == null){

            User user = userRepo.findById(cartItem.userId()).orElse(null);

            cart = new Cart();
            cart.setUser(user);
            cart = cartRepo.save(cart);



        }

        CartItem cartItem1 = new CartItem();
        cartItem1.setCart(cart);
        cartItem1.setQuantity(cartItem.quantity());
        cartItem1.setProduct(productRepo.findById(cartItem.ProductId()).orElse(null));
        cartItemRepo.save(cartItem1);

        return "Successfull";




    }

    public Cart isExist(Integer id){

        Optional<Cart> cart = cartRepo.findByUserId(id);

        if(cart.isPresent()) {
            return cart.get(); // .get() lagane se asli Product bahar nikalta hai
        }
        return null;
    }

    public List<CartResponseDTO> goToCart(int id) {

        Cart cart = cartRepo.findByUserId(id).orElse(null);

        if (cart == null) return new ArrayList<>(); // ← yeh line add karo

        List<CartItem> lis = cartItemRepo.findByCart_cartid(cart.getCartid());

        List<CartResponseDTO> res = new ArrayList<>();

        for (CartItem cartItem : lis) {
            Product product = productRepo.findById(cartItem.getProduct().getProdId()).orElse(null);
            CartResponseDTO cartResponseDTO = new CartResponseDTO(
                    product.getProdId(),
                    product.getName(),
                    product.getDescription(),
                    cartItem.getQuantity(),
                    product.getPrice()
            );
            res.add(cartResponseDTO);
        }

        return res;
    }
    @Transactional
    public void deleteFromCart(int id, int prodId) {

        Cart cart = cartRepo.findByUserId(id).orElse(null);
        cartItemRepo.deleteByCart_cartidAndProduct_prodId(id,prodId);
    }
}

package com.bewkoof.demo.Service;

import com.bewkoof.demo.Model.*;
import com.bewkoof.demo.Repo.ProductRepo;
import com.bewkoof.demo.Repo.UserRepo;
import com.bewkoof.demo.Repo.WishListItemRepo;
import com.bewkoof.demo.Repo.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    WishListRepo wishListRepo;
    @Autowired
    WishListItemRepo wishListItemRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;

    public void addToWishList(int userId, int prodId) {

        WishList wishList = isExist(userId);

        if(wishList == null){

            User user = userRepo.findById(userId).orElse(null);
            wishList = new WishList();
            wishList.setUser(user);
            wishListRepo.save(wishList);

        }

        WishListItem wishListItem = new WishListItem();
        wishListItem.setWishList(wishList);
        Product product = productRepo.findById(prodId).orElse(null);
        wishListItem.setProduct(product);
        wishListItemRepo.save(wishListItem);


    }

    private WishList isExist(int id) {

        WishList wishList = wishListRepo.findByUserId(id);

        if(wishList == null){
            return null;
        }
        return wishList;
    }

    public List<Product> goToWishList(int userId) {

        WishList wishList = wishListRepo.findByUserId(userId);

        if(wishList == null) return new ArrayList<>();
        List<WishListItem> lis = wishListItemRepo.findByWishListId(wishList.getWishListId());
        List<Product> res = new ArrayList<>();

        for(WishListItem wishListItem : lis){

            res.add(productRepo.findById(wishListItem.getProduct().getProdId()).orElse(null));
        }

        return res;
    }
}

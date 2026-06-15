package com.bewkoof.demo.Model;

import jakarta.persistence.*;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int WishListId;
    @OneToOne
    private User user;

    public int getWishListId() {
        return WishListId;
    }

    public void setWishListId(int wishListId) {
        WishListId = wishListId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

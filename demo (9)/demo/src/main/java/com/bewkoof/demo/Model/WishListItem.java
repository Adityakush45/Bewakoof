package com.bewkoof.demo.Model;

import jakarta.persistence.*;

@Entity
public class WishListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private WishList wishList;
    @OneToOne
    private Product product;

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

package com.bewkoof.demo.Service;

import com.bewkoof.demo.Model.Product;
import com.bewkoof.demo.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    public List<Product> productListById(Integer id) {
        List<Product> lis = productRepo.findByCategoryId(id);
        return lis;
    }

    public Product productById(Integer prodId) {

        Optional<Product> product = productRepo.findById(prodId);

        if(product.isPresent()) {
            return product.get(); // .get() lagane se asli Product bahar nikalta hai
        }
        return null;
    }




    public List<Product> searchAndFilterProducts(String keyword, String gender, Integer catId, Double price, Boolean available) {

        List<Product> lis = productRepo.searchAndFilterProducts(keyword,gender,catId,price,available);
        return lis;
    }

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }
}

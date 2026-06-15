package com.bewkoof.demo.Controller;

import com.bewkoof.demo.Model.Product;
import com.bewkoof.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/catlog/{catId}")
    public List<Product> productListByid(@PathVariable Integer catId){

        System.out.println("frontend ne "+catId+" beji h");

        return productService.productListById(catId);
    }

    @GetMapping("product/{prodId}")
    public Product productByProductId(@PathVariable Integer prodId){

        return productService.productById(prodId);

    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }


    @GetMapping("/search")
    public List<Product> getProducts(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Integer catId,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Boolean available
    ) {
        // Agar query empty string ("") aati hai frontend se, toh use null treat karo taaki query sahi chale
        String searchKeyword = (query != null && !query.trim().isEmpty()) ? query : null;

        return productService.searchAndFilterProducts(searchKeyword, gender, catId, price, available);
    }
}

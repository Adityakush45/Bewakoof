package com.bewkoof.demo.Repo;

import com.bewkoof.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {



    List<Product> findByCategoryId(Integer catId);



    @Query("SELECT p FROM Product p WHERE " +
            "(:keyword IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
            "(:gender IS NULL OR p.category.gender = :gender) AND " +
            "(:catId IS NULL OR p.category.id = :catId) AND " +
            "(:price IS NULL OR p.price <= :price) AND " +
            "(:available IS NULL OR p.available = :available)")
    List<Product> searchAndFilterProducts(
            @Param("keyword") String keyword,
            @Param("gender") String gender,
            @Param("catId") Integer catId,
            @Param("price") Double maxPrice,
            @Param("available") Boolean available
    );

}

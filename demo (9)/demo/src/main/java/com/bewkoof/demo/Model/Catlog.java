package com.bewkoof.demo.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Entity
public class Catlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ke liye
    private int id;


    private String categoryName;


    private int numberOfDesign;


    private LocalDate lastUpdatedDate ;

    private String gender;

    @PrePersist
    protected void onCreate() {
        this.lastUpdatedDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getNumberOfDesign() {
        return numberOfDesign;
    }

    public void setNumberOfDesign(int numberOfDesign) {
        this.numberOfDesign = numberOfDesign;
    }

    public LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

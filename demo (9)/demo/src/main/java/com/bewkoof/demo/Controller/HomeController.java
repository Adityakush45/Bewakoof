package com.bewkoof.demo.Controller;


import com.bewkoof.demo.DTO.CatlogDTO;
import com.bewkoof.demo.Model.Catlog;
import com.bewkoof.demo.Model.Product;
import com.bewkoof.demo.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController



public class HomeController {

    @Autowired
    HomeService homeService;


    @GetMapping("/bewkoof")
    public List<CatlogDTO> bewkoof(){

        List<CatlogDTO> lis = homeService.bewkoof();

        return lis;

    }

    @PostMapping("/AddCategory")
    public void addCategory(@RequestBody Catlog catlog){


        homeService.addCategory(catlog);

    }


}

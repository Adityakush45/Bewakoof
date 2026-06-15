package com.bewkoof.demo.Controller;

import com.bewkoof.demo.DTO.UserLoginDTO;
import com.bewkoof.demo.Model.User;
import com.bewkoof.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public User signup(@RequestBody User user){

        return userService.signup(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserLoginDTO userlogindto){

        return userService.login(userlogindto);

    }
}

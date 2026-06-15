package com.bewkoof.demo.Service;

import com.bewkoof.demo.DTO.UserLoginDTO;
import com.bewkoof.demo.Model.User;
import com.bewkoof.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User signup(User user) {
        return userRepo.save(user);
    }

    public User login(UserLoginDTO userlogindto) {

        User user = userRepo.findByemail(userlogindto.email());

        if(user != null){

            if(user.getPassword().equals(userlogindto.password())){
                return user;
            }

        }

        return null;
    }
}

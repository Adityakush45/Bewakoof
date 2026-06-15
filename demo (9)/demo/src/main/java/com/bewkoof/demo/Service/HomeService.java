package com.bewkoof.demo.Service;

import com.bewkoof.demo.DTO.CatlogDTO;
import com.bewkoof.demo.Model.Catlog;
import com.bewkoof.demo.Repo.HomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    @Autowired
    HomeRepo repo;


    public List<CatlogDTO> bewkoof() {
        List<Catlog> lis = repo.findAll();

        List<CatlogDTO> res = new ArrayList<>();

        for (Catlog cat : lis){

            CatlogDTO catlogDTO = new CatlogDTO(cat.getId(),cat.getCategoryName(),cat.getGender());
            res.add(catlogDTO);
        }

        return res;


    }

    public void addCategory(Catlog catlog) {

        repo.save(catlog);
    }
}

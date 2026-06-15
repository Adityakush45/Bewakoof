package com.bewkoof.demo.Repo;

import com.bewkoof.demo.Model.Catlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepo extends JpaRepository<Catlog,Integer> {
}

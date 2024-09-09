package com.benjdiya.monoapp.repositories;

import com.benjdiya.monoapp.entities.Categories;
import com.benjdiya.monoapp.entities.Compte;
import com.benjdiya.monoapp.entities.Offres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesRepo extends JpaRepository<Categories,Long> {

}

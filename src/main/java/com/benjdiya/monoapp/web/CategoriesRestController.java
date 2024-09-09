package com.benjdiya.monoapp.web;

import com.benjdiya.monoapp.dtos.CategorieDTO;
import com.benjdiya.monoapp.entities.Categories;
import com.benjdiya.monoapp.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesRestController {
    @Autowired
    CategoriesService categoriesService;
    @GetMapping("/categories")
    public List<CategorieDTO> categoriesList(){
        return categoriesService.GetCategories();
    }
}

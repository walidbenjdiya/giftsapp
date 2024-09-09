package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.CategorieDTO;
import com.benjdiya.monoapp.entities.Categories;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoriesService {

    List<CategorieDTO> GetCategories();
}

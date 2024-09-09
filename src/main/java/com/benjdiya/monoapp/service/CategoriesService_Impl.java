package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.CategorieDTO;
import com.benjdiya.monoapp.entities.Categories;
import com.benjdiya.monoapp.mappers.CategoriesMapper;
import com.benjdiya.monoapp.repositories.CategoriesRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional @AllArgsConstructor @NoArgsConstructor
public class CategoriesService_Impl implements CategoriesService{
    CategoriesRepo categoriesRepo;
    CategoriesMapper categoriesMapper;
    @Override
    public List<CategorieDTO> GetCategories() {
        return categoriesRepo.findAll().stream().map(categories -> categoriesMapper.FromCategory(categories)).collect(Collectors.toList());
    }
}

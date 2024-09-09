package com.benjdiya.monoapp.mappers;

import com.benjdiya.monoapp.dtos.CategorieDTO;
import com.benjdiya.monoapp.dtos.HistoryDTO;
import com.benjdiya.monoapp.entities.Categories;
import com.benjdiya.monoapp.entities.History;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class CategoriesMapper {

    public CategorieDTO FromCategory(Categories categories){
        CategorieDTO categorieDTO=new CategorieDTO();
        BeanUtils.copyProperties(categories, categorieDTO);

        return categorieDTO;
    }

    public Categories ToCategory(CategorieDTO categorieDTO){
        Categories categorie=new Categories();
        BeanUtils.copyProperties(categorieDTO, categorie);

        return categorie;
    }

}

package com.benjdiya.monoapp.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategorieDTO {
    private Long Id;
    private String img;
    private String title;

}

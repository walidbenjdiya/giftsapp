package com.benjdiya.monoapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OffresDTO {
    private Long id;
    private String description;
    private String title;
    private String name;
    private String image;
    private String raffledraw;
}

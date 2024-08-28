package com.benjdiya.monoapp.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HistoryDTO {
    private Long Id;
    private String offer;
    private String date;
    private String heure;
}

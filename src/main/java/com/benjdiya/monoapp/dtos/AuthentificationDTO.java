package com.benjdiya.monoapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AuthentificationDTO {
    private String Email;
    private String Password;
}

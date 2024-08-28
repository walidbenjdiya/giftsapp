package com.benjdiya.monoapp.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserInfoConfirmationDTO {
    private Long id;
    private String nom;
    private String username;
    private String prenom;
    private LocalDateTime dateNaissance;
    private String adresse;
    private String ville;
    private String numero_Tele;
}

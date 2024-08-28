package com.benjdiya.monoapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class UtilisateurDTO {
    private Long id;
    private String userId;
    private String nom;
    private String username;
    private String prenom;
    private String dateNaissance;
    private String state;
    private String adresse;
    private String ville;
    private String Numero_Tele;
}

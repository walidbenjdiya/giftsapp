package com.benjdiya.monoapp.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class inscriptionDTO {
    private Long id;
    private String userId;
    private String nom;
    private String prenom;
    private String Username;
    private String Email;
    private String adresse;
    private String ville;
    private String dateNaissance;
    private String Numero_Tele;
}

package com.benjdiya.monoapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Utilisateur {
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String username;
    private String userId;
    private String Nom;
    private String Prenom;
    private LocalDate DateNaissance;
    private String State;
    private String Adresse;
    private String Ville;
    private String Numero_Tele;
    @OneToOne(mappedBy = "utilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Compte compte;
    @OneToMany(mappedBy = "utilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<History> historyList;

    @OneToMany(mappedBy = "utilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Notification> notificationList;

    @ManyToMany(mappedBy = "utlisateursList")
    private List<Offres> offersList;
}

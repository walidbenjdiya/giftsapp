package com.benjdiya.monoapp.entities;

import com.benjdiya.monoapp.enums.CompteStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity @Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Compte {
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String Password;
    private LocalDateTime CreatedAt;
    private CompteStatus Status;
    @OneToOne()
    private Utilisateur utilisateur;

}

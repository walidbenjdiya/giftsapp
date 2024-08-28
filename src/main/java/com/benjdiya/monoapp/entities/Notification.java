package com.benjdiya.monoapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDateTime time;
    @ManyToOne
    private Utilisateur utilisateur;
}

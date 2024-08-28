package com.benjdiya.monoapp.repositories;

import com.benjdiya.monoapp.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long> {
 Utilisateur findUtilisateurByUsername(String az);
 Boolean findByUserId(String a);
 Utilisateur findUtilisateurByUserId(String aa);
}

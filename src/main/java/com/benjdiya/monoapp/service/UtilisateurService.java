package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.UtilisateurDTO;
import com.benjdiya.monoapp.dtos.inscriptionDTO;
import com.benjdiya.monoapp.entities.Utilisateur;
import com.benjdiya.monoapp.exception.UserNotFoundException;
import com.benjdiya.monoapp.exception.UserbalancelistException;

import java.util.List;


public interface UtilisateurService {
    void ajouterUser(UtilisateurDTO inscription);
    UtilisateurDTO GetUtilisateur(String aze) throws UserNotFoundException, UserbalancelistException;

    void supprimerUser(Utilisateur utilisateur);
    Utilisateur modifierUser(Long id,Utilisateur utilisateur);
    List<UtilisateurDTO> UTILISATEUR_LIST();

}

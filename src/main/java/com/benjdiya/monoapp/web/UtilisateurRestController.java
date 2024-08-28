package com.benjdiya.monoapp.web;

import com.benjdiya.monoapp.dtos.UtilisateurDTO;
import com.benjdiya.monoapp.dtos.inscriptionDTO;
import com.benjdiya.monoapp.entities.Utilisateur;
import com.benjdiya.monoapp.exception.UserNotFoundException;
import com.benjdiya.monoapp.exception.UserbalancelistException;
import com.benjdiya.monoapp.repositories.UtilisateurRepo;
import com.benjdiya.monoapp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurRestController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    NotificationController notificationController;
    @Autowired
    UtilisateurRepo utilisateurRepo;

    @GetMapping("/users")
    public List<UtilisateurDTO> utilisateurList()  {
        return utilisateurService.UTILISATEUR_LIST();
    }
    @GetMapping("/users/{id}")
    public UtilisateurDTO utilisateurDTO(@PathVariable(name = "id") String id) throws UserNotFoundException, UserbalancelistException {
      UtilisateurDTO utilisateurDTO= utilisateurService.GetUtilisateur(id);
      return utilisateurDTO;
    }
    @PostMapping("/addUser")
    public void inscription(@RequestBody UtilisateurDTO inscript){

            // Si l'utilisateur n'existe pas, ajouter l'utilisateur
            utilisateurService.ajouterUser(inscript);

    }

}

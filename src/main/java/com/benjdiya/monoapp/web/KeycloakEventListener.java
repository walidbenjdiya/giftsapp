package com.benjdiya.monoapp.web;

import com.benjdiya.monoapp.dtos.inscriptionDTO;
import com.benjdiya.monoapp.entities.Utilisateur;
import com.benjdiya.monoapp.mappers.UtilistrCmptMapper;
import com.benjdiya.monoapp.repositories.CompteRepo;
import com.benjdiya.monoapp.repositories.UtilisateurRepo;
import com.benjdiya.monoapp.service.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
public class KeycloakEventListener {
    @Autowired
    private UtilisateurRepo utilisateurRepo;
    @Autowired
    private UtilistrCmptMapper utilistrCmptMapper;
    @Autowired
    private CompteRepo compteRepo;
    @Autowired
    private OffersRestController offersRestController;
    private final KeycloakService keycloakService;
    int i=1;
    public KeycloakEventListener() {
        this.keycloakService = new KeycloakService();
    }

    @PostMapping("/keycloak/events/login")
    public String handleKeycloakEvent(@RequestBody Map<String, Object> event) throws URISyntaxException, IOException, InterruptedException {
        // Process the event
        String userId = (String) event.get("userId");
//        if(!utilisateurRepo.findByUserId(userId)){
//            handleRegistrationEvent(event);
//        }
//
//        keycloakService.getUser(userId);
//        System.out.println(event);
//        @SuppressWarnings("unchecked")
//        Map<String, String> details = (Map<String, String>) event.get("details");
//        String email=details.get("username");
//        Long UserId =utilisateurRepo.findUtilisateurByUsername(email).getId();
       return "offersRestController.offerlist(UserId)";
    }
    @PostMapping("/keycloak/events/inscription")
    public void handleRegistrationEvent(@RequestBody Map<String, Object> event) {
        // Convertir l'événement en entité utilisateur et sauvegarder dans la base de données

        System.out.println(event);

        Map<String, String> details = (Map<String, String>) event.get("details");

        // Créer une instance de InscriptionDTO
        inscriptionDTO inscription = new inscriptionDTO();

        // Mapper les éléments de la carte vers l'objet InscriptionDTO
        if (details != null) {
            inscription.setUsername(details.get("username"));
            inscription.setUserId(event.get("userId").toString());
            inscription.setEmail(details.get("email"));
//            inscription.setPrenom(details.get("first_name"));
//            inscription.setNom(details.get("last_name"));
            Utilisateur utilisateur= utilistrCmptMapper.FromInscriToUsr(inscription);
            compteRepo.save(utilisateur.getCompte());
            utilisateurRepo.save(utilisateur);
        }

    }
}

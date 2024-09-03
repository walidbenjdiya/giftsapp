package com.benjdiya.monoapp.web;

import com.benjdiya.monoapp.dtos.HistoryDTO;
import com.benjdiya.monoapp.entities.History;
import com.benjdiya.monoapp.entities.Utilisateur;
import com.benjdiya.monoapp.exception.HistoryNotAddedException;
import com.benjdiya.monoapp.exception.OfferNullTargetedPersonne;
import com.benjdiya.monoapp.repositories.OffersRepo;
import com.benjdiya.monoapp.repositories.UtilisateurRepo;
import com.benjdiya.monoapp.service.HistoryService;
import com.benjdiya.monoapp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class HistoryController {
     @Autowired
    HistoryService historyService;
     @Autowired
    UtilisateurRepo utilisateurRepo;
     @Autowired
    OffersRepo offersRepo;


    @GetMapping("/history/{id}")
    public List<HistoryDTO> history(@PathVariable(name = "id") String userId){
       return historyService.HISTORY_LIST(userId);
    }

    @PostMapping("/goldapi/postback")
    public void Goldapi(@RequestParam String ip,@RequestParam String s1) throws HistoryNotAddedException, OfferNullTargetedPersonne {
        if(s1==null){
            throw new OfferNullTargetedPersonne("the targeted person for offer is null");
        }
        String[] parts = s1.split("-");
        String offerName=parts[0];
        String UtilistName=parts[1];
        Utilisateur utilisateur= utilisateurRepo.findUtilisateurByUsername(UtilistName);
        History history=new History();
        history.setUtilisateur(utilisateur);
        history.setTime(LocalDateTime.now());
        history.setOffre(offersRepo.findByName(offerName));
        historyService.AjouterHistory(history);
    }
}

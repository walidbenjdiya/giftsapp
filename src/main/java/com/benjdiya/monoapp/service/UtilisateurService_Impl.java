package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.UtilisateurDTO;
import com.benjdiya.monoapp.dtos.inscriptionDTO;
import com.benjdiya.monoapp.entities.Utilisateur;
import com.benjdiya.monoapp.exception.UserNotFoundException;
import com.benjdiya.monoapp.exception.UserbalancelistException;
import com.benjdiya.monoapp.mappers.UtilistrCmptMapper;
import com.benjdiya.monoapp.repositories.CompteRepo;
import com.benjdiya.monoapp.repositories.UtilisateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UtilisateurService_Impl implements UtilisateurService{

    private UtilisateurRepo utilisateurRepo;
    private CompteRepo compteRepo;
    private UtilistrCmptMapper utilistrCmptMapper;
    @Override
    public void ajouterUser(UtilisateurDTO inscription) {

            Utilisateur utilis= utilistrCmptMapper.FromUsrDtoToUsr(inscription);

            utilisateurRepo.findById(inscription.getId()).map(utilisateur -> {
                utilisateur.setPrenom(utilis.getPrenom());
                utilisateur.setNom(utilis.getNom());
                utilisateur.setVille(utilis.getVille());
                utilisateur.setAdresse(utilis.getAdresse());
                utilisateur.setState(utilis.getState());
                utilisateur.setDateNaissance(utilis.getDateNaissance());
                utilisateur.setNumero_Tele(utilis.getNumero_Tele());
                return utilisateurRepo.save(utilisateur);

            });


    }

    @Override
    public UtilisateurDTO GetUtilisateur(String id)  {
       UtilisateurDTO utilisateurDTO= utilistrCmptMapper.FromUsrToUsrDto(utilisateurRepo.findUtilisateurByUserId(id));
        return utilisateurDTO;
    }


    @Override
    public void supprimerUser(Utilisateur utilisateur) {
        utilisateurRepo.delete(utilisateur);
    }

    @Override
    public Utilisateur modifierUser(Long id,Utilisateur utilisateur) {
        return null;
    }

    @Override
    public List<UtilisateurDTO> UTILISATEUR_LIST()  {

        List<Utilisateur> utilisateurList= utilisateurRepo.findAll();
        List<UtilisateurDTO> utilisateurDTOS = new ArrayList<>();
        for(Utilisateur utilisateur: utilisateurList){
            utilisateurDTOS.add(utilistrCmptMapper.FromUsrToUsrDto(utilisateur));
        }
        return utilisateurDTOS;
    }
}

package com.benjdiya.monoapp.mappers;

import com.benjdiya.monoapp.dtos.AuthentificationDTO;
import com.benjdiya.monoapp.dtos.OffresDTO;
import com.benjdiya.monoapp.dtos.UtilisateurDTO;
import com.benjdiya.monoapp.dtos.inscriptionDTO;
import com.benjdiya.monoapp.entities.Compte;
import com.benjdiya.monoapp.entities.Offres;
import com.benjdiya.monoapp.entities.Utilisateur;
import com.benjdiya.monoapp.exception.UserbalancelistException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class UtilistrCmptMapper {

    public Utilisateur FromInscriToUsr(inscriptionDTO inscription){
        Utilisateur utilisateur=new Utilisateur();
        BeanUtils.copyProperties(inscription,utilisateur);

        Compte compte= FromInscriToCmp(inscription);
        utilisateur.setCompte(compte);
        return utilisateur;
    }
    public Compte FromInscriToCmp(inscriptionDTO inscription){
        Compte compte=new Compte();
        BeanUtils.copyProperties(inscription,compte);
        compte.setCreatedAt(LocalDateTime.now());
        return compte;
    }

    public UtilisateurDTO FromUsrToUsrDto(Utilisateur utilisateur)  {
        UtilisateurDTO utilisateurDTO=new UtilisateurDTO();
        BeanUtils.copyProperties(utilisateur, utilisateurDTO);
        if(utilisateur.getDateNaissance()==null){
            return utilisateurDTO;
        }
        utilisateurDTO.setDateNaissance(utilisateur.getDateNaissance().format(DateTimeFormatter.ISO_LOCAL_DATE));
        return utilisateurDTO;
    }
    public Utilisateur FromUsrDtoToUsr(UtilisateurDTO utilisateurDTO)  {
        Utilisateur utilisateur=new Utilisateur();
        BeanUtils.copyProperties(utilisateurDTO, utilisateur);
        LocalDate date = LocalDate.parse(utilisateurDTO.getDateNaissance(), DateTimeFormatter.ISO_LOCAL_DATE);
        utilisateur.setDateNaissance(date);
        return utilisateur;
    }


}

package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.AuthentificationDTO;
import com.benjdiya.monoapp.entities.Compte;
import com.benjdiya.monoapp.exception.DeletingAccountException;
import com.benjdiya.monoapp.exception.GetAccountException;
import com.benjdiya.monoapp.repositories.CompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompteService_Impl implements CompteService {
    @Autowired
    CompteRepo compteRepo;

    @Override
    public Compte GetAccount(Long id) throws GetAccountException {
        return compteRepo.findById(id).orElseThrow(()-> new GetAccountException("on peut pas consulter ce compte"));
    }

    @Override
    public List<Compte> COMPTE_LIST() {
        return compteRepo.findAll();
    }

    @Override
    public Compte AjouterCompte(Compte compte) {
        return compteRepo.save(compte);
    }

    @Override
    public void SupprimerCompte(Long id) throws DeletingAccountException {
        Compte compte = compteRepo.findById(id).orElseThrow(() -> new DeletingAccountException("On ne peut pas supprimer ce compte"));
        compteRepo.delete(compte);
    }

    @Override
    public Compte ModififerCompte(Long id, Compte compte) {
        return null;
    }



}

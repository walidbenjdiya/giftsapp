package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.AuthentificationDTO;
import com.benjdiya.monoapp.entities.Compte;
import com.benjdiya.monoapp.exception.DeletingAccountException;
import com.benjdiya.monoapp.exception.GetAccountException;

import java.util.List;

public interface CompteService {
    Compte GetAccount(Long id) throws GetAccountException;
    List<Compte> COMPTE_LIST();
    Compte AjouterCompte(Compte compte);
    void SupprimerCompte(Long id) throws DeletingAccountException;
    Compte ModififerCompte(Long id,Compte compte);
}

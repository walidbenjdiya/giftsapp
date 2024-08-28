package com.benjdiya.monoapp.web;

import com.benjdiya.monoapp.entities.Compte;
import com.benjdiya.monoapp.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompteRestController {
    @Autowired
    CompteService compteService;
    @GetMapping("/comptes")
    public List<Compte> compteList(){
        return compteService.COMPTE_LIST();
    }
}

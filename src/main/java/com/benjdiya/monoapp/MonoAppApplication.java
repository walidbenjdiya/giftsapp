package com.benjdiya.monoapp;

import com.benjdiya.monoapp.entities.Compte;
import com.benjdiya.monoapp.entities.Utilisateur;
import com.benjdiya.monoapp.enums.CompteStatus;
import com.benjdiya.monoapp.repositories.CompteRepo;
import com.benjdiya.monoapp.repositories.UtilisateurRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootApplication
public class MonoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonoAppApplication.class, args);
    }

//    @Bean
//    CommandLineRunner start(UtilisateurRepo utilisateurRepo, CompteRepo compteRepo){
//        return args -> {
//            Stream.of("anas").forEach(nom->{
//                Utilisateur utilisateur1=new Utilisateur();
//                utilisateur1.setNom(nom);
//                utilisateur1.setUserId("06d5d2e1-8d97-41c3-809e-7014c3ca9ce7");
//                utilisateur1.setUsername("user2");
//                utilisateur1.setVille("casa");
//                utilisateur1.setPrenom("aererf");
//                utilisateur1.setAdresse("azertyu 12");
//                utilisateurRepo.save(utilisateur1);
//                Compte compte = new Compte();
//                compte.setEmail("arrfe@keb.com");
//                compte.setStatus(CompteStatus.VALIDE);
//                compte.setPassword("123");
//                compte.setUtilisateur(utilisateur1);
//                compte.setCreatedAt(LocalDateTime.now());
//                compteRepo.save(compte);
//
//            });
//
//        };
    //}
}

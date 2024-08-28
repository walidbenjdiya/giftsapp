package com.benjdiya.monoapp.repositories;

import com.benjdiya.monoapp.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte,Long> {
    Compte findCompteByEmail(String aa);
}

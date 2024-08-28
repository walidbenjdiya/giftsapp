package com.benjdiya.monoapp.repositories;

import com.benjdiya.monoapp.entities.Offres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffersRepo extends JpaRepository<Offres,Long> {
Offres findByName(String offer);
}

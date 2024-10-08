package com.benjdiya.monoapp.repositories;

import com.benjdiya.monoapp.entities.Offres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffersRepo extends JpaRepository<Offres,Long> {
Offres findByName(String offer);
    List<Offres> findAllByCategoriesId(Long id);
}

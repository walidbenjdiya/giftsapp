package com.benjdiya.monoapp.repositories;

import com.benjdiya.monoapp.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepo extends JpaRepository<History,Long> {
   List<History> findAllByUtilisateur_UserId(String userId);
}

package com.benjdiya.monoapp.repositories;

import com.benjdiya.monoapp.entities.History;
import com.benjdiya.monoapp.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepo extends JpaRepository<Notification,Long> {
    List<Notification> findAllByUtilisateur_UserId(String userId);

}

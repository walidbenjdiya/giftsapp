package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.NotificationDTO;
import com.benjdiya.monoapp.entities.Notification;
import com.benjdiya.monoapp.mappers.NotificationMapper;
import com.benjdiya.monoapp.repositories.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NotificationService_Impl implements NotificationService{
    @Autowired
    NotificationRepo notificationRepo;
    @Autowired
    NotificationMapper notificationMapper;
    @Override
    public void AjouterNotification(Notification notification) {
        notificationRepo.save(notification);
    }

    @Override
    public List<NotificationDTO> notification_LIST(String userId) {
      return notificationRepo.findAllByUtilisateur_UserId(userId).stream()
              .map(notification -> notificationMapper.FromNotif(notification))
              .collect(Collectors.toList());
    }
}

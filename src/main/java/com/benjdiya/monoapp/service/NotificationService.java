package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.NotificationDTO;
import com.benjdiya.monoapp.entities.Notification;

import java.util.List;

public interface NotificationService {
    void AjouterNotification(Notification notification);
    List<NotificationDTO> notification_LIST(String userId);
}

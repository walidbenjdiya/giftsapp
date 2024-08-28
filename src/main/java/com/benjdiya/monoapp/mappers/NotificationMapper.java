package com.benjdiya.monoapp.mappers;

import com.benjdiya.monoapp.dtos.HistoryDTO;
import com.benjdiya.monoapp.dtos.NotificationDTO;
import com.benjdiya.monoapp.entities.History;
import com.benjdiya.monoapp.entities.Notification;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationMapper {
    public NotificationDTO FromNotif(Notification notification){
        NotificationDTO notificationDTO=new NotificationDTO();
        BeanUtils.copyProperties(notification, notificationDTO);
        return notificationDTO;
    }
    public Notification ToNotif(NotificationDTO notificationDTO){
        Notification notification=new Notification();
        BeanUtils.copyProperties(notificationDTO, notification);
        return notification;
    }
}

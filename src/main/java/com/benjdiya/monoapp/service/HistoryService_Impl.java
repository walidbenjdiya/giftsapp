package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.HistoryDTO;
import com.benjdiya.monoapp.entities.History;
import com.benjdiya.monoapp.exception.HistoryNotAddedException;

import com.benjdiya.monoapp.mappers.HistoryMapper;
import com.benjdiya.monoapp.repositories.HistoryRepo;
import com.benjdiya.monoapp.repositories.UtilisateurRepo;
import com.benjdiya.monoapp.web.NotificationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HistoryService_Impl implements HistoryService{
    @Autowired
    HistoryRepo historyRepo;
    @Autowired
    UtilisateurRepo utilisateurRepo;
    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    NotificationController notificationController;
    @Override
    public void AjouterHistory(History history) throws HistoryNotAddedException {
        //History history= historyMapper.ToHistory(historyDTO);
       // history.setUtilisateur(utilisateurRepo.findById(id).get());
        //history.getOffre()
        if (history == null) {
            throw new HistoryNotAddedException("History Not Added");
        }

        historyRepo.save(history);
        notificationController.triggerNotification("Congratulations, you have participated in the giveaways of "+history.getOffre().getName()+", improve your chance width more offer");
    }

    @Override
    public History ModifierHistory(Long id, History history) {
        return null;
    }

    @Override
    public List<HistoryDTO> HISTORY_LIST(String userId) {
        List<History> historyList= historyRepo.findAllByUtilisateur_UserId(userId);
       return historyList.stream().map(history -> historyMapper.FromHistory(history)).collect(Collectors.toList());

    }
}

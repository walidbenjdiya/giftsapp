package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.HistoryDTO;
import com.benjdiya.monoapp.entities.History;
import com.benjdiya.monoapp.exception.HistoryNotAddedException;

import java.util.List;

public interface HistoryService {

    void AjouterHistory(History history) throws HistoryNotAddedException;

    History ModifierHistory(Long id, History history);
    List<HistoryDTO> HISTORY_LIST(String userId);
}

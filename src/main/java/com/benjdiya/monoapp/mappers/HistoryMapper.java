package com.benjdiya.monoapp.mappers;

import com.benjdiya.monoapp.dtos.HistoryDTO;
import com.benjdiya.monoapp.dtos.OffresDTO;
import com.benjdiya.monoapp.entities.History;
import com.benjdiya.monoapp.entities.Offres;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class HistoryMapper {
    public HistoryDTO FromHistory(History history){
        HistoryDTO historyDTO=new HistoryDTO();
        BeanUtils.copyProperties(history, historyDTO);
        historyDTO.setDate(history.getTime().toLocalDate().toString());
        historyDTO.setHeure(history.getTime().toLocalTime().truncatedTo(ChronoUnit.MINUTES).toString());
        historyDTO.setOffer(history.getOffre().getTitle());
        return historyDTO;
    }
    public History ToHistory(HistoryDTO historyDTO){
        History history=new History();
        BeanUtils.copyProperties(historyDTO, history);
        return history;
    }

}

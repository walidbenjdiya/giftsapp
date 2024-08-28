package com.benjdiya.monoapp.mappers;

import com.benjdiya.monoapp.dtos.OffresDTO;
import com.benjdiya.monoapp.entities.Offres;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OfferMappers {
    public OffresDTO FromOffre(Offres offres){
        OffresDTO offresDTO=new OffresDTO();
        BeanUtils.copyProperties(offres, offresDTO);
        offresDTO.setRaffledraw(offres.getRaffleDdraw().toLocalDate().toString());
        return offresDTO;
    }
    public Offres ToOffre(OffresDTO offresdto){
        Offres offres=new Offres();
        BeanUtils.copyProperties(offresdto, offres);
        return offres;
    }
}

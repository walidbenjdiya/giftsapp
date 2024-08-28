package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.OffresDTO;
import com.benjdiya.monoapp.entities.Offres;

import java.util.List;

public interface OffersService {
     void offre(OffresDTO offres);
     List<OffresDTO> OFFRES_DTO_LIST();


}

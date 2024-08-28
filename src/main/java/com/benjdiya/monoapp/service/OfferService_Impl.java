package com.benjdiya.monoapp.service;

import com.benjdiya.monoapp.dtos.OffresDTO;
import com.benjdiya.monoapp.entities.Offres;
import com.benjdiya.monoapp.mappers.OfferMappers;
import com.benjdiya.monoapp.repositories.OffersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OfferService_Impl implements OffersService {


    @Autowired
    private OffersRepo offersRepo;
    @Autowired
    private OfferMappers offerMappers;

    @Override
    public void offre(OffresDTO offre) {
        offersRepo.save(offerMappers.ToOffre(offre));
    }

    @Override
    public List<OffresDTO> OFFRES_DTO_LIST() {
        return offersRepo.findAll().stream().map(offre -> offerMappers.FromOffre(offre) ).collect(Collectors.toList());
    }
}

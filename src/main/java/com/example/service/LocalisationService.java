package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.Localisation;
import com.example.mapper.LocalisationMapper;

@Service
public class LocalisationService {
	@Autowired
    private LocalisationMapper localisationMapper;

    @Transactional
    public List<Localisation> findAll() {
        return localisationMapper.findAll();
    }

    @Transactional
    public Localisation findOne(Long id) {
        return localisationMapper.findOne(id);
    }

    @Transactional
    public void save(Localisation player) {
    	localisationMapper.save(player);
    }

    @Transactional
    public void update(Localisation player) {
    	localisationMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	localisationMapper.delete(id);
    }
}

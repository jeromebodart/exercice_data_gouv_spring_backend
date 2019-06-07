package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.AdresseGeographique;
import com.example.mapper.AdresseGeographiqueMapper;

@Service
public class AdresseGeographiqueService {
	 @Autowired
    private AdresseGeographiqueMapper adresseGeographiqueMapper;

    @Transactional
    public List<AdresseGeographique> findAll() {
        return adresseGeographiqueMapper.findAll();
    }

    @Transactional
    public AdresseGeographique findOne(Long id) {
        return adresseGeographiqueMapper.findOne(id);
    }

    @Transactional
    public void save(AdresseGeographique player) {
    	adresseGeographiqueMapper.save(player);
    }

    @Transactional
    public void update(AdresseGeographique player) {
    	adresseGeographiqueMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	adresseGeographiqueMapper.delete(id);
    }
}

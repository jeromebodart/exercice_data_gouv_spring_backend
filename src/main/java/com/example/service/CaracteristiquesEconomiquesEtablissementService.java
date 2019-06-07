package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.CaracteristiquesEconomiquesEtablissement;
import com.example.mapper.CaracteristiquesEconomiquesEtablissementMapper;

@Service
public class CaracteristiquesEconomiquesEtablissementService {
	@Autowired
    private CaracteristiquesEconomiquesEtablissementMapper caracteristiquesEconomiquesEtablissementMapper;

    @Transactional
    public List<CaracteristiquesEconomiquesEtablissement> findAll() {
        return caracteristiquesEconomiquesEtablissementMapper.findAll();
    }

    @Transactional
    public CaracteristiquesEconomiquesEtablissement findOne(Long id) {
        return caracteristiquesEconomiquesEtablissementMapper.findOne(id);
    }

    @Transactional
    public void save(CaracteristiquesEconomiquesEtablissement player) {
    	caracteristiquesEconomiquesEtablissementMapper.save(player);
    }

    @Transactional
    public void update(CaracteristiquesEconomiquesEtablissement player) {
    	caracteristiquesEconomiquesEtablissementMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	caracteristiquesEconomiquesEtablissementMapper.delete(id);
    }
}

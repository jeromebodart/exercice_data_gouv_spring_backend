package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.entreprise.CaracteristiquesEconomiquesEntreprise;
import com.example.mapper.CaracteristiquesEconomiquesEntrepriseMapper;

@Service
public class CaracteristiquesEconomiquesEntrepriseService {
    @Autowired
    private CaracteristiquesEconomiquesEntrepriseMapper caracteristiquesEconomiquesEntrepriseMapper;

    @Transactional
    public List<CaracteristiquesEconomiquesEntreprise> findAll() {
        return caracteristiquesEconomiquesEntrepriseMapper.findAll();
    }

    @Transactional
    public CaracteristiquesEconomiquesEntreprise findOne(Long id) {
        return caracteristiquesEconomiquesEntrepriseMapper.findOne(id);
    }

    @Transactional
    public void save(CaracteristiquesEconomiquesEntreprise player) {
    	caracteristiquesEconomiquesEntrepriseMapper.save(player);
    }

    @Transactional
    public void update(CaracteristiquesEconomiquesEntreprise player) {
    	caracteristiquesEconomiquesEntrepriseMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	caracteristiquesEconomiquesEntrepriseMapper.delete(id);
    }
}

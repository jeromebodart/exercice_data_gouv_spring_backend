package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.entreprise.IdentificationEntreprise;
import com.example.mapper.IdentificationEntrepriseMapper;

@Service
public class IdentificationEntrepriseService {
    @Autowired
    private IdentificationEntrepriseMapper identificationEntrepriseMapper;

    @Transactional
    public List<IdentificationEntreprise> findAll() {
        return identificationEntrepriseMapper.findAll();
    }

    @Transactional
    public IdentificationEntreprise findOne(Long id) {
        return identificationEntrepriseMapper.findOne(id);
    }

    @Transactional
    public void save(IdentificationEntreprise player) {
    	identificationEntrepriseMapper.save(player);
    }

    @Transactional
    public void update(IdentificationEntreprise player) {
    	identificationEntrepriseMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	identificationEntrepriseMapper.delete(id);
    }
}

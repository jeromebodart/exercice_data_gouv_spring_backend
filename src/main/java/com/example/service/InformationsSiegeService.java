package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.entreprise.InformationsSiege;
import com.example.mapper.InformationsSiegeMapper;

@Service
public class InformationsSiegeService {
    @Autowired
    private InformationsSiegeMapper informationsSiegeServiceMapper;

    @Transactional
    public List<InformationsSiege> findAll() {
        return informationsSiegeServiceMapper.findAll();
    }

    @Transactional
    public InformationsSiege findOne(Long id) {
        return informationsSiegeServiceMapper.findOne(id);
    }

    @Transactional
    public void save(InformationsSiege player) {
    	informationsSiegeServiceMapper.save(player);
    }

    @Transactional
    public void update(InformationsSiege player) {
    	informationsSiegeServiceMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	informationsSiegeServiceMapper.delete(id);
    }
}

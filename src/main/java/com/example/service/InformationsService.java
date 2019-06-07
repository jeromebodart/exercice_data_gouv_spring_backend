package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.Informations;
import com.example.mapper.InformationsMapper;

@Service
public class InformationsService {
	@Autowired
    private InformationsMapper informationsMapper;

    @Transactional
    public List<Informations> findAll() {
        return informationsMapper.findAll();
    }

    @Transactional
    public Informations findOne(Long id) {
        return informationsMapper.findOne(id);
    }

    @Transactional
    public void save(Informations player) {
    	informationsMapper.save(player);
    }

    @Transactional
    public void update(Informations player) {
    	informationsMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	informationsMapper.delete(id);
    }
}

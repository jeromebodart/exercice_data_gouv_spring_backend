package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.MiseAJour;
import com.example.mapper.MiseAJourMapper;

@Service
public class MiseAJourService {
	@Autowired
    private MiseAJourMapper miseAJourMapper;

    @Transactional
    public List<MiseAJour> findAll() {
        return miseAJourMapper.findAll();
    }

    @Transactional
    public MiseAJour findOne(Long id) {
        return miseAJourMapper.findOne(id);
    }

    @Transactional
    public void save(MiseAJour player) {
    	miseAJourMapper.save(player);
    }

    @Transactional
    public void update(MiseAJour player) {
    	miseAJourMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	miseAJourMapper.delete(id);
    }
}

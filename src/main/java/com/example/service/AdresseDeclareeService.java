package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.AdresseDeclaree;
import com.example.mapper.AdresseDeclareeMapper;

@Service
public class AdresseDeclareeService {
	 @Autowired
	    private AdresseDeclareeMapper adresseDeclareeMapper;

	    @Transactional
	    public List<AdresseDeclaree> findAll() {
	        return adresseDeclareeMapper.findAll();
	    }

	    @Transactional
	    public AdresseDeclaree findOne(Long id) {
	        return adresseDeclareeMapper.findOne(id);
	    }

	    @Transactional
	    public void save(AdresseDeclaree player) {
	    	adresseDeclareeMapper.save(player);
	    }

	    @Transactional
	    public void update(AdresseDeclaree player) {
	    	adresseDeclareeMapper.update(player);
	    }

	    @Transactional
	    public void delete(Long id) {
	    	adresseDeclareeMapper.delete(id);
	    }
}

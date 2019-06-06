package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.Etablissement;
import com.example.mapper.EtablissementMapper;

@Service
public class EtablissementService {
	 @Autowired
	    private EtablissementMapper etablissementMapper;

	    @Transactional
	    public List<Etablissement> findAll() {
	        return etablissementMapper.findAll();
	    }

	    @Transactional
	    public Etablissement findOne(Long id) {
	        return etablissementMapper.findOne(id);
	    }

	    @Transactional
	    public void save(Etablissement player) {
	    	etablissementMapper.save(player);
	    }

	    @Transactional
	    public void update(Etablissement player) {
	    	etablissementMapper.update(player);
	    }

	    @Transactional
	    public void delete(Long id) {
	    	etablissementMapper.delete(id);
	    }
}

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
	
    /** Instance unique pré-initialisée */
    private static MiseAJour miseAJour;
     
    /** Point d'accès pour l'instance unique du singleton */
    public static MiseAJour getInstance()
    {   return miseAJour;
    }

    @Transactional
    public List<MiseAJour> findAll() {
        return miseAJourMapper.findAll();
    }

    @Transactional
    public MiseAJour findOne(Long id) {
        return miseAJourMapper.findOne(id);
    }

    @Transactional
    public void update(MiseAJour miseAjour) {
    	miseAJourMapper.update(miseAjour);
    }

    @Transactional
    public void delete(Long id) {
    	miseAJourMapper.delete(id);
    }

	public void save(MiseAJour miseAjour) {
		// TODO Auto-generated method stub
		
	}
}

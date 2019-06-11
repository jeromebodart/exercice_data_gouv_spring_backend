package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.Etablissement;
import com.example.domain.etablissement.MiseAJour;
import com.example.mapper.MiseAJourMapper;

@Service
public class MiseAJourService {

     
    /** Point d'accès pour l'instance unique du singleton */
    public static MiseAJour getInstance()
    {   
    	return new MiseAJour();
    }
    
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
    public void update(MiseAJour miseAJour) {
    	miseAJourMapper.update(miseAJour);
    }

    @Transactional
    public void delete(Long id) {
    	miseAJourMapper.delete(id);
    }
    
    @Transactional
	public void save(MiseAJour miseAJour) {
		 miseAJourMapper.save(miseAJour);
	}
    
    @Transactional
	public void findLastModified(Long id) {
		// TODO Auto-generated method stub
		
	}
    @Transactional
	public Long getMaxId() {
		// TODO Auto-generated method stub
		return miseAJourMapper.getMaxId();
	}
}

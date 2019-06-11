package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.EtablissementJoinUpdates;
import com.example.domain.etablissement.MiseAJour;
import com.example.mapper.EtablissementJoinUpdatesMapper;

@Service
public class EtablissementJoinUpdatesService {
	@Autowired
    private EtablissementJoinUpdatesMapper etablissementJoinUpdatesMapper;
	 
    
    /** Point d'accès pour l'instance unique du singleton */
    public static EtablissementJoinUpdates getInstance()
    {   
    	return new EtablissementJoinUpdates();
    }

    @Transactional
    public List<EtablissementJoinUpdates> findAll() {
        return etablissementJoinUpdatesMapper.findAll();
    }

    @Transactional
    public EtablissementJoinUpdates findOne(Long id) {
        return etablissementJoinUpdatesMapper.findOne(id);
    }

    @Transactional
    public void save(EtablissementJoinUpdates player) {
    	etablissementJoinUpdatesMapper.save(player);
    }

    @Transactional
    public void update(EtablissementJoinUpdates player) {
    	etablissementJoinUpdatesMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	etablissementJoinUpdatesMapper.delete(id);
    }
}

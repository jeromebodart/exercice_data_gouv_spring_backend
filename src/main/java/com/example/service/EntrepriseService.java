package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.entreprise.Entreprise;
import com.example.mapper.EntrepriseMapper;

@Service
public class EntrepriseService {
    @Autowired
    private EntrepriseMapper entrepriseMapper;
    @Autowired
	private InformationsSiegeService informationsSiegeService;
    @Autowired
	private IdentificationEntrepriseService identificationEntrepriseService;
    @Autowired
	private CaracteristiquesEconomiquesEntrepriseService caracteristiquesEconomiquesEntrepriseService;
//    @Autowired
//	private MiseAJourService miseAJourService;
//    @Autowired
// 	private EtablissementJoinUpdatesService etablissementJoinUpdatesService;
    @Transactional
    public List<Entreprise> findAll() {
        return entrepriseMapper.findAll();
    }
    
    @Transactional
    public Long generateSiren() {
        return entrepriseMapper.getMaxSiren();
    }
    
    @Transactional
    public Entreprise findOne(Long id) {
        return entrepriseMapper.findOne(id);
    }


    @Transactional
    public void update(Entreprise entreprise) {
    	informationsSiegeService.update(entreprise.getSiege());
    	identificationEntrepriseService.update(entreprise.getIdentification_entreprise());
    	caracteristiquesEconomiquesEntrepriseService.update(entreprise.getCaracteristiques_economiques());
    	entrepriseMapper.update(entreprise.getId(), String.format("%09d", entreprise.getSiren()), entreprise.getSiege().getId(), entreprise.getIdentification_entreprise().getId(), entreprise.getCaracteristiques_economiques().getId());
    }

    @Transactional
    public void delete(Long id) {
    	entrepriseMapper.delete(id);
    }
    
    @Transactional
	public void save(Entreprise entreprise) {
		// TODO Auto-generated method stub
    	if(entreprise.getSiege().getId() == null ) {
			informationsSiegeService.save(entreprise.getSiege());
		} 
		if (entreprise.getIdentification_entreprise().getId() == null) {
			identificationEntrepriseService.save(entreprise.getIdentification_entreprise());
		} 
		if (entreprise.getCaracteristiques_economiques().getId() == null) {
			caracteristiquesEconomiquesEntrepriseService.save(entreprise.getCaracteristiques_economiques());
		}
		Long siren = generateSiren() + 1;
		entreprise.setSiren(siren);
		entrepriseMapper.save(String.format("%09d", entreprise.getSiren()), entreprise.getSiege().getId(), entreprise.getIdentification_entreprise().getId(), entreprise.getCaracteristiques_economiques().getId());
	}
}

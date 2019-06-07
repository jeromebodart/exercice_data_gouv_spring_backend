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

	private InformationsSiegeService informationsSiegeService;
	private IdentificationEntrepriseService identificationEntrepriseService;
	private CaracteristiquesEconomiquesEntrepriseService caracteristiquesEconomiquesEntrepriseService;

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

//    @Transactional
//    public void save(Entreprise player) {
//    	entrepriseMapper.save(player);
//    }

    @Transactional
    public void update(Entreprise entreprise) {
    	informationsSiegeService.update(entreprise.getSiege());
    	identificationEntrepriseService.update(entreprise.getIdentification_entreprise());
    	caracteristiquesEconomiquesEntrepriseService.update(entreprise.getCaracteristiques_economiques());
    	entrepriseMapper.update(entreprise.getSiren(), entreprise.getSiege().getId(), entreprise.getIdentification_entreprise().getId(), entreprise.getCaracteristiques_economiques().getId());
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
		Long siren = generateSiren();
		entreprise.setSiren(siren++);
		entrepriseMapper.save(siren, entreprise.getSiege().getId(), entreprise.getIdentification_entreprise().getId(), entreprise.getCaracteristiques_economiques().getId());
	}
}

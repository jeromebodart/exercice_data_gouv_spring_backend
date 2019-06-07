package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.entreprise.CaracteristiquesEconomiquesEntreprise;
import com.example.domain.entreprise.Entreprise;
import com.example.domain.entreprise.IdentificationEntreprise;
import com.example.domain.entreprise.InformationsSiege;
import com.example.service.CaracteristiquesEconomiquesEntrepriseService;
import com.example.service.EntrepriseService;
import com.example.service.IdentificationEntrepriseService;
import com.example.service.InformationsSiegeService;

@RestController
@RequestMapping("/entreprises")
public class EntreprisesController {
    @Autowired
    private EntrepriseService entrepriseService;
    @Autowired
    private InformationsSiegeService informationsSiegeService;
    @Autowired
    private IdentificationEntrepriseService identificationEntrepriseService;
    @Autowired
    private CaracteristiquesEconomiquesEntrepriseService caracteristiquesEconomiquesEntrepriseService;
    
    @GetMapping
    public List<Entreprise> index() {
    	return entrepriseService.findAll();
    }
    
    @GetMapping("{id}")
    public ResponseEntity show(@PathVariable Long id) {
    	Entreprise entreprise =  entrepriseService.findOne(id);
		if (entreprise == null) {
			return new ResponseEntity("No Enterprise found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(entreprise, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@ModelAttribute Entreprise entreprise) {
    		informationsSiegeService.save(entreprise.getSiege());
    		identificationEntrepriseService.save(entreprise.getIdentification_entreprise());
        	caracteristiquesEconomiquesEntrepriseService.save(entreprise.getCaracteristiques_economiques());
        	
        	Long siren = entrepriseService.generateSiren();
        	entreprise.setSiren(siren);
        	entrepriseService.save(entreprise);
//        	entrepriseService.save(siren, entreprise.getSiege().getId(), entreprise.getIdentification_entreprise().getId(), entreprise.getCaracteristiques_economiques().getId());
        	return  new ResponseEntity(entreprise, HttpStatus.OK);
    	

    }
    
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @PathVariable Long id_siege, @PathVariable Long id_identification_entreprise, @PathVariable Long id_caracteristiques, @PathVariable Long siren) {
    	Entreprise entreprise =  entrepriseService.findOne(id);
//		if (entreprise == null) {
//			return new ResponseEntity("No Enterprise found for ID " + id, HttpStatus.NOT_FOUND);
//		}
    	InformationsSiege informationsSiege = informationsSiegeService.findOne(id_siege);
    	IdentificationEntreprise identificationEntreprise = identificationEntrepriseService.findOne(id_identification_entreprise);
    	CaracteristiquesEconomiquesEntreprise caracteristiquesEconomiquesEntreprise = caracteristiquesEconomiquesEntrepriseService.findOne(id_caracteristiques);
    	entreprise.setId(id);
    	entreprise.setSiege(informationsSiege);
    	entreprise.setIdentification_entreprise(identificationEntreprise);
    	entreprise.setCaracteristiques_economiques(caracteristiquesEconomiquesEntreprise);
    	entreprise.setSiren(siren);
    	entrepriseService.update(entreprise);
        return  new ResponseEntity(entreprise, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity destroy(@PathVariable Long id) {
    	entrepriseService.delete(id);
		if (entrepriseService.findOne(id) == null) {
			return new ResponseEntity("No Enterprise found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(id, HttpStatus.OK);
	}
}

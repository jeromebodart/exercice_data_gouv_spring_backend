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
import com.example.domain.etablissement.Etablissement;
import com.example.service.AdresseDeclareeService;
import com.example.service.AdresseGeographiqueService;
import com.example.service.AdresseNormaliseeService;
import com.example.service.CaracteristiquesEconomiquesEntrepriseService;
import com.example.service.CaracteristiquesEconomiquesEtablissementService;
import com.example.service.EtablissementJoinUpdatesService;
import com.example.service.EtablissementService;
import com.example.service.InformationsService;
import com.example.service.LocalisationService;
import com.example.service.MiseAJourService;

@RestController
@RequestMapping("/etablissements")
public class EtablissementsController {
	 @Autowired
	    private EtablissementService etablissementService;
	 	private AdresseDeclareeService adresseDeclareeService;
	 	private AdresseNormaliseeService adresseNormaliseeService;
	 	private AdresseGeographiqueService adresseGeographiqueService;
	 	private CaracteristiquesEconomiquesEtablissementService caracteristiquesEconomiquesEtablissementService;
	 	private InformationsService informationsService;
	 	private LocalisationService localisationService;
	 	private MiseAJourService miseAJourService;
	 	private EtablissementJoinUpdatesService etablissementJoinUpdatesService;
	    @GetMapping
	    public List<Etablissement> index() {
	    	return etablissementService.findAll();
	    }
	    
	    @GetMapping("{id}")
	    public ResponseEntity show(@PathVariable Long id) {
	    	Etablissement etablissement =  etablissementService.findOne(id);
			if (etablissement == null) {
				return new ResponseEntity("No Enterprise found for ID " + id, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity(etablissement, HttpStatus.OK);
	    }
	    @PostMapping
	    public ResponseEntity create(@ModelAttribute Etablissement entreprise) {

	        	
	        	Long siren = entrepriseService.generateSiren();
	        	entreprise.setSiren(siren);
	        	etablissementService.save(entreprise);
//	        	entrepriseService.save(siren, entreprise.getSiege().getId(), entreprise.getIdentification_entreprise().getId(), entreprise.getCaracteristiques_economiques().getId());
	        	return  new ResponseEntity(entreprise, HttpStatus.OK);
	    	

	    }
	    
	    @PutMapping("{id}")
	    public ResponseEntity update(@PathVariable Long id, @PathVariable Long id_siege, @PathVariable Long id_identification_entreprise, @PathVariable Long id_caracteristiques, @PathVariable Long siren) {
	    	Entreprise entreprise =  entrepriseService.findOne(id);
//			if (entreprise == null) {
//				return new ResponseEntity("No Enterprise found for ID " + id, HttpStatus.NOT_FOUND);
//			}
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

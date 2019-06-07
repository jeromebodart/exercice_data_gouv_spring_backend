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

	 	private AdresseDeclareeService adresseDeclareeService;
	 	private AdresseNormaliseeService adresseNormaliseeService;
	 	private AdresseGeographiqueService adresseGeographiqueService;
	 	private CaracteristiquesEconomiquesEtablissementService caracteristiquesEconomiquesEtablissementService;
	 	private InformationsService informationsService;
	 	private LocalisationService localisationService;
	 	private MiseAJourService miseAJourService;
	 	private EtablissementJoinUpdatesService etablissementJoinUpdatesService;
	 	private EntrepriseService entrepriseService;

	    @Transactional
	    public List<Etablissement> findAll() {
	        return etablissementMapper.findAll();
	    }

	    @Transactional
	    public Etablissement findOne(Long id) {
	        return etablissementMapper.findOne(id);
	    }

	    @Transactional
	    public void save(Etablissement etablissement) {
	    	if(etablissement.getEntreprise().getId() == null ) {
	    		entrepriseService.save(etablissement.getEntreprise());
			}
	    	if(etablissement.getAdresse_declaree().getId() == null ) {
	    		adresseDeclareeService.save(etablissement.getAdresse_declaree());
			}
	    	if(etablissement.getAdresse_normalisee().getId() == null ) {
	    		adresseNormaliseeService.save(etablissement.getAdresse_normalisee());
			}
	    	if(etablissement.getInfo().getId() == null ) {
	    		informationsService.save(etablissement.getInfo());
			}
	    	if(etablissement.getAdressegeographique().getId() == null ) {
	    		adresseGeographiqueService.save(etablissement.getAdressegeographique());
			}
	    	if(etablissement.getLocalisation().getId() == null ) {
	    		localisationService.save(etablissement.getLocalisation());
			}
	    	if(etablissement.getEconomies().getId() == null ) {
	    		caracteristiquesEconomiquesEtablissementService.save(etablissement.getEconomies());
			}
			Long nic = generateNic();
			etablissement.setNic(nic++);
			etablissementMapper.save(etablissement.getNic(),
									 etablissement.getEntreprise().getId(),
									 etablissement.getAdresse_declaree().getId(),
									 etablissement.getAdresse_normalisee().getId(),
									 etablissement.getInfo().getId(),
									 etablissement.getAdressegeographique().getId(),
									 etablissement.getLocalisation().getId(),
									 etablissement.getEconomies().getId());
	    }

	    private Long generateNic() {
			// TODO Auto-generated method stub
			return etablissementMapper.getMaxNic();
		}

		@Transactional
	    public void update(Etablissement etablissement) {
			etablissementMapper.update(etablissement.getNic(),
					 etablissement.getEntreprise().getId(),
					 etablissement.getAdresse_declaree().getId(),
					 etablissement.getAdresse_normalisee().getId(),
					 etablissement.getInfo().getId(),
					 etablissement.getAdressegeographique().getId(),
					 etablissement.getLocalisation().getId(),
					 etablissement.getEconomies().getId());
	    }

	    @Transactional
	    public void delete(Long id) {
	    	etablissementMapper.delete(id);
	    }
}

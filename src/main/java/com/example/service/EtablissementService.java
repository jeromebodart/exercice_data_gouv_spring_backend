package com.example.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.Etablissement;
import com.example.domain.etablissement.NatureUpdate;
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
	 	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

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
//	    	 Il faut ajouter la mise à jour VMAJ = 'C'
			Calendar calendar = Calendar.getInstance();
			miseAJourService.getInstance().setModification_activite_etablissement(NatureUpdate.C);
			miseAJourService.getInstance().setDate(formatter.format(calendar.getTime()));
			miseAJourService.getInstance().setModification_nature_etablissement(false);
			miseAJourService.getInstance().setModification_entreprise(false);
			miseAJourService.save(miseAJourService.getInstance());
//			etablissementJoinUpdatesService.save(player);
	    }

	    private Long generateNic() {
			// TODO Auto-generated method stub
			return etablissementMapper.getMaxNic();
		}

		@Transactional
	    public void update(Etablissement etablissement) {
//	    	 Il faut ajouter la mise à jour VMAJ = 'I' et 'F'
//			Une deuxième VMAJ pour l'entrée ou non de l'établissmeent du champ de diffusion (jechoisis 'D' entrée par défaut)
			entrepriseService.update(etablissement.getEntreprise());
			adresseDeclareeService.update(etablissement.getAdresse_declaree());
			adresseNormaliseeService.update(etablissement.getAdresse_normalisee());
			informationsService.update(etablissement.getInfo());
			adresseGeographiqueService.update(etablissement.getAdressegeographique());
			localisationService.update(etablissement.getLocalisation());
			caracteristiquesEconomiquesEtablissementService.update(etablissement.getEconomies());
			etablissementMapper.update(etablissement.getNic(),
					 etablissement.getEntreprise().getId(),
					 etablissement.getAdresse_declaree().getId(),
					 etablissement.getAdresse_normalisee().getId(),
					 etablissement.getInfo().getId(),
					 etablissement.getAdressegeographique().getId(),
					 etablissement.getLocalisation().getId(),
					 etablissement.getEconomies().getId());
			Calendar calendar = Calendar.getInstance();
//			Il faut changer cette état à I pour les anciennes mise à jour
//			On veut trouver la mise à jour lier à l'établissement avec F sur la colonne setModification_activite_etablissement
			etablissementJoinUpdatesService.findMany(etablissement.getId());
			miseAJourService.findOne();
			miseAJourService.getInstance().setModification_activite_etablissement(NatureUpdate.F);
			miseAJourService.getInstance().setDate(formatter.format(calendar.getTime()));
			miseAJourService.getInstance().setModification_nature_etablissement(true);
			miseAJourService.getInstance().setModification_entreprise(false);
			miseAJourService.save(miseAJourService.getInstance());
	    }

	    @Transactional
	    public void delete(Long id) {
//	    	On ne supprime pas l'établissement mais on lui associe une VMAJ à E dans la table MiseAJour
//	    	etablissementJoinUpdatesService.
//	    	miseAJourService.
	    	etablissementMapper.delete(id);
	    }
}

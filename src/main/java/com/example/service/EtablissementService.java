package com.example.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.Etablissement;
import com.example.domain.etablissement.EtablissementJoinUpdates;
import com.example.domain.etablissement.MiseAJour;
import com.example.domain.etablissement.NatureUpdate;
import com.example.mapper.EtablissementMapper;
import com.example.mapper.MiseAJourMapper;

@Service
public class EtablissementService {
	@Autowired
	private EtablissementMapper etablissementMapper;
	@Autowired
	private AdresseDeclareeService adresseDeclareeService;
	@Autowired
	private AdresseNormaliseeService adresseNormaliseeService;
	@Autowired
	private AdresseGeographiqueService adresseGeographiqueService;
	@Autowired
	private CaracteristiquesEconomiquesEtablissementService caracteristiquesEconomiquesEtablissementService;
	@Autowired
	private InformationsService informationsService;
	@Autowired
	private LocalisationService localisationService;
	@Autowired
	private MiseAJourService miseAJourService;
	@Autowired
	private EtablissementJoinUpdatesService etablissementJoinUpdatesService;
	@Autowired
	private EntrepriseService entrepriseService;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

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
		etablissement.setNic(nic++);etablissementMapper.save(String.format("%05d", etablissement.getNic()),
				etablissement.getEntreprise().getId(),
				etablissement.getAdresse_declaree().getId(),
				etablissement.getAdresse_normalisee().getId(),
				etablissement.getInfo().getId(),
				etablissement.getAdressegeographique().getId(),
				etablissement.getLocalisation().getId(),
				etablissement.getEconomies().getId());
		//			We have id_etablissement we can add to EtablissementJoinUpdates
		EtablissementJoinUpdates eJS = EtablissementJoinUpdatesService.getInstance();
		eJS.setId_etablissement(getMaxIdEtablissement());
		//	    	 Il faut ajouter la mise à jour VMAJ = 'C'
		Calendar calendar = Calendar.getInstance();
//		MiseAJourService.getInstance().setNature_update(NatureUpdate.C);
//		MiseAJourService.getInstance().setDate(formatter.format(calendar.getTime()));
//		MiseAJourService.getInstance().setModification_activite_etablissement(false);
//		MiseAJourService.getInstance().setModification_nature_etablissement(false);
//		MiseAJourService.getInstance().setModification_entreprise(false);
		MiseAJour mAJ = MiseAJourService.getInstance();
		mAJ.setNature_update(NatureUpdate.C);
		mAJ.setDate(formatter.format(calendar.getTime()));
		mAJ.setModification_activite_etablissement(0);
		mAJ.setModification_nature_etablissement(0);
		mAJ.setModification_entreprise(0);
		miseAJourService.save(mAJ);
		//			We have id_MiseAJour we can add to EtablissementJoinUpdates
		eJS.setId_updates(miseAJourService.getMaxId());
		etablissementJoinUpdatesService.save(eJS);
	}
	
	private Long generateNic() {
		// TODO Auto-generated method stub
		return etablissementMapper.getMaxNic();
	}
	
	
	private Long getMaxIdEtablissement() {
		// TODO Auto-generated method stub
		return etablissementMapper.getMaxId();
	}


	@Transactional
	public void update(Etablissement etablissement) {
		//	    	 Il faut ajouter la mise à jour VMAJ = 'I' et 'F'
		//			Une deuxième VMAJ pour l'entrée ou non de l'établissmeent du champ de diffusion (je choisis 'D' entrée par défaut)
		entrepriseService.update(etablissement.getEntreprise());
		adresseDeclareeService.update(etablissement.getAdresse_declaree());
		adresseNormaliseeService.update(etablissement.getAdresse_normalisee());
		informationsService.update(etablissement.getInfo());
		adresseGeographiqueService.update(etablissement.getAdressegeographique());
		localisationService.update(etablissement.getLocalisation());
		caracteristiquesEconomiquesEtablissementService.update(etablissement.getEconomies());
		etablissementMapper.update(String.format("%05d", etablissement.getNic()),
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
		//			etablissementJoinUpdatesService.findMany();
		
	}

	@Transactional
	public void delete(Long id) {
		//	    	On ne supprime pas l'établissement mais on lui associe une VMAJ à E dans la table MiseAJour
		//	    	etablissementJoinUpdatesService.
		//	    	miseAJourService.
		etablissementMapper.delete(id);
	}
}

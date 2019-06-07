package com.example.domain.etablissement;

import java.util.List;

import com.example.domain.entreprise.Entreprise;


public class Etablissement {
	private Long id;
	private Long nic;
	private Integer id_entreprise;
	private Entreprise entreprise;
	private AdresseDeclaree adresse_declaree;
	private AdresseNormalisee adresse_normalisee;
	private Informations info;
	private AdresseGeographique adressegeographique;
	private Localisation localisation;
	private CaracteristiquesEconomiquesEtablissement economies;
	private List<MiseAJour> mises_a_jour;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNic() {
		return nic;
	}
		
	public Integer getId_entreprise() {
		return id_entreprise;
	}
	public void setId_entreprise(Integer id_entreprise) {
		this.id_entreprise = id_entreprise;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setNic(Long nic) {
		this.nic = nic;
	}
	public AdresseNormalisee getAdresse_normalisee() {
		return adresse_normalisee;
	}
	public void setAdresse_normalisee(AdresseNormalisee adresse_normalisee) {
		this.adresse_normalisee = adresse_normalisee;
	}
	public Informations getInfo() {
		return info;
	}
	public void setInfo(Informations info) {
		this.info = info;
	}
	public AdresseGeographique getAdressegeographique() {
		return adressegeographique;
	}
	public void setAdressegeographique(AdresseGeographique adressegeographique) {
		this.adressegeographique = adressegeographique;
	}
	public Localisation getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}
	public CaracteristiquesEconomiquesEtablissement getEconomies() {
		return economies;
	}
	public void setEconomies(CaracteristiquesEconomiquesEtablissement economies) {
		this.economies = economies;
	}
	public AdresseDeclaree getAdresse_declaree() {
		return adresse_declaree;
	}
	public void setAdresse_declaree(AdresseDeclaree adresse_declaree) {
		this.adresse_declaree = adresse_declaree;
	}
	public List<MiseAJour> getMises_a_jour() {
		return mises_a_jour;
	}
	public void setMises_a_jour(List<MiseAJour> mises_a_jour) {
		this.mises_a_jour = mises_a_jour;
	}
}

package com.example.domain.etablissement;


public class Etablissement {
	private Long id;
	private int nic;
	private AdresseDeclaree adressedeclaree;
	private AdresseNormalisee adresse_normalisee;
	private Informations info;
	private AdresseGeographique adressegeographique;
	private Localisation localisation;
	private CaracteristiquesEconomiquesEtablissement economies;
	private MiseAJour mises_a_jour;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNic() {
		return nic;
	}
	public void setNic(int nic) {
		this.nic = nic;
	}
	public AdresseDeclaree getAdressedeclaree() {
		return adressedeclaree;
	}
	public void setAdressedeclaree(AdresseDeclaree adressedeclaree) {
		this.adressedeclaree = adressedeclaree;
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
	public MiseAJour getMises_a_jour() {
		return mises_a_jour;
	}
	public void setMises_a_jour(MiseAJour mises_a_jour) {
		this.mises_a_jour = mises_a_jour;
	}
}

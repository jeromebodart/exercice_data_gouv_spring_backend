package com.example.domain.etablissement;

public class Informations {
	private Long id;
	private String enseigne;
	private int ind_publipo;
	private int siege;
	private char statut_diffusion;
	private String date_diffusion_base;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnseigne() {
		return enseigne;
	}
	public void setEnseigne(String enseigne) {
		this.enseigne = enseigne;
	}
	public int getInd_publipo() {
		return ind_publipo;
	}
	public void setInd_publipo(int ind_publipo) {
		this.ind_publipo = ind_publipo;
	}
	public int getSiege() {
		return siege;
	}
	public void setSiege(int siege) {
		this.siege = siege;
	}
	public char getStatut_diffusion() {
		return statut_diffusion;
	}
	public void setStatut_diffusion(char statut_diffusion) {
		this.statut_diffusion = statut_diffusion;
	}
	public String getDate_diffusion_base() {
		return date_diffusion_base;
	}
	public void setDate_diffusion_base(String date_diffusion_base) {
		this.date_diffusion_base = date_diffusion_base;
	}
	
	
	
}

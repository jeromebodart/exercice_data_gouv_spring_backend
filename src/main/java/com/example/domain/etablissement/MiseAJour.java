package com.example.domain.etablissement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
public class MiseAJour {
	private Long id;
	private String date;
	private NatureUpdate nature_update;
	private int modification_activite_etablissement;
	private int modification_nature_etablissement;
	private int modification_entreprise;
 	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
 	
	public MiseAJour() {
		super();
		nature_update = NatureUpdate.F;
		Calendar calendar = Calendar.getInstance();
		date = formatter.format(calendar.getTime());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public NatureUpdate getNature_update() {
		return nature_update;
	}

	public void setNature_update(NatureUpdate nature_update) {
		this.nature_update = nature_update;
	}

	public int getModification_activite_etablissement() {
		return modification_activite_etablissement;
	}

	public void setModification_activite_etablissement(int modification_activite_etablissement) {
		this.modification_activite_etablissement = modification_activite_etablissement;
	}

	public int getModification_nature_etablissement() {
		return modification_nature_etablissement;
	}

	public void setModification_nature_etablissement(int modification_nature_etablissement) {
		this.modification_nature_etablissement = modification_nature_etablissement;
	}

	public int getModification_entreprise() {
		return modification_entreprise;
	}

	public void setModification_entreprise(int modification_entreprise) {
		this.modification_entreprise = modification_entreprise;
	}

	public SimpleDateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}

	
}

package com.example.domain.etablissement;

public enum NatureUpdate {
	  //Objets directement construits
	  C ("Création d'établissement"),
	  E ("Suppression d'établissement"),
	  I ("Modification état initial"),
	  F ("Modification état final"),
	  D ("Entrée dans la diffusion"),
	  O ("Sortie de la diffusion");
	   
	  private String name = "";
	   
	  //Constructeur
	  NatureUpdate(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
}

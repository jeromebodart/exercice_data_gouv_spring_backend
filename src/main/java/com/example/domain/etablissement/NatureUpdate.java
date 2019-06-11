package com.example.domain.etablissement;

public enum NatureUpdate {
	  //Objets directement construits
	  C ("C"),
	  E ("E"),
	  I ("I"),
	  F ("F"),
	  D ("D"),
	  O ("O");
	   
	  private String name = "";
	   
	  //Constructeur
	  NatureUpdate(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
}

package com.example.domain.etablissement;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(autowire=Autowire.BY_NAME,dependencyCheck=true)
public class AdresseDeclaree {
	private Long id;

	private String l1_declaree;
	private String l2_declaree;
	private String l3_declaree;
	private String l4_declaree;
	private String l5_declaree;
	private String l6_declaree;
	private String l7_declaree;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getL1_declaree() {
		return l1_declaree;
	}
	public void setL1_declaree(String l1_declaree) {
		this.l1_declaree = l1_declaree;
	}
	public String getL2_declaree() {
		return l2_declaree;
	}
	public void setL2_declaree(String l2_declaree) {
		this.l2_declaree = l2_declaree;
	}
	public String getL3_declaree() {
		return l3_declaree;
	}
	public void setL3_declaree(String l3_declaree) {
		this.l3_declaree = l3_declaree;
	}
	public String getL4_declaree() {
		return l4_declaree;
	}
	public void setL4_declaree(String l4_declaree) {
		this.l4_declaree = l4_declaree;
	}
	public String getL5_declaree() {
		return l5_declaree;
	}
	public void setL5_declaree(String l5_declaree) {
		this.l5_declaree = l5_declaree;
	}
	public String getL6_declaree() {
		return l6_declaree;
	}
	public void setL6_declaree(String l6_declaree) {
		this.l6_declaree = l6_declaree;
	}
	public String getL7_declaree() {
		return l7_declaree;
	}
	public void setL7_declaree(String l7_declaree) {
		this.l7_declaree = l7_declaree;
	}
	
	
}

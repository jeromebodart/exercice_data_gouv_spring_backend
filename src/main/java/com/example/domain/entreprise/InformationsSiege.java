package com.example.domain.entreprise;


public class InformationsSiege {
	private Long id;
	 private String nic;
	 private String code_region;
	 private String departement_commune;
	 private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getCode_region() {
		return code_region;
	}
	public void setCode_region(String code_region) {
		this.code_region = code_region;
	}
	public String getDepartement_commune() {
		return departement_commune;
	}
	public void setDepartement_commune(String departement_commune) {
		this.departement_commune = departement_commune;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code_region == null) ? 0 : code_region.hashCode());
		result = prime * result + ((departement_commune == null) ? 0 : departement_commune.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nic == null) ? 0 : nic.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InformationsSiege other = (InformationsSiege) obj;
		if (code_region == null) {
			if (other.code_region != null)
				return false;
		} else if (!code_region.equals(other.code_region))
			return false;
		if (departement_commune == null) {
			if (other.departement_commune != null)
				return false;
		} else if (!departement_commune.equals(other.departement_commune))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nic == null) {
			if (other.nic != null)
				return false;
		} else if (!nic.equals(other.nic))
			return false;
		return true;
	}
	
	 
}

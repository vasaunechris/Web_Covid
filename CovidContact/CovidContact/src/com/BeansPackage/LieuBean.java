package com.BeansPackage;

public class LieuBean {
	
	public LieuBean() {
		
	}
	
	private String denomination;
	private String adresse;
	private int id;
	
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDenomination() {
		return this.denomination;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
	public int getId() {
		return this.id;
	}

}

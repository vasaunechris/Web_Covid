package com.BeansPackage;

public class ActiviteBean {
	
	private int id;
	private String nom;
	private String heureD;
	private String heureF;
	private String date;
	private LieuBean lieu;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setHeureD(String heureD) {
		this.heureD = heureD;
	}
	
	public void setHeureF(String heureF) {
		this.heureF = heureF;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setLieu(LieuBean lieu) {
		this.lieu = lieu;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getHeureD() {
		return this.heureD;
	}
	
	public String getHeureF() {
		return this.heureF;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public LieuBean getLieu() {
		return this.lieu;
	}

}

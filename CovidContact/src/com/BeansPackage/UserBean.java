	package com.BeansPackage;

import java.sql.Date;

public class UserBean {
	
	public UserBean() {
		
	}
	
	private int id;
	private int genre;
	private String nom;
	private String prenom;
	private String mdp;
	private String login;
	private String ville;
	private String pays;
	private String date;
	private String adresse;
	private String mail;
	private String rang;
	
	public void setId(int n) {this.id = n;}
	
	public void setGenre(int genre) {this.genre = genre;}
	
	public void setNom(String nom) {this.nom = nom;}
	
	public void setPrenom(String prenom) {this.prenom = prenom;}
	
	public void setMdp(String mdp) {this.mdp = mdp;}
	
	public void setLogin(String login) {this.login = login;}
	
	public void setVille(String ville) {this.ville = ville;}
	
	public void setPays(String pays) {this.pays = pays;}
	
	public void setAdresse(String adresse) {this.adresse = adresse;}
	
	public void setDate(String date) {this.date = date;}
	
	public void setMail(String mail) {this.mail = mail;}
	
	public void setRang(String rang) {this.rang = rang;}
	
	public int getId() {return this.id;}
	
	public int getGenre() { return this.genre;}
	
	public String getNom() {return this.nom;}
	
	public String getPrenom() {return this.prenom;}
	
	public String getMdp() {return this.mdp;}
	
	public String getLogin() {return this.login;}
	
	public String getVille() {return this.ville;}
	
	public String getPays() {return this.pays;}
	
	public String getAdresse() {return this.adresse;}
	
	public String getDate() {return this.date;}
	
	public String getMail() {return this.mail;}
	
	public String getRang() {return this.rang;}
	
	
}

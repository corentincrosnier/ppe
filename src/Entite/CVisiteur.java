/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author admin
 */
public class CVisiteur {

	private String matricule;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private GregorianCalendar dateEmbauche;
	private CSecteur secteur;
	private ArrayList<CTravail> listeTravail;
	private CDepartement departement;
	
	public CVisiteur(String matricule, String nom, String prenom, String adresse, String codePostal, String ville, GregorianCalendar dateEmbauche, CSecteur secteur, ArrayList<CTravail> listeTravail, CDepartement departement) {
		this.setAdresse(adresse);
		this.setCodePostal(codePostal);
		this.setDateEmbauche(dateEmbauche);
		this.setDepartement(departement);
		this.setSecteur(secteur);
		this.setListeTravail(listeTravail);
		this.setMatricule(matricule);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setVille(ville);
	}
	
	public CVisiteur(){
	}
	
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public GregorianCalendar getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(GregorianCalendar dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public CSecteur getSecteur() {
		return secteur;
	}

	public void setSecteur(CSecteur secteur) {
		this.secteur = secteur;
	}

	public ArrayList<CTravail> getListeTravail() {
		return listeTravail;
	}

	public void setListeTravail(ArrayList<CTravail> listeTravail) {
		this.listeTravail = listeTravail;
	}

	public CDepartement getepartement() {
		return departement;
	}

	public void setDepartement(CDepartement departement) {
		this.departement = departement;
	}
	
	
}

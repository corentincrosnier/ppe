/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author admin
 */
public class CRegion {

	private int code;
	private String nom;
	private CSecteur secteur;

	public CRegion(int code, String nom, CSecteur secteur) {
		this.setCode(code);
		this.setNom(nom);
		this.setSecteur(secteur);
	}
	
	public CRegion(){
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CSecteur getSecteur() {
		return secteur;
	}

	public void setSecteur(CSecteur secteur) {
		this.secteur = secteur;
	}
}

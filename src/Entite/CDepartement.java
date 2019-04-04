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
public class CDepartement {

	private int code;
	private String nom;
	private String chefVente;

	public CDepartement(int code, String nom, String chefVente) {
		this.setCode(code);
		this.setNom(nom);
		this.setChefVente(chefVente);
	}
	
	public CDepartement(){
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

	public String getChefVente() {
		return chefVente;
	}

	public void setChefVente(String chefVente) {
		this.chefVente = chefVente;
	}
}

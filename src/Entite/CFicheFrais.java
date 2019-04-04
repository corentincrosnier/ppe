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
public class CFicheFrais {
	private int mois;
	private int nbHorsClassif;
	private double montantHorsClassif;
	private String etape;
	private String matriculeVisiteur;
	private GregorianCalendar dateDerniereModif;
	private ArrayList<CTypeFrais> listeTypeFrais;

	public CFicheFrais(int mois, int nbHorsClassif, double montantHorsClassif, String etape, String matriculeVisiteur, GregorianCalendar dateDerniereModif, ArrayList<CTypeFrais> listeTypeFrais) {
		this.setMois(mois);
		this.setNbHorsClassif(nbHorsClassif);
		this.setMontantHorsClassif(montantHorsClassif);
		this.setEtape(etape);
		this.setMatriculeVisiteur(matriculeVisiteur);
		this.setDateDerniereModif(dateDerniereModif);
		this.setListeTypeFrais(listeTypeFrais);
	}
	
	public CFicheFrais(){
	}
	
	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getNbHorsClassif() {
		return nbHorsClassif;
	}

	public void setNbHorsClassif(int nbHorsClassif) {
		this.nbHorsClassif = nbHorsClassif;
	}

	public double getMontantHorsClassif() {
		return montantHorsClassif;
	}

	public void setMontantHorsClassif(double montantHorsClassif) {
		this.montantHorsClassif = montantHorsClassif;
	}

	public String getEtape() {
		return etape;
	}

	public void setEtape(String etape) {
		this.etape = etape;
	}

	public String getMatriculeVisiteur() {
		return matriculeVisiteur;
	}

	public void setMatriculeVisiteur(String matriculeVisiteur) {
		this.matriculeVisiteur = matriculeVisiteur;
	}

	public GregorianCalendar getDateDerniereModif() {
		return dateDerniereModif;
	}

	public void setDateDerniereModif(GregorianCalendar dateDerniereModif) {
		this.dateDerniereModif = dateDerniereModif;
	}
	
	public ArrayList<CTypeFrais> getListeTypeFrais() {
		return listeTypeFrais;
	}

	public void setListeTypeFrais(ArrayList<CTypeFrais> listeTypeFrais) {
		this.listeTypeFrais = listeTypeFrais;
	}
}

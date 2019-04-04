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
public class CTypeFrais {

	private int code;
	private String label;
	private double forfait;
	private int inclureQuantite;
	private double inclureMontant;

	public CTypeFrais(int code, String label, double forfait, int inclureQuantite, double inclureMontant) {
		this.setCode(code);
		this.setLabel(label);
		this.setForfait(forfait);
		this.setInclureQuantite(inclureQuantite);
		this.setInclureMontant(inclureMontant);
	}
	
	public CTypeFrais(){
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getForfait() {
		return forfait;
	}

	public void setForfait(double forfait) {
		this.forfait = forfait;
	}

	public int getInclureQuantite() {
		return inclureQuantite;
	}

	public void setInclureQuantite(int inclureQuantite) {
		this.inclureQuantite = inclureQuantite;
	}

	public double getInclureMontant() {
		return inclureMontant;
	}

	public void setInclureMontant(double inclureMontant) {
		this.inclureMontant = inclureMontant;
	}
}

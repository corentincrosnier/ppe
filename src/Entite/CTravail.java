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
public class CTravail {

	private String role;
	private GregorianCalendar date;
	private ArrayList<CRegion> listeRegion;

	public CTravail(String role, GregorianCalendar date, ArrayList<CRegion> listeRegion) {
		this.setDate(date);
		this.setListeRegion(listeRegion);
		this.setRole(role);
	}
	
	public CTravail(){
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public ArrayList<CRegion> getListeRegion() {
		return listeRegion;
	}

	public void setListeRegion(ArrayList<CRegion> listeRegion) {
		this.listeRegion = listeRegion;
	}
}

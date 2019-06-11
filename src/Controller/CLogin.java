/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.CVisiteur;
import Service.CTableVisiteur;
import bdd.CBDD;

/**
 *
 * @author admin
 */
public class CLogin {
	private CTableVisiteur tableVisiteur;
	private CVisiteur visiteur;
	private String name;
	private String password;
	private boolean isLogged;
	
	public CLogin(CTableVisiteur tableVisiteur){
		this.tableVisiteur=tableVisiteur;
		this.isLogged=false;
	}
	
	public boolean login(String name, String password){
		if(name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			this.name="admin";
			this.visiteur=new CVisiteur();
			this.visiteur.setMatricule("root");
			return true;
		}
		this.visiteur=this.tableVisiteur.checkAuth(name, password);
		if(this.visiteur!=null){
			this.name=visiteur.getNom()+" "+visiteur.getPrenom();
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	public CTableVisiteur getTableVisiteur(){
		return this.tableVisiteur;
	}
	
	public String getName(){
		return this.name;
	}
	
	public CVisiteur getVisiteur(){
		return this.visiteur;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class CPraticien {

    private int num;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private float coefNotoriete;
    private String typeLabel;
    private String typeLieu;
    private String typeCode;
    private ArrayList<CSpecialite> specialite;

    public CPraticien(int num, String nom, String prenom, String adresse, String codePostal, String ville, float coefNotoriete, String typeLabel, String typeLieu, String typeCode, ArrayList<CSpecialite> specialite) {
        this.setNum (num);
        this.setNom (nom);
        this.setPrenom (prenom);
        this.setAdresse (adresse);
        this.setCodePostal (codePostal);
        this.setVille (ville);
        this.setCoefNotoriete (coefNotoriete);
        this.setTypeLabel (typeLabel);
        this.setTypeLieu (typeLieu);
        this.setTypeCode (typeCode);
        this.setSpecialite (specialite);
    }
    
    public CPraticien(){
        
    }
    
            
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public float getCoefNotoriete() {
        return coefNotoriete;
    }

    public void setCoefNotoriete(float coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    public String getTypeLieu() {
        return typeLieu;
    }

    public void setTypeLieu(String typeLieu) {
        this.typeLieu = typeLieu;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public ArrayList<CSpecialite> getSpecialite() {
        return specialite;
    }

    public void setSpecialite(ArrayList<CSpecialite> specialite) {
        this.specialite = specialite;
    }

    public void afficherSpecialite() {
        ArrayList<CSpecialite> specialite = new ArrayList();
        for (int i = 0; i < specialite.size(); i++) {
            System.out.println(specialite.get(i).getLabel());
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class CCompteRendu {

    private int num;
    private GregorianCalendar date;
    private String bilan;
    private String motif;
    private String visiteur;
    private String praticien;
    private ArrayList<COffre> offre;

    public int getNum() {
        return num;
    }

    public CCompteRendu(int num, GregorianCalendar date, String bilan, String motif, String visiteur, String praticien, ArrayList<COffre> offre) {
        this.setNum (num);
        this.setDate (date);
        this.setBilan (bilan);
        this.setMotif (motif);
        this.setVisiteur (visiteur);
        this.setPraticien (praticien);
        this.setOffre (offre);
    }
    
    public CCompteRendu(){
        
    }

    public void setNum(int num) {
        this.num = num;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getBilan() {          
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(String visiteur) {
        this.visiteur = visiteur;
    }

    public String getPraticien() {
        return praticien;
    }

    public void setPraticien(String praticien) {
        this.praticien = praticien;
    }

    public ArrayList<COffre> getOffre() {
        return offre;
    }

    public void setOffre(ArrayList<COffre> offre) {
        this.offre = offre;
    }

    public void afficherOffre() {
        ArrayList<COffre> offre = new ArrayList();
        for (int i = 0; i < offre.size(); i++) {
            System.out.println(offre.get(i).getDepotLegalMedicament());
        }
    }
    
}

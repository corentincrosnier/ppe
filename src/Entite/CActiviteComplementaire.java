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
public class CActiviteComplementaire {

    private int num;
    private GregorianCalendar date;
    private String lieu;
    private String theme;
    private ArrayList<CPraticien> praticien;
    private ArrayList<CVisiteur> visiteur;


    public CActiviteComplementaire(int num, GregorianCalendar date, String lieu, String theme, ArrayList<CPraticien> praticien, ArrayList<CVisiteur> visiteur) {
        this.setNum (num);
        this.setDate (date);
        this.setLieu (lieu);
        this.setTheme (theme);
        this.setPraticien (praticien);
        this.setVisiteur (visiteur);
    }
    
    public CActiviteComplementaire(){
        
    }
    
    public int getNum() {
        return num;
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

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public ArrayList<CPraticien> getPraticien() {
        return praticien;
    }

    public void setPraticien(ArrayList<CPraticien> praticien) {
        this.praticien = praticien;
    }

    public ArrayList<CVisiteur> getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(ArrayList<CVisiteur> visiteur) {
        this.visiteur = visiteur;
    }
    
    public void afficherPraticien() {
        ArrayList<CPraticien> praticien = new ArrayList();
        for (int i = 0; i < praticien.size(); i++) {
            System.out.println(praticien.get(i).getNum());
        }
    }

    public void afficherVisiteur() {
        ArrayList<CVisiteur> visiteur = new ArrayList();
        for (int i = 0; i < visiteur.size(); i++) {
            System.out.println(visiteur.get(i).getMatricule());
        }
    }
        
}

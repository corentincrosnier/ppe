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
public class CMedicament {
    
	private String nomCommercial;
    private int depotLegal;
    private String composition;
    private String effets;
    private String contreIndic;
    private float prixEchantillon;
    private int familleCode;
    private String familleLabel;
    private ArrayList<CPresentation> listePresentation;
    private ArrayList<CPrescription> listePrescription;
    private ArrayList listePerturbe=new ArrayList();
    private ArrayList listePerturbateur=new ArrayList();
    private ArrayList<CComposant> listeComposant=new ArrayList();

    public CMedicament(String nomCommercial, int depotLegal, String composition, String effets, String contreIndic, float prixEchantillon, int familleCode, String familleLabel, ArrayList<CPresentation> listePresentation, ArrayList<CPrescription> listePrescription, ArrayList listePerturbe, ArrayList listePerturbateur, ArrayList<CComposant> listeComposant) {
        this.setNomCommercial (nomCommercial);
        this.setDepotLegal (depotLegal);
        this.setComposition (composition);
        this.setEffets (effets);
        this.setContreIndic (contreIndic);
        this.setPrixEchantillon (prixEchantillon);
        this.setFamilleCode (familleCode);
        this.setFamilleLabel (familleLabel);
        this.setListePresentation (listePresentation);
        this.setListePrescription (listePrescription);
        this.setListePerturbe (listePerturbe);
        this.setListePerturbateur (listePerturbateur);
        this.setListeComposant (listeComposant);
    }
    
    public CMedicament() {
        
    }
    
    /**
     * @return the listeInteraction
     */
    public ArrayList getListePerturbe() {
        return listePerturbe;
    }

    /**
     * @param listeInteraction the listeInteraction to set
     */
    public void setListePerturbe(ArrayList listePerturbe) {
        this.listePerturbe = listePerturbe;
    }

    /**
     * @return the listePerturbateur
     */
    public ArrayList getListePerturbateur() {
        return listePerturbateur;
    }

    /**
     * @param listePerturbateur the listePerturbateur to set
     */
    public void setListePerturbateur(ArrayList listePerturbateur) {
        this.listePerturbateur = listePerturbateur;
    }
    


    /**
     * @return the nomCommercial
     */
    public String getNomCommercial() {
        return nomCommercial;
    }

    /**
     * @param nomCommercial the nomCommercial to set
     */
    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    /**
     * @return the depotLegal
     */
    public int getDepotLegal() {
        return depotLegal;
    }

    /**
     * @param depotLegal the depotLegal to set
     */
    public void setDepotLegal(int depotLegal) {
        this.depotLegal = depotLegal;
    }

    /**
     * @return the composition
     */
    public String getComposition() {
        return composition;
    }

    /**
     * @param composition the composition to set
     */
    public void setComposition(String composition) {
        this.composition = composition;
    }

    /**
     * @return the effets
     */
    public String getEffets() {
        return effets;
    }

    /**
     * @param effets the effets to set
     */
    public void setEffets(String effets) {
        this.effets = effets;
    }

    /**
     * @return the contreIndic
     */
    public String getContreIndic() {
        return contreIndic;
    }

    /**
     * @param contreIndic the contreIndic to set
     */
    public void setContreIndic(String contreIndic) {
        this.contreIndic = contreIndic;
    }

    /**
     * @return the prixEchantillon
     */
    public float getPrixEchantillon() {
        return prixEchantillon;
    }

    /**
     * @param prixEchantillon the prixEchantillon to set
     */
    public void setPrixEchantillon(float prixEchantillon) {
        this.prixEchantillon = prixEchantillon;
    }

    /**
     * @return the familleCode
     */
    public int getFamilleCode() {
        return familleCode;
    }

    /**
     * @param familleCode the familleCode to set
     */
    public void setFamilleCode(int familleCode) {
        this.familleCode = familleCode;
    }

    /**
     * @return the familleLabel
     */
    public String getFamilleLabel() {
        return familleLabel;
    }

    /**
     * @param familleLabel the familleLabel to set
     */
    public void setFamilleLabel(String familleLabel) {
        this.familleLabel = familleLabel;
    }

    /**
     * @return the listePresentation
     */
    public ArrayList<CPresentation> getListePresentation() {
        return listePresentation;
    }

    /**
     * @param listePresentation the listePresentation to set
     */
    public void setListePresentation(ArrayList<CPresentation> listePresentation) {
        this.listePresentation = listePresentation;
    }

    /**
     * @return the listePrescription
     */
    public ArrayList<CPrescription> getListePrescription() {
        return listePrescription;
    }

    /**
     * @param listePrescription the listePrescription to set
     */
    public void setListePrescription(ArrayList<CPrescription> listePrescription) {
        this.listePrescription = listePrescription;
    }



    /**
     * @return the listeComposant
     */
    public ArrayList<CComposant> getListeComposant() {
        return listeComposant;
    }

    /**
     * @param listeComposant the listeComposant to set
     */
    public void setListeComposant(ArrayList<CComposant> listeComposant) {
        this.listeComposant = listeComposant;
    }
 
    
}

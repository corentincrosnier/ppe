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
public class CSpecialite {

    private int code;
    private String label;
    private String diplome;
    private float coefPrescrition;

    

    public CSpecialite(int code, String label, String diplome, float coefPrescrition) {
        this.setCode (code);
        this.setLabel (label);
        this.setDiplome (diplome);
        this.setCoefPrescrition (coefPrescrition);
    }
    
    public CSpecialite(){
        
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

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public float getCoefPrescrition() {
        return coefPrescrition;
    }

    public void setCoefPrescrition(float coefPrescrition) {
        this.coefPrescrition = coefPrescrition;
    }
}

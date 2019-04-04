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
public class CDosage {
    
    private int code;
    private float quantite;
    private String unite;    

    public CDosage(int code, float quantite, String unite) {
        this.setCode (code);
        this.setQuantite (quantite);
        this.setUnite (unite);
    }

    public CDosage() {
        
    }
    
    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the quantite
     */
    public float getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    /**
     * @return the unite
     */
    public String getUnite() {
        return unite;
    }

    /**
     * @param unite the unite to set
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }
    
}

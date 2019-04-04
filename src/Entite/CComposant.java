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
public class CComposant {
    
    private int code;
    private String label;
    private float quantite;
	private String unite;


    public CComposant(int code, String label, float quantite, String unite) {
        this.setCode (code);
        this.setLabel (label);
        this.setQuantite (quantite);
		this.setUnite(unite);
    }
    
    public CComposant () {
        
    }

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
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
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
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
    
    
}

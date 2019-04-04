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
public class COffre {

    private int quantite;
	private int depotLegalMedicament;
    
    public COffre(int quantite, int depotLegalMedicament) {
        this.setQuantite (quantite);
        this.setDepotLegalMedicament(depotLegalMedicament);
    }
    
    public COffre() {
        
    }

    /**
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * @return the medicament
     */
    public int getDepotLegalMedicament() {
        return depotLegalMedicament;
    }

    /**
     * @param medicament the medicament to set
     */
    public void setDepotLegalMedicament(int depotLegalMedicament) {
        this.depotLegalMedicament = depotLegalMedicament;
    }
    
 
}

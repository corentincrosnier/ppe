/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CPraticien;
import bdd.CBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CTablePraticien {
	protected CBDD bdd;
	protected CTableComposant tableComposant;
	protected CTablePrescription tablePrescription;
	protected CTablePresentation tablePresentation;
	//protected CTableFamille tableFamille=new CTableFamille();
    
    public CTablePraticien(){
        //this.loadMedicament();
    }
	
	public CTablePraticien(CBDD bdd){
        this.bdd=bdd;
		//this.load();
    }
	
	public ArrayList<CPraticien> listPraticien(){
		ArrayList<CPraticien> liste=new ArrayList();
		if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
            ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM praticien;");
            try {
                while(rs.next()){
                    liste.add(rs_to_praticien(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTablePraticien.class.getName()).log(Level.SEVERE, null, ex);
				return liste;
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
		return liste;
	}
	
	public CPraticien rs_to_praticien(ResultSet rs) throws SQLException{
		CPraticien praticien=new CPraticien();
		praticien.setNum(rs.getInt("PRA_NUM_PRATICIEN"));
		praticien.setNom(rs.getString("PRA_NOM_PRATICIEN"));
		praticien.setPrenom(rs.getString("PRA_PRENOM_PRATICIEN"));
		praticien.setAdresse(rs.getString("PRA_ADRESSE_PRATICIEN"));
		praticien.setCodePostal(rs.getString("PRA_CP_PRATICIEN"));
		praticien.setVille(rs.getString("PRA_VILLE_PRATICIEN"));
		praticien.setCoefNotoriete(rs.getFloat("PRA_COEFNOTORIETE_PRATICIEN"));
		
		
		return praticien;
	}
}

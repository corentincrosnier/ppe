/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CPrescription;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CTablePrescription {
	//protected CBDD bdd=new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
	protected CBDD bdd;
    protected ArrayList<CPrescription> listePrescription=new ArrayList();
	
	protected CTableDosage tableDosage;
	//protected CTableFamille tableFamille=new CTableFamille();
    
    public CTablePrescription(){
       // this.loadComposant();
    }
	
	public CTablePrescription(CBDD bdd, CTableDosage tableDosage){
       // this.loadComposant();
	   this.bdd=bdd;
	   this.tableDosage=tableDosage;
    }
    
    /*public int insert(CPersonnels personnel) {
        String req="insert into personnel(nom,prenom,matricule,tauxHoraire) value('"
                +personnel.getNom()+"','"
                +personnel.getPrenom()+"','"
                +personnel.getMatricule()+"',"
                +personnel.getTauxHoraire()+");";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
            //--------------Reload Table after inserting---------
            this.listePersonnel();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }*/
	
	public int insert(CPrescription prescription, int depotLegal) {
        int res = -1;
        if (bdd.connecter() == true) {
            //res = bdd.executerRequeteUpdate(req);
			for (int i = 0; i < prescription.getListeDosage().size(); i++) {
				bdd.executerRequeteUpdate("INSERT INTO prescrire(MED_DEPOTLEGAL_MEDICAMENT,TIN_CODE_TYPE_INDIVIDU,DOS_CODE_DOSAGE,PRE_POSOLOGIE_PRESCRIRE) VALUE('"+depotLegal+"','"+prescription.getIndividuCode()+"','"+prescription.getListeDosage().get(i).getCode()+"','"+prescription.getPosologie()+"')");
			}
            System.out.println("Res = " + res);
            bdd.deconnecter();
            //--------------Reload Table after inserting---------
            //this.listePersonnel();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    /*public int delete(String matricule) {
        String req = "DELETE FROM prescrire WHERE matricule="+matricule+";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }*/
	
	public ArrayList<CPrescription> fetchPrescription(int depotLegal){
		ArrayList<CPrescription> fetchList=new ArrayList();
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
			ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM prescrire,type_individu WHERE prescrire.MED_DEPOTLEGAL_MEDICAMENT="+depotLegal+" AND prescrire.TIN_CODE_TYPE_INDIVIDU=type_individu.TIN_CODE_TYPE_INDIVIDU;");
		
            try {
                while(rs.next()){
                    fetchList.add(new CPrescription(rs.getInt("MED_DEPOTLEGAL_MEDICAMENT"),rs.getString("PRE_POSOLOGIE_PRESCRIRE"),rs.getInt("TIN_CODE_TYPE_INDIVIDU"),rs.getString("TIN_LIBELLE_TYPE_INDIVIDU"),this.tableDosage.fetchDosage(rs.getInt("DOS_CODE_DOSAGE"))));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTablePrescription.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            //System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
		return fetchList;
	}
	
	public void load(){
		//ArrayList<CPrescription> fetchList=new ArrayList();
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
			ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM prescrire,type_individu WHERE prescrire.TIN_CODE_TYPE_INDIVIDU=type_individu.TIN_CODE_TYPE_INDIVIDU;");
		
            try {
                while(rs.next()){
                    listePrescription.add(new CPrescription(rs.getInt("MED_DEPOTLEGAL_MEDICAMENT"),rs.getString("PRE_POSOLOGIE_PRESCRIRE"),rs.getInt("TIN_CODE_TYPE_INDIVIDU"),rs.getString("TIN_LIBELLE_TYPE_INDIVIDU"),this.tableDosage.fetchDosage(rs.getInt("DOS_CODE_DOSAGE"))));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTablePrescription.class.getName()).log(Level.SEVERE, null, ex);
           //     return null;
            }
            //System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
		//return fetchList;
	}

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }
    
   /* public void printPersonnel(String matricule) {
        for (int i = 0; i < listePersonnels.size(); i++) {
            if (matricule.equals(listePersonnels.get(i).getMatricule())) {
                System.out.println("Nom: " + listePersonnels.get(i).getNom());
                System.out.println("Prénom: " + listePersonnels.get(i).getPrenom());
                System.out.println("Matricule: " + listePersonnels.get(i).getMatricule());
                System.out.println("Taux horaire: " + listePersonnels.get(i).getTauxHoraire());
                System.out.println("-------------------------------------");
                break;
            }
        }
    }*/
    
    /*public void printAllPersonnels(){
        for (int i = 0; i < listePersonnels.size(); i++) {
            System.out.println("Nom: "+listePersonnels.get(i).getNom());
            System.out.println("Prénom: "+listePersonnels.get(i).getPrenom());
            System.out.println("Matricule: "+listePersonnels.get(i).getMatricule());
            System.out.println("Taux horaire: "+listePersonnels.get(i).getTauxHoraire());
            System.out.println("-------------------------------------");
        }
    }
    
    public CPersonnels getPersonne(String matricule){
        for (int i = 0; i < listePersonnels.size(); i++) {
            if(listePersonnels.get(i).getMatricule().equals(matricule))
                return listePersonnels.get(i);
        }
        System.out.println("La personne n'a pas été trouvée.");
        return null;
    }*/

    //public ArrayList<CMedicament> getListeMedicament() {
    //    return listeMedicament;
    //}

   /* public void setListePersonnels(ArrayList<CPersonnels> listePersonnels) {
        this.listePersonnels = listePersonnels;
    }*/

	public ArrayList<CPrescription> getListePrescription() {
		return listePrescription;
	}
}

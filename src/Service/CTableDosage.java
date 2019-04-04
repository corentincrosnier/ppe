/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CDosage;
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
public class CTableDosage {
	//protected CBDD bdd=new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
	protected CBDD bdd;
    protected ArrayList<CDosage> listeDosage=new ArrayList();
	//protected CTableFamille tableFamille=new CTableFamille();
    
    public CTableDosage(CBDD bdd){
       // this.loadComposant();
	   this.bdd=bdd;
    }
     //-----------------------------------createTable n'est pas utilisée-----
   /* public int createTable() {
        String req = "CREATE TABLE IF NOT EXISTS personnel(nom varchar(30), prenom varchar(30), matricule char(8) primary key, tauxHoraire float unsigned) ENGINE = InnoDB;";
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
	
	public int insert(CDosage dosage) {
        String req="insert into dosage(DOS_CODE_DOSAGE,DOS_QUANTITE_DOSAGE,DOS_UNITE_DOSAGE) value('"
                +dosage.getCode()+"','"
				+dosage.getQuantite()+"','"
                +dosage.getUnite()+");";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
            //--------------Reload Table after inserting---------
            //this.listePersonnel();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    public int delete(CDosage dosage) {
        String req = "DELETE FROM dosage WHERE DOS_CODE_DOSAGE="+dosage.getCode()+";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate("DELETE FROM prescrire WHERE DOS_CODE_DOSAGE="+dosage.getCode()+";");
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    /*public int update(String oldMatricule, CPersonnels personnel) {
        int index=-1;
        for (int i = 0; i < listePersonnels.size(); i++) {
            if(personnel.getMatricule().equals(listePersonnels.get(i).getMatricule())){
                System.out.println("Le nouveau matricule éxiste déjà.");
                return -1;
            }
            else if(oldMatricule.equals(listePersonnels.get(i).getMatricule()))
                index=i;
        }
        if(index==-1){
            System.out.println("Le matricule n'a pas été trouvé.");
            return -1;
        }
        String req = "UPDATE personnel SET"
                + " nom='"+personnel.getNom().trim().replace("'", "''")
                +"', prenom='"+personnel.getPrenom().trim().replace("'", "''")
                +"', matricule='"+personnel.getMatricule()
                +"',tauxHoraire="+personnel.getTauxHoraire()
                +" where matricule='"+oldMatricule+"';";
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
    
    /*public int loadComposant() {
        int res = -1;
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
            ResultSet rs=bdd.executerRequeteQuery("SELECT *,FAM_LIBELLE_FAMILLE FROM medicament,famille WHERE famille.FAM_CODE_FAMILLE=medicament.FAM_CODE_FAMILLE;");
            try {
                while(rs.next()){
                    this.listeComposant.add(rs_to_medicament(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableComposant.class.getName()).log(Level.SEVERE, null, ex);
                return res;
            }
            res=1;
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }*/
	
	public ArrayList<CDosage> fetchDosage(int codeDosage){
		ArrayList<CDosage> fetchList=new ArrayList();
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
			ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM dosage WHERE dosage.DOS_CODE_DOSAGE="+codeDosage+";");
		
            try {
                while(rs.next()){
                    fetchList.add(new CDosage(rs.getInt("DOS_CODE_DOSAGE"),rs.getFloat("DOS_QUANTITE_DOSAGE"),rs.getString("DOS_UNITE_DOSAGE")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableDosage.class.getName()).log(Level.SEVERE, null, ex);
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
		//ArrayList<CDosage> fetchList=new ArrayList();
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
			ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM dosage;");
		
            try {
                while(rs.next()){
                    listeDosage.add(new CDosage(rs.getInt("DOS_CODE_DOSAGE"),rs.getFloat("DOS_QUANTITE_DOSAGE"),rs.getString("DOS_UNITE_DOSAGE")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableDosage.class.getName()).log(Level.SEVERE, null, ex);
                //return null;
            }
            //System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
		//return fetchList;
	}
    
   /* public CComposant rs_to_composant(ResultSet rs) throws SQLException{
        CComposant composant=new CComposant();
        composant.setCode(rs.getInt("CMP_CODE_COMPOSANT"));
        composant.setLabel(rs.getString("CMP_LIBELLE_COMPOSANT"));
		
		ResultSet rsInteraction=bdd.executerRequeteQuery("SELECT * FROM constituer WHERE CMP_CODE_COMPOSANT="+composant.getCode()+";");
		try {
			while(rsInteraction.next()){
				if(rsInteraction.getInt("MED_DEPOTLEGAL_MEDICAMENT")==medicament.getDepotLegal())
					medicament.getListePerturbe().add(rsInteraction.getInt("MED_DEPOTLEGAL_MEDICAMENT_INTERAGIR"));
				else
					medicament.getListePerturbateur().add(rsInteraction.getInt("MED_DEPOTLEGAL_MEDICAMENT"));
			}
		} catch (SQLException ex){
			Logger.getLogger(CTableMedicament.class.getName()).log(Level.SEVERE, null, ex);
		}
        return medicament;
    }

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }*/
    
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
	
	public ArrayList<CDosage> getListeDosage() {
		return listeDosage;
	}
}
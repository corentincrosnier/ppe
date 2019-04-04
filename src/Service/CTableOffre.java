/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CMedicament;
import Entite.COffre;
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
public class CTableOffre {
	protected CBDD bdd;
    protected ArrayList<COffre> listeOffre=new ArrayList();
	/*protected CTableComposant tableComposant;
	protected CTablePrescription tablePrescription;
	protected CTablePresentation tablePresentation;
	*/
	//protected CTableFamille tableFamille=new CTableFamille();
    
    public CTableOffre(){
        //this.loadMedicament();
    }
	
	public CTableOffre(CBDD bdd){
        this.bdd=bdd;
		//this.load();
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
    
    public int insert(COffre offre, int numRapport) {
		
        String req="insert into offrir(RAP_NUM_RAPPORT_VISITE,MED_DEPOTLEGAL_MEDICAMENT,OFF_QTE_OFFRIR) value('"
                +numRapport+"','"
				+offre.getDepotLegalMedicament()+"','"
				+offre.getQuantite()+"');";
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
    
    public int delete(COffre offre,int numRapport) {
        String req = "DELETE FROM offrir WHERE MED_DEPOTLEGAL_MEDICAMENT="+offre.getDepotLegalMedicament()+" AND RAP_NUM_RAPPORT_VISITE="+numRapport+";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    public int load() {
        int res = -1;
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
            ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM offrir;");
            try {
                while(rs.next()){
                    this.listeOffre.add(rs_to_offre(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableOffre.class.getName()).log(Level.SEVERE, null, ex);
                return res;
            }
            res=1;
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
	
	public ArrayList<COffre> fetchOffre(int numRapport) {
		ArrayList<COffre> fetchList=new ArrayList();
        int res = -1;
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
            ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM offrir WHERE offrir.RAP_NUM_RAPPORT_VISITE="+numRapport+";");
            try {
                while(rs.next()){
                    fetchList.add(rs_to_offre(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableOffre.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            res=1;
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return fetchList;
    }
    
    public COffre rs_to_offre(ResultSet rs) throws SQLException{
        COffre offre=new COffre();
        offre.setDepotLegalMedicament(rs.getInt("MED_DEPOTLEGAL_MEDICAMENT"));
        offre.setQuantite(rs.getInt("OFF_QTE_OFFRIR"));
		
        return offre;
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
    */

    public ArrayList<COffre> getListeOffre() {
        return listeOffre;
    }

   /*public void setListePersonnels(ArrayList<CPersonnels> listePersonnels) {
        this.listePersonnels = listePersonnels;
    }*/
}

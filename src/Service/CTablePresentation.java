/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CPresentation;
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
public class CTablePresentation {
	//protected CBDD bdd=new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
	protected CBDD bdd;
    protected ArrayList<CPresentation> listePresentation=new ArrayList();
	//protected CTableDosage tableDosage=new CTableDosage();
	//protected CTableFamille tableFamille=new CTableFamille();
    
    public CTablePresentation(){
       // this.loadComposant();
    }
	
	public CTablePresentation(CBDD bdd){
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
    
    public int insert(CPresentation presentation) {
        String req="insert into pesentation(PRE_CODE_PRESENTATION,PRE_LIBELLE_PRESENTATION) value('"
                +presentation.getCode()+"','"
                +presentation.getLabel()+");";
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
    
    public int delete(CPresentation presentation) {
        String req = "DELETE FROM presentation WHERE PRE_CODE_PRESENTATION="+presentation.getCode()+";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate("DELETE FROM formuler WHERE PRE_CODE_PRESENTATION="+presentation.getCode()+";");
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
	
	public ArrayList<CPresentation> fetchPresentation(int depotLegal){
		ArrayList<CPresentation> fetchList=new ArrayList();
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
			ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM presentation,formuler WHERE formuler.MED_DEPOTLEGAL_MEDICAMENT="+depotLegal+" AND presentation.PRE_CODE_PRESENTATION=formuler.PRE_CODE_PRESENTATION;");
		
            try {
                while(rs.next()){
                    fetchList.add(new CPresentation(rs.getInt("PRE_CODE_PRESENTATION"),rs.getString("PRE_LIBELLE_PRESENTATION")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableComposant.class.getName()).log(Level.SEVERE, null, ex);
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
		//ArrayList<CPresentation> fetchList=new ArrayList();
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
			//ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM presentation,formuler WHERE presentation.PRE_CODE_PRESENTATION=formuler.PRE_CODE_PRESENTATION;");
			ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM presentation;");
		
            try {
                while(rs.next()){
                    listePresentation.add(new CPresentation(rs.getInt("PRE_CODE_PRESENTATION"),rs.getString("PRE_LIBELLE_PRESENTATION")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableComposant.class.getName()).log(Level.SEVERE, null, ex);
            //    return null;
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

	public ArrayList<CPresentation> getListePresentation() {
		return listePresentation;
	}
}

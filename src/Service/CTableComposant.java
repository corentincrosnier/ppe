/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CComposant;
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
public class CTableComposant {
	//protected CBDD bdd=new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
	protected CBDD bdd;
    protected ArrayList<CComposant> listeComposant=new ArrayList();
	//protected CTableFamille tableFamille=new CTableFamille();

    
    public CTableComposant(){
       // this.loadComposant();
    }
	
	public CTableComposant(CBDD bdd){
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
    
    public int insert(CComposant composant) {
        String req="insert into composant(CMP_CODE_COMPOSANT,CMP_LIBELLE_COMPOSANT) value('"
                +composant.getCode()+"','"
                +composant.getLabel()+");";
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
    
    public int delete(CComposant composant) {
        String req = "DELETE FROM personnel WHERE CMP_CODE_COMPOSANT="+composant.getCode()+";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate("DELETE FROM constituer WHERE CMP_CODDE_COMPOSANT="+composant.getCode()+";");
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    public int update(CComposant composant) {
        String req = "UPDATE composant SET CMP_LIBELLE_COMPOSANT="+composant.getLabel()+" WHERE CMP_CODE_COMPOSANT='"+composant.getCode()+"';";
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

	public ArrayList<CComposant> fetchComposant(int depotLegal){
		ArrayList<CComposant> fetchList=new ArrayList();
        if (bdd.connecter() == true) {
			ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM constituer,composant WHERE constituer.MED_DEPOTLEGAL_MEDICAMENT="+depotLegal+" AND composant.CMP_CODE_COMPOSANT=constituer.CMP_CODE_COMPOSANT;");
		
            try {
                while(rs.next()){
                    fetchList.add(new CComposant(rs.getInt("CMP_CODE_COMPOSANT"),rs.getString("CMP_LIBELLE_COMPOSANT"),rs.getFloat("CST_QTE_CONSTITUER"),rs.getString("CST_UNITE_CONSTITUER")));
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
	
	public int load() {
        int res = -1;
        if (bdd.connecter() == true) {
            ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM composant;");
            try {
                while(rs.next()){
                    this.listeComposant.add(rs_to_composant(rs));
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
    }
	
	public CComposant getComposant(int code) {
        CComposant composant=null;
        if (bdd.connecter() == true) {
            ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM composant WHERE CMP_CODE_COMPOSANT="+code+";");
            try {
                while(rs.next()){
                    composant=rs_to_composant(rs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableComposant.class.getName()).log(Level.SEVERE, null, ex);
                return composant;
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return composant;
    }
	
	public CComposant rs_to_composant(ResultSet rs) throws SQLException{
        CComposant composant=new CComposant();
        composant.setCode(rs.getInt("CMP_CODE_COMPOSANT"));
        composant.setLabel(rs.getString("CMP_LIBELLE_COMPOSANT"));
        //composant.setQuantite(rs.getFloat("CST_QTE_CONSTITUER"));
        //composant.setUnite(rs.getString("CST_UNITE_CONSTITUER"));
        return composant;
    }
    
    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }

	public ArrayList<CComposant> getListeComposant() {
		return listeComposant;
	}
    
}

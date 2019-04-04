/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CVisiteur;
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
public class CTableVisiteur{
	protected CBDD bdd=new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
    protected ArrayList<CVisiteur> listeVisiteur=new ArrayList();
    
    public CTableVisiteur(){
        //this.listePersonnel();
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
    /*
    public int delRecord(String matricule) {
        String req = "DELETE FROM personnel WHERE matricule="+matricule+";";
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
    */
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
   /* 
    public int listePersonnel() {
        int res = -1;
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
            ResultSet rs=bdd.executerRequeteQuery("SELECT * FROM visiteur;");
            try {
                while(rs.next()){
                    this.listeVisiteur.add(rs_to_visiteur(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableVisiteur.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public CVisiteur rs_to_visiteur(ResultSet rs) throws SQLException{
        CVisiteur visiteur=new CVisiteur();
        visiteur.setNom(rs.getString("VIS_NOM_VISITEUR"));
        visiteur.setPrenom(rs.getString("VIS_PRENOM_VISITEUR"));
        visiteur.setMatricule(rs.getString("VIS_MATRICULE_VISITEUR"));
        visiteur.setAdresse(rs.getString("VIS_ADRESSE_VISITEUR"));
        visiteur.setCodePostal(rs.getString("VIS_CP_VISITEUR"));
        visiteur.setVille(rs.getString("VIS_VILLE_VISITEUR"));
       // visiteur.s(rs.getString("DEP_CODE_DEPARTEMENT"));
        visiteur.setMatricule(rs.getString("SECTEUR_SEC_CODE_SECTEUR"));
        //visiteur.setTauxHoraire(rs.getFloat("tauxHoraire"));
		
        visiteur.setDateEmbauche(rs.getString("VIS_DATEEMBAUCHE_VISITEUR"));
        return visiteur;
    }

    public CBDD getBdd() {
        return bdd;
    }

    public void setBdd(CBDD bdd) {
        this.bdd = bdd;
    }
    */
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
/*
    public ArrayList<CVisiteur> getListeVisiteur() {
        return listeVisiteur;
    }*/

   /* public void setListePersonnels(ArrayList<CPersonnels> listePersonnels) {
        this.listePersonnels = listePersonnels;
    }*/
}

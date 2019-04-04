/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CComposant;
import Entite.CMedicament;
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
public class CTableMedicament {
	protected CBDD bdd;
    protected ArrayList<CMedicament> listeMedicament=new ArrayList();
	protected CTableComposant tableComposant;
	protected CTablePrescription tablePrescription;
	protected CTablePresentation tablePresentation;
	//protected CTableFamille tableFamille=new CTableFamille();
    
    public CTableMedicament(){
        //this.loadMedicament();
    }
	
	public CTableMedicament(CBDD bdd, CTableComposant tableComposant,CTablePrescription tablePrescription, CTablePresentation tablePresentation){
        this.bdd=bdd;
		this.tableComposant=tableComposant;
		this.tablePrescription=tablePrescription;
		this.tablePresentation=tablePresentation;
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
    
    public int insert(CMedicament medicament) {
        String req="insert into medicament(MED_DEPOTLEGAL_MEDICAMENT,MED_NOMCOMMERCIAL_MEDICAMENT,MED_COMPOSITION_MEDICAMENT,MED_EFFETS_MEDICAMENT,MED_CONTREINDIC_MEDICAMENT,MED_PRIXECHANTILLON_MEDICAMENT,FAM_CODE_FAMILLE) value('"
                +medicament.getDepotLegal()+"','"
				+medicament.getNomCommercial()+"','"
				+medicament.getComposition()+"','"
				+medicament.getEffets()+"','"
				+medicament.getContreIndic()+"','"
				+medicament.getPrixEchantillon()+"','"
				+medicament.getFamilleCode()+"');";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
			for(int i=0;i<medicament.getListeComposant().size();i++){
				//this.tableComposant.insert(medicament.getListeComposant().get(i));
				bdd.executerRequeteUpdate("INSERT INTO constituer(MED_DEPOTLEGAL_MEDICAMENT,CMP_CODE_COMPOSANT,CST_QTE_CONSTITUER,CST_UNITE_CONSTITUER) VALUE('"+medicament.getDepotLegal()+"','"+medicament.getListeComposant().get(i).getCode()+"','"+medicament.getListeComposant().get(i).getQuantite()+"','"+medicament.getListeComposant().get(i).getUnite()+"')");
			}
			for(int i=0;i<medicament.getListePresentation().size();i++){
				//this.tablePresentation.insert(medicament.getListePresentation().get(i));
				
				bdd.executerRequeteUpdate("INSERT INTO formuler(MED_DEPOTLEGAL_MEDICAMENT,PRE_CODE_PRESENTATION) VALUE('"+medicament.getDepotLegal()+"','"+medicament.getListePresentation().get(i).getCode()+"')");
			}
			for(int i=0;i<medicament.getListePrescription().size();i++){
				for(int j=0;j<medicament.getListePrescription().get(i).getListeDosage().size();j++){
					//this.tablePrescription.insert(medicament.getListePrescription().get(i));
					bdd.executerRequeteUpdate("INSERT INTO prescrire(MED_DEPOTLEGAL_MEDICAMENT,TIN_CODE_TYPE_INDIVIDU,DOS_CODE_DOSAGE,PRE_POSOLOGIE_PRESCRIRE) VALUE('"+medicament.getDepotLegal()+"','"+medicament.getListePrescription().get(i).getIndividuCode()+"','"+medicament.getListePrescription().get(i).getListeDosage().get(j).getCode()+"','"+medicament.getListePrescription().get(i).getPosologie()+"')");
				}
			}
			for(int i=0;i<medicament.getListePerturbe().size();i++){
				bdd.executerRequeteUpdate("INSERT INTO interagir(MED_DEPOTLEGAL_MEDICAMENT,MED_DEPOTLEGAL_MEDICAMENT_INTERAGIR) VALUE('"+medicament.getDepotLegal()+"','"+medicament.getListePerturbe().get(i)+"')");
			}
			for(int i=0;i<medicament.getListePerturbateur().size();i++){
				bdd.executerRequeteUpdate("INSERT INTO interagir(MED_DEPOTLEGAL_MEDICAMENT,MED_DEPOTLEGAL_MEDICAMENT_INTERAGIR) VALUE('"+medicament.getListePerturbateur().get(i)+"','"+medicament.getDepotLegal()+"')");
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
    
    public int delete(CMedicament medicament) {
        String req = "DELETE FROM medicament WHERE MED_DEPOTLEGAL_MEDICAMENT="+medicament.getDepotLegal()+";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate("DELETE FROM constituer WHERE MED_DEPOTLEGAL_MEDICAMENT="+medicament.getDepotLegal()+";");
            res = bdd.executerRequeteUpdate("DELETE FROM formuler WHERE MED_DEPOTLEGAL_MEDICAMENT="+medicament.getDepotLegal()+";");
            res = bdd.executerRequeteUpdate("DELETE FROM interagir WHERE MED_DEPOTLEGAL_MEDICAMENT="+medicament.getDepotLegal()+";");
            res = bdd.executerRequeteUpdate("DELETE FROM interagir WHERE MED_DEPOTLEGAL_MEDICAMENT_INTERAGIR="+medicament.getDepotLegal()+";");
            res = bdd.executerRequeteUpdate("DELETE FROM prescrire WHERE MED_DEPOTLEGAL_MEDICAMENT="+medicament.getDepotLegal()+";");
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
	public int delete(int depotLegal) {
        String req = "DELETE FROM medicament WHERE MED_DEPOTLEGAL_MEDICAMENT="+depotLegal+";";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate("DELETE FROM constituer WHERE MED_DEPOTLEGAL_MEDICAMENT="+depotLegal+";");
            res = bdd.executerRequeteUpdate("DELETE FROM formuler WHERE MED_DEPOTLEGAL_MEDICAMENT="+depotLegal+";");
            res = bdd.executerRequeteUpdate("DELETE FROM interagir WHERE MED_DEPOTLEGAL_MEDICAMENT="+depotLegal+";");
            res = bdd.executerRequeteUpdate("DELETE FROM interagir WHERE MED_DEPOTLEGAL_MEDICAMENT_INTERAGIR="+depotLegal+";");
            res = bdd.executerRequeteUpdate("DELETE FROM prescrire WHERE MED_DEPOTLEGAL_MEDICAMENT="+depotLegal+";");
            res = bdd.executerRequeteUpdate(req);
            System.out.println("Res = " + res);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
	
    public int update(CMedicament medicament) {
        //int index=-1;
        /*for (int i = 0; i < listePersonnels.size(); i++) {
            if(personnel.getMatricule().equals(listePersonnels.get(i).getMatricule())){
                System.out.println("Le nouveau matricule éxiste déjà.");
                return -1;
            }
            else if(oldMatricule.equals(listePersonnels.get(i).getMatricule()))
                index=i;
        }*/
        /*if(index==-1){
            System.out.println("Le matricule n'a pas été trouvé.");
            return -1;
        }*/

		//gestion des modif d'arraylist like listeComposant
		/*CMedicament tmpMed=getMedicament(medicament.getDepotLegal());
		if(tmpMed.getListeComposant().equals(medicament.getListeComposant())){
			System.out.println("EQUAL COMPONENTSS///§§§!!!!");
		}
		else{
			System.out.println("UNNNNNNEQUALLLLL");
		}
		String req = "UPDATE medicament SET"
                + " MED_NOMCOMMERCIAL_MEDICAMENT='"+((medicament.getNomCommercial()==null)?"":medicament.getNomCommercial().trim().replace("'", "''"))
                +"', MED_COMPOSITION_MEDICAMENT='"+((medicament.getComposition()==null)?"":medicament.getComposition().trim().replace("'", "''"))
                +"', MED_EFFETS_MEDICAMENT='"+((medicament.getEffets()==null)?"":medicament.getEffets().trim().replace("'", "''"))
                +"',MED_CONTREINDIC_MEDICAMENT='"+((medicament.getContreIndic()==null)?"":medicament.getContreIndic().trim().replace("'", "''"))
                +"',MED_PRIXECHANTILLON_MEDICAMENT='"+medicament.getPrixEchantillon()
                +"',FAM_CODE_FAMILLE='"+medicament.getFamilleCode()
                +"' where MED_DEPOTLEGAL_MEDICAMENT='"+medicament.getDepotLegal()+"';";
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
        return res;*/
		int res=delete(medicament);
		res=insert(medicament);
		return res;
    }
    
    public int load() {
        int res = -1;
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
            ResultSet rs=bdd.executerRequeteQuery("SELECT *,FAM_LIBELLE_FAMILLE FROM medicament,famille WHERE famille.FAM_CODE_FAMILLE=medicament.FAM_CODE_FAMILLE;");
            try {
                while(rs.next()){
                    this.listeMedicament.add(rs_to_medicament(rs));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableMedicament.class.getName()).log(Level.SEVERE, null, ex);
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
	
    public CMedicament getMedicament(int depotLegal){
		CMedicament medicament=null;
        if (bdd.connecter() == true) {
            //ArrayList<CPersonnels> liste=new ArrayList();
			ResultSet rs=bdd.executerRequeteQuery("SELECT *,FAM_LIBELLE_FAMILLE FROM medicament,famille WHERE famille.FAM_CODE_FAMILLE=medicament.FAM_CODE_FAMILLE AND medicament.MED_DEPOTLEGAL_MEDICAMENT="+depotLegal+";");
			try {
                while(rs.next()){
                    medicament=rs_to_medicament(rs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTableMedicament.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return medicament;
    }
    
    public CMedicament rs_to_medicament(ResultSet rs) throws SQLException{
        CMedicament medicament=new CMedicament();
        medicament.setDepotLegal(rs.getInt("MED_DEPOTLEGAL_MEDICAMENT"));
        medicament.setNomCommercial(rs.getString("MED_NOMCOMMERCIAL_MEDICAMENT"));
        medicament.setComposition(rs.getString("MED_COMPOSITION_MEDICAMENT"));
        medicament.setEffets(rs.getString("MED_EFFETS_MEDICAMENT"));
        medicament.setContreIndic(rs.getString("MED_CONTREINDIC_MEDICAMENT"));
        medicament.setPrixEchantillon(rs.getFloat("MED_PRIXECHANTILLON_MEDICAMENT"));
        medicament.setFamilleCode(rs.getInt("FAM_CODE_FAMILLE"));
        medicament.setFamilleLabel(rs.getString("FAM_LIBELLE_FAMILLE"));
		
		if (bdd.connecter() == true) {
			ResultSet rsInteraction=bdd.executerRequeteQuery("SELECT * FROM interagir WHERE MED_DEPOTLEGAL_MEDICAMENT="+medicament.getDepotLegal()+" OR MED_DEPOTLEGAL_MEDICAMENT_INTERAGIR="+medicament.getDepotLegal()+";");
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
		}
		else{
            System.out.println("Connexion KO");
		}
		
		medicament.setListeComposant(this.tableComposant.fetchComposant(medicament.getDepotLegal()));
		medicament.setListePrescription(this.tablePrescription.fetchPrescription(medicament.getDepotLegal()));
		medicament.setListePresentation(this.tablePresentation.fetchPresentation(medicament.getDepotLegal()));
        return medicament;
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

    public ArrayList<CMedicament> getListeMedicament() {
        return listeMedicament;
    }

   /*public void setListePersonnels(ArrayList<CPersonnels> listePersonnels) {
        this.listePersonnels = listePersonnels;
    }*/
}

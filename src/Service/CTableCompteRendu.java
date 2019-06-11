/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CMedicament;
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
public class CTableCompteRendu {
	protected CBDD bdd;
    //protected ArrayList<CMedicament> listeMedicament=new ArrayList();
	protected CTableComposant tableComposant;
	protected CTablePrescription tablePrescription;
	protected CTablePresentation tablePresentation;
	//protected CTableFamille tableFamille=new CTableFamille();
    
    public CTableCompteRendu(){
        //this.loadMedicament();
    }
	
	public CTableCompteRendu(CBDD bdd){
        this.bdd=bdd;
		//this.load();
    }
    
	public int insert(String matriculeVis, int idPraticien, String date, String motif, String bilan) {
        String req="INSERT INTO rapport_visite(RAP_DATE_RAPPORT_VISITE,RAP_BILAN_RAPPORT_VISITE,RAP_MOTIF_RAPPORT_VISITE,VIS_MATRICULE_VISITEUR,PRA_NUM_PRATICIEN) value('"
				+date+"','"
				+bilan+"','"
				+motif+"','"
				+matriculeVis+"','"
				+idPraticien+"');";
        int res = -1;
        if (bdd.connecter() == true) {
            res = bdd.executerRequeteUpdate(req);
			/*for(int i=0;i<medicament.getListeComposant().size();i++){
				//this.tableComposant.insert(medicament.getListeComposant().get(i));
				bdd.executerRequeteUpdate("INSERT INTO constituer(MED_DEPOTLEGAL_MEDICAMENT,CMP_CODE_COMPOSANT,CST_QTE_CONSTITUER,CST_UNITE_CONSTITUER) VALUE('"+medicament.getDepotLegal()+"','"+medicament.getListeComposant().get(i).getCode()+"','"+medicament.getListeComposant().get(i).getQuantite()+"','"+medicament.getListeComposant().get(i).getUnite()+"')");
			}*/
            System.out.println("Res = " + res);
            bdd.deconnecter();
            //--------------Reload Table after inserting---------
            //this.listePersonnel();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
	
	public int getLastCR(){
		String req = "SELECT * FROM rapport_visite ORDER BY RAP_NUM_RAPPORT_VISITE DESC;";
        int res = -1;
        if (bdd.connecter() == true) {
            ResultSet rs=bdd.executerRequeteQuery(req);
			try{
				rs.next();
				res=rs.getInt("RAP_NUM_RAPPORT_VISITE");
			}catch(SQLException ex){
				Logger.getLogger(CTableCompteRendu.class.getName()).log(Level.SEVERE, null, ex);
			}
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
	}
   
	/*
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
    }*/
    
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
}

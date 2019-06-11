/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe;

import Entite.CComposant;
import Entite.CDosage;
import Entite.CMedicament;
import Entite.COffre;
import Entite.CPrescription;
import Entite.CPresentation;
import Service.CTableComposant;
import Service.CTableDosage;
import Service.CTableMedicament;
import Service.CTableOffre;
import Service.CTablePrescription;
import Service.CTablePresentation;
import Service.CTableVisiteur;
import bdd.CBDD;
import bdd.CParametresStockageBDD;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class PPE {
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//--Creation acces a bdd
		CBDD bdd=new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
		
		//---Initialise les table avec leur dépendance
		CTableOffre tableOffre=new CTableOffre(bdd);
		CTableDosage tableDosage=new CTableDosage(bdd);
		CTablePresentation tablePresentation=new CTablePresentation(bdd);
		CTableComposant tableComposant=new CTableComposant(bdd);
		CTablePrescription tablePrescription=new CTablePrescription(bdd,tableDosage);
		CTableMedicament tableMedicament=new CTableMedicament(bdd,tableComposant,tablePrescription,tablePresentation);
		
		
		
		/*tableMedicament.load();
		ArrayList<CMedicament> meds=tableMedicament.getListeMedicament();
		CMedicament m=tableMedicament.getMedicament(123456789);
		m.setDepotLegal(987654321);
		tableMedicament.delete(987654321);
		tableMedicament.insert(m);
		*/
		
		/*tableMedicament.load();
		ArrayList<CMedicament> meds=tableMedicament.getListeMedicament();
		for(int i=0;i<meds.size();i++){
			System.out.println("Med :--------");
			System.out.println("depot legal: "+meds.get(i).getDepotLegal());
			System.out.println("Nom com: "+meds.get(i).getNomCommercial());
			System.out.println("Comp: "+meds.get(i).getComposition());
			System.out.println("Contre Indic: "+meds.get(i).getContreIndic());
		}
		tableDosage.load();
		ArrayList<CDosage> dos=tableDosage.getListeDosage();
		tablePrescription.load();
		ArrayList<CPrescription> prescr=tablePrescription.getListePrescription();
		tablePresentation.load();
		ArrayList<CPresentation> presen=tablePresentation.getListePresentation();
		tableComposant.load();
		ArrayList<CComposant> comp=tableComposant.getListeComposant();
		tableOffre.load();
		ArrayList<COffre> off=tableOffre.getListeOffre();
		*/
		
		//----------TEST Medicament---------------
		/*CMedicament med=new CMedicament();
		med.setComposition("comp1:2ml,comp2,3mg");
		med.setDepotLegal(105);
		med.setFamilleCode(1);
		
		//med.setContreIndic("azeaze");
		//med.setEffets("zeazeeeee");
		//med.setPrixEchantillon(33000.1f);
		tableComposant.load();
		ArrayList<CComposant> listComp=new ArrayList();
		listComp.add(tableComposant.getListeComposant().get(0));
		//listComp.add(tableComposant.getListeComposant().get(1));
		med.setListeComposant(listComp);
	*/
		//tableMedicament.insert(med);
	/*	med.setNomCommercial("nomCommercial");
		tableMedicament.update(med);
	*/
		//CMedicament med1=tableMedicament.getListeMedicament().get(1);
		
		//tableMedicament.update(med1);

		//-----------TEST COMPOSANT------------
		//ArrayList<CComposant> liste=tableComposant.getListeComposant();
		//liste=tableComposant.getListeComposant();
		
		System.out.println("FIN");
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.COffre;
import Entite.CPraticien;
import Service.CTableCompteRendu;
import Service.CTableOffre;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class CRapport {
	private CTableCompteRendu tableCompteRendu;
	private CTableOffre tableOffre;
	
	public CRapport(){
	}	
	
	public CRapport(CTableCompteRendu tableCr, CTableOffre tableOffre){
		this.tableCompteRendu=tableCr;
		this.tableOffre=tableOffre;
	}
	
	public int createCR(String matriculeVisiteur, int numPraticien, String date, String motif, String bilan, ArrayList<COffre> offre){
		int numRapport=-1;
		if(this.tableCompteRendu.insert(matriculeVisiteur, numPraticien, date, motif, bilan)==1){
			numRapport=this.tableCompteRendu.getLastCR();
			for (int i = 0; i < offre.size(); i++) {
				this.tableOffre.insert(offre.get(i),numRapport);
			}
		}
		return numRapport;
	}
}

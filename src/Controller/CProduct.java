/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entite.CMedicament;
import Service.CTableMedicament;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class CProduct {
	private CTableMedicament tableMedicament;
	private ArrayList<CMedicament> listMedicament;
	
	public CProduct(){
	}	
	
	public CProduct(CTableMedicament tableMedicament){
		this.tableMedicament=tableMedicament;
	}
	
	public void listeProduct(DefaultTableModel model){
		this.listMedicament=tableMedicament.load();
		
		for (int i = 0; i < listMedicament.size(); i++) {
			model.addRow(new Object[]{listMedicament.get(i).getDepotLegal(),listMedicament.get(i).getNomCommercial(),listMedicament.get(i).getPrixEchantillon()});
		}
	}
}

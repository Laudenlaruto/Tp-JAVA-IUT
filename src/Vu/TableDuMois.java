package Vu;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Modele.Date;

public class TableDuMois extends JTable{
Date dateAuj = new Date();
	
	public TableDuMois(){
		
	//	TableModel model = new DefaultTableModel(dateAuj.dernierJourDuMois(dateAuj.getDateMois(), dateAuj.getDateAn()), 10);
		JTable table = new JTable(30,10);
		
	}
}

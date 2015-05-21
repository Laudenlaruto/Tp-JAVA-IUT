package Vu;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Modele.Agenda;
import Modele.Date;
import Modele.Evt;
import Modele.EvtHelper;

public class TableDuMois extends DefaultTableModel{
	
	public TableDuMois(Agenda chAgenda, int moisCourant){
		int nbJour = Date.dernierJourDuMois(moisCourant, 2015);
		setColumnCount(nbJour);
		setRowCount(10);
		String [] entete = new String [nbJour];
		
		for (int i = 0;i<nbJour;i++)
			entete[i]=Integer.toString(i+1);
		setColumnIdentifiers(entete);
		// TODO Ajouter une exception dans l'agenda pour limiter le nombre d'evt par jour a 10
		for (int i = 0; i <= nbJour;i++ ){	
			List<Evt>  list = EvtHelper.extractListEvt(chAgenda.getChMap(), moisCourant, i);	
			int j = 0;
			for (Evt evt : list) {
				if (evt.getEvtJour()==i)
						setValueAt(evt, j, i-1);
				j++;
			}
		}

		}
	
	
}

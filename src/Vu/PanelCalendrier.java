package Vu;
import java.awt.*;

import javax.swing.*;

import Modele.BoutonDate;
import Modele.Date;
import Modele.ExceptAgenda;

import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class PanelCalendrier extends JPanel implements ActionListener
{
	int index =0;
	JPanel PanelNorth = new JPanel();
	JPanel PanelCentre = new JPanel();
	JPanel PanelSud = new JPanel();
	JButton bouton = new JButton("Précedent");
	JButton bouton2 = new JButton("Suivant");
	GregorianCalendar dateAuj = new GregorianCalendar();
	CardLayout Diapo = new CardLayout(25,25);
	String Titres[] =  {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Decembre"};
	BoutonDate boutonDates;
	JLabel NomMois = new JLabel(Titres[index]);
	BoutonDate oldBouton = null;
	PanelEvenement panelEvementLocal;
	public PanelCalendrier(PanelEvenement parPaneEve)
	{  
		panelEvementLocal = parPaneEve;
		this.setLayout( new BorderLayout());
		this.add(PanelCentre, BorderLayout.CENTER);
		PanelCentre.setLayout(Diapo);
		
		for (int i = 1; i <= Titres.length; i++) {
			int NombreJour = Date.dernierJourDuMois(i, 2015);
			JPanel PanelCalendrier = new JPanel();
			PanelCalendrier.setLayout(new GridLayout(0,7));
			for (int j = 1; j <= NombreJour; j++){
				try {
					boutonDates= new BoutonDate(new Date(j,i,dateAuj.get(Calendar.YEAR)));
					boutonDates.addActionListener(this);
					PanelCalendrier.add(boutonDates);

				} catch (ExceptAgenda e) {
					System.out.println(e.getMessage());
				}
				
			}
			Diapo.addLayoutComponent(PanelCalendrier,Titres[i-1]);
			PanelCentre.add(PanelCalendrier);
		}
		
		
		this.add(PanelNorth,BorderLayout.NORTH);
		PanelNorth.add(NomMois);
		PanelSud.add(bouton);
		PanelSud.add(bouton2);
		bouton.addActionListener(this);
		bouton2.addActionListener(this);
		this.add(PanelSud, BorderLayout.SOUTH);
		PanelSud.setBackground( new Color ( 0,255,255));
		PanelNorth.setBackground( new Color ( 0,255,255));
		Diapo.show(PanelCentre,Titres[dateAuj.get(Calendar.MONTH)]);
		index = dateAuj.get(Calendar.MONTH);
		NomMois.setText(Titres[index]);
	}
	public void actionPerformed (ActionEvent parEvt)
	{ 
		if (parEvt.getSource() == bouton){
			Diapo.previous(PanelCentre);
			if ( index !=0)
				index --;
			else 
				index = Titres.length-1;
			NomMois.setText(Titres[index]);
		}
		else if (parEvt.getSource() == bouton2){
			Diapo.next(PanelCentre);
			if ( index !=Titres.length-1)
				index ++;
			else 
				index = 0;
			NomMois.setText(Titres[index]);
		}
		
		else
		{	
			BoutonDate boutonDate = (BoutonDate)parEvt.getSource();
			panelEvementLocal.setDate(boutonDate.getDate());
			if (oldBouton != null)
				oldBouton.setCouleurs();
			
			boutonDate.setBackground(Color.GREEN);
			oldBouton = boutonDate;
		}
		
	}		
}

	


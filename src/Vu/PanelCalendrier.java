package Vu;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.BoutonDate;
import Modele.Date;
import Modele.ExceptAgenda;


public class PanelCalendrier extends JPanel implements ActionListener
{
	
	int index =0;
	JPanel PanelNorth = new JPanel();
	JPanel PanelCentre = new JPanel();
	JPanel PanelSud = new JPanel();
	JPanel PanelCal = new JPanel();
	
	
	JButton bouton = new JButton("Pr�cedent");
	JButton bouton2 = new JButton("Suivant");
	GregorianCalendar dateAuj = new GregorianCalendar();
	JLabel chAnnee = new JLabel(String.valueOf(dateAuj.get(Calendar.YEAR)));
	
	CardLayout Diapo = new CardLayout(25,25);
	String Titres[] =  {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Ao�t","Septembre","Octobre","Novembre","Decembre"};
	BoutonDate boutonDates;
	JLabel NomMois = new JLabel(Titres[index]);
	BoutonDate oldBouton = null;
	PanelEvenement panelEvementLocal;
	Font font = new Font(Font.SERIF,Font.PLAIN,80);
	public PanelCalendrier(PanelEvenement parPaneEve)
	{  
		panelEvementLocal = parPaneEve;
		this.setLayout(new GridLayout(0,2));
		PanelCal.setLayout( new BorderLayout());
		
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
		
		
		PanelCal.add(PanelNorth,BorderLayout.NORTH);
		PanelNorth.add(NomMois);
		PanelSud.add(bouton);
		PanelSud.add(bouton2);
		bouton.addActionListener(this);
		bouton2.addActionListener(this);
		PanelCal.add(PanelSud, BorderLayout.SOUTH);
		Diapo.show(PanelCentre,Titres[dateAuj.get(Calendar.MONTH)]);
		index = dateAuj.get(Calendar.MONTH);
		NomMois.setText(Titres[index]);
		chAnnee.setFont(font);
		chAnnee.setHorizontalAlignment(JLabel.CENTER);
		this.add(chAnnee);
		PanelCal.add(PanelCentre);
		this.add(PanelCal);
	}
	public void actionPerformed (ActionEvent parEvt)
	{ 
		if (parEvt.getSource() == bouton){
			Diapo.previous(PanelCentre);
			if ( index !=0)
				index --;
			else 
				index = Titres.length-1;
			
			panelEvementLocal.chTable.setModel(new TableDuMois(panelEvementLocal.agenda, index +1));// TODO cr�er un seter
			NomMois.setText(Titres[index]);
			panelEvementLocal.indexEvt=index+1;
		}
		else if (parEvt.getSource() == bouton2){
			Diapo.next(PanelCentre);
			if ( index !=Titres.length-1)
				index ++;
			else 
				index = 0;
			
			panelEvementLocal.chTable.setModel(new TableDuMois(panelEvementLocal.agenda, index+1 ));// TODO cr�er un seter
			NomMois.setText(Titres[index]);
			panelEvementLocal.indexEvt=index+1;
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

	


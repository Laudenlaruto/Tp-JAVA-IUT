package Vu;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Fichier.Fichier;
import Modele.Agenda;
import Modele.Date;
import Modele.Evt;


public class PanelEvenement extends JPanel implements ActionListener {
	JLabel labelDate;
	JButton ajout = new JButton("+");
	Agenda agenda = new Agenda();   
	JLabel titre = new JLabel("Titre");
	JTextArea atitre = new JTextArea();
	JLabel lieu = new JLabel("Lieu");
	JTextArea alieu = new JTextArea();
	String [] heures = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
	String [] minutes = {"0","10","20","30","40","50"};
	JLabel debut = new JLabel("Début");
	JComboBox heureDebut = new JComboBox(heures);
	JLabel sep1 = new JLabel(":");
	JComboBox minDebut = new JComboBox(minutes);
	JLabel fin = new JLabel("Fin");
	JComboBox heureFin = new JComboBox(heures);
	JLabel sep2 = new JLabel(":");
	JComboBox minFin = new JComboBox(minutes);
	JLabel des = new JLabel("Description");
	JTextArea ades = new JTextArea(5,5);
	JPanel pan = new JPanel();
	GridBagLayout Gridbag = new GridBagLayout();	
	GridBagConstraints c = new GridBagConstraints(); 
	JTextArea visualisationAgenda = new JTextArea();
	Date dateLocal = new Date();
	File file = new File("Agenda");
	public PanelEvenement(){
		Date today = new Date();
		this.setLayout(new GridLayout(0,2));
		pan.setLayout(Gridbag);
		c.insets = new Insets(10,10,10,10);
		c.fill = GridBagConstraints.HORIZONTAL;
		//--------
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=3;
		labelDate = new JLabel(today.toString());
		pan.add(labelDate,c);
		c.gridwidth = 1;
		c.gridx = 4;
		pan.add(ajout,c);
		ajout.setBackground(new Color(255,51,51));
		ajout.addActionListener(this);
		//---------
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 2;
		pan.add(titre,c);
		c.gridx = 2;
		c.gridwidth = 3;
		atitre.setBorder(border);
		pan.add(atitre,c);
		//--------
		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 2;
		pan.add(lieu,c);
		c.gridx = 2;
		c.gridwidth = 3;
		alieu.setBorder(border);
		pan.add(alieu,c);
		//------------------------------------------------------------
		c.gridwidth = 1;
		c.gridy = 3;
		c.gridx = 0;
		pan.add(debut,c);
		c.gridx = 2;
		pan.add(heureDebut,c);
		c.gridx = 3;
		pan.add(sep1,c);
		c.gridx=4;
		pan.add(minDebut,c);
		//------
		c.gridy = 4;
		c.gridx = 0;
		pan.add(fin,c);
		c.gridx = 2;
		pan.add(heureFin,c);
		c.gridx = 3;
		pan.add(sep2,c);
		c.gridx=4;
		pan.add(minFin,c);
		//------------
		c.gridy =5;
		c.gridx = 0;
		pan.add(des,c);
		//-------
		c.gridy = 6;
		c.gridheight=3;
		c.gridwidth=5;
		ades.setBorder(border);
		pan.add(ades,c);
		
		this.add(pan);		visualisationAgenda.setEditable(false);
		//this.add(visualisationAgenda);
		
		JScrollPane table = new JScrollPane(new TableDuMois());
		this.add(table);
		
		
		
		
		
		
		
		agenda = (Agenda)Fichier.lecture(file);
		if (agenda != null)
				visualisationAgenda.setText(Fichier.lecture(file).toString());
	
	}

	
	public void setDate(Date parDate){
		dateLocal = parDate;
		labelDate.setText(parDate.toString());
	}


	public void actionPerformed(ActionEvent parEvt) {
		if (parEvt.getSource() == ajout){
			if ( atitre.getText().length() !=0 && alieu.getText().length() !=0  ){
				agenda.ajout(dateLocal.toString(),new Evt(dateLocal, atitre.getText(),alieu.getText()));
				Fichier.ecriture(file, agenda);
			}
		}
		visualisationAgenda.setText(agenda.toString());
	}

}

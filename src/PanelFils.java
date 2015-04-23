import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class PanelFils extends JPanel{
	Agenda a = new Agenda();
	PanelEvenement panelEvenement = new PanelEvenement(a);
	PanelCalendrier panelCalendrier = new PanelCalendrier(panelEvenement);
	public PanelFils (){
		this.setLayout(new GridLayout(0,2));
		this.add(panelCalendrier);
		this.add(panelEvenement);
	}

}
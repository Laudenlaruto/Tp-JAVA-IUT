import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class PanelFils extends JPanel{
	Agenda a = new Agenda();
	
	public PanelFils (){
		a.ajout("0", new Evt(new Date(), "Today","Home"));
		a.ajout("01", new Evt(new Date(), "Today","Aqui"));
		a.ajout("02", new Evt(new Date(), "Today","Home"));
		a.ajout("03", new Evt(new Date(), "Today","Home"));
		a.ajout("04", new Evt(new Date(), "Today","Home"));
		a.ajout("05", new Evt(new Date(), "Today","Home"));
		PanelEvenement panelEvenement = new PanelEvenement(a);
		PanelCalendrier panelCalendrier = new PanelCalendrier(panelEvenement);
		this.setLayout(new GridLayout(0,2));
		this.add(panelCalendrier);
		this.add(panelEvenement);
	}

}

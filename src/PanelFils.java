import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class PanelFils extends JPanel{
	
	public PanelFils (){
		PanelEvenement panelEvenement = new PanelEvenement();
		PanelCalendrier panelCalendrier = new PanelCalendrier(panelEvenement);
		this.setLayout(new GridLayout(0,2));
		this.add(panelCalendrier);
		this.add(panelEvenement);
	}

}

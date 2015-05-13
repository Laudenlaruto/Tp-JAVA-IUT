package Vu;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;


public class PanelFils extends JPanel{
	
	public PanelFils (){
		PanelEvenement panelEvenement = new PanelEvenement();
		PanelCalendrier panelCalendrier = new PanelCalendrier(panelEvenement);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints(); 
		c.gridx = 1;
		c.gridy = 0;
		this.add(panelCalendrier,c);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		this.add(panelEvenement,c);
		this.setBackground(new Color(0,255,255));
	}

}

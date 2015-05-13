package Modele;
import java.awt.Color;
import java.util.GregorianCalendar;

import javax.swing.JButton;


public class BoutonDate extends JButton{

	private Date date;
	private boolean estDateCourante;
	private boolean estDateWeekEnd;
	GregorianCalendar dateAuj = new GregorianCalendar();
	Date dateLocal;
	public BoutonDate(Date parDate){
		
		super(String.valueOf(parDate.getDateJour()));
		JButton bouton = new JButton(String.valueOf(parDate.getDateJour()));
		date = parDate;
		Date aujourdhui = new Date();
		
		if (parDate.getNumSemaine()== 1 || parDate.getNumSemaine() == 7)
			estDateWeekEnd = true;
		else
			estDateWeekEnd = false;
		
		if(parDate.getDateJour()==aujourdhui.getDateJour() && parDate.getDateMois() == aujourdhui.getDateMois() && parDate.getDateAn() == aujourdhui.getDateAn())
			estDateCourante = true ;	
		else 
			estDateCourante = false;
		this.setCouleurs();
		
		dateLocal = date;
	}
	
	public Date getDate(){
		return dateLocal;
	}
	public void setCouleurs(){
		if (estDateCourante){
			this.setForeground(Color.WHITE);
			this.setBackground(Color.RED);
		}
		else if(estDateWeekEnd){
			this.setForeground(Color.BLUE);
			this.setBackground(Color.ORANGE);
		}
		else{
			this.setForeground(Color.RED);
			this.setBackground(Color.WHITE);
		}
	}
}

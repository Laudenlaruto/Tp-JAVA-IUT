package Modele;
import java.io.Serializable;

public class Evt implements Serializable
{
private Date chDate;
private String chTitre;
private String chLieu;
private static int chNbr = 0;

		public Evt(Date parDate, String parTitre, String parLieu)
		{
			chDate = parDate;
			chTitre = parTitre;
			chLieu = parLieu;
			chNbr ++;
		}
	/*	public Evt ()
		{
			chDate = new Date();
			chTitre = Clavier.lireString();
			chLieu= Clavier.lireString();
		}
		public static Evt saisirEvt() throws ExceptAgenda
		{
			Date d = Date.lireDate() ;
			//System.out.println("Le Titre:");
			String titre = "titre";
			//System.out.println("Le lieu:");
			String lieu = "lieu";
			return new Evt(d,titre,lieu);
		}*/
		public int getNbr()
		{
			return chNbr;
		}
		public String toString()
		{
			return (chTitre + "\n"+ " - " +"\n"+ chLieu);
		}
		public String getTitre()
		{
			return chTitre;
		}
		public void setTitre (String parTitre)
		{
			chTitre = parTitre;
		}
		public void setDate (Date parDate)
		{
			chDate = parDate;
		}
		public void setLieu(String parLieu)
		{
			chLieu = parLieu;
		}
		public int getEvtAn()
		{
			return chDate.getDateAn();
		}
		public int getEvtMois()
		{
			return chDate.getDateMois();
		}
		public int getEvtJour()
		{
			return chDate.getDateJour();
		}
		int precede(Evt parEvt)
		{
			if (chDate.precede(parEvt.chDate)== -1)
				return -1;
			else if (chDate.precede(parEvt.chDate) == 1)
				return 1;
			else 
			{
				if (chTitre.compareTo(parEvt.chTitre) >0)
					return -1;
				else if (chTitre.compareTo(parEvt.chTitre) <0)
					return 1;
				else
					return 0;
			}
		}
}
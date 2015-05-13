package Modele;
 import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Date implements Serializable
{
	private int chJour; //Champ&Attribut
	private int chMois;
	private int chAn;
	private String chJourSemaine; 
	private int chNumSemaine;
	private String chMoisAnnee;
	String[] JourDeSemaine = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
	String[] moisDeLannee = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Decembre"};
	//Tableau des jours de la semaine pour se servir de la fonction get day of week de Greogrian calendar. (-1 parcque tableau commence a 0)

		/**
		 * Constructeur par Défault qui renvoie la date courante
		 */
		public Date ()
		{
			GregorianCalendar dateAuj = new GregorianCalendar();
			chAn = dateAuj.get(Calendar.YEAR);
			chMois = dateAuj.get(Calendar.MONTH)+1;
			chJour = dateAuj.get(Calendar.DAY_OF_MONTH);
			chJourSemaine = JourDeSemaine[dateAuj.get(Calendar.DAY_OF_WEEK)-1];
			chNumSemaine = dateAuj.get(Calendar.DAY_OF_WEEK);
			chMoisAnnee = moisDeLannee[chMois-1];
		}
	/**
	 * Construcuteur avec Parametre qui renvoie la date grace a l'anné le mois et le jour	
	 * @param parJour
	 * @param parMois
	 * @param parAn
	 * @throws ExceptAgenda
	 */
		public Date (int parJour, int parMois, int parAn) throws ExceptAgenda
		{
			
			chJour=parJour;
			chMois=parMois;
			chAn=parAn;
			if (estValide() == false)
				throw new ExceptAgenda("Date invalide");
			
			/*Calendar c = Calendar.getInstance();
			c.set(chAn,chMois-1,chJour);*/
			GregorianCalendar date = new GregorianCalendar(chAn, chMois - 1, chJour);
			chNumSemaine = date.get(Calendar.DAY_OF_WEEK);
			chJourSemaine = JourDeSemaine[chNumSemaine-1];
			chMoisAnnee = moisDeLannee[chMois-1];
		}
		
		
		
		
		
	//Constructeur entrer au clavier
		public static Date lireDate() throws ExceptAgenda
		{
			StringTokenizer t = new StringTokenizer(Clavier.lireString(),"-");
			String Jour = t.nextToken();
			String Mois = t.nextToken();
			String Annee = t.nextToken();
			int J = Integer.parseInt(Jour);
			int M = Integer.parseInt(Mois);
			int A = Integer.parseInt(Annee);
			return new Date(J,M,A);
		}	
		
	public String toString()
	{
		return( chJourSemaine +" "+chJour+" "+chMoisAnnee+" "+chAn);
	}
	public int getDateAn()
	{
		return chAn;
	}
	public int getDateMois()
	{
		return chMois;
	}
	public int getDateJour()
	{
		return chJour;
	}
	public String getJourSemaine()
	{
		return chJourSemaine;
	}
	public int getNumSemaine(){
		return chNumSemaine;
	}
	public static int dernierJourDuMois(int parMois, int parAn)
	{
		switch(parMois)
			{
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if ((parAn%4==0 && parAn%100!=0) || parAn%400==0)
				return 29;
				else 
				return 28;
			default:
				return 31;
			}
	}

	public boolean estValide()
	{
		if (chAn<1582)
			return false;
		if (chMois<1 || chMois >12)
			return false;
		if (chJour<1 || chJour > dernierJourDuMois(chMois,chAn))
			return false;
		return true;
	}

	
	public int precede(Date parDate)
	{
		if(this.chAn > parDate.chAn)
			return -1;
		if(this.chAn < parDate.chAn)
			return 1;
			if(this.chMois > parDate.chMois)
				return -1;
			if(this.chMois < parDate.chMois)
				return 1;
				if(this.chJour > parDate.chJour)
				return -1;
				if(this.chJour < parDate.chJour)
				return 1;
	return 0;
	}
	
	public Date dateDuLendemain() throws ExceptAgenda
	{
		int jour = chJour, mois = chMois, an = chAn;
		if (jour == dernierJourDuMois(mois, an))
		{
			jour = 1;
			if (mois == 12)
			{
				mois=1;
				an+=1;
			}
			else
				mois += 1;
		}
		else 
		{
			jour += 1;
		}
		
		return new Date(jour, mois, an);
	}
	
	public Date dateDeLaVeille() throws ExceptAgenda
	{
		int jour = chJour, mois = chMois, an = chAn;
		if (jour == 1)
		{
			if (mois == 1)
			{
				mois = 12;
				an -= 1;
				jour = dernierJourDuMois(mois,an);
			}
			else
			{
				mois -= 1;
				jour = dernierJourDuMois(mois,an);
			}
		}
		else
			jour -= 1;
			
		return new Date(jour, mois, an);
	}
}
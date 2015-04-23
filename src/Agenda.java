import java.util.*;
import java.util.Map.Entry;


public class Agenda
{
	
	private HashMap<String,ArrayList<Evt>> chMap;
	public Agenda()
	{
		chMap = new HashMap<String,ArrayList<Evt>>();
		
	}
	public String toString()
	{
		String message = new String();
		/*Set<Entry<String,ArrayList<Evt>>> entree = chMap.entrySet();
		Iterator <Entry<String,ArrayList<Evt>>> iterator = entree.iterator();
		while (iterator.hasNext())
		{
			//message+=iterator.next()+"\n";
			message += 
		}*/
		
		Set <String> mesCles = chMap.keySet();
		for (String cle :mesCles)
		{
			//message += cle + " : " + chMap.get(cle);
			ArrayList liste = chMap.get(cle); 
			for (int i=0; i<liste.size(); i++)
			{
				Evt e = (Evt)liste.get(i);
				message +=  cle +" - " +e.toString() +" \n";
			}
		}
		return(message);
	}
	public void ajout(String parCle, Evt parEvt)
	{
		if (chMap.containsKey(parCle))
		{
			chMap.get(parCle).add(parEvt);
		}
		else
		{
			ArrayList newListe = new ArrayList<Evt>();
			newListe.add(parEvt);
			chMap.put(parCle,newListe);
		}
	}
}
//caca
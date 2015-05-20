package Modele;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvtHelper {

	
	public static List<Evt> extractListEvt(HashMap<Date,ArrayList<Evt>> map,Date parDate){
		for (Date Cle : map.keySet()) {
			
			if (Cle.getDateMois() == parDate.getDateMois()){
				return map.get(Cle);
			}
		}
		
	return new ArrayList<Evt>();
	}
}

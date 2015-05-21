package Modele;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvtHelper {

	
	public static List<Evt> extractListEvt(HashMap<Date,ArrayList<Evt>> map,int moisCourant, int jourCourant){
		for (Date Cle : map.keySet()) {
			
			if (Cle.getDateMois() == moisCourant){
				if (Cle.getDateJour()== jourCourant)
					return map.get(Cle);
			}
		}
		
	return new ArrayList<Evt>();
	}
}

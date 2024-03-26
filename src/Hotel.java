import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.plaf.nimbus.State;
class non_presente_bdd extends Exception {
    private String message = "l'article que vous cherchez n'est pas présent à notre bdd verifiez svp";
	//hna j crois nst3mlou les interface graphic ten khir 
    public String getMessage() {
        return message;
    }
}

class deja_presente_bdd extends Exception {
    private String message = "l'article que vous faite entrer est deja present a notre bdd";
	//hna j crois nst3mlou les interface graphic ten khir 
    public String getMessage() {
        return message;
    }
}
public class Hotel {

	private static HashMap<Integer, Chambre> chambreMap = new HashMap<>();
	private static HashMap<Integer, User> userMap = new HashMap<>();
	private static HashMap<Integer, Reservation> reservationMap = new HashMap<>();

	// get Hashmap
	public static HashMap<Integer, Chambre> getChambreMap() {
		return chambreMap;
	}

	public static HashMap<Integer, User> getUserMap() {
		return userMap;
	}

	public static HashMap<Integer, Reservation> getReservationMap() {
		return reservationMap;
	}
	
	//une fonction pour vérifier si un utilisateur existe dans déja:
	static boolean findUser(String name, String password) {
		for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
			User user = entry.getValue();
			if (user.getName().equals(name) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	static void AjouterChambreMap(Chambre chambre) throws deja_presente_bdd {// la meme chose han kima ajoutusermap
		if (!chambreMap.containsKey(chambre.getId())) {
			chambreMap.put(chambre.getId(), chambre);
		} else {
			throw new deja_presente_bdd();
			// erreur existe deja
		}

	}

	static void AjouterUserMap(User user) throws deja_presente_bdd {//had l fcnt mafhemtch wch fayda ta3ha
		if (!userMap.containsKey(user.getId())) {					//ki izid user mayhmch esq existe wla lala psq l'id li raho f bdd
			userMap.put(user.getId(), user);						//raho auto-increment tsema jamais tel9a 3andhom meme id
		} else {
			throw new deja_presente_bdd();
			// erreur
		}
	}

	static void AjouterReservationMap(Reservation reservation) throws deja_presente_bdd{// la meme chose hna kima ajout user Mapss
		if (!reservationMap.containsKey(reservation.getId())) {
			reservationMap.put(reservation.getId(), reservation);
		} else {
		throw new deja_presente_bdd();
		}
	}
	static void AjtResMap(Reservation reservation){
		reservationMap.put(reservation.getId(), reservation);
		//chaque fois en appelle cette fonction AjtResMap(Reservation reservation) 
		//en doit appeller la ajouter une instance a la classe classgenerique
	}

	static void AjtUserMap(User user){
		userMap.put(user.getId(), user);
		//chaque fois en appelle cette fonction AjtResMap(User user) 
		//en doit appeller la ajouter une instance a la classe classgenerique
	}

	// modification sur les hashmap
	static void SupprimerChambreMap(Chambre chambre) throws non_presente_bdd {
		if (chambreMap.containsKey(chambre.getId())) {
			chambreMap.remove(chambre.getId());
		} else {
			throw new non_presente_bdd();
		}

	}

	static void SupprimerUserMap(User user) throws non_presente_bdd {
		if (userMap.containsKey(user.getId())) {
			userMap.remove(user.getId());
		} else {
			throw new non_presente_bdd();
		}

	}

	static void SupprimerReservationMap(Reservation reservation) throws non_presente_bdd {
		if (reservationMap.containsKey(reservation.getId())) {
			reservationMap.remove(reservation.getId());
		} else {
			throw new non_presente_bdd();
		}

	}

	static void ModifierChambreMap(Chambre chambrenew) throws non_presente_bdd {
		if (chambreMap.containsKey(chambrenew.getId())) {
			chambreMap.replace(chambrenew.getId(), chambrenew);
		} else {
			throw new non_presente_bdd();
		}

	}

	static void ModifierReservationMap(Reservation reservation) throws non_presente_bdd {
		if (reservationMap.containsKey(reservation.getId())) {
			reservationMap.replace(reservation.getId(), reservation);
		} else {
			throw new non_presente_bdd();
		}
	}

	static Chambre RechercheChambreParId(int id) {
		if (chambreMap.containsKey(id)) {
			return chambreMap.get(id);
		} else {
			// erreur jsp si on throw une err ou pas tbenlna f la suite
			return null;
		}

	}

	static User RechercheuserParId(int id) {
		if (userMap.containsKey(id)) {
			return userMap.get(id);
		} else {
			// erreur jsp si on throw une err ou pas tbenlna f la suite
			return null;
		}

	}

	static Reservation RechercheResevationParId(int id) {
		if (reservationMap.containsKey(id)) {
			return reservationMap.get(id);
		} else {
			// err jsp si on throw une err ou pas tbenlna f la suite
			return null;
		}

	}


	static boolean ChambreDispo(Chambre chambre, Date datedebut, Date datefin) {

		Iterator<Map.Entry<Integer, Reservation>> iterator = reservationMap.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Reservation> entry = iterator.next();
			Reservation reservation = entry.getValue();

			if (reservation.getId_user() == chambre.getId()) {
				if (!Date.DateCoincidePas(datedebut, datefin, reservation.getDateDebut(), reservation.getDateFin())) {
					return false;
				}

			}

		}
		return true;
	}

	static Chambre attribuerchambre(TypeChambre type, Date date1, Date date2) throws non_presente_bdd {
		Iterator<Map.Entry<Integer, Chambre>> iterator = chambreMap.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Chambre> entry = iterator.next();
			Chambre chambre = entry.getValue();
			if (chambre.getType() == type) {
				boolean nonreserve = ChambreDispo(chambre, date1, date2);
				if (nonreserve) {
					chambre.setReservedatleastonce(1);
					GestionOperation.ModifierOpsChambreMap(chambre);
					return chambre;
				}

			}
		}
		return null;
	}

}

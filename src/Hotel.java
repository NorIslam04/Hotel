import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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

	private static HashMap<Integer,ModificationHotel<?, ?>> modificationMap = new HashMap<>();

	// get Hashmap
	

	public static HashMap<Integer, Chambre> getChambreMap() {
		return chambreMap;
	}

	public static HashMap< Integer,ModificationHotel<?, ?>> getModificationMap() {
		return modificationMap;
	}

	public static void setModificationMap(HashMap<Integer,ModificationHotel<?, ?>> modificationMap) {
		Hotel.modificationMap = modificationMap;
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
	
	static boolean findEmail(String name, String password,String email) {
		// Parcourir la HashMap d'utilisateurs
		for (Entry<Integer, User> entry : userMap.entrySet()) {
			User user = entry.getValue();
			// Vérifier si le nom d'utilisateur et le mot de passe correspondent
			if (user.getName().equals(name) && user.getPassword().equals(password) && user.getGmail().equals(email)) {
				return true; // Correspondance trouvée
			}
		}
		return false; // Aucune correspondance trouvée
	}
	

	static void AjouterChambreMap(Chambre chambre) throws deja_presente_bdd {// la meme chose han kima ajoutusermap
		chambreMap.put(chambre.getId(), chambre);
	}
	static void AjtChambreMap(Chambre chambre) throws deja_presente_bdd {// la meme chose han kima ajoutusermap
		chambreMap.put(chambre.getId(), chambre);
		ModificationHotel<Chambre, TypeOperation> ajouterChambre = new ModificationHotel<>(chambre.getId(),chambre,TypeOperation.AJOUT );
		modificationMap.put(ModificationHotel.getNb(),ajouterChambre);
		
	}

	static void AjouterUserMap(User user) throws deja_presente_bdd {	
		userMap.put(user.getId(), user);						
	}
	
	static void AjtUserMap(User user) throws deja_presente_bdd {	
		userMap.put(user.getId(), user);						
		ModificationHotel<User, TypeOperation> ajouterUser = new ModificationHotel<>(user.getId(),user,TypeOperation.AJOUT );
		modificationMap.put(ModificationHotel.getNb(),ajouterUser);
	}


	static void AjouterReservationMap(Reservation reservation) throws deja_presente_bdd{// la meme chose hna kima ajout user Mapss
		reservationMap.put(reservation.getId(), reservation);
		
	}
	
	static void AjtReservationMap(Reservation reservation) throws deja_presente_bdd{// la meme chose hna kima ajout user Mapss
		reservationMap.put(reservation.getId(), reservation);
		ModificationHotel<Reservation, TypeOperation> ajouterReservation = new ModificationHotel<>(reservation.getId(),reservation,TypeOperation.AJOUT );
		modificationMap.put(ModificationHotel.getNb(),ajouterReservation);
	}
	

	// modification sur les hashmap
	static void SupprimerChambreMap(Chambre chambre) throws non_presente_bdd {
		if (chambreMap.containsKey(chambre.getId())) {
			chambreMap.remove(chambre.getId());
			ModificationHotel<Chambre, TypeOperation> suppChambre = new ModificationHotel<>(chambre.getId(),chambre,TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(),suppChambre);
		} else {
			throw new non_presente_bdd();
		}

	}

	static void SupprimerUserMap(User user) throws non_presente_bdd {
		if (userMap.containsKey(user.getId())) {
			userMap.remove(user.getId());
			ModificationHotel<User, TypeOperation> suppUser = new ModificationHotel<>(user.getId(),user,TypeOperation.SUPPRESSION );
			modificationMap.put(ModificationHotel.getNb(),suppUser);
		} else {
			throw new non_presente_bdd();
		}

	}

	static void SupprimerReservationMap(Reservation reservation) throws non_presente_bdd {
		if (reservationMap.containsKey(reservation.getId())) {
			reservationMap.remove(reservation.getId());
			ModificationHotel<Reservation, TypeOperation> suppReservation = new ModificationHotel<>(reservation.getId(),reservation,TypeOperation.SUPPRESSION );
			modificationMap.put(ModificationHotel.getNb(),suppReservation);
		} else {
			throw new non_presente_bdd();
		}

	}

	static void ModifierChambreMap(Chambre chambre) throws non_presente_bdd {
		if (chambreMap.containsKey(chambre.getId())) {
			chambreMap.replace(chambre.getId(), chambre);
			ModificationHotel<Chambre, TypeOperation> modifChambre = new ModificationHotel<>(chambre.getId(),chambre,TypeOperation.MODIFICATION);
			modificationMap.put(ModificationHotel.getNb(),modifChambre);

		} else {
			throw new non_presente_bdd();
		}

	}

	static void ModifierReservationMap(Reservation reservation) throws non_presente_bdd {
		if (reservationMap.containsKey(reservation.getId())) {
			reservationMap.replace(reservation.getId(), reservation);
			ModificationHotel<Reservation, TypeOperation> modifReservation = new ModificationHotel<>(reservation.getId(),reservation,TypeOperation.MODIFICATION );
			modificationMap.put(ModificationHotel.getNb(),modifReservation);
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
					GestionOperation.ModifierOpsChambreMap(chambre);
					return chambre;
				}

			}
		}
		return null;
	}

}

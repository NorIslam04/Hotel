import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

	static void AjouterChambreMap(Chambre chambre) {
		if (!chambreMap.containsKey(chambre.getId())) {
			chambreMap.put(chambre.getId(), chambre);
		} else {

			// erreur existe deja
		}

	}

	static void AjouterUserMap(User user) {
		if (!userMap.containsKey(user.getId())) {
			userMap.put(user.getId(), user);
		} else {
			// erreur
		}
	}

	static void AjouterReservationMap(Reservation reservation) {
		if (!reservationMap.containsKey(reservation.getId())) {
			reservationMap.put(reservation.getId(), reservation);
		} else {
			// err
		}
	}

	// modification sur les hashmap
	static void SupprimerChambreMap(Chambre chambre) {
		if (chambreMap.containsKey(chambre.getId())) {
			chambreMap.remove(chambre.getId());
		} else {
			// erreur
		}

	}

	static void SupprimerUserMap(User user) {
		if (userMap.containsKey(user.getId())) {
			userMap.remove(user.getId());
		} else {
			// err
		}

	}

	static void SupprimerReservationMap(Reservation reservation) {
		if (reservationMap.containsKey(reservation.getId())) {
			reservationMap.remove(reservation.getId());
		} else {
			// erreur
		}

	}

	static void ModifierChambreMap(Chambre chambrenew) {
		if (chambreMap.containsKey(chambrenew.getId())) {
			chambreMap.replace(chambrenew.getId(), chambrenew);
		} else {
			// erreur
		}

	}

	static void ModifierReservationMap(Reservation reservation) {
		if (reservationMap.containsKey(reservation.getId())) {
			reservationMap.replace(reservation.getId(), reservation);
		} else {
			// erreur
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
			if (reservation.getChambre().getId() == chambre.getId()) {
				if (!Date.DateCoincidePas(datedebut, datefin, reservation.getDateDebut(), reservation.getDateFin())) {
					return false;
				}

			}

		}
		return true;
	}

	static Chambre attribuerchambre(TypeChambre type, Date date1, Date date2) {
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

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
		chambreMap.put(chambre.getId(), chambre);
	}

	static void AjouterUserMap(User user) {
		userMap.put(user.getId(), user);
	}

	static void AjouterReservationMap(Reservation reservation) {
		reservationMap.put(reservation.getId(), reservation);
	}

	// modification sur les hashmap
	static void SupprimerChambreMap(Chambre chambre) {
		chambreMap.remove(chambre.getId());
	}

	static void SupprimerUserMap(User user) {
		userMap.remove(user.getId());
	}

	static void SupprimerReservationMap(Reservation reservation) {
		reservationMap.remove(reservation.getId());
	}

	static void ModifierChambreMap(Chambre chambrenew) {
		chambreMap.replace(chambrenew.getId(), chambrenew);
	}

	static void ModifierReservationMap(int id, Reservation reservation) {
		reservationMap.replace(id, reservation);
	}

	static boolean ChambreDispo(Chambre chambre, Date datedebut, Date datefin) {
		Iterator<Map.Entry<Integer, Reservation>> iterator = reservationMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Reservation> entry = iterator.next();
			Reservation reservation = entry.getValue();
			if (reservation.getIdUser() == chambre.getId()) {
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
					chambre.setsetReservedatleastonce(1);
					GestionOperation.ModifierOpsChambreMap(chambre);
					return chambre;
				}

			}
		}
		return null;
	}

	void recherchechambredispo(String type) {
	}

}

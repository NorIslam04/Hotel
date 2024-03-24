import java.util.HashMap;
//hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiihih

public class Hotel{

private static HashMap<Integer,Chambre> chambreMap = new HashMap<>();
private static HashMap<Integer,User> userMap = new HashMap<>();
private static HashMap<Integer,Reservation> reservationMap = new HashMap<>();


//get Hashmap 
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
		chambreMap.put(chambre.getId(),chambre);
	}
	
	static void AjouterUserMap(User user) {
	     userMap.put(user.getId(), user);
	}

	static void AjouterReservationMap(Reservation reservation ) {
	     reservationMap.put(reservation.getId(),reservation);
	}
	 
	 
	//modification sur les hashmap
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
	
	static void ModifierReservationMap(int id,Reservation reservation) {
		reservationMap.replace(id,reservation);
	}
	
	void recherchechambredispo(String type) {
		}


	
}

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

	private static HashMap<Integer,ModificationHotel<?>> modificationMap = new HashMap<>();

	// get Hashmap
	
	static void ajouterModificationHotel(Object objet,TypeOperation type){
	
		
			if(objet instanceof User ){
				User user=(User)objet;
					modificationMap.put(Integer.parseInt(String.valueOf(user.getId()) + String.valueOf(user.getNbOp())),
					new ModificationHotel<User>(user.getId(),user,type));
					modifierMap(user, type);
					user.setNbOp(user.getNbOp() + 1);
				}else{
					if (objet instanceof Chambre) {
						Chambre chambre=(Chambre)objet;
						modificationMap.put(Integer.parseInt(String.valueOf(chambre.getId()) + String.valueOf(chambre.getNbOp())),
					new ModificationHotel<Chambre>(chambre.getId(),chambre,type));
					modifierMap(chambre,type);
					chambre.setNbOp(chambre.getNbOp() + 1);
						
					}
					else{//reservation
						Reservation reservation=(Reservation)objet;
						modificationMap.put(Integer.parseInt(String.valueOf(reservation.getId()) + String.valueOf(reservation.getNbOp())),
					new ModificationHotel<Reservation>(reservation.getId(),reservation,type));
					modifierMap(reservation, type);
					reservation.setNbOp(reservation.getNbOp() + 1);
						
					}
				}
				
		
		

	}

	public static void modifierMap(Object o,TypeOperation T){//fonction principale
		if(T==TypeOperation.AJOUT){
			ajouterobjetmap(o);

		}if(T==TypeOperation.MODIFICATION){
			modifierobjetmap(o);

		}if(T==TypeOperation.SUPPRESSION){
			supprimerobjetmap(o);
			
		}

	}
	static void ajouterobjetmap(Object o){//secondaire
		if(o instanceof User){
			User user = (User) o; 
			userMap.put(user.getId(), user);
		}
		else if(o instanceof Chambre){
			Chambre chambre = (Chambre) o; // Cast 
			chambreMap.put(chambre.getId(), chambre);
		}
		else if(o instanceof Reservation){
			Reservation reservation = (Reservation) o; // 
			reservationMap.put(reservation.getId(), reservation);
		}

	}
	static void modifierobjetmap(Object o){//secondaire
		if(o instanceof User){
			User user = (User) o; 
			userMap.replace(user.getId(), user);
		}
		else if(o instanceof Chambre){
			Chambre chambre = (Chambre) o; // Cast 
			chambreMap.replace(chambre.getId(), chambre);
		}
		else if(o instanceof Reservation){
			Reservation reservation = (Reservation) o; // 
			reservationMap.replace(reservation.getId(), reservation);
		}

	}
	static void supprimerobjetmap(Object o){//secondaire
		if(o instanceof User){
			User user = (User) o; 
			userMap.remove(user.getId());
		}
		else if(o instanceof Chambre){
			Chambre chambre = (Chambre) o; // Cast 
			chambreMap.remove(chambre.getId(), chambre);
		}
		else if(o instanceof Reservation){
			Reservation reservation = (Reservation) o; // 
			reservationMap.remove(reservation.getId(), reservation);
		}

	}

	
	public static HashMap<Integer, Chambre> getChambreMap() {
		return chambreMap;
	}

	public static HashMap< Integer,ModificationHotel<?>> getModificationMap() {
		return modificationMap;
	}

	public static void setModificationMap(HashMap<Integer,ModificationHotel<?>> modificationMap) {
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
				Hotel.modifierMap(chambre, TypeOperation.MODIFICATION);
					return chambre;
				}

			}
		}
		return null;
	}

}

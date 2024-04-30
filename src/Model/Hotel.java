package Model;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum TypeOperation {
	AJOUT,
	SUPPRESSION,
	MODIFICATION

}

class non_presente_bdd extends Exception {
	private String message = "l'article que vous cherchez n'est pas présent à notre bdd verifiez svp";

	// hna j crois nst3mlou les interface graphic ten khir
	public String getMessage() {
		return message;
	}
} class deja_presente_bdd extends Exception {
	private String message = "l'article que vous faite entrer est deja present a notre bdd";

	// hna j crois nst3mlou les interface graphic ten khir
	public String getMessage() {
		return message;
	}
}

public class Hotel {

	static int id_user_current;
	static int totalRating;
	static int langue; //0 ang 1 fr
	static String username_current;
	
	
	
    static boolean reserveoption=false;

	private static HashMap<Integer, Chambre> chambreMap = new HashMap<>();
	private static HashMap<Integer, User> userMap = new HashMap<>();
	private static HashMap<Integer, Reservation> reservationMap = new HashMap<>();
	private static HashMap<Integer, Commentaires> commentairesMap = new HashMap<>();
	private static HashMap<Integer, Option> optionHashMap = new HashMap<>();

	private static HashMap<Integer, ModificationHotel<?, ?>> modificationMap = new HashMap<>();

	// get set Hashmap

	public static HashMap<Integer, Chambre> getChambreMap() {
		return chambreMap;
	}

	public static void setChambreMap(HashMap<Integer, Chambre> chambreMap) {
		Hotel.chambreMap = chambreMap;
	}

	public static void setUserMap(HashMap<Integer, User> userMap) {
		Hotel.userMap = userMap;
	}

	public static HashMap<Integer, Option> getOptionHashMap() {
		return optionHashMap;
	}

	public static void setOptionHashMap(HashMap<Integer, Option> optionHashMap) {
		Hotel.optionHashMap = optionHashMap;
	}

	public static void setReservationMap(HashMap<Integer, Reservation> reservationMap) {
		Hotel.reservationMap = reservationMap;
	}

	public static HashMap<Integer, ModificationHotel<?, ?>> getModificationMap() {
		return modificationMap;
	}

	public static void setModificationMap(HashMap<Integer, ModificationHotel<?, ?>> modificationMap) {
		Hotel.modificationMap = modificationMap;
	}

	public static HashMap<Integer, User> getUserMap() {
		return userMap;
	}

	public static HashMap<Integer, Reservation> getReservationMap() {
		return reservationMap;
	}

	// une fonction pour vérifier si un utilisateur existe dans déja:
	static boolean findUser(String name, String password) {
		for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
			User user = entry.getValue();
			if (user.getName().equals(name) && user.getPassword().equals(password)) {
				id_user_current = user.getId();
				username_current=user.getName();
				return true;
				
			}
		}
		return false;
	}

	static boolean findEmail(String name, String password, String email) {
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


    //fct ajt hashmap:

	static void AjouterChambreMap(Chambre chambre) throws deja_presente_bdd {// la meme chose han kima ajoutusermap
		chambreMap.put(chambre.getId(), chambre);
	}

	static void AjtChambreMap(Chambre chambre) throws deja_presente_bdd {// la meme chose han kima ajoutusermap
		chambreMap.put(chambre.getId(), chambre);
		ModificationHotel<Chambre, TypeOperation> ajouterChambre = new ModificationHotel<>(chambre.getId(), chambre,
				TypeOperation.AJOUT);
		modificationMap.put(ModificationHotel.getNb(), ajouterChambre);

	}

	static void AjouterUserMap(User user) throws deja_presente_bdd {
		userMap.put(user.getId(), user);
	}

	static void AjtUserMap(User user) throws deja_presente_bdd {
		userMap.put(user.getId(), user);
		ModificationHotel<User, TypeOperation> ajouterUser = new ModificationHotel<>(user.getId(), user,
				TypeOperation.AJOUT);
		modificationMap.put(ModificationHotel.getNb(), ajouterUser);
	}

	static void AjouterReservationMap(Reservation reservation) throws deja_presente_bdd {// la meme chose hna kima ajout
																							// user Mapss
		reservationMap.put(reservation.getId(), reservation);

	}

	static void AjtReservationMap(Reservation reservation) throws deja_presente_bdd {// la meme chose hna kima ajout
																						// user Mapss
		reservationMap.put(reservation.getId(), reservation);
		ModificationHotel<Reservation, TypeOperation> ajouterReservation = new ModificationHotel<>(reservation.getId(),
				reservation, TypeOperation.AJOUT);
		modificationMap.put(ModificationHotel.getNb(), ajouterReservation);
	}

	static void AjouterCommentaireMap(Commentaires commentaires) throws deja_presente_bdd {// la meme chose hna kima
																							// ajout user Mapss
		commentairesMap.put(commentaires.getId(), commentaires);

	}
	static void AjtCommentaireMap(Commentaires commentaires){
		commentairesMap.put(commentaires.getId(), commentaires);
		ModificationHotel<Commentaires, TypeOperation> ajoutercmtrMap = new ModificationHotel<>(
				commentaires.getId(), commentaires, TypeOperation.AJOUT);

		modificationMap.put(ModificationHotel.getNb(), ajoutercmtrMap);
	}

	static void AjtOptionMap(Option option) throws deja_presente_bdd {// la meme chose hna kima ajout
																						// user Mapss
		optionHashMap.put(option.getId(), option);
		ModificationHotel<Option, TypeOperation> ajouteroptMap = new ModificationHotel<>(
				option.getId(), option, TypeOperation.AJOUT);

		modificationMap.put(ModificationHotel.getNb(), ajouteroptMap);
	}

	static void AjouterOptionMap(Option option) {
	optionHashMap.put(option.getId(), option);
	}



	// supp hashmap:

	static void SupprimeroptionMap(Option option) throws non_presente_bdd {
		if (optionHashMap.containsKey(option.getId())) {
			optionHashMap.remove(option.getId());
			ModificationHotel<Option, TypeOperation> suppop= new ModificationHotel<>(option.getId(), option,
					TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppop);
		} else {
			throw new non_presente_bdd();
		}

	}

	static void SupprimerChambreMap(Chambre chambre) throws non_presente_bdd {
		if (chambreMap.containsKey(chambre.getId())) {
			chambreMap.remove(chambre.getId());
			ModificationHotel<Chambre, TypeOperation> suppChambre = new ModificationHotel<>(chambre.getId(), chambre,
					TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppChambre);
		} else {
			throw new non_presente_bdd();
		}

	}

	static void SupprimerUserMap(User user) throws non_presente_bdd {
		if (userMap.containsKey(user.getId())) {
			userMap.remove(user.getId());
			ModificationHotel<User, TypeOperation> suppUser = new ModificationHotel<>(user.getId(), user,
					TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppUser);
		} else {
			throw new non_presente_bdd();
		}

	}

	static void SupprimerCommentaireMap(Commentaires commentaires) throws non_presente_bdd {
		if (commentairesMap.containsKey(commentaires.getId())) {
			commentairesMap.remove(commentaires.getId());
			ModificationHotel<Commentaires, TypeOperation> suppcmntr = new ModificationHotel<>(commentaires.getId(),
					commentaires, TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppcmntr);
		} else {
			throw new non_presente_bdd();
		}

	}

	static void SupprimerReservationMap(Reservation reservation) throws non_presente_bdd {
		if (reservationMap.containsKey(reservation.getId())) {
			reservationMap.remove(reservation.getId());
			ModificationHotel<Reservation, TypeOperation> suppReservation = new ModificationHotel<>(reservation.getId(),
					reservation, TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppReservation);
		} else {
			throw new non_presente_bdd();
		}

	}


		//modif hashmap:
	static void ModifieroptionMap(Option option) throws non_presente_bdd {
		if (optionHashMap.containsKey(option.getId())) {
			optionHashMap.replace(option.getId(), option);

			ModificationHotel<Option, TypeOperation> modifopt = new ModificationHotel<>(option.getId(), option,
					TypeOperation.MODIFICATION);
			modificationMap.put(ModificationHotel.getNb(), modifopt);

		} else {
			throw new non_presente_bdd();
		}

	}

	static void ModifierChambreMap(Chambre chambre) throws non_presente_bdd {
		if (chambreMap.containsKey(chambre.getId())) {
			chambreMap.replace(chambre.getId(), chambre);
			ModificationHotel<Chambre, TypeOperation> modifChambre = new ModificationHotel<>(chambre.getId(), chambre,
					TypeOperation.MODIFICATION);
			modificationMap.put(ModificationHotel.getNb(), modifChambre);

		} else {
			throw new non_presente_bdd();
		}

	}

	static void ModifierCmntrMap(Commentaires commentaire) throws non_presente_bdd {
		if (commentairesMap.containsKey(commentaire.getId())) {
			commentairesMap.replace(commentaire.getId(), commentaire);
			ModificationHotel<Commentaires, TypeOperation> modifcmntr = new ModificationHotel<>(commentaire.getId(),
					commentaire, TypeOperation.MODIFICATION);
			modificationMap.put(ModificationHotel.getNb(), modifcmntr);

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
	static void ModifierUserMap(User user) throws non_presente_bdd{
		
		if (userMap.containsKey(user.getId())) {
			userMap.replace(user.getId(), user);
			ModificationHotel<User, TypeOperation> modifUser = new ModificationHotel<>(user.getId(),user,TypeOperation.MODIFICATION );
			modificationMap.put(ModificationHotel.getNb(),modifUser);
		} else {
			throw new non_presente_bdd();
		}
	}



	//fct:

	public static boolean verif_email(String chaine) {
        // Expression régulière pour correspondre à "@.....com"
        String pattern = "@.{4,}\\.com$";
        // Créer un objet Pattern à partir de l'expression régulière
        Pattern p = Pattern.compile(pattern);
        // Créer un objet Matcher pour rechercher la correspondance dans la chaîne
        Matcher m = p.matcher(chaine);
        // Retourne true si la chaîne correspond au pattern, sinon false
        return m.find();
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

	static boolean verifchambreavecoption(Chambre chambre, TypeChambre type, boolean sona, boolean terasse,
			boolean vuesurmer, boolean vuesurforet) {

		if (type == chambre.getType()) {
			if ((!chambre.isTERASSE() && terasse) || (!chambre.isSONA() && sona)
					|| (!chambre.isVuesurforet() && vuesurforet) || (!chambre.isVuesurmere() && vuesurmer)) {
				return false;

			}
			return true;
		} else {
			return false;
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

	static boolean chambreAafficher(Chambre chambre, TypeChambre type, Date datedebut, Date datefin, boolean tv,
			boolean climatisation, boolean vuesurforet, boolean vuesurmer) {
		if (ChambreDispo(chambre, datedebut, datefin)
				&& verifchambreavecoption(chambre, type, tv, climatisation, vuesurmer, vuesurforet)) {
			return true;
		}
		return false;
	}

	static Chambre attribuerchambre(TypeChambre type, Date date1, Date date2) throws non_presente_bdd {
		Iterator<Map.Entry<Integer, Chambre>> iterator = chambreMap.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Chambre> entry = iterator.next();
			Chambre chambre = entry.getValue();
			if (chambre.getType() == type) {
				boolean nonreserve = ChambreDispo(chambre, date1, date2);
				if (nonreserve) {

					return chambre;
				}

			}
		}
		return null;
	}

	public static float calculernotehotel() {
		int nbruserrated = 1;
		float totalrating = 5;
		Iterator<Map.Entry<Integer, User>> iterator = userMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, User> entry = iterator.next();
			User user = entry.getValue();
			if (user.getNote() != -1) {
				totalrating = totalrating + user.getNote();
				nbruserrated++;
			}

		}
		totalrating = totalrating / nbruserrated;
		return totalrating; // TODO;initialiser
	}

	public static HashMap<Integer, Commentaires> getCommentairesMap() {
		return commentairesMap;
	}

	public static void setCommentairesMap(HashMap<Integer, Commentaires> commentairesMap) {
		Hotel.commentairesMap = commentairesMap;
	}



	public static void afficherHashMap(int i) {
        switch (i) {
            case 1:
                for (Map.Entry<Integer, User> entry : Hotel.getUserMap().entrySet()) {
                    int id = entry.getKey();
                    User user = entry.getValue();

                    System.out.println("ID: " + id);
                    System.out.println("Name: " + user.getName());
                    System.out.println("Email :" + user.getGmail());
                    System.out.println("Password: " + user.getPassword());
                    System.out.println("note : "+user.getNote()+"/5");
                    System.out.println("----------------------");
                }
                break;

            case 2:
                for (Map.Entry<Integer, Chambre> entry : Hotel.getChambreMap().entrySet()) {
                    int id = entry.getKey();
                    Chambre chambre = entry.getValue();

                    System.out.println("ID: " + id);
                    System.out.println("Nombre de lits: " + chambre.getNbLit());
                    System.out.println("Type: " + chambre.getType());
                    System.out.println("Prix: " + chambre.getPrix());
                    System.out.println("SONA -> "+chambre.isSONA());
                    System.out.println("TERASSE  -> "+chambre.isTERASSE());
                    System.out.println("VUESURMERE  -> "+chambre.isVuesurmere());
                    System.out.println("VUESURFORET -> "+chambre.isVuesurforet());
                    System.out.println("----------------------");
                }
                break;
            case 3:
                for (Map.Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
                    int id = entry.getKey();
                    Reservation reservation = entry.getValue();

                    System.out.println("ID: " + id);
                    System.out.println("ID User: " + reservation.getId_user());
                    System.out.println("Type: " + reservation.getType());
                    System.out.println("Date de début: " + reservation.getDateDebut());
                    System.out.println("Date de fin: " + reservation.getDateFin());
                    System.out.println("NbrJourResrvation: " + reservation.getNbrJourReservation());
                    System.out.println("ID Chambre: " + reservation.getId_chambre());
                    System.out.println("État: " + reservation.getEtat());
                    System.out.println("Prix: "+reservation.getPrix());
                    System.out.println("----------------------");
                }
                break;
                case 4:
                for (Map.Entry<Integer, Commentaires> entry : Hotel.getCommentairesMap().entrySet()) {
                    int id = entry.getKey();
                    Commentaires commentaire = entry.getValue();
                    System.out.println("ID: " + id);
                    System.out.println("Commentaire: " + commentaire.getCommentaire());
                    System.out.println("Username: " + commentaire.getUsername());
                    System.out.println("ID utilisateur: " + commentaire.getIduser());
                    System.out.println("Date: " + commentaire.getDate());
                    System.out.println("------------------------");
                }

                break;
            case 5:

            for (Map.Entry<Integer, Option> entry : Hotel.getOptionHashMap().entrySet()) {
                int id = entry.getKey();
                Option option = entry.getValue();
        
                System.out.println("ID: " + id);
                System.out.println("Nom de l'option: " + option.getRooms_Options());
                System.out.println("Prix de l'option: " + option.getPrix_option());
                System.out.println("----------------------");
            }
            break;

            default:
                System.out.println("hashMap n'existe pas !");
                break;
        }

    }

}
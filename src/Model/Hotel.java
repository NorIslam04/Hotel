package Model;
import Model.Chambre.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Hotel {

	public enum TypeOperation {
		AJOUT,
		SUPPRESSION,
		MODIFICATION
	
	}

	public static int id_user_current;
	public static int totalRating;
	public static int langue; //0 ang 1 fr
	public static String username_current;
	public static int neew=0;
	
	
	
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
	public static boolean findUser(String name, String password) {
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

	public static boolean findEmail(String name, String password, String email) {
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

	public static void AjouterChambreMap(Chambre chambre) {// la meme chose han kima ajoutusermap
		chambreMap.put(chambre.getId(), chambre);
	}

	public static void AjtChambreMap(Chambre chambre) {// la meme chose han kima ajoutusermap
		chambreMap.put(chambre.getId(), chambre);
		ModificationHotel<Chambre, TypeOperation> ajouterChambre = new ModificationHotel<>(chambre.getId(), chambre,
				TypeOperation.AJOUT);
		modificationMap.put(ModificationHotel.getNb(), ajouterChambre);

	}

	public static void AjouterUserMap(User user) {
		userMap.put(user.getId(), user);
	}

	public static void AjtUserMap(User user) {
		userMap.put(user.getId(), user);
		ModificationHotel<User, TypeOperation> ajouterUser = new ModificationHotel<>(user.getId(), user,
				TypeOperation.AJOUT);
		modificationMap.put(ModificationHotel.getNb(), ajouterUser);
	}

	public static void AjouterReservationMap(Reservation reservation)  {// la meme chose hna kima ajout
																							// user Mapss
		reservationMap.put(reservation.getId(), reservation);

	}

	public static void AjtReservationMap(Reservation reservation) {// la meme chose hna kima ajout
																						// user Mapss
		reservationMap.put(reservation.getId(), reservation);
		ModificationHotel<Reservation, TypeOperation> ajouterReservation = new ModificationHotel<>(reservation.getId(),
				reservation, TypeOperation.AJOUT);
		modificationMap.put(ModificationHotel.getNb(), ajouterReservation);
	}

	public static void AjouterCommentaireMap(Commentaires commentaires){// la meme chose hna kima
																							// ajout user Mapss
		commentairesMap.put(commentaires.getId(), commentaires);

	}
	public static void AjtCommentaireMap(Commentaires commentaires){
		commentairesMap.put(commentaires.getId(), commentaires);
		ModificationHotel<Commentaires, TypeOperation> ajoutercmtrMap = new ModificationHotel<>(
				commentaires.getId(), commentaires, TypeOperation.AJOUT);

		modificationMap.put(ModificationHotel.getNb(), ajoutercmtrMap);
	}

	public static void AjtOptionMap(Option option){// la meme chose hna kima ajout
																						// user Mapss
		optionHashMap.put(option.getId(), option);
		ModificationHotel<Option, TypeOperation> ajouteroptMap = new ModificationHotel<>(
				option.getId(), option, TypeOperation.AJOUT);

		modificationMap.put(ModificationHotel.getNb(), ajouteroptMap);
	}

	public static void AjouterOptionMap(Option option) {
	optionHashMap.put(option.getId(), option);
	}



	// supp hashmap:

	public static void SupprimeroptionMap(Option option)  {
		if (optionHashMap.containsKey(option.getId())) {
			optionHashMap.remove(option.getId());
			ModificationHotel<Option, TypeOperation> suppop= new ModificationHotel<>(option.getId(), option,
					TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppop);
		} 

	}

	public static void SupprimerChambreMap(Chambre chambre)  {
		if (chambreMap.containsKey(chambre.getId())) {
			chambreMap.remove(chambre.getId());
			ModificationHotel<Chambre, TypeOperation> suppChambre = new ModificationHotel<>(chambre.getId(), chambre,
					TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppChambre);
		} 

	}

	public static void SupprimerUserMap(User user) {
		if (userMap.containsKey(user.getId())) {
			userMap.remove(user.getId());
			ModificationHotel<User, TypeOperation> suppUser = new ModificationHotel<>(user.getId(), user,
					TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppUser);
		} 

	}

	public static void SupprimerCommentaireMap(Commentaires commentaires) {
		if (commentairesMap.containsKey(commentaires.getId())) {
			commentairesMap.remove(commentaires.getId());
			ModificationHotel<Commentaires, TypeOperation> suppcmntr = new ModificationHotel<>(commentaires.getId(),
					commentaires, TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppcmntr);
		} 

	}

	public static void SupprimerReservationMap(Reservation reservation) {
		if (reservationMap.containsKey(reservation.getId())) {
			reservationMap.remove(reservation.getId());
			ModificationHotel<Reservation, TypeOperation> suppReservation = new ModificationHotel<>(reservation.getId(),
					reservation, TypeOperation.SUPPRESSION);
			modificationMap.put(ModificationHotel.getNb(), suppReservation);
		} else{
			System.out.println("existe pas! dnas Map reservation");
		}

	}


		//modif hashmap:


	public static void ModifieroptionMap(Option option){
		if (optionHashMap.containsKey(option.getId())) {
			optionHashMap.replace(option.getId(), option);

			ModificationHotel<Option, TypeOperation> modifopt = new ModificationHotel<>(option.getId(), option,
					TypeOperation.MODIFICATION);
			modificationMap.put(ModificationHotel.getNb(), modifopt);

		}
	}

	public static void ModifierChambreMap(Chambre chambre) {
		if (chambreMap.containsKey(chambre.getId())) {
			chambreMap.replace(chambre.getId(), chambre);
			ModificationHotel<Chambre, TypeOperation> modifChambre = new ModificationHotel<>(chambre.getId(), chambre,
					TypeOperation.MODIFICATION);
			modificationMap.put(ModificationHotel.getNb(), modifChambre);

		} 

	}

	public static void ModifierCmntrMap(Commentaires commentaire) {
		if (commentairesMap.containsKey(commentaire.getId())) {
			commentairesMap.replace(commentaire.getId(), commentaire);
			ModificationHotel<Commentaires, TypeOperation> modifcmntr = new ModificationHotel<>(commentaire.getId(),
					commentaire, TypeOperation.MODIFICATION);
			modificationMap.put(ModificationHotel.getNb(), modifcmntr);

		} 

	}

	public static void ModifierReservationMap(Reservation reservation) {
		
		if (reservationMap.containsKey(reservation.getId())) {
			reservationMap.replace(reservation.getId(), reservation);
			ModificationHotel<Reservation, TypeOperation> modifReservation = new ModificationHotel<>(reservation.getId(),reservation,TypeOperation.MODIFICATION );
			modificationMap.put(ModificationHotel.getNb(),modifReservation);
		} 
	}
	public static void ModifierUserMap(User user){
		
		if (userMap.containsKey(user.getId())) {
			userMap.replace(user.getId(), user);
			ModificationHotel<User, TypeOperation> modifUser = new ModificationHotel<>(user.getId(),user,TypeOperation.MODIFICATION );
			modificationMap.put(ModificationHotel.getNb(),modifUser);
		} 
	}

	public static float calculermoyenne(){
        Iterator<Map.Entry<Integer, User>> iterator = userMap.entrySet().iterator();
        float moy=5;
        int i=1;
        while (iterator.hasNext()) {
            Map.Entry<Integer, User> entry = iterator.next();
            User user = entry.getValue();
			if (user.getNote()!=-1) {
				moy=moy+user.getNote();
            i++;
			}
         
            }
        return moy/i;//
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
	
	public static Chambre RechercheChambreParId(int id) {
		if (chambreMap.containsKey(id)) {
			return chambreMap.get(id);
		} else {
			// erreur jsp si on throw une err ou pas tbenlna f la suite
			return null;
		}

	}

	public static User RechercheuserParId(int id) {
		if (userMap.containsKey(id)) {
			return userMap.get(id);
		} else {
			// erreur jsp si on throw une err ou pas tbenlna f la suite
			return null;
		}

	}

	public static Reservation RechercheResevationParId(int id) {
		if (reservationMap.containsKey(id)) {
			return reservationMap.get(id);
		} else {
			// err jsp si on throw une err ou pas tbenlna f la suite
			return null;
		}

	}

	public static boolean verifchambreavecoption(Chambre chambre, TypeChambre type, boolean sona, boolean terasse,
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

			if (reservation.getId_chambre() == chambre.getId()) {
				if (!Date.DateCoincidePas(datedebut, datefin, reservation.getDateDebut(), reservation.getDateFin())) {
					return false;
				}

			}

		}
		return true;
	}

	public static boolean chambreAafficher(Chambre chambre, TypeChambre type, Date datedebut, Date datefin, boolean tv,
			boolean climatisation, boolean vuesurforet, boolean vuesurmer) {
		if (ChambreDispo(chambre, datedebut, datefin) && verifchambreavecoption(chambre, type, tv, climatisation, vuesurmer, vuesurforet)) {
			return true;
		}
		return false;
	}

	public static Chambre attribuerchambre(TypeChambre type, Date date1, Date date2,OptionSupplementaire opt)  {
		Iterator<Map.Entry<Integer, Chambre>> iterator = chambreMap.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, Chambre> entry = iterator.next();
			Chambre chambre = entry.getValue();

			boolean sona=chambre.isSONA() && opt ==OptionSupplementaire.SONA;
			boolean terasse=chambre.isTERASSE() && opt == OptionSupplementaire.TERASSE;
			boolean	vuesurforet=chambre.isVuesurforet() && opt == OptionSupplementaire.VUESURFORET;
			boolean vuesurmer=chambre.isVuesurmere() && opt == OptionSupplementaire.VUESURMERE;

			if ( chambre.getType() == type && sona 
				|| chambre.getType() == type && terasse
				|| chambre.getType() == type && vuesurforet
				|| chambre.getType() == type && vuesurmer) {
				//on recherche l'option esq en a 
				
				boolean nonreserve = ChambreDispo(chambre, date1, date2);
				if (nonreserve) {
					return chambre;//accepter la treservation
				}
			}
		}
		return null;//decalage de la reservation
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
	

}

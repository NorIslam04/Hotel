import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

class Chambre_reservee extends Exception {
	private String message = "la chambre est deja reservee vous ne pouvez appliquer aucun changement !";

	public String getMessage() {
		return message;
	}
}

class prix_invalide extends Exception {
	private String message = "prix invalide verifiez le";

	public String getMessage() {
		return message;
	}
}

public class Admin {

	private String name;
	private String password;
	private int id;
	private int nbOp = 0;
	static int nb = 0;

	public Admin(String name, String password, int id) {
		this.name = name;
		this.password = password;
		this.id = id;
		nb++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbOp() {
		return nbOp;
	}

	public void setNbOp(int nbOp) {
		this.nbOp = nbOp;
	}

	public static int getNb() {
		return nb;
	}

	public static void setNb(int nb) {
		Admin.nb = nb;
	}

	public void supprimerreservationinutile() throws Date_nonvalid, non_presente_bdd, deja_presente_bdd {
		// ici l admin a la fin de journee vas executer ce traitement
		// cette fonction permet de supprimer kml les reservation ly la date de fin
		// dylhm =date actuelle m la bdd ...etc
		// gnr nlibiriw wsh mnss79ouch
		LocalDate date = LocalDate.now();
		Date dateact = new Date(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
		Iterator<Map.Entry<Integer, Reservation>> iterator = Hotel.getReservationMap().entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Reservation> entry = iterator.next();
			Reservation reservation = entry.getValue();
			if (reservation.getDateFin() == dateact) {
				Hotel.ajouterModificationHotel(reservation, TypeOperation.SUPPRESSION);
			}

		}
	}

	void modifierchambrenblit(int id, TypeChambre type) throws non_presente_bdd, Date_nonvalid, Chambre_reservee, deja_presente_bdd {
		LocalDate date = LocalDate.now();
		Date dateact = new Date(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
		Date dateDansUnan = Date.ajouterJours(date.getDayOfMonth(), date.getMonthValue(), date.getYear(), 365);
		Chambre chambre = Hotel.RechercheChambreParId(id);
		if (Hotel.ChambreDispo(chambre, dateact, dateDansUnan)) {
			chambre.setType(type);
			Hotel.ajouterModificationHotel(chambre, TypeOperation.MODIFICATION);// le id ne peut pas etre modified
		} else {
			throw new Chambre_reservee();
		}

	}

	// hna les ancienne reservation doivent etre acceptee avec les anciens prix a
	// verifier
	void modifierprixchambre(int newprice, TypeChambre type) throws prix_invalide {
		if (newprice <= 0) {
			throw new prix_invalide();
		} else {
			type.setPrix(newprice);
		}
	}

}
// TODO : ne7iw m la bdd nb de lit per chambre
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

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

	public void supprimerreservationinutile() throws Date_nonvalid, non_presente_bdd {
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
				GestionOperation.SupprimerOpsReservation(reservation);
			}

		}
	}

}
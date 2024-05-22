package Model;
import Model.Date.*;
import java.util.*;
import Model.Hotel.TypeOperation;

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
	public static int nb_Supp;

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

	

	public static int getNb() {
		return nb;
	}

	public static void setNb(int nb) {
		Admin.nb = nb;
	}

	public static int supprimerreservationinutile() throws Date_nonvalid {
		Date today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
		try {
			nb_Supp=0;
		for (Map.Entry<Integer, Reservation> obj : Hotel.getReservationMap().entrySet()) {
			Reservation reservation = obj.getValue();
			if (Date.comparer(reservation.getDateFin(),today)<=0) {
				obj.getValue().sup=1;
				nb_Supp++;
				ModificationHotel<Reservation, TypeOperation> suppReservation = new ModificationHotel<>(reservation.getId(),
					reservation, TypeOperation.SUPPRESSION);
			Hotel.getModificationMap().put(ModificationHotel.getNb(), suppReservation);
			}
			
		}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return nb_Supp;
		
	}


}

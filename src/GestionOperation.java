import java.util.HashMap;

public class GestionOperation {

	static HashMap<Integer, Operation<Chambre>> ChambreOps = new HashMap<>();
	static HashMap<Integer, Operation<User>> UserOps = new HashMap<>();
	static HashMap<Integer, Operation<Reservation>> reservationOps = new HashMap<>();

	static void AjouterOpsChambreMap(Chambre chambre) throws deja_presente_bdd {
		ChambreOps.put(chambre.getId() + chambre.getNbOp(), new Operation<Chambre>(TypeOperation.AJOUT, chambre));
		chambre.setNbOp(chambre.getNbOp() + 1);
		Hotel.AjouterChambreMap(chambre);
	}

	static void AjouterOpsUserMap(User user) throws deja_presente_bdd {
		// verif adresse mail
		UserOps.put(Integer.parseInt(String.valueOf(user.getId()) + String.valueOf(user.getNbOp())),
				new Operation<User>(TypeOperation.AJOUT, user));
		user.setNbOp(user.getNbOp() + 1);
		Hotel.AjouterUserMap(user);
	}

	static void AjouterOpsReservation(Reservation reservation) throws deja_presente_bdd {
		reservationOps.put(
				Integer.parseInt(String.valueOf(reservation.getId()) + String.valueOf(reservation.getNbOp())),
				new Operation<Reservation>(TypeOperation.AJOUT, reservation));
		reservation.setNbOp(reservation.getNbOp() + 1);
		Hotel.AjouterReservationMap(reservation);
	}

	static void SupprimerOpsChambreMap(Chambre chambre) throws non_presente_bdd {
		ChambreOps.put(Integer.parseInt(String.valueOf(chambre.getId()) + String.valueOf(chambre.getNbOp())),
				new Operation<Chambre>(TypeOperation.SUPPRESSION, chambre));
		chambre.setNbOp(chambre.getNbOp() + 1);
		Hotel.SupprimerChambreMap(chambre);
	}

	static void SupprimerOpsUserMap(User user) throws non_presente_bdd {
		UserOps.put(Integer.parseInt(String.valueOf(user.getId()) + String.valueOf(user.getNbOp())),
				new Operation<User>(TypeOperation.SUPPRESSION, user));
		user.setNbOp(user.getNbOp() + 1);
		Hotel.SupprimerUserMap(user);
	}

	static void SupprimerOpsReservation(Reservation reservation) throws non_presente_bdd {
		reservationOps.put(
				Integer.parseInt(String.valueOf(reservation.getId()) + String.valueOf(reservation.getNbOp())),
				new Operation<Reservation>(TypeOperation.SUPPRESSION, reservation));
		reservation.setNbOp(reservation.getNbOp() + 1);
		Hotel.SupprimerReservationMap(reservation);
	}

	static void ModifierOpsChambreMap(Chambre chambre) throws non_presente_bdd {
		ChambreOps.put(Integer.parseInt(String.valueOf(chambre.getId()) + String.valueOf(chambre.getNbOp())),
				new Operation<Chambre>(TypeOperation.MODIFICATION, chambre));
		chambre.setNbOp(chambre.getNbOp() + 1);
		Hotel.ModifierChambreMap(chambre);
	}// ici le id reste tjr le mm

	static void ModifierOpsUserMap(User user) {
		UserOps.put(Integer.parseInt(String.valueOf(user.getId()) + String.valueOf(user.getNbOp())),
				new Operation<User>(TypeOperation.MODIFICATION, user));
		user.setNbOp(user.getNbOp() + 1);
		// Hotel.ModifierUserMap(user); //modifier user !!
	}

	static void ModifierOpsReservation(Reservation reservation) throws non_presente_bdd {
		reservationOps.put(Integer.parseInt(reservation.getId() + String.valueOf(reservation.getNbOp())),
				new Operation<Reservation>(TypeOperation.MODIFICATION, reservation));
		reservation.setNbOp(reservation.getNbOp() + 1);
		Hotel.ModifierReservationMap(reservation);
	}
}

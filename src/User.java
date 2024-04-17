class GmailIncorrect extends Exception {

	@Override
	public String toString() {
		return "GmailIncorrect";
	}

}

class motDePasseSimple extends Exception {

	@Override
	public String toString() {
		return "Mot de passe trop simple < 8 caracteres";
	}

}

public class User {
	// hii
	private String gmail;
	private String name;
	private String password;
	private int id;// de hashMap
	static int nb = 0;
	private int nbOp = 0;
	private boolean indb = false;

	public User(int id, String gmail, String name, String password) {
		this.id = id;
		this.gmail = gmail;
		this.name = name;
		this.password = password;
		nb++;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
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
		User.nb = nb;
	}

	public int getNbOp() {
		return nbOp;
	}

	public void setNbOp(int nbOp) {
		this.nbOp = nbOp;
	}

	public boolean isIndb() {
		return indb;
	}

	public void setIndb(boolean indb) {
		this.indb = indb;
	}

	static boolean gmailCorrect(String gmail) throws GmailIncorrect {
		if (gmail.contains("@gmail.com")) {
			return true;
		} else {
			throw new GmailIncorrect();
		}

	}

	static boolean motdepass(String passworld) throws motDePasseSimple {
		if (passworld.length() >= 8) {
			return true;
		} else {
			throw new motDePasseSimple();
		}

	}

	static boolean signin(String name, String passworld, String gmail)//(islam) rani kteb deja wa7da kima f interface sign-in
			throws deja_presente_bdd, motDePasseSimple, GmailIncorrect {
		// verifier gmail correct
		if (Hotel.findUser(name, passworld) == true) {
			throw new deja_presente_bdd();
		} else {
			User.motdepass(passworld);
			User.gmailCorrect(gmail);
			Hotel.modifierMap(new User(nb, gmail, name, passworld),TypeOperation.AJOUT);
			return true;

		}
	}

		
	public void reserver(TypeChambre type,String datedebut,String datefin) throws Date_nonvalid, Exception {
	
		Reservation reservation=new Reservation(Reservation.nb,this.id,Date.StringDateint(datedebut),Date.StringDateint(datefin),type,0,EtatReservation.EN_ATTENTE);
		Hotel.modifierMap(reservation,TypeOperation.AJOUT);
	}
		


}

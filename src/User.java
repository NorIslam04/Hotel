public class User {
	private String gmail;
	private String name;
	private String password;
	private int id;// de hashMap
	static int nb = 0;

	private int note=-1;// TODO:chaque user peut attribuer une note elle sera presente a la bdd

	public User(int id, String gmail, String name, String password,int note) {
		this.note=note;
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


	static boolean motdepass(String passworld){
			return passworld.length() >= 8;
	
	}

	public void reserveravecdetail(Chambre chambre,Date datedebut,Date datefin) throws Date_nonvalid, Exception {
		double prix=-1;//une fonction pour calculer le prix apartir des fonction les khayarhom l user
		Reservation reservation=new Reservation(Reservation.nb,this.id,datedebut,datefin,chambre.getType(),chambre.getId(),EtatReservation.ACCEPTER,prix);
		Hotel.AjtReservationMap(reservation);
	}
	

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
		


}

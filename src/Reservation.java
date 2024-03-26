public class Reservation {

	private int id;//de hash map
	//private User user;
	private int id_user;
	private String type;
	private Date dateDebut;
	private Date dateFin;
	//private Chambre chambre;
	private int id_chambre;
	private int NbrJourReservation;


	private EtatReservation etat = EtatReservation.EN_ATTENTE;// new reservation
	private int nbOp = 0;
	static int nb = 0;

	public Reservation(int id, int idUser, String type, Date dateDebut, Date dateFin, int idChambre,
			EtatReservation etat) throws Exception {
		this.id = id;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.NbrJourReservation=(int) Date.differenceEntreDates(dateDebut, dateFin);
		//this.user=Hotel.RechercheuserParId(idUser);//TODO: supp
		//this.chambre=Hotel.RechercheChambreParId(idChambre); //fhed les fct g pas encore geree les err TODO: supp
		this.id_user=idUser;
		this.id_chambre=idChambre;
		this.etat = etat;
		nb++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public User getUser() {
//		return user;
	//}

	//public void setser(User idUser) {
	//	this.user = user;
	//}

	

	public String getType() {
		return type;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_chambre() {
		return id_chambre;
	}

	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public EtatReservation getEtat() {
		return etat;
	}

	public void setEtat(EtatReservation etat) {
		this.etat = etat;
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
		Reservation.nb = nb;
	}

	

	public int getNbrJourReservation() {
		return NbrJourReservation;
	}

	public void setNbrJourReservation(int nbrJourReservation) {
		NbrJourReservation = nbrJourReservation;
	}

	//public Chambre getChambre() {
	//	return chambre;
	//}

	//public void setChambre(Chambre chambre) {
	//	this.chambre = chambre;
	//}
}

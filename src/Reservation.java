public class Reservation {

	private int id;
	private User user;
	private String type;
	private Date dateDebut;
	private Date dateFin;
	private Chambre chambre;


	private EtatReservation etat = EtatReservation.EN_ATTEND;// new reservation
	private int nbOp = 0;
	static int nb = 0;
	private boolean indb = false;

	public Reservation(int id, int idUser, String type, Date dateDebut, Date dateFin, int idChambre,
			EtatReservation etat) {
		this.id = id;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.user=Hotel.RechercheuserParId(idUser);//TODO: supp
		this.chambre=Hotel.RechercheChambreParId(idChambre); //fhed les fct g pas encore geree les err
		this.etat = etat;
		nb++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setser(User idUser) {
		this.user = user;
	}

	public String getType() {
		return type;
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

	public boolean isIndb() {
		return indb;
	}

	public void setIndb(boolean indb) {
		this.indb = indb;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
}

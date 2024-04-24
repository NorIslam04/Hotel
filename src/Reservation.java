enum EtatReservation {
    ACCEPTER,
    DECLINER,
    EN_ATTENTE;

    public static EtatReservation toEtatReservation(String str) {
        switch (str) {
            case "ACCEPTER":
                return ACCEPTER;
            case "DECLINER":
                return DECLINER;
            case "EN_ATTEND":
                return EN_ATTENTE;
            default:
                throw new IllegalStateException("État de réservation inconnu : " + str);
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case ACCEPTER:
                return "ACCEPTER";
            case DECLINER:
                return "DECLINER";
            case EN_ATTENTE:
                return "EN_ATTEND";
            default:
                throw new IllegalArgumentException("État de réservation invalide : " + this);
        }
    }
}
public class Reservation {

	private int id;//de hash map
	private int id_user;
	private TypeChambre type;
	private Date dateDebut;
	private Date dateFin;
	private double prix;
	private int id_chambre;
	private int NbrJourReservation;
	private EtatReservation etat = EtatReservation.EN_ATTENTE;// new reservation
	static int nb = 0;

	public Reservation(int id, int idUser, Date dateFin, Date dateDebut, TypeChambre type, int idChambre,
			EtatReservation etat,double prix) throws Exception {
		this.id = id;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.NbrJourReservation=(int) Date.differenceEntreDates(dateDebut, dateFin);
		this.id_user=idUser;
		this.prix=prix;
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

	

	public TypeChambre getType() {
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

	public void setType(TypeChambre type) {
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}

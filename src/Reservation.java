public class Reservation {
	
		private int id;
		private int idUser;
		private String type;
		private Date dateDebut;
		private Date dateFin;
		private int idChambre;
		private String etat="en attente";// new reservation
		private int nbOp=0;
		static int nb=0;
		private boolean indb=false;
		
		public Reservation(int id,int idUser, String type, Date dateDebut, Date dateFin, int idChambre,String etat) {
			this.id = id;
			this.idUser = idUser;
			this.type = type;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
			this.idChambre = idChambre;
			this.etat = etat;
			nb++;
		}



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getIdUser() {
			return idUser;
		}

		public void setIdUser(int idUser) {
			this.idUser = idUser;
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

		public int getIdChambre() {
			return idChambre;
		}

		public void setIdChambre(int idChambre) {
			this.idChambre = idChambre;
		}

		public String getEtat() {
			return etat;
		}

		public void setEtat(String etat) {
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

		

	
	
}

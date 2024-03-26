enum TypeChambre {
	SOLO,
	DOUBLE,
	TRIPLE,
	SUITE;

	public String ToString() {
		switch (this) {
			case SOLO:
				return "SOLO";
			case DOUBLE:
				return "DOUBLE";
			case TRIPLE:
				return "TRIPLE";
			case SUITE:
				return "SUITE";
			default:
				throw new IllegalStateException("Type de chambre inconnu : " + this);
		}
	}

	public static TypeChambre ToTypeChambre(String str) {
		switch (str) {
			case "SOLO":
				return SOLO;
			case "DOUBLE":
				return DOUBLE;
			case "TRIPLE":
				return TRIPLE;
			case "SUITE":
				return SUITE;
			default:
				throw new IllegalStateException("Type de chambre inconnu : " + str);
		}
	}
}

public class Chambre {

	private int id;// pour hash map
	private int nbLit;
	private TypeChambre type;
	private double prix;
	private int nbOp = 0;
	static int nb = 0;
	private boolean indb = false;
	private int Reservedatleastonce = 0;// 0->non et 1->oui Reservedatleastonce

	public Chambre(int id, int nbLit, TypeChambre type, double prix, int Reservedatleastonce) {
		this.id = id;
		this.nbLit = nbLit;
		this.type = type;
		this.prix = prix;
		this.Reservedatleastonce = Reservedatleastonce;
		nb++;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbLit() {
		return nbLit;
	}

	public void setNbLit(int nbLit) {
		this.nbLit = nbLit;
	}

	public TypeChambre getType() {
		return type;
	}

	public void setType(TypeChambre type) {
		this.type = type;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
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
		Chambre.nb = nb;
	}

	public boolean isIndb() {
		return indb;
	}

	public void setIndb(boolean indb) {
		this.indb = indb;
	}

	public int getReservedatleastonce() {
		return Reservedatleastonce;
	}

	public void setReservedatleastonce(int Reservedatleastonce) {
		this.Reservedatleastonce = Reservedatleastonce;
	}

}

enum TypeChambre {
	SOLO,
	DOUBLE,
	TRIPLE,
	SUITE;
	
	
    private float prix;
	private int nblit;

    TypeChambre() {
    	this.prix = 0;
		this.nblit=0;
    }

    public float getPrix() {
        return prix;
    }

    
    public void setPrix(float prix) {
        this.prix = prix;
    }
	public int getNbLit() {
        return nblit;
    }

    
    public void setNbLit(int nbLit) {
        this.nblit = nbLit;
    }

	public static void initialiser(float prixSOLO,int nbLitSOLOS,float prixDOUBLE,int nbLitDOULBE,float prixTRIPLE,int nbLitTRIPLE,float prixSUITE,int nbLitSUITE){
		initialisersSOLO(prixSOLO, nbLitSOLOS);
		initialisersDOUBLE(prixDOUBLE, nbLitDOULBE);
		initialisersTRIPLE(prixTRIPLE, nbLitTRIPLE);
		initialisersSUITE(prixSUITE, nbLitSUITE);
	}
	public static void initialisersSOLO(float prix,int nbLit){
	SOLO.setPrix(prix);
	SOLO.setNbLit(nbLit);
	}
	public static void initialisersDOUBLE(float prix,int nbLit){
		DOUBLE.setPrix(prix);
		DOUBLE.setNbLit(nbLit);
	}
	public static void initialisersTRIPLE(float prix,int nbLit){
		TRIPLE.setNbLit(nbLit);
		TRIPLE.setPrix(prix);
	}
	public static void initialisersSUITE(float prix,int nbLit){
		SUITE.setNbLit(nbLit);
		SUITE.setPrix(prix);
	}
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
	private TypeChambre type;
	private int nbOp = 0;
	static int nb = 0;


	public Chambre(int id, TypeChambre type) {
		this.id = id;
		this.type = type;
		nb++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbLit() {
		return type.getNbLit();
	}


	public TypeChambre getType() {
		return type;
	}

	public void setType(TypeChambre type) {
		this.type = type;
	}

	public double getPrix() {
		return type.getPrix();
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


}

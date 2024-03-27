enum TypeChambre {
	SOLO,
	DOUBLE,
	TRIPLE,
	SUITE;
	
    private float prix;

    TypeChambre() {
    	this.prix = 0;
    }

    public float getPrix() {
        return prix;
    }

    
    public void setPrix(float prix) {
        this.prix = prix;
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
	private int nbLit;
	private TypeChambre type;
	private int nbOp = 0;
	static int nb = 0;


	public Chambre(int id, TypeChambre type, double prix) {
		this.id = id;
		if(type==TypeChambre.SOLO){
			this.nbLit = 1;
		}if(type==TypeChambre.DOUBLE){
			this.nbLit = 2;
		}
		if(type==TypeChambre.SUITE){
			this.nbLit = 4;
		}
		if(type==TypeChambre.TRIPLE){
			this.nbLit = 3;
		}
		
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

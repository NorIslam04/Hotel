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

enum OptionSupplementaire {
TV,CLIMATISATION,VUESURMERE,VUESURFORET;
private float prix;//prix pour chaque option


OptionSupplementaire() {
	this.prix = 0;
}

public float getPrix() {
	return prix;
}


public void setPrix(float prix) {
	this.prix = prix;
}


public static void initialiser(float prixTV,float prixClimatisation,float prixvuesurmer,float prixvuesurforet){
	TV.setPrix(prixTV);
	CLIMATISATION.setPrix(prixClimatisation);
	VUESURFORET.setPrix(prixvuesurforet);
	VUESURMERE.setPrix(prixvuesurmer);
}
}

public class Chambre {

	private int id;// pour hash map
	private TypeChambre type;
	private boolean tv;

	private boolean climatisation;
	private boolean vuesurmere;
	private boolean vuesurforet;
	private double prix;
	private int nbOp = 0;
	static int nb = 0;
	public Chambre(int id, TypeChambre type,int prix) {
		this.id = id;
		this.type = type;
		this.prix=prix;
		nb++;
	}
	public Chambre(int id, TypeChambre type,int prix,boolean tv,boolean climatisation,boolean vuesurmere,boolean vuesurforet) {
		this.id = id;
		this.type = type;
		this.prix=prix;
		this.tv=tv;
		this.climatisation=climatisation;
		this.vuesurmere=vuesurmere;
		this.vuesurforet=vuesurforet;
		nb++;
	}



	public boolean isVuesurmere() {
		return vuesurmere;
	}
	public void setVuesurmere(boolean vuesurmere) {
		this.vuesurmere = vuesurmere;
	}

	public boolean isVuesurforet() {
		return vuesurforet;
	}
	public void setVuesurforet(boolean vuesurforet) {
		this.vuesurforet = vuesurforet;
	}


	public boolean isClimatisation() {
		return climatisation;
	}
	public void setClimatisation(boolean climatisation) {
		this.climatisation = climatisation;
	}


	public boolean isTv() {
		return tv;
	}
	public void setTv(boolean tv) {
		this.tv = tv;
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
		return prix;
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



	public void setPrix(int prix) {
		this.prix = prix;
	}


  public float calculeprixchambre(){
	float prix=0;
	if(tv){
		prix=prix+OptionSupplementaire.TV.getPrix();
	}
	if(climatisation){
		prix=prix+OptionSupplementaire.CLIMATISATION.getPrix();
	}
	if(vuesurforet){
		prix=prix+OptionSupplementaire.VUESURFORET.getPrix();
	}
	if(vuesurmere){
		prix=prix+OptionSupplementaire.VUESURMERE.getPrix();
	}
	if(type==TypeChambre.SOLO){
		prix=prix+TypeChambre.SOLO.getPrix();
	}
	if(type==TypeChambre.DOUBLE){
		prix=prix+TypeChambre.DOUBLE.getPrix();
	}
	if(type==TypeChambre.TRIPLE){
		prix=prix+TypeChambre.TRIPLE.getPrix();
	}
	if(type==TypeChambre.SUITE){
		prix=prix+TypeChambre.SUITE.getPrix();
	}
// TODO : n9drou n7ou kml hd les if w nkhdmou b objet ida mnssinech ndirouha
	this.prix=prix;  
	return prix;
  }
}

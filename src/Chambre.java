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
SONA,TERASSE,VUESURMERE,VUESURFORET;
private float prix;//prix pour chaque option


OptionSupplementaire() {
	this.prix = 5;
}

public float getPrix() {
	return prix;
}


public void setPrix(float prix) {
	this.prix = prix;
}


public static void initialiser(float prixSONA,float prixTERASSE,float prixvuesurmer,float prixvuesurforet){
	SONA.setPrix(prixSONA);
	TERASSE.setPrix(prixTERASSE);
	VUESURFORET.setPrix(prixvuesurforet);
	VUESURMERE.setPrix(prixvuesurmer);
}
}




	
	/*chambre solo 
	4 options
	option sona: son prix  admin*/
	//TODO reservation prix yb9a le meme dnc nzidoulou un prix 


	//utilisateur reserva une chambre 4 option 20 dollar solo 100 dolars 120 dollars

	
public class Chambre {

	private int id;// pour hash map
	private TypeChambre type;
	private boolean SONA;
	private boolean TERASSE;
	private boolean vuesurmere;
	private boolean vuesurforet;




	// en gros ces deux variable vont permettre a l admin de mette une date pour les chambres ou tt les reservation 
	//qui coincide m3a hd la date on vas pas leurs proposer cette chambre puisque elle sera soit
	//supprimee apres soit modified apres 
	//si la chambre est deja resevee durant la date que proposera l admin une err sera projetee 
	//TODO faire les modif necessaires dans les fct d attribution 

	private double prix;
	private int nbOp = 0;
	static int nb = 0;
	public Chambre(int id, TypeChambre type,int prix) {
		this.id = id;
		this.type = type;
		this.prix=prix;
		nb++;
	}
	public Chambre(int id, TypeChambre type,boolean SONA,boolean TERASSE,boolean vuesurmere,boolean vuesurforet) {
		this.id = id;
		this.type = type;
		this.SONA=SONA;
		this.TERASSE=TERASSE;
		this.vuesurmere=vuesurmere;
		this.vuesurforet=vuesurforet;
		this.prix=calculeprixchambre();
		nb++;
	}


	

	public boolean isVuesurmere() {
		return vuesurmere;
	}
	public void seSONAuesurmere(boolean vuesurmere) {
		this.vuesurmere = vuesurmere;
	}

	public boolean isVuesurforet() {
		return vuesurforet;
	}
	public void seSONAuesurforet(boolean vuesurforet) {
		this.vuesurforet = vuesurforet;
	}


	public boolean isTERASSE() {
		return TERASSE;
	}
	public void setTERASSE(boolean TERASSE) {
		this.TERASSE = TERASSE;
	}


	public boolean isSONA() {
		return SONA;
	}
	public void setSONA(boolean SONA) {
		this.SONA = SONA;
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
	float prix=type.getPrix();
	if(SONA){
		prix=prix+OptionSupplementaire.SONA.getPrix();
	
	}
	if(TERASSE){
		prix=prix+OptionSupplementaire.TERASSE.getPrix();
		
	}
	if(vuesurforet){
		prix=prix+OptionSupplementaire.VUESURFORET.getPrix();
	}
	if(vuesurmere){
		prix=prix+OptionSupplementaire.VUESURMERE.getPrix();
	}
	
// TODO : n9drou n7ou kml hd les if w nkhdmou b objet ida mnssinech ndirouha
	this.prix=prix;  
	return prix;
  }
}

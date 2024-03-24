public class Chambre{

	private int id;//pour hash map
	private int nbLit;
	private String type;
	private double prix;
	private int nbOp=0;
	static int nb=0;
	private boolean indb=false;
	private int reserver=0;
	
	public Chambre(int id,int nbLit, String type, double prix,int reserver) {
		this.id = id;
		this.nbLit = nbLit;
		this.type = type;
		this.prix = prix;
		this.reserver=reserver;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public int getReserver() {
		return reserver;
	}

	public void setReserver(int reserver) {
		this.reserver = reserver;
	}

	
	

}

public class Admin {

	private String name;
	private String password;
	private int id;
	private int nbOp=0;
	static int nb=0;

	
	public Admin(String name, String password, int id) {
		this.name = name;
		this.password = password;
		this.id = id;
		nb++;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		Admin.nb = nb;
	}

	
}

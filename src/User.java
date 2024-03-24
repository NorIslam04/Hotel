public class User {

	private String gmail;
	private String name;
	private String password;
	private int id;//de hashMap
	static int nb=0;
	private int nbOp=0;
	private boolean indb=false;
	
	public User(int id,String gmail, String name, String password) {
		this.id =id;
		this.gmail = gmail;
		this.name = name;
		this.password = password;
		nb++;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
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

	public static int getNb() {
		return nb;
	}

	public static void setNb(int nb) {
		User.nb = nb;
	}

	public int getNbOp() {
		return nbOp;
	}

	public void setNbOp(int nbOp) {
		this.nbOp = nbOp;
	}

	public boolean isIndb() {
		return indb;
	}

	public void setIndb(boolean indb) {
		this.indb = indb;
	}

}

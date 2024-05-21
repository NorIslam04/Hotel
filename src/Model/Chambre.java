package Model;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import Control.Control;




	
	/*chambre solo 
	4 options
	option sona: son prix  admin*/
	//TODO reservation prix yb9a le meme dnc nzidoulou un prix 


	//utilisateur reserva une chambre 4 option 20 dollar solo 100 dolars 120 dollars

	
	public class Chambre {

		public enum TypeChambre {
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
		
		public enum OptionSupplementaire {
			SONA,
			TERASSE,
			VUESURMERE,
			VUESURFORET;
			private float prix;//prix pour chaque option


			public String ToString() {
				switch (this) {
					case SONA:
						return "SONA";
					case TERASSE:
						return "TERASSE";
					case VUESURFORET:
						return "VUESURFORET";
					case VUESURMERE:
						return "VUESURMERE";
					default:
						throw new IllegalStateException("Type de chambre inconnu : " + this);
				}
			}
		
			
		
			public static OptionSupplementaire tOptionSupplementaire(String str) {
				switch (str) {
					case "SONA":
						return SONA;
					case "TERASSE":
						return TERASSE;
					case "VUESURMERE":
						return VUESURMERE;
					case "VUESURFORET":
						return VUESURFORET;
					default:
						throw new IllegalStateException("Type de chambre inconnu : " + str);
				}
			}
		
		
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
	static int nb = 0;

	//neveau constructeure
	public Chambre(int id, TypeChambre type,double prix,boolean SONA,boolean TERASSE,boolean vuesurmere,boolean vuesurforet) {
		this.id = id;
		this.type = type;

		this.SONA=SONA;
		this.TERASSE=TERASSE;
		this.vuesurmere=vuesurmere;
		this.vuesurforet=vuesurforet;
		this.prix=calculeprixchambre();///hsna lazem nriglo prblm psq ana nst3mel had l constructure bch njbed base de donnees l hashmap bch njeb prix psq f base de donnees ikon prix wadjed
		this.prix=prix;
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


  public static double GetPrix(String option){

	for (Map.Entry<Integer, Option> entry : Hotel.getOptionHashMap().entrySet()) {

		if(option.equals(entry.getValue().getRooms_Options().toString())){
			return entry.getValue().getPrix_option();
		}
	}
	return 0;

}

   public static void Bdd_to_hashMap_room(){
        // Informations de connexion à la base de données

        String query = "SELECT * FROM rooms";

        try {
            // Établir la connexion à la base de données
            Connection connection = Control.connectToMySQL();

            // Créer une déclaration pour exécuter la requête
            Statement statement = connection.createStatement();

            // Exécuter la requête SQL et obtenir le résultat
            ResultSet resultSet = statement.executeQuery(query);
            // Parcourir le résultat et afficher les informations
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                TypeChambre typeChambre = TypeChambre.ToTypeChambre(type);
                int prix=resultSet.getInt("prix");
                boolean sona=resultSet.getBoolean("SONA");
                boolean terasse=resultSet.getBoolean("TERASSE");
                boolean vuesurmere=resultSet.getBoolean("VUESURMERE");
                boolean vuesurforet=resultSet.getBoolean("VUESURFORET");

                Chambre chambre = new Chambre(id, typeChambre, prix, sona, terasse, vuesurmere, vuesurforet);
                Hotel.AjouterChambreMap(chambre);
                Chambre.setNb(id);
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static void hash_map_bdd () throws SQLException{
		 HashMap<Integer, ModificationHotel<?,?>> modificMap = Hotel.getModificationMap();
        Connection connection = Control.connectToMySQL();
        // Parcours de la HashMap et accès à ses éléments
        for (Map.Entry<Integer, ModificationHotel<?,?>> entry : modificMap.entrySet()) {

            Object objet = entry.getValue().getObjet(); // Obtenez l'objet de ModificationHotel (type T)
            Object operation = entry.getValue().getOperation(); // Obtenez l'opération de ModificationHotel (type
                                                                       // O)
                if (objet instanceof Chambre) {
                Chambre chambre = (Chambre) objet;
                String ch ="Chambre";
                if (operation==TypeOperation.AJOUT) {

                    String insertQuery = "INSERT INTO rooms (type, prix,SONA, TERASSE, VUESURMERE, VUESURFORET) VALUES (?, ?, ?, ?, ?, ?)";                 
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setString(1, chambre.getType().ToString());
                    preparedStatement.setDouble(2, chambre.getPrix());
                    preparedStatement.setBoolean(3, chambre.isSONA());
                    preparedStatement.setBoolean(4, chambre.isTERASSE());
                    preparedStatement.setBoolean(5, chambre.isVuesurmere());
                    preparedStatement.setBoolean(6, chambre.isVuesurforet());


                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    System.out.println("Objet: "+ch+" / Operation: "+operation);

                } else if (operation == TypeOperation.MODIFICATION) {
                    // on a un probleme de iD_hashMap != iD_DB (c pas suur)
                    int idChambre = chambre.getId(); // Supposons que vous ayez une méthode getId() dans la classe
                                                     // Chambre pour obtenir l'identifiant de la chambre
                    String updateQuery = "UPDATE rooms SET  type = ?, prix = ?, SONA=?, TERASSE=?, VUESURMERE= ?, VUESURFORET= ? WHERE id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                    
                    preparedStatement.setString(1, chambre.getType().ToString());
                    preparedStatement.setDouble(2, chambre.getPrix());
                    preparedStatement.setBoolean(3, chambre.isSONA());
                    preparedStatement.setBoolean(4, chambre.isTERASSE());
                    preparedStatement.setBoolean(5, chambre.isVuesurmere());
                    preparedStatement.setBoolean(6, chambre.isVuesurforet());
                    preparedStatement.setInt(7, idChambre);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    System.out.println("Objet: "+ch+" / Operation: "+operation);


                } else {

                    int idChambre = chambre.getId(); // Supposons que vous ayez une méthode getId() dans la classe
                                                     // Chambre pour obtenir l'identifiant de la chambre
                    String deleteQuery = "DELETE FROM rooms WHERE id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                    preparedStatement.setInt(1, idChambre);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
					System.out.println("Objet: "+ch+" / Operation: "+operation);

                }
            }
		}
	}
}
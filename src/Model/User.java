package Model;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import Model.Date.*;
import Model.Reservation.EtatReservation;
import Control.Control;


public class User {
	private String gmail;
	private String name;
	private String password;
	private int id;// de hashMap
	static int nb = 0;

	private int note=-1;// TODO:chaque user peut attribuer une note elle sera presente a la bdd

	public User(int id, String gmail, String name, String password,int note) {
		this.note=note;
		this.id = id;
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


	public static boolean motdepass(String passworld){
			return passworld.length() >= 8;
	
	}

	public void reserveravecdetail(Chambre chambre,Date datedebut,Date datefin) throws Date_nonvalid, Exception {
		double prix=99999;//une fonction pour calculer le prix apartir des fonction les khayarhom l user
		Reservation reservation=new Reservation(Reservation.nb,this.id,datedebut,datefin,chambre.getType(),chambre.getId(),EtatReservation.ACCEPTER,prix);
		Hotel.AjtReservationMap(reservation);
	}
	

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}


	public static void Bdd_to_hashMap_users() {
        // Informations de connexion à la base de données

        String query = "SELECT * FROM users";

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
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                int note =resultSet.getInt("note");
                User user = new User(id, email, name, password,note);
                Hotel.AjouterUserMap(user);
                User.setNb(id);
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

	public static void hash_map_db() throws SQLException{

		HashMap<Integer, ModificationHotel<?,?>> modificMap = Hotel.getModificationMap();
        Connection connection = Control.connectToMySQL();

        for (Map.Entry<Integer, ModificationHotel<?,?>> entry : modificMap.entrySet()) {

            Object objet = entry.getValue().getObjet(); // Obtenez l'objet de ModificationHotel (type T)
            Object operation = entry.getValue().getOperation(); // Obtenez l'opération de ModificationHotel (type
                                                                       // O)

            if (objet instanceof User ) {
                User user = (User) objet;
                if(operation == TypeOperation.AJOUT){
                AddUserDb(user);

                }else if(operation==TypeOperation.MODIFICATION){
                int iduser = user.getId(); // Supposons que vous ayez une méthode getId() dans la classe
                                                     // Chambre pour obtenir l'identifiant de la chambre
                    String updateQuery = "UPDATE users SET note = ? WHERE id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                    
                    preparedStatement.setInt(1, user.getNote());
                    preparedStatement.setInt(2, iduser);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    System.out.println("Objet: User / Operation: "+operation);
               	} 
				}
			}
	}
            



	public static void AddUserDb(User user) {
        try {
            Connection connection = Control.connectToMySQL();

            // Préparer la requête SQL pour l'insertion des données
            String query = "INSERT INTO users (name, email, password,note) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, user.getName());
            statement.setString(2, user.getGmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getNote());
            // Exécuter la requête d'insertion
            statement.executeUpdate();
            System.out.println("Objet: User / Operation: AJOUT");

            // Fermer les ressources
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
		


}

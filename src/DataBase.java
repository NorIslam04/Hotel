import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class DataBase {

    public static Connection connectToMySQL() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hotel";
        String utilisateur = "root";
        String motDePasse = "islam";

        Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
        return connexion;
    }

    // base de données to hashMap:
    public static void Bdd_to_hashMap_users() throws deja_presente_bdd {
        // Informations de connexion à la base de données

        String query = "SELECT * FROM users";

        try {
            // Établir la connexion à la base de données
            Connection connection = connectToMySQL();

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
                User user = new User(id, email, name, password);
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

    public static void Bdd_to_hashMap_room() throws deja_presente_bdd {
        // Informations de connexion à la base de données

        String query = "SELECT * FROM rooms";

        try {
            // Établir la connexion à la base de données
            Connection connection = connectToMySQL();

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

                Chambre chambre = new Chambre(id, typeChambre,prix);
                Hotel.AjouterChambreMap(chambre);
                // Hotel.
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

    public static void Bdd_to_hashMap_reservation() throws Exception {
        String query = "SELECT * FROM reservation";

        try {
            Connection connection = connectToMySQL();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idUser = resultSet.getInt("idUser");
                TypeChambre type = TypeChambre.ToTypeChambre(resultSet.getString("type"));
                String dateDebut = resultSet.getString("dateDebut");
                String dateFin = resultSet.getString("dateFin");
                int idChambre = resultSet.getInt("idChambre");
                EtatReservation etat = EtatReservation.toEtatReservation(resultSet.getString("etat"));

                Date dd = Date.Recupere_date(dateDebut);
                Date df = Date.Recupere_date(dateFin);

                Reservation reservation = new Reservation(id, idUser, df, dd, type, idChambre, etat);
                Hotel.AjouterReservationMap(reservation);
                Reservation.setNb(id);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean verif_user_bdd(String name, String psswrd) {
        boolean utilisateurTrouve = false;

        // Requête SQL pour vérifier l'existence de l'utilisateur
        String query = "SELECT * FROM users WHERE name = ? AND password = ?";
        try {
            // Établir la connexion à la base de données
            Connection connexion = connectToMySQL();

            // Créer une déclaration préparée pour exécuter la requête avec les paramètres
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, psswrd);

            // Exécuter la requête SQL et obtenir le résultat
            ResultSet resultSet = statement.executeQuery();

            // Vérifier si un utilisateur correspondant a été trouvé dans la base de données
            if (resultSet.next()) {
                utilisateurTrouve = true;
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            connexion.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }

        return utilisateurTrouve;
    }


    static void HasgMapsToDb() throws SQLException {
        HashMap<Integer, ModificationHotel<?,?>> modificMap = Hotel.getModificationMap();
        Connection connection = connectToMySQL();
        // Parcours de la HashMap et accès à ses éléments
        for (Map.Entry<Integer, ModificationHotel<?,?>> entry : modificMap.entrySet()) {

            Object objet = entry.getValue().getObjet(); // Obtenez l'objet de ModificationHotel (type T)
            Object operation = entry.getValue().getOperation(); // Obtenez l'opération de ModificationHotel (type
                                                                       // O)

            if (objet instanceof User && operation == TypeOperation.AJOUT) {
                User user = (User) objet;
                AddUserDb(user);
            }

            else if (objet instanceof Chambre) {
                Chambre chambre = (Chambre) objet;
                String ch ="Chambre";
                if (operation==TypeOperation.AJOUT) {

                    String insertQuery = "INSERT INTO rooms (type, prix) VALUES (?, ?)";                 
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setString(1, chambre.getType().ToString());
                    preparedStatement.setDouble(2, chambre.getPrix());
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    System.out.println("Objet: "+ch+" / Operation: "+operation);

                } else if (operation == TypeOperation.MODIFICATION) {
                    // on a un probleme de iD_hashMap != iD_DB (c pas suur)
                    int idChambre = chambre.getId(); // Supposons que vous ayez une méthode getId() dans la classe
                                                     // Chambre pour obtenir l'identifiant de la chambre
                    String updateQuery = "UPDATE rooms SET  type = ?, prix = ? WHERE id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                    
                    preparedStatement.setString(1, chambre.getType().ToString());
                    preparedStatement.setDouble(2, chambre.getPrix());
                    preparedStatement.setInt(3, idChambre);
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

                }
            } else {// modification operation
                if (objet instanceof Reservation) {
                    Reservation reservation = (Reservation) objet;
                    String res="Reservation";
                    if(operation == TypeOperation.AJOUT) {
                        String insertQuery = "INSERT INTO reservation (idUser, type, dateDebut, dateFin, idChambre, etat) VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setInt(1, reservation.getId_user());
                        preparedStatement.setString(2, reservation.getType().ToString());
                        preparedStatement.setString(3, reservation.getDateDebut().toString());
                        preparedStatement.setString(4, reservation.getDateFin().toString());
                        preparedStatement.setInt(5, reservation.getId_chambre());
                        preparedStatement.setString(6, reservation.getEtat().toString());
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+res+" / Operation: "+operation);

                    } else if (operation==TypeOperation.MODIFICATION) {
                        int idReservation = reservation.getId();
                        String updateQuery = "UPDATE reservation SET idUser = ?, type = ?, dateDebut = ?, dateFin = ?, idChambre = ?, etat = ? WHERE id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setInt(1, reservation.getId_user());
                        preparedStatement.setString(2, reservation.getType().ToString());
                        preparedStatement.setString(3, reservation.getDateDebut().toString());
                        preparedStatement.setString(4, reservation.getDateFin().toString());
                        preparedStatement.setInt(5, reservation.getId_chambre());
                        preparedStatement.setString(6, reservation.getEtat().toString());
                        preparedStatement.setInt(7, idReservation);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+res+" / Operation: "+operation);

                    } else if (operation.equals(TypeOperation.SUPPRESSION)) {
                        int idReservation = reservation.getId();
                        String deleteQuery = "DELETE FROM reservation WHERE id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                        preparedStatement.setInt(1, idReservation);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+res+" / Operation: "+operation);

                    }
                }

            }
        }

        connection.close();

    }

    // hashMap to base de donner

    public static void AddUserDb(User user) {
        try {
            Connection connection = connectToMySQL();

            // Préparer la requête SQL pour l'insertion des données
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, user.getName());
            statement.setString(2, user.getGmail());
            statement.setString(3, user.getPassword());
            // Exécuter la requête d'insertion
            statement.executeUpdate();
            System.out.println("Objet: User / Operation: AJOUT");

            // Fermer les ressources
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    

    public static void afficherHashMap(int i) {
        switch (i) {
            case 1:
                for (Map.Entry<Integer, User> entry : Hotel.getUserMap().entrySet()) {
                    int id = entry.getKey();
                    User user = entry.getValue();

                    System.out.println("ID: " + id);
                    System.out.println("Name: " + user.getName());
                    System.out.println("Email :" + user.getGmail());
                    System.out.println("Password: " + user.getPassword());
                    System.out.println("----------------------");
                }
                break;

            case 2:
                for (Map.Entry<Integer, Chambre> entry : Hotel.getChambreMap().entrySet()) {
                    int id = entry.getKey();
                    Chambre chambre = entry.getValue();

                    System.out.println("ID: " + id);
                    System.out.println("Nombre de lits: " + chambre.getNbLit());
                    System.out.println("Type: " + chambre.getType());
                    System.out.println("Prix: " + chambre.getPrix());
                    System.out.println("----------------------");
                }
                break;
            case 3:
                for (Map.Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
                    int id = entry.getKey();
                    Reservation reservation = entry.getValue();

                    System.out.println("ID: " + id);
                    System.out.println("ID User: " + reservation.getId_user());
                    System.out.println("Type: " + reservation.getType());
                    System.out.println("Date de début: " + reservation.getDateDebut());
                    System.out.println("Date de fin: " + reservation.getDateFin());
                    System.out.println("NbrJourResrvation: " + reservation.getNbrJourReservation());
                    System.out.println("ID Chambre: " + reservation.getId_chambre());
                    System.out.println("État: " + reservation.getEtat());
                    System.out.println("----------------------");
                }
                break;

            default:
                System.out.println("hashMap n'existe pas !");
                break;
        }

    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
                user.setIndb(true);
                Hotel.AjouterUserMap(user);
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
                int nombre_lit = resultSet.getInt("nombre_lit");
                String type = resultSet.getString("type");
                double prix = resultSet.getDouble("prix");
                int reserver = resultSet.getInt("reserver");

                TypeChambre typeChambre = TypeChambre.ToTypeChambre(type);

                Chambre chambre = new Chambre(id, nombre_lit, typeChambre, prix, reserver);
                chambre.setIndb(true);
                Hotel.AjouterChambreMap(chambre);
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
                String type = resultSet.getString("type");
                String dateDebut = resultSet.getString("dateDebut");
                String dateFin = resultSet.getString("dateFin");
                int idChambre = resultSet.getInt("idChambre");
                String etat = resultSet.getString("etat");
                
                Date dd = Date.Recupere_date(dateDebut);
                Date df = Date.Recupere_date(dateFin);
                
                Reservation reservation = new Reservation(id, idUser, type, dd, df, idChambre,
                        EtatReservation.toEtatReservation(etat));
                Hotel.AjouterReservationMap(reservation);

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

    public static boolean verif_admin_bdd(String name, String psswrd) {
        boolean adminTrouve = false;

        // Requête SQL pour vérifier l'existence de l'utilisateur
        String query = "SELECT * FROM admin WHERE name = ? AND password = ?";
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
                adminTrouve = true;
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            connexion.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }

        return adminTrouve;
    }

    // hashMap to base de donner
    /* 
    public static void hashMapToDatabase_User() {
        HashMap<Integer, User> userMap = Hotel.getUserMap();
        try {
            // Établir la connexion à la base de données
            Connection connection = connectToMySQL();

            // Préparer la requête SQL pour l'insertion des données
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Parcourir la HashMap et insérer chaque utilisateur dans la base de données
            for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
                User user = entry.getValue();
                if (!user.isIndb()) {// pour ne pas inserer le meme user 2fois dans database

                    statement.setString(1, user.getName());
                    statement.setString(2, user.getGmail());
                    statement.setString(3, user.getPassword());
                    // Exécuter la requête d'insertion
                    statement.executeUpdate();
                    System.out.println(
                            "User: '" + user.getName() + "' est insérées avec succès dans la base de données.");
                }
            }

            // Fermer les ressources
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void hashMapToDatabase_chambres() {
        // Récupérer la HashMap contenant les données
        HashMap<Integer, Chambre> chambreMap = Hotel.getChambreMap();

        // Informations de connexion à la base de données
        String insertQuery = "INSERT INTO rooms (nombre_lit, type, prix, reserver) VALUES (?, ?, ?, ?)";

        try {
            // Établir la connexion à la base de données
            Connection connection = connectToMySQL();

            // Préparer la déclaration d'insertion
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Parcourir la HashMap et insérer chaque chambre dans la base de données
            for (Map.Entry<Integer, Chambre> entry : chambreMap.entrySet()) {

                Chambre chambre = entry.getValue();

                if (!chambre.isIndb()) {
                    // Définir les valeurs pour la déclaration d'insertion
                    preparedStatement.setInt(1, chambre.getNbLit());
                    TypeChambre typeChambre = chambre.getType();
                    preparedStatement.setString(2, typeChambre.ToString());
                    preparedStatement.setDouble(3, chambre.getPrix());
                    preparedStatement.setInt(4, chambre.getReservedatleastonce());

                    // Exécuter la requête d'insertion
                    preparedStatement.executeUpdate();
                    System.out.println(
                            "Chambre iD: " + chambre.getId() + " est insérées avec succès dans la base de données.");
                }
            }

            // Fermer les ressources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void hashMapToDatabase_Reservation() {
        // Récupérer la HashMap contenant les réservations
        HashMap<Integer, Reservation> reservationMap = Hotel.getReservationMap();

        // Informations de connexion à la base de données
        String insertQuery = "INSERT INTO reservation (idUser, type, dateDebut, dateFin, idChambre, etat) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // Établir la connexion à la base de données
            Connection connection = connectToMySQL();

            // Préparer la déclaration d'insertion
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Parcourir la HashMap et insérer chaque réservation dans la base de données
            for (Map.Entry<Integer, Reservation> entry : reservationMap.entrySet()) {
                Reservation reservation = entry.getValue();
                if (!reservation.isIndb()) {
                    // Définir les valeurs pour la déclaration d'insertion
                    preparedStatement.setInt(1, reservation.getUser().getId());
                    preparedStatement.setString(2, reservation.getType());
                    preparedStatement.setString(3, reservation.getDateDebut().toString()); // Supposons que
                                                                                           // getDateDebut() retourne
                                                                                           // une chaîne de caractères
                                                                                           // pour la date
                    preparedStatement.setString(4, reservation.getDateFin().toString()); // Supposons que getDateFin()
                                                                                         // retourne une chaîne de
                                                                                         // caractères pour la date
                    preparedStatement.setInt(5, reservation.getChambre().getId());
                    preparedStatement.setString(6, reservation.getEtat().toString());

                    // Exécuter la requête d'insertion
                    preparedStatement.executeUpdate();
                    System.out.println("La Resevation: la Chambre iD: " + reservation.getChambre().getId());
                }
            }

            // Fermer les ressources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
    public static void afficherHashMap() {
        System.out.println("choisir un num: ");
        System.out.println("1 -> Users");
        System.out.println("3 -> Chambre");
        System.out.println("4 -> Reservation");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        switch (i) {
            case 1:
                for (Map.Entry<Integer, User> entry : Hotel.getUserMap().entrySet()) {
                    int id = entry.getKey();
                    User user = entry.getValue();

                    System.out.println("ID: " + id);
                    System.out.println("Name: " + user.getName());
                    System.out.println("Password: " + user.getPassword());
                    System.out.println("----------------------");
                }
                break;

            case 3:
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
            case 4:
                for (Map.Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
                    int id = entry.getKey();
                    Reservation reservation = entry.getValue();

                    System.out.println("ID: " + id);
                    System.out.println("ID User: " + reservation.getId_user());
                    System.out.println("Type: " + reservation.getType());
                    System.out.println("Date de début: " + reservation.getDateDebut());
                    System.out.println("Date de fin: " + reservation.getDateFin());
                    System.out.println("ID Chambre: " + reservation.getId_chambre());
                    System.out.println("État: " + reservation.getEtat());
                    System.out.println("----------------------");
                }
                break;

            default:
                System.out.println("hashMap n'existe pas !");
                break;
        }
        sc.close();

    }
}

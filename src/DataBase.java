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

            if (objet instanceof User ) {
                User user = (User) objet;
                if(operation == TypeOperation.AJOUT){
                AddUserDb(user);
                }
                else
                if(operation==TypeOperation.MODIFICATION){
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

            else if (objet instanceof Chambre) {
                Chambre chambre = (Chambre) objet;
                String ch ="Chambre";
                if (operation==TypeOperation.AJOUT) {

                    String insertQuery = "INSERT INTO rooms (type, prix) VALUES (?, ?, ?, ?, ?, ?)";                 
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

                }
            } // modification operation
            else
                if (objet instanceof Reservation) {
                    Reservation reservation = (Reservation) objet;
                    String res="Reservation";
                    if(operation == TypeOperation.AJOUT) {
                        String insertQuery = "INSERT INTO reservation (idUser, type, dateDebut, dateFin, idChambre, etat,prix) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setInt(1, reservation.getId_user());
                        preparedStatement.setString(2, reservation.getType().ToString());
                        preparedStatement.setString(3, reservation.getDateDebut().toString());
                        preparedStatement.setString(4, reservation.getDateFin().toString());
                        preparedStatement.setInt(5, reservation.getId_chambre());
                        preparedStatement.setString(6, reservation.getEtat().toString());
                        preparedStatement.setDouble(7, reservation.getPrix());
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+res+" / Operation: "+operation);

                    } else if (operation==TypeOperation.MODIFICATION) {
                        int idReservation = reservation.getId();
                        String updateQuery = "UPDATE reservation SET idUser = ?, type = ?, dateDebut = ?, dateFin = ?, idChambre = ?, etat = ?, prix = ? WHERE id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setInt(1, reservation.getId_user());
                        preparedStatement.setString(2, reservation.getType().ToString());
                        preparedStatement.setString(3, reservation.getDateDebut().toString());
                        preparedStatement.setString(4, reservation.getDateFin().toString());
                        preparedStatement.setInt(5, reservation.getId_chambre());
                        preparedStatement.setString(6, reservation.getEtat().toString());
                        preparedStatement.setDouble(7, reservation.getPrix());
                        preparedStatement.setInt(8, idReservation);
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
            
            else{
                if (objet instanceof Commentaires) {
                    Commentaires commentaires = (Commentaires) objet;
                    String cmnt="Commentaire";
                    if(operation == TypeOperation.AJOUT) {
                        String insertQuery = "INSERT INTO commentaires (iduser, date, commentaires, username) VALUES (?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                        preparedStatement.setInt(1, commentaires.getIduser());
                        preparedStatement.setString(2, commentaires.getDate().toString());
                        preparedStatement.setString(3, commentaires.getCommentaire());
                        preparedStatement.setString(4, commentaires.getUsername());
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+cmnt+" / Operation: "+operation);

                    } else if (operation==TypeOperation.MODIFICATION) {
                        int idcmnt = commentaires.getId();
                        String updateQuery = "UPDATE commentaires SET iduser = ?, date = ?, commentaires = ?, username = ? WHERE id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setInt(1, commentaires.getIduser());
                        preparedStatement.setString(2, commentaires.getDate().toString());
                        preparedStatement.setString(3, commentaires.getCommentaire());
                        preparedStatement.setString(4, commentaires.getUsername());
                        preparedStatement.setInt(8, idcmnt);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+cmnt+" / Operation: "+operation);

                    } else if (operation.equals(TypeOperation.SUPPRESSION)) {
                        int idcmnt = commentaires.getId();
                        String deleteQuery = "DELETE FROM commentaires WHERE id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                        preparedStatement.setInt(1, idcmnt);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+cmnt+" / Operation: "+operation);

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
                    System.out.println("note : "+user.getNote()+"/5");
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
                    System.out.println("SONA -> "+chambre.isSONA());
                    System.out.println("TERASSE  -> "+chambre.isTERASSE());
                    System.out.println("VUESURMERE  -> "+chambre.isVuesurmere());
                    System.out.println("VUESURFORET -> "+chambre.isVuesurforet());
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
                    System.out.println("Prix: "+reservation.getPrix());
                    System.out.println("----------------------");
                }
                break;
                case 4:
                for (Map.Entry<Integer, Commentaires> entry : Hotel.getCommentairesMap().entrySet()) {
                    int id = entry.getKey();
                    Commentaires commentaire = entry.getValue();
                    System.out.println("ID: " + id);
                    System.out.println("Commentaire: " + commentaire.getCommentaire());
                    System.out.println("Username: " + commentaire.getUsername());
                    System.out.println("ID utilisateur: " + commentaire.getIduser());
                    System.out.println("Date: " + commentaire.getDate());
                    System.out.println("------------------------");
                }

                break;
            case 5:

            for (Map.Entry<Integer, Option> entry : Hotel.getOptionHashMap().entrySet()) {
                int id = entry.getKey();
                Option option = entry.getValue();
        
                System.out.println("ID: " + id);
                System.out.println("Nom de l'option: " + option.getRooms_Options());
                System.out.println("Prix de l'option: " + option.getPrix_option());
                System.out.println("----------------------");
            }
            break;

            default:
                System.out.println("hashMap n'existe pas !");
                break;
        }

    }
}
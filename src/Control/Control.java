package Control;
import Model.*;
import View.*;


import java.sql.*;
import java.util.Map;

public class Control {

    public static Connection connectToMySQL() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hotel";
        String utilisateur = "root";
        String motDePasse = "islam";

        Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
        return connexion;
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

    public static void hash_map_bdd () throws Exception {
        User.hash_map_db();
        Reservation.hahs_map_bdd();;
        Chambre.hash_map_bdd();
        Commentaires.hash_map_bdd();
        //Option.hash_map_bdd();
       
       
    }
    


    public Control() throws Exception{

        Option.Bdd_to_hashMap_option();
        Commentaires.Bdd_to_hashMap_commantaire();
        User.Bdd_to_hashMap_users();
        Chambre.Bdd_to_hashMap_room();
        Reservation.Bdd_to_hashMap_reservation();

        Action_Login();

    }

    public static void Action_Login(){

       new Login();

        Login.seConnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                switch (Login.seConnecterbtnActionPerformed(evt)) {
                    case -1:
                    new Passer_a_signin();   
                        break;
                    case 1:
                    Chambre_interface ch = new Chambre_interface();
                    ch.setVisible(true);
                        break;
                    case 2:
                    new Loby_Admin();
                        break;
                   
                }
               
            }
        });

        Login.aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login.aProposbtnActionPerformed();
            }
        });

        Login.sinscrireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Signe_in();
                Login.fermerFenetre();
            }
        });

        Login.closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login.closebtnActionPerformed(evt);
            }
        });


        Login.langueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               // 7ta t3abez 3la box bch yasra had l fnct
                Login.changerlangue();
                Login.fermerFenetre();
                Action_Login();
                   
            }
        });












        if(Login.langueBox.getSelectedItem()=="English"||Login.langueBox.getSelectedItem()=="Anglais"){
            Hotel.langue=0;
            Login.loginFrame.dispose();
        }else{
            Hotel.langue=1;
            Login.loginFrame.dispose();
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

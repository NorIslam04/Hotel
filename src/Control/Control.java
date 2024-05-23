package Control;
import Model.*;
import Model.Chambre.OptionSupplementaire;
import Model.Chambre.TypeChambre;
import Model.Date;
import Model.Reservation.EtatReservation;
import View.*;
import Model.Hotel.TypeOperation;
import Model.Option.Rooms_Options;

import java.awt.Window;
import java.awt.event.*;



import java.sql.*;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
        Option.hahs_map_bdd();
        Hotel.getModificationMap().clear();


    }
    


    public Control() throws Exception{

        Option.Bdd_to_hashMap_option();
        Commentaires.Bdd_to_hashMap_commantaire();
        User.Bdd_to_hashMap_users();
        Chambre.Bdd_to_hashMap_room();
        Reservation.Bdd_to_hashMap_reservation();


        //les instructions doit etre trier pour l'execution de programme


        Action_Login();

    }

    public static void Action_Login(){ //fait

       new Login();

        Login.seConnerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                switch (Login.seConnecterbtnActionPerformed(evt)) {
                    case -1:
                    new Passer_a_signin();   
                        break;
                    case 1:
                    Loby_User ch = new Loby_User();
                    ch.setVisible(true);
                    SwingUtilities.getWindowAncestor(Login.seConnerButton).dispose();
                        break;
                    case 2:
                    new Loby_Admin();
                    SwingUtilities.getWindowAncestor(Login.seConnerButton).dispose();                        break;
                   
                }
               
            }
        });

        Login.aPropos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new APropos();
            }
        });

        Login.sinscrireButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Action_Signin();
                SwingUtilities.getWindowAncestor(Login.sinscrireButton).dispose();
            }
        });

        Login.closebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        Login.showPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login.togglePasswordVisibility();
            }
        });

        Login.langueBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               // 7ta t3abez 3la box bch yasra had l fnct
                Login.changerlangue();
                SwingUtilities.getWindowAncestor(Login.langueBox).dispose();;
                Action_Login();  
            }
        });
    }
    
    public static void Action_Signin(){//fait

        new Signe_in();

        Signe_in.seConnecterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Action_Login();
                SwingUtilities.getWindowAncestor(Signe_in.seConnecterButton).dispose();
        
            }

           
        });

        Signe_in.aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new APropos();
            }
        });

        Signe_in.closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        Signe_in.showPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Signe_in.togglePasswordVisibility();
            }
        });

        Signe_in.langueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Signe_in.changerlangue();
                SwingUtilities.getWindowAncestor(Signe_in.seConnecterButton).dispose();

                Action_Signin();
            }
        });

        Signe_in.submitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               switch (Signe_in.submitbtnActionPerformed(evt)) {
                case 1:
                Action_Login();  
                    break;

                case 2:
                User user = new User(User.getNb(), Signe_in.mailtext.getText(), Signe_in.usertext.getText(), Signe_in.pwdtext.getText(),-1);
                Hotel.AjtUserMap(user);
                Hotel.username_current=Signe_in.usertext.getText();
                Hotel.id_user_current=User.getNb();
                Hotel.neew=1;
                new Loby_User();

                    break;
                case 3:

                User user1 = new User(User.getNb(), Signe_in.mailtext.getText(), Signe_in.usertext.getText(), Signe_in.pwdtext.getText(),-1);
                Hotel.AjtUserMap(user1);
                Hotel.username_current=Signe_in.usertext.getText();
                Hotel.id_user_current=User.getNb();
                Hotel.neew=1;
                new Loby_User();
                SwingUtilities.getWindowAncestor(Signe_in.seConnecterButton).dispose();

                break;
               }
                
            }
        });

    }

    public static void Action_TableReservationUser(){//fait
        new Table_Reseravtion_User();

        Table_Reseravtion_User.cancelReservationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
 
                int i=Table_Reseravtion_User.cancelReservationBtnActionPerformed(evt);
                if (i>=0) {
                    OptionSupplementaire opt =OptionSupplementaire.tOptionSupplementaire(Table_Reseravtion_User.roompricebox.getSelectedItem().toString());
                    Reservation reservation=new Reservation(i, Hotel.id_user_current, Date.Recupere_date(Table_Reseravtion_User.enddatetext.getText()), Date.Recupere_date(Table_Reseravtion_User.startdatetext.getText()), TypeChambre.ToTypeChambre((String)Table_Reseravtion_User.roomtypebox.getSelectedItem()),-99, EtatReservation.toEtatReservation(Table_Reseravtion_User.state.getText()), -1,opt);
                    Hotel.SupprimerReservationMap(reservation);
                    
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    });


        Table_Reseravtion_User.addreservationbtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
            double i=Table_Reseravtion_User.addreservationbtnActionPerformed(evt);
            if (i>0) {
                OptionSupplementaire opt =OptionSupplementaire.tOptionSupplementaire(Table_Reseravtion_User.roompricebox.getSelectedItem().toString()) ;//TODO: recupirer dans le text filed
                Reservation reservation=new Reservation(Reservation.getNb()+1, Hotel.id_user_current, Date.Recupere_date(Table_Reseravtion_User.enddatetext.getText()), Date.Recupere_date(Table_Reseravtion_User.startdatetext.getText()), TypeChambre.ToTypeChambre((String)Table_Reseravtion_User.roomtypebox.getSelectedItem()),-1, EtatReservation.EN_ATTENTE,i,opt);
                Hotel.AjtReservationMap(reservation);
            }

        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    });



    Table_Reseravtion_User.tablereservation.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) { 
            Table_Reseravtion_User.tablereservationMouseClicked(evt);
        }
    });




    Table_Reseravtion_User.updatebtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                double i=Table_Reseravtion_User.updatebtnActionPerformed(evt);
                System.out.println(Table_Reseravtion_User.roompricebox.getSelectedItem().toString());
                OptionSupplementaire opt =OptionSupplementaire.tOptionSupplementaire(Table_Reseravtion_User.roompricebox.getSelectedItem().toString());       
                Reservation reservation =new Reservation(Table_Reseravtion_User.id_res,Hotel.id_user_current, Date.Recupere_date(Table_Reseravtion_User.enddatetext.getText()),  Date.Recupere_date(Table_Reseravtion_User.startdatetext.getText()), TypeChambre.ToTypeChambre((String)Table_Reseravtion_User.roomtypebox.getSelectedItem()),-1, EtatReservation.EN_ATTENTE,i,opt);
                Hotel.ModifierReservationMap(reservation);

            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
        }
    });

    Table_Reseravtion_User.exitbtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                if(Table_Reseravtion_User.exitbtnActionPerformed(evt)==1){
                    Control.hash_map_bdd();
                    SwingUtilities.getWindowAncestor(Table_Reseravtion_User.exitbtn).dispose();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    });

    Table_Reseravtion_User.backtoroomsbtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Control.hash_map_bdd();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                                              
                SwingUtilities.getWindowAncestor(Table_Reseravtion_User.exitbtn).dispose();
                new Chambre_interface();
            } 
    });


    }

    public static void Action_AdminOptionChambre(int i) throws Exception{

        TypeChambre typeChambre = TypeChambre.ToTypeChambre((String) Admin_chambres_option.roomtypebox.getSelectedItem());
        boolean Sona =   Admin_chambres_option.sonaCheckBox.isSelected();
        boolean climatisation =Admin_chambres_option. terasseCheckBox.isSelected();
        boolean vuesurmer = Admin_chambres_option.vuesurmerBox.isSelected();
        boolean vueforet = Admin_chambres_option.vuesurforetBox.isSelected();
      
        switch (i) {
            case 1:
            Chambre chambrerecherchee = new Chambre(Chambre.getNb()+1,typeChambre, Sona, climatisation, vuesurmer, vueforet);
            Hotel.AjtChambreMap(chambrerecherchee);
                break;

            case 2:
            if(Admin_chambres_option.id_supp_chamb !=-1){

                Hotel.getChambreMap().get(Admin_chambres_option.id_supp_chamb).setSup(1);
                ModificationHotel<Chambre, TypeOperation> suppReservation = new ModificationHotel<>(Admin_chambres_option.id_supp_chamb,
                Hotel.getChambreMap().get(Admin_chambres_option.id_supp_chamb), TypeOperation.SUPPRESSION);
                Hotel.getModificationMap().put(ModificationHotel.getNb(), suppReservation);
               
            
            }   
                break;
            
            case 3:
          
            if(Admin_chambres_option.id_supp_chamb !=-1){
                Chambre chambrerecherchee1 = new Chambre(Admin_chambres_option.id_supp_chamb, typeChambre, Sona, climatisation, vuesurmer, vueforet);   
                Hotel.ModifierChambreMap(chambrerecherchee1);
            }
            
                break;
            default:

            int id=0;
            Rooms_Options rooms_Options = Rooms_Options.ToTypeChambre(Admin_chambres_option.typeandoptionsbox.getSelectedItem().toString()) ;
            for (Map.Entry<Integer, Option> entry : Hotel.getOptionHashMap().entrySet()) {
                if (entry.getValue().getRooms_Options().equals(rooms_Options)) {
                    id= entry.getKey();
                    break;
                }
                    }
            double newprice=Double.parseDouble(Admin_chambres_option.nouveauprixtxt.getText());
            Option option = new Option(Rooms_Options.ToTypeChambre(Admin_chambres_option.typeandoptionsbox.getSelectedItem().toString()),newprice , id);
            Hotel.ModifieroptionMap(option);

            Hotel.getChambreMap().clear();

            Control.hash_map_bdd();

            Chambre.Bdd_to_hashMap_room();

                break;
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
                    System.out.println("NbrJourResrvation: " + reservation.getPrix());
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

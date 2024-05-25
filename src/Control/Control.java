package Control;
import Model.*;
import Model.Chambre.OptionSupplementaire;
import Model.Chambre.TypeChambre;
import Model.Reservation.EtatReservation;
import View.*;
import Model.Hotel.TypeOperation;
import Model.Option.Rooms_Options;

import java.awt.event.*;
import Model.Date;
import Model.Date.Date_nonvalid;

import java.sql.*;
import java.util.Map;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Control {

    public static double total_prix=-1;
    public static int tmp;
    public static Date date_debut;
    public static Date date_fin;
    public static Date today;


    static Login l;
    static Signe_in s;
    static APropos a;
    static Admin_chambres_option ACO;
    static Loby_Admin la;
    static Loby_User lu;
    static Table_Reseravtion_User tru;
    static Table_Reservation_Admin tra;
    static Tarif_Option_Chambres TOC;
    static Chambre_interface ci;
    static Facture fa;


    
    

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
        Hotel.getModificationMap().clear();//il faut !!!!!

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
    
    
    
    //cbn
    public static void Action_Login(){ 

       Login l=new Login();

        l.seConnerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            
                
                switch (l.seConnecterbtnActionPerformed(evt)) {
                    case -1:
                    if (tmp==0) {
                        Action_Signin();
                        l.dispose();  
                    }else{
                        System.exit(1);
                    } 
                        break;
                    case 1:
                    Loby_User ch = new Loby_User();
                    ch.setVisible(true);
                    l.dispose();
                        break;
                    case 2:
                    
                    new Loby_Admin();
                     l.dispose();                        break;
                   
                }
               
            }
        });

        l.aPropos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Control.Action_apropos();

                
            }
        });

        l.sinscrireButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Action_Signin();
                l.dispose();
            }
        });

        l.closebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        l.showPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l.togglePasswordVisibility();
            }
        });

        l.langueBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               // 7ta t3abez 3la box bch yasra had l fnct
                l.changerlangue();
                l.dispose();
                Action_Login();  
            }
        });
    
    }
    //cbn
    public static void Action_Signin(){//fait

        s=new Signe_in();

        s.seConnecterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Action_Login();
                s.dispose();
        
            }

           
        });

        s.aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Control.Action_apropos();
            }
        });

        s.closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        s.showPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                s.togglePasswordVisibility();
            }
        });

        s.langueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s.changerlangue();
               s.dispose();

                Action_Signin();
            }
        });

        s.submitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               switch (s.submitbtnActionPerformed(evt)) {
                case 1:
                Action_Login();  
                    break;

                case 2:
                Hotel.id_user_current=User.getNb();
                User user = new User(User.getNb(), s.mailtext.getText(), s.usertext.getText(), s.pwdtext.getText(),-1);
             
                Hotel.AjtUserMap(user);
                Hotel.username_current=s.usertext.getText();
       
                Hotel.neew=1;
                new Loby_User();

                      break;
                case 3:
                Hotel.id_user_current=User.getNb();
                User user1 = new User(User.getNb(), s.mailtext.getText(), s.usertext.getText(), s.pwdtext.getText(),-1);
                Hotel.AjtUserMap(user1);
                Hotel.username_current=s.usertext.getText();
                Hotel.neew=1;
                new Loby_User();
               s.dispose();

                break;
               }
                
            }
        });

    }

    //cbn
    public static void Action_TableReservationUser(String dated,String datef){
       tru=new Table_Reseravtion_User(dated,datef);
    
    
        //cbn
        tru.cancelReservationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {

                int id_res=tru.cancelReservationBtnActionPerformed(evt);
                if (id_res!=-1) {
                    OptionSupplementaire opt =OptionSupplementaire.tOptionSupplementaire(tru.roompricebox.getSelectedItem().toString());
                    Reservation reservation=new Reservation(id_res, Hotel.id_user_current, Date.Recupere_date(tru.enddatetext.getText()), Date.Recupere_date(tru.startdatetext.getText()), TypeChambre.ToTypeChambre((String)tru.roomtypebox.getSelectedItem()),-99, EtatReservation.toEtatReservation(tru.state.getText()), -1,opt);
                    Hotel.getReservationMap().get(id_res).sup=1;
                    ModificationHotel<Reservation, TypeOperation> suppReservation = new ModificationHotel<>(reservation.getId(),
					reservation, TypeOperation.SUPPRESSION);
			        Hotel.getModificationMap().put(ModificationHotel.getNb(), suppReservation);
                    tru.mettreajourlesreservation();
                    
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    });

    //cbn
    tru.addreservationbtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Date date_debut=Date.Recupere_date(tru.startdatetext.getText());
            Date date_fin=Date.Recupere_date(tru.enddatetext.getText());
            int nb_day=Date.differenceEntreDates(date_debut, date_fin);
            double prix=0;

            switch ((String)tru.roompricebox.getSelectedItem()) {
                case "SONA":
                prix=Option.GetPrix("SONA");
                    break;
                case "TERASSE":
                    prix=Option.GetPrix("TERASSE");
                        break;
                case "VUESURMERE":
                    prix=Option.GetPrix("VUESURMERE");
                        break;
                case "VUESURFORET":
                    prix=Option.GetPrix("VUESURFORET");
                        break;
                            
                default:
                    break;
            }

            switch ((String)tru.roomtypebox.getSelectedItem()) {
                case "SOLO":
                prix+=Option.GetPrix("SOLO");
                    break;
                case "DOUBLE":
                    prix+=Option.GetPrix("DOUBLE");
                        break;
                case "TRIPLE":
                    prix+=Option.GetPrix("TRIPLE");
                        break;
                case "SUITE":
                    prix+=Option.GetPrix("SUITE");
                        break;
                            
                default:
                    break;
            }
            total_prix=prix*nb_day;
            double i=tru.addreservationbtnActionPerformed(evt);
            if (i==1) {
                OptionSupplementaire opt =OptionSupplementaire.tOptionSupplementaire(tru.roompricebox.getSelectedItem().toString()) ;
                Reservation reservation=new Reservation(Reservation.getNb()+1, Hotel.id_user_current, Date.Recupere_date(tru.enddatetext.getText()), Date.Recupere_date(tru.startdatetext.getText()), TypeChambre.ToTypeChambre((String)tru.roomtypebox.getSelectedItem()),-1, EtatReservation.EN_ATTENTE,total_prix,opt);
                Hotel.AjtReservationMap(reservation);
            }

        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    });


    //cbn
    tru.tablereservation.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) { 
            tru.tablereservationMouseClicked(evt);
        }
    });



    //cbn
    tru.updatebtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                Date date_fin = Date.Recupere_date(tru.enddatetext.getText());
                Date date_debut = Date.Recupere_date(tru.startdatetext.getText());

                int nb_day=Date.differenceEntreDates(date_debut, date_fin);
                double prix=0;

                switch ((String)tru.roompricebox.getSelectedItem()) {
                    case "SONA":
                    prix=Option.GetPrix("SONA");
                        break;
                    case "TERASSE":
                        prix=Option.GetPrix("TERASSE");
                            break;
                    case "VUESURMERE":
                        prix=Option.GetPrix("VUESURMERE");
                            break;
                    case "VUESURFORET":
                        prix=Option.GetPrix("VUESURFORET");
                            break;
                                
                    default:
                        break;
                }
    
                switch ((String)tru.roomtypebox.getSelectedItem()) {
                    case "SOLO":
                    prix+=Option.GetPrix("SOLO");
                        break;
                    case "DOUBLE":
                        prix+=Option.GetPrix("DOUBLE");
                            break;
                    case "TRIPLE":
                        prix+=Option.GetPrix("TRIPLE");
                            break;
                    case "SUITE":
                        prix+=Option.GetPrix("SUITE");
                            break;
                                
                    default:
                        break;
                }

                total_prix=prix*nb_day;


                int id_res=tru.updatebtnActionPerformed(evt);
                if (id_res!=-1) {
                    
                OptionSupplementaire opt =OptionSupplementaire.tOptionSupplementaire(tru.roompricebox.getSelectedItem().toString());       
                Reservation reservation =new Reservation(id_res,Hotel.id_user_current, Date.Recupere_date(tru.enddatetext.getText()),  Date.Recupere_date(tru.startdatetext.getText()), TypeChambre.ToTypeChambre((String)tru.roomtypebox.getSelectedItem()),-1, EtatReservation.EN_ATTENTE,total_prix,opt);
                Hotel.ModifierReservationMap(reservation);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
        }
    });

    tru.closebtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                if(tru.closebtnActionPerformed(evt)==1){
                    Control.hash_map_bdd();
                    tru.dispose();
                    System.exit(1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    });

    tru.revenirbtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Control.hash_map_bdd();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                                              
             tru.dispose();
                Control.Action_Chambre_Intreface();
            } 
    });


    }
    //cbn
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
            case 4:

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
            case 5:
            Control.hash_map_bdd();
            System.exit(0);
                    break;

            case 6:
            Control.hash_map_bdd();
            SwingUtilities.getWindowAncestor(Admin_chambres_option.revenirbtn).dispose(); 
                    break;
        }            

                   

                


    }





    //sans database
    public static void Action_apropos(){

        a=new APropos();

        a.revenirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
          a.dispose();
                
            }
        });

        a.closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        a.langueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a.changerlangue();
                a.dispose();
                Action_apropos();
       
            }
        });
    }
    //cbn //sans data base
    public static void Action_Chambre_Intreface(){

        ci=new Chambre_interface();

        ci.aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Control.Action_apropos();
            }
        });

        ci.passeraureservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Control.Action_TableReservationUser("jj/mm/aaaa","jj/mm/aaaa");
              ci.dispose();
            }
        });

        ci.revenirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            ci.dispose();
            try {
                Control.hash_map_bdd();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
        });

        ci.avissurnousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    new Commentaires_Interface();
                } catch (Exception e) {
        
                    e.printStackTrace();
                }
            }
        });

        ci.reserverpardetailbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                   ci.dispose();
                    Control.Action_TariOptionChambre();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ci.closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(1);
            }
        });

        ci.langueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ci.changerlangue();
                ci.dispose();
                Control.Action_Chambre_Intreface();
       
            }
        });



    }

    public static void Action_TariOptionChambre() throws Exception{

       TOC=new Tarif_Option_Chambres();

        TOC.reserverbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                try{
                
                today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
                date_debut = new Date((Integer) TOC.jourdebutBox.getSelectedItem(),
                    (Integer) TOC.moisdebutBox.getSelectedItem(), (Integer) TOC.anneedebutBox.getSelectedItem());

                date_fin = new Date((Integer) TOC.jourfinBox.getSelectedItem(), (Integer) TOC.moisfinBox.getSelectedItem(),
                    (Integer) TOC.anneefinBox.getSelectedItem());
                    String Date_debuts = TOC.jourdebutBox.getSelectedItem() + "/" +
                    TOC.moisdebutBox.getSelectedItem() + "/" +
                    TOC.anneedebutBox.getSelectedItem();

                String date_fin = TOC.jourfinBox.getSelectedItem() + "/" +
                 TOC.moisfinBox.getSelectedItem() + "/" +
                 TOC.anneefinBox.getSelectedItem();

           

                TypeChambre typeChambre = TypeChambre.ToTypeChambre((String) TOC.roomtypebox.getSelectedItem());
                boolean tv = TOC.sonaCheckBox.isSelected();
                boolean climatisation = TOC.terasseCheckBox.isSelected();
                boolean vuesurmer = TOC.vuesurmerBox.isSelected();
                boolean vueforet = TOC.vuesurforetBox.isSelected();
                    if(TOC.reserverbtnbtnActionPerformed()!=-1){
                Chambre chambrerecherchee = new Chambre(0, typeChambre, tv, climatisation, vuesurmer, vueforet);
                total_prix=chambrerecherchee.getPrix();
                Control.Action_TableReservationUser(Date_debuts,date_fin);
                TOC.reserverbtnbtnActionPerformed();
               TOC.dispose();
                }

            }catch(Exception e){
                System.out.println(e.getMessage());
            }

            }
        });


        TOC.closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        TOC.afficherprixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
               try{
                
                today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
                date_debut = new Date((Integer) TOC.jourdebutBox.getSelectedItem(),
                    (Integer)TOC.moisdebutBox.getSelectedItem(), (Integer) TOC.anneedebutBox.getSelectedItem());

                date_fin = new Date((Integer) TOC.jourfinBox.getSelectedItem(), (Integer) TOC.moisfinBox.getSelectedItem(),
                    (Integer) TOC.anneefinBox.getSelectedItem());


                TypeChambre typeChambre = TypeChambre.ToTypeChambre((String) TOC.roomtypebox.getSelectedItem());
                boolean tv = TOC.sonaCheckBox.isSelected();
                boolean climatisation = TOC.terasseCheckBox.isSelected();
                boolean vuesurmer = TOC.vuesurmerBox.isSelected();
                boolean vueforet = TOC.vuesurforetBox.isSelected();
                    if(TOC.afficherprixbtnbtnActionPerformed()!=-1){
                Chambre chambrerecherchee = new Chambre(0, typeChambre, tv, climatisation, vuesurmer, vueforet);
                total_prix=chambrerecherchee.getPrix();
                TOC.afficherprixbtnbtnActionPerformed();
                }

            }catch(Exception e){
                System.out.println(e.getMessage());
            }

               
               
            }
        });

        TOC.revenirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOC.dispose();
                Control.Action_Chambre_Intreface();
            }
        });

        TOC.sonaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                TOC.terasseCheckBox.setSelected(false);
                TOC.vuesurforetBox.setSelected(false);
                TOC.vuesurmerBox.setSelected(false);
        

            }
        });

        TOC.terasseCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                TOC.sonaCheckBox.setSelected(false);
                TOC.vuesurforetBox.setSelected(false);
                TOC.vuesurmerBox.setSelected(false);

            }
        });


        TOC.vuesurforetBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                TOC.sonaCheckBox.setSelected(false);
                TOC.terasseCheckBox.setSelected(false);
                TOC.vuesurmerBox.setSelected(false);

            }
        });


        TOC.vuesurmerBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                TOC.sonaCheckBox.setSelected(false);
                TOC.terasseCheckBox.setSelected(false);
                TOC.vuesurforetBox.setSelected(false);

            }
        });

    }



       public static void Action_TableReservationAdmin(){

        tra=new Table_Reservation_Admin();

        tra.acceptdeclinebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultTableModel model= (DefaultTableModel)tra.reservationtabel.getModel();

                try {
                    int ii=tra.acceptdeclinebtnActionPerformed(evt);
                    if (ii!=0) {
                        int selectedRow= tra.reservationtabel.getSelectedRow();
                    OptionSupplementaire opt= OptionSupplementaire.tOptionSupplementaire(model.getValueAt(selectedRow, 3).toString());
                    TypeChambre typeChambre=TypeChambre.ToTypeChambre(model.getValueAt(selectedRow,2).toString());
                    String Date_debut=model.getValueAt(selectedRow,5).toString();
                    String Date_fin=model.getValueAt(selectedRow,6).toString();
                    int idReservation=Integer.parseInt(model.getValueAt(selectedRow,1).toString());
                    int idUser=Integer.parseInt(model.getValueAt(selectedRow,0).toString());

                    switch (ii) {

                        
                        case 1:
                        double prix =Hotel.getReservationMap().get(idReservation).getPrix();
                        Reservation newres=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,Table_Reservation_Admin.getId_chambre() ,EtatReservation.ACCEPTER,prix,opt);
                        Hotel.ModifierReservationMap(newres);
                            break;
                        case 2:
                        double prix1 =Hotel.getReservationMap().get(idReservation).getPrix();
                        Reservation newres1=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,-1 ,EtatReservation.DECLINER,prix1,opt);
                        Hotel.ModifierReservationMap(newres1);
                            break;
                    
                    }
                    }
                    

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        tra.updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    int i=tra.updatebtnActionPerformed(evt);
                    if (i!=-1) {
                        DefaultTableModel model =(DefaultTableModel)tra.reservationtabel.getModel();
                        int selectedRow= tra.reservationtabel.getSelectedRow();
                        TypeChambre typeChambre=TypeChambre.ToTypeChambre(model.getValueAt(selectedRow,2).toString());
                        String Date_debut=model.getValueAt(selectedRow,5).toString();
                        String Date_fin=model.getValueAt(selectedRow,6).toString();
                        int idReservation=Integer.parseInt(model.getValueAt(selectedRow,1).toString());
                        int idUser=Integer.parseInt(model.getValueAt(selectedRow,0).toString());
                        OptionSupplementaire opt= OptionSupplementaire.tOptionSupplementaire(model.getValueAt(selectedRow, 3).toString());
    
                        switch (i) {
                            case 1:
                            double prix =Hotel.getReservationMap().get(idReservation).getPrix();
                            Reservation newres=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,Table_Reservation_Admin.getId_chambre() ,EtatReservation.toEtatReservation(tra.acceptdeclinebox.getSelectedItem().toString()),prix,opt);
                            Hotel.ModifierReservationMap(newres);
                                break;
                            
                            case 2:
                            double prix1 =Hotel.getReservationMap().get(idReservation).getPrix();
                            Reservation newres1=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,-1 ,EtatReservation.toEtatReservation(tra.acceptdeclinebox.getSelectedItem().toString()),prix1,opt);
                            Hotel.ModifierReservationMap(newres1);
                                break;
                        }
                    }
                   

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        tra.closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        if(tra.closebtnActionPerformed(evt)){
                        Control.hash_map_bdd();
                        System.exit(1);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        
            tra.suppreservationbtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    tra.suppreservationbtnActionPerformed(evt);
                } catch (Date_nonvalid e) {
                     // TODO Auto-generated catch block
                    e.printStackTrace();
                    }
    
                }
            });
    

        tra.backtoroomsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                    try {
                        tra.dispose();
                        Control.hash_map_bdd();
                         
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                   
            }
        });


    }


        public static void Action_Facture() throws Date_nonvalid{

            fa=new Facture();

            fa.revenirbtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                Action_TableReservationUser("JJ/MM/AA", "JJ/MM/AA");
                }
            });

            fa.closebtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        Control.hash_map_bdd();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                System.exit(0);
                }
            });


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

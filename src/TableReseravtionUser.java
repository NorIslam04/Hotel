import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TableReseravtionUser extends javax.swing.JFrame {

    static private String Ptriple="500";
    static private String Psolo="100";
    static private String Psuite="700";
    static private String Pdouble="250";
    static private ArrayList<Integer> id_reservation = new ArrayList<>();
    static private ArrayList<Integer> id_chambre = new ArrayList<>();

    public void mettreajourlesreservation(){
        DefaultTableModel model = (DefaultTableModel) tablereservation.getModel();
        Object rowData[]=new Object[5];
        model.setRowCount(0);
        for (Map.Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
            Reservation reservation = entry.getValue(); // Récupérer l'objet Chambre
            if(Hotel.id_user_current==reservation.getId_user()){
            rowData[0]=reservation.getType();
            rowData[1]=reservation.getNbrJourReservation()*getPrixParType(reservation.getType());
            rowData[2]=reservation.getDateDebut();
            rowData[3]=reservation.getDateFin();
            rowData[4]=reservation.getEtat();
            id_reservation.add(reservation.getId());
            id_chambre.add(reservation.getId_chambre());
            model.addRow(rowData);
            
            }
        }
    }

    public float getPrixParType(TypeChambre typeChambre) {

        HashMap<Integer, Chambre> chambreMap=Hotel.getChambreMap();
    for (Chambre chambre : chambreMap.values()) {
        if (chambre.getType() == typeChambre) {
            return (float) chambre.getPrix();
        }
    }
    return 0;
    }


    public static String getPsolo() {
        return Psolo;
    }

    public static void setPsolo(String psolo) {
        Psolo = psolo;
    }

    public static String getPsuite() {
        return Psuite;
    }

    public static void setPsuite(String psuite) {
        Psuite = psuite;
    }

    public static String getPtriple() {
        return Ptriple;
    }

    public static void setPtriple(String ptriple) {
        Ptriple = ptriple;
    }

    public static String getPdouble() {
        return Pdouble;
    }

    public static void setPdouble(String pdouble) {
        Pdouble = pdouble;
    }


    public void parcourChambre(){
        Boolean so=false;
            Boolean d=false;
            Boolean t=false;
            Boolean su=false;
        
        for (Map.Entry<Integer, Chambre> entry : Hotel.getChambreMap().entrySet()) {
            
            Chambre chambre = entry.getValue(); // Récupérer l'objet Chambre
            switch (chambre.getType()) {
                case TypeChambre.SOLO:
                    setPsolo(String.valueOf(chambre.getPrix()));
                    so=true;
                    break;
                case TypeChambre.DOUBLE:
                    setPdouble(String.valueOf(chambre.getPrix()));
                    d=true;
                    break;
                    case TypeChambre.TRIPLE:
                    setPtriple(String.valueOf(chambre.getPrix()));
                    t=true;
                    break;
            
                default:
                setPsuite(String.valueOf(chambre.getPrix()));
                su=true;
                    break;
            }

            if(su&&t&&so&&d){
                break;
            }
        }
    }


    public TableReseravtionUser() {
        parcourChambre();
        initComponents();
    }


                         
    private void initComponents() {
        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());

        

        showtablelabel = new javax.swing.JLabel();
        caraclabel = new javax.swing.JLabel();
        roomtypelabel = new javax.swing.JLabel();
        startdatelabel = new javax.swing.JLabel();
        enddatelabel = new javax.swing.JLabel();
        statelabel = new javax.swing.JLabel();
        startdatetext = new javax.swing.JTextField();
        state = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablereservation = new javax.swing.JTable();
        addreservationbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        idroomlabel = new javax.swing.JLabel();
        exitbtn = new javax.swing.JButton();
        enddatetext = new javax.swing.JTextField();
        backtoroomsbtn = new javax.swing.JButton();
        roomtypebox = new javax.swing.JComboBox<>();
        roompricebox = new javax.swing.JComboBox<>();
        backgroundlabel = new javax.swing.JLabel();
        cancelReservationBtn = new javax.swing.JButton();

        cancelReservationBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // Définir la police
        cancelReservationBtn.setText("Cancel-Reservation"); // Définir le texte du bouton
        cancelReservationBtn.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
            cancelReservationBtnActionPerformed(evt);
        } catch (Exception e) {
            // Gérer les exceptions
            e.printStackTrace();
        }
    }
});
        cancelReservationBtn.setBounds(90, 415, 152, 30); // Définir les coordonnées et la taille du bouton
        getContentPane().add(cancelReservationBtn); // Ajouter le bouton au conteneur


        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setVisible(true);

        //creation d'une label pour le username avec ses caractéristiques.
        showtablelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); 
        showtablelabel.setForeground(new java.awt.Color(255, 255, 255));
        showtablelabel.setText("Here Are Your Reservations:");
        // le positionement exact du label.
        showtablelabel.setBounds(460, 40, 390, 30);
        getContentPane().add(showtablelabel);

        //creation d'une label pour le username avec ses caractéristiques.
        caraclabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 17)); // NOI18N
        caraclabel.setForeground(new java.awt.Color(255, 255, 255));
        caraclabel.setText("The Characteristics Of Your Room:");
        // le positionement exact du label.
        caraclabel.setBounds(20, 65, 310, 30);
        getContentPane().add(caraclabel);

        roomtypelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        roomtypelabel.setForeground(new java.awt.Color(255, 255, 255));
        roomtypelabel.setText("Room Price:");
        // le positionement exact du label.
        roomtypelabel.setBounds(30, 200, 1500, 30);
        getContentPane().add(roomtypelabel);

        startdatelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        startdatelabel.setForeground(new java.awt.Color(255, 255, 255));
        startdatelabel.setText("Start Date:");
        // le positionement exact du label.
        startdatelabel.setBounds(30, 260, 150, 30);
        getContentPane().add(startdatelabel);

        enddatelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        enddatelabel.setForeground(new java.awt.Color(255, 255, 255));
        enddatelabel.setText("End Date:");
        // le positionement exact du label.
        enddatelabel.setBounds(30, 320, 150, 30);
        getContentPane().add(enddatelabel);

        statelabel.setFont(new java.awt.Font("Bodoni MT", 0, 20)); // NOI18N
        statelabel.setForeground(new java.awt.Color(255, 255, 255));
        statelabel.setText("State:");
        // le positionement exact du label.
        statelabel.setBounds(30, 372, 150, 30);
        getContentPane().add(statelabel);

        startdatetext.setText("JJ/MM/AAAA");
        startdatetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startdatetextActionPerformed(evt);
            }
        });
        // le positionement exact du label.
        startdatetext.setBounds(160, 260, 150, 30);
        getContentPane().add(startdatetext);

  
        // le positionement exact du label.
        state.setBounds(159, 372, 220, 30);
        state.setText("Choisissez une réservation");
        state.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        state.setForeground(Color.WHITE);
        getContentPane().add(state);

        tablereservation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablereservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room-Type", "Total Price", "Start Date", "End Date", "State"
            }
        ));
        tablereservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablereservationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablereservation);
        // le positionement exact du label.
        jScrollPane1.setBounds(420, 90, 440, 450);
        getContentPane().add(jScrollPane1);

        addreservationbtn.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        addreservationbtn.setText("Add Reservation");
        addreservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addreservationbtnActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du label.
        addreservationbtn.setBounds(20, 460, 130, 30);
        getContentPane().add(addreservationbtn);

        updatebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        updatebtn.setText("Update-Now");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    updatebtnActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du label.
        updatebtn.setBounds(190, 460, 130, 30);
        getContentPane().add(updatebtn);

        idroomlabel.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        idroomlabel.setForeground(new java.awt.Color(255, 255, 255));
        idroomlabel.setText("Room Type:");
        // le positionement exact du label.
        idroomlabel.setBounds(30, 130, 100, 30);
        getContentPane().add(idroomlabel);

        exitbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    exitbtnActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du label.
        exitbtn.setBounds(190, 510, 130, 30);
        getContentPane().add(exitbtn);

        enddatetext.setText("JJ/MM/AAAA");
        enddatetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enddatetextActionPerformed(evt);
            }
        });
        // le positionement exact du label.
        enddatetext.setBounds(160, 320, 150, 30);
        getContentPane().add(enddatetext);
        backtoroomsbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        backtoroomsbtn.setText("Back To Rooms");
        backtoroomsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    backtoroomsbtnActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du label.
        backtoroomsbtn.setBounds(20, 510, 130, 30);
        getContentPane().add(backtoroomsbtn);

        roomtypebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));
        roomtypebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomtypeboxActionPerformed(evt);
                String selectedRoomType = (String) roomtypebox.getSelectedItem();
                if(selectedRoomType.equals("SOLO")) {
                    roompricebox.setSelectedItem(Psolo); // Set price to 100 if room type is "SOLO"
                }else if(selectedRoomType.equals("DOUBLE")){
                    roompricebox.setSelectedItem(Pdouble);
                }else if(selectedRoomType.equals("TRIPLE")){
                    roompricebox.setSelectedItem(Ptriple);
                }else if(selectedRoomType.equals("SUITE")){
                    roompricebox.setSelectedItem(Psuite);
                }
            }
        });
        // le positionement exact du label.
        roomtypebox.setBounds(160, 131, 150, 30);
        getContentPane().add(roomtypebox);
        roompricebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { getPsolo(), getPdouble(), getPtriple(), getPsuite() }));
        roompricebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roompriceboxActionPerformed(evt);
                String selectedRoomprice = (String) roompricebox.getSelectedItem();
                if(selectedRoomprice.equals(getPsolo())) {
                    roomtypebox.setSelectedItem("SOLO"); // Set price to 100 if room type is "SOLO"
                }else if(selectedRoomprice.equals(getPdouble())){
                    roomtypebox.setSelectedItem("DOUBLE");
                }else if(selectedRoomprice.equals(getPtriple())){
                    roomtypebox.setSelectedItem("TRIPLE");
                }else if(selectedRoomprice.equals(getPsuite())){
                    roomtypebox.setSelectedItem("SUITE");
                }
            }
        });
        // le positionement exact du label.
        roompricebox.setBounds(160, 200, 150, 30);
        getContentPane().add(roompricebox);

        backgroundlabel.setIcon(new javax.swing.ImageIcon("liste-de-reservations.png")); // NOI18N
        backgroundlabel.setText("Année");
        // le positionement exact du label.
        backgroundlabel.setBounds(0, 0, 920, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(936, 588));
        setLocationRelativeTo(null);
        mettreajourlesreservation();
    }// </editor-fold>                        

    private void startdatetextActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void statetxtActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }  
    
    
    private void cancelReservationBtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        int i=tablereservation.getSelectedRow();
        Date today =new Date(Date.getToday_jour(),Date.getToday_mois(),Date.getToday_annee());
        DefaultTableModel model =(DefaultTableModel)tablereservation.getModel();
      if(i>=0){
          model.setValueAt(roomtypebox.getSelectedItem(),i,0);
          model.setValueAt(roompricebox.getSelectedItem(),i,1);
          model.setValueAt(startdatetext.getText(),i,2);
          model.setValueAt(enddatetext.getText(),i,3);
          model.setValueAt(state.getText(),i,4);
          if(Date.comparer(Date.Recupere_date(startdatetext.getText()), today)==1){
            JOptionPane.showMessageDialog(this, "Réservation annulée avec succès.");
            Reservation reservation=new Reservation(id_reservation.get(i), Hotel.id_user_current,Date.Recupere_date(enddatetext.getText()), Date.Recupere_date(startdatetext.getText()),TypeChambre.ToTypeChambre(roomtypebox.getSelectedItem().toString()), id_chambre.get(i),EtatReservation.toEtatReservation(state.getText()));
            Hotel.SupprimerReservationMap(reservation);
            model.removeRow(i);
          }else{
            JOptionPane.showMessageDialog(this, "Vous ne pouvez pas annuler cette réservation !", "Erreur", JOptionPane.ERROR_MESSAGE);
          }
      }else{
          JOptionPane.showMessageDialog(null,"Veuillez sélectionner une réservation à annuler.");
      }
    }

    private void addreservationbtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception { 
        try{
        Date today=new Date(Date.getToday_jour(),Date.getToday_mois(),Date.getToday_annee());
        Date date_debut=Date.Recupere_date(startdatetext.getText());
        Date.verif_today_date(today, date_debut);
        Date date_fin=Date.Recupere_date(enddatetext.getText());
        int id_user=Hotel.id_user_current;

        TypeChambre typeChambre=TypeChambre.ToTypeChambre((String)roomtypebox.getSelectedItem());

        Reservation reservation =new Reservation(Reservation.getNb(),id_user , date_fin, date_debut, typeChambre,-1, EtatReservation.EN_ATTENTE);
        Hotel.AjtReservationMap(reservation);

        DefaultTableModel Model=(DefaultTableModel) tablereservation.getModel();
        double prix_resevation = Double.parseDouble((String) roompricebox.getSelectedItem()) * reservation.getNbrJourReservation();
        Model.addRow(new Object[]{roomtypebox.getSelectedItem(),prix_resevation,startdatetext.getText(),enddatetext.getText(),EtatReservation.EN_ATTENTE});


    } catch(Date_syntaxe e){
        JOptionPane.showMessageDialog(frame,
        "entrer des chiffres dans les dates !",
        "Erreur",
        JOptionPane.ERROR_MESSAGE);

    
   } catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(frame,
                "entrer des chiffres dans les dates !",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);

   } catch(Date_nonvalid e){
   
    JOptionPane.showMessageDialog(frame,
                e.getMessage(),
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
    

   } catch(Date_Debut_Reservation e) {
    JOptionPane.showMessageDialog(frame,
                e.getMessage(),
                "Erreur",
                JOptionPane.ERROR_MESSAGE);

   }catch(Date_nonorganiser e){
    JOptionPane.showMessageDialog(frame,
                e.getMessage(),
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
   } catch(DiffSup365 e){
    JOptionPane.showMessageDialog(frame,
                e.getMessage(),
                "Erreur",
                JOptionPane.INFORMATION_MESSAGE);
   }                                          
} 
                                                 

    private void tablereservationMouseClicked(java.awt.event.MouseEvent evt) {                                              
        int selectedRow= tablereservation.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)tablereservation.getModel();
        roomtypebox.setSelectedItem(model.getValueAt(selectedRow,0).toString());
        roompricebox.setSelectedItem(model.getValueAt(selectedRow,1).toString());
        startdatetext.setText(model.getValueAt(selectedRow,2).toString());
        enddatetext.setText(model.getValueAt(selectedRow,3).toString());
        //ACCEPTER,DECLINER,EN_ATTENTE;
        if(model.getValueAt(selectedRow,4).toString().equals("ACCEPTER")){
            state.setForeground(Color.GREEN);
        }else if(model.getValueAt(selectedRow,4).toString().equals("DECLINER")){
            state.setForeground(Color.RED);
        }else{
            state.setForeground(Color.ORANGE);
        }
        state.setText(model.getValueAt(selectedRow,4).toString());
    }                                             

 
    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                          
        int i = tablereservation.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tablereservation.getModel();
        if (i >= 0) {
            try {
                Date today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
                Date date_debut = Date.Recupere_date(startdatetext.getText());
                Date.verif_today_date(today, date_debut);
                Date date_fin = Date.Recupere_date(enddatetext.getText());
                if(Date.comparer(date_debut, today)==1){
    
                TypeChambre typeChambre=TypeChambre.ToTypeChambre((String)roomtypebox.getSelectedItem());
    
                Reservation reservation =new Reservation(id_reservation.get(i),Hotel.id_user_current , date_fin, date_debut, typeChambre,-1, EtatReservation.EN_ATTENTE);
                Hotel.ModifierReservationMap(reservation);
                double prix_resevation = Double.parseDouble((String) roompricebox.getSelectedItem()) * reservation.getNbrJourReservation();
                // Mise à jour des valeurs dans le modèle de tableau
                model.setValueAt(roomtypebox.getSelectedItem(), i, 0);
                model.setValueAt(prix_resevation, i, 1);
                model.setValueAt(startdatetext.getText(), i, 2);
                model.setValueAt(enddatetext.getText(), i, 3);
                model.setValueAt("EN_ATTEND", i, 4);
                }else{
                    JOptionPane.showMessageDialog(null, "Vous ne pouvez pas modifier cette réservation", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Date_syntaxe e){
                JOptionPane.showMessageDialog(frame,
                "entrer des chiffres dans les dates !",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        
            
           } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame,
                        "entrer des chiffres dans les dates !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
        
           } catch(Date_nonvalid e){
           
            JOptionPane.showMessageDialog(frame,
                        e.getMessage(),
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            
        
           } catch(Date_Debut_Reservation e) {
            JOptionPane.showMessageDialog(frame,
                        e.getMessage(),
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
        
           }catch(Date_nonorganiser e){
            JOptionPane.showMessageDialog(frame,
                        e.getMessage(),
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
           } catch(DiffSup365 e){
            JOptionPane.showMessageDialog(frame,
                        e.getMessage(),
                        "Erreur",
                        JOptionPane.INFORMATION_MESSAGE);
           }             
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à mettre à jour.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
private JFrame frame;
    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                        
       frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"DO YOU REALY WANT TO EXIT","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            DataBase.HasgMapsToDb();
            System.exit(0);
        }
    }                                       

    private void backtoroomsbtnActionPerformed(java.awt.event.ActionEvent evt) throws SQLException { 
        DataBase.HasgMapsToDb();                                              
        this.dispose();
        new chambreinterface();
    }                                              

    private void enddatetextActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void roompriceboxActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void roomtypeboxActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableReseravtionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableReseravtionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableReseravtionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableReseravtionUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableReseravtionUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addreservationbtn;
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JButton backtoroomsbtn;
    private javax.swing.JLabel caraclabel;
    private javax.swing.JLabel enddatelabel;
    private javax.swing.JTextField enddatetext;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel idroomlabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> roompricebox;
    private javax.swing.JComboBox<String> roomtypebox;
    private javax.swing.JLabel roomtypelabel;
    private javax.swing.JLabel showtablelabel;
    private javax.swing.JLabel startdatelabel;
    private javax.swing.JTextField startdatetext;
    private javax.swing.JLabel statelabel;
    private javax.swing.JLabel state;
    private javax.swing.JTable tablereservation;
    private javax.swing.JButton updatebtn;
    private javax.swing.JButton  cancelReservationBtn;
    // End of variables declaration                   
}

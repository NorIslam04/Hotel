import java.awt.event.WindowListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TableReseravtionUser extends javax.swing.JFrame {

    public TableReseravtionUser() {
        
        initComponents();
    }
                        
    private void initComponents() {
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        roomtypelabel = new javax.swing.JLabel();
        startdatelabel = new javax.swing.JLabel();
        enddatelabel = new javax.swing.JLabel();
        roompricelabel = new javax.swing.JLabel();
        idroomtext = new javax.swing.JTextField();
        roomtypetext = new javax.swing.JTextField();
        startdatetext = new javax.swing.JTextField();
        roompricetext = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablereservation = new javax.swing.JTable();
        addreservationbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        idroomlabel = new javax.swing.JLabel();
        exitbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        enddatetext = new javax.swing.JTextField();
        backgroundlabel = new javax.swing.JLabel();

        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Table de réservation pour l'utilisateur");
        setLocationRelativeTo(null);
        setVisible(true);
        
        //creation d'une label pour le description des réservation avec ses caractéristiques.
        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 0, 24));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Here Are Your Reservations:");
        // le positionement exact du label.
        jLabel2.setBounds(460, 40, 390, 30);
        getContentPane().add(jLabel2);
        
        //creation d'une label pour les caractéristiques des chambres avec ses caractéristiques.
        jLabel3.setFont(new java.awt.Font("Bodoni MT Black", 0, 14));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("The Characteristics Of Your Room:");
        // le positionement exact du label.
        jLabel3.setBounds(50, 80, 260, 30);
        getContentPane().add(jLabel3);

        //creation d'une label pour l'ID de la chambre avec ses caractéristiques.
        idroomlabel.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        idroomlabel.setForeground(new java.awt.Color(255, 255, 255));
        idroomlabel.setText("ID-Room:");
        // le positionement exact du label.
        idroomlabel.setBounds(30, 140, 150, 50);
        getContentPane().add(idroomlabel);

        //creation d'une label pour le type de la chambre avec ses caractéristiques.
        roomtypelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        roomtypelabel.setForeground(new java.awt.Color(255, 255, 255));
        roomtypelabel.setText("Room Type:");
        // le positionement exact du label.
        roomtypelabel.setBounds(30, 200, 120,50);
        getContentPane().add(roomtypelabel);
        
        //creation d'une label pour la date de début avec ses caractéristiques.
        startdatelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        startdatelabel.setForeground(new java.awt.Color(255, 255, 255));
        startdatelabel.setText("Start Date:");
        // le positionement exact du label.
        startdatelabel.setBounds(30, 260,120,50);
        getContentPane().add(startdatelabel);

        //creation d'une label pour la date de fin avec ses caractéristiques.
        enddatelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        enddatelabel.setForeground(new java.awt.Color(255, 255, 255));
        enddatelabel.setText("End Date:");
        // le positionement exact du label.
        enddatelabel.setBounds(30, 330, 120, 50);
        getContentPane().add(enddatelabel);

        //creation d'une label pour la prix de la chambre avec ses caractéristiques.
        roompricelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        roompricelabel.setForeground(new java.awt.Color(255, 255, 255));
        roompricelabel.setText("Room Price:");
        // le positionement exact du label.
        roompricelabel.setBounds(30, 400, 120, 50);
        getContentPane().add(roompricelabel);

        //les TextFields:

        idroomtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idroomtextActionPerformed(evt);
            }
        });
        // le positionement exact du text field.
        idroomtext.setBounds(160, 140, 150, 30);
        getContentPane().add(idroomtext);

        roomtypetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomtypetextActionPerformed(evt);
            }
        });
        // le positionement exact du text field.
        roomtypetext.setBounds(160, 200, 150, 30);
        getContentPane().add(roomtypetext);

        startdatetext.setText("JJ/MM/AA");
        startdatetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startdatetextActionPerformed(evt);
            }
        });
        startdatetext.setBounds(160, 260, 150, 30);
        getContentPane().add(startdatetext);

        enddatetext.setText("JJ/MM/AA");
        // le positionement exact du text field.
        enddatetext.setBounds(160, 330, 150, 30);
        getContentPane().add(enddatetext);

        roompricetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roompricetextActionPerformed(evt);
            }
        });
        // le positionement exact du text field.
        roompricetext.setBounds(160, 400, 150, 30);
        getContentPane().add(roompricetext);

        // la Table des Réservations:
        tablereservation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablereservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID-Room", "Room-Type", "Start Date", "End Date", "Room Price"
            }
        ));
        tablereservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablereservationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablereservation);
        // le positionement exact du text field.
        jScrollPane1.setBounds(420, 130, 440, 330);
        getContentPane().add(jScrollPane1);

        //les bouttons:

        addreservationbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        addreservationbtn.setText("Add Reservation");
        addreservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addreservationbtnActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du boutton.
        addreservationbtn.setBounds(20, 460, 130, 30);
        getContentPane().add(addreservationbtn);

        updatebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        updatebtn.setText("Update-Now");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        // le positionement exact du boutton.
        updatebtn.setBounds(190, 460, 130, 30);
        getContentPane().add(updatebtn);

        exitbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        // le positionement exact du boutton.
        exitbtn.setBounds(190, 510, 130, 30);
        getContentPane().add(exitbtn);

        backbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        backbtn.setText("Back To Rooms");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        
        // le positionement exact du boutton.
        backbtn.setBounds(20, 510, 130, 30);
        getContentPane().add(backbtn);


        backgroundlabel.setIcon(new javax.swing.ImageIcon("liste-de-reservations.png"));
        backgroundlabel.setText("AnnÃ©e");
        // le positionement exact du label.
        backgroundlabel.setBounds(0, 0, 920, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(936, 588));
        setLocationRelativeTo(null);

        //for loop 
        //reservation 
        //if(id_user==id){

        //}
    }                      

    private void roomtypetextActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void startdatetextActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void roompricetextActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                               

    private void addreservationbtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception { 

            Date today = new Date(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
            Date date_debut = Date.Recupere_date(startdatetext.getText());
            Date.verif_today_date(today, date_debut);
            Date date_fin = Date.Recupere_date(enddatetext.getText());
            //Date.differenceEntreDates(date_debut, date_fin);
            int id_user = 0001; // des instructions pour récupérer le id_user
            int id_chambre = 0002; // des instructions pour récupérer le id_chambre
            Reservation reservation = new Reservation(Reservation.getNb(), id_user, date_fin, date_debut, TypeChambre.ToTypeChambre(roomtypetext.getText()),id_chambre,  EtatReservation.EN_ATTENTE);
            Hotel.modifierMap(reservation,TypeOperation.AJOUT);//hna lzem nst3amlo had l fct machi lokhra !!!
            DataBase.HasgMapsToDb();
            DefaultTableModel Model = (DefaultTableModel) tablereservation.getModel();
            Model.addRow(new Object[]{idroomtext.getText(), roomtypetext.getText(), startdatetext.getText(), enddatetext.getText(), roompricetext.getText()});
        
    }
  


    private void tablereservationMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow= tablereservation.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)tablereservation.getModel();
        idroomtext.setText(model.getValueAt(selectedRow,0).toString());
        roomtypetext.setText(model.getValueAt(selectedRow,1).toString());
        startdatetext.setText(model.getValueAt(selectedRow,2).toString());
        enddatetext.setText(model.getValueAt(selectedRow,3).toString());
        roompricetext.setText(model.getValueAt(selectedRow,4).toString());
    }                                             

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
      int i=tablereservation.getSelectedRow();
      DefaultTableModel model =(DefaultTableModel)tablereservation.getModel();
      if(i>=0){
          model.setValueAt(idroomtext.getText(),i,0);
          model.setValueAt(roomtypetext.getText(),i,1);
          model.setValueAt(startdatetext.getText(),i,2);
          model.setValueAt(enddatetext.getText(),i,3);
          model.setValueAt(roompricetext.getText(),i,4);
          
      }else{
          JOptionPane.showMessageDialog(null,"Error");
      }
    }                                         

    private void idroomtextActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          
    private JFrame frame;
    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
       frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"DO YOU REALY WANT TO EXIT","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
    }      
    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        chambreinterface ch = new chambreinterface();
        ch.setVisible(true);
        this.hide();
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
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableReseravtionUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addreservationbtn;
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JLabel enddatelabel;
    private javax.swing.JTextField enddatetext;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel idroomlabel;
    private javax.swing.JTextField idroomtext;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel roompricelabel;
    private javax.swing.JTextField roompricetext;
    private javax.swing.JLabel roomtypelabel;
    private javax.swing.JTextField roomtypetext;
    private javax.swing.JLabel startdatelabel;
    private javax.swing.JTextField startdatetext;
    private javax.swing.JTable tablereservation;
    private javax.swing.JButton updatebtn;
    private javax.swing.JButton backbtn;
    // End of variables declaration                   
}
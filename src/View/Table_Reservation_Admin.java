package View;
import Model.*;
import Model.Date.*;
import Model.Reservation.EtatReservation;
import Model.Chambre.*;
import Control.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Table_Reservation_Admin extends javax.swing.JFrame {
 private static int id_chambre;

    public static int getId_chambre() {
    return id_chambre;
}

public static void setId_chambre(int id_chambre) {
    Table_Reservation_Admin.id_chambre = id_chambre;
}

    public void mettreajourlesreservationadmin(){
        DefaultTableModel model = (DefaultTableModel) reservationtabel.getModel();
        Object rowData[]=new Object[7];
        model.setRowCount(0);
        for (Map.Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
            Reservation reservation = entry.getValue(); // Récupérer l'objet Chambre
            rowData[0]=reservation.getId_user();
            rowData[1]=reservation.getId();
            rowData[2]=reservation.getType();
            rowData[3]=reservation.getNbrJourReservation()*getPrixParType(reservation.getType());
            rowData[4]=reservation.getDateDebut();
            rowData[5]=reservation.getDateFin();
            rowData[6]=reservation.getEtat();
            model.addRow(rowData);
            
        }
    }

    public Double getPrixParType(TypeChambre typeChambre) {

         HashMap<Integer, Chambre> chambreMap=Hotel.getChambreMap();
    for (Chambre chambre : chambreMap.values()) {
        if (chambre.getType() == typeChambre) {
            return chambre.getPrix();
        }
    }
    return null;
    }

    public Table_Reservation_Admin() {
        initComponents();
        mettreajourlesreservationadmin();
    }
                       
    private void initComponents() {
        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());
        suppreservationbtn =new javax.swing.JButton();
        reservationlabel = new javax.swing.JLabel();
        acceptdeclinelabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationtabel = new javax.swing.JTable();
        updatebtn = new javax.swing.JButton();
        acceptdeclinebox = new javax.swing.JComboBox<>();
        acceptdeclinebtn = new javax.swing.JButton();
        clicklabel = new javax.swing.JLabel();
        selectlabel = new javax.swing.JLabel();
        backgroundlabel = new javax.swing.JLabel();
        closebtn = new javax.swing.JButton();
        backtoroomsbtn = new javax.swing.JButton();

        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setVisible(true);


        reservationlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        reservationlabel.setForeground(new java.awt.Color(255, 255, 255));
        reservationlabel.setText("Here Are All The Reservations:");
        // le positionement exact du label.
        reservationlabel.setBounds(440, 30, 390, 30);
        getContentPane().add(reservationlabel);

        acceptdeclinelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        acceptdeclinelabel.setForeground(new java.awt.Color(255, 255, 255));
        acceptdeclinelabel.setText("Accept/Decline Rservation");
        // le positionement exact du label.
        acceptdeclinelabel.setBounds(10, 30, 330, 30);
        getContentPane().add(acceptdeclinelabel);

        reservationtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID-User", "ID-Reser", "Room Type", "Reser Price", "Start Date", "End Date", "State"
            }
        ));
        reservationtabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    reservationtabelMouseClicked(evt);
                } catch (NumberFormatException  | Date_nonvalid | Date_syntaxe e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        jScrollPane1.setViewportView(reservationtabel);
        // le positionement exact du label.
        jScrollPane1.setBounds(370, 70, 540, 460);
        getContentPane().add(jScrollPane1);


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
        updatebtn.setBounds(190, 100, 160, 40);
        getContentPane().add(updatebtn);

        acceptdeclinebox.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        acceptdeclinebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACCEPTER", "DECLINER" }));
        acceptdeclinebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptdeclineboxActionPerformed(evt);
            }
        });
        // le positionement exact du label.
        acceptdeclinebox.setBounds(20, 100, 150, 40);
        getContentPane().add(acceptdeclinebox);

        acceptdeclinebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        acceptdeclinebtn.setText("ACCEPT/DECLINE");
        acceptdeclinebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    acceptdeclinebtnActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du label.
        acceptdeclinebtn.setBounds(190, 240, 160, 40);
        getContentPane().add(acceptdeclinebtn);

        suppreservationbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        suppreservationbtn.setText("Reservation inutile");
        suppreservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    suppreservationbtnActionPerformed(evt);
                } catch (Date_nonvalid   e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        suppreservationbtn.setBounds(100, 380, 160, 30);
        getContentPane().add(suppreservationbtn);

        closebtn.setBackground(new java.awt.Color(171, 34, 34));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        closebtn.setText("Close");
        closebtn.setForeground(Color.WHITE);
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    closebtnActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du label.
        closebtn.setBounds(190, 480, 150, 40);
        getContentPane().add(closebtn);
       

        backtoroomsbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        backtoroomsbtn.setText("Back To Rooms");
        backtoroomsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    backtoroomsbtnActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du label.
        backtoroomsbtn.setBounds(20, 480, 150, 40);
        getContentPane().add(backtoroomsbtn);

        clicklabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        clicklabel.setForeground(new java.awt.Color(255, 255, 255));
        clicklabel.setText("And Click Here:");
        // le positionement exact du label.
        clicklabel.setBounds(20, 250, 160, 30);
        getContentPane().add(clicklabel);

        selectlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        selectlabel.setForeground(new java.awt.Color(255, 255, 255));
        selectlabel.setText("Select The Reservation ");
        // le positionement exact du label.
        selectlabel.setBounds(20, 206, 220, 20);
        getContentPane().add(selectlabel);

        backgroundlabel.setIcon(new javax.swing.ImageIcon("liste-de-reservations.png")); // NOI18N
        // le positionement exact du label.
        backgroundlabel.setBounds(0, 0, 920, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(936, 588));
        setLocationRelativeTo(null);
        
    }// </editor-fold>                        

    private void reservationtabelMouseClicked(java.awt.event.MouseEvent evt) throws Exception {                                              
        int selectedRow= reservationtabel.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)reservationtabel.getModel();                                            
}

    private int EnAttente() throws Exception{
        
        int selectedRow= reservationtabel.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)reservationtabel.getModel();
        TypeChambre typeChambre=TypeChambre.ToTypeChambre(model.getValueAt(selectedRow,2).toString());
        String Date_debut=model.getValueAt(selectedRow,4).toString();
        String Date_fin=model.getValueAt(selectedRow,5).toString();
        

        Chambre tmp_Chambre = Hotel.attribuerchambre(typeChambre, Date.Recupere_date(Date_debut),Date.Recupere_date(Date_fin));

        
            if(tmp_Chambre==null){//decliner
                return 0;
            }else{//accepter
                setId_chambre(tmp_Chambre.getId());
                return 1;
            }
        

    }
    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, Exception {                                          
      int i=reservationtabel.getSelectedRow();

      DefaultTableModel model =(DefaultTableModel)reservationtabel.getModel();
      int selectedRow= reservationtabel.getSelectedRow();
      TypeChambre typeChambre=TypeChambre.ToTypeChambre(model.getValueAt(selectedRow,2).toString());
      String Date_debut=model.getValueAt(selectedRow,4).toString();
      String Date_fin=model.getValueAt(selectedRow,5).toString();
      int idReservation=Integer.parseInt(model.getValueAt(selectedRow,1).toString());
      int idUser=Integer.parseInt(model.getValueAt(selectedRow,0).toString());
      String etat=model.getValueAt(selectedRow,6).toString();
      if(i>=0){
        if(!etat.equals("ACCEPTER")){

          model.setValueAt(acceptdeclinebox.getSelectedItem(),i,6);
          if(EnAttente()==1){
            double prix =-1;//hna ya nricipiriwah m lintereface wla ndiro une variable static, 7kayatha kima idChambre
            Reservation newres=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,getId_chambre() ,EtatReservation.toEtatReservation(acceptdeclinebox.getSelectedItem().toString()),prix);
            Hotel.ModifierReservationMap(newres);
                    
            }else{
                double prix =-1;//hna ya nricipiriwah m lintereface wla ndiro une variable static
                Reservation newres=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,-1 ,EtatReservation.toEtatReservation(acceptdeclinebox.getSelectedItem().toString()),prix);
                Hotel.ModifierReservationMap(newres);
            } 
        }else{
            JOptionPane.showMessageDialog(frame,
            "DEJA ACCEPTER !",
            "ACCEPTER",
            JOptionPane.INFORMATION_MESSAGE);

        }
      }else{
          JOptionPane.showMessageDialog(null,"Error");
      }
       
    }                   
    
    private void suppreservationbtnActionPerformed(java.awt.event.ActionEvent evt) throws Date_nonvalid {                                           
        Admin.supprimerreservationinutile();
    } 

    private void acceptdeclinebtnActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, Exception {
        DefaultTableModel model= (DefaultTableModel)reservationtabel.getModel();
        int selectedRow= reservationtabel.getSelectedRow();
        String etat=model.getValueAt(selectedRow,6).toString();
        if(etat.equals("ACCEPTER")){

            JOptionPane.showMessageDialog(frame,
            "DEJA ACCEPTER !",
            "ACCEPTER",
            JOptionPane.INFORMATION_MESSAGE);
        }  
        else{                                               
       if(EnAttente()==1){
        JOptionPane.showMessageDialog(frame,
                "Vous pouvez 'ACCEPTER' cette reservation !",
                "ACCEPTER",
                JOptionPane.INFORMATION_MESSAGE);
        }else if(EnAttente()==0){
            JOptionPane.showMessageDialog(frame,
            "Vous devez 'DECLINER' cette reservation !",
            "DECLINER",
            JOptionPane.INFORMATION_MESSAGE);
        }  
    }                            
    }
                                                  

    private void acceptdeclineboxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }   
    private void backtoroomsbtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                               
        new Admin_chambres_option();
        Control.hash_map_bdd();
        this.dispose();
    }                                              

    private JFrame frame;
    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                         
    frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"DO YOU REALY WANT TO CLOSE THIS WINDOW?","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {   

            Control.hash_map_bdd();
            System.exit(0);
        }
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
            java.util.logging.Logger.getLogger(Table_Reservation_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table_Reservation_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table_Reservation_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table_Reservation_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table_Reservation_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify   
    private javax.swing.JButton suppreservationbtn;                  
    private javax.swing.JComboBox<String> acceptdeclinebox;
    private javax.swing.JButton acceptdeclinebtn;
    private javax.swing.JLabel acceptdeclinelabel;
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JLabel clicklabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel reservationlabel;
    private javax.swing.JTable reservationtabel;
    private javax.swing.JLabel selectlabel;
    private javax.swing.JButton updatebtn;
    private javax.swing.JButton closebtn;
    private javax.swing.JButton backtoroomsbtn;
    // End of variables declaration                   
}



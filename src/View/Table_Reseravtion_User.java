package View;
import Model.*;
import Control.*;
import Model.Chambre.*;
import Model.Date.*;
import Model.Reservation.*;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Table_Reseravtion_User extends javax.swing.JFrame {


 
   
    private static JFrame frame;
    public static int id_res=0;
   

    public static void mettreajourlesreservation(){
        DefaultTableModel model = (DefaultTableModel) tablereservation.getModel();
        Object rowData[]=new Object[7];
        model.setRowCount(0);
        for (Map.Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
            Reservation reservation = entry.getValue(); // Récupérer l'objet Chambre
            if(Hotel.id_user_current==reservation.getId_user()&& reservation.sup!=1){
            rowData[0]=reservation.getId();
            rowData[1]=reservation.getType();
            rowData[2]=reservation.getOption();
            rowData[3] =reservation.getPrix()+"$";
            rowData[4]=reservation.getDateDebut();
            rowData[5]=reservation.getDateFin();
            rowData[6]=reservation.getEtat();
            model.addRow(rowData);
            
            }
        }
    }

    public Table_Reseravtion_User() {
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
        roomtypelabel.setText("Room Options:");
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

      
        // le positionement exact du label.
        startdatetext.setText("JJ/MM/AAAA");
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
                "iD-Reser","Room-Type","Option", "Total Price", "Start Date", "End Date", "State"
            }
        ));

       tablereservation.getColumnModel().getColumn(6).setPreferredWidth(90);
        tablereservation.getColumnModel().getColumn(2).setPreferredWidth(105);


        //tablereservation.setPreferredScrollableViewportSize(new Dimension(800, 500));
        tablereservation.setPreferredScrollableViewportSize(new Dimension(1000, 300));

        jScrollPane1.setViewportView(tablereservation);
        // le positionement exact du label.
        jScrollPane1.setBounds(365, 90, 550, 450);
        getContentPane().add(jScrollPane1);

        addreservationbtn.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        addreservationbtn.setText("Add Reservation");
        
        // le positionement exact du label.
        addreservationbtn.setBounds(20, 460, 130, 30);
        getContentPane().add(addreservationbtn);

        updatebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        updatebtn.setText("Update-Now");
        
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
        
        // le positionement exact du label.
        exitbtn.setBounds(190, 510, 130, 30);
        getContentPane().add(exitbtn);

        enddatetext.setText("JJ/MM/AAAA");
       
        // le positionement exact du label.
        enddatetext.setBounds(160, 320, 150, 30);
        getContentPane().add(enddatetext);
        backtoroomsbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        backtoroomsbtn.setText("Back To Rooms");
        
        // le positionement exact du label.
        backtoroomsbtn.setBounds(20, 510, 130, 30);
        getContentPane().add(backtoroomsbtn);

        roomtypebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));
        roomtypebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            }
        });
        // le positionement exact du label.
        roomtypebox.setBounds(160, 131, 150, 30);
        getContentPane().add(roomtypebox);
        roompricebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SONA", "TERASSE", "VUESURMERE", "VUESURFORET" }));
        roompricebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
           
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
    }                       
 
    


    //cbn
    public static int cancelReservationBtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        int i=tablereservation.getSelectedRow();
        DefaultTableModel model =(DefaultTableModel)tablereservation.getModel();
       
      
        if(i>=0){
            
        Date today =new Date(Date.getToday_jour(),Date.getToday_mois(),Date.getToday_annee());
        if(Date.comparer(Date.Recupere_date(startdatetext.getText()), today)==1){
            JOptionPane.showMessageDialog(frame, "Réservation annulée avec succès.");
            
            
            return Integer.parseInt(model.getValueAt(i, 0).toString());
          }else{
            
            JOptionPane.showMessageDialog(frame, "Vous ne pouvez pas annuler cette réservation !", "Erreur", JOptionPane.ERROR_MESSAGE);
            return -1;
          }
      }else{
          JOptionPane.showMessageDialog(frame,"Veuillez sélectionner une réservation à annuler.","Infornation", JOptionPane.INFORMATION_MESSAGE);
        }
      return -1;
    }


    //cbn
    public static int addreservationbtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception { 
        try{
        Date today=new Date(Date.getToday_jour(),Date.getToday_mois(),Date.getToday_annee());
        Date date_debut=Date.Recupere_date(startdatetext.getText());
        Date.verif_today_date(today, date_debut);
        Date date_fin=Date.Recupere_date(enddatetext.getText());
        Date.differenceEntreDates(date_debut, date_fin);
        Date.Dates_logique(date_debut, date_fin);

        DefaultTableModel Model=(DefaultTableModel) tablereservation.getModel();

        Model.addRow(new Object[]{Reservation.getNb()+1,roomtypebox.getSelectedItem(),roompricebox.getSelectedItem(),Control.total_prix+"$",startdatetext.getText(),enddatetext.getText(),EtatReservation.EN_ATTENTE});
            return 1;

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
   return -1;                                     
} 
                                                 
    //cbn
    public static void tablereservationMouseClicked(java.awt.event.MouseEvent evt) {   
                                             
        int selectedRow= tablereservation.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)tablereservation.getModel();
        roomtypebox.setSelectedItem(model.getValueAt(selectedRow,1).toString());
        roompricebox.setSelectedItem(model.getValueAt(selectedRow,2).toString());
        startdatetext.setText(model.getValueAt(selectedRow,4).toString());
        enddatetext.setText(model.getValueAt(selectedRow,5).toString());
        state.setText(model.getValueAt(selectedRow,6).toString());

        roompricebox.setSelectedItem(model.getValueAt(selectedRow,2).toString());


        //ACCEPTER,DECLINER,EN_ATTENTE;
        if(model.getValueAt(selectedRow,6).toString().equals("ACCEPTER")){
            state.setForeground(Color.GREEN);
        }else if(model.getValueAt(selectedRow,6).toString().equals("DECLINER")){
            state.setForeground(Color.RED);
        }else{
            state.setForeground(Color.ORANGE);
        }
        state.setText(model.getValueAt(selectedRow,6).toString());
    }                                             

    //cbn
    public static int updatebtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                          
        int i = tablereservation.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tablereservation.getModel();
        
        if (i >= 0) {
            try {
                Date today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
                Date date_debut = Date.Recupere_date(startdatetext.getText());
                Date.verif_today_date(today, date_debut);
                Date date_fin = Date.Recupere_date(enddatetext.getText());

            if(Date.comparer(date_debut, today)==1){

                Date.Dates_logique(date_debut, date_fin);
                Date.differenceEntreDates(date_debut, date_fin);
                

                // Mise à jour des valeurs dans le modèle de tableau
                model.setValueAt(roomtypebox.getSelectedItem(), i, 1);
                model.setValueAt(roompricebox.getSelectedItem(), i, 2);
                model.setValueAt(Control.total_prix+"$", i, 3);

                model.setValueAt(startdatetext.getText(), i, 4);
                model.setValueAt(enddatetext.getText(), i, 5);
                model.setValueAt("EN_ATTEND", i, 6);
              


                return ((int)model.getValueAt(i,0));


            }else{
                    JOptionPane.showMessageDialog(null, "Vous ne pouvez pas modifier cette réservation", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return -1;
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
            JOptionPane.showMessageDialog(frame, "Veuillez sélectionner une ligne à mettre à jour.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    
    }
    
    //cbn
    public static int exitbtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                        
       frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"DO YOU REALY WANT TO EXIT","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            return 1;
            
        }
        return -1;
    }                                       

    public static void main(String args[]) {
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new Table_Reseravtion_User().setVisible(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }


    // Variables declaration - do not modify                     
    public static javax.swing.JButton addreservationbtn;
    public static  javax.swing.JLabel backgroundlabel;
    public static  javax.swing.JButton backtoroomsbtn;
    public static  javax.swing.JLabel caraclabel;
    public static  javax.swing.JLabel enddatelabel;
    public static  javax.swing.JTextField enddatetext;
    public static  javax.swing.JButton exitbtn;
    public static  javax.swing.JLabel idroomlabel;
    public static  javax.swing.JScrollPane jScrollPane1;
    public static  javax.swing.JComboBox<String> roompricebox;
    public static  javax.swing.JComboBox<String> roomtypebox;
    public static  javax.swing.JLabel roomtypelabel;
    public static  javax.swing.JLabel showtablelabel;
    public static  javax.swing.JLabel startdatelabel;
    public static  javax.swing.JTextField startdatetext;
    public static  javax.swing.JLabel statelabel;
    public static  javax.swing.JLabel state;
    public static   javax.swing.JTable tablereservation;
    public static  javax.swing.JButton updatebtn;
    public static  javax.swing.JButton cancelReservationBtn;
    // End of variables declaration                   
}
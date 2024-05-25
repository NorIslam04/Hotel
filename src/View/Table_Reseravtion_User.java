package View;
import Model.*;
import Control.*;

import Model.Date.*;
import Model.Reservation.*;

import java.awt.Color;
import java.awt.Dimension;

import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Table_Reseravtion_User extends javax.swing.JFrame {



   
    private  JFrame frame;
    public  int id_res=0;
   

    public  void mettreajourlesreservation(){
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
        setUndecorated(true); // Supprime tous les boutons par défaut
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
        facture = new javax.swing.JButton();
        idroomlabel = new javax.swing.JLabel();
        exitbtn = new javax.swing.JButton();
        enddatetext = new javax.swing.JTextField();
        backtoroomsbtn = new javax.swing.JButton();
        roomtypebox = new javax.swing.JComboBox<>();
        roompricebox = new javax.swing.JComboBox<>();
        backgroundlabel = new javax.swing.JLabel();
        cancelReservationBtn = new javax.swing.JButton();
        JPanel informationreservationpanel = new JPanel();
        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");

        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Table Reservation User");
        setLocationRelativeTo(null);
        setVisible(true);
         
        // création du premier panel:
        informationreservationpanel.setLayout(null);
        informationreservationpanel.setBorder((new RoundBorder(color, 3)));
        informationreservationpanel.setBackground(colorgris);
        //le positionnement exact du panel:
        informationreservationpanel.setBounds(0, 3, 1027, 220);
        add(informationreservationpanel);

        //les bouttons du panel:

        //creation d'un boutton pour ajouter une réservation:
        addreservationbtn.setText("Add Reservation");
        addreservationbtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        addreservationbtn.setBackground(color);
        addreservationbtn.setForeground(colorgris);
        addreservationbtn.setBorder(new RoundBorder(color, 3));
        // le positionement exact du boutton:
        addreservationbtn.setBounds(750, 10, 150, 30);
        informationreservationpanel.add(addreservationbtn);

        //creation d'un boutton pour mettre à jour une réservation:
        updatebtn.setText("Update-Now");
        updatebtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        updatebtn.setBackground(color);
        updatebtn.setForeground(colorgris);
        updatebtn.setBorder(new RoundBorder(color, 3));
        // le positionement exact du boutton:
        updatebtn.setBounds(750, 50, 150, 30);
        informationreservationpanel.add(updatebtn);


        facture.setText("Facture");
        facture.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        facture.setBackground(color);
        facture.setForeground(colorgris);
        facture.setBorder(new RoundBorder(color, 3));
        // le positionement exact du boutton:
        facture.setBounds(915, 40, 100, 30);
        informationreservationpanel.add(facture);

        //creation d'un boutton pour annuler une réservation:
        cancelReservationBtn.setText("Cancel-Reservation"); 
        cancelReservationBtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        cancelReservationBtn.setBackground(color);
        cancelReservationBtn.setForeground(colorgris);
        cancelReservationBtn.setBorder(new RoundBorder(color, 3));
        // le positionement exact du boutton:
        cancelReservationBtn.setBounds(750, 90, 150, 30);
        informationreservationpanel.add(cancelReservationBtn); 

        //creation d'un boutton pour revenir:
        backtoroomsbtn.setText("Back To Rooms");
        backtoroomsbtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        backtoroomsbtn.setBackground(color);
        backtoroomsbtn.setForeground(colorgris);
        backtoroomsbtn.setBorder(new RoundBorder(color, 3));
        // le positionement exact du boutton:
        backtoroomsbtn.setBounds(750, 130, 150, 30);
        informationreservationpanel.add(backtoroomsbtn);
 
        //creation d'un boutton pour fermer la fenetre:
        exitbtn.setText("Exit");
        exitbtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        exitbtn.setBackground(color);
        exitbtn.setForeground(colorgris);
        exitbtn.setBorder(new RoundBorder(color, 3));
        //le positionement exact du boutton:
        exitbtn.setBounds(750, 170, 150, 30);
        informationreservationpanel.add(exitbtn);

        //création du deuxième panel pour les information de la réservation:
        JPanel datereservationpanel = new JPanel();
        datereservationpanel.setBackground(color);
        datereservationpanel.setLayout(null);
        datereservationpanel.setBounds(10, 20, 350, 180);

        //les labels du panel:

        startdatelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        startdatelabel.setForeground(new java.awt.Color(255, 255, 255));
        startdatelabel.setText("Start Date:");
        // le positionement exact du label:
        startdatelabel.setBounds(30, 20, 150, 30);
        datereservationpanel.add(startdatelabel);

        enddatelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        enddatelabel.setForeground(new java.awt.Color(255, 255, 255));
        enddatelabel.setText("End Date:");
        // le positionement exact du label:
        enddatelabel.setBounds(30, 70, 150, 30);
        datereservationpanel.add(enddatelabel);

        statelabel.setFont(new java.awt.Font("Bodoni MT", 0, 20)); // NOI18N
        statelabel.setForeground(new java.awt.Color(255, 255, 255));
        statelabel.setText("State:");
        // le positionement exact du label:
        statelabel.setBounds(30, 120, 150, 30);
        datereservationpanel.add(statelabel);

        //les textfields du panel: 

        startdatetext.setText("JJ/MM/AAAA");
        //le positionement exact du textfield:
        startdatetext.setBounds(160, 20, 150, 30);
        datereservationpanel.add(startdatetext);

        enddatetext.setText("JJ/MM/AAAA");
        // le positionement exact du textfield.
        enddatetext.setBounds(160, 70, 150, 30);
        datereservationpanel.add(enddatetext);

        state.setText("Choisissez une réservation");
        state.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        state.setForeground(Color.WHITE);
        // le positionement exact du label.
        state.setBounds(130, 120, 220, 30);
        datereservationpanel.add(state);

        //ajouter au deuxième panel:
        informationreservationpanel.add(datereservationpanel);

        //création du troisième panel pour les information de la réservation:
        JPanel typeetoptionreservationpanel = new JPanel();
        typeetoptionreservationpanel.setBackground(color);
        typeetoptionreservationpanel.setLayout(null);
        typeetoptionreservationpanel.setBounds(370, 20, 350, 180);
        informationreservationpanel.add(typeetoptionreservationpanel);

        //les labels du panel:

        idroomlabel.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        idroomlabel.setForeground(new java.awt.Color(255, 255, 255));
        idroomlabel.setText("Room Type:");
        // le positionement exact du label.
        idroomlabel.setBounds(30, 20, 150, 30);
        typeetoptionreservationpanel.add(idroomlabel);

        roomtypelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        roomtypelabel.setForeground(new java.awt.Color(255, 255, 255));
        roomtypelabel.setText("Room Options:");
        // le positionement exact du label.
        roomtypelabel.setBounds(30, 70, 150, 30);
        typeetoptionreservationpanel.add(roomtypelabel);

        //les combobox du panel:

        roomtypebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));
        // le positionement exact du combobox:
        roomtypebox.setBounds(160, 20, 150, 30);
        typeetoptionreservationpanel.add(roomtypebox);

        roompricebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SONA", "TERASSE", "VUESURMERE", "VUESURFORET" }));
        // le positionement exact du combobox:
        roompricebox.setBounds(160, 70, 150, 30);
        typeetoptionreservationpanel.add(roompricebox);

        // création du quatrième panel:
        JPanel tableaupanel = new JPanel();
        tableaupanel.setLayout(null);
        tableaupanel.setBorder((new RoundBorder(color, 3)));
        tableaupanel.setBackground(colorgris);
        //le positionnement exact du panel:
        tableaupanel.setBounds(0, 225, 1027, 355);
        add(tableaupanel);

        //le tableau du panel:

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
        tablereservation.setPreferredScrollableViewportSize(new Dimension(1000, 300));

        jScrollPane1.setViewportView(tablereservation);
        // le positionement exact du label.
        jScrollPane1.setBounds(100, 15, 800, 290);
        tableaupanel.add(jScrollPane1);

        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);
        mettreajourlesreservation();

        //les actionlistnners:

        roomtypebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            }
        });

        roompricebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
           
            }
        });

        facture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
           dispose();
           try {
            new Facture();
        } catch (Date_nonvalid e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            }
        });
    }                     
 
    


    //cbn
    public  int cancelReservationBtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
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
    public  int addreservationbtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception { 
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
    public  void tablereservationMouseClicked(java.awt.event.MouseEvent evt) {   
                                             
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
    public  int updatebtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                          
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
    public  int exitbtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                        
       frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"DO YOU REALY WANT TO EXIT","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            return 1;
            
        }
        return -1;
    }                                       

    public  void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new Table_Reseravtion_User().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify                     
    public  javax.swing.JButton addreservationbtn;
    public   javax.swing.JLabel backgroundlabel;
    public   javax.swing.JButton backtoroomsbtn;
    public   javax.swing.JLabel caraclabel;
    public   javax.swing.JLabel enddatelabel;
    public   javax.swing.JTextField enddatetext;
    public   javax.swing.JButton exitbtn;
    public   javax.swing.JLabel idroomlabel;
    public   javax.swing.JScrollPane jScrollPane1;
    public   javax.swing.JComboBox<String> roompricebox;
    public   javax.swing.JComboBox<String> roomtypebox;
    public   javax.swing.JLabel roomtypelabel;
    public   javax.swing.JLabel showtablelabel;
    public   javax.swing.JLabel startdatelabel;
    public   javax.swing.JTextField startdatetext;
    public   javax.swing.JLabel statelabel;
    public   javax.swing.JLabel state;
    public    javax.swing.JTable tablereservation;
    public   javax.swing.JButton updatebtn;
    public   javax.swing.JButton cancelReservationBtn;
    public   javax.swing.JButton facture;
    // End of variables declaration                   
}
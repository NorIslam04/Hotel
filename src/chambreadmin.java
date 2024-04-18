import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;           
import javax.swing.table.DefaultTableModel;

public class chambreadmin extends javax.swing.JFrame {

    public chambreadmin() {
        initComponents();
        
    }
    
    public void mettreleschmabresactuelles(){
        DefaultTableModel model = (DefaultTableModel) roomstabel.getModel();
        Object rowData[]=new Object[3];
        
        for (Map.Entry<Integer, Chambre> entry : Hotel.getChambreMap().entrySet()) {
            int id = entry.getKey(); // Récupérer l'ID de la chambre
            Chambre chambre = entry.getValue(); // Récupérer l'objet Chambre
            rowData[0]=id;
            rowData[1]=chambre.getType();
            rowData[2]=chambre.getPrix();
            model.addRow(rowData);
        }
    }
                        
    private void initComponents() {

        JButton suppreservationbtn = new javax.swing.JButton();
        roomslabel = new javax.swing.JLabel();
        chlabel = new javax.swing.JLabel();
        idroomlabel = new javax.swing.JLabel();
        roomprice = new javax.swing.JLabel();
        roomtypelabel = new javax.swing.JLabel();
        idroomtext = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomstabel = new javax.swing.JTable();
        addnewroombtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        checkbtn = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        roomtypebox = new javax.swing.JComboBox<>();
        roompricetxt = new javax.swing.JTextField();
        backgroundlabel = new javax.swing.JLabel();

        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setVisible(true);

        //creation d'une label avec ses caractéristiques.
        roomslabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        roomslabel.setForeground(new java.awt.Color(255, 255, 255));
        roomslabel.setText("Here Are All The Rooms:");
        // le positionement exact du label.
        roomslabel.setBounds(480, 50, 150, 30);
        getContentPane().add(roomslabel);

        //creation d'une label avec ses caractéristiques.
        chlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 18));
        chlabel.setForeground(new java.awt.Color(255, 255, 255));
        chlabel.setText("The Characteristics The Room:");
        // le positionement exact du label.
        chlabel.setBounds(40, 80, 290, 40);
        getContentPane().add(chlabel);
       
        //creation d'une label avec ses caractéristiques.
        idroomlabel.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        idroomlabel.setForeground(new java.awt.Color(255, 255, 255));
        idroomlabel.setText("ID-Room:");
        // le positionement exact du label.
        idroomlabel.setBounds(30, 190, 150, 30);
        getContentPane().add(idroomlabel);

        //creation d'une label avec ses caractéristiques.
        roomprice.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        roomprice.setForeground(new java.awt.Color(255, 255, 255));
        roomprice.setText("Room Price:");
        // le positionement exact du label.
        roomprice.setBounds(30, 330, 150, 30);
        getContentPane().add(roomprice);

        //creation d'une label avec ses caractéristiques.
        roomtypelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        roomtypelabel.setForeground(new java.awt.Color(255, 255, 255));
        roomtypelabel.setText("Room Type:");
        // le positionement exact du label.
        roomtypelabel.setBounds(30, 260, 150, 30);
        getContentPane().add(roomtypelabel); 

        //creation d'un text field avec ses caractéristiques.
        idroomtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idroomtextActionPerformed(evt);
            }
        });
        // le positionement exact du text field.
        idroomtext.setBounds(160, 180, 150, 30);
        getContentPane().add(idroomtext); 

        //creation d'un tableau avec ses caractéristiques.
        roomstabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID-Room", "Room Type", "Room Price"
            }
        ));
        roomstabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomstabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(roomstabel);
        // le positionement exact du tableau.
        jScrollPane1.setBounds(420, 130, 440, 330);
        getContentPane().add(jScrollPane1);

        suppreservationbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        suppreservationbtn.setText("Reservation inutile");
        suppreservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    suppreservationbtnActionPerformed(evt);
                } catch (Date_nonvalid | non_presente_bdd | deja_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        suppreservationbtn.setBounds(100, 380, 160, 30);
        getContentPane().add(suppreservationbtn);


        

        //creation d'un boutton avec ses caractéristiques.
        addnewroombtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        addnewroombtn.setText("Add New Room");
        addnewroombtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewroombtnActionPerformed(evt);
            }
        });
        // le positionement exact du tableau.
        addnewroombtn.setBounds(30, 420, 130, 30);
        getContentPane().add(addnewroombtn);

        //creation d'un boutton avec ses caractéristiques.
        updatebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        updatebtn.setText("Update-Now");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        // le positionement exact du tableau.
        updatebtn.setBounds(190, 420, 140, 30);
        getContentPane().add(updatebtn);

        //creation d'un boutton avec ses caractéristiques.
        checkbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        checkbtn.setText("Check Rservations");
        checkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbtnActionPerformed(evt);
            }
        });
        // le positionement exact du tableau.
        checkbtn.setBounds(190, 470, 140, 30);
        getContentPane().add(checkbtn);

        //creation d'un boutton avec ses caractéristiques.
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        // le positionement exact du tableau.
        closebtn.setBounds(30, 470, 130, 30);
        getContentPane().add(closebtn);

        roomtypebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));
        roomtypebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomtypeboxActionPerformed(evt);
                String selectedRoomType = (String) roomtypebox.getSelectedItem();
                if(selectedRoomType.equals("SOLO")) {
                    roompricetxt.setText("100"); // Set price to 100 if room type is "SOLO"
                }else if(selectedRoomType.equals("DOUBLE")){
                    roompricetxt.setText("250");
                }else if(selectedRoomType.equals("TRIPLE")){
                    roompricetxt.setText("500"); 
                }else if(selectedRoomType.equals("SUITE")){
                    roompricetxt.setText("700"); 
                }
            }
        });
        // le positionement exact du combo box.
        roomtypebox.setBounds(160, 250, 150, 30);
        getContentPane().add(roomtypebox);

        //creation d'un text field avec ses caractéristiques.
        roompricetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idroomtextActionPerformed(evt);
            }
        });
        // le positionement exact du text field.
        roompricetxt.setBounds(160, 320, 150, 30);
        getContentPane().add(roompricetxt);
    
        backgroundlabel.setIcon(new javax.swing.ImageIcon("liste-de-reservations.png")); // NOI18N
        // le positionement exact du text field.
        backgroundlabel.setBounds(0, 0, 920, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(936, 588));
        setLocationRelativeTo(null);

        mettreleschmabresactuelles();
    }                      

    private void idroomtextActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void addnewroombtnActionPerformed(java.awt.event.ActionEvent evt) {                                              
        DefaultTableModel Model=(DefaultTableModel) roomstabel.getModel();
        Model.addRow(new Object[]{idroomtext.getText(),roomtypebox.getSelectedItem(),roompricetxt.getText()});
    }                                             

    private void roomstabelMouseClicked(java.awt.event.MouseEvent evt) {                                        
        int selectedRow= roomstabel.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)roomstabel.getModel();
        idroomtext.setText(model.getValueAt(selectedRow,0).toString());
        //jTextField2.setText(model.getValueAt(selectedRow,1).toString());
        roomtypebox.setSelectedItem(model.getValueAt(selectedRow,2).toString());
        roompricetxt.setText(model.getValueAt(selectedRow,3).toString());
    }                                       

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
      int i=roomstabel.getSelectedRow();
      DefaultTableModel model =(DefaultTableModel)roomstabel.getModel();
      if(i>=0){
          model.setValueAt(idroomtext.getText(),i,0);
          //model.setValueAt(jTextField2.getText(),i,1);
          model.setValueAt(roomtypebox.getSelectedItem(),i,2);
          model.setValueAt(roompricetxt.getText(),i,3);
      }else{
          JOptionPane.showMessageDialog(null,"Error");
      }
    }                                         

    private void checkbtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }  
    

    private void suppreservationbtnActionPerformed(java.awt.event.ActionEvent evt) throws Date_nonvalid, non_presente_bdd, deja_presente_bdd {                                            
        Admin.supprimerreservationinutile();
    }

    private void roomtypeboxActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void roompriceboxActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chambreadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chambreadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chambreadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chambreadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chambreadmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addnewroombtn;
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JButton checkbtn;
    private javax.swing.JLabel chlabel;
    private javax.swing.JButton closebtn;
    private javax.swing.JLabel idroomlabel;
    private javax.swing.JTextField idroomtext;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel roomprice;
    private javax.swing.JTextField roompricetxt;
    private javax.swing.JLabel roomslabel;
    private javax.swing.JTable roomstabel;
    private javax.swing.JComboBox<String> roomtypebox;
    private javax.swing.JLabel roomtypelabel;
    private javax.swing.JButton updatebtn;
    // End of variables declaration                   
}

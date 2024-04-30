package View;
import Model.*;
import Model.Chambre.*;
import Model.Date.*;
import Control.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;           
import javax.swing.table.DefaultTableModel;

public class chambreadmin extends javax.swing.JFrame {

    static private String Ptriple="500";
    static private String Psolo="100";
    static private String Psuite="700";
    static private String Pdouble="250";

    public Boolean pouvez_modifierPrix(TypeChambre typeChambre){
        for (Map.Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
            Reservation reservation = entry.getValue(); // Récupérer l'objet Chambre
            if(reservation.getType()==typeChambre){
                return false;
            }
    }
        return true;
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
    private boolean pouvez_modifier (int id_chambre) throws Date_nonvalid{
        
        for (Map.Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
            Reservation reservation = entry.getValue();
                if(id_chambre==reservation.getId_chambre()){
                        return false;
                }
            }
        
        return true;
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


    public chambreadmin() {
        parcourChambre();
        initComponents();
    }
    
    public void mettreleschmabresactuelles(){
        DefaultTableModel model = (DefaultTableModel) roomstabel.getModel();
        Object rowData[]=new Object[3];
        model.setRowCount(0);
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
        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());
        
        roomslabel = new javax.swing.JLabel();
        chlabel = new javax.swing.JLabel();
        idroomlabel = new javax.swing.JLabel();
        roomprice = new javax.swing.JLabel();
        roomtypelabel = new javax.swing.JLabel();
        chooselabel = new javax.swing.JLabel();
        idroom = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomstabel = new javax.swing.JTable();
        addnewroombtn = new javax.swing.JButton();
        changepricebtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        checkbtn = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        roomtypebox = new javax.swing.JComboBox<>();
        roompricebox = new javax.swing.JComboBox<>();
        alltypebox = new javax.swing.JComboBox<>();
        newpricetxt = new javax.swing.JTextField();
        backgroundlabel = new javax.swing.JLabel();

        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setVisible(true);

        //les label:
        //creation d'une label avec ses caractéristiques.
        roomslabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        roomslabel.setForeground(new java.awt.Color(255, 255, 255));
        roomslabel.setText("Here Are All The Rooms:");
        // le positionement exact du label.
        roomslabel.setBounds(480, 50, 320, 30);
        getContentPane().add(roomslabel);

        //creation d'une label avec ses caractéristiques.
        chlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 18));
        chlabel.setForeground(new java.awt.Color(255, 255, 255));
        chlabel.setText("The Characteristics The Room:");
        // le positionement exact du label.
        chlabel.setBounds(40, 50, 290, 40);
        getContentPane().add(chlabel);
       
        //creation d'une label avec ses caractéristiques.
        idroomlabel.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        idroomlabel.setForeground(new java.awt.Color(255, 255, 255));
        idroomlabel.setText("ID-Room:");
        // le positionement exact du label.
        idroomlabel.setBounds(30, 120, 150, 30);
        getContentPane().add(idroomlabel);

        //creation d'une label avec ses caractéristiques.
        roomprice.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        roomprice.setForeground(new java.awt.Color(255, 255, 255));
        roomprice.setText("Room Price:");
        // le positionement exact du label.
        roomprice.setBounds(30, 220, 150, 30);
        getContentPane().add(roomprice);

        //creation d'une label avec ses caractéristiques.
        roomtypelabel.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        roomtypelabel.setForeground(new java.awt.Color(255, 255, 255));
        roomtypelabel.setText("Room Type:");
        // le positionement exact du label.
        roomtypelabel.setBounds(30, 170, 150, 30);
        getContentPane().add(roomtypelabel); 

        //creation d'une label avec ses caractéristiques.
        chooselabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 14)); // NOI18N
        chooselabel.setForeground(new java.awt.Color(255, 255, 255));
        chooselabel.setText("Choose the type you want to change it price:");
        // le positionement exact du label.
        chooselabel.setBounds(20, 400, 320, 30);
        getContentPane().add(chooselabel);

        //les text filds:
        idroom.setFont(new java.awt.Font("Arial", 0, 17));
        idroom.setBounds(180, 120, 150, 30);
        // le positionement exact du field.
        idroom.setForeground(Color.BLACK);
        getContentPane().add(idroom); 

        newpricetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpricetxtActionPerformed(evt);
            }
        });

        // le positionement exact du text field.
        newpricetxt.setBounds(190, 450, 140, 30);
        getContentPane().add(newpricetxt);

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
        jScrollPane1.setBounds(420, 90, 440, 440);
        getContentPane().add(jScrollPane1);

        // les bouttons:
        //creation d'un boutton avec ses caractéristiques.
        addnewroombtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        addnewroombtn.setText("Add New Room");
        addnewroombtn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // kant hka:
            /*try {
                addnewroombtnActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
        }); 
        // le positionement exact du tableau.
        addnewroombtn.setBounds(30, 280, 140, 30);
        getContentPane().add(addnewroombtn);

        //creation d'un boutton avec ses caractéristiques.
        updatebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        updatebtn.setText("Update-Now");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
               /*  try {
                    updatebtnActionPerformed(evt);
                } catch (non_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }*/
            }
        });
        // le positionement exact du tableau.
        updatebtn.setBounds(190, 280, 140, 30);
        getContentPane().add(updatebtn);

        //creation d'un boutton avec ses caractéristiques.
        checkbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        checkbtn.setText("Check Rservations");
        checkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               /* try {
                    checkbtnActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }*/
            }
        });
        // le positionement exact du tableau.
        checkbtn.setBounds(30, 340, 145, 30);
        getContentPane().add(checkbtn);

        


        //creation d'un boutton avec ses caractéristiques.
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    closebtnActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du boutton.
        closebtn.setBounds(30, 500, 130, 30);
        getContentPane().add(closebtn);

        //creation d'un boutton avec ses caractéristiques.
        changepricebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        changepricebtn.setText("Change Price");
        changepricebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               /*  try {
                    changepricebtnActionPerformed(evt);
                } catch (non_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }*/
            }
        });
        // le positionement exact du boutton.
        changepricebtn.setBounds(190, 500, 140, 30);
        getContentPane().add(changepricebtn);

        // les combos box:
        //creation d'un combo box avec ses caractéristiques.
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
        // le positionement exact du combo box.
        roomtypebox.setBounds(180, 170, 150, 30);
        getContentPane().add(roomtypebox);

        //creation d'un combo box ses caractéristiques.
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
        // le positionement exact du combo box.
        roompricebox.setBounds(180, 220, 150, 30);
        getContentPane().add(roompricebox);

        //creation d'un combo box ses caractéristiques.
        alltypebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));
        alltypebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alltypeboxActionPerformed(evt);
            }
        });
        // le positionement exact du combo box.
        alltypebox.setBounds(30, 450, 130, 30);
        getContentPane().add(alltypebox);

    
        backgroundlabel.setIcon(new javax.swing.ImageIcon("liste-de-reservations.png")); 
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

    /*  private void addnewroombtnActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                              
        String typeCham=(String) roomtypebox.getSelectedItem();
        String prixs=(String) roompricebox.getSelectedItem();
        Double prix =Double.parseDouble(prixs);
        Chambre chambre =new Chambre(Chambre.getNb(), TypeChambre.ToTypeChambre(typeCham), prix);
        Hotel.AjtChambreMap(chambre);
        mettreleschmabresactuelles();//pour reaficher le tableau !!
    }     */                                        

    private void roomstabelMouseClicked(java.awt.event.MouseEvent evt) {  

        int selectedRow= roomstabel.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)roomstabel.getModel();
        idroom.setText(model.getValueAt(selectedRow,0).toString());
        roomtypebox.setSelectedItem(model.getValueAt(selectedRow,1).toString());
        roompricebox.setSelectedItem(model.getValueAt(selectedRow,2).toString());
        

    }                                       

  /*   private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) throws non_presente_bdd, SQLException,Exception {                                          
        int i=roomstabel.getSelectedRow();
        DefaultTableModel model =(DefaultTableModel)roomstabel.getModel();
        if(i>=0){
            model.setValueAt(roomtypebox.getSelectedItem(),i,1);
            model.setValueAt(roompricebox.getSelectedItem(),i,2);

  
        }else{

            JOptionPane.showMessageDialog(frame,
            "selection une chambre dans le tableau ",
            "Erreur",
            JOptionPane.INFORMATION_MESSAGE);
        }
        if(!idroom.getText().equals("")){

            int id_chambre=Integer.parseInt(idroom.getText());
            if(pouvez_modifier(id_chambre)){

            String typeCham=(String) roomtypebox.getSelectedItem();
            String prixs=(String) roompricebox.getSelectedItem();
            Double prix =Double.parseDouble(prixs);
            Chambre chambre=new Chambre(id_chambre, TypeChambre.ToTypeChambre(typeCham), prix);
            Hotel.ModifierChambreMap(chambre);
            
            }else{

            JOptionPane.showMessageDialog(frame,
            "Vous ne pouvez pas modifier cette salle car elle est déjà réservée !",
            "Erreur",
            JOptionPane.INFORMATION_MESSAGE);
            }
    
        }
    
    }    */                                     

    /* private void checkbtnActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                         
        reservationadmin resa = new reservationadmin();
        resa.setVisible(true);
        DataBase.HasgMapsToDb();
        this.dispose();
    }   */                                      

    private JFrame frame;
    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                         
    frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"DO YOU REALY WANT TO CLOSE THIS WINDOW?","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {   
            Control.hash_map_bdd();
            System.exit(0);
        }

    }                                          

    private void roomtypeboxActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void roompriceboxActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }  
    private void alltypeboxActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void newpricetxtActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

   /* private void changepricebtnActionPerformed(java.awt.event.ActionEvent evt) throws non_presente_bdd, SQLException {                                               
        String type_cham= (String)alltypebox.getSelectedItem();
        if(pouvez_modifierPrix(TypeChambre.ToTypeChambre(type_cham))){
        Double prix=Double.parseDouble(newpricetxt.getText());
        Admin.ModifPrixTousChambres(TypeChambre.ToTypeChambre(type_cham),prix);
        switch (type_cham) {
            case "SOLO":
            setPsolo(newpricetxt.getText());
                break;
            case "DOUBLE":
            setPdouble(newpricetxt.getText());   
                break;
            case "TRIPLE":
            setPtriple(newpricetxt.getText());
                break;
            default:
            setPsuite(newpricetxt.getText());;
                break;
        }
        mettreleschmabresactuelles();
        test();
        }else{
            JOptionPane.showMessageDialog(frame,
            "Vous ne pouvez pas modifier le prix de ce type car ce type est déjà réservé !",
            "Erreur",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }  */ 
    private void test(){
        String selectedRoomprice = (String) roompricebox.getSelectedItem();
        if(selectedRoomprice.equals(Psolo)) {
            roomtypebox.setSelectedItem("SOLO"); // Set price to 100 if room type is "SOLO"
        }else if(selectedRoomprice.equals(Pdouble)){
            roomtypebox.setSelectedItem("DOUBLE");
        }else if(selectedRoomprice.equals(Ptriple)){
            roomtypebox.setSelectedItem("TRIPLE");
        }else if(selectedRoomprice.equals(Psuite)){
            roomtypebox.setSelectedItem("SUITE");
        }

        selectedRoomprice = (String) roompricebox.getSelectedItem();
           
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
     
        roompricebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { Psolo, Pdouble, Ptriple, Psuite }));
        roompricebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roompriceboxActionPerformed(evt);
                String selectedRoomprice = (String) roompricebox.getSelectedItem();
                if(selectedRoomprice.equals(Psolo)) {
                    roomtypebox.setSelectedItem("SOLO"); // Set price to 100 if room type is "SOLO"
                }else if(selectedRoomprice.equals(Pdouble)){
                    roomtypebox.setSelectedItem("DOUBLE");
                }else if(selectedRoomprice.equals(Ptriple)){
                    roomtypebox.setSelectedItem("TRIPLE");
                }else if(selectedRoomprice.equals(Psuite)){
                    roomtypebox.setSelectedItem("SUITE");
                }
            }
        });

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
            java.util.logging.Logger.getLogger(chambreadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chambreadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chambreadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chambreadmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chambreadmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify 
    private javax.swing.JButton suppreservationbtn;                   
    private javax.swing.JButton addnewroombtn;
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JLabel chooselabel;
    private javax.swing.JButton checkbtn;
    private javax.swing.JLabel chlabel;
    private javax.swing.JButton closebtn;
    private javax.swing.JLabel idroomlabel;
    private javax.swing.JLabel idroom;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel roomprice;
    private javax.swing.JComboBox<String> roompricebox;
    private javax.swing.JLabel roomslabel;
    private javax.swing.JTable roomstabel;
    private javax.swing.JComboBox<String> roomtypebox;
    private javax.swing.JComboBox<String> alltypebox;
    private javax.swing.JLabel roomtypelabel;
    private javax.swing.JButton updatebtn;
    private javax.swing.JButton changepricebtn;
    private javax.swing.JTextField newpricetxt;
    // End of variables declaration                   
}

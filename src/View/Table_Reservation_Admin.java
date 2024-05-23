package View;
import Model.*;
import Model.Date.*;
import Model.Reservation.EtatReservation;
import Model.Chambre.*;
import Control.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table_Reservation_Admin extends javax.swing.JFrame {
 private static int id_chambre;

    public static int getId_chambre() {
    return id_chambre;
}

public static void setId_chambre(int id_chambre) {
    Table_Reservation_Admin.id_chambre = id_chambre;
}

public double GetPrix(int id_res){
    for (Map.Entry<Integer, Reservation> obj : Hotel.getReservationMap().entrySet()) {
        int id = obj.getKey();
        Reservation res=obj.getValue();
        if (id==id_res) {
          return res.getPrix();
        }
    }
    return -9345;
}

    public void mettreajourlesreservationadmin(){
        DefaultTableModel model = (DefaultTableModel) reservationtabel.getModel();
        Object rowData[]=new Object[8];
        model.setRowCount(0);
        for (Map.Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
            if(entry.getValue().sup==0){
            Reservation reservation = entry.getValue(); // Récupérer l'objet Chambre
            rowData[0]=reservation.getId_user();
            rowData[1]=reservation.getId();
            rowData[2]=reservation.getType();
            rowData[3]=reservation.getOption();
            rowData[4]=reservation.getPrix()+"$";
            rowData[5]=reservation.getDateDebut();
            rowData[6]=reservation.getDateFin();
            rowData[7]=reservation.getEtat();
            
            model.addRow(rowData);
            }
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
        JPanel acceptdeclinePanel = new JPanel();
        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");

        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setVisible(true);


      /* reservationlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        reservationlabel.setForeground(new java.awt.Color(255, 255, 255));
        reservationlabel.setText("Here Are All The Reservations:");
        // le positionement exact du label.
        reservationlabel.setBounds(440, 30, 390, 30);
        getContentPane().add(reservationlabel); */

      /* acceptdeclinelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 24)); // NOI18N
        acceptdeclinelabel.setForeground(new java.awt.Color(255, 255, 255));
        acceptdeclinelabel.setText("Accept/Decline Rservation");
        // le positionement exact du label.
        acceptdeclinelabel.setBounds(10, 30, 330, 30);
        getContentPane().add(acceptdeclinelabel); */
 
        // création du premier panel pour les information de la réservation:
        acceptdeclinePanel.setLayout(null);
        acceptdeclinePanel.setBorder((new RoundBorder(color, 3)));
        acceptdeclinePanel.setBackground(colorgris);
        add(acceptdeclinePanel);
        //le positionnement exact du panel:
        acceptdeclinePanel.setBounds(0, 3, 1027, 200);

        //création du deuxième panel pour les information de la réservation:
        
        JPanel acceptdeclinemanuelpanel = new JPanel();
        acceptdeclinemanuelpanel.setBackground(color);
        acceptdeclinemanuelpanel.setLayout(null);
        acceptdeclinemanuelpanel.setBounds(10, 10, 410, 180);
        
        //les labels du panel:
        acceptordeclinelabel = new JLabel("Accept Or Decline Manuely:");
        acceptordeclinelabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        acceptordeclinelabel.setForeground(colorgris);
        acceptordeclinelabel.setBounds(20, 70, 400, 17);
        acceptdeclinemanuelpanel.add(acceptordeclinelabel);

        clicklabel = new JLabel("Click Here To Know:");
        clicklabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        clicklabel.setForeground(colorgris);
        clicklabel.setBounds(20, 20, 400, 17);
        acceptdeclinemanuelpanel.add(clicklabel);

        //les bouttons:
        
        acceptdeclinebtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        acceptdeclinebtn.setBackground(colorgris);
        acceptdeclinebtn.setForeground(color.white);
        acceptdeclinebtn.setBorder(new RoundBorder(color, 3));
        acceptdeclinebtn.setText("Accept/Decline");
        acceptdeclinebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    acceptdeclinebtnActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du button:
        acceptdeclinebtn.setBounds(230, 14, 150, 30);
        acceptdeclinemanuelpanel.add(acceptdeclinebtn);

        updatebtn.setText("Update-Now");
        updatebtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        updatebtn.setBackground(colorgris);
        updatebtn.setForeground(color.white);
        updatebtn.setBorder(new RoundBorder(color, 3));
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    updatebtnActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du button:
        updatebtn.setBounds(230, 120, 150, 30);
        acceptdeclinemanuelpanel.add(updatebtn);
    
        //les combobox:
        acceptdeclinebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACCEPTER", "DECLINER" }));
        acceptdeclinebox.setForeground(color);
        acceptdeclinebox.setBackground(colorgris);
        acceptdeclinebox.setBorder(new RoundBorder(color, 3));
        // le positionement exact du label.
        acceptdeclinebox.setBounds(20, 120, 150, 30);
        acceptdeclinemanuelpanel.add(acceptdeclinebox);

        acceptdeclinePanel.add(acceptdeclinemanuelpanel);


        //création du troisième panel pour les information de la réservation:
        
        JPanel acceptdeclineauto = new JPanel();
        acceptdeclineauto.setBackground(color);
        acceptdeclineauto.setLayout(null);
        acceptdeclineauto.setBounds(430, 10, 380, 180);

        //les labels du panel:
        reservationinutilelabel = new JLabel("Delete Unnecessary Reservation:");
        reservationinutilelabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        reservationinutilelabel.setForeground(colorgris);
        reservationinutilelabel.setBounds(20, 20, 400, 17);
        acceptdeclineauto.add(reservationinutilelabel);

        //les bouttons du panel:
        suppreservationbtn.setText("Reservation inutile");
        suppreservationbtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        suppreservationbtn.setBackground(colorgris);
        suppreservationbtn.setForeground(color.white);
        suppreservationbtn.setBorder(new RoundBorder(color, 3));
        suppreservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    suppreservationbtnActionPerformed(evt);
                } catch (Date_nonvalid   e) {
                    e.printStackTrace();
                }
            }
        });
        suppreservationbtn.setBounds(120, 70, 150, 30);
        acceptdeclineauto.add(suppreservationbtn);

        acceptdeclinePanel.add(acceptdeclineauto);

        //création du quatrième panel pour les information de la réservation:
        
        JPanel tableaupanel = new JPanel();
        tableaupanel.setLayout(null);
        tableaupanel.setBorder((new RoundBorder(color, 3)));
        tableaupanel.setBackground(colorgris);
        tableaupanel.setBounds(0, 205, 1027, 380);
        add(tableaupanel);

        //le tableau du panel:

        reservationtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID-User", "ID-Reservation", "Room Type","Room Option", "Reservation Price", "Start Date", "End Date", "State"
            }
        ));
        
        jScrollPane1.setViewportView(reservationtabel);
        // le positionement exact du tableau.
        jScrollPane1.setBounds(50, 20, 900, 300);
        getContentPane().add(jScrollPane1); 

        tableaupanel.add(jScrollPane1);






        closebtn.setBackground(new java.awt.Color(171, 34, 34));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        closebtn.setText("Close");
        closebtn.setForeground(Color.WHITE);
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    closebtnActionPerformed(evt);
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du label.
        closebtn.setBounds(500, 1, 150, 40);
        tableaupanel.add(closebtn);
       

        /*backtoroomsbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
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
        getContentPane().add(backtoroomsbtn);*/

        /* clicklabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        clicklabel.setForeground(new java.awt.Color(255, 255, 255));
        clicklabel.setText("And Click Here:");
        // le positionement exact du label.
        clicklabel.setBounds(20, 250, 160, 30);
        getContentPane().add(clicklabel); */

        /*selectlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 18)); // NOI18N
        selectlabel.setForeground(new java.awt.Color(255, 255, 255));
        selectlabel.setText("Select The Reservation ");
        // le positionement exact du label.
        selectlabel.setBounds(20, 206, 220, 20);
        getContentPane().add(selectlabel); */

        // le positionement exact du label.
        backgroundlabel.setBounds(0, 0, 1032, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);

      
    }// </editor-fold>                        

   

    private int EnAttente() throws Exception{//fait
        
        int selectedRow= reservationtabel.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)reservationtabel.getModel();
        TypeChambre typeChambre=TypeChambre.ToTypeChambre(model.getValueAt(selectedRow,2).toString());
        OptionSupplementaire opt= OptionSupplementaire.tOptionSupplementaire(model.getValueAt(selectedRow, 3).toString());
        String Date_debut=model.getValueAt(selectedRow,5).toString();
        String Date_fin=model.getValueAt(selectedRow,6).toString();
        

        Chambre tmp_Chambre = Hotel.attribuerchambre(typeChambre, Date.Recupere_date(Date_debut),Date.Recupere_date(Date_fin),opt);

        
            if(tmp_Chambre==null){//decliner
                return 0;
            }else{//accepter
                setId_chambre(tmp_Chambre.getId());
                return 1;
            }
        

    }
    //fait
    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, Exception {  //mazelll                                        
        int i=reservationtabel.getSelectedRow();

      if(i>=0){

        DefaultTableModel model =(DefaultTableModel)reservationtabel.getModel();
        int selectedRow= reservationtabel.getSelectedRow();
        TypeChambre typeChambre=TypeChambre.ToTypeChambre(model.getValueAt(selectedRow,2).toString());
        String Date_debut=model.getValueAt(selectedRow,5).toString();
        String Date_fin=model.getValueAt(selectedRow,6).toString();
        int idReservation=Integer.parseInt(model.getValueAt(selectedRow,1).toString());
        int idUser=Integer.parseInt(model.getValueAt(selectedRow,0).toString());
        String etat=model.getValueAt(selectedRow,7).toString();

        OptionSupplementaire opt= OptionSupplementaire.tOptionSupplementaire(model.getValueAt(selectedRow, 3).toString());
        if(!etat.equals("ACCEPTER")){
          model.setValueAt(acceptdeclinebox.getSelectedItem(),i,7);
          if(EnAttente()==1){
            double prix =GetPrix(idReservation);
            
            Reservation newres=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,getId_chambre() ,EtatReservation.toEtatReservation(acceptdeclinebox.getSelectedItem().toString()),prix,opt);
            Hotel.ModifierReservationMap(newres);
                    
            }else{
                double prix =GetPrix(idReservation);
                Reservation newres=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,-1 ,EtatReservation.toEtatReservation(acceptdeclinebox.getSelectedItem().toString()),prix,opt);
                Hotel.ModifierReservationMap(newres);
            } 
        }else{
            JOptionPane.showMessageDialog(frame,
            "DEJA ACCEPTER !",
            "ACCEPTER",
            JOptionPane.INFORMATION_MESSAGE);

        }
      }else{
          JOptionPane.showMessageDialog(null,"Selection une ligne dans le tableau");
      }
       
    }                   
    
    private void suppreservationbtnActionPerformed(java.awt.event.ActionEvent evt) throws Date_nonvalid { //fait                                          
        int i=Admin.supprimerreservationinutile();
        if (i>0) {
            JOptionPane.showMessageDialog(frame,"vous avez supprimé - "+i+" - réservations inutile !");
            mettreajourlesreservationadmin();
        }else{
            JOptionPane.showMessageDialog(frame,"Il n'y a pas de réserves inutiles !");
        }

        //insert into reservation(idUser,type,dateDebut,dateFin,idChambre,etat,prix) values(15,'SOLO','10/5/2024','16/5/2024',-1,'DECLINER',5432.87);
    } 

    private void acceptdeclinebtnActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, Exception {//fait
        DefaultTableModel model= (DefaultTableModel)reservationtabel.getModel();
        int i=reservationtabel.getSelectedRow();
       
        if(i>=0){  

            int selectedRow= reservationtabel.getSelectedRow();
            String etat=model.getValueAt(selectedRow,7).toString();
            OptionSupplementaire opt= OptionSupplementaire.tOptionSupplementaire(model.getValueAt(selectedRow, 3).toString());
            TypeChambre typeChambre=TypeChambre.ToTypeChambre(model.getValueAt(selectedRow,2).toString());
            String Date_debut=model.getValueAt(selectedRow,5).toString();
            String Date_fin=model.getValueAt(selectedRow,6).toString();
            int idReservation=Integer.parseInt(model.getValueAt(selectedRow,1).toString());
            int idUser=Integer.parseInt(model.getValueAt(selectedRow,0).toString());

        if(etat.equals("ACCEPTER")){

            JOptionPane.showMessageDialog(frame,
            "DEJA ACCEPTER !",
            "ACCEPTER",
            JOptionPane.INFORMATION_MESSAGE);
        }  
        else{                                               
       if(EnAttente()==1){
        int a=JOptionPane.showConfirmDialog(frame,
                "'ACCEPTER' cette reservation Automatique ?",
                "Automatique",
                JOptionPane.INFORMATION_MESSAGE);
                if(a==0){
                    model.setValueAt("ACCEPTER",i,7);
                    double prix =GetPrix(idReservation);
                    Reservation newres=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,getId_chambre() ,EtatReservation.ACCEPTER,prix,opt);
                    Hotel.ModifierReservationMap(newres);
                }else{
                    JOptionPane.showMessageDialog(frame, "Vous devez 'ACCEPTER' Manuellement");
                }

        }else if(EnAttente()==0){
            int a=JOptionPane.showConfirmDialog(frame,
                "'DECLINER' cette reservation Automatique ?",
                "Automatique",
                JOptionPane.INFORMATION_MESSAGE);
                if(a==0){
                    model.setValueAt("DECLINER",i,7);
                double prix =GetPrix(idReservation);
                Reservation newres=new Reservation(idReservation, idUser,Date.Recupere_date(Date_fin), Date.Recupere_date(Date_debut), typeChambre,-1 ,EtatReservation.DECLINER,prix,opt);
                Hotel.ModifierReservationMap(newres);
                }else{
                    JOptionPane.showMessageDialog(frame, "Vous devez 'DECLINER' Manuellement");
                }
        }
    }  
    }else{
        JOptionPane.showMessageDialog(null,"Selection une ligne dans le tableau");
    }                            
    }
                                                  

   
    private void backtoroomsbtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {  //fait                                             
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
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new Table_Reservation_Admin().setVisible(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

   

    // Variables declaration - do not modify   
    private javax.swing.JButton suppreservationbtn;                  
    private javax.swing.JComboBox<String> acceptdeclinebox;
    private javax.swing.JButton acceptdeclinebtn;
    private javax.swing.JLabel acceptdeclinelabel;
    private javax.swing.JLabel reservationinutilelabel;
    private javax.swing.JLabel acceptordeclinelabel;
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



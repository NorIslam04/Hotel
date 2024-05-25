package View;
import Model.*;
import Model.Date.*;
import Model.Reservation.EtatReservation;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Facture extends javax.swing.JFrame {


        public void remplissageTable(){
            DefaultTableModel model = (DefaultTableModel) reservationtabel.getModel();
            Object rowData[]=new Object[5];
            model.setRowCount(0);
            for (java.util.Map.Entry<Integer, Reservation> iterable_element : Hotel.getReservationMap().entrySet()) {
                Reservation reservation = iterable_element.getValue(); // Récupérer l'objet Chambre
            if(Hotel.id_user_current==reservation.getId_user()&& reservation.sup!=1&& reservation.getEtat()==
            EtatReservation.ACCEPTER){
            rowData[0]=reservation.getType();
            rowData[1]=reservation.getOption();
            rowData[2] =reservation.getPrix()+"$";
            rowData[3]=reservation.getDateDebut();
            rowData[4]=reservation.getDateFin();
            model.addRow(rowData);
            }

        }

        }

        public double totalPrix(){
            double prix_total=0;
            for (java.util.Map.Entry<Integer, Reservation> iterable_element : Hotel.getReservationMap().entrySet()) {
                Reservation reservation = iterable_element.getValue(); // Récupérer l'objet Chambre
            if(Hotel.id_user_current==reservation.getId_user()&& reservation.sup!=1&& reservation.getEtat()==
            EtatReservation.ACCEPTER){
            
            prix_total+=reservation.getPrix();
            }

        }
        return prix_total;

        }
 

    public Facture() throws Date_nonvalid {
        initComponents();
        remplissageTable();
    }
       
    private void initComponents() throws Date_nonvalid {
        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());
        suppreservationbtn =new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationtabel = new javax.swing.JTable();
        updatebtn = new javax.swing.JButton();
        acceptdeclinebox = new javax.swing.JComboBox<>();
        acceptdeclinebtn = new javax.swing.JButton();
        clicklabel = new javax.swing.JLabel();
         closebtn = new javax.swing.JButton();
        backtoroomsbtn = new javax.swing.JButton();
        backgroundlabel = new javax.swing.JLabel();
        mercilabel = new javax.swing.JLabel();
        cheznous = new javax.swing.JLabel();
        facturelabel = new javax.swing.JLabel();
        nomutilisateur = new javax.swing.JLabel();
        emailutilisateur = new javax.swing.JLabel();
        totallabel = new javax.swing.JLabel();
        prixpanel = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        datelabell = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        closebtn = new javax.swing.JButton();
        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");

        //rendre le layout manager null pour le positionement absolu:
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setVisible(true);

        //création du premier panel:
        JPanel factureinfospanel = new JPanel();
        factureinfospanel.setLayout(null);
        factureinfospanel.setBorder((new RoundBorder(color, 3)));
        factureinfospanel.setBackground(color);
        //le positionnement exact du panel:
        factureinfospanel.setBounds(504, 0, 515, 600);
        add(factureinfospanel);

        //les labels du panel:

        facturelabel = new JLabel("Facture");
        facturelabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 50));
        facturelabel.setForeground(colorgris);
        //le positionnement exact du label:
        facturelabel.setBounds(45, 20, 800, 50);
        factureinfospanel.add(facturelabel);

         //Date t=new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());

        datelabell = new JLabel("Date d'aujourdhui:");
        datelabell.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        datelabell.setForeground(colorgris);
        //le positionnement exact du label:
        datelabell.setBounds(45, 60, 200, 50);
        factureinfospanel.add(datelabell);

        Date today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
        datelabel = new JLabel(today.toString());
        datelabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        datelabel.setForeground(colorgris);
        //le positionnement exact du label:
        datelabel.setBounds(210, 60, 200, 50);
        factureinfospanel.add(datelabel);
        setUndecorated(true); // Supprime tous les boutons par défaut
        nom = new JLabel("Nom d'utilisateur:");
        nom.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        nom.setForeground(color.white);
        //le positionnement exact du label:
        nom.setBounds(45, 100, 400, 50);
        factureinfospanel.add(nom);

        String name=Hotel.getUserMap().get(Hotel.id_user_current).getName();
        String gmail=Hotel.getUserMap().get(Hotel.id_user_current).getGmail();
    
        nomutilisateur = new JLabel(name);
        nomutilisateur.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        nomutilisateur.setForeground(color.white);
        //le positionnement exact du label:
        nomutilisateur.setBounds(200, 100, 800, 50);
        factureinfospanel.add(nomutilisateur);
        closebtn.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setText(" ");
        // le positionement exact du boutton.
        closebtn.setBounds(1000, 5, 25, 30);
        getContentPane().add(closebtn);
        email= new JLabel("L'Email d'utilisateur:");
        email.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        email.setForeground(color.white);
        //le positionnement exact du label:
        email.setBounds(45, 130, 400, 50);
        factureinfospanel.add(email);

        emailutilisateur = new JLabel(gmail);
        emailutilisateur.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        emailutilisateur.setForeground(color.white);
        //le positionnement exact du label:
        emailutilisateur.setBounds(225, 130, 800, 50);
        factureinfospanel.add(emailutilisateur);

        //le tableau du panel:
        reservationtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room Type","Room Option", "Reservation Price", "Start Date", "End Date"
            }
        ));
        jScrollPane1.setViewportView(reservationtabel);

        // le positionement exact du tableau.
        jScrollPane1.setBounds(5, 170, 500, 300);
        getContentPane().add(jScrollPane1); 

        //ajouter le tableau au panel:
        factureinfospanel.add(jScrollPane1);

        //création du deuxième panel:
        JPanel totaleprixpanel = new JPanel();
        totaleprixpanel.setLayout(null);
        totaleprixpanel.setBorder((new RoundBorder(color, 3)));
        totaleprixpanel.setBackground(colorgris);
        //le positionnement exact du panel:
        totaleprixpanel.setBounds(20, 480, 470, 40);
        factureinfospanel.add(totaleprixpanel);

        //les labels du panel:
        totallabel = new JLabel(Double.toString(totalPrix()));
        totallabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        totallabel.setForeground(color.white);
        //le positionnement exact du label:
        totallabel.setBounds(360, 15, 100, 20);
        totaleprixpanel.add(totallabel);

        prixpanel = new JLabel("Total:");
        prixpanel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        prixpanel.setForeground(Color.WHITE);
        //le positionnement exact du label:
        prixpanel.setBounds(300, 0, 400, 50);
        totaleprixpanel.add(prixpanel);

        mercilabel = new JLabel("Merci D'avoir Réserver");
        mercilabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
        mercilabel.setForeground(color);
        //le positionnement exact du label:
        mercilabel.setBounds(45, 200, 400, 50);
        getContentPane().add(mercilabel);

        cheznous = new JLabel("Chez Nous");
        cheznous.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
        cheznous.setForeground(color);
        //le positionnement exact du label:
        cheznous.setBounds(45, 250, 800, 50);
        getContentPane().add(cheznous);

        backgroundlabel.setIcon(new javax.swing.ImageIcon("facture.png"));
        backgroundlabel.setText("Année");
        // le positionement exact du label.
        backgroundlabel.setBounds(0, 0, 1032, 580);
        getContentPane().add(backgroundlabel);       
        //la taille de la fenetre:
        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);
    }                      
        
    
    
    public static void main(String args[]) {
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new Facture().setVisible(true);
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify   
    private javax.swing.JButton suppreservationbtn;                  
    private javax.swing.JComboBox<String> acceptdeclinebox;
    private javax.swing.JButton acceptdeclinebtn;
    private javax.swing.JLabel reservationinutilelabel;
    private javax.swing.JLabel backgroundlabel; 
    private javax.swing.JLabel mercilabel;
    private javax.swing.JLabel cheznous;
    private javax.swing.JLabel facturelabel;
    private javax.swing.JLabel nomutilisateur;
    private javax.swing.JLabel emailutilisateur;
    private javax.swing.JLabel datelabell;
    private javax.swing.JLabel totallabel; 
    private javax.swing.JLabel prixpanel; 
    private javax.swing.JLabel nom;
    private javax.swing.JLabel email;
    private javax.swing.JLabel datelabel;
    private javax.swing.JLabel acceptordeclinelabel;
    private javax.swing.JLabel clicklabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reservationtabel;
    private javax.swing.JButton updatebtn;
    private javax.swing.JButton closebtn;
    private javax.swing.JButton backtoroomsbtn;
    // End of variables declaration                   
}


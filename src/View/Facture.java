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

        }}

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
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationtabel = new javax.swing.JTable();
        backgroundlabel = new javax.swing.JLabel();
        mercilabel = new javax.swing.JLabel();
        cheznous = new javax.swing.JLabel();
        facturelabel = new javax.swing.JLabel();
        nomutilisateur = new javax.swing.JLabel();
        emailutilisateur = new javax.swing.JLabel();
        datelabel = new javax.swing.JLabel();
        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");
 
        //rendre le layout manager null pour le positionement absolu:
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setVisible(true);

        //les labels du panel:

        //création du premier panel:
        JPanel factureinfospanel = new JPanel();
        factureinfospanel.setLayout(null);
        factureinfospanel.setBorder((new RoundBorder(color, 3)));
        factureinfospanel.setBackground(color);
        //le positionnement exact du panel:
        factureinfospanel.setBounds(504, 0, 515, 600);
        add(factureinfospanel);

        facturelabel = new JLabel("Facture");
        facturelabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 50));
        facturelabel.setForeground(colorgris);
        //le positionnement exact du label:
        facturelabel.setBounds(45, 20, 800, 50);
        factureinfospanel.add(facturelabel);

        Date today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
        datelabel = new JLabel(today.toString());
        datelabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
        datelabel.setForeground(colorgris);
        //le positionnement exact du label:
        datelabel.setBounds(45, 60, 800, 50);
        factureinfospanel.add(datelabel);

        String name=Hotel.getUserMap().get(Hotel.id_user_current).getName();
        nomutilisateur = new JLabel(name);
        nomutilisateur.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        nomutilisateur.setForeground(color.white);
        //le positionnement exact du label:
        nomutilisateur.setBounds(45, 100, 800, 50);
        factureinfospanel.add(nomutilisateur);

        String gmail=Hotel.getUserMap().get(Hotel.id_user_current).getGmail();
        emailutilisateur = new JLabel(gmail);
        emailutilisateur.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        emailutilisateur.setForeground(color.white);
        //le positionnement exact du label:
        emailutilisateur.setBounds(45, 130, 800, 50);
        factureinfospanel.add(emailutilisateur);

        // création du deuxième panel:
        JPanel totaleprixpanel = new JPanel();
        totaleprixpanel.setLayout(null);
        totaleprixpanel.setBorder((new RoundBorder(color, 3)));
        totaleprixpanel.setBackground(colorgris);
        //le positionnement exact du panel:
        totaleprixpanel.setBounds(20, 480, 470, 40);

        factureinfospanel.add(totaleprixpanel);

        //les labels du panel:
        mercilabel = new JLabel("Merci D'avoir Réserver");
        mercilabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
        mercilabel.setForeground(color);
        //le positionnement exact du label:
        mercilabel.setBounds(45, 200, 400, 50);
        getContentPane().add(mercilabel);

        //les labels du panel:
        cheznous = new JLabel("Chez Nous");
        cheznous.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
        cheznous.setForeground(color);
        //le positionnement exact du label:
        cheznous.setBounds(45, 250, 800, 50);
        getContentPane().add(cheznous);

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
    private javax.swing.JLabel backgroundlabel; 
    private javax.swing.JLabel mercilabel;
    private javax.swing.JLabel cheznous;
    private javax.swing.JLabel facturelabel;
    private javax.swing.JLabel nomutilisateur;
    private javax.swing.JLabel emailutilisateur;
    private javax.swing.JLabel datelabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reservationtabel;
    // End of variables declaration                   
}





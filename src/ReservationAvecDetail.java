import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ReservationAvecDetail extends javax.swing.JFrame {

    public ReservationAvecDetail() {
        initComponents();
    }

    private void initComponents() {


        // Création de la fenêtre principale
        setUndecorated(true); // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("signin page");
        setLocationRelativeTo(null);
        setVisible(true);
        // les labels:



        
        JLabel datedebutJLabel= new JLabel("date debut");
        JLabel datefinJLabel= new JLabel("date fin");
        JTextField datedebuTextField=new JTextField("jj/mois/annee");
        JTextField datefinTextField=new JTextField("jj/mois/annee");
        JCheckBox tvcCheckBox=new JCheckBox();
        JCheckBox climatisationBox=new JCheckBox();
        JCheckBox vuesurmerBox=new JCheckBox();
        JCheckBox vuesurforetBox=new JCheckBox();
        JLabel tvJLabel= new JLabel("tv :");
        JLabel vuesurmerJLabel= new JLabel("climatisation :");
        JLabel climatisationJLabel= new JLabel("vue sur mer :");
        JLabel vuesurforetJLabel= new JLabel("vue sur foret :");
        JLabel prixJLabel=new JLabel("prix:");
        javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();
         javax.swing.JComboBox<String> roomtypebox=new JComboBox<>();

        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");
        JPanel informationReservationPanel=new JPanel();


        informationReservationPanel.setLayout(null);
        informationReservationPanel.setBounds(3, 3, 1027, 200);
        informationReservationPanel.setBorder((new RoundBorder(color, 3)));
        informationReservationPanel.setBackground(colorgris);
        add(informationReservationPanel);

        informationReservationPanel.add(datedebutJLabel);
        informationReservationPanel.add(datefinJLabel);
        informationReservationPanel.add(datefinTextField);
        informationReservationPanel.add(datedebuTextField);
        informationReservationPanel.add(tvJLabel);
        informationReservationPanel.add(tvcCheckBox);
        informationReservationPanel.add(climatisationBox);
        informationReservationPanel.add(climatisationJLabel);
        informationReservationPanel.add(vuesurforetJLabel);
        informationReservationPanel.add(vuesurmerJLabel);
        informationReservationPanel.add(vuesurmerBox);
        informationReservationPanel.add(vuesurforetBox);
        informationReservationPanel.add(prixJLabel);

        datedebuTextField.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        datedebutJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        datefinJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        datefinTextField.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        tvJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        climatisationJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        vuesurforetJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        vuesurmerJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));

        datedebuTextField.setForeground(new Color(colorgris.getRed(),colorgris.getGreen(),colorgris.getBlue()+100));
        datedebutJLabel.setForeground(color);
        datefinJLabel.setForeground(color);
        datedebuTextField.setForeground(color);
        tvJLabel.setForeground(color);
        climatisationJLabel.setForeground(color);
        vuesurforetJLabel.setForeground(color);
        vuesurmerJLabel.setForeground(color);

        datedebuTextField.setBackground(colorgris);
        datedebuTextField.setForeground(color);
        datedebuTextField.setBorder(new RoundBorder(color,3));
        datefinTextField.setBackground(colorgris);
        datefinTextField.setForeground(color);
        datefinTextField.setBorder(new RoundBorder(color,3));

        prixJLabel.setBackground(color);
        prixJLabel.setForeground(color);

        prixJLabel.setBorder(new RoundBorder(color,3));


       
        datedebutJLabel.setBounds(220, 0, 150, 50);
        datedebuTextField.setBounds(340, 10, 150, 30);
        datefinJLabel.setBounds(560, 0, 150, 50);
        datefinTextField.setBounds(650, 10, 150, 30);

        tvJLabel.setBounds(100, 60, 40, 20);
        tvcCheckBox.setBounds(150, 60, 40, 20);
        climatisationJLabel.setBounds(250, 60, 200, 20);
        climatisationBox.setBounds(400, 60, 40, 20);
        vuesurforetJLabel.setBounds(500, 60, 200, 20);
        vuesurforetBox.setBounds(650, 60, 40, 20);
        vuesurmerJLabel.setBounds(750, 60, 200, 20);
        vuesurmerBox.setBounds(900, 60, 40, 20);
        prixJLabel.setBounds(840, 150, 150, 30);
        prixJLabel.setBackground(color);

        tvcCheckBox.setBackground(colorgris);
        climatisationBox.setBackground(colorgris);
        vuesurforetBox.setBackground(colorgris);
        vuesurmerBox.setBackground(colorgris);


        roomtypebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));
        roomtypebox.setBounds(650, 100, 150, 30);
        roomtypebox.setForeground(color);
        roomtypebox.setBackground(colorgris);
        roomtypebox.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(roomtypebox);
       
       
        
        JButton filtrer = new JButton();
        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        filtrer.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        filtrer.setText("Filtrer");
        filtrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrerbtnActionPerformed();
            }
        });
        // le positionement exact du boutton.
        filtrer.setBounds(840, 100, 150, 30);
        filtrer.setBackground(color);
        filtrer.setForeground(colorgris);
        filtrer.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(filtrer);
    
         // Bouton pour fermer la fenêtre
         JButton revenirbtn = new JButton("");
         revenirbtn.setBounds(970, 5, 25, 30);
         revenirbtn.setBackground(Color.white);
         add(revenirbtn);
 
         // Action pour fermer la fenêtre lorsque le bouton est cliqué
         revenirbtn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 dispose();
             }
         });
         informationReservationPanel.add(revenirbtn);
          // creation d'un boutton pour le close avec ses caractéristiques.

        // Utiliser la couleur
        javax.swing.JButton closebtn = new JButton(" ");
        closebtn.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        // le positionement exact du boutton.
        closebtn.setBounds(997, 5, 25, 30);
        informationReservationPanel.add(closebtn);

        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        System.setProperty("sun.java2d.uiScale.enabled", "false");
        backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png")); // NOI18N
        // le positionement exact du background.
        backgroundlabel.setBounds(0, 0, 1032, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);
    }

    private JFrame frame;

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "DO YOU REALY WANT TO CLOSE THIS WINDOW?", "MySQL Connector",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }

    private void filtrerbtnActionPerformed() {
        
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationAvecDetail().setVisible(true);
            }
        });
    }
}

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Loby extends javax.swing.JFrame {

    public Loby() {
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
        javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();
        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");

        // creation d'un boutton pour le close avec ses caractéristiques.

        // Utiliser la couleur
        javax.swing.JButton closebtn = new JButton(" ");
        closebtn.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        // le positionement exact du boutton.
        closebtn.setBounds(1000, 5, 25, 30);
        add(closebtn);

        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        JPanel descriptionpPanel = new JPanel();
        descriptionpPanel.setLayout(null);
        descriptionpPanel.setBounds(650, 40, 400, 250);

        descriptionpPanel.setBackground(colorgris);
        add(descriptionpPanel);

        JLabel descJLabel = new JLabel(
                "<html>Notre vision est d'être<br>l'Hotel le plus fiable<br>et respectée à djijel.</html>");
        descJLabel.setForeground(color);
        descJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 34));
        descJLabel.setBounds(10, 70, 900, 200);
        descriptionpPanel.add(descJLabel);

        JButton passeraureservationbtn = new JButton("passer aux reservation");
        passeraureservationbtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        passeraureservationbtn.setBackground(color);
        passeraureservationbtn.setBounds(700, 360, 240, 30);
        passeraureservationbtn.setForeground(colorgris);
        add(passeraureservationbtn);
        JButton aPropos = new JButton();
        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        aPropos.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        aPropos.setText("A propos de nous ");
        aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aProposbtnActionPerformed();
            }
        });
        // le positionement exact du boutton.
        aPropos.setBounds(840, 450, 150, 30);
        aPropos.setBackground(colorgris);
        aPropos.setForeground(color);
        aPropos.setBorder(new RoundBorder(color, 3));

        add(aPropos);

        passeraureservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passeraureservationActionPerformed();
            }
        });
        // le pos
        System.setProperty("sun.java2d.uiScale.enabled", "false");
        backgroundlabel.setIcon(new javax.swing.ImageIcon("4.png")); // NOI18N
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

    private void aProposbtnActionPerformed() {
        APropos a = new APropos();
    }

    private void passeraureservationActionPerformed() {
        new chambreinterface();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loby().setVisible(true);
            }
        });
    }
}

package View;
import Model.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class AdminLoby1 extends javax.swing.JFrame {
    javax.swing.JComboBox<String> langueBox = new JComboBox<>();
    JButton processusfindejournee = new JButton();
    JButton modifprixbtn = new JButton();

    public AdminLoby1() {
        initComponents();
    }

    private void initComponents() {

        // Création de la fenêtre principale
        setUndecorated(true); // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("adminLoby page");
        setLocationRelativeTo(null);
        setVisible(true);
        // les labels:
        javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();
        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");
        JButton modifieroptions = new JButton();
        JButton gererlesreservationbtn;

        if (Hotel.langue == 0) {
            langueBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Frensh" }));
        } else {
            langueBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Francais", "Anglais" }));
        }

        langueBox.setBounds(840, 5, 150, 30);
        langueBox.setForeground(color);
        langueBox.setBackground(colorgris);
        langueBox.setBorder(new RoundBorder(color, 3));
        add(langueBox);
        langueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changerlangue();
            }
        });

        if (Hotel.langue == 0) {

            gererlesreservationbtn = new JButton("manage reservations");
            modifieroptions.setText("add/delete/modifie room's options");
            processusfindejournee.setText("start the end of day process");
            modifprixbtn.setText("manage prices");
        } else {

            gererlesreservationbtn = new JButton("gerer les reservations");
            modifieroptions.setText("ajouter/supprimer/modifier une chambre");
            processusfindejournee.setText("lancer le processus de fin de journee");
            modifprixbtn.setText("gerer les prix");
        }
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

        gererlesreservationbtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        gererlesreservationbtn.setBackground(color);
        gererlesreservationbtn.setBounds(780, 300, 240, 30);
        gererlesreservationbtn.setForeground(colorgris);
        add(gererlesreservationbtn);

        modifprixbtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        modifprixbtn.setBackground(color);
        modifprixbtn.setBounds(10, 300, 240, 30);
        modifprixbtn.setForeground(colorgris);
        add(modifprixbtn);

        modifieroptions.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        modifieroptions.setBackground(color);
        modifieroptions.setBounds(320, 300, 400, 30);
        modifieroptions.setForeground(colorgris);
        add(modifieroptions);

        processusfindejournee.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        processusfindejournee.setBackground(color);
        processusfindejournee.setBounds(10, 10, 400, 30);
        processusfindejournee.setForeground(colorgris);
        add(processusfindejournee);

        modifieroptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    new Adminchambresoption();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        gererlesreservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    passeraureservationActionPerformed();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le pos
        System.setProperty("sun.java2d.uiScale.enabled", "false");
        backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png")); // NOI18N
        // le positionement exact du background.
        backgroundlabel.setBounds(0, 0, 1032, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);
    }


    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void passeraureservationActionPerformed() throws Exception {
        try {
          new TableReservationAdmin();
        } catch (Exception e) {
            e.getMessage();
        }
        
    }

    private void changerlangue() {
        if (langueBox.getSelectedItem() == "English" || langueBox.getSelectedItem() == "Anglais") {
            Hotel.langue = 0;

        } else {
            Hotel.langue = 1;
        }
        dispose();
        new AdminLoby1();

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLoby1();
            }
        });
    }
}
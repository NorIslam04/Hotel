package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Control.Control;
import Model.Hotel;

public class Login extends javax.swing.JFrame {
    public javax.swing.JComboBox<String> langueBox = new JComboBox<>();
    private JFrame frame;

    public Login() {
        initComponents();
    }

    private void initComponents() {

        userlabel = new javax.swing.JLabel();
        pwdlabel = new javax.swing.JLabel();
        loginlabel = new javax.swing.JLabel();
        welcomelabel = new javax.swing.JLabel();
        backgroundlabel = new javax.swing.JLabel();
        descriptionlabel = new javax.swing.JLabel();
        showPasswordLabel = new JLabel();
        usertext = new javax.swing.JTextField();
        pwdtext = new javax.swing.JPasswordField();
        seConnerButton = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        sinscrireButton = new javax.swing.JButton();
        aPropos = new javax.swing.JButton();
        showPasswordButton = new JCheckBox();

        // Création des panneaux
        JPanel bienvenuePanel = new JPanel();
        JPanel contenuPanel = new JPanel();
        JPanel bouttonsJPanel = new JPanel();

        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");
        setUndecorated(true);
        // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login page");
        setLocationRelativeTo(null);
        setVisible(true);
        // les labels:
        if (Hotel.langue == 0) {
            langueBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "French" }));
        } else {
            langueBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Francais", "Anglais" }));
        }
        langueBox.setBounds(400, 5, 150, 30);
        langueBox.setForeground(color);
        langueBox.setBackground(colorgris);
        langueBox.setBorder(new RoundBorder(color, 3));
        add(langueBox);

        if (Hotel.langue == 0) {
            pwdlabel.setText("Password:");
            descriptionlabel.setText(
                    "<html><p style='line-height: ;'>A Comfortable And Relaxing Stay Surrounded By Nature In JiJel,<br> Live The Experience</p></html>");
            showPasswordLabel.setText("See PassWord");
            userlabel.setText("User-name:"); // le positionement exact du label.
            loginlabel.setText("Log-In");
            welcomelabel.setText("<html><p style='line-height: ;'>Welcome To Harry,<br>The Ultimate Escape</p></html>");
            sinscrireButton.setText("I Don't Have An Acount");
            aPropos.setText("About-Us");
            loginlabel.setBounds(170, 30, 300, 40);
        } else {
            pwdlabel.setText("Mot de pass:");
            descriptionlabel.setText(
                    "<html><p style='line-height: ;'>un sejour confortable et relaxant en pleine nature a jijel,<br> vivez l'experience</p></html>");
            showPasswordLabel.setText("Voir le mot de pass");
            userlabel.setText("Pseudo:"); // le positionement exact du label.
            loginlabel.setText("Se Connecter");
            welcomelabel.setText(
                    "<html><p style='line-height: ;'>Bienvenue au Harry,<br>l’evasion par excellence</p></html>");
            sinscrireButton.setText("J'ai pas de compte");
            aPropos.setText("A propos de Nous");
            loginlabel.setBounds(125, 30, 300, 40);
        }

        // creation d'une label pour le username avec ses caractéristiques.
        userlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24));
        userlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));

        // le positionement exact du label.
        userlabel.setBounds(20, 100, 150, 30);
        getContentPane().add(userlabel);

        // creation d'une label pour la description avec ses caractéristiques.
        descriptionlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 15));
        descriptionlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));

        descriptionlabel.setBounds(42, 100, 1000, 105);
        getContentPane().add(descriptionlabel);

        // creation d'une label pour le show password avec ses caractéristiques.
        showPasswordLabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        showPasswordLabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue() + 50));

        // le positionement exact du label.
        showPasswordLabel.setBounds(170, 195, 150, 30);
        getContentPane().add(showPasswordLabel);

        // creation d'une label pour le password avec ses caractéristiques.
        pwdlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24));
        pwdlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));

        // le positionement exact du label.
        pwdlabel.setBounds(20, 150, 150, 30);
        getContentPane().add(pwdlabel);

        // creation d'une label pour le sign in avec ses caractéristiques.
        loginlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        loginlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));

        // le positionement exact du label.

        getContentPane().add(loginlabel);

        // creation d'une label pour le welcome avec ses caractéristiques.
        welcomelabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 37));
        welcomelabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));

        // le positionement exact du label.
        welcomelabel.setBounds(70, 34, 1000, 100);
        getContentPane().add(welcomelabel);

        // les bouttons:
        // boutton pour le show password
        showPasswordButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        showPasswordButton.setBounds(362, 200, 20, 20);
        showPasswordButton.setBackground(colorgris);
        getContentPane().add(showPasswordButton);

        // creation d'un boutton pour le submit avec ses caractéristiques.
        seConnerButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        seConnerButton.setText("Login");

        // le positionement exact du boutton.
        seConnerButton.setBounds(280, 457, 235, 40);
        seConnerButton.setBackground(color);
        seConnerButton.setForeground(Color.BLACK);

        // creation d'un boutton pour se connecter avec ses caractéristiques.
        sinscrireButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        sinscrireButton.setBorder(new RoundBorder(color, 3));

        // le positionement exact du boutton.
        sinscrireButton.setBounds(60, 457, 215, 40);
        sinscrireButton.setBackground(colorgris);
        sinscrireButton.setForeground(color);

        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        aPropos.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));

        // le positionement exact du boutton.
        aPropos.setBounds(60, 510, 452, 40);
        aPropos.setBackground(colorgris);
        aPropos.setBorder(new RoundBorder(color, 3));
        aPropos.setForeground(color);

        // Utiliser la couleur
        closebtn.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setText(" ");
        // le positionement exact du boutton.
        closebtn.setBounds(1000, 5, 25, 30);
        getContentPane().add(closebtn);

        // le positionement exact du textfield:
        pwdtext.setBounds(170, 150, 230, 30);
        // Définir le remplissage du champ de texte
        Border whiteBorder = BorderFactory.createLineBorder(color);

        // Créer une bordure transparente intérieure
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 10, 5, 10);

        // Combiner les deux bordures pour créer une bordure composée
        Border compoundBorder = BorderFactory.createCompoundBorder(whiteBorder, emptyBorder);

        // Appliquer la bordure composée au champ de texte
        pwdtext.setForeground(color);
        pwdtext.setBackground(colorgris);
        pwdtext.setBorder(compoundBorder);

        // le positionement exact du textfield.
        usertext.setBounds(170, 100, 230, 30);
        usertext.setForeground(color);
        usertext.setBackground(colorgris);
        usertext.setBorder(compoundBorder);
        getContentPane().add(usertext);

        // le positionement exct du textfield.

        // Définir la disposition des panneaux
        bienvenuePanel.setLayout(new BorderLayout());
        contenuPanel.setLayout(null);

        bouttonsJPanel.setLayout(null);

        // Ajouter les composants au panneau bienvenue
        bienvenuePanel.add(welcomelabel, BorderLayout.CENTER);
        bienvenuePanel.add(descriptionlabel, BorderLayout.SOUTH);

        // Ajouter les composants au panneau contenu
        contenuPanel.setBorder(new RoundBorder(color, 3));
        contenuPanel.add(userlabel);
        contenuPanel.add(pwdlabel);
        contenuPanel.add(loginlabel);
        contenuPanel.add(usertext);
        contenuPanel.add(pwdtext);

        contenuPanel.add(showPasswordLabel);
        contenuPanel.add(showPasswordButton);

        bouttonsJPanel.add(aPropos);
        bouttonsJPanel.add(sinscrireButton);
        bouttonsJPanel.add(seConnerButton);

        // Positionner les panneaux
        bienvenuePanel.setBounds(30, 10, 1032, 150); // Ajustez les coordonnées et les dimensions selon votre interface
        contenuPanel.setBounds(65, 200, 442, 250);
        bouttonsJPanel.setBounds(0, 10, 1032, 1000); // Ajustez les coordonnées et les dimensions selon votre interface
        bienvenuePanel.setOpaque(false);
        contenuPanel.setOpaque(false);
        bouttonsJPanel.setOpaque(false);
        // Ajouter les panneaux à la fenêtre principale
        getContentPane().add(bienvenuePanel);
        getContentPane().add(contenuPanel);
        getContentPane().add(bouttonsJPanel);

        System.setProperty("sun.java2d.uiScale.enabled", "false");
        backgroundlabel.setIcon(new javax.swing.ImageIcon("Home (2).png")); // NOI18N
        // le positionement exact du background.
        backgroundlabel.setBounds(0, 0, 1032, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);
    }

    public void togglePasswordVisibility() {// fait
        // Changer le type de champ de texte pour afficher ou masquer le mot de passe
        if (pwdtext.getEchoChar() == '\u2022') {
            pwdtext.setEchoChar((char) 0); // Afficher le mot de passe
        } else {
            pwdtext.setEchoChar('\u2022'); // Masquer le mot de passe
        }
    }

    // cbn
    public int seConnecterbtnActionPerformed(java.awt.event.ActionEvent evt) {

        if (usertext.getText().equals("") || pwdtext.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,
                    "Please Fill All The Text Fields !!",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return 0;

        } else if (usertext.getText().equals(".") && pwdtext.getText().equals(".")) {
            return 2;

        } else {
            if (Hotel.findUser(usertext.getText(), pwdtext.getText())) {
                return 1;

            } else {
                Control.tmp = JOptionPane.showConfirmDialog(frame, "Vous voulais ouvrir un nouveau compte ?",
                        "Cree Un Compte", JOptionPane.INFORMATION_MESSAGE);
                return -1;

            }
        }
    }

    public void changerlangue() {// fait

        if (langueBox.getSelectedItem() == "English" || langueBox.getSelectedItem() == "Anglais") {
            Hotel.langue = 0;

        } else {
            Hotel.langue = 1;
        }

    }

    // Variables declaration - do not modify
    public javax.swing.JLabel backgroundlabel;
    public javax.swing.JButton closebtn;
    public javax.swing.JLabel pwdlabel;
    public javax.swing.JPasswordField pwdtext;
    public javax.swing.JLabel loginlabel;
    public javax.swing.JButton seConnerButton;
    public javax.swing.JLabel userlabel;
    public javax.swing.JTextField usertext;
    public javax.swing.JLabel welcomelabel;
    public javax.swing.JLabel descriptionlabel;
    public JCheckBox showPasswordButton;
    public JButton sinscrireButton;
    public javax.swing.JLabel showPasswordLabel;
    public JButton aPropos;
    // End of variables declaration

}

// To:do verification de la validation de l adreesse mail
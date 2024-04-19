import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Login extends javax.swing.JFrame {

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
        // creation d'une label pour le username avec ses caractéristiques.
        userlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24));
        userlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        userlabel.setText("User-name:");
        // le positionement exact du label.
        userlabel.setBounds(20, 100, 150, 30);
        getContentPane().add(userlabel);

        // creation d'une label pour la description avec ses caractéristiques.
        descriptionlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 15));
        descriptionlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        descriptionlabel.setText("<html><p style='line-height: ;'>A Comfortable And Relaxing Stay Surrounded By Nature In JiJel,<br> Live The Experience</p></html>");
        // le positionement exact du label.
        descriptionlabel.setBounds(42, 100, 1000, 105);
        getContentPane().add(descriptionlabel);

        // creation d'une label pour le show password avec ses caractéristiques.
        showPasswordLabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        showPasswordLabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue() + 50));
        showPasswordLabel.setText("See PassWord");
        // le positionement exact du label.
        showPasswordLabel.setBounds(170, 195, 150, 30);
        getContentPane().add(showPasswordLabel);
        
        // creation d'une label pour le password avec ses caractéristiques.
        pwdlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); 
        pwdlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        pwdlabel.setText("Password:");
        // le positionement exact du label.
        pwdlabel.setBounds(20, 150, 150, 30);
        getContentPane().add(pwdlabel);

        // creation d'une label pour le sign in avec ses caractéristiques.
        loginlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        loginlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        loginlabel.setText("Log-In");
        // le positionement exact du label.
        loginlabel.setBounds(170, 30, 150, 40);
        getContentPane().add(loginlabel);

        // creation d'une label pour le welcome avec ses caractéristiques.
        welcomelabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 37));
        welcomelabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        welcomelabel.setText("<html><p style='line-height: ;'>Welcome To Harry,<br>The Ultimate Escape</p></html>");
        // le positionement exact du label.
        welcomelabel.setBounds(70, 34, 1000, 100);
        getContentPane().add(welcomelabel);

        // les bouttons:
        // boutton pour le show password
        showPasswordButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        showPasswordButton.setBounds(362, 200, 40, 20);
        getContentPane().add(showPasswordButton);

        // creation d'un boutton pour le submit avec ses caractéristiques.
        seConnerButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        seConnerButton.setText("Login");
        seConnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seConnecterbtnActionPerformed(evt);
            }
        });
        // le positionement exact du boutton.
        seConnerButton.setBounds(280, 457, 235, 40);
        seConnerButton.setBackground(color);
        seConnerButton.setForeground(Color.BLACK);

        // creation d'un boutton pour se connecter avec ses caractéristiques.
        sinscrireButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        sinscrireButton.setBorder(new RoundBorder(color, 3));
        sinscrireButton.setText("I Don't Have An Acount");

        sinscrireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinscrireButtonbtnActionPerformed();
            }
        });
        // le positionement exact du boutton.
        sinscrireButton.setBounds(60, 457, 215, 40);
        sinscrireButton.setBackground(colorgris);
        sinscrireButton.setForeground(color);

        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        aPropos.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        aPropos.setText("About Us");
        aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aProposbtnActionPerformed();
            }
        });
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

        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        // les textfields:
        pwdtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdtextActionPerformed(evt);
            }
        });
        showPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                togglePasswordVisibility();
            }
        });

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

    private void pwdtextActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void aProposbtnActionPerformed() {
        APropos a = new APropos();
    }

    private JFrame frame;

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {
        frame = new JFrame("Exit");
            System.exit(0);
    }

    private void togglePasswordVisibility() {
        // Changer le type de champ de texte pour afficher ou masquer le mot de passe
        if (pwdtext.getEchoChar() == '\u2022') {
            pwdtext.setEchoChar((char) 0); // Afficher le mot de passe
        } else {
            pwdtext.setEchoChar('\u2022'); // Masquer le mot de passe
            
        }
    }

    private void sinscrireButtonbtnActionPerformed() {
        dispose();
        new Signeininterface();
    }

    private void seConnecterbtnActionPerformed(java.awt.event.ActionEvent evt) {

        if (usertext.getText().equals("") || pwdtext.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,
                    "Please Fill All The Text Fields !!",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else if (usertext.getText().equals(".") && pwdtext.getText().equals(".")) {
            // new tableReservationAdmin && modifier chambre
            JOptionPane.showMessageDialog(frame,
                    "WELCOME ADMIN ",
                    "WELCOME",
                    JOptionPane.INFORMATION_MESSAGE);
            new chambreadmin();

        } else {

            if (Hotel.findUser(usertext.getText(), pwdtext.getText())) {
                chambreinterface ch = new chambreinterface();
                ch.setVisible(true);
                this.hide();

            } else {

                passerasignin pas = new passerasignin();
                pas.setVisible(true);

            }
        }
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JButton closebtn;
    private javax.swing.JLabel pwdlabel;
    private javax.swing.JPasswordField pwdtext;
    private javax.swing.JLabel loginlabel;
    private javax.swing.JButton seConnerButton;
    private javax.swing.JLabel userlabel;
    private javax.swing.JTextField usertext;
    private javax.swing.JLabel welcomelabel;
    private javax.swing.JLabel descriptionlabel;
    private JCheckBox showPasswordButton;
    private JButton sinscrireButton;
    private javax.swing.JLabel showPasswordLabel;
    private JButton aPropos;
    // End of variables declaration

}

// To:do verification de la validation de l adreesse mail
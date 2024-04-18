/*import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Signeininterface extends javax.swing.JFrame {

    public Signeininterface() {
        initComponents();
    }

    private void initComponents() {

        userlabel = new javax.swing.JLabel();
        pwdlabel = new javax.swing.JLabel();
        signinlabel = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        pwdtext = new javax.swing.JPasswordField();
        welcomelabel = new javax.swing.JLabel();
        submitbtn = new javax.swing.JButton();
        maillabel = new javax.swing.JLabel();
        mailtext = new javax.swing.JTextField();
        closebtn = new javax.swing.JButton();
        backgroundlabel = new javax.swing.JLabel();
        backtologinbtn = new javax.swing.JButton();
        
        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("signin page");
        setLocationRelativeTo(null);
        setVisible(true);
        // les labels:
        //creation d'une label pour le username avec ses caractéristiques.
        userlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        userlabel.setForeground(new java.awt.Color(255, 255, 255));
        userlabel.setText("User-name:");
        // le positionement exact du label.
        userlabel.setBounds(240, 300, 150, 30);
        getContentPane().add(userlabel);

        //creation d'une label pour le password avec ses caractéristiques.
        pwdlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        pwdlabel.setForeground(new java.awt.Color(255, 255, 255));
        pwdlabel.setText("Password:");
        // le positionement exact du label.
        pwdlabel.setBounds(240, 420, 150, 30);
        getContentPane().add(pwdlabel);
       
        //creation d'une label pour le sign in avec ses caractéristiques.
        signinlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 36)); // NOI18N
        signinlabel.setForeground(new java.awt.Color(255, 255, 255));
        signinlabel.setText("Sign-In");
        // le positionement exact du label.
        signinlabel.setBounds(380, 240,150,40);
        getContentPane().add(signinlabel);
        
        //creation d'une label pour le welcome avec ses caractéristiques.
        welcomelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 48)); 
        welcomelabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomelabel.setText("Welcome To Our Hotel");
        // le positionement exact du label.
        welcomelabel.setBounds(180, 30, 1000, 50);
        getContentPane().add(welcomelabel);
        
        //creation d'une label pour le e-mail avec ses caractéristiques.
        maillabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); 
        maillabel.setForeground(new java.awt.Color(255, 255, 255));
        maillabel.setText("Adresse-Mail:");
        // le positionement exact du label.
        maillabel.setBounds(240, 360, 200, 30);
        getContentPane().add(maillabel);
        
        //les bouttons:
        //creation d'un boutton pour le submit avec ses caractéristiques.
        submitbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        submitbtn.setText("Submit");
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    submitbtnActionPerformed(evt);
                } catch (deja_presente_bdd | SQLException e) {
                    e.printStackTrace();
                } catch (non_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du boutton.
        submitbtn.setBounds(620, 480, 100, 30);
        getContentPane().add(submitbtn);
       
        //creation d'un boutton pour le close avec ses caractéristiques.
        closebtn.setBackground(new java.awt.Color(171, 34, 34));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        closebtn.setForeground(new java.awt.Color(255, 255, 255));
        closebtn.setText("Close");
        // le positionement exact du boutton.
        closebtn.setBounds(210, 480, 100, 30);
        getContentPane().add(closebtn);


        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        backtologinbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        backtologinbtn.setText("Back To Login");
        // le positionement exact du signin button.
        backtologinbtn.setBounds(410, 480, 120, 30);
        getContentPane().add(backtologinbtn);
        // l'action du signin button.
        backtologinbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtologinbtnActionPerformed(evt);
            }
        });

        //les textfields:

        pwdtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdtextActionPerformed(evt);
            }
        });

        // le positionement exact du textfield:
        pwdtext.setBounds(440, 420, 230, 30);
        getContentPane().add(pwdtext);
        
        // le positionement exact du textfield.
        usertext.setBounds(440, 300, 230, 30);
        getContentPane().add(usertext);

        // le positionement exact du textfield.
        mailtext.setBounds(440, 360, 230, 30);
        getContentPane().add(mailtext);

        backgroundlabel.setIcon(new javax.swing.ImageIcon("sign_up.png")); // NOI18N
        // le positionement exact du background.
        backgroundlabel.setBounds(0, 0, 920, 580);
        getContentPane().add(backgroundlabel);
        
        setSize(new java.awt.Dimension(936, 588));
        setLocationRelativeTo(null);
    }                       

    private void pwdtextActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       
    private JFrame frame;
    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"DO YOU REALY WANT TO CLOSE THIS WINDOW?","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
    }    
    private void backtologinbtnActionPerformed(java.awt.event.ActionEvent evt) {                                               
        Login log = new Login();
        log.setVisible(true);
        this.hide();
    }    
    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) throws deja_presente_bdd, SQLException, non_presente_bdd { 
        if(Hotel.findUser(usertext.getText(), pwdtext.getText())){
            if(Hotel.findEmail(usertext.getText(), pwdtext.getText(), mailtext.getText())){
             JOptionPane.showMessageDialog(frame,
             "Ce compte existe deja !",
             "Compte Existe",
             JOptionPane.INFORMATION_MESSAGE);
             new Login();
            }else{
                JOptionPane.showMessageDialog(frame,
                "Votre compte a été créé avec succès ",
                "WELCOME",
                JOptionPane.INFORMATION_MESSAGE);
                //ajoute dans hashMap users
                User user=new User(User.getNb(), mailtext.getText(), usertext.getText(), pwdtext.getText());
                Hotel.AjtUserMap(user);
                this.dispose();
            }
         }  
        else if(usertext.getText().equals("") || pwdtext.getText().equals("") || mailtext.getText().equals("")){
            JOptionPane.showMessageDialog(frame,
            "Remplir le champ de User-Name et Password et Adresse-Mail !",
            "ERROR",
            JOptionPane.ERROR_MESSAGE); 
        }else{

            JOptionPane.showMessageDialog(frame,
            "Votre compte a été créé avec succès ",
            "WELCOME",
            JOptionPane.INFORMATION_MESSAGE);
            //ajoute dans hashMap users
            User user=new User(User.getNb(), mailtext.getText(), usertext.getText(), pwdtext.getText());
            Hotel.AjtUserMap(user);
            this.dispose();
        }
        DataBase.HasgMapsToDb();
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
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signeininterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JButton backtologinbtn;
    private javax.swing.JButton closebtn;
    private javax.swing.JLabel maillabel;
    private javax.swing.JTextField mailtext;
    private javax.swing.JLabel pwdlabel;
    private javax.swing.JPasswordField pwdtext;
    private javax.swing.JLabel signinlabel;
    private javax.swing.JButton submitbtn;
    private javax.swing.JLabel userlabel;
    private javax.swing.JTextField usertext;
    private javax.swing.JLabel welcomelabel;
    // End of variables declaration                   
}

*/

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Signeininterface extends javax.swing.JFrame {

    public Signeininterface() {
        initComponents();
    }

    private void initComponents() {

        userlabel = new javax.swing.JLabel();
        pwdlabel = new javax.swing.JLabel();
        signinlabel = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        pwdtext = new javax.swing.JPasswordField();
        welcomelabel = new javax.swing.JLabel();
        submitbtn = new javax.swing.JButton();
        maillabel = new javax.swing.JLabel();
        mailtext = new javax.swing.JTextField();
        closebtn = new javax.swing.JButton();
        backgroundlabel = new javax.swing.JLabel();
        descriptionlabel = new javax.swing.JLabel();

        showPasswordButton = new JButton();
        showPasswordLabel = new JLabel();
        seConnecterButton = new javax.swing.JButton();
        aPropos = new javax.swing.JButton();
        // Création des panneaux
        JPanel bienvenuePanel = new JPanel();
        JPanel contenuPanel = new JPanel();
        JPanel bouttonsJPanel = new JPanel();

        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");
        setUndecorated(true); // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("signin page");
        setLocationRelativeTo(null);
        setVisible(true);
        // les labels:
        // creation d'une label pour le username avec ses caractéristiques.
        userlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        userlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        userlabel.setText("User-name:");
        // le positionement exact du label.
        userlabel.setBounds(70, 270, 150, 30);
        getContentPane().add(userlabel);

        // creation d'une label pour la description avec ses caractéristiques.
        descriptionlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 15)); // NOI18N
        descriptionlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        descriptionlabel.setText(
                "<html><p style='line-height: ;'>un sejour confortable et relaxant en pleine nature a jijel,<br> vivez l'experience</p></html>");
        // le positionement exact du label.
        descriptionlabel.setBounds(42, 100, 1000, 105);
        getContentPane().add(descriptionlabel);

        // creation d'une label pour le show password avec ses caractéristiques.
        showPasswordLabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        showPasswordLabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue() + 50));
        showPasswordLabel.setText("voir le mot de passe");
        // le positionement exact du label.
        showPasswordLabel.setBounds(250, 385, 150, 30);
        getContentPane().add(showPasswordLabel);

        // creation d'une label pour le password avec ses caractéristiques.
        pwdlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        pwdlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        pwdlabel.setText("Password:");
        // le positionement exact du label.
        pwdlabel.setBounds(70, 350, 150, 30);
        getContentPane().add(pwdlabel);

        // creation d'une label pour le sign in avec ses caractéristiques.
        signinlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        signinlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        signinlabel.setText("Sign-In");
        // le positionement exact du label.
        signinlabel.setBounds(230, 220, 150, 40);
        getContentPane().add(signinlabel);

        // creation d'une label pour le welcome avec ses caractéristiques.
        welcomelabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 37));
        welcomelabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        welcomelabel
                .setText("<html><p style='line-height: ;'>Bienvenue au Harry,<br>l’evasion par excellence</p></html>");

        // le positionement exact du label.
        welcomelabel.setBounds(42, 34, 1000, 100);
        getContentPane().add(welcomelabel);
        // boutton pour le show passwd
        showPasswordButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        showPasswordButton.setText(" ");
        showPasswordButton.setBounds(460, 390, 40, 20);
        getContentPane().add(showPasswordButton);

        // creation d'une label pour le e-mail avec ses caractéristiques.
        maillabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24));
        maillabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        maillabel.setText("Adresse-Mail:");
        // le positionement exact du label.
        maillabel.setBounds(70, 310, 200, 30);
        getContentPane().add(maillabel);

        // les bouttons:
        // creation d'un boutton pour le submit avec ses caractéristiques.
        submitbtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        submitbtn.setText("creer un nouveau compte");
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    submitbtnActionPerformed(evt);
                } catch (deja_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du boutton.
        submitbtn.setBounds(280, 457, 235, 40);
        submitbtn.setBackground(color);
        submitbtn.setForeground(Color.BLACK);

        // creation d'un boutton pour se connecter avec ses caractéristiques.
        seConnecterButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        seConnecterButton.setText("Se Connecter");

        seConnecterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seConnecterButtonbtnActionPerformed();
            }
        });
        // le positionement exact du boutton.
        seConnecterButton.setBounds(60, 457, 150, 40);
        seConnecterButton.setBackground(colorgris);
        seConnecterButton.setForeground(Color.WHITE);

        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        aPropos.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        aPropos.setText("A propos de nous ");
        aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aProposbtnActionPerformed();
            }
        });
        // le positionement exact du boutton.
        aPropos.setBounds(60, 510, 452, 40);
        aPropos.setBackground(colorgris);
        aPropos.setForeground(Color.WHITE);

        // creation d'un boutton pour le close avec ses caractéristiques.

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
        pwdtext.setBounds(250, 350, 230, 30);
        // Définir le remplissage du champ de texte
        pwdtext.setForeground(color);
        pwdtext.setBackground(colorgris);

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
        usertext.setBounds(250, 270, 230, 30);
        usertext.setForeground(color);
        usertext.setBackground(colorgris);
        usertext.setBorder(compoundBorder);
        getContentPane().add(usertext);

        // le positionement exct du textfield.
        mailtext.setBounds(250, 310, 230, 30);
        mailtext.setForeground(color);
        mailtext.setBackground(colorgris);
        mailtext.setBorder(compoundBorder);
        getContentPane().add(mailtext);

        // Définir la disposition des panneaux
        bienvenuePanel.setLayout(new BorderLayout());
        contenuPanel.setLayout(null); // Vous pouvez ajuster le layout en fonction de vos besoins

        bouttonsJPanel.setLayout(null);

        // Ajouter les composants au panneau bienvenue
        bienvenuePanel.add(welcomelabel, BorderLayout.CENTER);
        bienvenuePanel.add(descriptionlabel, BorderLayout.SOUTH);

        // Ajouter les composants au panneau contenu
        contenuPanel.add(userlabel);
        contenuPanel.add(pwdlabel);
        contenuPanel.add(signinlabel);
        contenuPanel.add(usertext);
        contenuPanel.add(pwdtext);
        contenuPanel.add(maillabel);
        contenuPanel.add(mailtext);
        contenuPanel.add(showPasswordLabel);
        contenuPanel.add(showPasswordButton);

        bouttonsJPanel.add(aPropos);
        bouttonsJPanel.add(seConnecterButton);
        bouttonsJPanel.add(submitbtn);

        // Positionner les panneaux
        bienvenuePanel.setBounds(30, 10, 1032, 150); // Ajustez les coordonnées et les dimensions selon votre interface
        contenuPanel.setBounds(0, 10, 1032, 1000);
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
        // TODO add your handling code here:
    }

    private void aProposbtnActionPerformed() {
        APropos a = new APropos();
    }

    private JFrame frame;

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "DO YOU REALY WANT TO CLOSE THIS WINDOW?", "MySQL Connector",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }

    private void togglePasswordVisibility() {
        // Changer le type de champ de texte pour afficher ou masquer le mot de passe
        if (pwdtext.getEchoChar() == '\u2022') {
            pwdtext.setEchoChar((char) 0); // Afficher le mot de passe
            showPasswordButton.setText("*"); // Changer le texte du bouton
        } else {
            pwdtext.setEchoChar('\u2022'); // Masquer le mot de passe
            showPasswordButton.setText(" "); // Changer le texte du bouton
        }
    }

    private void seConnecterButtonbtnActionPerformed() {
        dispose();
        new Login();
    }

    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) throws deja_presente_bdd {
        if (Hotel.findUser(usertext.getText(), pwdtext.getText())) {
            if (Hotel.findEmail(usertext.getText(), pwdtext.getText(), mailtext.getText())) {
                JOptionPane.showMessageDialog(frame,
                        "Ce compte existe deja !",
                        "Compte Existe",
                        JOptionPane.INFORMATION_MESSAGE);
                new Login();
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Votre compte a été créé avec succès ",
                        "WELCOME",
                        JOptionPane.INFORMATION_MESSAGE);
                // ajoute dans hashMap users
                User user = new User(User.getNb(), mailtext.getText(), usertext.getText(), pwdtext.getText());
                Hotel.AjouterUserMap(user);
                ;// hna lzem nst3amlo had l fct machi lokhra !!!
                // chambreinterface ch =
                new chambreinterface();
            }
        } else if (usertext.getText().equals("") || pwdtext.getText().equals("") || mailtext.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,
                    "Remplir le champ de User-Name et Password et Adresse-Mail !",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(frame,
                    "Votre compte a été créé avec succès ",
                    "WELCOME",
                    JOptionPane.INFORMATION_MESSAGE);
            // ajoute dans hashMap users
            User user = new User(User.getNb(), mailtext.getText(), usertext.getText(), pwdtext.getText());
            Hotel.AjouterUserMap(user);
            ;// hna lzem nst3amlo had l fct machi lokhra !!!
            // chambreinterface ch =
            new chambreinterface();
            // ch.setVisible(true);
            this.hide();

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
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signeininterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JButton closebtn;
    private javax.swing.JLabel maillabel;
    private javax.swing.JTextField mailtext;
    private javax.swing.JLabel pwdlabel;
    private javax.swing.JPasswordField pwdtext;
    private javax.swing.JLabel signinlabel;
    private javax.swing.JButton submitbtn;
    private javax.swing.JLabel userlabel;
    private javax.swing.JTextField usertext;
    private javax.swing.JLabel welcomelabel;
    private javax.swing.JLabel descriptionlabel;
    private JButton showPasswordButton;
    private JButton seConnecterButton;
    private javax.swing.JLabel showPasswordLabel;
    private JButton aPropos;
    // End of variables declaration

}
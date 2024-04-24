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

public class Signeininterface extends javax.swing.JFrame {
    
    javax.swing.JComboBox<String> langueBox = new JComboBox<>();

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
      

        
        

        showPasswordButton = new JCheckBox();
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

        if(Hotel.langue==0){
            langueBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English","frensh" }));
        }else{
                langueBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Francais","Anglais" }));
         }
         langueBox.setBounds(400, 5, 150, 30);
         langueBox.setForeground(color);
        langueBox.setBackground(colorgris);
        langueBox.setBorder(new RoundBorder(color, 3));
        add(langueBox);
        langueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changerlangue();
            }
        });

        if(Hotel.langue==0){
            pwdlabel.setText("Password:");
            descriptionlabel.setText("<html><p style='line-height: ;'>A Comfortable And Relaxing Stay Surrounded By Nature In JiJel,<br> Live The Experience</p></html>");
            showPasswordLabel.setText("See PassWord");
            userlabel.setText("User-name:"); // le positionement exact du label.
            signinlabel.setText("Sign-In");
            welcomelabel.setText("<html><p style='line-height: ;'>Welcome To Harry,<br>The Ultimate Escape</p></html>");
            seConnecterButton.setText("Back To Login");
            submitbtn.setText("Creat A New Acount");
            maillabel.setText("Mail-Adress");
            aPropos.setText("About-Us");
            signinlabel.setBounds(170, 30, 300, 40);
            }else{
                pwdlabel.setText("Mot de pass:");
                descriptionlabel.setText("<html><p style='line-height: ;'>un sejour confortable et relaxant en pleine nature a jijel,<br> vivez l'experience</p></html>");
                showPasswordLabel.setText("Voir le mot de pass");
                userlabel.setText("Pseudo:"); // le positionement exact du label.
                signinlabel.setText("S'inscrire");
                welcomelabel.setText("<html><p style='line-height: ;'>Bienvenue au Harry,<br>l’evasion par excellence</p></html>");
                maillabel.setText("Adresse email");
                aPropos.setText("A propos de Nous");
                seConnecterButton.setText("revenir a ce connecter");
                submitbtn.setText("Creer un nouveaux compte");
           
                signinlabel.setBounds(10, 30, 300, 40);
            }
        
            
   
        
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("signin page");
        setLocationRelativeTo(null);
        setVisible(true);

        // les labels:
        // creation d'une label pour le username avec ses caractéristiques.
        userlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24));
        userlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
       
        // le positionement exact du label.
        userlabel.setBounds(20, 90, 150, 30);
        getContentPane().add(userlabel);

        // creation d'une label pour la description avec ses caractéristiques.
        descriptionlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 15));
        descriptionlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
      
        // le positionement exact du label.
        descriptionlabel.setBounds(42, 100, 1000, 105);
        getContentPane().add(descriptionlabel);

        // creation d'une label pour le show password avec ses caractéristiques.
        showPasswordLabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        showPasswordLabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue() + 50));
       
        // le positionement exact du label.
        showPasswordLabel.setBounds(170, 205, 150, 30);
        getContentPane().add(showPasswordLabel);

        // creation d'une label pour le password avec ses caractéristiques.
        pwdlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        pwdlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
       
        // le positionement exact du label.
        pwdlabel.setBounds(20, 170, 150, 30);
        getContentPane().add(pwdlabel);

        // creation d'une label pour le sign in avec ses caractéristiques.
        signinlabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        signinlabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
     
        // le positionement exact du label.
        signinlabel.setBounds(170, 30, 150, 40);
        getContentPane().add(signinlabel);

        // creation d'une label pour le welcome avec ses caractéristiques.
        welcomelabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 37));
        welcomelabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
    
        // le positionement exact du label.
        welcomelabel.setBounds(42, 34, 1000, 100);
        getContentPane().add(welcomelabel);
        // boutton pour le show passwd
        showPasswordButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        showPasswordButton.setText(" ");
        showPasswordButton.setBounds(370, 208, 40, 20);
        getContentPane().add(showPasswordButton);

        // creation d'une label pour le e-mail avec ses caractéristiques.
        maillabel.setFont(new java.awt.Font("Baskerville Old Face", 0, 24));
        maillabel.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
   
        // le positionement exact du label.
        maillabel.setBounds(20, 130, 200, 30);
        getContentPane().add(maillabel);

        // les bouttons:
        // creation d'un boutton pour le submit avec ses caractéristiques.
        submitbtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    submitbtnActionPerformed(evt);
                } catch (deja_presente_bdd e) {
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du boutton.
        submitbtn.setBounds(285, 457, 230, 40);
        submitbtn.setBackground(color);
        submitbtn.setForeground(Color.BLACK);

        // creation d'un boutton pour se connecter avec ses caractéristiques.
        seConnecterButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
    

        seConnecterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seConnecterButtonbtnActionPerformed();
            }
        });

        
        // le positionement exact du boutton.
        seConnecterButton.setBounds(60, 457, 220, 40);
        seConnecterButton.setBackground(colorgris);
        seConnecterButton.setForeground(Color.WHITE);

        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        aPropos.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
    
        aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aProposbtnActionPerformed();
            }
        });
        pwdtext.setEchoChar('\u2022');
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
        pwdtext.setBounds(170, 170, 230, 30);
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
        usertext.setBounds(170, 90, 230, 30);
        usertext.setForeground(color);
        usertext.setBackground(colorgris);
        usertext.setBorder(compoundBorder);
        getContentPane().add(usertext);

        // le positionement exct du textfield.
        mailtext.setBounds(170, 130, 230, 30);
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
        contenuPanel.setBounds(65, 200, 442, 250);
        contenuPanel.setBorder(new RoundBorder(color, 3));
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

    private void seConnecterButtonbtnActionPerformed() {
        dispose();
        new Login();
    }
    private void changerlangue(){
        if(langueBox.getSelectedItem()=="English"||langueBox.getSelectedItem()=="Anglais"){
            Hotel.langue=0;
           
        }else{
            Hotel.langue=1;
        }
        dispose();
        new Signeininterface();
       
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
                new Loby();
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
            new Loby();
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
    private JCheckBox showPasswordButton;
    private JButton seConnecterButton;
    private javax.swing.JLabel showPasswordLabel;
    private JButton aPropos;
    // End of variables declaration

}
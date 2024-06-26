package View;
import Model.*;
import Model.Chambre.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JLabel;

import javax.swing.JPanel;

public class Chambre_interface extends javax.swing.JFrame {
    public  javax.swing.JComboBox<String> langueBox = new JComboBox<>();
    public  JButton aPropos = new JButton();

    public  JButton avissurnousButton = new JButton();
    public  JButton passeraureservationbtn;
    public  JLabel descJLabel;
    public  JButton reserverpardetailbtn= new  JButton();
    public  JButton revenirbtn = new JButton("");
    public  JButton closebtn = new JButton(" ");



    public Chambre_interface() {
        initComponents();
    }

    private void initComponents() {

        JLabel suitetext = new javax.swing.JLabel();
        JLabel prixsuite = new javax.swing.JLabel();
        JLabel doubletext = new javax.swing.JLabel();
        JLabel prixdouble = new javax.swing.JLabel();
        JLabel triotext = new javax.swing.JLabel();
        JLabel prixtrio = new javax.swing.JLabel();
        JLabel solotext = new javax.swing.JLabel();
        JLabel prixsolo = new javax.swing.JLabel();
        JPanel soloPanel = new JPanel();
        JPanel doublePanel = new JPanel();
        JPanel triplePanel = new JPanel();
        JPanel suitePanel = new JPanel();


        
        // Création de la fenêtre principale
        // Supprime tous les boutons par défaut
        setUndecorated(true);

        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("chambre");
        setLocationRelativeTo(null);
        setVisible(true);
        
        // les couleurs utilisées:
        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");


        
        if(Hotel.langue==0){
            langueBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English","Frensh" }));
            }else{
                langueBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Francais","Anglais" }));
            }

        langueBox.setBounds(800, 5, 150, 30);
        langueBox.setForeground(color);
        langueBox.setBackground(colorgris);
        langueBox.setBorder(new RoundBorder(color, 3));
        add(langueBox);
        
        
        
        if(Hotel.langue==0){
            reserverpardetailbtn.setText("Price with options");
            avissurnousButton.setText("Comments");
            aPropos.setText("About Us ");
             passeraureservationbtn = new JButton("Manage my reservations");
            prixsuite.setText(Option.GetPrix("SUITE")+ "$/Night.");
            suitetext.setText("Suite:Max 5 Guests.");

            prixtrio.setText(Option.GetPrix("TRIPLE")+ "$/Night.");
            triotext.setText("Trio Room:Max 3 Guests.");

            prixdouble.setText(Option.GetPrix("DOUBLE") + "$/Night.  ");
            doubletext.setText("Double Room: Max 2 Guests.");

            prixsolo.setText(Option.GetPrix("SOLO") + "$/Night.");
            solotext.setText("Solo Room:For 1 Guest.");
             descJLabel = new JLabel("Our Rooms");

             suitetext.setBounds(50, 25, 120, 20);
             doubletext.setBounds(28, 25, 200, 20);
             solotext.setBounds(40, 25, 200, 20);
             triotext.setBounds(35, 25, 200, 20);
        }else{
            reserverpardetailbtn.setText("Prix avec options");
            avissurnousButton.setText("Commentaires ");
            aPropos.setText("A propos de nous ");
             passeraureservationbtn = new JButton("Gerer mes reservation");
            prixsuite.setText(TypeChambre.SUITE.getPrix() + "$/nuit.");
            suitetext.setText("Suite:Max 5 personnes.");
            prixtrio.setText(TypeChambre.TRIPLE.getPrix() + "$/nuit.");
            triotext.setText("Chambre tripe:Max 3 personnes.");
            prixdouble.setText(TypeChambre.DOUBLE.getPrix() + "$/nuit.  ");
            doubletext.setText("Chambre Double : Max 2 persns.");
            prixsolo.setText(TypeChambre.SOLO.getPrix() + "$/nuit.");
            solotext.setText("Chambre Solo : pour 1 personne.");
             descJLabel = new JLabel("Nos Chambre");
             suitetext.setBounds(50, 25, 200, 20);
             doubletext.setBounds(20, 25, 200, 20);
             solotext.setBounds(20, 25, 200, 20);
             triotext.setBounds(20, 25, 200, 20);

        }
        //les panels:
        JPanel descriptionpPanel = new JPanel();
        descriptionpPanel.setLayout(null);
        descriptionpPanel.setBounds(400, 20, 400, 100);
        descriptionpPanel.setBackground(colorgris);
        add(descriptionpPanel);

        doublePanel.setLayout(null);
        soloPanel.setLayout(null);
        triplePanel.setLayout(null);
        suitePanel.setLayout(null);

        soloPanel.setBounds(49, 338, 219, 100);
        doublePanel.setBounds(287, 338, 219, 100);
        triplePanel.setBounds(526, 338, 219, 100);
        suitePanel.setBounds(768, 338, 219, 100);

        soloPanel.setBackground(colorgris);
        doublePanel.setBackground(colorgris);
        triplePanel.setBackground(colorgris);
        suitePanel.setBackground(colorgris);

        soloPanel.setBorder(new RoundBorder(color, 3));
        doublePanel.setBorder(new RoundBorder(color, 3));
        triplePanel.setBorder(new RoundBorder(color, 3));
        suitePanel.setBorder(new RoundBorder(color, 3));

        // les labels:
        javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();

        JLabel suiteimLabel = new JLabel();
        suiteimLabel.setIcon(new javax.swing.ImageIcon("Design sans titre (10).png"));
        // le positionement exact du label.
        suiteimLabel.setBounds(49, 140, 219, 180);
        getContentPane().add(suiteimLabel);

        JLabel triJLabel = new JLabel();
        triJLabel.setIcon(new javax.swing.ImageIcon("Design sans titre (11).png"));
        // le positionement exact du label.
        triJLabel.setBounds(768, 140, 219, 180);
        getContentPane().add(triJLabel);

        JLabel doubleJLabel = new JLabel();
        doubleJLabel.setIcon(new javax.swing.ImageIcon("Design sans titre (12).png"));
        // le positionement exact du label.
        doubleJLabel.setBounds(287, 140, 219, 180);
        getContentPane().add(doubleJLabel);

        JLabel soloJLabel = new JLabel();
        soloJLabel.setIcon(new javax.swing.ImageIcon("Design sans titre (13).png"));
        // le positionement exact du label.
        soloJLabel.setBounds(526, 140, 219, 180);
        getContentPane().add(soloJLabel);

        
        descJLabel.setForeground(color);
        descJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 34));
        // le positionement exact du label.
        descJLabel.setBounds(10, 0, 900, 100);
        descriptionpPanel.add(descJLabel);

        // creation d'une label pour solo avec ses caractéristiques.
        solotext.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        
        solotext.setForeground(color);
        // le positionement exact du label.
        
 
        // creation d'une label pour prix solo avec ses caractéristiques.
        prixsolo.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        
        prixsolo.setForeground(color);
        // le positionement exact du label.
        prixsolo.setBounds(80, 45, 120, 20);
 
        soloPanel.add(solotext);
        soloPanel.add(prixsolo);
        add(soloPanel);

        // creation d'une label pour double avec ses caractéristiques.
        doubletext.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
       
        doubletext.setForeground(color);
        // le positionement exact du label.
      
        // creation d'une label pour prix double avec ses caractéristiques.
        prixdouble.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
       
        prixdouble.setForeground(color);
        // le positionement exact du label.
        prixdouble.setBounds(80, 45, 120, 20);

        doublePanel.add(doubletext);
        doublePanel.add(prixdouble);
        add(doublePanel);

        // creation d'une label pour trio avec ses caractéristiques.
        triotext.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));

        triotext.setForeground(color);
       

        // creation d'une label pour prix trio avec ses caractéristiques.
        prixtrio.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
    
        prixtrio.setForeground(color);
        // le positionement exact du label.
        prixtrio.setBounds(80, 45, 120, 20);

        triplePanel.add(triotext);
        triplePanel.add(prixtrio);
        add(triplePanel);

        // creation d'une label pour suite avec ses caractéristiques.
        suitetext.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
     
        suitetext.setForeground(color);
        // le positionement exact du label.
       

        // creation d'une label pour prix suite avec ses caractéristiques.
        prixsuite.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
       
        prixsuite.setForeground(color);
        // le positionement exact du label.
        prixsuite.setBounds(80, 45, 120, 20);

        suitePanel.add(suitetext);
        suitePanel.add(prixsuite);
        add(suitePanel);
        
        // les bouttons:
        // creation d'un boutton pour le close avec ses caractéristiques.
        closebtn.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        // le positionement exact du boutton.
        closebtn.setBounds(1000, 5, 25, 30);
        add(closebtn);

        

        
        passeraureservationbtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        passeraureservationbtn.setBackground(color);
        passeraureservationbtn.setBounds(86, 480, 240, 40);
        passeraureservationbtn.setForeground(colorgris);
        add(passeraureservationbtn);

      
        reserverpardetailbtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        reserverpardetailbtn.setBackground(color);
        reserverpardetailbtn.setBounds(665, 480, 240, 40);
        reserverpardetailbtn.setForeground(colorgris);
        add(reserverpardetailbtn);

        
        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        aPropos.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
    

        aPropos.setBounds(10, 10, 150, 30);
        aPropos.setBackground(colorgris);
        aPropos.setForeground(color);
        aPropos.setBorder(new RoundBorder(color, 3));

        add(aPropos);

        
        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        avissurnousButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
     
        
        // le positionement exact du boutton.
        avissurnousButton.setBounds(10, 40, 150, 30);
        avissurnousButton.setBackground(colorgris);
        avissurnousButton.setForeground(color);
        avissurnousButton.setBorder(new RoundBorder(color, 3));
        

        add(avissurnousButton);

        // Bouton pour fermer la fenêtre
        
        // le positionement exact du boutton.
        revenirbtn.setBounds(970, 5, 25, 30);
        revenirbtn.setBackground(Color.white);
        add(revenirbtn);

        // Action pour fermer la fenêtre lorsque le bouton est cliqué

        System.setProperty("sun.java2d.uiScale.enabled", "false");
        backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png")); // NOI18N
        // le positionement exact du background.
        backgroundlabel.setBounds(0, 0, 1032, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);
        this.setVisible(true);

    }



    public void changerlangue(){
        if(langueBox.getSelectedItem()=="English"||langueBox.getSelectedItem()=="Anglais"){
            Hotel.langue=0;
           
        }else{
            Hotel.langue=1;
        }
        
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chambre_interface().setVisible(true);
            }
        });
    }
}

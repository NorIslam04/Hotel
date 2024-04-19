import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chambreinterface extends javax.swing.JFrame {

    public chambreinterface() {
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
        suiteimLabel.setIcon(new javax.swing.ImageIcon("Design sans titre (9).png"));
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

        JLabel descJLabel = new JLabel("Nos Chambre");
        descJLabel.setForeground(color);
        descJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 34));
        // le positionement exact du label.
        descJLabel.setBounds(10, 0, 900, 100);
        descriptionpPanel.add(descJLabel);

        // creation d'une label pour solo avec ses caractéristiques.
        solotext.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        solotext.setText("Solo Room:For 1 Guest.");
        solotext.setForeground(color);
        // le positionement exact du label.
        solotext.setBounds(40, 25, 200, 20);
 
        // creation d'une label pour prix solo avec ses caractéristiques.
        prixsolo.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        prixsolo.setText(TypeChambre.SOLO.getPrix() + "$/Night.");
        prixsolo.setForeground(color);
        // le positionement exact du label.
        prixsolo.setBounds(70, 45, 120, 20);
 
        soloPanel.add(solotext);
        soloPanel.add(prixsolo);
        add(soloPanel);

        // creation d'une label pour double avec ses caractéristiques.
        doubletext.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        doubletext.setText("Double Room: Max 2 Guests.");
        doubletext.setForeground(color);
        // le positionement exact du label.
        doubletext.setBounds(28, 25, 200, 20);

        // creation d'une label pour prix double avec ses caractéristiques.
        prixdouble.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        prixdouble.setText(TypeChambre.DOUBLE.getPrix() + "$/Night.  ");
        prixdouble.setForeground(color);
        // le positionement exact du label.
        prixdouble.setBounds(70, 45, 120, 20);

        doublePanel.add(doubletext);
        doublePanel.add(prixdouble);
        add(doublePanel);

        // creation d'une label pour trio avec ses caractéristiques.
        triotext.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        triotext.setText("Trio Room:Max 3 Guests.");
        triotext.setForeground(color);
        // le positionement exact du label.
        triotext.setBounds(35, 25, 200, 20);

        // creation d'une label pour prix trio avec ses caractéristiques.
        prixtrio.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        prixtrio.setText(TypeChambre.TRIPLE.getPrix() + "$/Night.");
        prixtrio.setForeground(color);
        // le positionement exact du label.
        prixtrio.setBounds(70, 45, 120, 20);

        triplePanel.add(triotext);
        triplePanel.add(prixtrio);
        add(triplePanel);

        // creation d'une label pour suite avec ses caractéristiques.
        suitetext.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        suitetext.setText("Suite:Max 5 Guests.");
        suitetext.setForeground(color);
        // le positionement exact du label.
        suitetext.setBounds(50, 25, 120, 20);

        // creation d'une label pour prix suite avec ses caractéristiques.
        prixsuite.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        prixsuite.setText(TypeChambre.SUITE.getPrix() + "$/Night.");
        prixsuite.setForeground(color);
        // le positionement exact du label.
        prixsuite.setBounds(70, 45, 120, 20);

        suitePanel.add(suitetext);
        suitePanel.add(prixsuite);
        add(suitePanel);
        
        // les bouttons:
        // creation d'un boutton pour le close avec ses caractéristiques.
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

        JButton passeraureservationbtn = new JButton("passer aux reservation");
        passeraureservationbtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        passeraureservationbtn.setBackground(color);
        passeraureservationbtn.setBounds(86, 480, 240, 40);
        passeraureservationbtn.setForeground(colorgris);
        add(passeraureservationbtn);

        JButton reserverpardetailbtn = new JButton("reservation avec details");
        reserverpardetailbtn.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        reserverpardetailbtn.setBackground(color);
        reserverpardetailbtn.setBounds(665, 480, 240, 40);
        reserverpardetailbtn.setForeground(colorgris);
        add(reserverpardetailbtn);

        JButton aPropos = new JButton();
        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        aPropos.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        aPropos.setText("A propos de nous ");
        aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aProposbtnActionPerformed();
            }
        });
        aPropos.setBounds(10, 10, 150, 30);
        aPropos.setBackground(colorgris);
        aPropos.setForeground(color);
        aPropos.setBorder(new RoundBorder(color, 3));

        add(aPropos);

        JButton avissurnousButton = new JButton();
        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        avissurnousButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        avissurnousButton.setText("Avis sur nous ");
        avissurnousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avissurnousButtonActionPerformed();
            }
        });
        // le positionement exact du boutton.
        avissurnousButton.setBounds(10, 40, 150, 30);
        avissurnousButton.setBackground(colorgris);
        avissurnousButton.setForeground(color);
        avissurnousButton.setBorder(new RoundBorder(color, 3));

        add(avissurnousButton);

        // Bouton pour fermer la fenêtre
        JButton revenirbtn = new JButton("");
        // le positionement exact du boutton.
        revenirbtn.setBounds(970, 5, 25, 30);
        revenirbtn.setBackground(Color.white);
        add(revenirbtn);

        // Action pour fermer la fenêtre lorsque le bouton est cliqué
        revenirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        passeraureservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passeraureservationActionPerformed();
            }
        });

        reserverpardetailbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserverDetailActionPerformed();
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

    private void avissurnousButtonActionPerformed() {
        
    };

    private void aProposbtnActionPerformed() {
        APropos a = new APropos();
    }

    private void passeraureservationActionPerformed() {
        new TableReseravtionUser();
    }

    private void reserverDetailActionPerformed() {
        try {
            new ReservationAvecDetail();
        } catch (deja_presente_bdd e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chambreinterface().setVisible(true);
            }
        });
    }
}

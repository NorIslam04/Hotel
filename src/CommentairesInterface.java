import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;;

class BlackScrollPane extends JScrollPane {
    public BlackScrollPane(Component view) {
        super(view);
        setOpaque(false);
    }
}

public class CommentairesInterface extends javax.swing.JFrame {

    JCheckBox etoile1Box = new JCheckBox();
    JCheckBox etoile2Box = new JCheckBox();
    JCheckBox etoile3Box = new JCheckBox();
    JCheckBox etoile4Box = new JCheckBox();
    JCheckBox etoile5Box = new JCheckBox();
    JPanel commentContainerJPanel = new JPanel(new GridLayout(0, 1, 0, 0));
    BlackScrollPane scrollPane;
    Color color = Color.decode("#E0C878");
    Color colorgris = Color.decode("#252926");
    JLabel prixJLabel;

    javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();

    public CommentairesInterface() throws deja_presente_bdd {
        initComponents();
    }

    private void initComponents() throws deja_presente_bdd {

        // hedy pour le test brk ne7iha apres mlzmch nnssaaaaaaaaaaaaaa////////
        // Création de la fenêtre principale
        setUndecorated(true); // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("commentaires page");
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel rateusJLabel;

        JButton commenterbtn = new JButton();
        // les labels:
        if (Hotel.langue == 0) {

            commenterbtn.setText("comment");
            rateusJLabel = new JLabel("rate us :");

        } else {
            rateusJLabel = new JLabel("notez nous:");
            commenterbtn.setText("commenter");

        }

        JPanel informationReservationPanel = new JPanel();

        informationReservationPanel.setLayout(null);
        informationReservationPanel.setBounds(3, 3, 1027, 200);
        informationReservationPanel.setBorder((new RoundBorder(color, 3)));
        informationReservationPanel.setBackground(colorgris);
        add(informationReservationPanel);

        etoile1Box.setBounds(240, 90, 40, 20);
        etoile2Box.setBounds(240, 110, 40, 20);
        etoile4Box.setBounds(240, 150, 40, 20);
        etoile3Box.setBounds(240, 130, 40, 20);
        etoile5Box.setBounds(240, 170, 40, 20);

        rateusJLabel.setBounds(20, 60, 200, 17);

        rateusJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        rateusJLabel.setForeground(colorgris);

        JPanel optioJPanel = new JPanel();
        optioJPanel.setLayout(null);

        optioJPanel.add(etoile1Box);
        optioJPanel.add(etoile2Box);
        optioJPanel.add(etoile3Box);
        optioJPanel.add(etoile5Box);
        optioJPanel.add(etoile4Box);
        optioJPanel.add(rateusJLabel);
        optioJPanel.setBounds(400, 10, 380, 180);
        optioJPanel.setBackground(color);
        informationReservationPanel.add(optioJPanel);

        // Créer une JComboBox et lui fournir le tableau d'entiers comme modèle

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
        Icon etoileBlancheIcon = new ImageIcon("For Rent21.png");
        Icon etoileJauneIcon = new ImageIcon("For Rent2.png");

        // Initialiser les cases à cocher avec l'icône d'étoile blanche
        etoile1Box.setIcon(etoileBlancheIcon);
        etoile2Box.setIcon(etoileBlancheIcon);
        etoile3Box.setIcon(etoileBlancheIcon);
        etoile4Box.setIcon(etoileBlancheIcon);
        etoile5Box.setIcon(etoileBlancheIcon);

        // Ajouter un écouteur d'événements à chaque case à cocher
        etoile1Box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (etoile1Box.isSelected()) {
                    etoile1Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune

                } else {
                    etoile1Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile blanche
                    etoile2Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile2Box.setSelected(false);
                    etoile4Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile4Box.setSelected(false);
                    etoile3Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile3Box.setSelected(false); // Changer l'icône en étoile jaune
                    etoile5Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile5Box.setSelected(false);

                }
            }
        });
        etoile2Box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (etoile2Box.isSelected()) {
                    etoile2Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile1Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile1Box.setSelected(true);

                } else {
                    etoile2Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile
                    etoile4Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile4Box.setSelected(false);
                    etoile3Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile3Box.setSelected(false); // Changer l'icône en étoile jaune
                    etoile5Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile5Box.setSelected(false);
                }
            }
        });
        etoile3Box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (etoile3Box.isSelected()) {
                    etoile3Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile1Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile1Box.setSelected(true);
                    etoile2Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile2Box.setSelected(true);
                } else {
                    etoile3Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile blanche
                    etoile4Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile4Box.setSelected(false);// Changer l'icône en étoile jaune
                    etoile5Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile5Box.setSelected(false);
                }
            }
        });
        etoile4Box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (etoile4Box.isSelected()) {
                    etoile4Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune

                    etoile3Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile3Box.setSelected(true); // Changer l'icône en étoile jaune
                    etoile1Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile1Box.setSelected(true);
                    etoile2Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile2Box.setSelected(true);
                } else {
                    etoile4Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile blanche
                    etoile5Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile5Box.setSelected(false);
                }
            }
        });
        etoile5Box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (etoile5Box.isSelected()) {
                    etoile5Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile5Box.setSelected(true);
                    etoile4Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile4Box.setSelected(true);// Changer l'icône en étoile jaun
                    etoile3Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile3Box.setSelected(true); // Changer l'icône en étoile jaune
                    etoile1Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile1Box.setSelected(true);
                    etoile2Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile2Box.setSelected(true);
                } else {
                    etoile5Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile blanche
                }
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
                try {
                    closebtnActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        commenterbtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));

        // le positionement exact du boutton.
        commenterbtn.setBounds(840, 50, 150, 30);
        commenterbtn.setBackground(color);
        commenterbtn.setForeground(colorgris);
        commenterbtn.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(commenterbtn);

        System.setProperty("sun.java2d.uiScale.enabled", "false");
        backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png")); // NOI18N
        // le positionement exact du background.
        backgroundlabel.setBounds(0, 0, 1032, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);
    }

    public JPanel createPanel(Commentaires comment) {
        JPanel panel = new JPanel();
        JLabel nameLabel;
        JLabel commentLabel;
        JLabel datLabel;

        panel.setLayout(new BorderLayout()); // Utilisation d'un BorderLayout

        JButton modif, supprimer;
        if (Hotel.langue == 0) {
            nameLabel = new JLabel("User : " + comment.getUser().getName());
            commentLabel = new JLabel(" " + comment.getCommentaire());
            datLabel = new JLabel(" " + comment.getDate().getJour() + comment.getDate().getMois() + "/"
                    + comment.getDate().getAnnee() + "/");

            modif = new JButton("modify");
            supprimer = new JButton("delete");
        } else {
            nameLabel = new JLabel("User : " + comment.getUser().getName());
            commentLabel = new JLabel(" " + comment.getCommentaire());
            datLabel = new JLabel("le : " + comment.getDate().getJour() + comment.getDate().getMois() + "/"
                    + comment.getDate().getAnnee() + "/");

            modif = new JButton("modifier");
            supprimer = new JButton("supprimer");
        }

        nameLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        nameLabel.setForeground(colorgris);
        commentLabel.setForeground(colorgris);
        commentLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        datLabel.setForeground(colorgris);
        datLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        // Utilisation d'un BoxLayout vertical
        // pour les options

        // Ajout du bouton "Réserver"

        modif.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        supprimer.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        // Ajout des composants au JPanel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 1)); // Utilisation d'un GridLayout pour empiler verticalement les
                                                   // éléments
        infoPanel.add(nameLabel);

        infoPanel.add(commentLabel);
        infoPanel.add(datLabel);

        modif.setBackground(colorgris);
        modif.setForeground(color);
        supprimer.setBackground(colorgris);
        supprimer.setForeground(color);
        infoPanel.setBackground(Color.white);
        panel.setBackground(Color.white);

        panel.add(infoPanel, BorderLayout.NORTH); // Ajout du panneau d'informations au centre
        if (Hotel.id_user_current == comment.getUser().getId()) {
            panel.add(modif, BorderLayout.SOUTH);
            panel.add(supprimer, BorderLayout.SOUTH); // Ajout du bouton Réserver en bas
        }
        Border border = new RoundBorder(colorgris, 2); // Utilisation du code RGB pour la couleur marron

        modif.setBorder(border);
        panel.setBorder(border);
        // Définir une taille préférée pour le JPanel
        panel.setPreferredSize(new Dimension(182, 700));

        return panel;
    }

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new CommentairesInterface().setVisible(true);
                } catch (deja_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

}

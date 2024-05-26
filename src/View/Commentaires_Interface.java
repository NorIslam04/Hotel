package View;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.Border;
import Control.Control;
import Model.Commentaires;
import Model.Hotel;

class BlackScrollPane extends JScrollPane {
    public BlackScrollPane(Component view) {
        super(view);
        setOpaque(false);
    }
}

public class Commentaires_Interface extends javax.swing.JFrame {

    public static int note=Hotel.getUserMap().get(Hotel.id_user_current).getNote();

    // pour le test
    public JButton revenirbtn = new JButton("");
    JCheckBox etoile1Box = new JCheckBox();
    JCheckBox etoile2Box = new JCheckBox();
    JCheckBox etoile3Box = new JCheckBox();
    JCheckBox etoile4Box = new JCheckBox();
    JCheckBox etoile5Box = new JCheckBox();
    public JTextArea commenttxt = new JTextArea(1, 1);;
    JPanel commentContainerJPanel = new JPanel(new GridLayout(0, 1, 0, 0));
    BlackScrollPane scrollPane;
    Color color = Color.decode("#E0C878");
    Color colorgris = Color.decode("#252926");
    public javax.swing.JButton closebtn = new JButton("");
    javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();
    JLabel moyenneactuelle=new JLabel(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");
    public JButton commenterbtn = new JButton();

    public Commentaires_Interface() throws Exception {
        initComponents();
    }

    private void initComponents() throws Exception {
     
        // Création de la fenêtre principale
        setUndecorated(true); // Supprime tous les boutons par défaut
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("commentaires page");
        setLocationRelativeTo(null);
        setVisible(true);
        affichercommentaire();
        JLabel rateusJLabel;


        // les labels:
        if (Hotel.langue == 0) {

            commenterbtn.setText("add comment");
            rateusJLabel = new JLabel("rate us :");
        

        } else {
            rateusJLabel = new JLabel("notez nous:");
            commenterbtn.setText("commenter");

        }

        closebtn.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        // le positionement exact du boutton.
        closebtn.setBounds(997, 5, 25, 30);

        JPanel ratingJPanel = new JPanel();
        commenttxt.setLineWrap(true); // Enable line wrapping
        commenttxt.setWrapStyleWord(true); // Wrap lines at word boundarie
        commenttxt.setBounds(400, 83, 400, 50);
        commenttxt.setText("\nEntrez votre texte ici...");
        add(commenttxt);
        commenttxt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (commenttxt.getText().equals("\nEntrez votre texte ici...")) {
                    commenttxt.setText("");
                    commenttxt.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (commenttxt.getText().isEmpty()) {
                    commenttxt.setText("\nEntrez votre texte ici...");
                    commenttxt.setForeground(Color.GRAY);
                }
            }
        });

        ratingJPanel.setLayout(null);
        ratingJPanel.setBounds(3, 3, 1027, 200);
        ratingJPanel.setBorder((new RoundBorder(color, 3)));
        ratingJPanel.setBackground(colorgris);
        add(ratingJPanel);

        etoile1Box.setBounds(0, 50, 40, 20);
        etoile2Box.setBounds(40, 50, 40, 20);
        etoile3Box.setBounds(80, 50, 40, 20);
        etoile4Box.setBounds(120, 50, 40, 20);
        etoile5Box.setBounds(160, 50, 40, 20);

        etoile1Box.setBackground(colorgris);
        etoile2Box.setBackground(colorgris);
        etoile3Box.setBackground(colorgris);
        etoile4Box.setBackground(colorgris);
        etoile5Box.setBackground(colorgris);

        rateusJLabel.setBounds(0, 20, 200, 17);

        rateusJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        rateusJLabel.setForeground(color);
     
        JPanel optioJPanel = new JPanel();
        optioJPanel.setLayout(null);

        optioJPanel.add(etoile1Box);
        optioJPanel.add(etoile2Box);
        optioJPanel.add(etoile3Box);
        optioJPanel.add(etoile5Box);
        optioJPanel.add(etoile4Box);
        optioJPanel.add(rateusJLabel);
       
        optioJPanel.setBounds(10, 50, 300, 100);
        optioJPanel.setBackground(colorgris);
        ratingJPanel.add(optioJPanel);

        // Créer une JComboBox et lui fournir le tableau d'entiers comme modèle

        // Bouton pour fermer la fenêtre
        
        revenirbtn.setBounds(970, 5, 25, 30);
        revenirbtn.setBackground(Color.white);

        closebtn.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        // le positionement exact du boutton.
        closebtn.setBounds(1000, 5, 25, 30);


        
        Icon etoileBlancheIcon = new ImageIcon("For Rent21.png");
        Icon etoileJauneIcon = new ImageIcon("For Rent2.png");
        etoile1Box.setIcon(etoileBlancheIcon);
        etoile2Box.setIcon(etoileBlancheIcon);
        etoile3Box.setIcon(etoileBlancheIcon);
        etoile4Box.setIcon(etoileBlancheIcon);
        etoile5Box.setIcon(etoileBlancheIcon);
        // Initialiser les cases à cocher avec l'icône d'étoile blanche
        if (Hotel.RechercheuserParId(Hotel.id_user_current) != null) {

            if (Hotel.RechercheuserParId(Hotel.id_user_current).getNote() == 1) {
                etoile1Box.setIcon(etoileJauneIcon);
                etoile2Box.setIcon(etoileBlancheIcon);
                etoile3Box.setIcon(etoileBlancheIcon);
                etoile4Box.setIcon(etoileBlancheIcon);
                etoile5Box.setIcon(etoileBlancheIcon);
                etoile1Box.setSelected(true);
            }

            if (Hotel.RechercheuserParId(Hotel.id_user_current).getNote() == 2) {
                etoile1Box.setSelected(true);
                etoile2Box.setSelected(true);
                etoile1Box.setIcon(etoileJauneIcon);
                etoile2Box.setIcon(etoileJauneIcon);
                etoile3Box.setIcon(etoileBlancheIcon);
                etoile4Box.setIcon(etoileBlancheIcon);
                etoile5Box.setIcon(etoileBlancheIcon);
            }
            if (Hotel.RechercheuserParId(Hotel.id_user_current).getNote() == 3) {
                etoile1Box.setSelected(true);
                etoile2Box.setSelected(true);
                etoile3Box.setSelected(true);

                etoile1Box.setIcon(etoileJauneIcon);
                etoile2Box.setIcon(etoileJauneIcon);
                etoile3Box.setIcon(etoileJauneIcon);
                etoile4Box.setIcon(etoileBlancheIcon);
                etoile5Box.setIcon(etoileBlancheIcon);
            }
            if (Hotel.RechercheuserParId(Hotel.id_user_current).getNote() == 4) {
                etoile1Box.setSelected(true);
                etoile2Box.setSelected(true);
                etoile3Box.setSelected(true);
                etoile4Box.setSelected(true);
                etoile1Box.setIcon(etoileJauneIcon);
                etoile2Box.setIcon(etoileJauneIcon);
                etoile3Box.setIcon(etoileJauneIcon);
                etoile4Box.setIcon(etoileJauneIcon);
                etoile5Box.setIcon(etoileBlancheIcon);
            }

        
 if (Hotel.RechercheuserParId(Hotel.id_user_current).getNote() == 5) {
                etoile1Box.setSelected(true);
                etoile2Box.setSelected(true);
                etoile3Box.setSelected(true);
                etoile4Box.setSelected(true);
                etoile5Box.setSelected(true);

                etoile1Box.setIcon(etoileJauneIcon);
                etoile2Box.setIcon(etoileJauneIcon);
                etoile3Box.setIcon(etoileJauneIcon);
                etoile4Box.setIcon(etoileJauneIcon);
                etoile5Box.setIcon(etoileJauneIcon);
            }
        }

        // Ajouter un écouteur d'événements à chaque case à cocher
        etoile1Box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (etoile1Box.isSelected()) {
                    etoile1Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    note=1;
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");
                } else {

                    etoile2Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile4Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile3Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile5Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile1Box.setSelected(true);
                    etoile2Box.setSelected(false);
                    etoile4Box.setSelected(false);
                    etoile3Box.setSelected(false);
                    etoile5Box.setSelected(false);
                    note=1;
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");

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
                    note=2;
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");
                } else {

                    etoile2Box.setSelected(true);
                    etoile4Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile4Box.setSelected(false);
                    etoile3Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile3Box.setSelected(false); // Changer l'icône en étoile jaune
                    etoile5Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile5Box.setSelected(false);
                    note=2;
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");
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
                    note=3;
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");
                } else {

                    etoile3Box.setSelected(true);
                    etoile4Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile4Box.setSelected(false);// Changer l'icône en étoile jaune
                    etoile5Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    note=3;
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");
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
                    note=4;
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");
                } else {

                    etoile4Box.setSelected(true);
                    etoile5Box.setIcon(etoileBlancheIcon); // Changer l'icône en étoile jaune
                    etoile5Box.setSelected(false);
                    note=4;
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");
                }
            }
        });
        etoile5Box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (etoile5Box.isSelected()) {
                    etoile5Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile4Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile4Box.setSelected(true);// Changer l'icône en étoile jaun
                    etoile3Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile3Box.setSelected(true); // Changer l'icône en étoile jaune
                    etoile1Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile1Box.setSelected(true);
                    etoile2Box.setIcon(etoileJauneIcon); // Changer l'icône en étoile jaune
                    etoile2Box.setSelected(true);
                    note=5;
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");

                } else {
                    moyenneactuelle.setText(""+String.format("%.1f", Hotel.calculermoyenne())+"/5");
                    etoile5Box.setSelected(true);
                }
            }
        });

        moyenneactuelle.setBounds(230, 53, 200, 17);
        moyenneactuelle.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        moyenneactuelle.setForeground(color);
        optioJPanel.add(moyenneactuelle);
  

        ratingJPanel.add(revenirbtn);
        ratingJPanel.add(closebtn);

        // creation d'un boutton pour le close avec ses caractéristiques.

        // Utiliser la couleur

        commenterbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                commenterbtnactionPerformed();

            }
        });



        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        commenterbtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));

        // le positionement exact du boutton.
        commenterbtn.setBounds(840, 90, 150, 30);
        commenterbtn.setBackground(color);
        commenterbtn.setForeground(colorgris);
        commenterbtn.setBorder(new RoundBorder(color, 3));
        ratingJPanel.add(commenterbtn);

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

        if (Hotel.langue == 0) {
            nameLabel = new JLabel(" User : " + comment.getUsername());
            commentLabel = new JLabel(" Comment: " + comment.getCommentaire());
            datLabel = new JLabel(" " + comment.getDate().getJour() + "/" + comment.getDate().getMois() + "/"
                    + comment.getDate().getAnnee());

        } else {
            nameLabel = new JLabel(" User: " + comment.getUsername());
            commentLabel = new JLabel(" Commentaire: " + comment.getCommentaire());
            datLabel = new JLabel(" Le: " + comment.getDate().getJour() + "/" + comment.getDate().getMois() + "/"
                    + comment.getDate().getAnnee());

        }

        nameLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        nameLabel.setForeground(Color.decode("#4A5471"));
        commentLabel.setForeground(colorgris);
        commentLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));

        datLabel.setForeground(Color.decode("#4A5471"));
        datLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 1)); // Utilisation d'un GridLayout pour empiler verticalement les
                                                   // éléments
        infoPanel.add(nameLabel);
        

        infoPanel.add(commentLabel);
        infoPanel.add(datLabel);

        infoPanel.setBackground(Color.white);
        panel.setBackground(Color.white);

        panel.add(infoPanel, BorderLayout.NORTH); // Ajout du panneau d'informations au centre

        Border border = new RoundBorder(colorgris, 2); // Utilisation du code RGB pour la couleur marron

        panel.setBorder(border);
        // Définir une taille préférée pour le JPanel
        panel.setPreferredSize(new Dimension(182, 700));

        return panel;
    }

    public void commenterbtnactionPerformed(){
        Iterator<Map.Entry<Integer, Commentaires>> iterator = Hotel.getCommentairesMap().entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Commentaires> entry = iterator.next();
            Commentaires commentaire = entry.getValue();

            JPanel commentairePanel = createPanel(commentaire);
            commentairePanel.setPreferredSize(new Dimension(170, 70));
            if (commentaire.getIduser() == Hotel.id_user_current) {
                commentContainerJPanel.add(commentairePanel, 0);
            } else {
                commentContainerJPanel.add(commentairePanel);

            }
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new Commentaires_Interface().setVisible(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    void affichercommentaire() throws Exception {
      
        Iterator<Map.Entry<Integer, Commentaires>> iterator = Hotel.getCommentairesMap().entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Commentaires> entry = iterator.next();
            Commentaires commentaires = entry.getValue();

            JPanel commentairePanel = createPanel(commentaires);
            commentairePanel.setPreferredSize(new Dimension(170, 70));
            if (commentaires.getIduser() == Hotel.id_user_current) {
                commentContainerJPanel.add(commentairePanel, 0);
            } else {
                commentContainerJPanel.add(commentairePanel);

            }
        }
        

        commentContainerJPanel.setBackground(colorgris);
        scrollPane = new BlackScrollPane(commentContainerJPanel);
        scrollPane.setBackground(colorgris);
        scrollPane.setPreferredSize(new Dimension(936, 588));
        scrollPane.setBounds(0, 210, 1033, 400);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().repaint();

    }

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.Border;

class BlackScrollPane extends JScrollPane {
    public BlackScrollPane(Component view) {
        super(view);
        setOpaque(false);
    }
}

public class ReservationAvecDetail extends javax.swing.JFrame {
    JTextField datedebuTextField = new JTextField("5/5/2024");
    JTextField datefinTextField = new JTextField("11/5/2024");
    JCheckBox tvcCheckBox = new JCheckBox();
    JCheckBox climatisationBox = new JCheckBox();
    JCheckBox vuesurmerBox = new JCheckBox();
    JCheckBox vuesurforetBox = new JCheckBox();
    javax.swing.JComboBox<String> roomtypebox = new JComboBox<>();
    JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0));
    BlackScrollPane scrollPane;
    Color color = Color.decode("#E0C878");
    Color colorgris = Color.decode("#252926");
    JLabel prixJLabel = new JLabel("prix:");
       
     javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();

    public ReservationAvecDetail() throws deja_presente_bdd {
        initComponents();
    }

    private void initComponents() throws deja_presente_bdd {


        TypeChambre.initialiser(100, 1, 150, 2, 200, 3, 350, 4);
        OptionSupplementaire.initialiser(15, 5, 10, 10);
         Chambre chambre1;

         for (int i = 0; i < 100; i++) {
             chambre1 = new Chambre(i, TypeChambre.SOLO, false, true, true, false);
             Hotel.AjouterChambreMap(chambre1);
             chambre1 = new Chambre( i+100, TypeChambre.DOUBLE, false, true, true, true);
             
             Hotel.AjouterChambreMap(chambre1);
             chambre1 = new Chambre( i+300, TypeChambre.SUITE, true, false, false, true);
             
             Hotel.AjouterChambreMap(chambre1);
             chambre1 = new Chambre(  i+200, TypeChambre.TRIPLE, true, true, true, true);
             
             Hotel.AjouterChambreMap(chambre1);
         }

         //hedy pour le test brk ne7iha apres mlzmch nnssaaaaaaaaaaaaaa////////
        // Création de la fenêtre principale
        setUndecorated(true); // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("signin page");
        setLocationRelativeTo(null);
        setVisible(true);
        // les labels:

        JLabel datedebutJLabel = new JLabel("date debut");
        JLabel datefinJLabel = new JLabel("date fin");
        JLabel tvJLabel = new JLabel("tv :");
        JLabel vuesurmerJLabel = new JLabel("climatisation :");
        JLabel climatisationJLabel = new JLabel("vue sur mer :");
        JLabel vuesurforetJLabel = new JLabel("vue sur foret :");
       

        JPanel informationReservationPanel = new JPanel();

        informationReservationPanel.setLayout(null);
        informationReservationPanel.setBounds(3, 3, 1027, 200);
        informationReservationPanel.setBorder((new RoundBorder(color, 3)));
        informationReservationPanel.setBackground(colorgris);
        add(informationReservationPanel);

        informationReservationPanel.add(datedebutJLabel);
        informationReservationPanel.add(datefinJLabel);
        informationReservationPanel.add(datefinTextField);
        informationReservationPanel.add(datedebuTextField);
        informationReservationPanel.add(tvJLabel);
        informationReservationPanel.add(tvcCheckBox);
        informationReservationPanel.add(climatisationBox);
        informationReservationPanel.add(climatisationJLabel);
        informationReservationPanel.add(vuesurforetJLabel);
        informationReservationPanel.add(vuesurmerJLabel);
        informationReservationPanel.add(vuesurmerBox);
        informationReservationPanel.add(vuesurforetBox);
        informationReservationPanel.add(prixJLabel);

        datedebuTextField.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        datedebutJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        datefinJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        datefinTextField.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        tvJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        climatisationJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        vuesurforetJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        vuesurmerJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));

        datedebuTextField.setForeground(new Color(colorgris.getRed(), colorgris.getGreen(), colorgris.getBlue() + 100));
        datedebutJLabel.setForeground(color);
        datefinJLabel.setForeground(color);
        datedebuTextField.setForeground(color);
        tvJLabel.setForeground(color);
        climatisationJLabel.setForeground(color);
        vuesurforetJLabel.setForeground(color);
        vuesurmerJLabel.setForeground(color);

        datedebuTextField.setBackground(colorgris);
        datedebuTextField.setForeground(color);
        datedebuTextField.setBorder(new RoundBorder(color, 3));
        datefinTextField.setBackground(colorgris);
        datefinTextField.setForeground(color);
        datefinTextField.setBorder(new RoundBorder(color, 3));

        prixJLabel.setBackground(color);
        prixJLabel.setForeground(color);

        prixJLabel.setBorder(new RoundBorder(color, 3));

        datedebutJLabel.setBounds(220, 0, 150, 50);
        datedebuTextField.setBounds(340, 10, 150, 30);
        datefinJLabel.setBounds(560, 0, 150, 50);
        datefinTextField.setBounds(650, 10, 150, 30);

        tvJLabel.setBounds(100, 60, 40, 20);
        tvcCheckBox.setBounds(150, 60, 40, 20);
        climatisationJLabel.setBounds(250, 60, 200, 20);
        climatisationBox.setBounds(400, 60, 40, 20);
        vuesurforetJLabel.setBounds(500, 60, 200, 20);
        vuesurforetBox.setBounds(650, 60, 40, 20);
        vuesurmerJLabel.setBounds(750, 60, 200, 20);
        vuesurmerBox.setBounds(900, 60, 40, 20);
        prixJLabel.setBounds(840, 150, 150, 30);
        prixJLabel.setBackground(color);

        tvcCheckBox.setBackground(colorgris);
        climatisationBox.setBackground(colorgris);
        vuesurforetBox.setBackground(colorgris);
        vuesurmerBox.setBackground(colorgris);

        roomtypebox
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));
        roomtypebox.setBounds(650, 100, 150, 30);
        roomtypebox.setForeground(color);
        roomtypebox.setBackground(colorgris);
        roomtypebox.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(roomtypebox);

        afficherchambre();

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

        JButton filtrer = new JButton();
        // creation d'un boutton pour le a propos de nous avec ses caractéristiques.
        filtrer.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        filtrer.setText("Filtrer");
        filtrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    filtrerbtnActionPerformed();
                } catch (Date_nonorganiser | DiffSup365 e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (deja_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        // le positionement exact du boutton.
        filtrer.setBounds(840, 100, 150, 30);
        filtrer.setBackground(color);
        filtrer.setForeground(colorgris);
        filtrer.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(filtrer);

        System.setProperty("sun.java2d.uiScale.enabled", "false");
        backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png")); // NOI18N
        // le positionement exact du background.
        backgroundlabel.setBounds(0, 0, 1032, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);
    }

    public JPanel createPanel(Chambre chambre) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Utilisation d'un BorderLayout

        JLabel nameLabel = new JLabel("IDChambre: " + chambre.getId());
        nameLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        nameLabel.setForeground(color);
        JLabel bedsLabel = new JLabel("Nombre de lits: " + chambre.getNbLit());
        bedsLabel.setForeground(color);
        bedsLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        JLabel priceLabel = new JLabel("Prix: " + chambre.getPrix());
        priceLabel.setForeground(color);
        priceLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        JLabel optionlLabel = new JLabel("Options: ");
        optionlLabel.setForeground(color);
        optionlLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS)); // Utilisation d'un BoxLayout vertical
                                                                               // pour les options

        JLabel tvLabel = new JLabel("                     tv ");
        if (chambre.isTv()) {
            tvLabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                // colorie en vert
        }else{
            tvLabel.setForeground(Color.white); 
        }
        optionsPanel.add(tvLabel);

        JLabel climatiJLabel = new JLabel("             Climatisation");
        if (chambre.isClimatisation()) {
            climatiJLabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                      // colorie en vert
        }else{
            climatiJLabel.setForeground(Color.white); 
        }
        optionsPanel.add(climatiJLabel);

        JLabel vuemerJLabel = new JLabel("           Vue sur la mere");
        if (chambre.isVuesurmere()) {
            vuemerJLabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                     // colorie en vert
        }else{
            vuemerJLabel.setForeground(Color.white); 
        }
        optionsPanel.add(vuemerJLabel);

        JLabel vueforetJLabel = new JLabel("           Vue sur la foret");
        if (chambre.isVuesurforet()) {
            vueforetJLabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                       // colorie en vert
        }else{
            vueforetJLabel.setForeground(Color.white); 
        }
        optionsPanel.add(vueforetJLabel);
        vueforetJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        vuemerJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        climatiJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        tvLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        // Ajout du bouton "Réserver"
        JButton reserveButton = new JButton("reserver cette chambre");
        reserveButton.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        reserveButton.addActionListener(e -> {
            // Action à effectuer lors du clic sur le bouton Réserver
            JOptionPane.showMessageDialog(panel, "Chambre " + chambre.getId() + " réservée !");
        });

        // Ajout des composants au JPanel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 1)); // Utilisation d'un GridLayout pour empiler verticalement les
                                                   // éléments
        infoPanel.add(nameLabel);
     
        infoPanel.add(bedsLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(optionlLabel);
        reserveButton.setBackground(color);
        reserveButton.setForeground(colorgris);
        infoPanel.setBackground(colorgris);
        optionsPanel.setBackground(colorgris);
        panel.setBackground(colorgris);

        panel.add(infoPanel, BorderLayout.NORTH); // Ajout du panneau d'informations au centre
        panel.add(optionsPanel, BorderLayout.CENTER); // Ajout du panneau des options en haut
        panel.add(reserveButton, BorderLayout.SOUTH); // Ajout du bouton Réserver en bas
        Border border = new RoundBorder(color, 2); // Utilisation du code RGB pour la couleur marron

        reserveButton.setBorder(border);
        panel.setBorder(border);
        // Définir une taille préférée pour le JPanel
        panel.setPreferredSize(new Dimension(182, 170));

        return panel;
    }

    private JFrame frame;

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "DO YOU REALY WANT TO CLOSE THIS WINDOW?", "MySQL Connector",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }

    private void filtrerbtnActionPerformed() throws Date_nonorganiser, DiffSup365, deja_presente_bdd {

        try {

            Date today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
            Date date_debut = Date.Recupere_date(datedebuTextField.getText());
            Date date_fin = Date.Recupere_date(datefinTextField.getText());
            Date.verif_today_date(today, date_debut);
            TypeChambre typeChambre = TypeChambre.ToTypeChambre((String) roomtypebox.getSelectedItem());
            boolean tv = tvcCheckBox.isSelected();
            boolean climatisation = climatisationBox.isSelected();
            boolean vuesurmer = vuesurmerBox.isSelected();
            boolean vueforet = vuesurforetBox.isSelected();
            TypeChambre.initialiser(100, 1, 150, 2, 200, 3, 350, 4);
       
            JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0)); // 5 chambres par ligne
            Chambre chambrerecherchee=new Chambre(0,typeChambre, tv, climatisation,vuesurmer,vueforet);
            prixJLabel.setText("prix : "+chambrerecherchee.calculeprixchambre());
        
            Iterator<Map.Entry<Integer, Chambre>> iterator = Hotel.getChambreMap().entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<Integer, Chambre> entry = iterator.next();
                Chambre chambre = entry.getValue();
                if (Hotel.chambreAafficher(chambre, typeChambre, date_debut, date_fin, tv, climatisation, vueforet,
                        vuesurmer)) {
                    chambreContainer.add(createPanel(chambre));
                }
            }
            chambreContainer.setBackground(colorgris);
            scrollPane.setBackground(colorgris);
            JViewport viewport = scrollPane.getViewport();

            // Supprimer les composants du viewport
            viewport.removeAll();
            viewport.add(chambreContainer);
            getContentPane().add(backgroundlabel);
            
            System.setProperty("sun.java2d.uiScale.enabled", "false");
            backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png")); // NOI18N
            backgroundlabel.setBounds(0, 0, 1032, 580);
            getContentPane().add(backgroundlabel);
    
            // le positionement exact du background.
            // Ajouter les nouveaux composants (chambres filtrées) au viewport
         

            // Repaint pour mettre à jour l'affichage
            getContentPane().revalidate();
            getContentPane().repaint();
        } catch (Date_syntaxe e) {
            JOptionPane.showMessageDialog(frame,
                    "entrer des chiffres dans les dates !",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame,
                    "entrer des chiffres dans les dates !",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Date_nonvalid e) {

            JOptionPane.showMessageDialog(frame,
                    e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Date_Debut_Reservation e) {
            JOptionPane.showMessageDialog(frame,
                    e.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    void afficherchambre() throws deja_presente_bdd {
  

        Iterator<Map.Entry<Integer, Chambre>> iterator = Hotel.getChambreMap().entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Chambre> entry = iterator.next();
            Chambre chambre = entry.getValue();
            chambreContainer.add(createPanel(chambre));

        }
        
        chambreContainer.setBackground(colorgris);
        scrollPane = new BlackScrollPane(chambreContainer);
        scrollPane.setBackground(colorgris);
        
        scrollPane.setPreferredSize(new Dimension(936, 588)); // Taille fixe du JScrollPane
        scrollPane.setBounds(0, 210, 1033, 400);

        // Supprimer le contenu existant du JFrame principal

        // Ajouter le JScrollPane au JFrame principal
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Repaint pour mettre à jour l'affichage
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   
                    new ReservationAvecDetail().setVisible(true);
                } catch (deja_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

}

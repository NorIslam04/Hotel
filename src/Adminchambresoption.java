import java.awt.*;

import java.util.Iterator;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.Border;



class BlackScrollPane extends JScrollPane {
    public BlackScrollPane(Component view) {
        super(view);
        setOpaque(false);
    }
}
public class Adminchambresoption extends javax.swing.JFrame{
    JCheckBox sonaCheckBox = new JCheckBox();
    JCheckBox terasseCheckBox = new JCheckBox();
    JCheckBox vuesurmerBox = new JCheckBox();
    JCheckBox vuesurforetBox = new JCheckBox();
  
    javax.swing.JComboBox<String> roomtypebox = new JComboBox<>();


    JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0));
    BlackScrollPane scrollPane;
    Color color = Color.decode("#E0C878");
    Color colorgris = Color.decode("#252926");
    

    javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();

    public Adminchambresoption() throws deja_presente_bdd {
        initComponents();
    }
    

    private void initComponents() throws deja_presente_bdd {
        
        TypeChambre.initialiser(100, 1, 150, 2,200, 3, 350, 4);
        OptionSupplementaire.initialiser(15, 5, 10, 10);
        Chambre chambre1;
        double prix =-1;//hna 3la jal constricteure
        for (int i = 0; i < 100; i++) {
            chambre1 = new Chambre(i, TypeChambre.SOLO,prix, false, true, true, false);
            Hotel.AjouterChambreMap(chambre1);
            chambre1 = new Chambre(i + 100, TypeChambre.DOUBLE,prix, false, true, true, true);

            Hotel.AjouterChambreMap(chambre1);
            chambre1 = new Chambre(i + 300, TypeChambre.SUITE,prix, true, false, false, true);

            Hotel.AjouterChambreMap(chambre1);
            chambre1 = new Chambre(i + 200, TypeChambre.TRIPLE,prix, true, true, true, true);

            Hotel.AjouterChambreMap(chambre1);
        }
        
        // hedy pour le test brk ne7iha apres mlzmch nnssaaaaaaaaaaaaaa////////
        // Création de la fenêtre principale
        setUndecorated(true); // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("adminchambre page");
        setLocationRelativeTo(null);
        setVisible(true);
    
        JLabel sonaJlabel;
        JLabel vuesurmerJLabel;
        JLabel TerasseJlabel;
        JLabel vuesurforetJLabel;
        JLabel choisistypeJLabel;
        JLabel choisisoptionsJLabel;

        JButton filtrer = new JButton();
        JButton ajouterchambre = new JButton();
        // les labels:
        if (Hotel.langue == 0) {
         
            sonaJlabel = new JLabel("Sona :");
            vuesurmerJLabel = new JLabel("Sea View :");
            TerasseJlabel = new JLabel("Terasse :");
            vuesurforetJLabel = new JLabel("Forest View :");
            filtrer.setText("Filter");
            ajouterchambre.setText("add this room");
  
            choisisoptionsJLabel = new JLabel("Choose Options :");
            choisistypeJLabel = new JLabel("Choose Type :");
          
        } else {
       
            sonaJlabel = new JLabel("Sona :");
            vuesurmerJLabel = new JLabel("Terasse :");
            TerasseJlabel = new JLabel("vue sur mer :");
            vuesurforetJLabel = new JLabel("vue sur foret :");
            choisisoptionsJLabel = new JLabel("choisissez les Options :");
            choisistypeJLabel = new JLabel("choisissez le Type :");
            ajouterchambre.setText("ajouter cette chambre");
        
          

            filtrer.setText("Filtrer");
  
        }

        JPanel informationReservationPanel = new JPanel();

        informationReservationPanel.setLayout(null);
        informationReservationPanel.setBounds(3, 3, 1027, 200);
        informationReservationPanel.setBorder((new RoundBorder(color, 3)));
        informationReservationPanel.setBackground(colorgris);
        add(informationReservationPanel);



      
        sonaJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        TerasseJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        vuesurforetJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        vuesurmerJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));



        sonaJlabel.setForeground(colorgris);
        TerasseJlabel.setForeground(colorgris);
        vuesurforetJLabel.setForeground(colorgris);
        vuesurmerJLabel.setForeground(colorgris);

 

        sonaJlabel.setBounds(40, 90, 200, 20);
          sonaCheckBox.setBounds(240, 90, 40, 20);
        TerasseJlabel.setBounds(40, 110, 200, 20);
        terasseCheckBox.setBounds(240, 110, 40, 20);
        vuesurforetJLabel.setBounds(40, 130, 200, 20);
        vuesurforetBox.setBounds(240, 130, 40, 20);
        vuesurmerJLabel.setBounds(40, 150, 200, 20);
        vuesurmerBox.setBounds(240, 150, 40, 20);
        choisistypeJLabel.setBounds(20, 20, 200, 17);
        choisisoptionsJLabel.setBounds(20, 60, 200, 17);
        roomtypebox.setBounds(200, 14, 150, 30);

        choisistypeJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        choisisoptionsJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        choisisoptionsJLabel.setForeground(colorgris);
        choisistypeJLabel.setForeground(colorgris);

        JPanel optioJPanel = new JPanel();
        optioJPanel.setLayout(null);
        optioJPanel.add(sonaJlabel);
        optioJPanel.add(  sonaCheckBox);
        optioJPanel.add(terasseCheckBox);
        optioJPanel.add(TerasseJlabel);
        optioJPanel.add(vuesurforetJLabel);
        optioJPanel.add(vuesurmerJLabel);
        optioJPanel.add(vuesurmerBox);
        optioJPanel.add(vuesurforetBox);
        optioJPanel.add(choisisoptionsJLabel);
        optioJPanel.add(choisistypeJLabel);
        optioJPanel.add(roomtypebox);
        optioJPanel.setBounds(326, 10, 380, 180);
        optioJPanel.setBackground(color);
        informationReservationPanel.add(optioJPanel);

          sonaCheckBox.setBackground(color);
        terasseCheckBox.setBackground(color);
        vuesurforetBox.setBackground(color);
        vuesurmerBox.setBackground(color);

        roomtypebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));

        roomtypebox.setForeground(color);
        roomtypebox.setBackground(colorgris);
        roomtypebox.setBorder(new RoundBorder(color, 3));


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
        optioJPanel.add(roomtypebox);
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
        filtrer.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));

        filtrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                filtrerbtnActionPerformed();

            }
        });
        ajouterchambre.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));

        ajouterchambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //TODO
            }
        });
        ajouterchambre.setBounds(850, 100, 150, 30);
        ajouterchambre.setBackground(color);
        ajouterchambre.setForeground(colorgris);
        ajouterchambre.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(ajouterchambre);
        // le positionement exact du boutton.
        filtrer.setBounds(850, 150, 150, 30);
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
        JLabel nameLabel;
        JLabel bedsLabel;
        JLabel priceLabel;
        JLabel optionlLabel;
        panel.setLayout(new BorderLayout()); // Utilisation d'un BorderLayout
        JLabel SonaJlabel;
        JLabel TerasseJlabel;
        JLabel vuemerJLabel;
        JLabel vueforetJLabel;
        JButton reserveButton;
        JButton supprimerChambreButton;
        if (Hotel.langue == 0) {
            nameLabel = new JLabel("RoomID: " + chambre.getId());
            bedsLabel = new JLabel("beds number: " + chambre.getNbLit());
            priceLabel = new JLabel("price: " + chambre.getPrix());
            optionlLabel = new JLabel("Options: ");
            SonaJlabel = new JLabel("                   Sona ");
            TerasseJlabel = new JLabel("                  terasse");
            vuemerJLabel = new JLabel("                 Sea View");
            vueforetJLabel = new JLabel("               Forest View");
        
            reserveButton = new JButton("Modifier this room");
            supprimerChambreButton=new JButton("Delete this room");
        } else {
            nameLabel = new JLabel("IDChambre: " + chambre.getId());
            bedsLabel = new JLabel("Nombre de lits: " + chambre.getNbLit());
            priceLabel = new JLabel("Prix: " + chambre.getPrix());
            optionlLabel = new JLabel("Options: ");
            SonaJlabel = new JLabel("                   Sona ");
            TerasseJlabel = new JLabel("                  terasse");
            vuemerJLabel = new JLabel("           Vue sur la mere");
            vueforetJLabel = new JLabel("           Vue sur la foret");
            reserveButton = new JButton("modifier cette chambre");
            supprimerChambreButton=new JButton("supprimer cette chambre");
        }

        nameLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        nameLabel.setForeground(colorgris);
        bedsLabel.setForeground(colorgris);
        bedsLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        priceLabel.setForeground(colorgris);
        priceLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        optionlLabel.setForeground(colorgris);
        optionlLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS)); // Utilisation d'un BoxLayout vertical
                                                                               // pour les options

        if (chambre.isSONA()) {
            SonaJlabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                // colorie en vert
        } else {
            SonaJlabel.setForeground(colorgris);
        }
        optionsPanel.add(SonaJlabel);

        if (chambre.isTERASSE()) {
            TerasseJlabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                      // colorie en vert
        } else {
            TerasseJlabel.setForeground(colorgris);
        }
        optionsPanel.add(TerasseJlabel);

        if (chambre.isVuesurmere()) {
            vuemerJLabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                     // colorie en vert
        } else {
            vuemerJLabel.setForeground(colorgris);
        }
        optionsPanel.add(vuemerJLabel);

        if (chambre.isVuesurforet()) {
            vueforetJLabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                       // colorie en vert
        } else {
            vueforetJLabel.setForeground(colorgris);
        }
        optionsPanel.add(vueforetJLabel);
        vueforetJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        vuemerJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        TerasseJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        SonaJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        // Ajout du bouton "Réserver"

        reserveButton.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        supprimerChambreButton.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

     
        reserveButton.addActionListener(e -> {
      
            //TODO ici il doit verifier que la chambre n est pas reservee

        });
        
     
        supprimerChambreButton.addActionListener(e -> {
   
             //TODO ici il doit verifier que la chambre n est pas deja reservee

        });

        // Ajout des composants au JPanel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 1)); // Utilisation d'un GridLayout pour empiler verticalement les
                                                   // éléments
        infoPanel.add(nameLabel);

        infoPanel.add(bedsLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(optionlLabel);
        reserveButton.setBackground(colorgris);
        reserveButton.setForeground(color);
        supprimerChambreButton.setBackground(colorgris);
        supprimerChambreButton.setForeground(color);
        infoPanel.setBackground(Color.white);
        optionsPanel.setBackground(Color.white);
        panel.setBackground(Color.white);
        JPanel modsupPanel=new JPanel();
        modsupPanel.setLayout(new GridLayout(0,1));
        modsupPanel.add(supprimerChambreButton);
        modsupPanel.add(reserveButton);

        panel.add(infoPanel, BorderLayout.NORTH); // Ajout du panneau d'informations au centre
        panel.add(optionsPanel, BorderLayout.CENTER); // Ajout du panneau des options en haut
        panel.add(modsupPanel, BorderLayout.SOUTH); // Ajout du bouton Réserver en bas
      
        Border border = new RoundBorder(colorgris, 2); // Utilisation du code RGB pour la couleur marron

        reserveButton.setBorder(border);
        supprimerChambreButton.setBorder(border);
        panel.setBorder(border);
        // Définir une taille préférée pour le JPanel
        panel.setPreferredSize(new Dimension(182, 200));

        return panel;
    }

    
    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void filtrerbtnActionPerformed() {
   
            TypeChambre typeChambre = TypeChambre.ToTypeChambre((String) roomtypebox.getSelectedItem());
            boolean Sona =   sonaCheckBox.isSelected();
            boolean climatisation = terasseCheckBox.isSelected();
            boolean vuesurmer = vuesurmerBox.isSelected();
            boolean vueforet = vuesurforetBox.isSelected();
          
            TypeChambre.initialiser(100, 1, 150, 2, 200, 3, 350, 4);

            JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0)); // 5 chambres par ligne
            Chambre chambrerecherchee = new Chambre(0, typeChambre,-1, Sona, climatisation, vuesurmer, vueforet);
          

            Iterator<Map.Entry<Integer, Chambre>> iterator = Hotel.getChambreMap().entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<Integer, Chambre> entry = iterator.next();
                Chambre chambre = entry.getValue();
                if (Hotel.verifchambreavecoption(chambre, typeChambre, Sona, climatisation, vuesurmer, vuesurmer)) {
                    chambreContainer.add(createPanel(chambre));
                    System.out.println("hi");
                }
            }
            chambreContainer.setBackground(colorgris);
            scrollPane.setBackground(colorgris);
            JViewport viewport = scrollPane.getViewport();

            
            viewport.removeAll();
            viewport.add(chambreContainer);
            getContentPane().add(backgroundlabel);

            System.setProperty("sun.java2d.uiScale.enabled", "false");
            backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png")); // NOI18N
            backgroundlabel.setBounds(0, 0, 1032, 580);
            getContentPane().add(backgroundlabel);

            getContentPane().revalidate();
            getContentPane().repaint();
        

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

    private void changerlangue() {
        if (roomtypebox.getSelectedItem() == "English") {
            Hotel.langue = 0;

        } else {
            Hotel.langue = 1;
        }
        System.out.println(Hotel.langue);
    }

    public static void main(String args[]) {
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new Adminchambresoption().setVisible(true);
                } catch (deja_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}

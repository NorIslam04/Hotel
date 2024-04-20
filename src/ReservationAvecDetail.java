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
import javax.swing.JViewport;
import javax.swing.border.Border;

class BlackScrollPane extends JScrollPane {
    public BlackScrollPane(Component view) {
        super(view);
        setOpaque(false);
    }
}

public class ReservationAvecDetail extends javax.swing.JFrame {

    JCheckBox tvcCheckBox = new JCheckBox();
    JCheckBox climatisationBox = new JCheckBox();
    JCheckBox vuesurmerBox = new JCheckBox();
    JCheckBox vuesurforetBox = new JCheckBox();
    javax.swing.JComboBox<String> roomtypebox = new JComboBox<>();

    javax.swing.JComboBox<Integer> jourdebutBox = new JComboBox<>();
    javax.swing.JComboBox<Integer> moisdebutBox = new JComboBox<>();
    javax.swing.JComboBox<Integer> anneedebutBox = new JComboBox<>();

    javax.swing.JComboBox<Integer> jourfinBox = new JComboBox<>();
    javax.swing.JComboBox<Integer> moisfinBox = new JComboBox<>();
    javax.swing.JComboBox<Integer> anneefinBox = new JComboBox<>();

    JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0));
    BlackScrollPane scrollPane;
    Color color = Color.decode("#E0C878");
    Color colorgris = Color.decode("#252926");
    JLabel prixJLabel;

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
            chambre1 = new Chambre(i + 100, TypeChambre.DOUBLE, false, true, true, true);

            Hotel.AjouterChambreMap(chambre1);
            chambre1 = new Chambre(i + 300, TypeChambre.SUITE, true, false, false, true);

            Hotel.AjouterChambreMap(chambre1);
            chambre1 = new Chambre(i + 200, TypeChambre.TRIPLE, true, true, true, true);

            Hotel.AjouterChambreMap(chambre1);
        }

        // hedy pour le test brk ne7iha apres mlzmch nnssaaaaaaaaaaaaaa////////
        // Création de la fenêtre principale
        setUndecorated(true); // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ReservationaAvecDetails page");
        setLocationRelativeTo(null);
        setVisible(true);
        JLabel datedebutJLabel;
        JLabel datefinJLabel;
        JLabel tvJLabel;
        JLabel vuesurmerJLabel;
        JLabel climatisationJLabel;
        JLabel vuesurforetJLabel;
        JLabel choisisdateJLabel;
        JLabel choisistypeJLabel;
        JLabel choisisoptionsJLabel;

        JButton filtrer = new JButton();
        // les labels:
        if (Hotel.langue == 0) {
            datedebutJLabel = new JLabel("Starting Date");
            datefinJLabel = new JLabel("Ending Date");
            tvJLabel = new JLabel("TV :");
            vuesurmerJLabel = new JLabel("Sea View :");
            climatisationJLabel = new JLabel("Air Conditioning :");
            vuesurforetJLabel = new JLabel("Forest View :");
            filtrer.setText("Filter");
            choisisdateJLabel = new JLabel("Choose your reservation date :");
            choisisoptionsJLabel = new JLabel("Choose Options :");
            choisistypeJLabel = new JLabel("Choose Type :");
            prixJLabel = new JLabel("price:");
            datefinJLabel.setBounds(0, 0, 150, 50);
        } else {
            datedebutJLabel = new JLabel("date debut");
            datefinJLabel = new JLabel("date fin");
            tvJLabel = new JLabel("tv :");
            vuesurmerJLabel = new JLabel("climatisation :");
            climatisationJLabel = new JLabel("vue sur mer :");
            vuesurforetJLabel = new JLabel("vue sur foret :");
            choisisoptionsJLabel = new JLabel("choisissez les Options :");
            choisistypeJLabel = new JLabel("choisissez le Type :");
            choisisdateJLabel = new JLabel("choisissez votre date de reservation :");
            prixJLabel = new JLabel("prix:");

            filtrer.setText("Filtrer");
            datefinJLabel.setBounds(0, 0, 150, 50);
        }

        JPanel informationReservationPanel = new JPanel();

        informationReservationPanel.setLayout(null);
        informationReservationPanel.setBounds(3, 3, 1027, 200);
        informationReservationPanel.setBorder((new RoundBorder(color, 3)));
        informationReservationPanel.setBackground(colorgris);
        add(informationReservationPanel);

        informationReservationPanel.add(prixJLabel);

        datedebutJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        datefinJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        tvJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        climatisationJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        vuesurforetJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        vuesurmerJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));

        datedebutJLabel.setForeground(colorgris);
        datefinJLabel.setForeground(colorgris);

        tvJLabel.setForeground(colorgris);
        climatisationJLabel.setForeground(colorgris);
        vuesurforetJLabel.setForeground(colorgris);
        vuesurmerJLabel.setForeground(colorgris);

        prixJLabel.setBackground(color);
        prixJLabel.setForeground(color);

        prixJLabel.setBorder(new RoundBorder(color, 3));

        tvJLabel.setBounds(40, 90, 40, 20);
        tvcCheckBox.setBounds(240, 90, 40, 20);
        climatisationJLabel.setBounds(40, 110, 200, 20);
        climatisationBox.setBounds(240, 110, 40, 20);
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
        optioJPanel.add(tvJLabel);
        optioJPanel.add(tvcCheckBox);
        optioJPanel.add(climatisationBox);
        optioJPanel.add(climatisationJLabel);
        optioJPanel.add(vuesurforetJLabel);
        optioJPanel.add(vuesurmerJLabel);
        optioJPanel.add(vuesurmerBox);
        optioJPanel.add(vuesurforetBox);
        optioJPanel.add(choisisoptionsJLabel);
        optioJPanel.add(choisistypeJLabel);
        optioJPanel.add(roomtypebox);
        optioJPanel.setBounds(400, 10, 380, 180);
        optioJPanel.setBackground(color);
        informationReservationPanel.add(optioJPanel);

        prixJLabel.setBounds(840, 150, 150, 30);
        prixJLabel.setBackground(color);

        tvcCheckBox.setBackground(color);
        climatisationBox.setBackground(color);
        vuesurforetBox.setBackground(color);
        vuesurmerBox.setBackground(color);

        roomtypebox
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));

        roomtypebox.setForeground(color);
        roomtypebox.setBackground(colorgris);
        roomtypebox.setBorder(new RoundBorder(color, 3));

        Integer[] jours = new Integer[30];
        for (int i = 1; i <= 30; i++) {
            jours[i - 1] = i;
        }
        Integer[] mois = new Integer[12];
        for (int i = 1; i <= 12; i++) {
            mois[i - 1] = i;
        }
        Integer[] annee = new Integer[5];
        for (int i = 0; i <= 4; i++) {
            annee[i] = i + 2024;
        }

        // Créer une JComboBox et lui fournir le tableau d'entiers comme modèle
        jourdebutBox = new JComboBox<>(jours);
        jourfinBox = new JComboBox<>(jours);
        moisdebutBox = new JComboBox<>(mois);
        moisfinBox = new JComboBox<>(mois);
        anneedebutBox = new JComboBox<>(annee);
        anneefinBox = new JComboBox<>(annee);

        jourdebutBox.setForeground(color);
        jourdebutBox.setBackground(colorgris);
        jourdebutBox.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(jourdebutBox);

        jourfinBox.setForeground(color);
        jourfinBox.setBackground(colorgris);
        jourfinBox.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(jourfinBox);

        moisdebutBox.setForeground(color);
        moisdebutBox.setBackground(colorgris);
        moisdebutBox.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(moisdebutBox);

        moisfinBox.setForeground(color);
        moisfinBox.setBackground(colorgris);
        moisfinBox.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(moisfinBox);

        anneedebutBox.setForeground(color);
        anneedebutBox.setBackground(colorgris);
        anneedebutBox.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(anneedebutBox);
        anneefinBox.setForeground(color);
        anneefinBox.setBackground(colorgris);
        anneefinBox.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(anneefinBox);

        datedebutJLabel.setBounds(30, 30, 150, 50);
        datefinJLabel.setBounds(30, 100, 150, 30);
        jourdebutBox.setBounds(30, 70, 50, 30);
        jourfinBox.setBounds(30, 140, 50, 30);
        moisdebutBox.setBounds(120, 70, 50, 30);
        moisfinBox.setBounds(120, 140, 50, 30);
        anneedebutBox.setBounds(230, 70, 100, 30);
        anneefinBox.setBounds(230, 140, 100, 30);
        choisisdateJLabel.setBounds(20, 10, 400, 30);
        choisisdateJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        choisisdateJLabel.setForeground(colorgris);

        JPanel gestiondate = new JPanel();
        gestiondate.setLayout(null);
        gestiondate.add(datedebutJLabel);
        gestiondate.add(datefinJLabel);
        gestiondate.add(jourdebutBox);
        gestiondate.add(jourfinBox);
        gestiondate.add(moisdebutBox);
        gestiondate.add(moisfinBox);
        gestiondate.add(anneedebutBox);
        gestiondate.add(anneefinBox);
        gestiondate.setBounds(10, 10, 380, 180);
        gestiondate.setBackground(color);
        gestiondate.add(choisisdateJLabel);
        informationReservationPanel.add(gestiondate);

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
        JLabel nameLabel;
        JLabel bedsLabel;
        JLabel priceLabel;
        JLabel optionlLabel;
        panel.setLayout(new BorderLayout()); // Utilisation d'un BorderLayout
        JLabel tvLabel;
        JLabel climatiJLabel;
        JLabel vuemerJLabel;
        JLabel vueforetJLabel;
        JButton reserveButton;
        if (Hotel.langue == 0) {
            nameLabel = new JLabel("RoomID: " + chambre.getId());
            bedsLabel = new JLabel("beds number: " + chambre.getNbLit());
            priceLabel = new JLabel("price: " + chambre.getPrix());
            optionlLabel = new JLabel("Options: ");
            tvLabel = new JLabel("                      tv ");
            climatiJLabel = new JLabel("           Air Conditioning");
            vuemerJLabel = new JLabel("                 Sea View");
            vueforetJLabel = new JLabel("               Forest View");
            reserveButton = new JButton("Reserve this Room");
        } else {
            nameLabel = new JLabel("IDChambre: " + chambre.getId());
            bedsLabel = new JLabel("Nombre de lits: " + chambre.getNbLit());
            priceLabel = new JLabel("Prix: " + chambre.getPrix());
            optionlLabel = new JLabel("Options: ");
            tvLabel = new JLabel("                     tv ");
            climatiJLabel = new JLabel("             Climatisation");
            vuemerJLabel = new JLabel("           Vue sur la mere");
            vueforetJLabel = new JLabel("           Vue sur la foret");
            reserveButton = new JButton("reserver cette chambre");
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

        if (chambre.isTv()) {
            tvLabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                // colorie en vert
        } else {
            tvLabel.setForeground(colorgris);
        }
        optionsPanel.add(tvLabel);

        if (chambre.isClimatisation()) {
            climatiJLabel.setForeground(Color.GREEN); // Si la chambre contient cette option et qu'elle est fixe, on la
                                                      // colorie en vert
        } else {
            climatiJLabel.setForeground(colorgris);
        }
        optionsPanel.add(climatiJLabel);

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
        climatiJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        tvLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        // Ajout du bouton "Réserver"

        reserveButton.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        reserveButton.addActionListener(e -> {
            Date date_debut;
            try {
                date_debut = new Date((Integer) jourdebutBox.getSelectedItem(),
                        (Integer) moisdebutBox.getSelectedItem(), (Integer) anneedebutBox.getSelectedItem());
                Date date_fin = new Date((Integer) jourfinBox.getSelectedItem(), (Integer) moisfinBox.getSelectedItem(),
                        (Integer) anneefinBox.getSelectedItem());
                // Action à effectuer lors du clic sur le bouton Réserver
                // TODO Hotel.AjtReservationMap(new Reservation(WIDTH,Hotel.id_user_current, new
                // Date((Integer)jourfinBox.getSelectedItem(),(Integer)moisfinBox.getSelectedItem(),(Integer)anneefinBox.getSelectedItem()),
                // new
                // Date((Integer)jourdebutBox.getSelectedItem(),(Integer)moisdebutBox.getSelectedItem(),(Integer)anneedebutBox.getSelectedItem()),
                // TypeChambre.ToTypeChambre((String) roomtypebox.getSelectedItem()), idchambre,
                // EtatReservation.ACCEPTER));

                Reservation reservation = new Reservation(Reservation.getNb(), Hotel.id_user_current, date_fin,
                        date_debut, chambre.getType(),
                        chambre.getId(), EtatReservation.ACCEPTER);
                Hotel.AjtReservationMap(reservation);

                JOptionPane.showMessageDialog(panel, "Chambre " + chambre.getId() + " réservée avec succee !");
                new TableReseravtionUser();

            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(frame,
                        "entrer des chiffres dans les dates !",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);

            } catch (Date_nonvalid e1) {

                JOptionPane.showMessageDialog(frame,
                        e1.getMessage(),
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);

            } catch (Date_Debut_Reservation e1) {
                JOptionPane.showMessageDialog(frame,
                        e1.getMessage(),
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);

            } catch (Date_nonorganiser e1) {
                JOptionPane.showMessageDialog(frame,
                        e1.getMessage(),
                        "dates non organisee",
                        JOptionPane.ERROR_MESSAGE);

            } catch (DiffSup365 e1) {
                JOptionPane.showMessageDialog(frame,
                        "date non valide!",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);

            } catch (deja_presente_bdd e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

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
        infoPanel.setBackground(Color.white);
        optionsPanel.setBackground(Color.white);
        panel.setBackground(Color.white);

        panel.add(infoPanel, BorderLayout.NORTH); // Ajout du panneau d'informations au centre
        panel.add(optionsPanel, BorderLayout.CENTER); // Ajout du panneau des options en haut
        panel.add(reserveButton, BorderLayout.SOUTH); // Ajout du bouton Réserver en bas
        Border border = new RoundBorder(colorgris, 2); // Utilisation du code RGB pour la couleur marron

        reserveButton.setBorder(border);
        panel.setBorder(border);
        // Définir une taille préférée pour le JPanel
        panel.setPreferredSize(new Dimension(182, 200));

        return panel;
    }

    private JFrame frame;

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void filtrerbtnActionPerformed() {

        try {

            Date today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
            Date date_debut = new Date((Integer) jourdebutBox.getSelectedItem(),
                    (Integer) moisdebutBox.getSelectedItem(), (Integer) anneedebutBox.getSelectedItem());

            Date date_fin = new Date((Integer) jourfinBox.getSelectedItem(), (Integer) moisfinBox.getSelectedItem(),
                    (Integer) anneefinBox.getSelectedItem());
            Date.verif_today_date(today, date_debut);
            Date.differenceEntreDates(date_debut, date_fin);
            TypeChambre typeChambre = TypeChambre.ToTypeChambre((String) roomtypebox.getSelectedItem());
            boolean tv = tvcCheckBox.isSelected();
            boolean climatisation = climatisationBox.isSelected();
            boolean vuesurmer = vuesurmerBox.isSelected();
            boolean vueforet = vuesurforetBox.isSelected();
            TypeChambre.initialiser(100, 1, 150, 2, 200, 3, 350, 4);

            JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0)); // 5 chambres par ligne
            Chambre chambrerecherchee = new Chambre(0, typeChambre, tv, climatisation, vuesurmer, vueforet);
            prixJLabel.setText("prix : " + chambrerecherchee.calculeprixchambre());

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

        } catch (Date_nonorganiser e) {
            JOptionPane.showMessageDialog(frame,
                    e.getMessage(),
                    "dates non organisee",
                    JOptionPane.ERROR_MESSAGE);

        } catch (DiffSup365 e) {
            JOptionPane.showMessageDialog(frame,
                    "date non valide!",
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

                    new ReservationAvecDetail().setVisible(true);
                } catch (deja_presente_bdd e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

}

package View;
import Model.*;
import Control.*;
import Model.Date.*;
import java.awt.Color;
import java.awt.Font;
import Model.Chambre.*;
import javax.swing.*;


public class Tarif_Option_Chambres  extends javax.swing.JFrame {

    JCheckBox sonaCheckBox = new JCheckBox();
    JCheckBox terasseCheckBox = new JCheckBox();
    JCheckBox vuesurmerBox = new JCheckBox();
    JCheckBox vuesurforetBox = new JCheckBox();
    javax.swing.JComboBox<String> roomtypebox = new JComboBox<>();

    javax.swing.JComboBox<Integer> jourdebutBox = new JComboBox<>();
    javax.swing.JComboBox<Integer> moisdebutBox = new JComboBox<>();
    javax.swing.JComboBox<Integer> anneedebutBox = new JComboBox<>();

    javax.swing.JComboBox<Integer> jourfinBox = new JComboBox<>();
    javax.swing.JComboBox<Integer> moisfinBox = new JComboBox<>();
    javax.swing.JComboBox<Integer> anneefinBox = new JComboBox<>();

    Color color = Color.decode("#E0C878");
    Color colorgris = Color.decode("#252926");
    JLabel prixJLabel;

    javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();

    public Tarif_Option_Chambres () throws Exception {
        initComponents();
    }

    private void initComponents() throws Exception {

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

        TypeChambre.initialiser(100, 1, 150, 2, 200, 3, 350, 4);
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
        JLabel SonaJlabel;
        JLabel vuesurmerJLabel;
        JLabel TerasseJlabel;
        JLabel vuesurforetJLabel;
        JLabel choisisdateJLabel;
        JLabel choisistypeJLabel;
        JLabel choisisoptionsJLabel;

        JButton reserverbtn = new JButton();
        JButton afficherprixButton = new JButton();
        // les labels:
        if (Hotel.langue == 0) {
            datedebutJLabel = new JLabel("Starting Date");
            datefinJLabel = new JLabel("Ending Date");
            SonaJlabel = new JLabel("Sona :");
            vuesurmerJLabel = new JLabel("Sea View :");
            TerasseJlabel = new JLabel("Terasse :");
            vuesurforetJLabel = new JLabel("Forest View :");
            reserverbtn.setText("reserve");
            afficherprixButton.setText("see price");
            choisisdateJLabel = new JLabel("Choose your reservation date :");
            choisisoptionsJLabel = new JLabel("Choose Options :");
            choisistypeJLabel = new JLabel("Choose Type :");
            prixJLabel = new JLabel("price:");
            datefinJLabel.setBounds(0, 0, 150, 50);
        } else {
            datedebutJLabel = new JLabel("date debut");
            datefinJLabel = new JLabel("date fin");
            SonaJlabel = new JLabel("Sona :");
            vuesurmerJLabel = new JLabel("Terasse :");
            TerasseJlabel = new JLabel("vue sur mer :");
            vuesurforetJLabel = new JLabel("vue sur foret :");
            choisisoptionsJLabel = new JLabel("choisissez les Options :");
            choisistypeJLabel = new JLabel("choisissez le Type :");
            choisisdateJLabel = new JLabel("choisissez votre date de reservation :");
            prixJLabel = new JLabel("prix:");
            afficherprixButton.setText("voir le prix");

            reserverbtn.setText("reserver");
            datefinJLabel.setBounds(0, 0, 150, 50);
        }

        JPanel informationReservationPanel = new JPanel();

        informationReservationPanel.setLayout(null);
        informationReservationPanel.setBounds(3, 180, 1027, 200);
        informationReservationPanel.setBorder((new RoundBorder(color, 3)));
        informationReservationPanel.setBackground(colorgris);
        add(informationReservationPanel);

        informationReservationPanel.add(prixJLabel);

        datedebutJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        datefinJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        SonaJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        TerasseJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        vuesurforetJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        vuesurmerJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));

        datedebutJLabel.setForeground(colorgris);
        datefinJLabel.setForeground(colorgris);

        SonaJlabel.setForeground(colorgris);
        TerasseJlabel.setForeground(colorgris);
        vuesurforetJLabel.setForeground(colorgris);
        vuesurmerJLabel.setForeground(colorgris);

        prixJLabel.setBackground(color);
        prixJLabel.setForeground(color);

        prixJLabel.setBorder(new RoundBorder(color, 3));

        SonaJlabel.setBounds(40, 90, 200, 20);
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
        optioJPanel.add(SonaJlabel);
        optioJPanel.add(sonaCheckBox);
        optioJPanel.add(terasseCheckBox);
        optioJPanel.add(TerasseJlabel);
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

        prixJLabel.setBounds(840, 100, 150, 70);
        prixJLabel.setBackground(color);

        sonaCheckBox.setBackground(color);
        terasseCheckBox.setBackground(color);
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

        jourdebutBox.setSelectedItem(Date.getToday_jour());
        jourfinBox.setSelectedItem(Date.getToday_jour() + 1);
        moisdebutBox.setSelectedItem(Date.getToday_mois());
        moisfinBox.setSelectedItem(Date.getToday_mois());
        anneedebutBox.setSelectedItem(Date.getToday_annee());
        anneefinBox.setSelectedItem(Date.getToday_annee());

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

        optioJPanel.add(roomtypebox);
        // creation d'un boutton pour le close avec ses caractéristiques.

        // Utiliser la couleur
        javax.swing.JButton closebtn = new JButton(" ");
        closebtn.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        // le positionement exact du boutton.
        closebtn.setBounds(997, 5, 25, 30);
        add(closebtn);

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
        reserverbtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));

        reserverbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //reserverbtnbtnActionPerformed();

            }
        });
        // le positionement exact du boutton.
        reserverbtn.setBounds(840, 70, 150, 25);
        reserverbtn.setBackground(color);
        reserverbtn.setForeground(colorgris);
        reserverbtn.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(reserverbtn);

        afficherprixButton.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));

        afficherprixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                //afficherprixbtnbtnActionPerformed();

            }
        });
        // le positionement exact du boutton.
        afficherprixButton.setBounds(840, 40, 150, 25);
        afficherprixButton.setBackground(color);
        afficherprixButton.setForeground(colorgris);
        afficherprixButton.setBorder(new RoundBorder(color, 3));
        informationReservationPanel.add(afficherprixButton);
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
        System.exit(0);
    }
/* 
    private void reserverbtnbtnActionPerformed() {

        try {

            Date today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
            Date date_debut = new Date((Integer) jourdebutBox.getSelectedItem(),
                    (Integer) moisdebutBox.getSelectedItem(), (Integer) anneedebutBox.getSelectedItem());

            Date date_fin = new Date((Integer) jourfinBox.getSelectedItem(), (Integer) moisfinBox.getSelectedItem(),
                    (Integer) anneefinBox.getSelectedItem());
            Date.verif_today_date(today, date_debut);
            Date.differenceEntreDates(date_debut, date_fin);
            TypeChambre typeChambre = TypeChambre.ToTypeChambre((String) roomtypebox.getSelectedItem());
            boolean tv = sonaCheckBox.isSelected();
            boolean climatisation = terasseCheckBox.isSelected();
            boolean vuesurmer = vuesurmerBox.isSelected();
            boolean vueforet = vuesurforetBox.isSelected();

            Chambre chambrerecherchee = new Chambre(0, typeChambre, tv, climatisation, vuesurmer, vueforet);
            if (Hotel.langue == 0) {
                prixJLabel.setText("<html>price : " + chambrerecherchee.calculeprixchambre() + "$/night<br>"
                        + "total price :"
                        + chambrerecherchee.calculeprixchambre() * Date.differenceEntreDates(date_debut, date_fin)
                        + "$</html>");
            } else {
                prixJLabel.setText("<html>prix : " + chambrerecherchee.calculeprixchambre() + "$/nuitee<br>"
                        + "prix total :"
                        + chambrerecherchee.calculeprixchambre() * Date.differenceEntreDates(date_debut, date_fin)
                        + "$</html>");
            }

            Control.Action_TableReservationUser();

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

        }catch (Date_nonorganiser e) {
            JOptionPane.showMessageDialog(frame,
                    e.getMessage(),
                    "dates non organisee",
                    JOptionPane.ERROR_MESSAGE);

        } catch (DiffSup365 e) {
            JOptionPane.showMessageDialog(frame,
                    "date non valide!",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
*/
    

/* 
public void afficherprixbtnbtnActionPerformed() {
        try {

            Date today = new Date(Date.getToday_jour(), Date.getToday_mois(), Date.getToday_annee());
            Date date_debut = new Date((Integer) jourdebutBox.getSelectedItem(),
                    (Integer) moisdebutBox.getSelectedItem(), (Integer) anneedebutBox.getSelectedItem());

            Date date_fin = new Date((Integer) jourfinBox.getSelectedItem(), (Integer) moisfinBox.getSelectedItem(),
                    (Integer) anneefinBox.getSelectedItem());
            Date.verif_today_date(today, date_debut);
            Date.differenceEntreDates(date_debut, date_fin);
            TypeChambre typeChambre = TypeChambre.ToTypeChambre((String) roomtypebox.getSelectedItem());
            boolean tv = sonaCheckBox.isSelected();
            boolean climatisation = terasseCheckBox.isSelected();
            boolean vuesurmer = vuesurmerBox.isSelected();
            boolean vueforet = vuesurforetBox.isSelected();

            Chambre chambrerecherchee = new Chambre(0, typeChambre, tv, climatisation, vuesurmer, vueforet);
            if (Hotel.langue == 0) {
                prixJLabel.setText("<html>price : " + chambrerecherchee.calculeprixchambre() + "$/night<br>"
                        + "total price :"
                        + chambrerecherchee.calculeprixchambre() * Date.differenceEntreDates(date_debut, date_fin)
                        + "$</html>");
            } else {
                prixJLabel.setText("<html>prix : " + chambrerecherchee.calculeprixchambre() + "$/nuitee<br>"
                        + "prix total :"
                        + chambrerecherchee.calculeprixchambre() * Date.differenceEntreDates(date_debut, date_fin)
                        + "$</html>");
            }

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
*/
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new Tarif_Option_Chambres ().setVisible(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

}

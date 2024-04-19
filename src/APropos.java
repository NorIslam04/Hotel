import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class APropos extends javax.swing.JFrame {

    public APropos() {
        initComponents();
    }

    private void initComponents() {

        // Création de la fenêtre principale
        setUndecorated(true); // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("signin page");
        setLocationRelativeTo(null);
        setVisible(true);
        // les labels:
        javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();
        Color color = Color.decode("#E0C878");
        Color colorgris = Color.decode("#252926");

        // Panel gauche pour les informations de contact
        JPanel contactPanel = new JPanel();
        contactPanel.setLayout(null);
        contactPanel.setBounds(120, 350, 380, 200);
        contactPanel.setBackground(colorgris);
        add(contactPanel);

        // Titre "Nous contacter" dans le panel de contact
        JLabel contactTitle = new JLabel("     Nous contacter");
        contactTitle.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        contactTitle.setForeground(Color.white);
        contactTitle.setBounds(100, 10, 200, 30);
        contactPanel.add(contactTitle);

        // Informations de contact
        JLabel addressLabel = new JLabel("        Adresse : Saadi Anser, Djijel");
        JLabel phoneLabel = new JLabel("        numero : 213557550768");
        JLabel emailLabel = new JLabel("        gmail : Belvaux@gmail.com");

        addressLabel.setBounds(0, 50, 380, 30);
        addressLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        addressLabel.setForeground(Color.white);
        addressLabel.setBorder(new RoundBorder(color, 3));;
        phoneLabel.setBounds(0, 90, 380, 30);
        phoneLabel.setBorder(new RoundBorder(color, 3));
        phoneLabel.setForeground(Color.white);
        phoneLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        emailLabel.setBounds(0, 130, 380, 30);
        emailLabel.setBorder(new RoundBorder(color, 3));
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

        contactPanel.add(addressLabel);
        contactPanel.add(phoneLabel);
        contactPanel.add(emailLabel);

        // Panel droit pour la disponibilité
        JPanel availabilityPanel = new JPanel();
        availabilityPanel.setLayout(null);
        availabilityPanel.setBounds(540, 350, 380, 200);
       
        availabilityPanel.setBackground(color);
        add(availabilityPanel);

        // Titre "Notre disponibilité" dans le panel de disponibilité
        JLabel availabilityTitle = new JLabel("      Notre disponibilité");
        availabilityTitle.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        availabilityTitle.setForeground(colorgris);
        availabilityTitle.setBounds(80, 10, 200, 30);
        availabilityPanel.add(availabilityTitle);

        // Texte pour la disponibilité (à remplir par la suite)
        JLabel availabilityText = new JLabel(
                "<html>Monday to Friday 9:00 am to 6:00 pm<br>Saturday 9:00 am to 12 noon<br>Sunday by appointment only.</html>");
        availabilityText.setForeground(colorgris);
        availabilityText.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        availabilityText.setBounds(30, 10, 300, 200);
        availabilityPanel.add(availabilityText);

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

        // creation d'un boutton pour le close avec ses caractéristiques.

        // Utiliser la couleur
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

        JPanel descriptionpPanel=new JPanel();
        descriptionpPanel.setLayout(null);
        descriptionpPanel.setBounds(3, 40, 1027, 280);
        descriptionpPanel.setBorder(new RoundBorder(color, 3));
        descriptionpPanel.setBackground(colorgris);
        add(descriptionpPanel);

        JLabel descriptionlabel=new JLabel("                                             Description :");
        descriptionlabel.setFont(new Font("Baskerville Old Face", Font.ITALIC, 30));
        descriptionlabel.setBounds(100, 40, 900, 30);
        descriptionlabel.setForeground(Color.white);
        descriptionpPanel.add(descriptionlabel);
        
        JLabel descJLabel=new JLabel("<html>Niché au cœur de la magnifique ville de Jijel, l'Hôtel Harry est une oasis de tranquillité en pleine nature.Entouré de paysages <br> pittoresques et de verdure luxuriante,  cet hôtel offre une retraite paisible où l'on peut échapper au tumulte de la vie quotidienne.</html>");
        descJLabel.setForeground(Color.WHITE);
        descJLabel.setFont(new Font("Baskerville Old Face", Font.ITALIC, 15));
        descJLabel.setBounds(120, 20, 900, 200);
        descriptionpPanel.add(descJLabel);
        

        JLabel descJLabel2=new JLabel("<html>Avec son ambiance chaleureuse et son charme authentique, l'Hôtel Harry propose des hébergements confortables et élégants,idéaux<br> pour une escapade relaxante. Que ce soit pour un séjour romantique en amoureux, des vacances en famille ou une escapade entre <br>amis,  cet établissement offre une expérience de séjour mémorable.</html>");
        descJLabel2.setForeground(Color.WHITE);
        descJLabel2.setFont(new Font("Baskerville Old Face", Font.ITALIC, 15));
        descJLabel2.setBounds(120, 70, 900, 200);
        descriptionpPanel.add(descJLabel2);
        JLabel descJLabel3=new JLabel("<html>Profitez de délicieux repas dans les restaurants de l'hôtel, détendez-vous au bord de la piscine ou partez à la découverte des environs <br>pittoresques .Quels que soient vos besoins, l'Hôtel Harry est l'endroit parfait pour une escapade inoubliable à Jijel.</html>");
        descJLabel3.setForeground(Color.WHITE);
        descJLabel3.setFont(new Font("Baskerville Old Face", Font.ITALIC, 15));
        descJLabel3.setBounds(120, 120, 900, 200);
        descriptionpPanel.add(descJLabel3);

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new APropos().setVisible(true);
            }
        });
    }
}

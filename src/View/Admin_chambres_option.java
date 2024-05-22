package View;
import Model.*;
import Model.Chambre.*;
import Model.Option.Rooms_Options;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.Border;
import Control.Control;

class BlackScrollPane extends JScrollPane {
    public BlackScrollPane(Component view) {
        super(view);
        setOpaque(false);
    }
}
public class Admin_chambres_option extends javax.swing.JFrame{

    public static JCheckBox sonaCheckBox = new JCheckBox();
    public static JCheckBox terasseCheckBox = new JCheckBox();
    public static JCheckBox vuesurmerBox = new JCheckBox();
    public static JCheckBox vuesurforetBox = new JCheckBox();
    public static JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0));
    public static BlackScrollPane scrollPane;
    public static JButton filtrer = new JButton();
    public static JButton ajouterchambre = new JButton();
    public static JButton modifierchamb =new JButton();
    public static JButton suppchambre =new JButton();
    public static JButton updatepricebtn = new JButton();
    public static javax.swing.JLabel backgroundlabel = new javax.swing.JLabel();
    public static javax.swing.JLabel changepricelabel = new javax.swing.JLabel();
    public static javax.swing.JComboBox<String> roomtypebox = new JComboBox<>();
    public static javax.swing.JComboBox<String>  typeandoptionsbox = new JComboBox<>();
    static javax.swing.JTextField nouveauprixtxt= new javax.swing.JTextField();
    public static Color color = Color.decode("#E0C878");
    public static Color colorgris = Color.decode("#252926");
    public static int id_supp_chamb=0;
    public static Container container;

    public Admin_chambres_option() throws Exception {
        initComponents();
    }
    
    private void initComponents() throws Exception {

        // Création de la fenêtre principale
        setUndecorated(true); // Supprime tous les boutons par défaut
        // rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("adminchambre page");
        setLocationRelativeTo(null);
        setVisible(true);
    
       // les labels:
        JLabel sonaJlabel;
        JLabel vuesurmerJLabel;
        JLabel TerasseJlabel;
        JLabel vuesurforetJLabel;
        JLabel choisistypeJLabel;
        JLabel choisisoptionsJLabel;

        if (Hotel.langue == 0) {
         
            sonaJlabel = new JLabel("Sona :");           
            vuesurmerJLabel = new JLabel("Sea View :");
            TerasseJlabel = new JLabel("Terasse :");
            vuesurforetJLabel = new JLabel("Forest View :");
            filtrer.setText("Filter");
            ajouterchambre.setText("Add This Room");
            modifierchamb.setText("Edit This Room");
            suppchambre.setText("Delete This Room");
            choisisoptionsJLabel = new JLabel("Choose Options :");
            choisistypeJLabel = new JLabel("Choose Type :");
            changepricelabel = new JLabel("Change Price:");
            updatepricebtn.setText("Update Price");
        
        } else {
       
            sonaJlabel = new JLabel("Sona :");
            vuesurmerJLabel = new JLabel("Terasse :");
            TerasseJlabel = new JLabel("Vue sur mer :");
            vuesurforetJLabel = new JLabel("Vue sur foret :");
            choisisoptionsJLabel = new JLabel("Choisissez Les Options :");
            choisistypeJLabel = new JLabel("Choisissez Le Type :");
            ajouterchambre.setText("Ajouter Cette Chambre");
            modifierchamb.setText("Modifier Cette Chambre");
            suppchambre.setText("Supprimer Cette Chambre");
            filtrer.setText("Filtrer");
            updatepricebtn.setText("mis à jour prix");
        }

        // les panels:
    
        // création du premier panel pour les information de la réservation:
        JPanel informationReservationPanel = new JPanel();
        informationReservationPanel.setLayout(null);
        informationReservationPanel.setBorder((new RoundBorder(color, 3)));
        informationReservationPanel.setBackground(colorgris);
        add(informationReservationPanel);
        //le positionnement exact du panel:
        informationReservationPanel.setBounds(3, 3, 1027, 200);
       
       //les bouttons du panel informationReservationPanel:

       //création d'un boutton avec ses caractéristiques:
        modifierchamb.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        modifierchamb.setBackground(color);
        modifierchamb.setForeground(colorgris);
        modifierchamb.setBorder(new RoundBorder(color, 3));
        
        //le positionnement exact du boutton:
        modifierchamb.setBounds(790, 25, 150, 30);

        //création d'un boutton avec ses caractéristiques:
        suppchambre.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        suppchambre.setBackground(color);
        suppchambre.setForeground(colorgris);
        suppchambre.setBorder(new RoundBorder(color, 3));
        
        //le positionnement exact du boutton:
        suppchambre.setBounds(790, 70, 150, 30);

        //création d'un boutton avec ses caractéristiques:
        ajouterchambre.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        ajouterchambre.setBackground(color);
        ajouterchambre.setForeground(colorgris);
        ajouterchambre.setBorder(new RoundBorder(color, 3));
        //le positionnement exact du boutton:
        ajouterchambre.setBounds(790, 115, 150, 30);

        //création d'un boutton avec ses caractéristiques:
        JButton revenirbtn = new JButton("");
        revenirbtn.setBackground(Color.white);
        //le positionnement exact du boutton:
        revenirbtn.setBounds(970, 5, 25, 30);

        //création d'un boutton avec ses caractéristiques:
        javax.swing.JButton closebtn = new JButton("");
        closebtn.setBackground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        // le positionement exact du boutton.
        closebtn.setBounds(997, 5, 25, 30);

        //création d'un boutton avec ses caractéristiques:
        filtrer.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        filtrer.setBackground(color);
        filtrer.setForeground(colorgris);
        filtrer.setBorder(new RoundBorder(color, 3));
        //le positionnement exact du boutton:
        filtrer.setBounds(790, 160, 150, 30);

        //ajouter au premier panel:

        informationReservationPanel.add(filtrer);
        informationReservationPanel.add(ajouterchambre);
        informationReservationPanel.add(suppchambre);
        informationReservationPanel.add(modifierchamb);
        informationReservationPanel.add(closebtn);
        informationReservationPanel.add(revenirbtn);

        //création du deuxième panel pour les information de la réservation:
        
        JPanel optioJPanel = new JPanel();
        optioJPanel.setBackground(color);
        optioJPanel.setLayout(null);
        optioJPanel.setBounds(400, 10, 380, 180);

        // les labels du panel:

        sonaJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        sonaJlabel.setForeground(colorgris);
        sonaJlabel.setBounds(40, 90, 200, 20);
        TerasseJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        TerasseJlabel.setForeground(colorgris);
        TerasseJlabel.setBounds(40, 110, 200, 20);
        vuesurforetJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        vuesurforetJLabel.setForeground(colorgris);
        vuesurforetJLabel.setBounds(40, 130, 200, 20);
        vuesurmerJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        vuesurmerJLabel.setForeground(colorgris);
        vuesurmerJLabel.setBounds(40, 150, 200, 20);
        choisistypeJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        choisistypeJLabel.setForeground(colorgris);
        choisistypeJLabel.setBounds(20, 20, 200, 17);
        choisisoptionsJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        choisisoptionsJLabel.setForeground(colorgris);
        choisisoptionsJLabel.setBounds(20, 60, 200, 17);

        //les checkbox:
        sonaCheckBox.setBackground(color);
        sonaCheckBox.setBounds(240, 90, 40, 20);
        terasseCheckBox.setBackground(color);
        terasseCheckBox.setBounds(240, 110, 40, 20);
        vuesurforetBox.setBackground(color);
        vuesurforetBox.setBounds(240, 130, 40, 20);
        vuesurmerBox.setBackground(color);
        vuesurmerBox.setBounds(240, 150, 40, 20); 

        // les combo_box:
        roomtypebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE" }));
        roomtypebox.setForeground(color);
        roomtypebox.setBackground(colorgris);
        roomtypebox.setBorder(new RoundBorder(color, 3));
        roomtypebox.setBounds(200, 14, 150, 30);

        //ajouter au panel:
        optioJPanel.add(sonaJlabel);
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
        informationReservationPanel.add(optioJPanel);

        //création du troisième panel pour les information de la réservation:
        
        JPanel changepricepanel = new JPanel();
        changepricepanel.setBackground(color);
        changepricepanel.setLayout(null);
        changepricepanel.setBounds(10, 10, 380, 180);

        //les labels:
        changepricelabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 17));
        changepricelabel.setForeground(colorgris); 
        changepricelabel.setBounds(20, 60, 200, 17);

        //les bouttons:
        updatepricebtn.setFont(new java.awt.Font("Baskerville Old Face", 0, 14));
        updatepricebtn.setBackground(colorgris);
        updatepricebtn.setForeground(color.white);
        updatepricebtn.setBorder(new RoundBorder(color, 3));
        updatepricebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPreformedUpdate(evt);

            }
        });
        //le positionnement exact du boutton:
        updatepricebtn.setBounds(20, 120, 150, 30);

        //les combobox:
        typeandoptionsbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLO", "DOUBLE", "TRIPLE", "SUITE", "SONA","TERASSE", "VUESURMERE", "VUESURFORET"}));
        typeandoptionsbox.setForeground(color);
        typeandoptionsbox.setBackground(colorgris);
        typeandoptionsbox.setBorder(new RoundBorder(color, 3));
        typeandoptionsbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            
            updateprice(); 

            }
        });
        typeandoptionsbox.setBounds(20, 14, 150, 30);

        //les textfields:
        nouveauprixtxt.setBounds(20, 90, 100, 20);

        //ajouter au panel:
        changepricepanel.add(typeandoptionsbox);
        changepricepanel.add(changepricelabel);
        changepricepanel.add(nouveauprixtxt);
        changepricepanel.add(updatepricebtn);
        informationReservationPanel.add(changepricepanel);



        afficherchambre();

        System.setProperty("sun.java2d.uiScale.enabled", "false");
        backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png"));

        // le positionement exact du background.
        backgroundlabel.setBounds(0, 0, 1032, 580);
        getContentPane().add(backgroundlabel);

        setSize(new java.awt.Dimension(1032, 580));
        setLocationRelativeTo(null);

        // les actions listners:
        modifierchamb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Control.Action_AdminOptionChambre(3);
                    modifChambreactionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        suppchambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Control.Action_AdminOptionChambre(2);
                    suppchambreActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        ajouterchambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Control.Action_AdminOptionChambre(1);
                    addChambrePreformed(evt);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    







        revenirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

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

        filtrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                filtrerbtnActionPerformed();

            }
        });
    }

    public static JPanel createPanel(Chambre chambre) {
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

        if (Hotel.langue == 0) {
            nameLabel = new JLabel("RoomID: " + chambre.getId());
            bedsLabel = new JLabel("Room type: " + chambre.getType());
            priceLabel = new JLabel("price: " + chambre.getPrix());
            optionlLabel = new JLabel("Options: ");
            optionlLabel.setForeground(Color.BLUE);
            SonaJlabel = new JLabel("                   Sona ");
            TerasseJlabel = new JLabel("                  terasse");
            vuemerJLabel = new JLabel("                 Sea View");
            vueforetJLabel = new JLabel("               Forest View");
            suppchambre.setText("Delete Room");
            modifierchamb.setText("Edit Room");
        } else {
            nameLabel = new JLabel("IDChambre: " + chambre.getId());
            bedsLabel = new JLabel("Type de la Chambre: " + chambre.getType());
            priceLabel = new JLabel("Prix: " + chambre.getPrix());
            optionlLabel = new JLabel("Options: ");
            SonaJlabel = new JLabel("                   Sona ");
            TerasseJlabel = new JLabel("                  terasse");
            vuemerJLabel = new JLabel("           Vue sur la mere");
            vueforetJLabel = new JLabel("           Vue sur la foret");
            suppchambre.setText("Suprimer Chambre");

        }

        nameLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        bedsLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        priceLabel.setForeground(colorgris);
        priceLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        optionlLabel.setForeground(colorgris);
        optionlLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        vueforetJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        vuemerJLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        TerasseJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
        SonaJlabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));

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

        // Ajout des composants au JPanel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 1)); // Utilisation d'un GridLayout pour empiler verticalement les
                                                   // éléments
        infoPanel.add(nameLabel);
        infoPanel.add(bedsLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(optionlLabel);
        infoPanel.setBackground(Color.white);
        optionsPanel.setBackground(Color.white);
        panel.setBackground(Color.white);
        JPanel modsupPanel=new JPanel();
        modsupPanel.setLayout(new GridLayout(0,1));

        panel.add(infoPanel, BorderLayout.NORTH); // Ajout du panneau d'informations au centre
        panel.add(optionsPanel, BorderLayout.CENTER); // Ajout du panneau des options en haut
        panel.add(modsupPanel, BorderLayout.SOUTH); // Ajout du bouton Réserver en bas
      
        Border border = new RoundBorder(colorgris, 2); // Utilisation du code RGB pour la couleur marron

        panel.setBorder(border);
        // Définir une taille préférée pour le JPanel
        panel.setPreferredSize(new Dimension(182, 200));

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Admin_chambres_option.id_supp_chamb= chambre.getId();
               System.out.println(id_supp_chamb);
  
                sonaCheckBox.setSelected(chambre.isSONA());
                terasseCheckBox.setSelected(chambre.isTERASSE());;
                vuesurforetBox.setSelected(chambre.isVuesurforet());
                vuesurmerBox.setSelected(chambre.isVuesurmere());
                switch (chambre.getType()) {
                    case SOLO:
                    roomtypebox.setSelectedIndex(0);
                        break;
                    case DOUBLE:
                    roomtypebox.setSelectedIndex(1);
                        break;
                    case TRIPLE:
                    roomtypebox.setSelectedIndex(2);
                        break;
                    default:
                    roomtypebox.setSelectedIndex(3);
                        break;
                }
                JOptionPane.showMessageDialog(frame, "La chambre "+id_supp_chamb+" a été sélectionnée ! \n" + 
                                        "Vous pouvez la SUPRIMER ou la MODIFIER","La sélection d'une chambre",  JOptionPane.INFORMATION_MESSAGE);
              
            }
        });

        return panel;
    }
     
    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        
        Control.hash_map_bdd();
        System.exit(0);
  
}

    static JFrame frame=new JFrame();

    public void modifChambreactionPerformed(java.awt.event.ActionEvent evt){
    if (Admin_chambres_option.id_supp_chamb !=0) {
   
    JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0)); // 5 chambres par ligne
    
    JOptionPane.showMessageDialog(frame, "La Chambre "+id_supp_chamb+" a été Modifier avec succès","Modification d'une chambre",  JOptionPane.INFORMATION_MESSAGE);

    Iterator<Map.Entry<Integer, Chambre>> iterator = Hotel.getChambreMap().entrySet().iterator();

    while (iterator.hasNext()) {
        Map.Entry<Integer, Chambre> entry = iterator.next();
        if(entry.getValue().getSup()!=1){
        Chambre chambre = entry.getValue();
        chambreContainer.add(createPanel(chambre));
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
    Admin_chambres_option.id_supp_chamb =0;


}else{

    JOptionPane.showMessageDialog(frame, "Choisissez une chambre à Modifier !","Modification d'une chambre",  JOptionPane.INFORMATION_MESSAGE);

}

}

    public void suppchambreActionPerformed(java.awt.event.ActionEvent evt){
        if (id_supp_chamb!=0) {

        JOptionPane.showMessageDialog(frame,"La Chambre "+id_supp_chamb+" a été supprimée avec succès.","Suppression d'une chambre",  JOptionPane.INFORMATION_MESSAGE);

        JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0)); // 5 chambres par ligne

        Iterator<Map.Entry<Integer, Chambre>> iterator = Hotel.getChambreMap().entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Chambre> entry = iterator.next();
            if(entry.getValue().getSup()!=1){
            Chambre chambre = entry.getValue();
            chambreContainer.add(createPanel(chambre));
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
        Admin_chambres_option.id_supp_chamb =0;

        }else{
  
            JOptionPane.showMessageDialog(frame,"Choisissez une chambre à supprimer !","Suppression d'une chambre",  JOptionPane.INFORMATION_MESSAGE);

        }
    }
  

     void  addChambrePreformed(java.awt.event.ActionEvent evt) throws Exception{
        
        JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0)); // 5 chambres par ligne
       
        JOptionPane.showMessageDialog(frame,"La chambre a été Ajoutée avec succès");
      
        Iterator<Map.Entry<Integer, Chambre>> iterator = Hotel.getChambreMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Chambre> entry = iterator.next();
            if(entry.getValue().getSup()!=1){
            Chambre chambre = entry.getValue();
            chambreContainer.add(createPanel(chambre));
            }
        }
        chambreContainer.setBackground(colorgris);
        scrollPane.setBackground(colorgris);
        JViewport viewport = scrollPane.getViewport();
  
        viewport.removeAll();
        viewport.add(chambreContainer);

        System.setProperty("sun.java2d.uiScale.enabled", "false");
        backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png")); // NOI18N
        backgroundlabel.setBounds(0, 0, 1032, 580);


        getContentPane().add(backgroundlabel);
        getContentPane().revalidate();
        getContentPane().repaint();
    
    }

    private void filtrerbtnActionPerformed() {
   
            TypeChambre typeChambre = TypeChambre.ToTypeChambre((String) roomtypebox.getSelectedItem());
            boolean Sona =   sonaCheckBox.isSelected();
            boolean climatisation = terasseCheckBox.isSelected();
            boolean vuesurmer = vuesurmerBox.isSelected();
            boolean vueforet = vuesurforetBox.isSelected();
          

            JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0)); // 5 chambres par ligne
          

            Iterator<Map.Entry<Integer, Chambre>> iterator = Hotel.getChambreMap().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Chambre> entry = iterator.next();
                Chambre chambre = entry.getValue();
                if (Hotel.verifchambreavecoption(chambre, typeChambre, Sona, climatisation, vuesurmer, vuesurmer)) {
                    chambreContainer.add(createPanel(chambre));
                    
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

    void afficherchambre() throws Exception {

        Iterator<Map.Entry<Integer, Chambre>> iterator = Hotel.getChambreMap().entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Chambre> entry = iterator.next();
            Chambre chambre = entry.getValue();
            JPanel chambrePanel = createPanel(chambre);
            chambrePanel.setPreferredSize(new Dimension(170, 135)); // Définir la taille préférée de chaque élément
            chambreContainer.add(chambrePanel);
        }

        chambreContainer.setBackground(colorgris);
        scrollPane = new BlackScrollPane(chambreContainer);
        scrollPane.setBackground(colorgris);

        scrollPane.setPreferredSize(new Dimension(936, 588)); // Taille fixe du JScrollPane
        scrollPane.setBounds(0, 210, 1033, 400);

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
    
    //mazel !!
    public static void updateprice(){

    String option=typeandoptionsbox.getSelectedItem().toString();
    Double price = Option.GetPrix(option);
    nouveauprixtxt.setText(price.toString());
    }




    void ActionPreformedUpdate(java.awt.event.ActionEvent evt) {
        int id=0;
        Rooms_Options rooms_Options = Rooms_Options.ToTypeChambre(typeandoptionsbox.getSelectedItem().toString()) ;
                for (Map.Entry<Integer, Option> entry : Hotel.getOptionHashMap().entrySet()) {
                    if (entry.getValue().getRooms_Options().equals(rooms_Options)) {
                         id= entry.getKey();
                        break;
                    }
                }
                double newprice=Double.parseDouble(nouveauprixtxt.getText());
                Option option = new Option(Rooms_Options.ToTypeChambre(typeandoptionsbox.getSelectedItem().toString()),newprice , id);
                Hotel.ModifieroptionMap(option);

                JPanel chambreContainer = new JPanel(new GridLayout(0, 5, 0, 0)); // 5 chambres par ligne
       
                JOptionPane.showMessageDialog(frame,"La Prix "+typeandoptionsbox.getSelectedItem().toString()+ " a été Modifier avec succès !");
                Hotel.getChambreMap().clear();
                Chambre.Bdd_to_hashMap_room();
                Iterator<Map.Entry<Integer, Chambre>> iterator = Hotel.getChambreMap().entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Chambre> entry = iterator.next();
                    if(entry.getValue().getSup()!=1){
                    Chambre chambre = entry.getValue();
                    chambreContainer.add(createPanel(chambre));
                    }
                }
                chambreContainer.setBackground(colorgris);
                scrollPane.setBackground(colorgris);
                JViewport viewport = scrollPane.getViewport();
          
                viewport.removeAll();
                viewport.add(chambreContainer);
        
                System.setProperty("sun.java2d.uiScale.enabled", "false");
                backgroundlabel.setIcon(new javax.swing.ImageIcon("10.png")); // NOI18N
                backgroundlabel.setBounds(0, 0, 1032, 580);
        
        
                getContentPane().add(backgroundlabel);
                getContentPane().revalidate();
                getContentPane().repaint();
    }

    public static void main(String args[]) {
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new Admin_chambres_option().setVisible(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}

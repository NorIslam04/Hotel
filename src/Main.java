import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        // Créer et configurer la fenêtre principale
        JFrame frame = new JFrame("Changement d'icône");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Créer un bouton avec une icône par défaut
        ImageIcon defaultIcon = new ImageIcon("For Rent2.png");
        JButton button = new JButton(defaultIcon);

        // Ajouter un gestionnaire d'événements au bouton
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Changer l'icône lorsque le bouton est cliqué
                if (button.getIcon() == defaultIcon) {
                    button.setIcon(new ImageIcon("For Rent21.png"));
                } else {
                    button.setIcon(defaultIcon);
                }
            }
        });

        // Ajouter le bouton à la fenêtre
        frame.getContentPane().add(button, BorderLayout.CENTER);

        // Afficher la fenêtre
        frame.setVisible(true);
    }
}
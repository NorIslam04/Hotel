import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Main extends JFrame {
    public Main() {
        setTitle("Exemple JTextField");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField textField = new JTextField("Tapez ici");
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setForeground(Color.GRAY); // Couleur de texte grise initiale
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Tapez ici")) {
                    textField.setText(""); // Efface le texte lorsque le champ obtient le focus
                    textField.setForeground(Color.BLACK); // Change la couleur du texte en noir
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("Tapez ici"); // Restaure le texte initial si le champ est vide
                    textField.setForeground(Color.GRAY); // Rétablit la couleur de texte grise
                }
            }
        });

        panel.add(textField);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}

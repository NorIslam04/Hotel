import javax.swing.*;

public class CheckBoxExample extends JFrame {
    
    public CheckBoxExample() {
        setTitle("Checkbox Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        
        // Création du bouton à cocher
        JCheckBox checkBox = new JCheckBox("Cocher moi");
        
        // Ajout du bouton à cocher au panneau
        panel.add(checkBox);

        getContentPane().add(panel);
        
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CheckBoxExample example = new CheckBoxExample();
            example.setVisible(true);
        });
    }
}
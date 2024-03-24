import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class chambres extends javax.swing.JFrame {

    
    public chambres() {
        initComponents();
    }
                         
    private void initComponents() {

        titrelabel = new javax.swing.JLabel();
        suitetext = new javax.swing.JLabel();
        prixsuite = new javax.swing.JLabel();
        doubletext = new javax.swing.JLabel();
        prixdouble = new javax.swing.JLabel();
        triotext = new javax.swing.JLabel();
        prixtrio = new javax.swing.JLabel();
        solotext = new javax.swing.JLabel();
        prixsolo = new javax.swing.JLabel();
        passtomyreservationsbtn = new javax.swing.JButton();
        backgroundlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");

        titrelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 48)); // NOI18N
        titrelabel.setForeground(new java.awt.Color(255, 255, 255));
        titrelabel.setText("These Are Our Rooms");

        suitetext.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        suitetext.setText("Suite:Max 5 Guests.");

        prixsuite.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        prixsuite.setText("700$/Night.");

        doubletext.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        doubletext.setText("Double Room: Max 2 Guests.");

        prixdouble.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        prixdouble.setText("250$/Night.  ");

        triotext.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        triotext.setText("Trio Room:Max 3 Guests.");

        prixtrio.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        prixtrio.setText("500$/Night.");

        solotext.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        solotext.setText("Solo Room:For 1 Guest.");

        prixsolo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        prixsolo.setText("100$/Night.");

        passtomyreservationsbtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); 
        passtomyreservationsbtn.setText("Pass To My Reservations");

        backgroundlabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Desktop\\les interfaces graphiques\\chambres.png")); 

        setSize(new java.awt.Dimension(936, 588));
        setLocationRelativeTo(null);
    }                       

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chambres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chambres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chambres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chambres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chambres().setVisible(true);
            }
        });
    }                
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JLabel doubletext;
    private javax.swing.JButton passtomyreservationsbtn;
    private javax.swing.JLabel prixdouble;
    private javax.swing.JLabel prixsolo;
    private javax.swing.JLabel prixsuite;
    private javax.swing.JLabel prixtrio;
    private javax.swing.JLabel solotext;
    private javax.swing.JLabel suitetext;
    private javax.swing.JLabel titrelabel;
    private javax.swing.JLabel triotext;
                    
}

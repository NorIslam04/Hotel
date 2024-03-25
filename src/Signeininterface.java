import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Signeininterface extends javax.swing.JFrame {

    public Signeininterface() {
        initComponents();
    }
                       
    private void initComponents() {

        userlabel = new javax.swing.JLabel();
        pwdlabel = new javax.swing.JLabel();
        signinlabel = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        pwdtext = new javax.swing.JPasswordField();
        welcomelabel = new javax.swing.JLabel();
        submitbtn = new javax.swing.JButton();
        maillabel = new javax.swing.JLabel();
        mailtext = new javax.swing.JTextField();
        closebtn = new javax.swing.JButton();
        backgroundlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");

        userlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); 
        userlabel.setForeground(new java.awt.Color(255, 255, 255));
        userlabel.setText("User-name:");

        pwdlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24));
        pwdlabel.setForeground(new java.awt.Color(255, 255, 255));
        pwdlabel.setText("Password:");

        signinlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 36));
        signinlabel.setForeground(new java.awt.Color(255, 255, 255));
        signinlabel.setText("Sign-In");

        pwdtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdtextActionPerformed(evt);
            }
        });

        welcomelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 48));
        welcomelabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomelabel.setText("Welcome To Our Hotel");

        submitbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        submitbtn.setText("Submit");

        maillabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24));
        maillabel.setForeground(new java.awt.Color(255, 255, 255));
        maillabel.setText("Adresse-Mail:");

        closebtn.setBackground(new java.awt.Color(171, 34, 34));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        closebtn.setForeground(new java.awt.Color(255, 255, 255));
        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        backgroundlabel.setIcon(new javax.swing.ImageIcon("sign_up.png"));

        setSize(new java.awt.Dimension(936, 588));
        setLocationRelativeTo(null);
    }                      

    private void pwdtextActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       
private JFrame frame;
    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        frame=new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"DO YOU REALY WANT TO CLOSE THIS WINDOW?","MySQL Connector",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
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
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signeininterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signeininterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JButton closebtn;
    private javax.swing.JLabel maillabel;
    private javax.swing.JTextField mailtext;
    private javax.swing.JLabel pwdlabel;
    private javax.swing.JPasswordField pwdtext;
    private javax.swing.JLabel signinlabel;
    private javax.swing.JButton submitbtn;
    private javax.swing.JLabel userlabel;
    private javax.swing.JTextField usertext;
    private javax.swing.JLabel welcomelabel;
    // End of variables declaration                   
}


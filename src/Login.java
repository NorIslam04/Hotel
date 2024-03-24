import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    
    public Login() {
        initComponents();
    }

    private void initComponents() {

        userlabel = new javax.swing.JLabel();
        pwdlabel = new javax.swing.JLabel();
        loginlabel = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        pwdtext = new javax.swing.JPasswordField();
        welcomelabel = new javax.swing.JLabel();
        signinbtn = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        submitbtn = new javax.swing.JButton();
        backgroundlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");

        userlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24));
        userlabel.setForeground(new java.awt.Color(255, 255, 255));
        userlabel.setText("User-name:");

        pwdlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24));
        pwdlabel.setForeground(new java.awt.Color(255, 255, 255));
        pwdlabel.setText("Password:");

        loginlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 36));
        loginlabel.setForeground(new java.awt.Color(255, 255, 255));
        loginlabel.setText("Login");

        usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });

        pwdtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdtextActionPerformed(evt);
            }
        });

        welcomelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 48)); // NOI18N
        welcomelabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomelabel.setText("Welcome To Our Hotel");

        signinbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        signinbtn.setText("Sign-in");
        signinbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinbtnActionPerformed(evt);
            }
        });

        closebtn.setBackground(new java.awt.Color(171, 34, 34));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        closebtn.setForeground(new java.awt.Color(255, 255, 255));
        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        submitbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        submitbtn.setText("Submit");
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtnActionPerformed(evt);
            }
        });

        backgroundlabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Desktop\\les interfaces graphiques\\login.png"));

        setSize(new java.awt.Dimension(936, 588));
        setLocationRelativeTo(null);
    }                        

    private void pwdtextActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void signinbtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
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

    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void usertextActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

                       
    private javax.swing.JLabel backgroundlabel;
    private javax.swing.JButton closebtn;
    private javax.swing.JLabel loginlabel;
    private javax.swing.JLabel pwdlabel;
    private javax.swing.JPasswordField pwdtext;
    private javax.swing.JButton signinbtn;
    private javax.swing.JButton submitbtn;
    private javax.swing.JLabel userlabel;
    private javax.swing.JTextField usertext;
    private javax.swing.JLabel welcomelabel;
                    
}


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
        
        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("signin page");
        setLocationRelativeTo(null);
        setVisible(true);
        // les labels:
        //creation d'une label pour le username avec ses caractéristiques.
        userlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        userlabel.setForeground(new java.awt.Color(255, 255, 255));
        userlabel.setText("User-name:");
        // le positionement exact du label.
        userlabel.setBounds(240, 300, 150, 30);
        getContentPane().add(userlabel);

        //creation d'une label pour le password avec ses caractéristiques.
        pwdlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        pwdlabel.setForeground(new java.awt.Color(255, 255, 255));
        pwdlabel.setText("Password:");
        // le positionement exact du label.
        pwdlabel.setBounds(240, 420, 150, 30);
        getContentPane().add(pwdlabel);
       
        //creation d'une label pour le sign in avec ses caractéristiques.
        signinlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 36)); // NOI18N
        signinlabel.setForeground(new java.awt.Color(255, 255, 255));
        signinlabel.setText("Sign-In");
        // le positionement exact du label.
        signinlabel.setBounds(380, 240,150,40);
        getContentPane().add(signinlabel);
        
        //creation d'une label pour le welcome avec ses caractéristiques.
        welcomelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 48)); 
        welcomelabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomelabel.setText("Welcome To Our Hotel");
        // le positionement exact du label.
        welcomelabel.setBounds(180, 30, 1000, 50);
        getContentPane().add(welcomelabel);
        
        //creation d'une label pour le e-mail avec ses caractéristiques.
        maillabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); 
        maillabel.setForeground(new java.awt.Color(255, 255, 255));
        maillabel.setText("Adresse-Mail:");
        // le positionement exact du label.
        maillabel.setBounds(240, 360, 200, 30);
        getContentPane().add(maillabel);
        
        //les bouttons:
        //creation d'un boutton pour le submit avec ses caractéristiques.
        submitbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        submitbtn.setText("Submit");
        // le positionement exact du boutton.
        submitbtn.setBounds(620, 480, 100, 30);
        getContentPane().add(submitbtn);
       
        //creation d'un boutton pour le close avec ses caractéristiques.
        closebtn.setBackground(new java.awt.Color(171, 34, 34));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        closebtn.setForeground(new java.awt.Color(255, 255, 255));
        closebtn.setText("Close");
        // le positionement exact du boutton.
        closebtn.setBounds(210, 480, 100, 30);
        getContentPane().add(closebtn);


        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });

        //les textfields:

        pwdtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdtextActionPerformed(evt);
            }
        });

        // le positionement exact du textfield:
        pwdtext.setBounds(440, 420, 230, 30);
        getContentPane().add(pwdtext);
        
        // le positionement exact du textfield.
        usertext.setBounds(440, 300, 230, 30);
        getContentPane().add(usertext);

        // le positionement exact du textfield.
        mailtext.setBounds(440, 360, 230, 30);
        getContentPane().add(mailtext);

        backgroundlabel.setIcon(new javax.swing.ImageIcon("sign_up.png")); // NOI18N
        // le positionement exact du background.
        backgroundlabel.setBounds(0, 0, 920, 580);
        getContentPane().add(backgroundlabel);
        
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


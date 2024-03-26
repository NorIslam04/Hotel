import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        
    }
                        
    private void initComponents() {

        userlabel = new javax.swing.JLabel();
        pwdlabel = new javax.swing.JLabel();
        loginlabel = new javax.swing.JLabel();
        welcomelabel = new javax.swing.JLabel();
        backgroundlabel = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        pwdtext = new javax.swing.JPasswordField();
        signinbtn = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        submitbtn = new javax.swing.JButton();

        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setVisible(true);
        
        //creation d'une label pour le username avec ses caractéristiques.
        userlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); 
        userlabel.setForeground(new java.awt.Color(255, 255, 255));
        userlabel.setText("User-name:");
        // le positionement exact du label.
        userlabel.setBounds(240, 320, 150, 30);
        getContentPane().add(userlabel);
        
        //creation d'une label pour le password avec ses caractéristiques.
        pwdlabel.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        pwdlabel.setForeground(new java.awt.Color(255, 255, 255));
        pwdlabel.setText("Password:");
        // le positionement exact du label.
        pwdlabel.setBounds(240, 380, 150,30);
        getContentPane().add(pwdlabel);
        
        //creation d'une label pour le login avec ses caractéristiques.
        loginlabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 36)); // NOI18N
        loginlabel.setForeground(new java.awt.Color(255, 255, 255));
        loginlabel.setText("Login");
        // le positionement exact du label.
        loginlabel.setBounds(400, 240, 150, 50);
        getContentPane().add(loginlabel);

        //creation d'une label pour le welcome avec ses caractéristiques.
        welcomelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 48)); // NOI18N
        welcomelabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomelabel.setText("Welcome To Our Hotel");
        // le positionement exact du label.
        welcomelabel.setBounds(180,30,1000,50);
        getContentPane().add(welcomelabel);
        
        // le positionement exact du password field.
        pwdtext.setBounds(420, 380, 230, 30);
        getContentPane().add(pwdtext);
        // l'action du password field.
        pwdtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdtextActionPerformed(evt);
            }
        });
        // le positionement exact du user text field.
        usertext.setBounds(420, 320, 230, 30);
        getContentPane().add(usertext);
        // l'action du user text field.
        /* usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });*/

        //les bouttons:

        signinbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        signinbtn.setText("Sign-in");
        // le positionement exact du signin button.
        signinbtn.setBounds(610, 450, 90, 30);
        getContentPane().add(signinbtn);
        // l'action du signin button.
        signinbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinbtnActionPerformed(evt);
            }
        });
        
        
        closebtn.setBackground(new java.awt.Color(171, 34, 34));
        closebtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        closebtn.setForeground(new java.awt.Color(255, 255, 255));
        closebtn.setText("Close");
        // le positionement exact du close button.
        closebtn.setBounds(230, 450, 90, 30);
        getContentPane().add(closebtn);
        // l'action du close button.
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
       

        submitbtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        submitbtn.setText("Submit");
        // le positionement exact du submit button.
        submitbtn.setBounds(420, 450, 90, 30);
        getContentPane().add(submitbtn);

        // l'action du submit button.
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtnActionPerformed(evt);
            }
        });

        // le positionement exact du background label.
        backgroundlabel.setIcon(new javax.swing.ImageIcon("login.png")); // NOI18N
        backgroundlabel.setBounds(0, 0, 920, 580);
        getContentPane().add(backgroundlabel);
       

        setSize(new java.awt.Dimension(936, 588));
        setLocationRelativeTo(null);
    }                        

    private void pwdtextActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void signinbtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Signeininterface sin = new Signeininterface();
        sin.setVisible(true);
        this.hide();
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

        if(usertext.getText().equals("") || pwdtext.getText().equals("")){
            JOptionPane.showMessageDialog(frame,
            "Remplir le champ de User et Password",
            "ERROR",
            JOptionPane.ERROR_MESSAGE); 
        }else
        if(usertext.getText().equals(".admin")&&pwdtext.getText().equals(".admin")){
           // new tableReservationAdmin && modifier chambre
           JOptionPane.showMessageDialog(frame,
                "WELCOME ADMIN ZA3IIIM",
                "WELCOME",
                JOptionPane.INFORMATION_MESSAGE); 

        }else{
        if(Hotel.findUser(usertext.getText(),pwdtext.getText())){                                  
        chambreinterface ch = new chambreinterface();
        ch.setVisible(true);
        this.hide();
        }else{

            passerasignin pas = new passerasignin();
            pas.setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
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

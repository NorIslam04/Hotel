public class passerasignin extends javax.swing.JFrame {

    public passerasignin() {
        initComponents();
    }
                    
    private void initComponents() {

        checktext = new javax.swing.JLabel();
        signintext = new javax.swing.JLabel();
        signinbtn = new javax.swing.JButton();
        clickbackbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocationRelativeTo(null);
        setVisible(true);
       
        //creation d'une label pour le check avec ses caractéristiques.
        checktext.setFont(new java.awt.Font("Arial Black", 0, 12)); 
        checktext.setForeground(new java.awt.Color(255, 255, 255));
        checktext.setText("Please check your User-name and Password !");
        // le positionement exact du label.
        checktext.setBounds(30, 20, 300, 30);
        getContentPane().add(checktext);
        
        //creation d'une label pour le sign-in avec ses caractéristiques.
        signintext.setFont(new java.awt.Font("Arial", 0, 12));
        signintext.setForeground(new java.awt.Color(255, 255, 255));
        signintext.setText("Unless you want to creat a new acount click on sign-in");
        // le positionement exact du label.
        signintext.setBounds(30, 100, 300, 30);
        getContentPane().add(signintext);

        //creation d'un boutton pour le sign-in avec ses caractéristiques.
        signinbtn.setFont(new java.awt.Font("Bodoni MT", 0, 12));
        signinbtn.setText("Sign-In");
        signinbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinbtnActionPerformed(evt);
            }
        });
        // le positionement exact du boutton.
        signinbtn.setBounds(132, 130, 90, 25);
        getContentPane().add(signinbtn);
        
        //creation d'un boutton pour le click avec ses caractéristiques.
        clickbackbtn.setFont(new java.awt.Font("Bodoni MT", 0, 12)); // NOI18N
        clickbackbtn.setText("Click Here To Hit Back");
        clickbackbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickbackbtnActionPerformed(evt);
            }
        });
        // le positionement exact du boutton.
        clickbackbtn.setBounds(100, 60, 150, 25);
        getContentPane().add(clickbackbtn);

        jLabel3.setIcon(new javax.swing.ImageIcon("passtosignin.jpg"));
        // le positionement exact du label.
        jLabel3.setBounds(0, 0, 360, 180);
        getContentPane().add(jLabel3);


        setSize(new java.awt.Dimension(375, 215));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void clickbackbtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        this.dispose();
    }                                            

    private void signinbtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Signeininterface sin = new Signeininterface();
        sin.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(passerasignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(passerasignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(passerasignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(passerasignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new passerasignin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel checktext;
    private javax.swing.JButton clickbackbtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton signinbtn;
    private javax.swing.JLabel signintext;
    // End of variables declaration                   
}
               
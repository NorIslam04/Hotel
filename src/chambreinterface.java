import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class chambreinterface extends javax.swing.JFrame {

    
    public chambreinterface() {
        initComponents();
    }
    @SuppressWarnings("unchecked")                       
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
        
        //rendre le layout manager null pour le positionement absolu.
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("chambre");
        setLocationRelativeTo(null);
        setVisible(true);
        
        //creation d'une label pour le titre avec ses caractéristiques.
        titrelabel.setFont(new java.awt.Font("Bodoni MT Black", 0, 48)); // NOI18N
        titrelabel.setForeground(new java.awt.Color(255, 255, 255));
        titrelabel.setText("These Are Our Rooms");
        // le positionement exact du label.
        titrelabel.setBounds(180, 60, 1000, 50);
        getContentPane().add(titrelabel);

        //creation d'une label pour suite avec ses caractéristiques.
        suitetext.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        suitetext.setText("Suite:Max 5 Guests.");
        // le positionement exact du label.
        suitetext.setBounds(30, 330, 120, 20);
        getContentPane().add(suitetext);
        
        //creation d'une label pour prix suite avec ses caractéristiques.
        prixsuite.setFont(new java.awt.Font("Bodoni MT", 0, 14)); 
        prixsuite.setText("700$/Night.");
        // le positionement exact du label.
        prixsuite.setBounds(30, 360, 120, 20);
        getContentPane().add(prixsuite);
        
        //creation d'une label pour double avec ses caractéristiques.
        doubletext.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        doubletext.setText("Double Room: Max 2 Guests.");
        // le positionement exact du label.
        doubletext.setBounds(480, 330, 200 , 20);
        getContentPane().add(doubletext);
       
        //creation d'une label pour prix double avec ses caractéristiques.
        prixdouble.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        prixdouble.setText("250$/Night.  ");
        // le positionement exact du label.
        prixdouble.setBounds(480, 360, 120, 20);
        getContentPane().add(prixdouble);
        
        //creation d'une label pour trio avec ses caractéristiques.
        triotext.setFont(new java.awt.Font("Bodoni MT", 0, 14));
        triotext.setText("Trio Room:Max 3 Guests.");
        // le positionement exact du label.
        triotext.setBounds(250, 330, 200, 20);
        getContentPane().add(triotext);
        
        //creation d'une label pour prix trio avec ses caractéristiques.
        prixtrio.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        prixtrio.setText("500$/Night.");
        // le positionement exact du label.
        prixtrio.setBounds(250, 360, 120, 20);
        getContentPane().add(prixtrio);
        
        //creation d'une label pour solo avec ses caractéristiques.
        solotext.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        solotext.setText("Solo Room:For 1 Guest.");
        // le positionement exact du label.
        solotext.setBounds(700, 330, 200, 20);
        getContentPane().add(solotext);
        
        //creation d'une label pour prix solo avec ses caractéristiques.
        prixsolo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        prixsolo.setText("100$/Night.");
        // le positionement exact du label.
        prixsolo.setBounds(700, 360, 120, 20);
        getContentPane().add(prixsolo);
        
        //creation d'une label pour le pass to my reservations button avec ses caractéristiques.
        passtomyreservationsbtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); 
        passtomyreservationsbtn.setText("Pass To My Reservations");
        // le positionement exact du label.
        passtomyreservationsbtn.setBounds(20, 470, 200, 40);
        getContentPane().add(passtomyreservationsbtn);
        

        backgroundlabel.setIcon(new javax.swing.ImageIcon("chambres.png")); 
        // le positionement exact du label.
        backgroundlabel.setBounds(0, 0, 920, 580);
        getContentPane().add(backgroundlabel);
       

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
            java.util.logging.Logger.getLogger(chambreinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chambreinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chambreinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chambreinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chambreinterface().setVisible(true);
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

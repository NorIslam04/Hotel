//cbn
    public static void Action_apropos(){

        new APropos();

        APropos.revenirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwingUtilities.getWindowAncestor(APropos.revenirbtn).dispose();
            }
        });

        APropos.closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        APropos.langueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                APropos.changerlangue();
                SwingUtilities.getWindowAncestor( APropos.langueBox).dispose();
                Action_apropos();
       
            }
        });
    }
    //cbn
    public static void Action_Chambre_Intreface(){

        new Chambre_interface();

        Chambre_interface.aPropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Control.Action_apropos();
                SwingUtilities.getWindowAncestor(Chambre_interface.aPropos).dispose();
            }
        });

        Chambre_interface.passeraureservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Control.Action_TableReservationUser();
                SwingUtilities.getWindowAncestor(Chambre_interface.passeraureservationbtn).dispose();
            }
        });

        Chambre_interface.revenirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwingUtilities.getWindowAncestor(Chambre_interface.revenirbtn).dispose();
            }
        });

        Chambre_interface.avissurnousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    new Commentaires_Interface();
                    SwingUtilities.getWindowAncestor(Chambre_interface.avissurnousButton).dispose();
                } catch (Exception e) {
        
                    e.printStackTrace();
                }
            }
        });

        Chambre_interface.reserverpardetailbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    new Tarif_Option_Chambres();
                    SwingUtilities.getWindowAncestor(Chambre_interface.reserverpardetailbtn).dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Chambre_interface.closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        Chambre_interface.langueBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chambre_interface.changerlangue();
                SwingUtilities.getWindowAncestor(Chambre_interface.langueBox).dispose();
                Control.Action_Chambre_Intreface();
       
            }
        });



    }



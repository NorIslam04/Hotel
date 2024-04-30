


public class Main {
    public static void main(String[] args)  throws Exception { 

        Option.Bdd_to_hashMap_option();
        Commentaires.Bdd_to_hashMap_commantaire();
        User.Bdd_to_hashMap_users();
        Chambre.Bdd_to_hashMap_room();
        Reservation.Bdd_to_hashMap_reservation();
       

        //DataBase.afficherHashMap(1);
        new Login();

    }
}
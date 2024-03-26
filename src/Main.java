

public class Main {
    public static void main(String[] args) throws Exception {
     new Login();
       
     //creation des hashMap 
     DataBase.Bdd_to_hashMap_users();
     DataBase.Bdd_to_hashMap_room();
     DataBase.Bdd_to_hashMap_reservation();

     DataBase.afficherHashMap();

    


    }

    
}



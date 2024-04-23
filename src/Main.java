public class Main {
    public static void main(String[] args)  throws Exception { 
        
        DataBase.Bdd_to_hashMap_users();
        DataBase.Bdd_to_hashMap_room();
        DataBase.Bdd_to_hashMap_reservation();
      
        new Login();
    }
}
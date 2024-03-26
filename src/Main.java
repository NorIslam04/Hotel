import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
     new Login();
     //creation des hashMap 
     DataBase.Bdd_to_hashMap_users();
     DataBase.Bdd_to_hashMap_room();
     DataBase.Bdd_to_hashMap_reservation();




















     
    /*  Scanner sc = new Scanner(System.in);
     while(true){
          System.out.println("choisir un num: ");
          System.out.println("1 -> Users");
          System.out.println("2 -> Chambre");
          System.out.println("3 -> Reservation");
          int i=sc.nextInt();
          DataBase.afficherHashMap(i);
     }
    */


    }

    
}



import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;

public class Main {
    public static void main(String[] args)  throws NumberFormatException,Date_syntaxe,Date_nonvalid,DiffSup365,Date_nonorganiser, Date_Debut_Reservation { 
        try {
         
            Date today = new Date(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
            Date date_debut = Date.Recupere_date("ihytcxd");
            Date.verif_today_date(today, date_debut);
            Date date_fin = Date.Recupere_date("i");
            Date.differenceEntreDates(date_debut, date_fin);
            

            
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch(Date_nonvalid e){
            System.out.println(e.getMessage());
        } catch(DiffSup365 e){
            System.out.println(e.getMessage());
        } catch(Date_nonorganiser e){
            System.out.println(e.getMessage());
        }

        //new Login();
        //TypeChambre.initialiser(100, 1, 200, 2, 300, 3, 400, 4);
        //DataBase.Bdd_to_hashMap_users();
        //DataBase.Bdd_to_hashMap_room();
        //DataBase.Bdd_to_hashMap_reservation();

        // creation des hashMap

        //DataBase.afficherHashMap(1);
        //System.out.println(ModificationHotel.getNb());

        /*
         * Scanner sc = new Scanner(System.in);
         * while(true){
         * System.out.println("choisir un num: ");
         * System.out.println("1 -> Users");
         * System.out.println("2 -> Chambre");
         * System.out.println("3 -> Reservation");
         * int i=sc.nextInt();
         * DataBase.afficherHashMap(i);
         * }
         */

    }

}

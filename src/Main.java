import java.util.Date;


public class Main {
    public static void main(String[] args) throws Exception {
        Date1 today=new Date1(25, 05, 2024);
       try {


        Date1 date_debut=Date1.Recupere_date("islam/03/2024");
        Date1.verif_today_date(today,date_debut );
        Date1 date_fin =Date1.Recupere_date("26/03/2024");
        System.out.println("deffirance : "+Date1.differenceEntreDates(date_debut, date_fin));

       } catch(Date_syntaxe e){
            System.out.println(e.getMessage());

       } catch (NumberFormatException e) {
        System.out.println("entrer des chiffres dans les dates !");

       } catch(Date_nonvalid e){
        System.out.println(e.getMessage());

       } catch(Date_Debut_Reservation e) {
        System.out.println(e.getMessage());

       }catch(Date_nonorganiser e){
        System.out.println(e.getMessage());
       }
       
       //creation des hashMap 
       DataBase.Bdd_to_hashMap_users();
       DataBase.Bdd_to_hashMap_room();
       DataBase.Bdd_to_hashMap_reservation();


       
        User user1=new User(User.nb, "aloo@gamil.com", "aloo", "aloo1234");
        Hotel.AjouterUserMap(user1);
        DataBase.hashMapToDatabase_User();
        System.out.println(User.nb);
       

        Chambre chambre=new Chambre(Chambre.nb, 2, TypeChambre.SUITE, 23000.16,0);
        Hotel.AjouterChambreMap(chambre);
        DataBase.hashMapToDatabase_chambres();
        

        Date1 dd=Date1.Recupere_date("23/03/2024");
        Date1 df=Date1.Recupere_date("26/03/2024");

        Reservation reservation=new Reservation(Reservation.nb, user1.getId(), chambre.getType().ToString(), dd, df, chambre.getId(), EtatReservation.ACCEPTER);
        Hotel.AjouterReservationMap(reservation);
        DataBase.hashMapToDatabase_Reservation();


       //ses instruction dans login-page admin:
       String username="islam";//usertext.gettext();
       String password="islam";//pwdtext.gettext();
       if(DataBase.verif_admin_bdd(username, password)){
        //to Admin-page: 
       }else{
            //username or password is incorrect - affiche dans la fenetre d'error
       }
    
    }

    
}

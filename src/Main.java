public class Main {
    public static void main(String[] args) throws Exception {
        Date today=new Date(25, 05, 2024);
       try {

        Date date_debut=Date.Recupere_date("23/03/2024");
        Date.verif_today_date(today,date_debut );
        Date date_fin =Date.Recupere_date("26/03/2024");
        System.out.println("deffirance : "+Date.differenceEntreDates(date_debut, date_fin));
        
       } catch(Date_syntaxe e){
            System.out.println(e.getMessage());
        

       } catch (NumberFormatException e) {
        System.out.println("entrer des chiffres dans les dates -> "+e.getMessage());

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
        

        Date dd=Date.Recupere_date("23/03/2024");
        Date df=Date.Recupere_date("26/03/2024");

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



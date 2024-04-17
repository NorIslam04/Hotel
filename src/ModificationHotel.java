

public class ModificationHotel<T> {

    private int id;// de user,chambre,reservation
    private T objet;// user,chambre,reservation
    private TypeOperation operation;//AJOUT,SUPPRESSION,MODIFICATION
    private static int nb=0;
    
    /*
     * le but de cette class dans le convertion de hashMap -> BDD 
     * utilison comme premery-key le id et objet pour recuperer l'instance modifier dans hashMap de l'hotel
     * l'attribue operation pour separer les modification dans la BDD
     */


    public ModificationHotel(int id, T objet, TypeOperation operation) {
        this.id = id;
        this.objet = objet;
        this.operation = operation;
        nb++;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public T getObjet() {
        return objet;
    }
    public void setObjet(T objet) {
        this.objet = objet;
    }
    public TypeOperation getOperation() {
        return operation;
    }
    public void setOperation(TypeOperation operation) {
        this.operation = operation;
    }

    public static int getNb() {
        return nb;
    }


    public static void setNb(int nb) {
        ModificationHotel.nb = nb;
    }


    @Override
    public String toString() {
        return "ModificationHotel [objet=" + objet + ", operation=" + operation + "]";
    }

    

    
    /*//tous les operation......
     * if(id=1&&objet user){
     * 
     * }if(id=1&&objet chambre){}
     * 
     * 

     * 
     */




    
}

package Model;
public class ModificationHotel<T,O> {

    private int id;// de user,chambre,reservation
    private T objet;// user,chambre,reservation
    private O operation;//AJOUT,SUPPRESSION,MODIFICATION
    private static int nb=0;
    

    public ModificationHotel(int id, T objet, O operation) {
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
    public O getOperation() {
        return operation;
    }
    public void setOperation(O operation) {
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
    
}

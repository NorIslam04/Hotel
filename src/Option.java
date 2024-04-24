enum Rooms_Options{
    SOLO,
	DOUBLE,
	TRIPLE,
	SUITE,
	SONA,
	TERASSE,
	VUESURMERE,
	VUESURFORET;

    public String toString() {
        switch (this) {
            case SOLO:
                return "SOLO";
            case DOUBLE:
                return "DOUBLE";
            case TRIPLE:
                return "TRIPLE";
            case SUITE:
                return "SUITE";
            case SONA:
                return "SONA";
            case TERASSE:
                return "TERASSE";
            case VUESURMERE:
                return "VUESURMERE";
            case VUESURFORET:
                return "VUESURFORET";
            default:
                return "error";
        }
    }

    public static Rooms_Options ToTypeChambre(String str) {
        switch (str) {
            case "SOLO":
                return SOLO;
            case "DOUBLE":
                return DOUBLE;
            case "TRIPLE":
                return TRIPLE;
            case "SUITE":
                return SUITE;
            case "SONA":
                return SONA;
            case "TERASSE":
                return TERASSE;
            case "VUESURMERE":
                return VUESURMERE;
            case "VUESURFORET":
                return VUESURFORET;
            default:
                throw new IllegalStateException("Type de chambre inconnu : " + str);
        }
    }
    
}

public class Option {
    private Rooms_Options rooms_Options;
    private Double prix_option;
    private int id;
    private static int nb=0;

    public Option(Rooms_Options rooms_Options, Double prix_option,int id) {
        this.rooms_Options = rooms_Options;
        this.prix_option = prix_option;
        this.id=id;
        nb++;
    }

    

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public static int getNb() {
        return nb;
    }



    public static void setNb(int nb) {
        Option.nb = nb;
    }



    public Rooms_Options getRooms_Options() {
        return rooms_Options;
    }
    public void setRooms_Options(Rooms_Options rooms_Options) {
        this.rooms_Options = rooms_Options;
    }
    public Double getPrix_option() {
        return prix_option;
    }
    public void setPrix_option(Double prix_option) {
        this.prix_option = prix_option;
    }
    
}

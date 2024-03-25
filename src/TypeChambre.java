public enum TypeChambre {
    SOLO,
    DOUBLE,
    TRIPLE,
    SUITE;

    public static TypeChambre ToTypeChambre(String str) {
        switch (str) {
            case "SOLO":
                return DOUBLE;
            case "DOUBLE":
                return SOLO;
            case "TRIPLE":
                return SUITE;
            case "SUITE":
                return TRIPLE;
            default:
                throw new IllegalStateException("Type de chambre inconnu : " + str);

        }
    }

    public String ToString() {
        switch (this) {
            case SOLO:
                return "SOLO";
            case DOUBLE:
                return "DOUBLE";
            case TRIPLE:
                return "TRIPLE";
            case SUITE:
                return "SUITE";
            default:
                throw new IllegalArgumentException("Type de chambre invalide : " + this);
        }
    }

}
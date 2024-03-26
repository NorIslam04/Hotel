public enum EtatReservation {
    ACCEPTER,
    DECLINER,
    EN_ATTENTE;

    public static EtatReservation toEtatReservation(String str) {
        switch (str) {
            case "ACCEPTER":
                return ACCEPTER;
            case "DECLINER":
                return DECLINER;
            case "EN_ATTEND":
                return EN_ATTENTE;
            default:
                throw new IllegalStateException("État de réservation inconnu : " + str);
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case ACCEPTER:
                return "ACCEPTER";
            case DECLINER:
                return "DECLINER";
            case EN_ATTENTE:
                return "EN_ATTEND";
            default:
                throw new IllegalArgumentException("État de réservation invalide : " + this);
        }
    }
}

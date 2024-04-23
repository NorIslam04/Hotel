import java.time.LocalDate;
import java.util.Map.Entry;

class Date_nonvalid extends Exception {
    private String message = "Dates invalide !";

    public String getMessage() {
        return message;
    }
}

class Date_nonorganiser extends Exception {
    private String message = "Dates non organisées !";

    public String getMessage() {
        return message;
    }
}

class DiffSup365 extends Exception {
    private String message = "le nombre de jours de réservation était supérieure à 365 jours, contactez la direction de l'hôtel.";

    public String getMessage() {
        return message;
    }
}

class Date_Debut_Reservation extends Exception {
    private String message = "Votre date de réservation est déjà passée !";

    public String getMessage() {
        return message;
    }
}

class Date_syntaxe extends Exception {
    private String message = "erreur dans la syntaxe de la date ! -> syntaxe: (JJ/MM/AAAA) ou 2-chiffres pour JJ et MM et 4 pour AAAA ";

    public String getMessage() {
        return message;
    }
}

public class Date {
    private int jour, mois, annee;
    private static int today_jour = LocalDate.now().getDayOfMonth();
    private static int today_mois = LocalDate.now().getMonthValue();
    private static int today_annee = LocalDate.now().getYear();

    public static int getToday_jour() {
        return today_jour;
    }

    public static void setToday_jour(int today_jour) {
        Date.today_jour = today_jour;
    }

    public static int getToday_mois() {
        return today_mois;
    }

    public static void setToday_mois(int today_mois) {
        Date.today_mois = today_mois;
    }

    public static int getToday_annee() {
        return today_annee;
    }

    public static void setToday_annee(int today_annee) {
        Date.today_annee = today_annee;
    }

    public Date(int jour, int mois, int annee) throws Date_nonvalid {
        if (!isValidDate(jour, mois, annee)) {
            throw new Date_nonvalid();
        }
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public static void verif_today_date(Date today, Date dubut_reservation) throws Date_Debut_Reservation {
        if (!Dates_logique(today, dubut_reservation) && !(today.getJour() == dubut_reservation.getJour()
                && today.getAnnee() == dubut_reservation.getAnnee() && today_mois == dubut_reservation.getMois())) {
            throw new Date_Debut_Reservation();
        }
    }

    public static boolean isValidDate(int jour, int mois, int annee) {

        if (jour < 1 || mois < 1 || mois > 12 || annee <= 0) {
            return false;
        }

        if (mois == 2) {

            if ((jour == 29 && !estBissextile(annee)) || (jour > 29)) {
                return false;
            }
        } else if (mois == 4 || mois == 6 || mois == 9 || mois == 11) {

            if (jour > 30) {
                return false;
            }
        } else {

            if (jour > 31) {
                return false;
            }
        }

        return true;
    }

    public static boolean estBissextile(int annee) {
        return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
    }

    public static boolean Dates_logique(Date date_debut, Date date_fin) {
        if (date_debut.annee > date_fin.annee ||
                (date_debut.annee == date_fin.annee && date_debut.mois > date_fin.mois) ||
                (date_debut.annee == date_fin.annee && date_debut.mois == date_fin.mois
                        && date_debut.jour >= date_fin.jour)) {
            return false;
        }
        return true;
    }

    public static int joursDepuisDebutAnnee(Date date) {
        int[] joursParMois = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int jours = date.getJour();

        for (int i = 1; i < date.getMois(); i++) {
            jours += joursParMois[i];
        }

        if (date.getMois() == 2 && estBissextile(date.getAnnee())) {
            jours++;
        }

        return jours;
    }

    public static int differenceEntreDates(Date date_debut, Date date_fin) throws Date_nonorganiser, DiffSup365 {
        if (!Dates_logique(date_debut, date_fin)) {
            throw new Date_nonorganiser();
        }
        if (date_debut.annee != date_fin.annee) {
            int diff1 = 365 - joursDepuisDebutAnnee(date_debut) - joursDepuisDebutAnnee(date_fin) + 1;
            if (date_fin.annee - date_debut.annee > 1) {
                throw new DiffSup365();
            }
            return diff1;
        }

        return joursDepuisDebutAnnee(date_fin) - joursDepuisDebutAnnee(date_debut);
    }

    public static Date Recupere_date(String dateString) throws Date_nonvalid, NumberFormatException, Date_syntaxe {
        try {

            String[] parts_date_debut = dateString.split("/");
            if (!dateString.contains("/")) {
                throw new Date_syntaxe();
            }
            int jourInt = Integer.parseInt(parts_date_debut[0]);
            int moisInt = Integer.parseInt(parts_date_debut[1]);
            int anneeInt = Integer.parseInt(parts_date_debut[2]);

            return new Date(jourInt, moisInt, anneeInt);

        } catch (NumberFormatException e) {
            throw new NumberFormatException();

        }

    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    static Reservation Decalage_Date(TypeChambre type) throws Date_nonvalid {// empeut recupirer le id de lachambre et
                                                                             // la date fin

        Date dateMin = new Date(31, 12, 9999);
        Reservation tmp_res = null;

        for (Entry<Integer, Reservation> entry : Hotel.getReservationMap().entrySet()) {
            Reservation reservation = entry.getValue();
            Date currentDateDebut = reservation.getDateFin();
            if (Dates_logique(currentDateDebut, dateMin)) {
                dateMin = currentDateDebut;
                tmp_res = reservation;
            }
        }
        return tmp_res;
    }

    @Override
    public String toString() {
        return this.jour + "/" + this.mois + "/" + this.annee;
    }

    static int comparer(Date date1, Date date2) {
        if (date1.annee < date2.annee) {
            return -1;
        } else {
            if (date1.annee > date2.annee) {
                return 1;
            } else {
                if (date1.mois < date2.mois) {
                    return -1;
                } else {
                    if (date1.mois > date2.mois) {
                        return 1;
                    } else {
                        if (date1.jour < date2.jour) {
                            return -1;
                        } else {
                            if (date1.jour > date2.jour) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
    }

    static boolean DateCoincidePas(Date datedebut1, Date datefin1, Date datedebut2, Date datefin2) {

        if (comparer(datefin1, datedebut2) < 0 || comparer(datefin2, datedebut1) < 0) {//cdt1 =true;cdt2=true;
            return true;
        } else {
            return false;
        }
    }

    static Date StringDateint(String date) throws Date_nonvalid {

        int SlashIndex1 = date.indexOf('/');
        int SlashIndex2 = date.lastIndexOf('/');

        String jourDebutString = date.substring(0, SlashIndex1);
        String moisDebutString = date.substring(SlashIndex1 + 1, SlashIndex2);
        String anneeDebutString = date.substring(SlashIndex2 + 1);

        int jour = Integer.parseInt(jourDebutString);
        int mois = Integer.parseInt(moisDebutString);
        int annee = Integer.parseInt(anneeDebutString);
        return new Date(jour, mois, annee);
    }

    public static Date ajouterJours(int jour, int mois, int annee, int nombreJours) throws Date_nonvalid {

        int[] joursParMois = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (estBissextile(annee)) {
            joursParMois[2] = 29;
        }
        jour = jour + nombreJours;

        while (jour > joursParMois[mois]) {
            jour = jour - joursParMois[mois];
            mois++;

            if (mois > 12) {
                mois = 1;
                annee++;
                if (estBissextile(annee)) {
                    joursParMois[2] = 29;
                } else {
                    joursParMois[2] = 28;
                }
            }
        }

        return new Date(jour, mois, annee);
    }

}

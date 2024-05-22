package Model;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import Model.Chambre.*;
import Control.Control;



public class Reservation {

	private int id;//de hash map
	private int id_user;
	private TypeChambre type;
	private Date dateDebut;
	private Date dateFin;
	private double prix;
	private int id_chambre;
	private EtatReservation etat = EtatReservation.EN_ATTENTE;// new reservation
    public int sup;
    public OptionSupplementaire option;

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

	static int nb = 0;

	public Reservation(int id, int idUser, Date dateFin, Date dateDebut, TypeChambre type, int idChambre,
			EtatReservation etat,double prix,OptionSupplementaire opt){
		this.id = id;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.id_user=idUser;
		this.prix=prix;
		this.id_chambre=idChambre;
		this.etat = etat;
        this.option=opt;
		nb++;
        sup=0;
	}


    

	
	public int getSup() {
        return sup;
    }





    public void setSup(int sup) {
        this.sup = sup;
    }





    public OptionSupplementaire getOption() {
        return option;
    }





    public void setOption(OptionSupplementaire option) {
        this.option = option;
    }





    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public TypeChambre getType() {
		return type;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_chambre() {
		return id_chambre;
	}

	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}

	public void setType(TypeChambre type) {
		this.type = type;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public EtatReservation getEtat() {
		return etat;
	}

	public void setEtat(EtatReservation etat) {
		this.etat = etat;
	}

	public static int getNb() {
		return nb;
	}

	public static void setNb(int nb) {
		Reservation.nb = nb;
	}



	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}


	public static void Bdd_to_hashMap_reservation() throws Exception {

        String query = "SELECT * FROM reservation";

        try {
            Connection connection =Control.connectToMySQL();;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idUser = resultSet.getInt("idUser");
                TypeChambre type = TypeChambre.ToTypeChambre(resultSet.getString("type"));
                String dateDebut = resultSet.getString("dateDebut");
                String dateFin = resultSet.getString("dateFin");
                int idChambre = resultSet.getInt("idChambre");
                EtatReservation etat = EtatReservation.toEtatReservation(resultSet.getString("etat"));
                double prix=resultSet.getDouble("prix");
                Date dd = Date.Recupere_date(dateDebut);
                Date df = Date.Recupere_date(dateFin);
                OptionSupplementaire opt=OptionSupplementaire.tOptionSupplementaire(resultSet.getString("option"));
                Reservation reservation = new Reservation(id, idUser, df, dd, type, idChambre, etat,prix,opt);
                Hotel.AjouterReservationMap(reservation);
                Reservation.setNb(id);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static void hahs_map_bdd () throws SQLException{

		HashMap<Integer, ModificationHotel<?,?>> modificMap = Hotel.getModificationMap();
        Connection connection = Control.connectToMySQL();
        // Parcours de la HashMap et accès à ses éléments
        for (Map.Entry<Integer, ModificationHotel<?,?>> entry : modificMap.entrySet()) {

            Object objet = entry.getValue().getObjet(); // Obtenez l'objet de ModificationHotel (type T)
            Object operation = entry.getValue().getOperation(); // Obtenez l'opération de ModificationHotel (type
                                                                       // O)

                if (objet instanceof Reservation) {
                    Reservation reservation = (Reservation) objet;
                    String res="Reservation";
                    if(operation == TypeOperation.AJOUT) {
                        String insertQuery = "INSERT INTO reservation (idUser, type, dateDebut, dateFin, idChambre, etat,prix,`option`) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                        preparedStatement.setInt(1, reservation.getId_user());
                        preparedStatement.setString(2, reservation.getType().ToString());
                        preparedStatement.setString(3, reservation.getDateDebut().toString());
                        preparedStatement.setString(4, reservation.getDateFin().toString());
                        preparedStatement.setInt(5, reservation.getId_chambre());
                        preparedStatement.setString(6, reservation.getEtat().toString());
                        preparedStatement.setDouble(7, reservation.getPrix());
                        preparedStatement.setString(8, reservation.getOption().toString());
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+res+" / Operation: "+operation);

                    } else if (operation==TypeOperation.MODIFICATION) {
                        int idReservation = reservation.getId();
                        String updateQuery = "UPDATE reservation SET idUser = ?, type = ?, dateDebut = ?, dateFin = ?, idChambre = ?, etat = ?, prix = ?, `option` = ? WHERE id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setInt(1, reservation.getId_user());
                        preparedStatement.setString(2, reservation.getType().toString());
                        preparedStatement.setString(3, reservation.getDateDebut().toString());
                        preparedStatement.setString(4, reservation.getDateFin().toString());
                        preparedStatement.setInt(5, reservation.getId_chambre());
                        preparedStatement.setString(6, reservation.getEtat().toString());
                        preparedStatement.setDouble(7, reservation.getPrix());
                        preparedStatement.setString(8, reservation.getOption().toString());
                        preparedStatement.setInt(9, idReservation);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: " + res + " / Operation: " + operation);

                    } else if (operation.equals(TypeOperation.SUPPRESSION)) {
                        int idReservation = reservation.getId();
                        String deleteQuery = "DELETE FROM reservation WHERE id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                        preparedStatement.setInt(1, idReservation);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+res+" / Operation: "+operation);

                    }
                }
		}
	}

}

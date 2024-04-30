package Model;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import Control.Control;


public class Commentaires {
    private int id;//hashMap
    private String commentaire;
    private String username;
    private int iduser;
    private Date date;
    private static int nb=0;


    public Commentaires(int id, String commentaire, String username, Date date,int iduser) {
        this.id = id;
        this.commentaire = commentaire;
        this.username = username;
        this.iduser=iduser;
        this.date = date;
        nb++;
    }

    

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public int getIduser() {
        return iduser;
    }



    public void setIduser(int iduser) {
        this.iduser = iduser;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static int getNb() {
        return nb;
    }

    public static void setNb(int nb) {
        Commentaires.nb = nb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    void Commentaire(int iduser, String commentaire,Date date) {
       // this.user = Hotel.RechercheuserParId(iduser); hna ikon andna direct l id user
        this.commentaire = commentaire;
        this.date=date;
    }

    public static void Bdd_to_hashMap_commantaire() throws NumberFormatException, Date_nonvalid, Date_syntaxe, deja_presente_bdd{
        String query = "SELECT * FROM commentaires";

        try {
            Connection connection = Control.connectToMySQL();;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idUser = resultSet.getInt("iduser");
                String stringdate = resultSet.getString("date");
                String commantaires=resultSet.getString("commentaires");
                String username=resultSet.getString("username");

                Date date = Date.Recupere_date(stringdate);

                Commentaires commantaire = new Commentaires(id, commantaires, username, date, idUser);
                Hotel.AjouterCommentaireMap(commantaire);
                Commentaires.setNb(id);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void hash_map_bdd () throws SQLException{

         HashMap<Integer, ModificationHotel<?,?>> modificMap = Hotel.getModificationMap();
        Connection connection = Control.connectToMySQL();
        // Parcours de la HashMap et accès à ses éléments
        for (Map.Entry<Integer, ModificationHotel<?,?>> entry : modificMap.entrySet()) {

            Object objet = entry.getValue().getObjet(); // Obtenez l'objet de ModificationHotel (type T)
            Object operation = entry.getValue().getOperation(); // Obtenez l'opération de ModificationHotel (type
                                                                       // O)

                
                if (objet instanceof Commentaires) {
                    Commentaires commentaires = (Commentaires) objet;
                    String cmnt="Commentaire";
                    if(operation == TypeOperation.AJOUT) {
                        String insertQuery = "INSERT INTO commentaires (iduser, date, commentaires, username) VALUES (?, ?, ?, ?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                        preparedStatement.setInt(1, commentaires.getIduser());
                        preparedStatement.setString(2, commentaires.getDate().toString());
                        preparedStatement.setString(3, commentaires.getCommentaire());
                        preparedStatement.setString(4, commentaires.getUsername());
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+cmnt+" / Operation: "+operation);

                    } else if (operation==TypeOperation.MODIFICATION) {
                        int idcmnt = commentaires.getId();
                        String updateQuery = "UPDATE commentaires SET iduser = ?, date = ?, commentaires = ?, username = ? WHERE id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                        preparedStatement.setInt(1, commentaires.getIduser());
                        preparedStatement.setString(2, commentaires.getDate().toString());
                        preparedStatement.setString(3, commentaires.getCommentaire());
                        preparedStatement.setString(4, commentaires.getUsername());
                        preparedStatement.setInt(8, idcmnt);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+cmnt+" / Operation: "+operation);

                    } else if (operation.equals(TypeOperation.SUPPRESSION)) {
                        int idcmnt = commentaires.getId();
                        String deleteQuery = "DELETE FROM commentaires WHERE id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                        preparedStatement.setInt(1, idcmnt);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        System.out.println("Objet: "+cmnt+" / Operation: "+operation);

                    }
                }
            }
    }


}

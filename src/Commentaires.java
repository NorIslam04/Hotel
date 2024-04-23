
public class Commentaires {
    private int id;
    private String commentaire;
    private User user;
    private Date date;

    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private int nbOp = 0;
	static int nb = 0;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    void Commentaire(int iduser, String commentaire,Date date) {
        this.user = Hotel.RechercheuserParId(iduser);
        this.commentaire = commentaire;
        this.date=date;
    }

    public int getNbOp() {
        return nbOp;
    }

    public void setNbOp(int nbOp) {
        this.nbOp = nbOp;
    }

}

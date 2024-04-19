
public class Commentaires {
    private String commentaire;
    private User user;
    private int id;
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

    void Commentaire(int iduser, String commentaire) {
        this.user = Hotel.RechercheuserParId(iduser);
        this.commentaire = commentaire;
    }

    public int getNbOp() {
        return nbOp;
    }

    public void setNbOp(int nbOp) {
        this.nbOp = nbOp;
    }

}

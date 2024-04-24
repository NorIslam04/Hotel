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


}

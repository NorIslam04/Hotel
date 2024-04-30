package Model;
enum Prevoir {
	MODIFICATION,SUPPRESSION,RIEN;	
	}

public class modificationprevus {
Chambre chambre;//id est le mm f le processus de fin de journer j vais parcourir cette liste 
//en faisant le naissaissaire si c une supp j supprime 
//mzel mdrtha le cmntr
private Prevoir prevmodif=Prevoir.RIEN;

private Date datePrevModif;
public modificationprevus(Chambre chambre, Prevoir prevmodif, Date datePrevModif) {
    this.chambre = chambre;
    this.prevmodif = prevmodif;
    this.datePrevModif = datePrevModif;
}
public Date getDatePrevModif() {
    return datePrevModif;
}
public void setDatePrevModif(Date datePrevModif) {
    this.datePrevModif = datePrevModif;
}
public Prevoir getPrevmodif() {
    return prevmodif;
}
public void setPrevmodif(Prevoir prevmodif) {
    this.prevmodif = prevmodif;
}

}

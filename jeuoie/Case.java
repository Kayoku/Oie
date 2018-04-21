package jeuoie;

abstract public class Case
{
    // index de la case du jeu
    protected int i;

    // le joueur qui est sur cette case
    protected Joueur joueur;

    // constructeur de la case
    public Case(int iniIndex, Joueur iniJoueur)
    {
        this.i = iniIndex;
        this.joueur = iniJoueur;
    }

    // constructeur d'une case sans joueur
    public Case(int iniIndex)
    {
        this.i = iniIndex;
        this.joueur = null;
    }

    // retourne le numero de la case
    public int NumCase()
    {
        return this.i;
    }

    // retourne vrai si elle peut être quitté
    public boolean PeutEtreQuitte()
    {
        return true;
    }

    // retourne vrai si un joueur est dans la case
    public boolean EstOccupe()
    {
        return this.joueur != null;
    }

    // retourne le joueur dans la case et retourne null si personne
    public Joueur RetourneJoueur()
    {
        return this.joueur;
    }

    // place le joueur dans cette case
    public void PlaceJoueur(Joueur joueur)
    {
        this.joueur = joueur;
    }

    // laisse un tour se passer
    public void LaisserUnTour()
    {}

    public String afficherCase()
    {
	String caseString;
	if (joueur == null)
	    caseString = "   |";
	else
        {
           int numJoueur = joueur.Id(); 
	   caseString = " "+numJoueur+" |";
        }
        return caseString;
    }

    abstract public void effet(Case[] cases);
}

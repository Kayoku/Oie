package jeuoie;

import static jeuoie.JeuOie.joueurs;

public class Joueur 
{
    protected int casenow;
    protected String nom;
    protected int id;

    // On peut utiliser 2 constructeurs différents
    // Ici on nomme le joueur et on lui attribut une case de départ
    public Joueur (String nom, int id)
    {
        this.nom = nom; //nom du joueur
		this.id = id; //id du joueur
        this.casenow = 0; // id de la case du joueur
    }

    // retourne le nom du joueur
    public String Nom() { return nom; }

    // retourner l'id du joueur
    public int Id() { return id; }

    // retourner la case du joueur
    public int CaseNow() { return casenow; }
    
    // méthode tirageDe qui retourne une valeur entre 1 et 6
    public int tirageDe() 
    { 
        return ((int) (Math.random()*10000) % 6)+1; 
    }
    
    // méthode joue qui permet de faire joueur le joueur
    public void joue(Case[] cases)
    {
        int res = this.tirageDe();                 // on tire le dé!
        int c = this.casenow;                      // ici on récupére le numero de la case actuelle du joueur
        int d = res+c;                             // on récupére le numero de la nouvelle case aprés lancement du dé
        // si le joueur depasse la case 63, il devra reculer d’autant de cases supplémentaires
		if ( d > 63)
		{
			d = 63 -(d-63);
		}
		
        // on affiche les différents paramètres déterminant le déroulement du jeu!
        System.out.print(this.Nom() + " est actuellement à la case " + c + ".");
        System.out.println(" Il lance le dé, et réalise un " +res + "!");  
        System.out.println(this.Nom() + " est maintenant en case " + d);

    	// On avance le joueur sur la prochaine case
    	this.casenow = d;

        // Si la case est déjà occupé, l'oie sur cette case va à mon ancienne case		
		if (cases[d].EstOccupe())
			{
				Joueur oie = cases[d].RetourneJoueur();
				cases[oie.CaseNow()].PlaceJoueur(null);
				cases[c].PlaceJoueur(oie);
			}
		else
			{
				// Sinon, mon ancienne case devient vide
				cases[c].PlaceJoueur(null);
			}
		// On actualise les nouveaux paramètres du joueurs
		cases[d].PlaceJoueur(this);

		// On applique les effets de la case
		cases[d].effet();
	}
}

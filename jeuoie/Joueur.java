package jeuoie;

import static jeuoie.JeuOie.joueurs;

public class Joueur 
{
    protected int casenow;
    protected String nom;
    protected int id;
	protected int bloque = 0;

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
    
	//met bloque à 2 
	public void dormir() { this.bloque=2; }
    // méthode tirageDe qui retourne une valeur entre 1 et 6
    public int tirageDe() 
    { 
        return ((int) (Math.random()*10000) % 6)+1; 
    }

    // méthode qui pemet de mettre une nouvelle case au joueur
    public void placeCase(int new_case) { this.casenow = new_case; } 
    
    // méthode joue qui permet de faire joueur le joueur
    public void joue(Case[] cases)
    {
        if( !cases[this.casenow].PeutEtreQuitte())
		{
			System.out.println(this.nom + " est bloqué il doit attendre que quelqu'un prenne sa place"); 
			return ;
		}
		if ( this.bloque > 0)
		{
			this.bloque --;
			System.out.println(this.nom + " est bloqué il doit attendre "+ this.bloque +" tours"); 
			return;
		}
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

        int new_case = d;
        int old = c;
        // Tant que la nouvelle case, est différente de la courante
        while (new_case != this.casenow)
        {
            // Si la case est déjà occupé, l'oie sur cette case va à mon ancienne case		
		    if (cases[new_case].EstOccupe())
		    	{
		    		Joueur oie = cases[new_case].RetourneJoueur();
                    System.out.println("On échange " + this.id + " et " + oie.Id() + "!"); 
		            cases[new_case].PlaceJoueur(this);
		    		cases[c].PlaceJoueur(oie);
                    if (c != old)
                        cases[old].PlaceJoueur(null);
		    	}
		    // Sinon, mon ancienne case devient vide
		    else
		    	{
		            cases[new_case].PlaceJoueur(this);
		    		cases[old].PlaceJoueur(null);
		    	}

		    // On applique les effets de la case
            old = new_case;
		    new_case = cases[new_case].effet(cases);
        }

        System.out.println(this.Nom() + " est maintenant en case " + d);
	}
}

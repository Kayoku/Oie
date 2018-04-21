package jeuoie;

public class JeuOie 
{
    static boolean fini = false;
    static Joueur[] joueurs;  
    static Case[] cases;
    static int nb_joueur=4;

    public static void main(String[] args) 
    {        
        // initialisation des joueurs en case départ!
        joueurs = new Joueur[nb_joueur]; 

        // constructeur en précisant l'indice de la case
        joueurs[0] = new Joueur("John", 0);
        joueurs[1] = new Joueur("Paul", 1);
        joueurs[2] = new Joueur("George", 2);
        joueurs[3] = new Joueur("Ringo", 3);

        // initialisation des cases
        initialiserCases();

        // jeu
		int cpt = 0;
        while( true )
        {
            joueurs[cpt].joue(cases);
            afficherPlateau();
			cpt = (cpt + 1 )% nb_joueur;
			//on regarde si la case 63 est occupé
			if ( cases[63].EstOccupe()) 
				//on quitte le while et le jeu se finit
				{
					System.out.println(" le gagnant est : " + cases[63].RetourneJoueur().Nom() + "!");  
					break;
				}	
        }
    }
    
	//permet d'initialiser toutes les cases avec leurs spécificités 
    static void initialiserCases()
    {
        cases = new Case[64];

        // paramétrage des cases "normales" et donc de la case départ!
        for (int i =0; i<64; i++)
            cases[i] = new NormalCase(i);

        // Première case
    	cases[0] = new PremiereCase(0, joueurs);

        // case attendre deux tours
        cases[19] = new AttendreCase(19);
        
		//case bloquante
		cases[31] = new BloqueCase(31);
		cases[52] = new BloqueCase(52);
        
        // case aller a une case précise
        cases[6] = new AllerCase(6,12);
        cases[42] = new AllerCase(42,30);
		cases[58] = new AllerCase(58,0);
    };

	// on affiche le plateau
    static void afficherPlateau()
    {
    	for (int i = 0 ; i < cases.length ; i++)
		{
    	    System.out.print(cases[i].afficherCase());
		}
		System.out.println();
    }
}

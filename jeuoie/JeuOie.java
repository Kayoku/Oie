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
        joueurs[0] = new Joueur("José", 0);
        joueurs[1] = new Joueur("Maurice", 1);
        joueurs[2] = new Joueur("Loulou", 2);
        joueurs[3] = new Joueur("Jacquie", 3);

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
    
    static void initialiserCases()
    {
        cases = new Case[64];

        // paramétrage des cases "normales" et donc de la case départ!
        for (int i =0; i<64; i++)
            cases[i] = new NormalCase(i);

        // Première case
    	cases[0] = new PremiereCase(0);

        // case attendre un tour
        cases[17] = new AttendreCase(17);
        cases[24] = new AttendreCase(24);
        
        // cases reculer de k cases
        cases[29] = new ReculeCase(29);
        cases[50] = new ReculeCase(50);
        
        // cases avancer de k cases
        cases[4] = new AvanceCase(4);
        cases[40] = new AvanceCase(40);
        cases[56] = new AvanceCase(56);
        
        // case aller a une case précise
        cases[1] = new AllerCase(1,12);
        cases[27] = new AllerCase(27,35);
    };

    static void afficherPlateau()
    {
    	for (int i = 0 ; i < cases.length ; i++)
    	    System.out.print(cases[i].afficherCase());
    	System.out.println();
    }
}

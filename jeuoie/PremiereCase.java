package jeuoie;

import java.util.ArrayList;

public class PremiereCase extends Case 
{
    protected ArrayList<Joueur> joueurs;

    // constructeur d'une case sans joueur
    public PremiereCase(int iniIndex)
    {
        super(iniIndex);
        joueurs = new ArrayList<Joueur>();
    }

    @Override
    public void PlaceJoueur(Joueur joueur)
    {
    	if (joueur != null)
           joueurs.add(joueur); 
    	else
    	{
                // Ici on doit enlever un joueur de la liste
    	}
    }

    @Override
    public void effet()
    {
        System.out.println("Case de début, il ne se passe rien");
    }

    @Override
    public String afficherCase()
    {
        String stringCase = "";
	    for (int i = 0 ; i < joueurs.size() ; i++)
	        stringCase += joueurs.get(i).Id() + "/";
	    return stringCase+" |";
    }
}

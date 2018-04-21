package jeuoie;

import java.util.ArrayList;

public class PremiereCase extends Case 
{
    protected ArrayList<Joueur> joueurs;

    // constructeur d'une case sans joueur
    public PremiereCase(int iniIndex, Joueur[] js)
    {
        super(iniIndex);
        joueurs = new ArrayList<Joueur>();
        for (int i = 0 ; i < js.length ; i++)
            joueurs.add(js[i]);
    }

    @Override
    public void PlaceJoueur(Joueur joueur)
    {
    	if (joueur != null)
        {
            joueurs.add(joueur); 
            joueur.placeCase(this.i);
        }

        // Ici on doit enlever un joueur de la liste
        for (int i = 0 ; i < joueurs.size() ; i++)
            if (joueurs.get(i).CaseNow() > 0)
                joueurs.remove(i);
    }

    @Override
    public void effet(Case[] cases)
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

package jeuoie;

public class AllerCase extends Case
{
    // indice de la nouvelle case a atteindre
    protected int n;

    // constructeur de la case
    public AllerCase(int initCase, int num)
    {
        // ce mot clé appelle le constructeur de la classe mère
        super(initCase);

        // ici on paramètre la case sur laquelle on va se rendre!
		n = num;
    }
	//override permet réécrire sur la fonction effet existante.
    @Override
    public void effet(Case[] cases)
    {
		cases[n].PlaceJoueur(this);
		cases[initCase].PlaceJoueur(null);
    }
}

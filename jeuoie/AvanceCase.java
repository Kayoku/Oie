package jeuoie;

public class AvanceCase extends Case
{
    // nombre de case dont le joueur va avancer
    protected int nb;

    // constructeur de la case
    public AvanceCase(int iniIndex, Joueur iniJoueur)
    {
        // ce mot clé appelle le constructeur de la classe mère
        super(iniIndex,iniJoueur);
        // ici on paramètre le nombre de case à avancer!
	nb = 4;
    }

    //constructeur de la case avec moins de paramètres
    public AvanceCase(int iniIndex)
    {
        // ce mot clé appelle le constructeur de la classe mère
        super(iniIndex);
        // ici on paramètre le nombre de case à avancer!
        nb = 4;
    }

    @Override
    public int effet(Case[] cases)
    {
        System.out.println("Case Avance, le joueur doit avancer jusqu'à la case " + nb);
        return this.i + nb;
    }
}

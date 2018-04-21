package jeuoie;

public class AllerCase extends Case
{
    // indice de la nouvelle case a atteindre
    protected int n;

    // constructeur de la case
    public AllerCase(int iniIndex, int num)
    {
        // ce mot clé appelle le constructeur de la classe mère
        super(iniIndex);

        // ici on paramètre la case sur laquelle on va se rendre!
	n = num;
    }

    @Override
    public void effet(Case[] cases)
    {
        System.out.println("Case Aller, on doit faire aller le joueur sur la case à la nouvelle case " + n);
    }
}

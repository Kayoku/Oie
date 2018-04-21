package jeuoie;

public class ReculeCase extends Case
{
    // nombre de cases dont le joueur va reculer
    protected int nb;

    // constructeur de la case
    public ReculeCase(int iniIndex, Joueur iniJoueur)
    {
        // ce mot clé appelle le constructeur de la classe mère
        super(iniIndex,iniJoueur);
        //ici on paramètre nb comme on le souhaite!
        nb = 6;
    }

    //constructeur avec un seul paramètre
    public ReculeCase(int iniIndex)
    {
        super(iniIndex);

        //ici on paramètre nb comme on le souhaite!
        nb = 6;
    }

    @Override
    public void effet()
    {
        System.out.println("Case Recule, le joueur va reculer de " + nb + " cases!");
    }
}

package jeuoie;

public class NormalCase extends Case 
{
    // constructeur de la case
    public NormalCase(int iniIndex, Joueur iniJoueur)
    {
        // ce mot clé appelle le constructeur de la classe mère
        super(iniIndex,iniJoueur);
    }
    
    // constructeur d'une case sans joueur
    public NormalCase(int iniIndex)
    {
        super(iniIndex);
    }

    @Override
    public void effet()
    {
        System.out.println("Case normal, il ne se passe rien");
    }
}

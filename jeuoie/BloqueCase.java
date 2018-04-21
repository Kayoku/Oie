package jeuoie;

public class BloqueCase extends Case
{
    // constructeur de la case
    public BloqueCase(int initCase)
    {
        // ce mot clé appelle le constructeur de la classe mère
        super(initCase);

    }
	
	//override permet réécrire sur la fonction effet existante.
	@Override
	public boolean PeutEtreQuitte()
    {
        return false;
    }
	//override permet réécrire sur la fonction effet existante.
    @Override
    public int effet(Case[] cases)
    {
        System.out.println("Bloque case, il doit attendre que quelqu'un le releves");
        return this.i;
    }
}

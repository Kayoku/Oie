package jeuoie;

public class AttendreCase extends Case {

    // le nombre de tour a attendre
    protected int nb;

    // constructeur avec moins de paramètres
    public AttendreCase(int iniIndex) {
        super(iniIndex);
        nb = 2;
    }
	
	//override permet réécrire sur la fonction effet existante.
    @Override
    public int effet(Case[] cases)
    {
        System.out.println("Case Attendre, le joueur passera les deux prochains tours");
		this.joueur.dormir();
        return this.i;
    }
}

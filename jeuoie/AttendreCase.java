package jeuoie;

public class AttendreCase extends Case {

    // le nombre de tour a attendre
    protected int nb;

    // constructeur de la case
    public AttendreCase(int iniIndex, Joueur iniJoueur){
	super(iniIndex,iniJoueur);
        nb = 1;
    }

    // constructeur avec moins de paramètres
    public AttendreCase(int iniIndex) {
        super(iniIndex);
        nb = 1;
    }

    @Override
    public void effet()
    {
        System.out.println("Case Attendre, le joueur passera son prochain tour");
    }
}

//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
/**
 * Classe qui représente une file d'attente de visiteurs.
 */
public class File {
    private Noeud premier;
    private int nbElements;

    /**
     * Constructeur de la classe File.
     */
    public File() {
        this.premier = null;
        this.nbElements = 0;
    }

    /**
     * Vérifie si la file est vide.
     * @return true si la file est vide, false sinon.
     */
    public boolean estVide() {
        return premier == null;
    }

    /**
     * Insère un visiteur au début de la file.
     * @param visiteur Le visiteur à insérer.
     */
    public void insererDebutFile(Visiteur visiteur) {
        Noeud nouveauNoeud = new Noeud(visiteur);
        if (!this.estVide()) {
            nouveauNoeud.setSuivant(premier);
        }
        premier = nouveauNoeud;
        nbElements++;
    }

    /**
     * Insère un visiteur à la fin de la file.
     * @param visiteur Le visiteur à insérer.
     */
    public void insererALaFinFile(Visiteur visiteur) {
        Noeud nouveauNoeud = new Noeud(visiteur);
        if (this.estVide()) {
            premier = nouveauNoeud;
        } else {
            Noeud courant = premier;
            while (courant.getSuivant() != null) {
                courant = courant.getSuivant();
            }
            courant.setSuivant(nouveauNoeud);
        }
        nbElements++;
    }

    /**
     * Insère un visiteur à un index spécifié de la file.
     * @param visiteur Le visiteur à insérer.
     * @param index L'index où insérer le visiteur.
     */
    public void insererAuMilieu(Visiteur visiteur, int index) {
        if (index <= 0) {
            insererDebutFile(visiteur);
        } else if (index >= nbElements) {
            insererALaFinFile(visiteur);
        } else {
            Noeud courant = premier;
            for (int i = 0; i < index - 1; i++) {
                courant = courant.getSuivant();
            }
            Noeud nouveauNoeud = new Noeud(visiteur);
            nouveauNoeud.setSuivant(courant.getSuivant());
            courant.setSuivant(nouveauNoeud);
            nbElements++;
        }
    }

    /**
     * Enlève et renvoie le visiteur en tête de la file.
     * @return Le visiteur qui était en tête de la file.
     */
    public Visiteur defiler() {
        if (estVide()) {
            System.out.println("Il n'y a aucun visiteur dans la file");
            return null;
        }
        Visiteur visiteur = premier.getVisiteur();
        premier = premier.getSuivant();
        nbElements--;
        return visiteur;
    }

    /**
     * Récupère le nombre d'éléments dans la file.
     * @return Le nombre d'éléments.
     */
    public int getNbElements() {
        return nbElements;
    }

    /**
     * Récupère le premier nœud de la file.
     * @return Le premier nœud.
     */
    public Noeud getPremier() {
        return premier;
    }

    /**
     * Récupère le nœud à un index spécifié.
     * @param index L'index du nœud à récupérer.
     * @return Le nœud correspondant à l'index.
     */
    public Noeud getNoeud(int index) {
        if (index < 0 || index >= nbElements) {
            return null;
        }
        Noeud courant = premier;
        for (int i = 0; i < index; i++) {
            courant = courant.getSuivant();
        }
        return courant;
    }

    /**
     * Représentation sous forme de chaîne de la file d'attente.
     * @return Une chaîne de caractères représentant la file.
     */
    @Override
    public String toString() {
        String resultat = nbElements + " visiteurs: ";
        Noeud courant = premier;
        while (courant != null) {
            resultat += "[" + courant.getVisiteur().getNom() + ", " + courant.getVisiteur().getAge() + "] -> ";
            courant = courant.getSuivant();
        }
        resultat += "[null]";
        return resultat;
    }
}

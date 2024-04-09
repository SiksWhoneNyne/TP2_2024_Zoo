//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
/**
 * Classe représentant une pile de gardiens.
 * Permet d'empiler et de dépiler des gardiens selon le principe LIFO (Last In, First Out).
 */
public class Pile {
    private static final int TAILLE_INITIALE = 4;
    private Gardien[] gardiens;
    private int nbElements;
    private final int RATIO_AGRANDISEMENT = 2;
    private int capacite;

    /**
     * Constructeur de la classe Pile.
     * Initialise la pile avec une taille initiale et sans éléments.
     */
    public Pile() {
        gardiens = new Gardien[TAILLE_INITIALE];
        nbElements = 0;
        capacite = TAILLE_INITIALE;
    }

    /**
     * Empile un gardien sur la pile.
     *
     * @param gardien Le gardien à empiler.
     */
    public void empiler(Gardien gardien) {
        if (nbElements == capacite) {
            agrandir();
        }
        gardiens[nbElements++] = gardien;
    }

    /**
     * Dépile le gardien au sommet de la pile.
     *
     * @return Le gardien défilé ou null si la pile est vide.
     */
    public Gardien depiler() {
        if (nbElements == 0) {
            return null;
        }
        Gardien gardien = gardiens[--nbElements];
        gardiens[nbElements] = null;
        return gardien;
    }

    /**
     * Agrandit la capacité de la pile lorsque nécessaire.
     */
    private void agrandir() {
        capacite *= RATIO_AGRANDISEMENT;
        Gardien[] nouveauTableau = new Gardien[capacite];
        System.arraycopy(gardiens, 0, nouveauTableau, 0, gardiens.length);
        gardiens = nouveauTableau;
    }

    /**
     * Vérifie si la pile est vide.
     *
     * @return vrai si la pile est vide, faux sinon.
     */
    public boolean estVide() {
        return nbElements == 0;
    }

    /**
     * Retourne le tableau des gardiens dans la pile.
     *
     * @return Tableau de Gardien.
     */
    public Gardien[] getGardiens() {
        return gardiens;
    }

    /**
     * Retourne le nombre d'éléments dans la pile.
     *
     * @return Le nombre d'éléments dans la pile.
     */
    public int getNbElements() {
        return nbElements;
    }

    /**
     * Retourne une représentation en chaîne de la pile.
     *
     * @return La chaîne représentant la pile de gardiens.
     */
    @Override
    public String toString() {
        String resultat = getNbElements() + " gardiens (capacité " + capacite + ") : ";
        if (nbElements == 0) {
            // Ajoute "[null]" pour chaque emplacement dans la pile jusqu'à la capacité totale
            for (int i = 0; i < capacite; i++) {
                resultat += "[null] ";
            }
        } else {
            // Affiche les gardiens présents dans la pile
            for (int i = 0; i < nbElements; i++) {
                resultat += "[" + gardiens[i].getNom() + "(" + gardiens[i].getId() + ") " + gardiens[i].getCompetence() + "] ";
            }
            // Rempli le reste de la capacité de la pile avec "[null]"
            for (int i = nbElements; i < capacite; i++) {
                resultat += "[null] ";
            }
        }
        return resultat.trim();
    }
}

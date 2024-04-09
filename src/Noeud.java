//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
/**
 * Classe représentant un noeud dans une structure de données linéaire (comme une liste liée).
 * Chaque noeud contient un visiteur et un lien vers le noeud suivant.
 */
public class Noeud {
    private Visiteur valeur;
    public Noeud suivant;

    /**
     * Constructeur pour créer un nouveau noeud avec un visiteur.
     *
     * @param valeur Le visiteur associé à ce noeud.
     */
    public Noeud(Visiteur valeur) {
        this.valeur = valeur;
        this.suivant = null;
    }

    /**
     * Retourne la représentation en chaîne de caractères du noeud.
     *
     * @return Une chaîne représentant le visiteur du noeud.
     */
    @Override
    public String toString() {
        return "[" + this.valeur + "]";
    }

    /**
     * Obtient le visiteur contenu dans ce noeud.
     *
     * @return Le visiteur associé à ce noeud.
     */
    public Visiteur getVisiteur() {
        return valeur;
    }

    /**
     * Obtient la valeur (visiteur) de ce noeud.
     *
     * @return La valeur (visiteur) de ce noeud.
     */
    public Visiteur getValeur() {
        return valeur;
    }

    /**
     * Obtient le noeud suivant dans la liste.
     *
     * @return Le noeud suivant.
     */
    public Noeud getSuivant() {
        return suivant;
    }

    /**
     * Définit le noeud suivant dans la liste.
     *
     * @param prochain Le noeud à définir comme le suivant.
     */
    public void setSuivant(Noeud prochain) {
        suivant = prochain;
    }
}

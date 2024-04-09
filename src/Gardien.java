//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
/**
 * Classe représentant un gardien dans le zoo.
 */
public class Gardien {
    private static int dernierId = 999;
    private final String nom;
    private int competence;
    private final int id;

    /**
     * Constructeur pour créer un nouveau gardien.
     *
     * @param nom        Le nom du gardien.
     * @param competence Le niveau de compétence du gardien.
     */
    public Gardien(String nom, int competence) {
        this.nom = nom;
        this.competence = competence;
        ++dernierId;
        this.id = dernierId;
    }

    /**
     * Entraîne un animal en modifiant son poids en fonction du temps passé et augmente les points de compétence du gardien.
     *
     * @param animal L'animal à entraîner.
     * @param temps  La durée de l'entraînement en minutes.
     */
    public void entrainerAnimal(Animal animal, double temps) {
        if (temps < 10) {
            animal.modifierPoids(1.01); // Augmente le poids de 1%
        } else if (temps <= 30) {
            animal.modifierPoids(0.98); // Diminue le poids de 2%
        } else {
            animal.modifierPoids(0.95); // Diminue le poids de 5%
        }
        this.competence++;
        System.out.println("Le Gardien " + this.nom + " a entraine l'animal " + animal.getNom() + " " + Math.round(temps) + " minutes et augmente sa propre compétence.");
    }

    /**
     * Retourne le nom du gardien.
     *
     * @return Le nom du gardien.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le niveau de compétence du gardien.
     *
     * @return Le niveau de compétence du gardien.
     */
    public int getCompetence() {
        return competence;
    }

    /**
     * Retourne l'identifiant du gardien.
     *
     * @return L'identifiant du gardien.
     */
    public int getId() {
        return id;
    }

    /**
     * Fournit une représentation sous forme de chaîne de caractères du gardien.
     *
     * @return Une chaîne de caractères représentant le gardien.
     */
    @Override
    public String toString() {
        return nom + " (" + id + "), " + competence;
    }
}

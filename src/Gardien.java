public class Gardien {
    private static int dernierId = 999;
    private final String nom;
    private final int competence;
    private final int id;

    /**
     * Constructeur pour le gardien.
     * @param nom Le nom du gardien.
     * @param competence Le niveau de compétence du gardien.
     */
    public Gardien(String nom, int competence) {
        this.nom = nom;
        this.competence = competence;
        ++dernierId;
        this.id = dernierId;
    }


    /**
     * @param animal L'animal à entraîner.
     * @param temps La durée de l'entraînement en minutes.
     */
    public void entrainerAnimal(Animal animal, double temps) {
        if (temps < 10) {
            animal.modifierPoids(1.01); // Augmente le poids de 1%
        } else if (temps <= 30) {
            animal.modifierPoids(0.98); // Diminue le poids de 2%
        } else {
            animal.modifierPoids(0.95); // Diminue le poids de 5%
        }
    }

    public String getNom() {
        return nom;
    }

    public int getCompetence() {
        return competence;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return nom + " (" +  id + "), " + competence;
    }
}

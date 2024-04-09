//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
/**
 * Classe représentant un animal avec ses caractéristiques principales.
 */
public class Animal {
    private String nom;
    private String regimeAlimentaire;
    private double poids;
    private Classe classe;
    private String espece;
    private double besoinAlimentaire;

    /**
     * Constructeur pour créer un nouvel animal.
     *
     * @param nom                le nom de l'animal
     * @param regimeAlimentaire  le régime alimentaire de l'animal (carnivore, herbivore, omnivore, piscivore)
     * @param poids              le poids initial de l'animal en kilogrammes
     * @param classe             la classe de l'animal (e.g. mammifère, oiseau, reptile, etc.)
     * @param espece             l'espèce spécifique de l'animal
     */
    public Animal(String nom, String regimeAlimentaire, double poids, Classe classe, String espece) {
        this.nom = nom;
        this.regimeAlimentaire = regimeAlimentaire;
        this.poids = poids;
        this.classe = classe;
        this.espece = espece;
        this.besoinAlimentaire = calculerBesoinAlimentaire();
    }

    /**
     * Calcule le besoin alimentaire de l'animal en fonction de son régime et de son poids.
     *
     * @return le besoin alimentaire quotidien de l'animal en kilogrammes
     */
    private double calculerBesoinAlimentaire() {
        return switch (regimeAlimentaire.toLowerCase()) {
            case "carnivore" -> poids * 0.05;
            case "herbivore" -> poids * 0.03;
            case "omnivore" -> poids * 0.02;
            case "piscivore" -> poids * 0.01;
            default -> 0;
        };
    }

    /**
     * Modifie le poids de l'animal et recalcule son besoin alimentaire.
     *
     * @param facteur le facteur de modification du poids (e.g. 1.1 pour augmenter de 10%)
     */
    public void modifierPoids(double facteur) {
        poids *= facteur;
        besoinAlimentaire = calculerBesoinAlimentaire();
    }

    // Getters et Setters

    public String getNom() {
        return nom;
    }

    public String getRegimeAlimentaire() {
        return regimeAlimentaire;
    }

    public double getPoids() {
        return poids;
    }

    public Classe getClasse() {
        return classe;
    }

    public String getEspece() {
        return espece;
    }

    public double getBesoinAlimentaire() {
        return besoinAlimentaire;
    }

    /**
     * Met à jour le poids de l'animal et recalcul son besoin alimentaire.
     *
     * @param poids le nouveau poids de l'animal en kilogrammes
     */
    public void setPoids(double poids) {
        this.poids = poids;
        this.besoinAlimentaire = calculerBesoinAlimentaire();
    }

    /**
     * Représentation textuelle de l'animal comprenant son nom, espèce, poids et besoin alimentaire.
     *
     * @return une chaîne de caractères décrivant l'animal
     */
    @Override
    public String toString() {
        return String.format("Le %s nommé %s pèse %.1f kg et son besoin alimentaire %s est de %.1f kg.",
                espece.toLowerCase(), nom, poids, regimeAlimentaire.toLowerCase(), besoinAlimentaire);
    }
}

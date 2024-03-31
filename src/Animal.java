public class Animal {
    private String nom;
    private String regimeAlimentaire;
    private double poids;
    private Classe classe; // Supposons que Classe est une énumération des classes d'animaux
    private String espece;
    private double besoinAlimentaire;

    public Animal(String nom, String regimeAlimentaire, double poids, Classe classe, String espece) {
        this.nom = nom;
        this.regimeAlimentaire = regimeAlimentaire;
        this.poids = poids;
        this.classe = classe;
        this.espece = espece;
        this.besoinAlimentaire = calculerBesoinAlimentaire();
    }

    private double calculerBesoinAlimentaire() {
        switch (regimeAlimentaire.toLowerCase()) {
            case "carnivore":
                return poids * 0.05;
            case "herbivore":
                return poids * 0.03;
            case "omnivore":
                return poids * 0.02;
            case "piscivore":
                return poids * 0.01;
            default:
                return 0;
        }
    }

    // Getters
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

    // Setter pour le poids, au cas où l'animal prend ou perd du poids
    public void setPoids(double poids) {
        this.poids = poids;
        this.besoinAlimentaire = calculerBesoinAlimentaire(); // Mise à jour du besoin alimentaire
    }

    @Override
    public String toString() {
        return String.format("%s nommé %s pèse %.1f kg et son besoin alimentaire %s de %.1f kg.",
                classe.name().toLowerCase(), nom, poids, regimeAlimentaire, besoinAlimentaire);
    }
}

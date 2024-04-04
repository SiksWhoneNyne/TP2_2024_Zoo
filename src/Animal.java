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

    public void modifierPoids(double facteur) {
        this.poids *= facteur;
        this.besoinAlimentaire = calculerBesoinAlimentaire(); // Recalcule le besoin alimentaire après modification du poids
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

    // Setter pour le poids, si l'animal prend ou perd du poids
    public void setPoids(double poids) {
        this.poids = poids;
        this.besoinAlimentaire = calculerBesoinAlimentaire(); // Mise à jour du besoin alimentaire
    }

    @Override
    public String toString() {
        return "Le " + espece.toLowerCase() + " nommé " + nom + " pèse " + String.format("%,.1f", poids) +
                " kg et son besoin alimentaire " + regimeAlimentaire + " de " + String.format("%,.1f", besoinAlimentaire) + " kg.";
    }
}

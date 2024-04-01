public class Veterinaire {
    private String nom;
    private Classe specialite;

    /**
     * Constructeur pour créer un vétérinaire avec un nom et une spécialité.
     *
     * @param nom Le nom du vétérinaire.
     * @param specialite La spécialité du vétérinaire, basée sur l'énumération Classe.
     */
    public Veterinaire(String nom, Classe specialite) {
        this.nom = nom;
        this.specialite = specialite;
    }

    /**
     * Tente de soigner un animal. La capacité de soigner dépend de la spécialité du vétérinaire
     * par rapport à la classe de l'animal.
     *
     * @param animal L'animal à soigner.
     */
    public void soignerAnimal(Animal animal) {
        if (animal.getClasse() == this.specialite) {
            System.out.println("Le vétérinaire " + nom + " spécialisé en " + specialite + " a soigné l'animal " + animal.getNom() + ".");
        } else {
            System.out.println("Le vétérinaire " + nom + " ne peut pas soigner l'animal " + animal.getNom() + " car il n'est pas spécialisé en " + animal.getClasse() + ".");
        }
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public Classe getSpecialite() {
        return specialite;
    }
}

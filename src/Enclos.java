//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
/**
 * Classe représentant un enclos dans un zoo.
 */
public class Enclos {
    private String nom;
    private int capaciteMax;
    private int nombreAnimaux;
    private Animal[] animaux;
    private Veterinaire veterinaire;
    private Gardien gardien;

    /**
     * Constructeur de l'Enclos.
     *
     * @param nom          Le nom de l'enclos.
     * @param capaciteMax  La capacité maximale de l'enclos.
     * @param veterinaire  Le vétérinaire assigné à l'enclos.
     * @param gardien      Le gardien assigné à l'enclos.
     */
    public Enclos(String nom, int capaciteMax, Veterinaire veterinaire, Gardien gardien) {
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.veterinaire = veterinaire;
        this.gardien = gardien;
        this.animaux = new Animal[capaciteMax];
        this.nombreAnimaux = 0;
    }

    /**
     * Ajoute une collection d'animaux à l'enclos.
     *
     * @param lesAnimaux Les animaux à ajouter à l'enclos.
     */
    public void ajouterAnimaux(Animal[] lesAnimaux) {
        for (int i = 0; i < lesAnimaux.length; i++) {
            if (nombreAnimaux < capaciteMax) {
                this.animaux[nombreAnimaux++] = lesAnimaux[i];
            }
        }
    }

    /**
     * Renvoie le nombre d'animaux présents dans l'enclos.
     *
     * @return Le nombre d'animaux.
     */
    public int getNombreAnimaux() {
        return nombreAnimaux;
    }

    /**
     * Renvoie le nom de l'enclos.
     *
     * @return Le nom de l'enclos.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Renvoie le vétérinaire assigné à l'enclos.
     *
     * @return Le vétérinaire.
     */
    public Veterinaire getVeterinaire() {
        return veterinaire;
    }

    /**
     * Renvoie les animaux de l'enclos.
     *
     * @return Un tableau d'animaux.
     */
    public Animal[] getAnimaux() {
        return animaux;
    }

    /**
     * Renvoie le gardien actuel de l'enclos.
     *
     * @return Le gardien.
     */
    public Gardien getGardien() {
        return gardien;
    }

    /**
     * Définit le gardien de l'enclos.
     *
     * @param gardien Le nouveau gardien de l'enclos.
     */
    public void setGardien(Gardien gardien) {
        this.gardien = gardien;
    }

    /**
     * Retourne une représentation textuelle de l'enclos, y compris les informations sur les animaux, le vétérinaire et le gardien.
     *
     * @return Une chaîne de caractères décrivant l'enclos.
     */
    @Override
    public String toString() {
        String result = "L'enclos '" + nom + "' est peuplé avec " + nombreAnimaux + " animaux. ";
        if (gardien != null && veterinaire != null)
            result += "Sa capacité est de " + capaciteMax + " animaux. Le vétérinaire assigné est [" + veterinaire + "]. Le gardien actuel est [" + gardien + "]\n";
        else if (veterinaire == null)
            result += "Sa capacité est de " + capaciteMax + " animaux. Il n'y a aucun vétérinaire assigné! Le gardien actuel est [" + gardien + "]\n";
        else if (gardien == null)
            result += "Sa capacité est de " + capaciteMax + " animaux. Le vétérinaire assigné est [" + veterinaire + "]. Pas de gardien actuellement dans l'enclos.\n";

        result += "Les animaux dans cet enclos:\n";
        for (int i = 0; i < nombreAnimaux; i++) {
            if (animaux[i] != null) { // Assurez-vous que l'animal n'est pas null avant de l'appeler toString()
                result += "\t- " + animaux[i] + "\n";
            }
        }
        return result;
    }
}

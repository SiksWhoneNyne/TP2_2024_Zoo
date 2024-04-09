//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
public class Visiteur {
    private String nom;
    private int age;
    private String[] especes;

    /**
     * Constructeur pour créer un nouveau visiteur.
     *
     * @param nom Le nom du visiteur.
     * @param age L'âge du visiteur.
     * @param especes Les espèces d'animaux que le visiteur souhaite voir.
     */
    public Visiteur(String nom, int age, String[] especes) {
        this.nom = nom;
        this.age = age;
        this.especes = especes;
    }

    /**
     * Permet au visiteur d'entrer dans le zoo.
     *
     * @param zoo Le zoo dans lequel le visiteur entre.
     */
    public void entrerDansZoo(Zoo zoo) {
        System.out.println(this + " est entré dans le zoo " + zoo.getNom() + ".");
    }

    /**
     * Permet au visiteur de quitter le zoo.
     */
    public void quitterZoo() {
        System.out.println(this + " a quitté le zoo.");
    }

    /**
     * Permet au visiteur d'entrer dans un enclos spécifique.
     *
     * @param enclos L'enclos que le visiteur souhaite visiter.
     */
    public void entrerDansEnclo(Enclos enclos) {
        if(enclos != null) {
            System.out.println(this + " est entré dans l'enclos " + enclos.getNom() + ".");
        }
    }

    /**
     * Permet au visiteur de quitter un enclos spécifique.
     *
     * @param enclos L'enclos que le visiteur quitte.
     */
    public void quitterEnclo(Enclos enclos) {
        if(enclos != null) {
            System.out.println(this + " a quitté l'enclos " + enclos.getNom() + ".");
        }
    }

    /**
     * Obtient le nom du visiteur.
     *
     * @return Le nom du visiteur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtient l'âge du visiteur.
     *
     * @return L'âge du visiteur.
     */
    public int getAge() {
        return age;
    }

    /**
     * Obtient les espèces d'animaux que le visiteur souhaite voir.
     *
     * @return Un tableau contenant les noms des espèces.
     */
    public String[] getEspeces() {
        return especes;
    }

    /**
     * Fournit une représentation textuelle d'un visiteur.
     *
     * @return Une chaîne de caractères représentant le visiteur.
     */
    @Override
    public String toString() {
        return "[" + nom + ", " + age + "]";
    }
}

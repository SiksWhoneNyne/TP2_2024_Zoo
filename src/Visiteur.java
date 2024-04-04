public class Visiteur {
    private String nom;
    private int age;
    private String[] especes;

    public Visiteur(String nom, int age, String[] especes) {
        this.nom = nom;
        this.age = age;
        this.especes = especes;
    }

    public void entrerDansZoo(Zoo zoo) {
        System.out.println(this.toString() + " est entré dans le zoo " + zoo.getNom() + ".");
    }

    public void quitterZoo() {
        System.out.println(this.toString() + " a quitté le zoo.");
    }

    public void entrerDansEnclo(Enclos enclos) {
        if(enclos != null) {
            System.out.println(this.toString() + " est entré dans l'enclos " + enclos.getNom() + ".");
        }
    }

    public void quitterEnclo(Enclos enclos) {
        if(enclos != null) {
            System.out.println(this.toString() + " a quitté l'enclos " + enclos.getNom() + ".");
        }
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String[] getEspeces() {
        return especes;
    }

    @Override
    public String toString() {
        return "[" + nom +", " + age + "]";
    }
}
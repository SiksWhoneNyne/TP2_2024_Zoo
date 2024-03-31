public class Visiteur {
    private String nom;
    private int age;
    private int nombreAnimaux;
    private String[] especes;
    private String[] especesSouhaitees;

    public Visiteur(String nom,int age,String[] especes){
        this.nom = nom;
        this.age = age;
        this.especes = especes;
    }

    public void entrerDansZoo(Zoo zoo){
        zoo.arriveeVisiteur(this);
    }

    public void quitterZoo(){

    }

    //getters
    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String[] getEspeces(){
        return especes;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEspecesSouhaitees(String[] especesSouhaitees) {
        this.especesSouhaitees = especesSouhaitees;
    }

    @Override
    public String toString() {
        return "Visiteur{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }

}

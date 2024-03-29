public class Visiteur {
    private String nom;
    private int age;
    private int nombreAnimaux;
    private String[] especes;

    public Visiteur(String nom,int age,String[] especes){
        this.nom = nom;
        this.age = age;
        this.especes = especes;
    }

    public void entrerDansZoo(Zoo zoo){
        zoo.arriveeVisiteur(this);
    }

    //getters
    public String[] getEspeces(){
        return especes;
    }

    public int getAge(){
        return age;
    }
    public String getNom(){
        return nom;
    }

}

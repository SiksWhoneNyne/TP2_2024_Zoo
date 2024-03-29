public class Enclos {
    private String nom;
    private int nombreAnimaux;
    private int capaciteMax;
    private Animal[] animaux;
    private Veterinaire veterinaire;
    private  Gardien gardien;

    public Enclos(String nom,int capaciteMax,Veterinaire veterinaire,Gardien gardien){
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.veterinaire = veterinaire;
        this.gardien = gardien;
    }
}

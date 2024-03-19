public class Enclos {
    private String nom;
    private int nombreAnimaux;
    private int capaciteMax;
    private Animal [] animaux;
    private Veterinaire veterinaire;
    private Gardien gardien;

    // Constructeur ========================================================
    public Enclos (String nom, int capaciteMax, Veterinaire veterinaire, Gardien gardien) {
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.veterinaire = veterinaire;
        this.gardien = gardien;
        this.animaux = new Animal[capaciteMax];
        this.nombreAnimaux = 0;
    }

    // Debut Methodes =======================================================

    public Gardien getGardien() {
        return gardien;
    }

    public Veterinaire getVeterinaire() {
        return veterinaire;
    }

    public void ajouterAnimaux(Animal[] lesAnimaux){

    }

    public int getNombreAnimaux() {
        return nombreAnimaux;
    }
    public getAnimaux(){

    }

    public String toString(){

    }
}

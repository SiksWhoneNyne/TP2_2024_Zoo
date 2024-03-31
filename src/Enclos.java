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

    public void ajouterAnimaux(Animal[] lesAnimaux){
        for (int i = 0; i < lesAnimaux.length; i++) {
            this.animaux[i + nombreAnimaux] = lesAnimaux[i];
        }
    }

    public int getNombreAnimaux(){
        return nombreAnimaux;
    }

    public Veterinaire getVeterinaire(){
        return veterinaire;
    }

    public Animal[] getAnimaux(){
        return animaux;
    }

    public Gardien getGardien(){
        return gardien;
    }
}

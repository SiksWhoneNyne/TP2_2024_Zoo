public class Enclos {
    private String nom;
    private int nombreAnimaux;
    private int capaciteMax;
    private Animal[] animaux;
    private Veterinaire veterinaire;
    private  Gardien gardien;

    //Constructeur de classe Enclos
    public Enclos(String nom,int capaciteMax,Veterinaire veterinaire,Gardien gardien){
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.veterinaire = veterinaire;
        this.gardien = gardien;
        this.animaux = new Animal[capaciteMax];
    }

    public void ajouterAnimaux(Animal[] lesAnimaux){
        for (int i = 0; i < lesAnimaux.length; i++) {
            this.animaux[i + nombreAnimaux] = lesAnimaux[i];
            nombreAnimaux++;
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

    @Override
    public String toString() {
        String result = "L'enclos '" + nom + "' est peuplé avec " + nombreAnimaux + " animaux. Sa capacité est de " + capaciteMax + " animaux.\n";
        result += "Les animaux dans cet enclos:\n";

        for (int i = 0; i < nombreAnimaux; i++) {
            result += "\t- " + animaux[i].toString() + "\n";
        }

        result += "Le vétérinaire assigné est " + veterinaire.toString() + "\n";
        result += "Le gardien actuel est " + gardien.toString() + "\n";
        return result;
    }
}

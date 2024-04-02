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
            this.animaux[nombreAnimaux] = lesAnimaux[i];
            nombreAnimaux++;
        }
    }

    public int getNombreAnimaux(){
        return nombreAnimaux;
    }
    public String getNom() {
        return this.nom;
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

    //setters
    public void setGardien(Gardien gardien){
        this.gardien = gardien;
    }

    @Override
    public String toString() {
        String result = "L'enclos '" + nom + "' est peuplé avec " + nombreAnimaux + " animaux. ";
        if(gardien != null && veterinaire != null)
               result += "Sa capacité est de " + capaciteMax + " animaux." + " Le vétérinaire assigné est [" + veterinaire.toString() + "]." + "Le gardien actuel est [" + gardien.toString() + "] \n" ;
        else if(veterinaire == null)
            result += "Sa capacité est de " + capaciteMax + " animaux." + "Il n'y a aucun vétérinaire assigné! " + "Le gardien actuel est [" + gardien.toString() + "] \n" ;
        else if(gardien == null)
            result += "Sa capacité est de " + capaciteMax + " animaux." + " Le vétérinaire assigné est [" + veterinaire.toString() + "]." + "il n'y a aucun gardien pour cet enclos! \n" ;

        result += "Les animaux dans cet enclos:\n";
        for (int i = 0; i < nombreAnimaux; i++) {
            result += "\t- " + animaux[i].toString() + "\n";
        }

        return result;
    }
}
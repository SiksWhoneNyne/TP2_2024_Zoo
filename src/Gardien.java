public class Gardien {
    private String nom;
    private int competence;
    private int id;
    private static int idDuSuivant = 1000;

    public Gardien(String nom,int competence){
        this.nom = nom;
        this.competence = competence;
        this.id = idDuSuivant++;
    }

    public void entrainerAnimal(Animal animal,double temps){
        if(temps <0 || temps > 60){
            System.out.println("Le temps d'entrainement n'est pas entre 0 et 60 minutes");
            return;
        }

        if(temps < 10){
            animal.setPoids(animal.getPoids() + (animal.getPoids() /100));
        }
        else if(temps >= 10 && temps <= 30){
            animal.setPoids(animal.getPoids() - (animal.getPoids() *2) /100);
        }
        else
            animal.setPoids(animal.getPoids() - (animal.getPoids() *5) /100);
    }
}

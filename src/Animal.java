public class Animal {
  //test
    private String nom;
    private String regimeAlimentaire;
    private double poids;
    private Classe classe;
    private String espece;
    private double besoinAlimentaire;

    public Animal(String nom,String regimeAlimentaire,double poids,Classe classe,String espece){
        this.nom = nom;
        this.regimeAlimentaire = regimeAlimentaire;
        this.poids = poids;
        this.classe = classe;
        this.espece = espece;
    }


    //accesseurs
    public String getEspece(){
        return espece;
    }
    public double getPoids(){
        return poids;
    }

    public double getBesoinAlimentaire() {
        return besoinAlimentaire;
    }

    //mutateurs
    //public double setBesoinAlimentaire(){
        //if(this.espece)
    //}
    public void setPoids(double poids){
        this.poids = poids;
    }
}

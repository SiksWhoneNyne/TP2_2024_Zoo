public class Zoo {
    private String nom;
    private int nombreEnclos;
    private File fileVisiteurs;
    private Gardien[] pileGardiens;
    private Enclos[] lesEnclos;
    private int nombreTotalAnimaux;

    public Zoo(String nom){
        this.nom = nom;
        this.fileVisiteurs = new File();
        this.pileGardiens = new Gardien[0];
        this.lesEnclos = new Enclos[5];
        this.nombreTotalAnimaux = 0;
    }

    public void arriveeVisiteur(Visiteur visiteur){

        if(fileVisiteurs.estVide() || visiteur.getAge() <65){
            fileVisiteurs.insererDebutFile(visiteur);
        }

        else{
            Noeud courant = fileVisiteurs.getPremier();
            int ctn = 0;

            while (courant != null){
                if (courant.getValeur().getAge() >= 65){
                    fileVisiteurs.insererAuMilieu(visiteur,ctn);
                }
                courant = courant.suivant;
                ctn++;
            }
        }

    }
}

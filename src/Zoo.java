public class Zoo {
    private String nom;
    private int nombreEnclos;
    private File fileVisiteurs;
    private Pile pileGardiens;
    private Enclos[] lesEnclos;
    private int nombreTotalAnimaux;

    public Zoo(String nom){
        this.nom = nom;
        this.fileVisiteurs = new File();
        this.pileGardiens = new Pile();
        this.lesEnclos = new Enclos[5];
        this.nombreTotalAnimaux = 0;
    }

    public Gardien retirerGardien(){
        boolean gardienEnFonction = false;
        int nbCompetenceDesGardiens = 0;

        for (int i = 0; i < getPileGardiens().getGardiens().length; i++) {
            if(lesEnclos[i].getGardien().equals(getPileGardiens().getGardiens()[0])){
                gardienEnFonction = true;
            }
        }

        for (int i = 0; i < getPileGardiens().getGardiens().length; i++) {
            nbCompetenceDesGardiens += getPileGardiens().getGardiens()[i].getCompetence();
        }

        if(gardienEnFonction == true && nbCompetenceDesGardiens - getPileGardiens().getGardiens()[0].getCompetence() < 20){
            return null;
        }
        else
            return getPileGardiens().depiler();
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




    public void ajouterGardien(Gardien gardien) {
        pileGardiens.empiler(gardien);
    }

    public boolean ajouterEnclos(Enclos[] enclos) {
        int sommePointsExp = 0;
        for (int i = 0; i < getPileGardiens().getNbElements(); i++) {
            sommePointsExp += getPileGardiens().getGardiens()[i].getCompetence();
        }
        if(sommePointsExp < 20)
            return false;


        for (int i = 0; i < enclos.length; i++) {
            lesEnclos[++nombreEnclos] = enclos[i];
        }

        return true;
    }

    public Visiteur retirerVisiteur(){
       return fileVisiteurs.defiler();
    }

    //getters
    public File getFileVisiteurs(){
        return fileVisiteurs;
    }
    public int getNombreEnclos() {
        return nombreEnclos;
    }

    public Enclos[] getLesEnclos() {
        return lesEnclos;
    }

    public int getNombreTotalAnimaux() {
        return nombreTotalAnimaux;
    }

    public String getNom() {
        return nom;
    }

    public Pile getPileGardiens() {
        return pileGardiens;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Zoo: ").append(nom).append("\n");
        sb.append("Nombre d'enclos: ").append(nombreEnclos).append("\n");
        sb.append("Nombre total d'animaux: ").append(nombreTotalAnimaux).append("\n");
        sb.append("Gardiens: \n").append(pileGardiens).append("\n");
        sb.append("Visiteurs en file: \n").append(fileVisiteurs).append("\n");
        for (Enclos enclos : lesEnclos) {
            if (enclos != null) {
                sb.append(enclos).append("\n");
            }
        }
        return sb.toString();
    }
}

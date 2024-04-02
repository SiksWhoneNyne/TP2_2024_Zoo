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
        int indexEnclos =-1;

        for (int i = 0; i < lesEnclos.length; i++) {
            if(lesEnclos[i].getGardien().equals(getPileGardiens().getGardiens()[0])){
                gardienEnFonction = true;
                indexEnclos = i;
            }
        }

        for (int i = 0; i < pileGardiens.getNbElements(); i++) {
            nbCompetenceDesGardiens += getPileGardiens().getGardiens()[i].getCompetence();
        }

        if(gardienEnFonction == true && nbCompetenceDesGardiens - getPileGardiens().getGardiens()[0].getCompetence() < 20){
            return null;
        }
        else{
            for (int i = 0; i < lesEnclos.length; i++) {
                if(i == indexEnclos){
                    lesEnclos[i].setGardien(null);
                    break;
                }
            }

        }
            return getPileGardiens().depiler();
    }

    public void arriveeVisiteur(Visiteur visiteur){

        if(fileVisiteurs.estVide() || visiteur.getAge() <65){
            fileVisiteurs.insererALaFinFile(visiteur);
        }

        else if(fileVisiteurs.getNbElements() == 1){
            if(fileVisiteurs.getNoeud(0).getVisiteur().getAge() < 65 && visiteur.getAge() >=65)
                fileVisiteurs.insererDebutFile(visiteur);
            else fileVisiteurs.insererALaFinFile(visiteur);
            }
        else if(fileVisiteurs.getNbElements() > 1) {
            Noeud courant = fileVisiteurs.getPremier();
            for (int i = 0;courant!=null; i++) {
                if(courant.getVisiteur().getAge() >= 65){
                    fileVisiteurs.insererAuMilieu(visiteur,i+1);
                    return;
                }
                courant = courant.suivant;
            }
        }
    }




    public void ajouterGardien(Gardien gardien) {
        pileGardiens.empiler(gardien);
    }

    public boolean ajouterEnclos(Enclos[] enclos) {
        int sommePointsExp = 0;
        for (int i = 0; i < enclos.length; i++) {
            sommePointsExp += enclos[i].getGardien().getCompetence();
        }
        if(sommePointsExp < 20)
            return false;


        for (int i = 0; i < enclos.length; i++) {
            lesEnclos[nombreEnclos++] = enclos[i];
            nombreTotalAnimaux += enclos[i].getNombreAnimaux();
            pileGardiens.empiler(enclos[i].getGardien());

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
        StringBuilder sb = new StringBuilder("");
        sb.append("Voici la pile de gardiens: \n").append(pileGardiens).append("\n");
        sb.append("Voici la file des visiteurs: \n" + fileVisiteurs).append("\n");
        for (int i = 0; i < lesEnclos.length; i++) {
            sb.append(lesEnclos[i].toString());
        }

        return sb.toString();
    }
}

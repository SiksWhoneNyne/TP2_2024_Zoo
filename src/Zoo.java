//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
/**
 * Classe représentant un zoo. Cette classe gère les enclos, les gardiens, et les visiteurs du zoo.
 */
public class Zoo {
    private String nom;
    private int nombreEnclos;
    private File fileVisiteurs;
    private Pile pileGardiens;
    private Enclos[] lesEnclos;
    private int nombreTotalAnimaux;

    /**
     * Constructeur de la classe Zoo.
     * @param nom Le nom du zoo.
     */
    public Zoo(String nom){
        this.nom = nom;
        this.fileVisiteurs = new File();
        this.pileGardiens = new Pile();
        this.lesEnclos = new Enclos[5];
        this.nombreTotalAnimaux = 0;
    }

    /**
     * Retire le dernier gardien de la pile de gardiens. Si le gardien est actuellement en fonction dans un enclos, cette méthode s'assure que le retrait du gardien ne compromet pas le niveau de compétence requis pour le zoo.
     * @return Le gardien retiré, ou null si aucun gardien ne peut être retiré.
     */
    public Gardien retirerGardien(){
        boolean gardienEnFonction = false;
        int nbCompetenceDesGardiens = 0;
        int indexEnclos =-1;

        //Vérifier si le gardien est en fonction et garde l'index de son enclos
        for (int i = 0; i < lesEnclos.length; i++) {
            if(lesEnclos[i].getGardien() != null && lesEnclos[i].getGardien().equals(getPileGardiens().getGardiens()[getPileGardiens().getNbElements() -1])){
                gardienEnFonction = true;
                indexEnclos = i;
            }
        }

        //Compter les points de competence des gardiens
        for (int i = 0; i < pileGardiens.getNbElements(); i++) {
            if(getPileGardiens().getGardiens()[i] != null)
                nbCompetenceDesGardiens += getPileGardiens().getGardiens()[i].getCompetence();
        }

        //Vérifie que les points des competence des gardiens sans inclure les points du gardien qu'on enleve soient plus grand que 20
        if(nbCompetenceDesGardiens - getPileGardiens().getGardiens()[pileGardiens.getNbElements() -1] .getCompetence() < 20 && gardienEnFonction){
            System.out.println("On ne peut enlever le gardien [" +  lesEnclos[pileGardiens.getNbElements() -1].getGardien() + "] parce que les points d'expérience < 20");
            return null;
        }
        else{
            for (int i = 0; i < lesEnclos.length; i++) {
                if(i == indexEnclos){
                    System.out.println("On retire le dernier gardien arrivé au zoo: [" + lesEnclos[i].getGardien().toString() + "]");
                    lesEnclos[i].setGardien(null);
                    break;
                }
            }

        }
        return getPileGardiens().depiler();
    }

    /**
     * Ajoute un visiteur à la file d'attente du zoo. Les visiteurs âgés de 65 ans et plus sont priorisés.
     * @param visiteur Le visiteur à ajouter à la file.
     */
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

    /**
     * Ajoute un gardien au zoo et l'assigne à un enclos. Si plusieurs enclos n'ont pas de gardien, le gardien est assigné à l'enclos avec le moins d'animaux.
     * @param gardien Le gardien à ajouter.
     */
    public void ajouterGardien(Gardien gardien) {
        //on ajoute le gardien dans la pile
        pileGardiens.empiler(gardien);
        //tableau qui contient les index des enclos sans gardien
        int[] indexDesEnclosSansGardien = new int[5];
        int positionAAjouterIndex = 0;
        //on parcours tous les enclos et on garde l'index des enclos sans gardien dans la tableau de int
        for (int i = 0; i < nombreEnclos; i++) {
            if(lesEnclos[i].getGardien() == null){
                indexDesEnclosSansGardien[positionAAjouterIndex] = i;
                positionAAjouterIndex++;
            }

        }
        if(positionAAjouterIndex < 1){
            System.out.println("Tous les enclos ont un gardien!");
            return;
        }
        //s'il y a juste un enclos sans gardien, on ajoute le gardien à cet enclos grace au tableau d'index des enclos sans gardien
        if(positionAAjouterIndex == 1){
            lesEnclos[indexDesEnclosSansGardien[0]].setGardien(gardien);
            System.out.println("On ajoute le gardien " + gardien.getNom() + " à l'enclos " + lesEnclos[indexDesEnclosSansGardien[0]].getNom());
        }
        //s'il y a plusieurs enclos sans gardien, on cherche l'enclos sans gardien avec le moins d'animaux et on lui ajoute le gardien
        else {
            Enclos enclosMoinsAnimaux = lesEnclos[indexDesEnclosSansGardien[0]];
            for (int i = 0; i < indexDesEnclosSansGardien.length; i++) {
                if(enclosMoinsAnimaux.getNombreAnimaux() > lesEnclos[indexDesEnclosSansGardien[i]].getNombreAnimaux() ){
                    enclosMoinsAnimaux = lesEnclos[indexDesEnclosSansGardien[i]];
                }
            }
            System.out.println("On ajoute le gardien " + gardien.getNom() + " à l'enclos " + enclosMoinsAnimaux.getNom());
            enclosMoinsAnimaux.setGardien(gardien);
        }

    }

    /**
     * Ajoute un ou plusieurs enclos au zoo.
     * @param enclos Un tableau d'enclos à ajouter au zoo.
     * @return true si les enclos ont été ajoutés avec succès, false autrement.
     */
    public boolean ajouterEnclos(Enclos[] enclos) {
        int sommePointsExp = 0;
        for (int i = 0; i < enclos.length; i++) {
            if(enclos[i].getGardien() != null)
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

    /**
     * Retire le premier visiteur de la file d'attente et le renvoie.
     * @return Le visiteur retiré de la file d'attente.
     */
    public Visiteur retirerVisiteur(){
        return fileVisiteurs.defiler();
    }


    //Getters

    /**
     * @return La file des visiteurs.
     */
    public File getFileVisiteurs(){
        return fileVisiteurs;
    }

    /**
     * @return Le nombre d'enclos dans le zoo.
     */
    public int getNombreEnclos() {
        return nombreEnclos;
    }

    /**
     * @return Un tableau des enclos du zoo.
     */
    public Enclos[] getLesEnclos() {
        return lesEnclos;
    }

    /**
     * @return Le nombre total d'animaux dans le zoo.
     */
    public int getNombreTotalAnimaux() {
        return nombreTotalAnimaux;
    }

    /**
     * @return Le nom du zoo.
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return La pile des gardiens.
     */
    public Pile getPileGardiens() {
        return pileGardiens;
    }

    @Override
    public String toString() {
        String resultat = "Voici la pile de gardiens: \n" + pileGardiens + "\n" +
                "Et la file des visiteurs: \n" + fileVisiteurs + "\n Le zoo est peuplé avec " + getNombreTotalAnimaux() + " animaux. Il y a " + getNombreEnclos() + " enclos. \n";
        for (int i = 0; i < lesEnclos.length; i++) {
            if (lesEnclos[i] != null) {
                resultat += lesEnclos[i].toString();
            }
        }
        return resultat;
    }
}
public class File {
    private Noeud premier;
    private int nbElements;

    public boolean estVide(){
        if(premier == null)
            return true;
        else return false;
    }
    //methodes d'insertion
    public void insererDebutFile(Visiteur visiteur){
        Noeud nouveauNoeud = new Noeud(visiteur);
        if(this.estVide())
            premier = nouveauNoeud;

        else{
                Noeud debutDeLaFile = premier;
                nouveauNoeud.setSuivant(debutDeLaFile);
                premier = nouveauNoeud;

            }
        nbElements++;
    }
    //Methode pour inserer un visiteur a la fin de la file
    public void insererALaFinFile(Visiteur visiteur) {

        if (premier == null){
            insererDebutFile(visiteur);
            return;
      }

        Noeud courant = premier;
        while (courant.getSuivant() != null)
            courant = courant.getSuivant();

        Noeud nouveau = new Noeud(visiteur);
        courant.setSuivant(nouveau);

        ++nbElements;
        return;
    }
    //Methode pour ajouter un visiteur a un endroit précis dans la file
    public void insererAuMilieu(Visiteur visiteur, int index) {
        if (index < 0 || index > nbElements) {
            System.out.println("Index invalide");
            return;
        }

        if (index == 0){
            insererDebutFile(visiteur);
            return;
        }

        else if (index == nbElements){
            insererALaFinFile(visiteur);
            return;
        }


        Noeud avant = getNoeud(index - 1);

        Noeud apres = avant.suivant;
        Noeud nouveau = new Noeud(visiteur);
        avant.setSuivant(nouveau);
        nouveau.setSuivant(apres);
        ++nbElements;
        return;
    }

    //methodes de suppression
    public Visiteur defiler(){
        if(nbElements == 0){
            System.out.println("Il n'y a aucun visiteur dans la file");
            return null;
        }

        if(nbElements == 0){
            Visiteur visiteur = premier.getVisiteur();
            premier = null;
            nbElements--;
            return visiteur;
        }
        else {
            Noeud dernier = getNoeud(nbElements -1);
            Noeud avantDernier = getNoeud(nbElements -2);
            avantDernier.setSuivant(null);
            return dernier.getVisiteur();
        }

    }






    //getters
    public int getNbElements(){
        return nbElements;
    }
    public Noeud getPremier(){
        return premier;
    }
    public Noeud getNoeud(int index) {
        if (index < 0 || index >= nbElements)
            return null;

        Noeud courant = premier;
        int position = 0;
        while (courant != null && position != index) {
            courant = courant.suivant;
            position++;
        }
        return courant;
    }

    public int getIndex(Visiteur visiteur) {
        Noeud courant = premier;
        int index = 0;
        while (courant != null) {
            if (courant.getValeur().equals(visiteur)) {
                return index;
            }
            courant = courant.getSuivant();
            index++;
        }
        return -1;
    }

    public String toString(){
        return "";
    }
}

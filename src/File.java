public class File {
    private Noeud premier;
    private int nbElements;

    public File() {
        this.premier = null;
        this.nbElements = 0;
    }

    public boolean estVide() {
        return premier == null;
    }

    public void insererDebutFile(Visiteur visiteur) {
        Noeud nouveauNoeud = new Noeud(visiteur);
        if (!this.estVide()) {
            nouveauNoeud.setSuivant(premier);
        }
        premier = nouveauNoeud;
        nbElements++;
    }

    public void insererALaFinFile(Visiteur visiteur) {
        Noeud nouveauNoeud = new Noeud(visiteur);
        if (this.estVide()) {
            premier = nouveauNoeud;
        } else {
            Noeud courant = premier;
            while (courant.getSuivant() != null) {
                courant = courant.getSuivant();
            }
            courant.setSuivant(nouveauNoeud);
        }
        nbElements++;
    }

    public void insererAuMilieu(Visiteur visiteur, int index) {
        if (index <= 0) {
            insererDebutFile(visiteur);
        } else if (index >= nbElements) {
            insererALaFinFile(visiteur);
        } else {
            Noeud courant = premier;
            for (int i = 0; i < index - 1; i++) {
                courant = courant.getSuivant();
            }
            Noeud nouveauNoeud = new Noeud(visiteur);
            nouveauNoeud.setSuivant(courant.getSuivant());
            courant.setSuivant(nouveauNoeud);
            nbElements++;
        }
    }

    public Visiteur defiler(){
        if(nbElements == 0){
            System.out.println("Il n'y a aucun visiteur dans la file");
            return null;
        }

        if(nbElements == 1){
            Visiteur visiteur = premier.getVisiteur();
            premier = null;
            nbElements--;
            return visiteur;
        }
        else {
            Noeud premierNoeud = premier;
            premier = premier.getSuivant();
            nbElements--;
            return premierNoeud.getVisiteur();
        }

    }

    public int getNbElements() {
        return nbElements;
    }

    public Noeud getPremier() {
        return premier;
    }

    public Noeud getNoeud(int index) {
        if (index < 0 || index >= nbElements) {
            return null;
        }
        Noeud courant = premier;
        for (int i = 0; i < index; i++) {
            courant = courant.getSuivant();
        }
        return courant;
    }

    @Override
    public String toString() {
        String stringARetourner = nbElements + " visiteurs: ";
        Noeud courant = premier;
        while (courant != null) {
            stringARetourner += "[" + courant.getVisiteur().getNom() + ", " + courant.getVisiteur().getAge() + "] -> ";
            courant = courant.getSuivant();
        }
        stringARetourner += "[null]";
        return stringARetourner;
    }
}
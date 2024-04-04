public class Entree {
    private double prix;
    private int nombreEnclos;
    private Enclos[] lesEnclos;

    public Entree(Visiteur visiteur, Zoo zoo) {
        // Initialisation des variables
        this.nombreEnclos = 0;
        Enclos[] enclosPotentiels = zoo.getLesEnclos();
        this.lesEnclos = new Enclos[zoo.getNombreEnclos()];

        // Parcourir tous les enclos potentiels du zoo
        for (int i = 0; i < zoo.getNombreEnclos(); i++) {
            Enclos enclos = enclosPotentiels[i];
            // Vérifier si le visiteur veut visiter l'enclos et si l'enclos a un gardien
            if (enclos.getGardien() != null && visiteurVeutVisiterEnclos(visiteur, enclos)) {
                this.lesEnclos[nombreEnclos++] = enclos;
            }
        }

        // Calculer le prix
        this.prix = calculerPrix(visiteur, zoo);
    }

    private boolean visiteurVeutVisiterEnclos(Visiteur visiteur, Enclos enclos) {
        for (int i = 0; i < visiteur.getEspeces().length; i++) {
            String especeVisiteur = visiteur.getEspeces()[i];
            for (int j = 0; j < enclos.getAnimaux().length; j++) {
                Animal animal = enclos.getAnimaux()[j];
                if (animal != null && especeVisiteur.equals(animal.getEspece())) {
                    return true;
                }
            }
        }
        return false;
    }

    private double calculerPrix(Visiteur visiteur, Zoo zoo) {
        double prixBase = 10 * this.nombreEnclos + 1 * zoo.getNombreTotalAnimaux();
        if (visiteur.getAge() < 12) {
            return 0;
        } else if ((visiteur.getAge() >= 13 && visiteur.getAge() <= 17) || visiteur.getAge() >= 65) {
            return prixBase * 0.5;
        } else {
            return prixBase;
        }
    }

    public double getPrix() {
        return this.prix;
    }

    public int getNombreEnclos() {
        return this.nombreEnclos;
    }

    public Enclos[] getEnclos() {
        Enclos[] enclosVisibles = new Enclos[this.nombreEnclos];
        for (int i = 0; i < this.nombreEnclos; i++) {
            enclosVisibles[i] = this.lesEnclos[i];
        }
        return enclosVisibles;
    }

    public void afficherEnclos() {
        System.out.print("Ce billet permettra de visiter les " + this.nombreEnclos + " enclos suivants: ");
        for (int i = 0; i < this.nombreEnclos; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(this.lesEnclos[i].getNom());
        }
        System.out.println();
    }
}
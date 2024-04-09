//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
/**
 * Classe représentant l'entrée d'un visiteur dans un zoo.
 */
public class Entree {
    private double prix;
    private int nombreEnclos;
    private final Enclos[] lesEnclos;

    /**
     * Constructeur qui initialise une entrée pour un visiteur donné, en fonction des enclos qu'il souhaite visiter dans le zoo.
     * @param visiteur Le visiteur pour lequel l'entrée est créée.
     * @param zoo Le zoo que le visiteur va visiter.
     */
    public Entree(Visiteur visiteur, Zoo zoo) {
        this.nombreEnclos = 0;
        this.lesEnclos = new Enclos[zoo.getNombreEnclos()];
        // Initialisation des enclos visitables
        for (int i = 0; i < zoo.getNombreEnclos(); i++) {
            if (zoo.getLesEnclos()[i].getGardien() != null && visiteurVeutVisiterEnclos(visiteur, zoo.getLesEnclos()[i])) {
                this.lesEnclos[nombreEnclos] = zoo.getLesEnclos()[i];
                nombreEnclos++;
            }
        }
        calculerPrix(visiteur, zoo);
    }

    /**
     * Vérifie si le visiteur veut visiter l'enclos donné, basé sur les espèces d'animaux qu'il souhaite voir.
     * @param visiteur Le visiteur en question.
     * @param enclos L'enclos à vérifier.
     * @return Vrai si le visiteur veut visiter l'enclos, faux sinon.
     */
    private boolean visiteurVeutVisiterEnclos(Visiteur visiteur, Enclos enclos) {
        for (int i = 0; i < visiteur.getEspeces().length; i++) {
            for (int j = 0; j < enclos.getAnimaux().length; j++) {
                if (enclos.getAnimaux()[j] != null && visiteur.getEspeces()[i].equals(enclos.getAnimaux()[j].getEspece())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Calcule le prix d'entrée pour le visiteur en tenant compte de son âge et du nombre d'enclos qu'il peut visiter.
     * @param visiteur Le visiteur pour lequel le prix est calculé.
     * @param zoo Le zoo qui est visité.
     */
    private void calculerPrix(Visiteur visiteur, Zoo zoo) {
        this.prix = 10 * this.nombreEnclos + zoo.getNombreTotalAnimaux();
        if (visiteur.getAge() < 12) {
            this.prix = 0;
        } else if ((visiteur.getAge() >= 13 && visiteur.getAge() <= 17) || visiteur.getAge() >= 65) {
            this.prix *= 0.5;
        }
    }

    /**
     * Renvoie le prix d'entrée pour le visiteur.
     * @return Le prix d'entrée.
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Renvoie le nombre d'enclos que le visiteur prévoit de visiter.
     * @return Le nombre d'enclos visitables.
     */
    public int getNombreEnclos() {
        return nombreEnclos;
    }

    /**
     * Renvoie les enclos que le visiteur prévoit de visiter.
     * @return Un tableau des enclos visitables.
     */
    public Enclos[] getEnclos() {
        Enclos[] enclosVisibles = new Enclos[this.nombreEnclos];
        for (int i = 0; i < this.nombreEnclos; i++) {
            enclosVisibles[i] = this.lesEnclos[i];
        }
        return enclosVisibles;
    }

    /**
     * Affiche les enclos que le billet permet de visiter.
     */
    public void afficherEnclos() {
        System.out.print("Ce billet permettra de visiter les " + this.nombreEnclos + " enclos suivants: ");
        for (int i = 0; i < this.nombreEnclos; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(this.lesEnclos[i].getNom());
        }
        System.out.println();
    }
}

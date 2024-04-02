public class Entree {
    private double prix;
    private int nombreEnclos;
    private Enclos[] lesEnclos;

    // Constructeur
    public Entree(Visiteur visiteur, Zoo zoo) {
        int nombreEnclosRequis = nombreEnclosRequis(visiteur.getEspeces(), zoo);

        // Calcul du prix
        if (visiteur.getAge() < 12) {
            this.prix = 0;
        } else if (visiteur.getAge() >= 13 && visiteur.getAge() <= 17) {
            this.prix = nombreEnclosRequis * 10 * 0.5;
        } else if (visiteur.getAge() >= 65) {
            this.prix = nombreEnclosRequis * 10 * 0.5;
        } else {
            this.prix = nombreEnclosRequis * 10;
        }

        // Création des enclos pour l'entrée
        this.nombreEnclos = nombreEnclosRequis;
        this.lesEnclos = new Enclos[nombreEnclosRequis];
        int index = 0;
        for (Classe classe : Classe.values()) {
            if (index >= nombreEnclosRequis) {
                break;
            }
            Enclos enclos = zoo.getLesEnclos(classe);
            if (enclos != null && enclos.getGardien() != null) {
                this.lesEnclos[index] = enclos;
                index++;
            }
        }
    }

    // Méthode pour calculer le nombre d'enclos requis en fonction des espèces souhaitées
    private int nombreEnclosRequis(String[] especes, Zoo zoo) {
        int nombreEnclosRequis = 0;
        Enclos[] enclosZoo = zoo.getLesEnclos();
        int i = 0;
        while (i < enclosZoo.length && enclosZoo[i] != null) {
            if (enclosZoo[i].getGardien() != null && enclosZoo[i].contientEspeceDeListe(especes)) {
                nombreEnclosRequis++;
            }
            i++;
        }
        return nombreEnclosRequis;
    }



    // Getter pour le prix de l'entrée
    public double getPrix(){
        return prix;
    }
    public int getNombreEnclos(){
        return nombreEnclos;
    }
    public Enclos[] getEnclos(){
        return lesEnclos;
    }
    public void afficherEnclos(){
        String afficheEnclos = "Les enclos : ";
        for (int i = 0; i < lesEnclos.length; i++) {
            afficheEnclos += afficheEnclos + lesEnclos[i];
        }
    }

    /*
    public void afficherEnclos() {
        int i = 0;
        while (i < lesEnclos.length && lesEnclos[i] != null) {
            System.out.println(lesEnclos[i]);
            i++;
        }
    }
    */
}
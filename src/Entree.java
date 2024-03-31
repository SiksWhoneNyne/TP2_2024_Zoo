public class Entree {
    private int nombreEnclos;
    private Enclos[] lesEnclos;
    private int prix;

    public Entree(Visiteur visiteur,Zoo zoo){
    }
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
}

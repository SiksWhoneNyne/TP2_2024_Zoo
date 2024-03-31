public class Pile {
    private static final int TAILLE_INITIALE = 4;
    private Gardien[] gardiens;
    private int nbElements;

    public Pile() {
        gardiens = new Gardien[TAILLE_INITIALE];
        nbElements = 0;
    }

    public void empiler(Gardien gardien) {
        if (nbElements == gardiens.length) {
            agrandir();
        }
        gardiens[nbElements++] = gardien;
    }

    public Gardien depiler() {
        if (nbElements == 0) {
            return null;
        }
        Gardien gardien = gardiens[--nbElements];
        gardiens[nbElements] = null;
        return gardien;
    }

    private void agrandir() {
        Gardien[] nouveauTableau = new Gardien[gardiens.length * 2];
        for (int i = 0; i < gardiens.length; i++) {
            nouveauTableau[i] = gardiens[i];
        }
        gardiens = nouveauTableau;
    }

    public boolean estVide() {
        return nbElements == 0;
    }

    // Getters
    public Gardien[] getGardiens() {
        return gardiens;
    }

    public int getNbElements() {
        return nbElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pile de Gardiens: \n");
        for (int i = nbElements - 1; i >= 0; i--) {
            sb.append(gardiens[i].getNom()).append("\n");
        }
        return sb.toString();
    }
}

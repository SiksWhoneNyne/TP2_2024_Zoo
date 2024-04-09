import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
class testerFile {
    private Zoo zoo; // Le zoo sur lequel on va effectuer les tests

    //On réinitialise le Zoo pour effectuer nos tests
    @BeforeEach
    void setUp() {
        zoo = new Zoo("Granby"); // Initialisation du zoo pour les tests
    }

    @Test
    void testArriveeVisiteurMoins65Ans() {
        // Créer un visiteur de moins de 65 ans
        Visiteur jeuneVisiteur = new Visiteur("Leandro", 20, new String[]{"Poisson"});
        zoo.arriveeVisiteur(jeuneVisiteur); // Ajout du visiteur dans la file
        // On vérifie que Leandro est bien ajouté à la file d'attente
        assertFalse(zoo.getFileVisiteurs().estVide());
        assertEquals(jeuneVisiteur, zoo.getFileVisiteurs().defiler(), "Leandro doit être le premier dans la file.");
    }

    @Test
    void testArriveeVisiteur65AnsEtPlus() {
        // Créer un visiteur de 65 ans ou plus
        Visiteur visiteurAge = new Visiteur("Wenceslas", 70, new String[]{"Reptile"});
        zoo.arriveeVisiteur(visiteurAge); // Ajout du visiteur âgé dans la file
        // On vérifie que Wenceslas est bien ajouté à la file et prioritaire grace a son âge
        assertFalse(zoo.getFileVisiteurs().estVide());
        assertEquals(visiteurAge, zoo.getFileVisiteurs().defiler(), "Wenceslas devrait être le premier dans la file, car il est prioritaire grace a son age.");
    }

    @Test
    void testOrdreArriveeAvecPriorite() {
        // Créer deux visiteurs, un âgé et un jeune
        Visiteur jeuneVisiteur = new Visiteur("Leandro", 20, new String[]{"Cetace"});
        Visiteur visiteurAge = new Visiteur("Wenceslas", 70, new String[]{"Mammifere"});
        // Ajout des visiteurs dans la file, le jeune en premier
        zoo.arriveeVisiteur(jeuneVisiteur);
        zoo.arriveeVisiteur(visiteurAge);
        // On vérifie que Wenceslas (visiteur âgé) est priorisé devant Leandro
        assertEquals(visiteurAge, zoo.getFileVisiteurs().defiler(), "Wenceslas est plus âgé, donc il passe en priorité devant.");
        assertEquals(jeuneVisiteur, zoo.getFileVisiteurs().defiler(), "Leandro doit suivre Wenceslas dans la file car on respecte la priorité d'âge.");
    }
}
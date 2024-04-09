import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//Noms : Leandro Schoonewolff Cadavid et Mathias Hotoeua Wenceslas
//URL du GitHub: https://github.com/SiksWhoneNyne/TP2_2024_Zoo
//Tp2 version Finale
public class testerPile {
    private Zoo zoo; // Le zoo sur lequel on va effectuer les tests

    //On réinitialise le Zoo pour effectuer nos tests
    @BeforeEach
    void setUp() {
        zoo = new Zoo("zoo");
    }

    @Test
    void testAjouterGardienAEnclosAvecLeMoinsDAnimaux() {
        Enclos[] lesEnclos = new Enclos[Classe.values().length];
        Gardien mmeSkelgaard = new Gardien("Mme. Skelgaard", 10);
        Gardien mmeLyding = new Gardien("Mmm. Lyding", 20);

        //Il y a 3 enclos sans gardiens
        lesEnclos[Classe.Poisson.ordinal()] = new Enclos("Les Poissons", 3, null, mmeSkelgaard);
        lesEnclos[Classe.Cetace.ordinal()] = new Enclos("Les Cétacés", 3, null, mmeLyding);
        lesEnclos[Classe.Reptile.ordinal()] = new Enclos("Les Reptiles", 3, null, null);
        lesEnclos[Classe.Oiseau.ordinal()] = new Enclos("Les Oiseaux", 3, null, null);
        lesEnclos[Classe.Mammifere.ordinal()] = new Enclos("Les Mammifères", 3, null, null);

        Animal simba = new Animal("Simba", "carnivore", 150, Classe.Mammifere, "lion");
        Animal zara = new Animal("Zara", "herbivore", 150, Classe.Mammifere, "zèbre");
        Animal neptune = new Animal("Neptune", "carnivore", 150, Classe.Cetace, "dauphin");
        Animal flipper = new Animal("Flipper", "carnivore", 150, Classe.Cetace, "marsouin");
        Animal polly = new Animal("Polly", "omnivore", 150, Classe.Oiseau, "perroquet");
        Animal apollo = new Animal("Apollo", "omnivore", 150, Classe.Oiseau, "corneille");
        Animal spike = new Animal("Spike", "carnivore", 150, Classe.Poisson, "thon");
        Animal finn = new Animal("Finn", "piscivore", 150, Classe.Poisson, "saumon");
        Animal monty = new Animal("Monty", "carnivore", 150, Classe.Reptile, "python");
        Animal jaws = new Animal("Jaws", "carnivore", 150, Classe.Reptile, "alligator");

        // Ajout d'animaux aux enclos
        lesEnclos[Classe.Poisson.ordinal()].ajouterAnimaux(new Animal[] {spike, finn});
        lesEnclos[Classe.Cetace.ordinal()].ajouterAnimaux(new Animal[] {neptune, flipper});
        lesEnclos[Classe.Reptile.ordinal()].ajouterAnimaux(new Animal[] {monty, jaws});
        lesEnclos[Classe.Mammifere.ordinal()].ajouterAnimaux(new Animal[] {simba, zara});
        lesEnclos[Classe.Oiseau.ordinal()].ajouterAnimaux(new Animal[] {polly});

        zoo.ajouterEnclos(lesEnclos);
        zoo.ajouterGardien(new Gardien("M. Bourassa", 10));
        //test qui vérifie que M.Bourassa est bien ajouté à l'enclos qui a le moins d'animaux ,parmis les enclos sans gardiens, qui est l'enclos des oiseaux
        assertEquals("M. Bourassa", lesEnclos[Classe.Oiseau.ordinal()].getGardien().getNom());
    }

    @Test
    void testAjouterGardienALenclosSansGardien() {
        Enclos[] lesEnclos = new Enclos[Classe.values().length];
        Gardien mmeSkelgaard = new Gardien("Mme. Skelgaard", 10);
        Gardien mmeLyding = new Gardien("Mmm. Lyding", 20);
        Gardien mSmith = new Gardien("M. Smith", 10);
        Gardien mPatel = new Gardien("M. Patel", 5);

        lesEnclos[Classe.Poisson.ordinal()] = new Enclos("Les Poissons", 3, null, mmeSkelgaard);
        lesEnclos[Classe.Cetace.ordinal()] = new Enclos("Les Cétacés", 3, null, mmeLyding);
        lesEnclos[Classe.Reptile.ordinal()] = new Enclos("Les Reptiles", 3, null, mSmith);
        lesEnclos[Classe.Oiseau.ordinal()] = new Enclos("Les Oiseaux", 3, null, mPatel);
        lesEnclos[Classe.Mammifere.ordinal()] = new Enclos("Les Mammifères", 3, null, null);

        Animal simba = new Animal("Simba", "carnivore", 150, Classe.Mammifere, "lion");
        Animal zara = new Animal("Zara", "herbivore", 150, Classe.Mammifere, "zèbre");
        Animal neptune = new Animal("Neptune", "carnivore", 150, Classe.Cetace, "dauphin");
        Animal flipper = new Animal("Flipper", "carnivore", 150, Classe.Cetace, "marsouin");
        Animal polly = new Animal("Polly", "omnivore", 150, Classe.Oiseau, "perroquet");
        Animal apollo = new Animal("Apollo", "omnivore", 150, Classe.Oiseau, "corneille");
        Animal spike = new Animal("Spike", "carnivore", 150, Classe.Poisson, "thon");
        Animal finn = new Animal("Finn", "piscivore", 150, Classe.Poisson, "saumon");
        Animal monty = new Animal("Monty", "carnivore", 150, Classe.Reptile, "python");
        Animal jaws = new Animal("Jaws", "carnivore", 150, Classe.Reptile, "alligator");

        // Ajout d'animaux aux enclos
        lesEnclos[Classe.Poisson.ordinal()].ajouterAnimaux(new Animal[] {spike, finn});
        lesEnclos[Classe.Cetace.ordinal()].ajouterAnimaux(new Animal[] {neptune, flipper});
        lesEnclos[Classe.Reptile.ordinal()].ajouterAnimaux(new Animal[] {monty, jaws});
        lesEnclos[Classe.Mammifere.ordinal()].ajouterAnimaux(new Animal[] {simba, zara});
        lesEnclos[Classe.Oiseau.ordinal()].ajouterAnimaux(new Animal[] {polly,apollo});

        zoo.ajouterEnclos(lesEnclos);
        zoo.ajouterGardien(new Gardien("M. Bourassa", 10));
        //test qui vérifie que M.Bourassa est bien ajouté à l'enclos qui n'a pas de gardien
        assertEquals("M. Bourassa", lesEnclos[Classe.Mammifere.ordinal()].getGardien().getNom());
    }

    @Test
    void testAjouterGardien_NoEnclosureWithoutGuardian() {
        Veterinaire drSmith = new Veterinaire("Dr. Smith", Classe.Poisson);
        Veterinaire drPatel = new Veterinaire("Dr. Patel", Classe.Cetace);
        Veterinaire drGrandbois = new Veterinaire("Dr. Grandbois", Classe.Oiseau);
        Veterinaire drSkelgaard = new Veterinaire("Dr. Skelgaard", Classe.Mammifere);
        Veterinaire drLyding = new Veterinaire("Dr. Lyding", Classe.Reptile);
        // Création de gardiens
        Gardien mSmith = new Gardien("M. Smith", 10);
        Gardien mPatel = new Gardien("M. Patel", 5);
        Gardien mmeGrandbois = new Gardien("Mme. Grandbois", 15);
        Gardien mmeSkelgaard = new Gardien("Mme. Skelgaard", 10);
        Gardien mmeLyding = new Gardien("Mmm. Lyding", 20);
        // Création des animaux
        Animal simba = new Animal("Simba", "carnivore", 150, Classe.Mammifere, "lion");
        Animal zara = new Animal("Zara", "herbivore", 150, Classe.Mammifere, "zèbre");
        Animal neptune = new Animal("Neptune", "carnivore", 150, Classe.Cetace, "dauphin");
        Animal flipper = new Animal("Flipper", "carnivore", 150, Classe.Cetace, "marsouin");
        Animal polly = new Animal("Polly", "omnivore", 150, Classe.Oiseau, "perroquet");
        Animal apollo = new Animal("Apollo", "omnivore", 150, Classe.Oiseau, "corneille");
        Animal spike = new Animal("Spike", "carnivore", 150, Classe.Poisson, "thon");
        Animal finn = new Animal("Finn", "piscivore", 150, Classe.Poisson, "saumon");
        Animal monty = new Animal("Monty", "carnivore", 150, Classe.Reptile, "python");
        Animal jaws = new Animal("Jaws", "carnivore", 150, Classe.Reptile, "alligator");
        // Création d'enclos
        Enclos[] lesEnclos = new Enclos[Classe.values().length];
        lesEnclos[Classe.Poisson.ordinal()] = new Enclos("Les Poissons", 3, drSmith, mSmith);
        lesEnclos[Classe.Cetace.ordinal()] = new Enclos("Les Cétacés", 3, drPatel, mPatel);
        lesEnclos[Classe.Reptile.ordinal()] = new Enclos("Les Reptiles", 3, drLyding, mmeLyding);
        lesEnclos[Classe.Oiseau.ordinal()] = new Enclos("Les Oiseaux", 3, drGrandbois, mmeGrandbois);
        lesEnclos[Classe.Mammifere.ordinal()] = new Enclos("Les Mammifères", 3, drSkelgaard, mmeSkelgaard);

        // Ajout d'animaux aux enclos
        lesEnclos[Classe.Poisson.ordinal()].ajouterAnimaux(new Animal[] {spike, finn});
        lesEnclos[Classe.Cetace.ordinal()].ajouterAnimaux(new Animal[] {neptune, flipper});
        lesEnclos[Classe.Reptile.ordinal()].ajouterAnimaux(new Animal[] {monty, jaws});
        lesEnclos[Classe.Mammifere.ordinal()].ajouterAnimaux(new Animal[] {simba, zara});
        lesEnclos[Classe.Oiseau.ordinal()].ajouterAnimaux(new Animal[] {polly, apollo});

        // Création du zoo avec des enclos
        Zoo granby = new Zoo("Granby");
        granby.ajouterEnclos(lesEnclos);
        // Ajout d'un gardien sans aucun enclos
        Gardien gardien = new Gardien("Gardien Test", 10);

        zoo.ajouterGardien(gardien);
        //je verifie que mon gardien n'a été ajouté a aucun enclos car ils ont tous deja un gardien qui a été ajouté auparavant
        assertEquals("Mme. Skelgaard", lesEnclos[Classe.Mammifere.ordinal()].getGardien().getNom());
        assertEquals("Mmm. Lyding", lesEnclos[Classe.Reptile.ordinal()].getGardien().getNom());
        assertEquals("Mme. Grandbois", lesEnclos[Classe.Oiseau.ordinal()].getGardien().getNom());
        assertEquals("M. Smith", lesEnclos[Classe.Poisson.ordinal()].getGardien().getNom());
        assertEquals("M. Patel", lesEnclos[Classe.Cetace.ordinal()].getGardien().getNom());
    }

}

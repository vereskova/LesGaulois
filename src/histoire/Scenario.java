package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {
    public static void main(String[] args) {
        // Création des personnages Astérix et Minus
        Gaulois asterix = new Gaulois("Astérix", 8);
        Romain minus = new Romain("Minus", 6);

        // Scénario
        System.out.println("Le gaulois Astérix : « Bonjour à tous »");
        minus.parler("UN GAU... UN GAUGAU...");

        System.out.println("Astérix envoie un grand coup dans la mâchoire de Minus");
        minus.recevoirCoup(asterix.getNom().length()); // Simule un coup reçu
        minus.parler("Aïe");

        System.out.println("Astérix envoie un grand coup dans la mâchoire de Minus");
        minus.recevoirCoup(asterix.getNom().length()); // Simule un deuxième coup reçu
        minus.parler("Aïe");

        System.out.println("Astérix envoie un grand coup dans la mâchoire de Minus");
        minus.recevoirCoup(asterix.getNom().length()); // Simule un troisième coup reçu
        minus.parler("J'abandonne...");
    }
}

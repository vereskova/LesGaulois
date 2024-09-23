package personnages;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion = 1;

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + " »");
    }

    private String prendreParole() {
        return "Le gaulois " + nom + " : ";
    }

    // Méthode boirePotion pour augmenter l'effet de la potion
    public void boirePotion(int forcePotion) {
        effetPotion = forcePotion;  // On affecte la force de la potion à l'attribut effetPotion
        parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
    }

    // Méthode frapper modifiée pour prendre en compte l'effet de la potion
    public void frapper(Romain romain) {
        int forceCoup = (force / 3) * effetPotion;  // La force est maintenant affectée par l'effet de la potion
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        romain.recevoirCoup(forceCoup);
    }

    @Override
    public String toString() {
        return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
    }

    public static void main(String[] args) {
        /*// Création du gaulois Astérix
        Gaulois asterix = new Gaulois("Astérix", 8);
        System.out.println(asterix);
        System.out.println("Nom du gaulois : " + asterix.getNom());

        // Vérification de la méthode parler via prendreParole
        System.out.println("\nTest de la méthode parler (qui utilise prendreParole) :");
        asterix.parler("Je suis prêt pour l'aventure !");

        // Création d'un romain pour tester la méthode frapper
        Romain cesar = new Romain("César", 10);

        System.out.println("\nTest de la méthode frapper avant de boire une potion :");
        asterix.frapper(cesar);

        // Test de la méthode boirePotion
        System.out.println("\nTest de la méthode boirePotion :");
        asterix.boirePotion(5);  // On fait boire une potion de force 5

        System.out.println("\nTest de la méthode frapper après avoir bu la potion :");
        asterix.frapper(cesar);  // Maintenant Astérix frappe avec l'effet de la potion
    }*/
    }
}


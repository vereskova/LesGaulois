package personnages;

import java.util.Random;

public class Druide {
    private String nom;
    private int effetPotionMin;
    private int effetPotionMax;
    private int forcePotion = 1; // Attribut forcePotion initialisé à 1

    public Druide(String nom, int effetPotionMin, int effetPotionMax) {
        this.nom = nom;
        this.effetPotionMin = effetPotionMin;
        this.effetPotionMax = effetPotionMax;
        parler("Bonjour, je suis le druide " + nom
                + " et ma potion peut aller d'une force " + effetPotionMin + " à "
                + effetPotionMax + ".");
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + " »");
    }

    private String prendreParole() {
        return "Le druide " + nom + " : ";
    }

    // Méthode pour préparer la potion
    public void preparerPotion() {
        Random random = new Random();
        // Génère un nombre aléatoire entre effetPotionMin et effetPotionMax
        forcePotion = effetPotionMin + random.nextInt(effetPotionMax - effetPotionMin + 1);

        if (forcePotion > 7) {
            parler("J'ai préparé une super potion de force " + forcePotion + ".");
        } else {
            parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion + ".");
        }
    }

    // Méthode booster pour donner une potion à un gaulois
    public void booster(Gaulois gaulois) {
        if (gaulois.getNom().equals("Obélix")) {
            parler("Non, Obélix !... Tu n’auras pas de potion magique !");
            gaulois.parler("Par Bélénos, ce n'est pas juste !");
        } else {
            preparerPotion();
            gaulois.boirePotion(forcePotion);
        }
    }

    
/*
 * public static void main(String[] args) { // Création du druide Panoramix avec
 * une potion dont la force est entre 5 et 10 Druide panoramix = new
 * Druide("Panoramix", 5, 10);
 * 
 * // Préparer la potion et tester plusieurs fois for (int i = 0; i < 5; i++) {
 * // Faire plusieurs tests panoramix.preparerPotion(); }
 * 
 * Gaulois asterix = new Gaulois("Astérix", 8); Gaulois obelix = new
 * Gaulois("Obélix", 10);
 * 
 * System.out.println("\nTest de la méthode booster :");
 * panoramix.booster(asterix); // Astérix peut recevoir une potion
 * panoramix.booster(obelix); // Obélix ne peut pas recevoir de potion } }
 */
}


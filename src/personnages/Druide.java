package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " ~ " + effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}
	
	public int getforcePotion() {
		return forcePotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {
		Random random = new Random();
		int forceDePotion = random.nextInt(effetPotionMin, effetPotionMax);
		if(forceDePotion > 7) parler("J'ai préparé unesuper potion de force" + forceDePotion + ".");
		else parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force" + forceDePotion + ".");
	}
	
	public void booster(Gaulois gaulois) {
		if (getNom() == "Obelix") parler("Non, Obélix !... Tu n’auras pas de potion magique!");
	}
}

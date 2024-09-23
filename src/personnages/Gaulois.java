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
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	
	@Override 
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion="
			+ effetPotion + "]"; }
	 

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		System.out.println("Nom du gaulois : " + asterix.getNom());
		
		// Vérification de la méthode prendreParole via parler
        System.out.println("\nTest de la méthode parler (qui utilise prendreParole) :");
        asterix.parler("Je suis prêt pour l'aventure !");
        
        // Création d'un Romain pour tester la méthode frapper
        Romain cesar = new Romain("César", 10);
        
        System.out.println("\nTest de la méthode frapper :");
        asterix.frapper(cesar);
	}
}

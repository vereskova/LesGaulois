package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
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
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
        if (forceCoup > force) {
            parler("J'abandonne...");
        } else {
            parler("UN GAU... UN GAUGAU...");
        }
    }
	
	public static void main(String[] args) {
		/*
		 * // Création de l'objet Cesar de la classe Romain Romain cesar = new
		 * Romain("César", 10);
		 * 
		 * // Vérification de la méthode prendreParole via parler
		 * System.out.println("Test de la méthode parler (qui utilise prendreParole) :"
		 * ); cesar.parler("Nous allons conquérir la Gaule !");
		 * 
		 * // Vérification de la méthode recevoirCoup
		 * System.out.println("\nTest de la méthode recevoirCoup :");
		 * cesar.recevoirCoup(3); // Réduit la force de César de 3
		 * cesar.recevoirCoup(5); // Réduit encore la force de 5 cesar.recevoirCoup(3);
		 * // Met César KO si la force tombe en dessous de 0
		 */  
		
	}
}

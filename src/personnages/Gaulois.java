package personnages;
import villagegaulois.Musee;
import villagegaulois.Trophee;

public class Gaulois {

	private String nom;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];

	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	
	public void faireUneDonnation(Musee musee) {
        if (nb_trophees > 0) {
            System.out.println("Le gaulois " + nom + " : « Je donne au musée tous mes trophées :");
            for (int i = 0; i < nb_trophees; i++) {
                System.out.println("- " + trophees[i].getEquipement());
                musee.donnerTrophee(this, trophees[i].getEquipement());
            }
            nb_trophees = 0;
        } else {
            System.out.println("Le gaulois " + nom + " n'a pas de trophées à donner.");
        }
    }
	
	
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
//		romain.recevoirCoup(force*effetPotion / 3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}
	
	
	public void boirePotion(int forcePotion) {
		effetPotion += forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée");
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
		}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Hello");
		Romain romain = new Romain("romain", 3);
		asterix.frapper(romain);
		asterix.boirePotion(6);
	}
}

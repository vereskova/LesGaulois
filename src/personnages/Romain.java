package personnages;

public class Romain {
	private String nom;
	private int force;
	private String texte;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force > 0;

		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[Equipement.values().length];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " '" + texte + "' ");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forse_avant = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forse_avant > force;
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		return equipementEjecte;
	}

    private boolean possedeDejaEquipement(Equipement equip) {
        for (int i = 0; i < nbEquipement; i++) {
            if (equipements[i] == equip) {
                return true;
            }
        }
        return false;
    }

    private void equiper(Equipement equip){
        System.out.println("Le soldat " + nom + " s'�quipe avec un " + equip.toString() + " !");
        equipements[nbEquipement] = equip;
        nbEquipement++;
    }

	public void sEquiper(Equipement equip) {
		switch (nbEquipement) {
			case 2:
				System.out.println("Le soldat " + nom + " est d�j� bien prot�g� !");
				break;
			case 1:
                if(possedeDejaEquipement(equip)){
                    System.out.println("Le soldat " + nom + " poss�de d�j� un " + equip.toString() + " !");
                    break;
                }
				else equiper(equip);
                break;
			case 0:
                equiper(equip);
				break;
            default:
                System.out.println("Erreur inattendue dans sEquiper");
                break;
		}
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		//TODO
			int nbEquipementEjecte = 0;
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] == null) {
					continue;
				} else {
					equipementEjecte[nbEquipementEjecte] = equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
		}
		return equipementEjecte;
	}


	public static void main(String[] args) {
		Romain romain = new Romain("Minus", 3);
		System.out.println(romain);
		romain.prendreParole();
		romain.parler("Hello");
		romain.recevoirCoup(1);

		romain.sEquiper(Equipement.CASQUE);
        romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
        romain.sEquiper(Equipement.BOUCLIER);
		romain.recevoirCoup(1);
		romain.recevoirCoup(1);

	}
}

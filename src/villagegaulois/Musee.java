package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;


public class Musee {
    private Trophee[] trophees = new Trophee[200];
    private int nbTrophee = 0;

 
    public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
        if (nbTrophee < trophees.length) {
            trophees[nbTrophee] = new Trophee(gaulois, equipement);
            nbTrophee++;
        } else {
            System.out.println("Le musée est plein !");
        }
    }


    public void afficherTrophees() {
        for (int i = 0; i < nbTrophee; i++) {
            System.out.println("Trophée: " + trophees[i].donnerNom() + " - " + trophees[i].getEquipement());
        }
    }
    
 // méthode “extraireInstructionsOCaml”
    
    public String extraireInstructionsOCaml() {
        StringBuilder sb = new StringBuilder();
        sb.append("let musee = [\n");

        for (int i = 0; i < nbTrophee; i++) {
            Trophee trophee = trophees[i];
            String gauloisNom = trophee.donnerNom(); // Get the name of the Gaulois
            String equipementNom = trophee.getEquipement().toString(); // Get the name of the Equipement

            sb.append("\"").append(gauloisNom).append("\", \"").append(equipementNom).append("\";\n");
        }

        sb.append("]");
        return sb.toString();
    }
}
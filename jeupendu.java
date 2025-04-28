import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JeuPendu {
    private String motSecret;
    private String motAffiche;
    private int essaisRestants;
    private List<Character> lettresProposees;

    public JeuPendu(String motSecret, int essaisMax) {
        this.motSecret = motSecret.toUpperCase();
        this.motAffiche = "_".repeat(motSecret.length());
        this.essaisRestants = essaisMax;
        this.lettresProposees = new ArrayList<>();
    }

    public boolean proposerLettre(char lettre) {
        lettre = Character.toUpperCase(lettre);
        
        if (lettresProposees.contains(lettre)) {
            System.out.println("Cette lettre a déjà été proposée.");
            return false;
        }

        lettresProposees.add(lettre);
        
        // Si la lettre est dans le mot
        if (motSecret.contains(String.valueOf(lettre))) {
            // Mettre à jour le mot affiché
            StringBuilder motTemp = new StringBuilder(motAffiche);
            for (int i = 0; i < motSecret.length(); i++) {
                if (motSecret.charAt(i) == lettre) {
                    motTemp.setCharAt(i, lettre);
                }
            }
            motAffiche = motTemp.toString();
            return true;
        } else {
            essaisRestants--;
            return false;
        }
    }

    public boolean estGagne() {
        return !motAffiche.contains("_");
    }

    public boolean estPerdu() {
        return essaisRestants == 0;
    }

    public String getMotAffiche() {
        return motAffiche;
    }

    public int getEssaisRestants() {
        return essaisRestants;
    }

    public List<Character> getLettresProposees() {
        return lettresProposees;
    }
}

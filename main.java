import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Liste des mots possibles
        String[] mots = {"JAVA", "PENDU", "PROGRAMMATION", "MOT"};
        // Choisir un mot aléatoire parmi la liste
        String motSecret = mots[(int) (Math.random() * mots.length)];

        // Initialiser le jeu avec un mot secret et un nombre d'essais (par exemple 6)
        JeuPendu jeu = new JeuPendu(motSecret, 6);

        Scanner scanner = new Scanner(System.in);

        while (!jeu.estGagne() && !jeu.estPerdu()) {
            System.out.println("\nMot à deviner : " + jeu.getMotAffiche());
            System.out.println("Lettres proposées : " + jeu.getLettresProposees());
            System.out.println("Essais restants : " + jeu.getEssaisRestants());
            System.out.print("Proposez une lettre : ");
            
            char lettre = scanner.next().charAt(0);

            if (!jeu.proposerLettre(lettre)) {
                System.out.println("Lettre incorrecte !");
            }

            if (jeu.estGagne()) {
                System.out.println("Félicitations ! Vous avez deviné le mot : " + motSecret);
            } else if (jeu.estPerdu()) {
                System.out.println("Désolé, vous avez perdu. Le mot était : " + motSecret);
            }
        }

        scanner.close();
    }
}

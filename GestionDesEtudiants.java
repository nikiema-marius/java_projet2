
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class GestionDesEtudiants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre d'etudiants : ");
        int nombreEtudiants = scanner.nextInt();
        scanner.nextLine(); // Consomme le saut de ligne

        // 2. Créer un tableau pour stocker les etudiants
        Etudiant[] etudiants = new Etudiant[nombreEtudiants];

        // 3. Lire les informations des etudiants
        for (int i = 0; i < nombreEtudiants; i++) {
            System.out.println("Entrez les informations pour l'etudiant " + (i + 1) + " :");
            System.out.print("Matricule : ");
            String matricule = scanner.nextLine();
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Prenom : ");
            String prenom = scanner.nextLine();
            System.out.print("Moyenne : ");
            double moyenne = scanner.nextDouble();
            scanner.nextLine();

            etudiants[i] = new Etudiant(matricule, nom, prenom, moyenne);
        }
        Etudiant premierEtudiant = etudiants[0];
        Etudiant dernierEtudiant = etudiants[nombreEtudiants - 1];
        double sommeMoyennes = 0;
        int nbAuMoinsMoyenne = 0;

        StringBuilder etudiantsAdmis = new StringBuilder();
        StringBuilder etudiantsRecales = new StringBuilder();
        StringBuilder etudiantsRattrapage = new StringBuilder();

        // Calculer la somme des moyennes
        for (Etudiant etudiant : etudiants) {
            sommeMoyennes += etudiant.getMoyenne();
        }

        // Calculer la moyenne de la classe
        double moyenneClasse = sommeMoyennes / nombreEtudiants;

        // Catégoriser les etudiants
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getMoyenne() >= moyenneClasse) {
                nbAuMoinsMoyenne++;
            }
            if (etudiant.getMoyenne() >= 10) {
                etudiantsAdmis.append(etudiant.toString()).append("\n");
            } else if (etudiant.getMoyenne() < 7) {
                etudiantsRecales.append(etudiant.toString()).append("\n");
            } else {
                etudiantsRattrapage.append(etudiant.toString()).append("\n");
            }
        }

        // Afficher les statistiques
        System.out.println("Statistiques :");
        System.out.println("a. Premier etudiant : " + premierEtudiant.getNom() + " " + premierEtudiant.getPrenom()
                + " - Moyenne: " + premierEtudiant.getMoyenne());
        System.out.println("b. Dernier etudiant : " + dernierEtudiant.getNom() + " " + dernierEtudiant.getPrenom()
                + " - Moyenne: " + dernierEtudiant.getMoyenne());
        System.out.println("c. Moyenne de la classe : " + moyenneClasse);
        System.out.println("d. Nombre d'etudiants ayant au moins la moyenne de la classe : " + nbAuMoinsMoyenne);
        System.out.println("e. etudiants admis (note >= 10) :\n" + etudiantsAdmis.toString());
        System.out.println("f. etudiants recales (note < 7) :\n" + etudiantsRecales.toString());
        System.out.println(
                "g. etudiants devant passer le rattrapage (7 <= note < 10) :\n" + etudiantsRattrapage.toString());

        // 5. Écrire les résultats dans un fichier
        try (FileWriter writer = new FileWriter("stat.txt")) {
            writer.write("Statistiques :\n");
            writer.write("a. Premier etudiant : " + premierEtudiant.getNom() + " " + premierEtudiant.getPrenom()
                    + " - Moyenne: " + premierEtudiant.getMoyenne() + "\n");
            writer.write("b. Dernier etudiant : " + dernierEtudiant.getNom() + " " + dernierEtudiant.getPrenom()
                    + " - Moyenne: " + dernierEtudiant.getMoyenne() + "\n");
            writer.write("c. Moyenne de la classe : " + moyenneClasse + "\n");
            writer.write("d. Nombre d'etudiants ayant au moins la moyenne de la classe : " + nbAuMoinsMoyenne + "\n");
            writer.write("e. etudiants admis (note >= 10) :\n" + etudiantsAdmis.toString() + "\n");
            writer.write("f. etudiants recales (note < 7) :\n" + etudiantsRecales.toString() + "\n");
            writer.write("g. etudiants devant passer le rattrapage (7 <= note < 10) :\n"
                    + etudiantsRattrapage.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecriture du fichier : " + e.getMessage());
        }

        scanner.close();
    }
}

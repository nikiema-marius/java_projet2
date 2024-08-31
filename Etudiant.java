public class Etudiant {
    private String matricule;
    private String nom;
    private String prenom;
    private double moyenne;

    // Constructeur
    public Etudiant(String matricule, String nom, String prenom, double moyenne) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }

    // Méthodes d'accès (getters)
    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    // Méthode pour obtenir une représentation de l'étudiant en chaîne de caractères
    @Override
    public String toString() {
        return nom + " " + prenom + " (" + matricule + ") - Moyenne: " + moyenne;
    }
}

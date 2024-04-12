package tpcomptebancaire;

import java.util.ArrayList;
import java.util.Scanner;

public class Banques {
    private String name;
    private ArrayList<CompteBancaire> comptes;

    public Banques(String name) {
        this.name = name;
        this.comptes = new ArrayList<>();
    }

    public CompteBancaire creerCompte(String titulaire) {
        CompteBancaire compteBancaire = new CompteBancaire(titulaire);
        compteBancaire.setNumero(comptes.size() + 1);
        comptes.add(compteBancaire);
        return compteBancaire;
    }

    public void ajouterCompte(CompteBancaire compte) {
        if (compte != null) {
            comptes.add(compte);
        }
    }

    public void supprimerCompteInteractif() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro du compte à supprimer :");
        int numero = scanner.nextInt(); // Lisez le numéro du compte

        boolean estSupprime = comptes.removeIf(compte -> compte.getNumero() == numero);
        
        if (estSupprime) {
            System.out.println("Le compte numéro " + numero + " a été supprimé avec succès.");
        } else {
            System.out.println("Aucun compte trouvé avec le numéro " + numero + ".");
        }

        // scanner.close(); // Normalement, on ferme le scanner, mais cela fermera aussi System.in, donc à éviter ici
    }

    public void afficherTousLesComptes() {
        for (CompteBancaire compte : comptes) {
            System.out.println(compte);
        }
    }

    public void afficherClients() {
        for (CompteBancaire compte : comptes) {
            System.out.print(compte.getTitulaire() + " ");
        }
        System.out.print("\n");
    }
}

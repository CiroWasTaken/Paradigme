package banque;

import java.util.Scanner;

public class TestCompteBancaire {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Banque banque = new Banque();

        CompteBancaire compte1 = new CompteBancaire("123456", "Joel Miller", 1000.0);
        CompteBancaire compte2 = new CompteBancaire("654321", "Arthur Morgan", 2000.0);
        CompteBancaire compte3 = new CompteBancaire("111222", "Ellie William", 3000.0);

        banque.ajouterCompte(compte1);
        banque.ajouterCompte(compte2);
        banque.ajouterCompte(compte3);

        System.out.println("Affichage des comptes avant les transactions :");
        banque.afficherComptes();

        Transaction transaction = new Transaction();

        System.out.println("Veuillez entrer le montant du virement de Joel Miller à Arthur Morgan:");
        double montantVirement = scanner.nextDouble();
        transaction.effectuerVirement(compte1, compte2, montantVirement);

        System.out.println("Veuillez entrer le montant du retrait pour Ellie William:");
        double montantRetrait = scanner.nextDouble();
        transaction.effectuerRetrait(compte3, montantRetrait);

        System.out.println("Affichage des comptes après les transactions :");
        banque.afficherComptes();
        
        scanner.close();
    }
}

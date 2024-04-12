package banque;

public class Transaction {

    public void effectuerVirement(CompteBancaire compteSource, CompteBancaire compteDestinataire, double montant) {
        if (compteSource.getSolde() >= montant) {
            compteSource.retirer(montant);
            compteDestinataire.deposer(montant);
            System.out.println("Virement de " + montant + " € effectué de " + compteSource.getTitulaire() + " à " + compteDestinataire.getTitulaire());
        } else {
            System.out.println("Virement échoué : solde insuffisant.");
        }
    }

    public void effectuerRetrait(CompteBancaire compte, double montant) {
        if (compte.getSolde() >= montant) {
            compte.retirer(montant);
            System.out.println("Retrait de " + montant + " € effectué par " + compte.getTitulaire());
        } else {
            System.out.println("Retrait échoué : solde insuffisant.");
        }
    }
}

package banque;

public class CompteBancaire {
    String numero;
    String titulaire;
    double solde;

    public CompteBancaire(String numero, String titulaire, double solde) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = solde;
    }


    public String getNumero() {
        return numero;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println(montant + " € ont été déposés. Nouveau solde: " + solde);
        } else {
            System.out.println("Le montant à déposer doit être positif.");
        }
    }

   public void retirer(double montant) {
	   if (montant > 0) {
		   solde -= montant;
		   System.out.println(montant + " € ont été retirés. Nouveau solde: " + solde);
	   } else {
		   System.out.println("Le montant à retirer doit être positif.");
	   }
   }

    
    public void afficherInfos() {
        System.out.println("Numéro de compte: " + numero);
        System.out.println("Titulaire: " + titulaire);
        System.out.println("Solde: " + solde);
    }
}


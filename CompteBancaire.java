	package tpcomptebancaire;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CompteBancaire {
	private int numero;
	private String titulaire;
	private double solde;
	private int limiteDecouvert = -2000;
	private double tauxInteret = 0.02;
	private int fraisGestion = 10;
	private ArrayList<Transaction> transactions = new ArrayList<>();


	public CompteBancaire(String titulaire) {
		this.numero = numero;
		this.titulaire = titulaire;
		this.solde = solde;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	private void ajouterTransaction(String type, int montant) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        transactions.add(new Transaction(type, montant, formatter.format(date)));
    }

	public void deposer(int depot) {
		if (depot <= 0) {
			System.out.println("Le montant du dépôt doit être positif.");
		} else {
			this.solde = this.solde + depot;
		}
		ajouterTransaction("Dépôt", depot);

	}

	public void appliquerInterets() {
		if (solde > 0) {
			this.solde =  solde * tauxInteret;
		}
	}

	public void preleverFraisGestion() {
		this.solde = this.solde - fraisGestion;
	}

	public void retirer(int retire) {
		if (this.solde >= retire) {
			this.solde = this.solde - retire;
		} else if (retire <= 0) {
			System.out.println("Le montant du retrait doit être positif.");
		} else if (this.solde - retire < limiteDecouvert) {
			System.out.println("Opération refusée. Limite de découvert dépassée.");
		} else {
			System.out.println("Vous n'avez pas assez de fond pour retirer.");
		}
		ajouterTransaction("Retrait", retire);

	}

	public void ajusterLimiteDecouvert(int nouvelleLimite) {
        limiteDecouvert = nouvelleLimite;
    }

	public void transferer(CompteBancaire dest, int montant) {
		if (dest.getNumero() == this.getNumero()) {
			System.out.println("Impossible, compte identique.");
			return;
		} else if (montant <= 0) {
			System.out.println("Le montant du transfert doit être positif.");
		} else if (this.solde < montant) {
			System.out.println("Solde insuffisant pour effectuer le transfert.");
		} else {
			this.retirer(montant);
			dest.deposer(montant);
		}
		ajouterTransaction("Transfert", montant);
	}

	public void Affiche() {
		System.out.println("Titulaire : " + getTitulaire() + " Solde : " + getSolde());
	}

	public void afficherTransactions() {
		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
	}

	public String toString() {
		return "CompteBancaire{" +
				"numero=" + numero +
				", titulaire='" + titulaire + '\'' +
				", solde=" + solde +
				'}';
	}
}

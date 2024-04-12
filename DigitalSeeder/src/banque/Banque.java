package banque;

import java.util.ArrayList;
import java.util.List;

public class Banque {
	private List<CompteBancaire> comptes;

	public Banque() {
		comptes = new ArrayList<>();
	}

	public void ajouterCompte(CompteBancaire compte) {
		comptes.add(compte);
	}

	public void supprimerCompte(String numero) {
		comptes.removeIf(compte -> compte.getNumero().equals(numero));
	}

	public void afficherComptes() {
		System.out.println("Liste des comptes bancaires :");
		for (CompteBancaire compte : comptes) {
			compte.afficherInfos();
			System.out.println();
		}
	}
}

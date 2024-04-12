package tpcomptebancaire;

public class TestCompteBancaire {
	public static void main(String[] args) {

		Banques maNeoBanque = new Banques("Ma Neo Banque");
		CompteBancaire compteMusa = maNeoBanque.creerCompte("Musa");
		compteMusa.setSolde(1);
		CompteBancaire compteLudo = maNeoBanque.creerCompte("Ludo");
		CompteBancaire compteDhassane = maNeoBanque.creerCompte("Dhassane");
		CompteBancaire compteLimane = maNeoBanque.creerCompte("Limane");
		CompteBancaire compteFLorene = maNeoBanque.creerCompte("Florent");

		maNeoBanque.afficherClients();
		compteMusa.Affiche();

	}

}

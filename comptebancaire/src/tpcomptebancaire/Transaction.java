package tpcomptebancaire;
class Transaction {
    private String type;
    private int montant;
    private String date;

    public Transaction(String type, int montant, String date) {
        this.type = type;
        this.montant = montant;
        this.date = date;
    }

    public String toString() {
        return "Transaction{" +
               "type='" + type + '\'' +
               ", montant=" + montant +
               ", date='" + date + '\'' +
               '}';
    }
}

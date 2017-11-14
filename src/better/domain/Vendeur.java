package better.domain;

public class Vendeur extends Seller {

    public Vendeur(String firstname, String lastname, String age, String entryYear, double turnover) {
        super(firstname, lastname, age, entryYear, turnover);
    }

    @Override
    public String getPosition() {
        return "Le vendeur";
    }

    @Override
    protected double getBonus() {
        return 400;
    }
}

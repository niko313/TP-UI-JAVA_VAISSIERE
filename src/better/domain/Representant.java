package better.domain;

public class Representant extends Seller {

    public Representant(String firstname, String lastname, String age, String entryYear, int turnover) {
        super(firstname, lastname, age, entryYear, turnover);
    }

    @Override
    public String getPosition() {
        return "Le représentant";
    }

    @Override
    protected double getBonus() {
        return 800;
    }
}

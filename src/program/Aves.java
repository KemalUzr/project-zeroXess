package program;

public class Aves extends Animals {
    String name;

    public Aves(String amount, String weight, String name) {
        super(amount, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

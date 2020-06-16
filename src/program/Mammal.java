package program;

public class Mammal extends Animals {
    public String name;

    public Mammal(String amount, String weight, String name) {
        super(amount, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

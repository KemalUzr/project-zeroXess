package program;

import program.Animal.Animal;

public class Aves extends Animal {
    String name;

    public Aves(String amount, String weight, String name) {
        super(amount, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

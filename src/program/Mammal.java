package program;

import program.Animal.Animal;

public class Mammal extends Animal {
    public String name;

    public Mammal(String amount, String weight, String name) {
        super(amount, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

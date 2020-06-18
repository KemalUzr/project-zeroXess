package program.Animal;

public class Animal {
    public String amount;
    public String weight;

    public Animal(String amount, String weight) {
        this.amount = amount;
        this.weight = weight;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAmount() {
        return amount;
    }

    public String getWeight() {
        return weight;
    }
}

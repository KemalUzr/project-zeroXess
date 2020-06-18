package program.Animal;

import java.util.ArrayList;

public class Cow extends Animal {
    public static Integer totalCowAmount = 0;
    public ArrayList<Integer> allCowWeight;

    public Cow(String amount, String weight, ArrayList<Integer> allCowWeight) {
        super(amount, weight);
        this.totalCowAmount ++;
        this.allCowWeight = allCowWeight;
    }

    public Integer getTotalCowAmount() {
        return totalCowAmount;
    }

    public ArrayList<Integer> getAllCowWeight() {
        return allCowWeight;
    }
}

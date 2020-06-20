package program.Animal;

import program.Mammal;

import java.util.ArrayList;

public class Cow extends Mammal {
    public static Integer totalCowAmount = 0;
    public ArrayList<Integer> allCowWeight;

    public Cow(String amount, String weight, String name, ArrayList<Integer> allCowWeight) {
        super(amount, weight, name);
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

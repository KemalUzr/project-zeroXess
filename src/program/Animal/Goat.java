package program.Animal;

import program.Mammal;

import java.util.ArrayList;

public class Goat extends Mammal {
    public static Integer totalGoatAmount = 0;
    public ArrayList<Integer> allGoatWeight;

    public Goat(String amount, String weight, String name, ArrayList<Integer> allGoatWeight) {
        super(amount, weight, name);
        this.totalGoatAmount ++;
        this.allGoatWeight = allGoatWeight;
    }

    public Integer getTotalGoatAmount() {
        return totalGoatAmount;
    }

    public ArrayList<Integer> getAllGoatWeight() {
        return allGoatWeight;
    }
}

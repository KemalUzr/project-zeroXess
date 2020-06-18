package program.Animal;

import java.util.ArrayList;

public class Goat extends Animal {
    public static Integer totalGoatAmount = 0;
    public ArrayList<Integer> allGoatWeight;


    public Goat(String amount, String weight, ArrayList<Integer> allChickenWeight) {
        super(amount, weight);
        this.totalGoatAmount ++;
        this.allGoatWeight = allChickenWeight;
    }

    public Integer getTotalGoatAmount() {
        return totalGoatAmount;
    }

    public ArrayList<Integer> getAllGoatWeight() {
        return allGoatWeight;
    }
}

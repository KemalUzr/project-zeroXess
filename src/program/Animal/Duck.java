package program.Animal;

import java.util.ArrayList;

public class Duck extends Animal {
    public static Integer totalDuckAmount = 0;
    public ArrayList<Integer> allDuckWeight;


    public Duck(String amount, String weight, ArrayList<Integer> allChickenWeight) {
        super(amount, weight);
        this.totalDuckAmount ++;
        this.allDuckWeight = allChickenWeight;
    }

    public Integer getTotalDuckAmount() {
        return totalDuckAmount;
    }

    public ArrayList<Integer> getAllDuckWeight() {
        return allDuckWeight;
    }
}

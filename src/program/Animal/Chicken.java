package program.Animal;

import java.util.ArrayList;

public class Chicken extends Animal{

    public static Integer totalChickenAmount = 0;
    public ArrayList<Integer> allChickenWeight;


    public Chicken(String amount, String weight, ArrayList<Integer> allChickenWeight) {
        super(amount, weight);
        this.totalChickenAmount ++;
        this.allChickenWeight = allChickenWeight;
    }

    public Integer getTotalChickenAmount() {
        return totalChickenAmount;
    }

    public ArrayList<Integer> getAllChickenWeight() {
        return allChickenWeight;
    }
}

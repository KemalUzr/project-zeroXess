package program.Animal;

import program.Aves;

import java.util.ArrayList;

public class Chicken extends Aves {

    public static Integer totalChickenAmount = 0;
    public ArrayList<Integer> allChickenWeight;

    public Chicken(String amount, String weight, String name, ArrayList<Integer> allChickenWeight) {
        super(amount, weight, name);
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

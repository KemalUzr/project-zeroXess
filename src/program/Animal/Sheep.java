package program.Animal;

import java.util.ArrayList;

public class Sheep extends Animal {
    public static Integer totalSheepAmount = 0;
    public ArrayList<Integer> allSheepWeight;


    public Sheep(String amount, String weight, ArrayList<Integer> allChickenWeight) {
        super(amount, weight);
        this.totalSheepAmount ++;
        this.allSheepWeight = allChickenWeight;
    }

    public Integer getTotalSheepAmount() {
        return totalSheepAmount;
    }

    public ArrayList<Integer> getAllSheepWeight() {
        return allSheepWeight;
    }
}

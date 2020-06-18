package program.Animal;

import program.Mammal;

import java.util.ArrayList;

public class Sheep extends Mammal {
    public static Integer totalSheepAmount = 0;
    public ArrayList<Integer> allSheepWeight;

    public Sheep(String amount, String weight, String name, ArrayList<Integer> allSheepWeight) {
        super(amount, weight, name);
        this.allSheepWeight = allSheepWeight;
        this.totalSheepAmount ++;
    }

    public Integer getTotalSheepAmount() {
        return totalSheepAmount;
    }

    public ArrayList<Integer> getAllSheepWeight() {
        return allSheepWeight;
    }
}

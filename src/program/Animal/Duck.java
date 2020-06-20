package program.Animal;

import program.Aves;

import java.util.ArrayList;

public class Duck extends Aves {
    public static Integer totalDuckAmount = 0;
    public ArrayList<Integer> allDuckWeight;

    public Duck(String amount, String weight, String name, ArrayList<Integer> allDuckWeight) {
        super(amount, weight, name);
        this.totalDuckAmount ++;
        this.allDuckWeight = allDuckWeight;
    }



    public Integer getTotalDuckAmount() {
        return totalDuckAmount;
    }

    public ArrayList<Integer> getAllDuckWeight() {
        return allDuckWeight;
    }
}

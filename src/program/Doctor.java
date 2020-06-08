package program;

import javafx.beans.property.SimpleStringProperty;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private ArrayList<String> workingDays;
    private ArrayList<Integer> workingTimes;
    private ArrayList<String> diseases;


    public Doctor(String name, ArrayList<String> workingDays, ArrayList<Integer> workingTimes, ArrayList<String> diseases){
        this.name = name;
        this.workingDays = workingDays;
        this.workingTimes = workingTimes;
        this.diseases = diseases;
    }

    public String getDoctorName() {
        return name;
    }

    public ArrayList<String> getWorkingDays() {
        return workingDays;
    }

    public ArrayList<Integer> getWorkingTimes(){
        return workingTimes;
    }

    public ArrayList<String> getDiseases(){
        return diseases;
    }
}

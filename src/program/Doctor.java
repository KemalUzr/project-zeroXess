package program;

import javafx.beans.property.SimpleStringProperty;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private ArrayList<String> workingDays;
    private ArrayList<Integer> workingTimes;
    private ArrayList<Specialization> spezializations;


    public Doctor(String name, ArrayList<String> workingDays, ArrayList<Integer> workingTimes, ArrayList<Specialization> specializations){
        this.name = name;
        this.workingDays = workingDays;
        this.workingTimes = workingTimes;
        this.spezializations = specializations;
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

    public ArrayList<Specialization> getSpecialization(){
        return spezializations;
    }
}

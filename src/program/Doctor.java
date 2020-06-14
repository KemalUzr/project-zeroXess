package program;

import javafx.beans.property.SimpleStringProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private ArrayList<String> workingDays;
    private ArrayList<ArrayList<Integer>> workingTimes;
    private ArrayList<Specialization> spezializations;


    public Doctor(String name, ArrayList<String> workingDays, ArrayList<ArrayList<Integer>> workingTimes, ArrayList<Specialization> specializations){
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

    public ArrayList<Integer> getWorkingTimes(int day){
        return workingTimes.get(day);
    }

    public ArrayList<Specialization> getSpecialization(){
        return spezializations;
    }
}

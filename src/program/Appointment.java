package program;

import javafx.beans.property.SimpleStringProperty;

public class Appointment {
    private SimpleStringProperty doctor , day , time , specialization;

    public Appointment(Doctor doctor, String day, String time, Specialization specialization){
        this.doctor = new SimpleStringProperty(doctor.getDoctorName());
        this.day = new SimpleStringProperty(day);
        this.time = new SimpleStringProperty(time);
        this.specialization = new SimpleStringProperty(specialization.getName());
    }

    public int getDayAsInt(String day){
        int dayNumber = 0;
        switch(day){
            case "Monday":
                dayNumber = 1;
                break;
            case "Tuesday":
                dayNumber = 2;
                break;
            case "Wednesday":
                dayNumber = 3;
                break;
            case "Thursday":
                dayNumber = 4;
                break;
            case "Friday":
                dayNumber = 5;
                break;
            case "Saturday":
                dayNumber = 6;
                break;
            case "Sunday":
                dayNumber = 7;
                break;
        }
        return dayNumber;
    }

    public int getTimeAsInt(String time){
        int timeNumber = 0;
        switch(time){
            case "08:00":
                timeNumber = 1;
                break;
            case "09:00":
                timeNumber = 2;
                break;
            case "10:00":
                timeNumber = 3;
                break;
            case "11:00":
                timeNumber = 4;
                break;
            case "12:00":
                timeNumber = 5;
                break;
            case "13:00":
                timeNumber = 6;
                break;
            case "14:00":
                timeNumber = 7;
                break;
            case "15:00":
                timeNumber = 8;
                break;
            case "16:00":
                timeNumber = 9;
                break;
        }
        return timeNumber;
    }

    public String getDoctor() {
        return doctor.get();
    }

    public SimpleStringProperty doctorProperty(){
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor.set(doctor);
    }

    public String getDay() {
        return day.get();
    }

    public SimpleStringProperty dayProperty(){
        return day;
    }

    public void setDate(String day) {
        this.day.set(day);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty(){
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getSpecialization() {
        return specialization.get();
    }

    public SimpleStringProperty specializationProperty(){
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization.set(specialization);
    }
}

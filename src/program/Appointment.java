package program;

import javafx.beans.property.SimpleStringProperty;

public class Appointment {
    private SimpleStringProperty doctor , day , time , specialization;

    public Appointment(Doctor doctor, String day, int time, Specialization specialization){
        this.doctor = new SimpleStringProperty(doctor.getDoctorName());
        this.day = new SimpleStringProperty(day);
        this.time = new SimpleStringProperty(String.valueOf(time));
        this.specialization = new SimpleStringProperty(specialization.getName());
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

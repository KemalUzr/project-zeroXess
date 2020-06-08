package program;

import javafx.beans.property.SimpleStringProperty;

public class Appointment {
    private SimpleStringProperty doctor , date , time , disease;

    public Appointment(Doctor doctor, String date, int time, String disease){
        this.doctor = new SimpleStringProperty(doctor.getDoctorName());
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(String.valueOf(time));
        this.disease = new SimpleStringProperty();
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

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty(){
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
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
    public String getDisease() {
        return disease.get();
    }

    public SimpleStringProperty patientProperty(){
        return disease;
    }

    public void setDisease(String disease) {
        this.disease.set(disease);
    }
}

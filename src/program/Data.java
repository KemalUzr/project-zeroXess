package program;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Data {
    public static ObservableList<Appointment> firstAppointments = FXCollections.observableArrayList();
    public static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();

    public static ObservableList<Doctor> doctors = FXCollections.observableArrayList();
}

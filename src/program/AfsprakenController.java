package program;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AfsprakenController implements Initializable{
    @FXML private TableView<Appointment> tableView;
    @FXML private TableColumn<Appointment , String> doctorColumn;
    @FXML private TableColumn<Appointment , String> dateColumn;
    @FXML private TableColumn<Appointment , String> timeColumn;
    @FXML private TableColumn<Appointment , String> diseaseColumn;

    @FXML private ChoiceBox<Doctor> doctorSelection;
    @FXML private ChoiceBox<String> daySelection;
    @FXML private ChoiceBox<Integer> timeSelection;
    @FXML private TextField diseaseTextField;

    private ObservableList<Doctor> doctors = FXCollections.observableArrayList();

    public void initialize (URL url, ResourceBundle resourceBundle) {
        doctorColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctor"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("time"));
        diseaseColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("disease"));

        tableView.setItems(getData());

        getDoctor();

        tableView.setEditable(true);
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        timeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public void naHome(ActionEvent event) throws IOException{
        Parent showHome = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene showHomeScene = new Scene(showHome);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showHomeScene);
        window.show();
    }

    public void changeDoctor (TableColumn.CellEditEvent editCell){
        Appointment appointmentSelected = tableView.getSelectionModel().getSelectedItem();
        appointmentSelected.setDoctor(editCell.getNewValue().toString());
    }

    public void addButtonClicked(){
        Appointment appointment = new Appointment(doctorSelection.getValue(), daySelection.getValue(), timeSelection.getValue(), diseaseTextField.getText());
        tableView.getItems().add(appointment);
    }

    public void deleteButtonClicked(){
        ObservableList<Appointment> appointmentSelected, allAppointments;
        allAppointments = tableView.getItems();
        appointmentSelected = tableView.getSelectionModel().getSelectedItems();
        appointmentSelected.forEach(allAppointments::remove);
    }

    public ObservableList<Appointment> getData(){
        ObservableList<Appointment> data = FXCollections.observableArrayList();
        data.add(new Appointment(new Doctor("shon", firstDoctorWorkingDays(), firstDoctorWorkingTimes(), firstDoctorDiseases()), "shon@shon",10, "eyes" ));
        return data;
    }

    public void selectDoctorButton(){
        timeSelection.getItems().clear();
        daySelection.getItems().clear();
        getDay();
        getTime();
    }

    public void getDoctor(){
        doctors.add(new Doctor("Dr. Piet de Slang", firstDoctorWorkingDays(), firstDoctorWorkingTimes(), firstDoctorDiseases()));
        doctors.add(new Doctor("Dr. Kees de Beer", firstDoctorWorkingDays(), secondDoctorWorkingTimes(), secondDoctorDiseases()));
        doctorSelection.getItems().addAll(doctors);
    }

    public void getTime(){
        ObservableList<Integer> availableTimes = FXCollections.observableArrayList();
        for (int i = 0; i < doctorSelection.getValue().getWorkingTimes().size(); i++) {
            availableTimes.add(doctorSelection.getValue().getWorkingTimes().get(i));
        }
        timeSelection.getItems().addAll(availableTimes);
    }

    public void getDay(){
        ObservableList<String> availableDays = FXCollections.observableArrayList();
        for (int i = 0; i < doctorSelection.getValue().getWorkingDays().size(); i++) {
            availableDays.add(doctorSelection.getValue().getWorkingDays().get(i));
        }
        daySelection.getItems().addAll(availableDays);
    }

    public ArrayList<String> firstDoctorWorkingDays(){
        ArrayList<String> fDWD = new ArrayList<>();
        fDWD.add("Monday");
        fDWD.add("Tuesday");
        fDWD.add("Wednesday");
        fDWD.add("Thursday");
        fDWD.add("Friday");
        return fDWD;
    }

    public ArrayList<Integer> firstDoctorWorkingTimes(){
        ArrayList<Integer> fDWT = new ArrayList<>();
        fDWT.add(8);
        fDWT.add(9);
        fDWT.add(10);
        fDWT.add(11);
        fDWT.add(12);
        fDWT.add(13);
        fDWT.add(14);
        fDWT.add(15);
        return fDWT;
    }

    public ArrayList<Integer> secondDoctorWorkingTimes(){
        ArrayList<Integer> sDWT = new ArrayList<>();
        sDWT.add(8);
        sDWT.add(9);
        sDWT.add(10);
        sDWT.add(11);
        sDWT.add(12);
        sDWT.add(13);
        sDWT.add(14);
        sDWT.add(15);
        sDWT.add(16);
        return sDWT;
    }

    public ArrayList<String> firstDoctorDiseases(){
        ArrayList<String> fDD = new ArrayList<>();
        fDD.add("Ear");
        fDD.add("Eyes");
        return fDD;
    }

    public ArrayList<String> secondDoctorDiseases(){
        ArrayList<String> sDD = new ArrayList<>();
        sDD.add("Skin");
        sDD.add("General");
        return sDD;
    }
}

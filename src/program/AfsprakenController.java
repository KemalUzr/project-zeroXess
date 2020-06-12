package program;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    @FXML private TableColumn<Appointment , String> dayColumn;
    @FXML private TableColumn<Appointment , String> timeColumn;
    @FXML private TableColumn<Appointment , String> specializationColumn;

    @FXML private ChoiceBox<String> doctorSelection;
    @FXML private ChoiceBox<String> daySelection;
    @FXML private ChoiceBox<Integer> timeSelection;
    @FXML private ChoiceBox<String> specializationSelection;

    @FXML private Label wrongDoctorAlert;

    private ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    private ObservableList<Specialization> specializations = FXCollections.observableArrayList();

    public void initialize (URL url, ResourceBundle resourceBundle) {
        doctorColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctor"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("day"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("time"));
        specializationColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("specialization"));

        tableView.setItems(getData());

        getDoctor();
        getSpecialization();

        tableView.setEditable(true);
        dayColumn.setCellFactory(TextFieldTableCell.forTableColumn());
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

    public void changeSpecialization(TableColumn.CellEditEvent editCell){
        Appointment appointmentSelected = tableView.getSelectionModel().getSelectedItem();
        appointmentSelected.setSpecialization(editCell.getNewValue().toString());
    }

    public void addButtonClicked(){
        wrongDoctorAlert.setText("");
        if(checkDoctorSpecialization()) {
            Appointment appointment = new Appointment(doctors.get(getRightDoctor()), daySelection.getValue(), timeSelection.getValue(), specializations.get(getRightSpecialization()));
            tableView.getItems().add(appointment);

        } else {
            wrongDoctorAlert.setText("This doctor doesn't have this specialization.");
        }
    }

    public boolean checkDoctorSpecialization(){
        int count = 0;
        while(doctors.get(getRightDoctor()).getSpecialization().size() > count){
            if(doctors.get(getRightDoctor()).getSpecialization().get(count).getName().equals(specializations.get(getRightSpecialization()).getName())){
                return true;
            }
            count ++;
        }
        return false;
    }

    public int getRightDoctor() {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctorSelection.getValue().contains(doctors.get(i).getDoctorName())) {
                return i;
            }
        }
        return 0;
    }

    public int getRightSpecialization(){
        for (int i = 0; i < specializations.size(); i++) {
            if (specializationSelection.getValue().contains(specializations.get(i).getName())) {
                return i;
            }
        }
        return 0;
    }

    public void deleteButtonClicked(){
        ObservableList<Appointment> appointmentSelected, allAppointments;
        allAppointments = tableView.getItems();
        appointmentSelected = tableView.getSelectionModel().getSelectedItems();
        appointmentSelected.forEach(allAppointments::remove);
    }

    public ObservableList<Appointment> getData(){
        ObservableList<Appointment> data = FXCollections.observableArrayList();
        data.add(new Appointment(new Doctor("Dr. Piet de Slang", firstDoctorWorkingDays(), firstDoctorWorkingTimes(), secondDoctorSpecializations()), "Monday",10, new General() ));
        return data;
    }

    public void selectDoctorButton(){
        timeSelection.getItems().clear();
        daySelection.getItems().clear();
        getDay();
        getTime();
    }

    public void getDoctor(){
        doctors.add(new Doctor("Dr. Piet de Slang", firstDoctorWorkingDays(), firstDoctorWorkingTimes(), firstDoctorSpecializations()));
        doctors.add(new Doctor("Dr. Kees de Beer", firstDoctorWorkingDays(), secondDoctorWorkingTimes(), secondDoctorSpecializations()));
        for (int i = 0; i < doctors.size(); i++) {
            doctorSelection.getItems().add(doctors.get(i).getDoctorName());
        }

    }

    public void getSpecialization(){
        specializations.add(new Skin());
        specializations.add(new General());
        specializations.add(new Eyes());
        specializations.add(new Ear());
        for (int i = 0; i < specializations.size(); i++) {
            specializationSelection.getItems().add(specializations.get(i).getName());
        }
    }

    public void getTime(){
        ObservableList<Integer> availableTimes = FXCollections.observableArrayList();
        for (int i = 0; i < doctors.get(getRightDoctor()).getWorkingTimes().size(); i++) {
            availableTimes.add(doctors.get(getRightDoctor()).getWorkingTimes().get(i));
        }
        timeSelection.getItems().addAll(availableTimes);
    }

    public void getDay(){
        ObservableList<String> availableDays = FXCollections.observableArrayList();
        for (int i = 0; i < doctors.get(getRightDoctor()).getWorkingDays().size(); i++) {
            availableDays.add(doctors.get(getRightDoctor()).getWorkingDays().get(i));
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

    public ArrayList<Specialization> firstDoctorSpecializations(){
        ArrayList<Specialization> fDS = new ArrayList<>();
        fDS.add(new Ear());
        fDS.add(new Eyes());
        return fDS;
    }

    public ArrayList<Specialization> secondDoctorSpecializations(){
        ArrayList<Specialization> sDS = new ArrayList<>();
        sDS.add(new Skin());
        sDS.add(new General());
        return sDS;
    }
}

package program;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    @FXML private ChoiceBox<String> timeSelection;
    @FXML private ChoiceBox<String> specializationSelection;

    @FXML private Label wrongDoctorAlert;

    private ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    private ObservableList<Specialization> specializations = FXCollections.observableArrayList();

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        doctorColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctor"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("day"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("time"));
        specializationColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("specialization"));

        getDoctor();
        getSpecialization();

        tableView.setItems(Data.allAppointments);

        tableView.setEditable(true);
        dayColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        timeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public void naHome(ActionEvent event) throws IOException{
        Parent showHome = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene showHomeScene = new Scene(showHome);

        //Data.allAppointments.setAll(tableView.getItems());

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
            Appointment appointment = new Appointment(Data.doctors.get(getRightDoctor()), daySelection.getValue(), timeSelection.getValue(), specializations.get(getRightSpecialization()));
            //tableView.getItems().add(appointment);
            Data.doctors.get(getRightDoctor()).getWorkingTimes(Data.doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelection.getValue())).remove(timeSelection.getValue());
            timeSelection.getItems().clear();
            Data.allAppointments.add(appointment);
        } else {
            wrongDoctorAlert.setText("This doctor doesn't have this specialization.");
        }
    }

    public boolean checkDoctorSpecialization(){
        int count = 0;
        while(Data.doctors.get(getRightDoctor()).getSpecialization().size() > count){
            if(Data.doctors.get(getRightDoctor()).getSpecialization().get(count).getName().equals(specializations.get(getRightSpecialization()).getName())){
                return true;
            }
            count ++;
        }
        return false;
    }

    public int getRightDoctor() {
        for (int i = 0; i < Data.doctors.size(); i++) {
            if (doctorSelection.getValue().contains(Data.doctors.get(i).getDoctorName())) {
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
        Data.doctors.get(getRightDoctor()).getWorkingTimes(doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelection.getValue())).add(doctors.get(getRightDoctor()).getWorkingTimes(doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelection.getValue())).size(), appointmentSelected.get(1).getTime());
    }

    public void getDoctor(){
        if(Data.doctors.isEmpty()){
            Data.doctors.add(new Doctor("Dr. Piet de Slang", firstDoctorWorkingDays(), firstDoctorWorkingTimesPerDay(), firstDoctorSpecializations()));
            Data.doctors.add(new Doctor("Dr. Kees de Beer", firstDoctorWorkingDays(), secondDoctorWorkingTimesPerDay(), secondDoctorSpecializations()));
        }
        for (int i = 0; i < Data.doctors.size(); i++) {
            doctorSelection.getItems().add(Data.doctors.get(i).getDoctorName());
        }
        doctorSelection.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        daySelection.getItems().clear();
                        ObservableList<String> availableDays = FXCollections.observableArrayList();
                        for (int i = 0; i < Data.doctors.get(getRightDoctor()).getWorkingDays().size(); i++) {
                            availableDays.add(Data.doctors.get(getRightDoctor()).getWorkingDays().get(i));
                        }
                        daySelection.getItems().addAll(availableDays);
                        daySelection.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                            @Override
                            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                                timeSelection.getItems().clear();
                                ObservableList<String> availableTimes = FXCollections.observableArrayList();
                                for (int i = 0; i < Data.doctors.get(getRightDoctor()).getWorkingTimes(Data.doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelection.getValue())).size(); i++) {
                                    availableTimes.add(Data.doctors.get(getRightDoctor()).getWorkingTimes(Data.doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelection.getValue())).get(i));
                                }
                                timeSelection.getItems().addAll(availableTimes);
                            }
                        });
                    }
                });
    }

    //Vanaf hier alleen maar functies om de keuzes te initialiseren
    public void getSpecialization(){
        specializations.add(new Skin());
        specializations.add(new General());
        specializations.add(new Eyes());
        specializations.add(new Ear());
        for (int i = 0; i < specializations.size(); i++) {
            specializationSelection.getItems().add(specializations.get(i).getName());
        }
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

    public ArrayList<ArrayList<String>> firstDoctorWorkingTimesPerDay(){
        ArrayList<ArrayList<String>> fDWTPD = new ArrayList<>();
        for (int i = 0; i < firstDoctorWorkingDays().size(); i++) {
            fDWTPD.add(firstDoctorWorkingTimes());
        }
        return fDWTPD;
    }

    public ArrayList<ArrayList<String>> secondDoctorWorkingTimesPerDay(){
        ArrayList<ArrayList<String>> sDWTPD = new ArrayList<>();
        for (int i = 0; i < firstDoctorWorkingDays().size(); i++) {
            sDWTPD.add(secondDoctorWorkingTimes());
        }
        return sDWTPD;
    }

    public ArrayList<String> firstDoctorWorkingTimes(){
        ArrayList<String> fDWT = new ArrayList<>();
        fDWT.add("08:00");
        fDWT.add("09:00");
        fDWT.add("10:00");
        fDWT.add("11:00");
        fDWT.add("12:00");
        fDWT.add("13:00");
        fDWT.add("14:00");
        fDWT.add("15:00");
        return fDWT;
    }

    public ArrayList<String> secondDoctorWorkingTimes(){
        ArrayList<String> sDWT = new ArrayList<>();
        sDWT.add("08:00");
        sDWT.add("09:00");
        sDWT.add("10:00");
        sDWT.add("11:00");
        sDWT.add("12:00");
        sDWT.add("13:00");
        sDWT.add("14:00");
        sDWT.add("15:00");
        sDWT.add("16:00");
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

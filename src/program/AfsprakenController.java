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

    private ObservableList<Specialization> specializations = FXCollections.observableArrayList();

    public static Doctor doctorSelected;
    public static String daySelected;
    public static String timeSelected;
    public static Specialization specializationSelected;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        doctorColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctor"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("day"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("time"));
        specializationColumn.setCellValueFactory(new PropertyValueFactory<Appointment, String>("specialization"));

        wrongDoctorAlert.setText("");
        setDoctorChoicebox();
        setSpecializationChoicebox();

        tableView.setItems(Data.allAppointments);

        tableView.setEditable(true);
        dayColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        timeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    //Terug naar BeschikbaarhedenController
    public void terug(ActionEvent event) throws IOException {
        Parent showTerug = FXMLLoader.load(getClass().getResource("Beschikbaarheden.fxml"));
        Scene showHomeScene = new Scene(showTerug);

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

    //Functie voor het toevoegen van afspraken
    public void addButtonClicked(){

        if(checkDoctorSpecialization()) {
            Appointment appointment = new Appointment(doctorSelected, daySelected, timeSelected, specializationSelected);
            Data.doctors.get(getRightDoctor()).getWorkingTimes(Data.doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelected)).remove(timeSelected);
            Data.allAppointments.add(appointment);
            updateFirstAppointment();
        } else {
            wrongDoctorAlert.setText("This doctor doesn't have this specialization.");
        }
    }

    //Functie om de gekozen dokter te krijgen
    public void selectedDoctor(){
        for (int i = 0; i < Data.doctors.size(); i++) {
            if (doctorSelection.getValue().contains(Data.doctors.get(i).getDoctorName())) {
                doctorSelected = Data.doctors.get(i);
            }
        }
    }

    //Functie om de gekozen dag te krijgen
    public void selectedDay(){
        daySelected = daySelection.getValue();
    }

    //Functie om de gekozen tijd te krijgen
    public void selectedTime(){
        timeSelected = timeSelection.getValue();
    }

    //Functie om de gekozen specialisatie te krijgen
    public void selectedSpecialization(){
        for (int i = 0; i < specializations.size(); i++) {
            if (specializationSelection.getValue().contains(specializations.get(i).getName())) {
                specializationSelected = specializations.get(i);
            }
        }
    }

    //Functie van observer pattern, zorgt ervoor dat firstAppointment altijd de eerstkomende afspraak heeft
    public void updateFirstAppointment(){
        for (int i = 0; i < Data.allAppointments.size(); i++) {
            for (int j = 0; j < Data.firstAppointments.size(); j++) {
                if(Data.allAppointments.get(i).getDayAsInt(Data.allAppointments.get(i).getDay()) < Data.firstAppointments.get(j).getDayAsInt(Data.firstAppointments.get(j).getDay())){
                    Data.firstAppointments.set(0, Data.allAppointments.get(i));
                } else if (Data.allAppointments.get(i).getDayAsInt(Data.allAppointments.get(i).getDay()) == Data.firstAppointments.get(j).getDayAsInt(Data.firstAppointments.get(j).getDay())){
                    if (Data.allAppointments.get(i).getTimeAsInt(Data.allAppointments.get(i).getTime()) < Data.firstAppointments.get(j).getTimeAsInt(Data.firstAppointments.get(j).getTime())){
                        Data.firstAppointments.set(0, Data.allAppointments.get(i));
                    }
                }
            }
        }
    }

    //Controleert of de gekozen dokter de gekozen specialisatie bevat
    public boolean checkDoctorSpecialization(){
        for (int i = 0; i < Data.doctors.get(getRightDoctor()).getSpecialization().size(); i++) {
            if (doctorSelected.getSpecialization().get(i).getName().equals(specializationSelected.getName())){
                return true;
            }
        }
        return false;
    }

    //Zorgt ervoor dat de integer van de gekozen dokter gegeven wordt.
    public int getRightDoctor() {
        for (int i = 0; i < Data.doctors.size(); i++) {
            if (doctorSelected.equals(Data.doctors.get(i).getDoctorName())) {
                return i;
            }
        }
        return 0;
    }

    //Functie voor wanneer er op de delete knop gedrukt wordt
    public void deleteButtonClicked(){
        ObservableList<Appointment> appointmentSelected;
        appointmentSelected = tableView.getSelectionModel().getSelectedItems();
        appointmentSelected.forEach(Data.allAppointments::remove);
        Data.firstAppointments.clear();
        Data.firstAppointments.add(tableView.getItems().get(0));
        updateFirstAppointment();
        //Data.doctors.get(getRightDoctor()).getWorkingTimes(doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelection.getValue())).add(doctors.get(getRightDoctor()).getWorkingTimes(doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelection.getValue())).size(), appointmentSelected.get(1).getTime());
    }

    //Zorgt ervoor dat de hardcoded tijd al uit de ChoiceBoxes gehaald wordt
    public void removeInitialTime(){
        for (int i = 0; i < Data.allAppointments.size(); i++) {
            Data.doctors.get(1).getWorkingTimes(Data.doctors.get(1).getWorkingDays().indexOf(Data.allAppointments.get(i).getDay())).remove(Data.allAppointments.get(i).getTime());
        }
    }

    //Zorgt voor de keuzes in de doctorSelection Choicebox
    public void setDoctorChoicebox(){
        if(Data.doctors.isEmpty()){
            Data.doctors.add(new Doctor("Dr. Piet de Slang", firstDoctorWorkingDays(), firstDoctorWorkingTimesPerDay(), firstDoctorSpecializations()));
            Data.doctors.add(new Doctor("Dr. Kees de Beer", firstDoctorWorkingDays(), secondDoctorWorkingTimesPerDay(), secondDoctorSpecializations()));
        }
        for (int i = 0; i < Data.doctors.size(); i++) {
            doctorSelection.getItems().add(Data.doctors.get(i).getDoctorName());
        }
        removeInitialTime();
        setDayChoicebox();
    }

    //Zorgt voor de keuzes in de daySelection Choicebox
    public void setDayChoicebox(){
        doctorSelection.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                        daySelection.getItems().clear();
                        selectedDoctor();
                        ObservableList<String> availableDays = FXCollections.observableArrayList();
                        for (int i = 0; i < Data.doctors.get(getRightDoctor()).getWorkingDays().size(); i++) {
                            availableDays.add(Data.doctors.get(getRightDoctor()).getWorkingDays().get(i));
                        }
                        daySelection.getItems().addAll(availableDays);

                        setTimeChoicebox();
    }

    //Zorgt voor de keuzes in de timeSelection Choicebox
    public void setTimeChoicebox(){
        daySelection.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        timeSelection.getItems().clear();
                        ObservableList<String> availableTimes = FXCollections.observableArrayList();
                        for (int i = 0; i < Data.doctors.get(getRightDoctor()).getWorkingTimes(Data.doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelection.getValue())).size(); i++) {
                            availableTimes.add(Data.doctors.get(getRightDoctor()).getWorkingTimes(Data.doctors.get(getRightDoctor()).getWorkingDays().indexOf(daySelection.getValue())).get(i));
                        }
                        timeSelection.getItems().addAll(availableTimes);
                        selectedDay();
                        timeSelection.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                            @Override
                            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                                selectedTime();
                            }
                        });
                    }
                });
                    }
                });
    }

    //Zorgt voor de keuzes in de specializationSelection Choicebox
    public void setSpecializationChoicebox(){
        specializations.add(new Specialization("Skin"));
        specializations.add(new Specialization("General"));
        specializations.add(new Specialization("Eyes"));
        specializations.add(new Specialization("Ear"));
        for (int i = 0; i < specializations.size(); i++) {
            specializationSelection.getItems().add(specializations.get(i).getName());
        }
        specializationSelection.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selectedSpecialization();
            }
        });
    }

    //Vanaf hier alleen maar functies om de keuzes te initialiseren
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
        fDS.add(new Specialization("Ear"));
        fDS.add(new Specialization("Eyes"));
        return fDS;
    }

    public ArrayList<Specialization> secondDoctorSpecializations(){
        ArrayList<Specialization> sDS = new ArrayList<>();
        sDS.add(new Specialization("Skin"));
        sDS.add(new Specialization("General"));
        return sDS;
    }
}

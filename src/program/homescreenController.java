package program;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class homescreenController implements Initializable {
    @FXML private TableView<Appointment> Tview;
    @FXML private TableColumn<Appointment , String> Doctor;
    @FXML private TableColumn<Appointment , String> Day;
    @FXML private TableColumn<Appointment , String> Time;
    @FXML private TableColumn<Appointment , String> Specialization;

    private AfsprakenController afsprakenController = new AfsprakenController();

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        Doctor.setCellValueFactory(new PropertyValueFactory<Appointment, String>("doctor"));
        Day.setCellValueFactory(new PropertyValueFactory<Appointment, String>("day"));
        Time.setCellValueFactory(new PropertyValueFactory<Appointment, String>("time"));
        Specialization.setCellValueFactory(new PropertyValueFactory<Appointment, String>("specialization"));

        update();
        Tview.setItems(Data.firstAppointments);
    }

    public void getData2(){
        Data.allAppointments.add(new Appointment(new Doctor("Dr. Kees de Beer", afsprakenController.firstDoctorWorkingDays(), afsprakenController.firstDoctorWorkingTimesPerDay(), afsprakenController.firstDoctorSpecializations()), afsprakenController.firstDoctorWorkingDays().get(2), afsprakenController.firstDoctorWorkingTimes().get(2), new Ear()));
        Data.firstAppointments.add(new Appointment(new Doctor("Dr. Kees de Beer", afsprakenController.firstDoctorWorkingDays(), afsprakenController.firstDoctorWorkingTimesPerDay(), afsprakenController.firstDoctorSpecializations()), afsprakenController.firstDoctorWorkingDays().get(2), afsprakenController.firstDoctorWorkingTimes().get(2), new Ear()));

    }

    public void update(){
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

    public void terugLogin(ActionEvent event) throws IOException {
        Parent showLogin = FXMLLoader.load(getClass().getResource("inlogScherm.fxml"));
        Scene showLoginScene = new Scene(showLogin);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(showLoginScene);
        window.show();
    }

    public void naProfiel(ActionEvent event) throws IOException {
        Parent showProfiel = FXMLLoader.load(getClass().getResource("Profiel.fxml"));
        Scene showProfielScene = new Scene(showProfiel);
        Aves Chicken = new Aves("12", "222", "Chicken");
        Aves Duck = new Aves("12", "222", "Duck");
        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showProfielScene);
        window.show();
    }

    public void livestock(ActionEvent event) throws IOException {
        Parent showLivestock = FXMLLoader.load(getClass().getResource("Livestock.fxml"));
        Scene showLivestockScene = new Scene(showLivestock);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showLivestockScene);
        window.show();
    }
    public void naMedisch(ActionEvent event) throws IOException {
        Parent showBeschikbaarheden = FXMLLoader.load(getClass().getResource("Beschikbaarheden.fxml"));
        Scene showBeschikbaarhedenScene = new Scene(showBeschikbaarheden);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showBeschikbaarhedenScene);
        window.show();
    }

    public void naExchange(ActionEvent event) throws IOException {
        Parent showHome = FXMLLoader.load(getClass().getResource("Exchange.fxml"));
        Scene showHomeScene = new Scene(showHome);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showHomeScene);
        window.show();
    }

    public void toAdress(ActionEvent event) throws IOException{
        Parent toadress = FXMLLoader.load(getClass().getResource("adressScherm.fxml"));
        Scene adressScene = new Scene(toadress);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(adressScene);
        window.show();

    }

    public void toEducative(ActionEvent event) throws IOException{
        Parent toEducative = FXMLLoader.load(getClass().getResource("educativeHome.fxml"));
        Scene EducativeScene = new Scene(toEducative);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(EducativeScene);
        window.show();

    }

}

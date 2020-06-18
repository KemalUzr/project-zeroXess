package program;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BeschikbaarhedenController {

    public void naHome(ActionEvent event) throws IOException {
        Parent showHome = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene showHomeScene = new Scene(showHome);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showHomeScene);
        window.show();
    }
    public void naDiseases(ActionEvent event) throws IOException {
        Parent showDiseases = FXMLLoader.load(getClass().getResource("Diseases.fxml"));
        Scene showDiseasesScene = new Scene(showDiseases);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showDiseasesScene);
        window.show();
    }
    public void naAppointments(ActionEvent event) throws IOException {
        Parent showAppointments = FXMLLoader.load(getClass().getResource("Appointment.fxml"));
        Scene showAppointmentScene = new Scene(showAppointments);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showAppointmentScene);
        window.show();
    }
}

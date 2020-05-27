package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Profiel{
    public Button saveButton;

    public TextField name;
    public TextField date;
    public TextField phone;
    public TextField email;

    public void initialize() throws IOException {
        loadProfile();
    }

    public void saveProfile(){

        try {
            BufferedWriter writerE = new BufferedWriter(new FileWriter("email.txt"));
            writerE.write(email.getText());
            writerE.close();
            BufferedWriter writerN = new BufferedWriter(new FileWriter("name.txt"));
            writerN.write(name.getText());
            writerN.close();
            BufferedWriter writerD = new BufferedWriter(new FileWriter("date.txt"));
            writerD.write(date.getText());
            writerD.close();
            BufferedWriter writerP = new BufferedWriter(new FileWriter("phone.txt"));
            writerP.write(phone.getText());
            writerP.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadProfile() throws IOException {

        String emailL = Files.readString(Paths.get("email.txt"), Charset.defaultCharset());
        String nameL = Files.readString(Paths.get("name.txt"), Charset.defaultCharset());
        String dateL = Files.readString(Paths.get("date.txt"), Charset.defaultCharset());
        String phoneL = Files.readString(Paths.get("phone.txt"), Charset.defaultCharset());

        name.setText(nameL);
        date.setText(dateL);
        phone.setText(phoneL);
        email.setText(emailL);
    }
    public void naHome(ActionEvent event) throws IOException {
        Parent showHome = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene showHomeScene = new Scene(showHome);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showHomeScene);
        window.show();
    }

}

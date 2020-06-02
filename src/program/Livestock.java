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

public class Livestock {
    public Button loadStockButton;
    public Button saveStockButton;

    public TextField cowAmount;
    public TextField sheepAmount;
    public TextField goatAmount;
    public TextField chickenAmount;
    public TextField duckAmount;
    public TextField cowWeight;
    public TextField sheepWeight;
    public TextField goatWeight;
    public TextField chickenWeight;
    public TextField duckWeight;

    public void naHome(ActionEvent event) throws IOException {
        Parent showHome = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene showHomeScene = new Scene(showHome);

        //pakt stage informatie
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(showHomeScene);
        window.show();
        loadStock();
    }

    public void initialize() throws IOException {
        loadStock();
    }
    public void saveStock(){


        try {
            BufferedWriter writercowA = new BufferedWriter(new FileWriter("cowAmount.txt"));
            writercowA.write(cowAmount.getText());
            writercowA.close();

            BufferedWriter writerSheepA = new BufferedWriter(new FileWriter("sheepAmount.txt"));
            writerSheepA.write(sheepAmount.getText());
            writerSheepA.close();

            BufferedWriter writergoatA = new BufferedWriter(new FileWriter("goatAmount.txt"));
            writergoatA.write(goatAmount.getText());
            writergoatA.close();

            BufferedWriter writerChickenA = new BufferedWriter(new FileWriter("chickenAmount.txt"));
            writerChickenA.write(chickenAmount.getText());
            writerChickenA.close();

            BufferedWriter writerduckA = new BufferedWriter(new FileWriter("duckAmount.txt"));
            writerduckA.write(duckAmount.getText());
            writerduckA.close();

            BufferedWriter writercowW = new BufferedWriter(new FileWriter("cowWeight.txt"));
            writercowW.write(cowWeight.getText());
            writercowW.close();

            BufferedWriter writerSheepW = new BufferedWriter(new FileWriter("sheepWeight.txt"));
            writerSheepW.write(sheepWeight.getText());
            writerSheepW.close();

            BufferedWriter writergoatW = new BufferedWriter(new FileWriter("goatWeight.txt"));
            writergoatW.write(goatWeight.getText());
            writergoatW.close();

            BufferedWriter writerChickenW = new BufferedWriter(new FileWriter("chickenWeight.txt"));
            writerChickenW.write(chickenWeight.getText());
            writerChickenW.close();

            BufferedWriter writerduckW = new BufferedWriter(new FileWriter("duckWeight.txt"));
            writerduckW.write(duckWeight.getText());
            writerduckW.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Laad stock in via de .txt files
    public void loadStock() throws IOException {
        String amountCow = Files.readString(Paths.get("cowAmount.txt"), Charset.defaultCharset());
        String amountGoat = Files.readString(Paths.get("goatAmount.txt"), Charset.defaultCharset());
        String amountSheep = Files.readString(Paths.get("sheepAmount.txt"), Charset.defaultCharset());
        String amountChicken = Files.readString(Paths.get("chickenAmount.txt"), Charset.defaultCharset());
        String amountDuck = Files.readString(Paths.get("duckAmount.txt"), Charset.defaultCharset());
        String weightCow = Files.readString(Paths.get("cowWeight.txt"), Charset.defaultCharset());
        String weightGoat = Files.readString(Paths.get("goatWeight.txt"), Charset.defaultCharset());
        String weightSheep = Files.readString(Paths.get("sheepWeight.txt"), Charset.defaultCharset());
        String weightChicken = Files.readString(Paths.get("chickenWeight.txt"), Charset.defaultCharset());
        String weightDuck = Files.readString(Paths.get("duckWeight.txt"), Charset.defaultCharset());

        cowAmount.setText(amountCow);

        sheepAmount.setText(amountSheep);

        goatAmount.setText(amountGoat);

        chickenAmount.setText(amountChicken);

        duckAmount.setText(amountDuck);

        cowWeight.setText(weightCow);

        sheepWeight.setText(weightSheep);

        goatWeight.setText(weightGoat);

        chickenWeight.setText(weightChicken);

        duckWeight.setText(weightDuck);
    }
}

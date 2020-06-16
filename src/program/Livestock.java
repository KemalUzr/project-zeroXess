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

public class Livestock  {
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

    Mammal sheep = new Mammal(getValue("sheepAmount"), getValue("sheepWeight"), "Sheep");
    Mammal cow = new Mammal(getValue("cowAmount"), getValue("cowWeight"), "Cow");
    Mammal goat = new Mammal(getValue("goatAmount"), getValue("goatWeight"), "Goat");
    Aves chicken = new Aves(getValue("chickenAmount"), getValue("chickenWeight"), "Chicken");
    Aves duck = new Aves(getValue("duckAmount"), getValue("duckWeight"), "Duck");

    public Livestock() throws IOException {
    }

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
        sheep.setAmount(sheepAmount.getText());
        cow.setAmount(cowAmount.getText());
        goat.setAmount(goatAmount.getText());
        chicken.setAmount(chickenAmount.getText());
        duck.setAmount(duckAmount.getText());
        sheep.setAmount(sheepWeight.getText());
        cow.setAmount(cowWeight.getText());
        goat.setAmount(goatWeight.getText());
        chicken.setAmount(chickenWeight.getText());
        duck.setAmount(duckWeight.getText());

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

            BufferedWriter writerchickenA = new BufferedWriter(new FileWriter("chickenAmount.txt"));
            writerchickenA.write(chickenAmount.getText());
            writerchickenA.close();

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
    public String getValue(String specific) throws IOException {
          String returnValue = Files.readString(Paths.get(specific +".txt"), Charset.defaultCharset());
        return returnValue;
    }
    public void loadStock() throws IOException {

        chickenAmount.setText(chicken.getAmount());

        cowAmount.setText(cow.getAmount());

        sheepAmount.setText(sheep.getAmount());

        goatAmount.setText(goat.getAmount());

        duckAmount.setText(duck.getAmount());

        cowWeight.setText(cow.getWeight());

        sheepWeight.setText(sheep.getWeight());

        goatWeight.setText(goat.getWeight());

        chickenWeight.setText(chicken.getWeight());

        duckWeight.setText(duck.getWeight());
    }
}

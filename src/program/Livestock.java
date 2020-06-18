package program;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import program.Animal.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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
    public TextField addInput;
    @FXML
    public ChoiceBox<String> addDropdown;
    ArrayList<Integer> allChickenWeight = new ArrayList<>();
    ArrayList<Integer> allCowWeight = new ArrayList<>();
    ArrayList<Integer> allDuckWeight = new ArrayList<>();
    ArrayList<Integer> allGoatWeight = new ArrayList<>();
    ArrayList<Integer> allSheepWeight = new ArrayList<>();
    int chickenTotal = 0;
    int cowTotal = 0;
    int duckTotal = 0;
    int goatTotal = 0;
    int sheepTotal = 0;
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
    public void addNewAnimal(){
        System.out.println(addDropdown.getValue());
        String addInputString = addInput.getText();
        int addInputInt = Integer.parseInt(addInputString);

        addInput.setText("");
        switch (addDropdown.getValue()) {
            case "sheep":
                allSheepWeight.add(addInputInt);
                Sheep sheep = new Sheep("1", addInputString, allSheepWeight);
                for (Integer test : sheep.getAllSheepWeight()) {
                    sheepTotal = sheepTotal + test;
                }
                saveNewData(sheepTotal, sheep.getTotalSheepAmount(), "sheep");
                sheepWeight.setText(Integer.toString(sheepTotal));
                sheepAmount.setText(Integer.toString(sheep.getTotalSheepAmount()));
                sheepTotal = 0;
                break;
            case "cow":
                allCowWeight.add(addInputInt);
                Cow cow = new Cow("1", addInputString, allCowWeight);
                for (Integer test : cow.getAllCowWeight()) {
                    cowTotal = cowTotal + test;
                }
                saveNewData(cowTotal, cow.getTotalCowAmount(), "cow");
                cowWeight.setText(Integer.toString(cowTotal));
                cowAmount.setText(Integer.toString(cow.getTotalCowAmount()));
                cowTotal = 0;
                break;
            case "goat":
                allGoatWeight.add(addInputInt);
                Goat goat = new Goat("1", addInputString, allGoatWeight);
                for (Integer test : goat.getAllGoatWeight()) {
                    goatTotal = goatTotal + test;
                }
                saveNewData(goatTotal, goat.getTotalGoatAmount(), "goat");
                goatWeight.setText(Integer.toString(goatTotal));
                goatAmount.setText(Integer.toString(goat.getTotalGoatAmount()));
                goatTotal = 0;
                break;
            case "chicken":
                allChickenWeight.add(addInputInt);
                Chicken chicken = new Chicken("1", addInputString, allChickenWeight);
                for (Integer test : chicken.getAllChickenWeight()) {
                    chickenTotal = chickenTotal + test;
                }
                saveNewData(chickenTotal, chicken.getTotalChickenAmount(), "chicken");
                chickenWeight.setText(Integer.toString(chickenTotal));
                chickenAmount.setText(Integer.toString(chicken.getTotalChickenAmount()));
                chickenTotal = 0;
                break;
            case "duck":
                allDuckWeight.add(addInputInt);
                Duck duck = new Duck("1", addInputString, allDuckWeight);
                for (Integer test : duck.getAllDuckWeight()) {
                    duckTotal = duckTotal + test;
                }
                saveNewData(duckTotal, duck.getTotalDuckAmount(), "duck");
                duckWeight.setText(Integer.toString(duckTotal));
                duckAmount.setText(Integer.toString(duck.getTotalDuckAmount()));
                duckTotal = 0;
                break;
        }

    }

    public void saveNewData(int totalWeight, int amount, String animal) {
        System.out.println(amount);
        try {
            BufferedWriter writerAmount = new BufferedWriter(new FileWriter(animal + "Amount.txt"));
            writerAmount.write(Integer.toString(amount));
            writerAmount.close();
            BufferedWriter writerTotal = new BufferedWriter(new FileWriter(animal + "Weight.txt"));
            writerTotal.write(Integer.toString(totalWeight));
            writerTotal.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadStock() throws IOException {

        addDropdown.getItems().add("sheep");
        addDropdown.getItems().add("cow");
        addDropdown.getItems().add("goat");
        addDropdown.getItems().add("chicken");
        addDropdown.getItems().add("duck");

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

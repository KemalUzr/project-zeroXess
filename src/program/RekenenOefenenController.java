package program;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RekenenOefenenController implements Initializable {
    // voor voorbeelden te laten zien
    @FXML   private TextField inputpreftable;
    @FXML    private TextArea prefTables;

    // voor de oefen opdrachten
    @FXML   private TextField inputoefen;
    @FXML    private TextArea oefenvragen;

    //antwoorden
    @FXML   private TextField inputvraag1;
    @FXML   private TextField inputvraag2;
    @FXML   private TextField inputvraag3;
    @FXML   private TextField inputvraag4;
    @FXML   private TextField inputvraag5;
    @FXML   private TextField inputvraag6;
    @FXML   private TextField inputvraag7;
    @FXML   private TextField inputvraag8;
    @FXML   private TextField inputvraag9;
    @FXML   private TextField inputvraag10;


    //
    ArrayList<Integer> Antwoordenlijst = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void Previewtable(ActionEvent event){
        String inputstr = inputpreftable.getText();
        int num = Integer.parseInt(inputstr);
        prefTables.setText("");


        for( int i=1 ; i <=10; i++){
            prefTables.setText(prefTables.getText()+"\n" + num+ "*"+i+"="+(num * i));

        }
    }

    public void oefentable(ActionEvent event){
        String inputstr = inputoefen.getText();
        int num = Integer.parseInt(inputstr);
        oefenvragen.setText("");


        for( int i=1 ; i <=10; i++){
            oefenvragen.setText(oefenvragen.getText()+"\n"+"Vraag "+ i +" :  " + num+ "*"+i+"=");
            Antwoordenlijst.add(i * num);

        }
    }


 public void checkOefenvragen(){
////
     String input1 = inputvraag1.getText();
     String input2 = inputvraag2.getText();
     String input3 = inputvraag3.getText();
     String input4 = inputvraag4.getText();
     String input5 = inputvraag5.getText();
     String input6 = inputvraag6.getText();
     String input7 = inputvraag7.getText();
     String input8 = inputvraag8.getText();
     String input9 = inputvraag9.getText();
     String input10 = inputvraag10.getText();

     int ant1 = Integer.parseInt(input1);
     int ant2 = Integer.parseInt(input1);
     int ant3 = Integer.parseInt(input1);
     int ant4 = Integer.parseInt(input1);
     int ant5 = Integer.parseInt(input1);
     int ant6 = Integer.parseInt(input1);
     int ant7 = Integer.parseInt(input1);
     int ant8 = Integer.parseInt(input1);
     int ant9 = Integer.parseInt(input1);
     int ant10 = Integer.parseInt(input1);

     ArrayList<Integer> contesterantworden = new ArrayList<>();

    contesterantworden.add(ant1);
     contesterantworden.add(ant2);
     contesterantworden.add(ant3);
     contesterantworden.add(ant4);
     contesterantworden.add(ant5);
     contesterantworden.add(ant6);
     contesterantworden.add(ant7);
     contesterantworden.add(ant8);
     contesterantworden.add(ant9);
     contesterantworden.add(ant10);


     int count = 0;
     for(int i = 0; i < Antwoordenlijst.size(); i++) {
         if(Antwoordenlijst.get(i).equals(contesterantworden.get(i))) {
             count++;
         }



     }
}




 // zorg er voor dat het naar overzicht scherm van rekenen gaat
    public void ToRekenOverzicht(ActionEvent event) throws IOException {
        Parent toRhome  = FXMLLoader.load(getClass().getResource("RekenenHome.fxml"));
        Scene Rhome = new Scene(toRhome);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Rhome);
        window.show();
}
}
package program;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdressController implements Initializable{

    // Table content
    @FXML private TableView<Adress> tableView;
    @FXML private TableColumn<Adress ,  String> nameColumn;
    @FXML private TableColumn<Adress ,  String> emailColumn;
    @FXML private TableColumn<Adress ,  String> telColumn;

    // input fields
    @FXML private TextField nameTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField telTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set up the columns in table
        nameColumn.setCellValueFactory(new PropertyValueFactory<Adress, String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Adress, String>("email"));
        telColumn.setCellValueFactory(new PropertyValueFactory<Adress , String>( "tel"));


        //laat data
        tableView.setItems(getData());

        // zorgt er voor dat je de columns kan aanpassen
        tableView.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());


    }
    // zorgt er voor dat je terug kan gaan naar het profiel
    public void toHomescreen(ActionEvent event) throws IOException{
        Parent tohome  = FXMLLoader.load(getClass().getResource("homescreen.fxml"));
        Scene homeScene = new Scene(tohome);

        //pakt stage informatie
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }


    // zorgt er voor dat je de naam kan veranderen
    public void changeName(TableColumn.CellEditEvent editCell){
        Adress adressSelected = tableView.getSelectionModel().getSelectedItem();
        adressSelected.setName(editCell.getNewValue().toString());

    }
    // zorg er voor dat je adressen  kan toevoegen
    public void addButttonClicked(){
        Adress adress = new Adress(nameTextField.getText(), emailTextField.getText() , telTextField.getText());
        tableView.getItems().add(adress);


    }
    // delete adress
    public void deleteButtonClicked(){
        ObservableList<Adress> adressSelected, allAdresses;
        allAdresses = tableView.getItems();
        adressSelected = tableView.getSelectionModel().getSelectedItems();
        adressSelected.forEach(allAdresses::remove);
    }
    // test data word er in Gegenereerd
    public ObservableList<Adress> getData(){

        ObservableList<Adress> data = FXCollections.observableArrayList();
        data.add(new Adress("shon", "shon@shon","2132342323" ));
        data.add(new Adress("shon1", "shon1@shon","213234234" ));
        data.add(new Adress("shon2", "shon2@shon","213234234" ));
        return data;
    }
}

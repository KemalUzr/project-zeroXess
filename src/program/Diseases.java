package program;

import javafx.beans.property.SimpleStringProperty;

public class Diseases {
    private SimpleStringProperty Disease;

    public Diseases(String DiseaseName){
        this.Disease = new SimpleStringProperty(DiseaseName);
    }

    public String getDisease() {
        return Disease.get();
    }

    public SimpleStringProperty diseaseNameProperty() {
        return Disease;
    }

    public void setDisease(String diseaseName) {
        this.Disease.set(diseaseName);
    }

}

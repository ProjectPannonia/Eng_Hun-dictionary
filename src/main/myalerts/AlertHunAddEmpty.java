package main.myalerts;

import javafx.scene.control.Alert;

public class AlertHunAddEmpty implements MyError {
    @Override
    public void SendAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba!");
        alert.setHeaderText("Nem adtad meg az magyar szót!");
        alert.setContentText("Kérlek add meg a megfelelő magyar szót!");
        alert.showAndWait();
    }
}

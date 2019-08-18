package main.myalerts;

import javafx.scene.control.Alert;

public class AlertEngAddEmpty implements MyError {
    @Override
    public void SendAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba!");
        alert.setHeaderText("Nem adtad meg az angol szót!");
        alert.setContentText("Kérlek add meg a megfelelő angol szót!");
        alert.showAndWait();
    }
}

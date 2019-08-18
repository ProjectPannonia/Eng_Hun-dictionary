package main.myalerts;

import javafx.scene.control.Alert;

public class ReadError implements MyError {
    @Override
    public void SendAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hibás bevitel!");
        alert.setHeaderText("Fájlból olvasás sikertelen!");
        alert.setContentText("Kérlek ellenőrizd a megadott adatokat!");
        alert.showAndWait();
    }
}

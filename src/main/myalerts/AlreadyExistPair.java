package main.myalerts;

import javafx.scene.control.Alert;

public class AlreadyExistPair implements MyError {
    @Override
    public void SendAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba!");
        alert.setHeaderText("A megadott szó pár már megtalálható a szótárban!");
        alert.setContentText("Kérlek adj meg másik szó párt!");
        alert.showAndWait();
    }
}

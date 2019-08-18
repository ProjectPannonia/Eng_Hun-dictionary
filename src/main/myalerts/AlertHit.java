package main.myalerts;

import javafx.scene.control.Alert;

public class AlertHit implements MyError {
    @Override
    public void SendAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba!");
        alert.setHeaderText("Nincs találat!");
        alert.setContentText("A keresett szót nem tartalmazza az adatbázis!");
        alert.showAndWait();
    }
}

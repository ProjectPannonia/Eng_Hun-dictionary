package main.myalerts;

import javafx.scene.control.Alert;

public class Alertnotempty implements MyError {
    @Override
    public void SendAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hibás bevitel!");
        alert.setHeaderText("Mindkét mező adatot tartalmaz!");
        alert.setContentText("Kérlek csak a keresett szót írd be. A másik mezőből töröld az szöveget!");
        alert.showAndWait();
        System.out.println("Hibás bevitel! Mindkét mező adatot tartalmaz!");
    }
}

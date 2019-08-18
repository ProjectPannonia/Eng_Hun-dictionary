package main.myalerts;

import javafx.scene.control.Alert;

public class AlertAddWordNull implements MyError {
    @Override
    public void SendAlert() {
        System.out.println("A mezők értéke nem lehet null!");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hibás bevitel!");
        alert.setHeaderText("Mindkét beviteli mező üres!");
        alert.setContentText("Kérlek a bal oldali mezőben add meg az angol, a jobb oldaliba pedig a magyar szót!");
        alert.showAndWait();
        System.out.println("Hibás bevitel, a mezők nem tartalmaznak értéket!");
    }
}

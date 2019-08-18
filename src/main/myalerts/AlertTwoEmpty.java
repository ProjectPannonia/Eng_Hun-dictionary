package main.myalerts;

import javafx.scene.control.Alert;

public class AlertTwoEmpty implements MyError{
    @Override
    public void SendAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hibás bevitel!");
        alert.setHeaderText("Mindkét mező üres!");
        alert.setContentText("Valamelyik mezőbe írd be a nyelvnek megfelelő keresett szót!");
        alert.showAndWait();
        System.out.println("Hibás bevitel! Mindkét mező üres!");
    }
}

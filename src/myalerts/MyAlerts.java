package myalerts;

import javafx.scene.control.Alert;

public class MyAlerts {
    public void alertNotEmpty(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hibás bevitel!");
        alert.setHeaderText("Mindkét mező adatot tartalmaz!");
        alert.setContentText("Kérlek csak a keresett szót írd be. A másik mezőből töröld az szöveget!");
        alert.showAndWait();
        System.out.println("Hibás bevitel! Mindkét mező adatot tartalmaz!");
    }
    public void alertTwoEmpty(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hibás bevitel!");
        alert.setHeaderText("Mindkét mező üres!");
        alert.setContentText("Valamelyik mezőbe írd be a nyelvnek megfelelő keresett szót!");
        alert.showAndWait();
        System.out.println("Hibás bevitel! Mindkét mező üres!");
    }
    public void hit(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba!");
        alert.setHeaderText("Nincs találat!");
        alert.setContentText("A keresett szót nem tartalmazza az adatbázis!");
        alert.showAndWait();
    }
    public void addWordNull(){
        System.out.println("A mezők értéke nem lehet null!");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hibás bevitel!");
        alert.setHeaderText("Mindkét beviteli mező üres!");
        alert.setContentText("Kérlek a bal oldali mezőben add meg az angol, a jobb oldaliba pedig a magyar szót!");
        alert.showAndWait();
        System.out.println("Hibás bevitel, a mezők nem tartalmaznak értéket!");
    }
    public void hunAddEmpty(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba!");
        alert.setHeaderText("Nem adtad meg az magyar szót!");
        alert.setContentText("Kérlek add meg a megfelelő magyar szót!");
        alert.showAndWait();
    }
    public void engAddEmpty(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba!");
        alert.setHeaderText("Nem adtad meg az angol szót!");
        alert.setContentText("Kérlek add meg a megfelelő angol szót!");
        alert.showAndWait();
    }
}

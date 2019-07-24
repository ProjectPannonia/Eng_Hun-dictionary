package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class EmptyChecker {

    public boolean EmptyCheck(String EngTbox, String HunTbox){

        return EngTbox != null && HunTbox != null;
    }
}

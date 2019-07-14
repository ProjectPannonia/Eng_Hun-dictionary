package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {
    @Override
    public void init() throws Exception{
        WordCounter wc = new WordCounter();
        wc.WordCounter();
        System.out.println(wc.WordCounter());
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        CreateArraylistFromDatabase calfd = new CreateArraylistFromDatabase();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dictionary by SLD");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        ArrayList<Word> words = calfd.getAllWord();
        for(Word w : words){
            System.out.println(w.getHun());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

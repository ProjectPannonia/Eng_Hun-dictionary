package AddWordsFromFile;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public String[] Reader(String path){
        String str;
        String[] tokens = null;

        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            while ((str = in.readLine()) != null){
                tokens = str.split(" ");
            }
        }catch (IOException e){
            System.out.println("File not found!");
        }
        return tokens;
    }
}

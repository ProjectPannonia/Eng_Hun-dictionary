package addwordsfromfile;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyReader {
    public String[] Reader(String path) throws IOException{
        String str;
        String[] tokens = null;

        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            while ((str = in.readLine()) != null && !str.equals("")){
                tokens = str.split(" ");
            }
        }
        return tokens;
    }
}

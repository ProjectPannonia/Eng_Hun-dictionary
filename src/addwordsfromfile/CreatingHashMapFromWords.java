package addwordsfromfile;

import java.util.HashMap;

public class CreatingHashMapFromWords {

    public HashMap createHashMap(String[] array){
        HashMap<String,String> created = new HashMap<>();
        String eng = null;
        String hun = null;

        for (int i = 0; i < array.length; i++){
            if(i % 2 == 0)eng = array[i];
            else hun = array[i];
            created.put(eng,hun);
        }
        return created;
    }
}

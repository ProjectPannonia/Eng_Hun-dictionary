package checkers;

public class EmptyCheck {

    // Ha mindkettő üres igennel tér vissza
    public boolean twoEmpty(String eng, String hun){
        boolean en = eng.isEmpty();
        boolean hu = hun.isEmpty();

        return !en && !hu;
    }
    // If english search textbox not empty, return true
    public boolean hunEmpty(String eng, String hun){
        boolean en = !eng.isEmpty();
        boolean hu = hun.isEmpty();

        return en && hu;
    }
    // Ha az angol üres igennel tér vissza
    public boolean engEmpty(String eng,String hun){
        boolean en = eng.isEmpty();
        boolean hu = !hun.isEmpty();

        return en && hu;
    }
    // Ha eggyik sem üres igennel tér vissza
    public boolean notEmpty(String eng, String hun){
        boolean en = !eng.equals("");
        boolean hu = !hun.equals("");

        return en && hu;
    }
}

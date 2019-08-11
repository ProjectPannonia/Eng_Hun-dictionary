package checkers;

public class EmptyCheck {

    public boolean emptyCheck(String eng, String hun){
        String engW = eng.toLowerCase().trim();
        String hunW = hun.toLowerCase().trim();

        return engW != null && hunW != null;
    }
}

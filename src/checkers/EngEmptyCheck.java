package checkers;

public class EngEmptyCheck extends EmptyCheck {
    @Override
    public boolean emptyCheck(String eng,String hun){
        String engW = eng.toLowerCase().trim();
        String hunW = hun.toLowerCase().trim();

        return engW != null && hunW == null;
    }
}

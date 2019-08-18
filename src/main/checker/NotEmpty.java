package main.checker;

public class NotEmpty implements Check {
    @Override
    public boolean check(String eng, String hun) {

        boolean en = !eng.isEmpty();
        boolean hu = !hun.isEmpty();

        return en && hu;
    }
}

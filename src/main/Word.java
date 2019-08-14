package main;

public class Word {

    private String eng;
    private String hun;

    public Word(String eng,String hun){
        this.eng = eng;
        this.hun = hun;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getHun() {
        return hun;
    }

    public void setHun(String hun) {
        this.hun = hun;
    }
}

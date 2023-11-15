package misc;

public class CatStuff {
    private Cat cat;

    public CatStuff(Cat cat){
        this.cat = cat;
    }
    public void run(Cat cat){
        cat.changeAge(16);
    }

    public void stringChange(String toChange){
        toChange = "ff";
    }
}

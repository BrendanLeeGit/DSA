package misc;

public class TestRef {
    public static void main(String[] args){
        Cat cat = new Cat();
        System.out.println(cat.getAge());

        CatStuff catStuff = new CatStuff(cat);
        catStuff.run(cat);

        System.out.println(cat.getAge());
    }
}

package misc;

public class RandomTest {
    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        System.out.println("Name before foo method: " + aDog.getName());

        foo(aDog);
        System.out.println("Name after foo method: " + aDog.getName());
    }

    public static void foo(Dog d) {
        // change d inside of foo() to point to a new Dog instance "Fifi"
        d.name = "p";
    }
}

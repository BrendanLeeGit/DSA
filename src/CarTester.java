import java.util.ArrayList;

public class CarTester {
    public void runTest(){
        //Test initial car
        Car car = new Car();
        for (int i = 0; i < 4; i++){
            car.moveHorizontal(10);
            System.out.println("Current Position " + car.getCoordinates());
            car.moveVertical(10);
            System.out.println("Current Position " + car.getCoordinates());
            car.moveHorizontal(-10);
            System.out.println("Current Position " + car.getCoordinates());
            car.moveVertical(-10);
            System.out.println("Current Position " + car.getCoordinates());
        }

        ArrayList positions = car.getPositions();
        for (int i = 0; i < positions.size(); i++){
            System.out.println("Recorded coordinate: " + positions.get(i));
        }
    }
}

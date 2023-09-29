package car;

import java.util.ArrayList;

/**
 * Car.Car class bc why not
 */
public class Car {
    private GPS gps;

    public Car(){
        this.gps = new GPS(0, 0);
    }

    /**
     * Positive distance moves up, negative moves down
     * @param distance
     */
    public void moveVertical(double distance){
        gps.changeY(distance);
    }

    /**
     * Positive distance moved right, negative moves left
     * @param distance
     */
    public void moveHorizontal(double distance){
        gps.changeX(distance);
    }

    public String getCoordinates(){
        recordCoordinates();
        return "(" + gps.getX() + ", " + gps.getY() + ")";
    }

    public void recordCoordinates(){
        gps.recordPosition();
    }

    public ArrayList getPositions(){
        return gps.getPositions();
    }
}

package Car;

import java.util.ArrayList;

public class GPS {
    private ArrayList<String> positions = new ArrayList();

    private double x;
    private double y;

    public GPS(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void changeX(double x){
        this.x += x;
    }

    public void changeY(double y){
        this.y += y;
    }

    public void recordPosition(){
        positions.add("(" + x + ", " + y + ")");
    }

    public ArrayList getPositions(){
        return positions;
    }
}

package queue;

public class PassengerMain {
    public static void main(String args[]) {
        AirLineCheckInSim.AirlineCheckinSim sim = new AirlineCheckinSim();
        sim.enterData();
        sim.runSimulation();
        sim.showStats();
        System.exit(0);
    }
}

package queue;

public class AirLineCheckInSim {


    public class AirlineCheckinSim {
        /**
         * Queue of frequent flyers.
         */
        private PassengerQueue frequentFlyerQueue =
                new PassengerQueue("Frequent Flyer");
        /**
         * Queue of regular passengers.
         */
        private PassengerQueue regularPassengerQueue =
                new PassengerQueue("Regular Passenger");
        /**
         * Maximum number of frequent flyers to be served
         * before a regular passenger gets served.
         */
        private int frequentFlyerMax;
        /**
         * Maximum time to service a passenger.
         */
        private int maxProcessingTime;
        /**
         * Total simulated time.
         */
        private int totalTime;
        /**
         * If set true, print additional output.
         */
        private boolean showAll;
        /**
         * Simulated clock.
         */
        private int clock = 0;
        /**
         * Time that the agent will be done with the current passenger.
         */
        private int timeDone;
        /**
         * Number of frequent flyers served since the
         * last regular passenger was served.
         */
        private int frequentFlyersSinceRP;
    }

}

package queue.supermarket;

public class CheckOutManager {
    private CheckOut[] checkOuts;
    private final int numStandLines, numSuper, numExpress;

    public CheckOutManager(int numStandLines, int numSuper, int numExpress){
        this.numStandLines = numStandLines;
        this.numSuper = numSuper;
        this.numExpress = numExpress;
    }

    public void makeCheckOutCounters(int numStandLines){
        checkOuts = new CheckOut[numStandLines + 3];

        //Create the checkouts
        for (int i = 0; i < numStandLines; i++){
            checkOuts[i] = new CheckOut();
        }
    }

    public CheckOut getSmallestLine(int checkOutType){
        //0 -> super express; 1 -> express; 2 -> standard line
        if (checkOutType == 0){
            return checkOuts[0];
        }
        //Compare the two express lines
        if (checkOutType == 1){
            if (checkOuts[1].getCustomerLineSize() >= checkOuts[2].getCustomerLineSize()){
                return checkOuts[1];
            }
            else {
                return checkOuts[2];
            }
        }
        //Go through all standard arrays and check the smallest one
        else if (checkOutType == 2){
            CheckOut smallestCheckOut = checkOuts[3];       //Initialize as first standard checkout line
            for (int i = 0; i < numStandLines - 1; i++){
                if (checkOuts[i + 3].getCustomerLineSize() < checkOuts[i + 4].getCustomerLineSize()){
                    smallestCheckOut = checkOuts[i + 4];
                }
            }
            return smallestCheckOut;
        }
        //Shouldn't have any other inputs so for now I'm just going to make it error out
        //TODO: remove random error out
        return checkOuts[-3];
    }

    public void processCustomers(Customer[] customerList){
        for (Customer c : customerList){

        }
    }
}

package queue.supermarket;
import java.util.Random;

public class CustomerCreation {
    private final int maxItems;
    private final Random rand;

    public CustomerCreation(int maxItems){
        this.maxItems = maxItems;
        rand = new Random();
    }

    public Customer[] generateCustomerArray(int sizeOfArray){
        //Create a new array and fill it with Customers with random amounts of items
        Customer[] customerArray = new Customer[sizeOfArray];
        for (int i = 0; i < customerArray.length; i++){
            customerArray[i] = new Customer(rand.nextInt(maxItems));
        }
        return customerArray;
    }

}

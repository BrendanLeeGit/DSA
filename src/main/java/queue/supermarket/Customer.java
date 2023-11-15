package queue.supermarket;

public class Customer {
    private final int itemAmount;

    public Customer(int itemAmount){
        this.itemAmount = itemAmount;
    }

    public int getItemAmount() {
        return itemAmount;
    }
}

package queue.supermarket;

import queue.Queue;

public class CheckOut {
    private Queue<Customer> customerQueue;
    private int time;

    public CheckOut(){
        this.customerQueue = new Queue<>();
    }

    public void addCustomer(Customer customer) {
        customerQueue.offer(customer);
    }

    public void processCustomer(){
        time += 5 * customerQueue.poll().getItemAmount();
    }

    public int getCustomerLineSize(){
        return customerQueue.getSize();
    }

    public boolean canAcceptCustomer(Customer customer){
        return true;
    }

}

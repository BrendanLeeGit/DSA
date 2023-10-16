package queue;

public class QueueRun {
    private Queue<String> queue;

    public QueueRun(){
        queue = new Queue<>();
    }

    public void runQueue(){
        //Add three and print
        queue.offer("Michael");
        queue.offer("Brendan");
        queue.offer("Robert Downey Junior");
        queue.printQueue();

        //Check first person in line
        System.out.println("Peeked: " + queue.peek());

        //Remove next two
        System.out.println("Polled: " + queue.poll());
        System.out.println("Polled: " + queue.poll());
        queue.printQueue();

        //Remove the next one as well
        System.out.println("Polled: " + queue.poll());
        queue.printQueue();
    }
}

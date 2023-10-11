package stack;

public class StackRunner {
    public StackRunner(){
    }

    public void runSequence(){
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        //Add 0 - 9 to it
        for (int i = 0; i < 14; i++){
            arrayStack.push(i);
        }

        arrayStack.printStack();

        System.out.println("Popped: " + arrayStack.pop());
        arrayStack.printStack();
        System.out.println("Size: " + arrayStack.size());

        System.out.println("Four is at: " + arrayStack.searchWeird(4));

        arrayStack.printStack();
        //Remove all the rest
        for (int i = 0; i < 13; i++){
            arrayStack.pop();
        }
        arrayStack.printStack();

        arrayStack.empty();
        arrayStack.push(3);
        arrayStack.printStack();
    }
}

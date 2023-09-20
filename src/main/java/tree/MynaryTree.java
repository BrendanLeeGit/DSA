package tree;

/**
 * My implementation of a binary tree.
 * @param <T>
 */
public class MynaryTree<T extends Comparable<T>> {
    private Node root;

    /**
     * Adds an element to the Binary Tree.
     * @param input     The data of the Node that will be added
     */
    public void add(T input){
        //If it's the first node, just make the root ofc
        if (root == null){
            root = new Node(input, null, null, null);
        }
        else{

            //Create a ref to the parent node to add the input to
            Node parent = traverseToBottom(input, root);
            if (parent != null){

                //Compare input with the parent node to know if it goes on the left or right
                if (input.compareTo(parent.data) < 0){
                    parent.left = new Node(input, parent, null, null);
                }
                else {
                    parent.right = new Node(input, parent, null, null);
                }
            }
            else {
                System.out.println("Whoops sorry it's already here");
            }
        }
    }

    /**
     * Lets you know if a certain element already exists in the tree.
     * @param input     The element you want to check the existence of
     * @return          Whether the input exists in the tree or not
     */
    public boolean contains(T input){
        return traverseToBottom(input, root) == null;
    }

    /**
     * Recursively traverses down the tree and returns the last node possible depending on the input.
     * @param input         The input element that will be added to the tree
     * @param currentNode   The current node the method is going through
     * @return              The reference of the node that should be the parent of the new input
     */
    private Node traverseToBottom(T input, Node currentNode){
        //use commpareTo to traverse donwn the tree
        if (input.compareTo(currentNode.data) < 0){

            //Make sure we're not gonna be returning a null node here
            if (currentNode.left != null){
                return traverseToBottom(input, currentNode.left);
            }
            else return currentNode;
        }
        else if (input.compareTo(currentNode.data) > 0){
            if (currentNode.right != null){
                return traverseToBottom(input, currentNode.right);
            }
            else return currentNode;
        }
        else return null;
    }


    /**
     * Performs an in order traversal of the binary tree. This one I had to google, as I was overcomplicating it sm.
     * @param currentNode   The current node of the search
     */
    public void printInorder(Node currentNode)
    {
        if (currentNode == null)
            return;

        // First recur on left child
        printInorder(currentNode.left);

        // Then print the data of node
        System.out.print(currentNode.data + " ");

        // Now recur on right child
        printInorder(currentNode.right);
    }

    /**
     * Returns the root Node.
     * @return  The root Node
     */
    public Node getRoot(){
        return root;
    }

    /**
     * Private inner Node class to store and link data together. This Node implementation is specifically designed to
     * work for binary trees as it only supports two children
     */
    private class Node {
        T data;
        Node parent;
        Node left;
        Node right;

        /**
         * Constructor that initializes every field in the node based on parameters.
         * @param data      The data you want the node to store
         * @param parent    The parent node you want this node to reference
         * @param left      The left child node you want this node to reference
         * @param right     The right child node you want this node to reference
         */
        public Node(T data, Node parent, Node left, Node right){
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}

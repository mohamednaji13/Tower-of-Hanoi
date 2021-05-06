package towerofhanoi;

import java.util.EmptyStackException;

/**
 * This class creates a linked stack that stores
 * generic objects. Includes a private node class for
 * the access of data
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 * @param <T>
 *            generic type
 * 
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> topNode;
    private int size = 0;

    /**
     * creates a new linked stack
     */
    public LinkedStack() {
        topNode = null; // sets the first node to null
    }


    /**
     * Returns the size of the stack
     * 
     * @return
     *         amount of items in the stack
     */
    public int size() {
        return size;
    }


    /**
     * Checks if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0; // returns true if empty and false if not
    }


    /**
     * Displays the stacks contents enclosed in [] and seperated by ", "
     * 
     * @return
     *         the string with the stacks contents
     */
    public String toString() {
        super.toString();
        Node<T> temp = this.topNode;
        StringBuilder str = new StringBuilder(); // creates new StringBuilder
        str.append("["); // adds the first bracket
        while (temp != null) {
            str.append(temp.data.toString() + ", "); // cycles throw the node
                                                     // chain and displays
                                                     // contents seperated by ",
                                                     // "
            temp = temp.next;

        }
        if (!isEmpty()) {
            str.deleteCharAt(str.length() - 1);
            str.deleteCharAt(str.length() - 1); // if the list is empty, the
                                                // last ", " is removed
        }
        str.append("]"); // adds the enclosing bracket
        return str.toString(); // returns the final string
    }


    /**
     * Adds an object to the stack
     * 
     * @param obj
     *            the object to be added
     */
    @Override
    public void push(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
            // throws IllegalArgumentException
            // if paramter is null
        }
        Node<T> newNode = new Node<T>(obj, topNode);
        // adds a new node with the paramter
        newNode.setNextNode(topNode);
        topNode = newNode; // sets the new node to the top node

        size++; // increments the size

    }


    /**
     * Removes the itewm at the top of the stack and returns it
     * 
     * @return T
     *         the object at the top of the stack
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // throws EmptyStackException if
                                             // stack is empty
        }
        Node<T> temp = topNode;
        // stores the item at the top of the stack
        topNode = temp.getNextNode(); // sets the top node to the next node
        size--; // decrements size
        return temp.data; // returns the item at the top of the stack

    }


    /**
     * Returns the object at the top of the stack without removing it
     * 
     * @return T
     *         the object at the top of the stack's data
     */

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // throws EmptyStackException if
                                             // stack is empty
        }
        Node<T> temp = new Node<T>(topNode.getData());
        return temp.getData(); // returns the top nodes data
    }


    /**
     * clears the stack
     */
    @Override
    public void clear() {
        topNode = null; // sets the top node to null
        size = 0; // sets the size to zero

    }

    /**
     * Private Node Class used for the storage and access of data by the stack
     * 
     * @author <Mohamed Naji> <mohamedn>
     * @version <6/24/2020>
     * @param <T>
     *            generic type
     */
    private static class Node<T> {

        private T data;

        private Node<T> next;

        /**
         * Creates a node
         * 
         * @param t
         *            data stored in the node
         */
        public Node(T t) {
            next = null;
            data = t;

        }


        /**
         * Creates a node that is linked to another node
         * 
         * @param t
         *            the data to be stored
         * @param node
         *            the next node
         */

        public Node(T t, Node<T> node) {
            data = t;
            next = node;
        }


        /**
         * returns the next node in the chain
         * 
         * @return next
         *         the next node
         */
        public Node<T> getNextNode() {
            return next;
        }


        /**
         * Gets the data stored by a node
         * 
         * @return
         *         data stpred
         */
        public T getData() {
            return data;
        }


        /**
         * Sets the next node
         * 
         * @param node
         *            the next node
         */
        public void setNextNode(Node<T> node) {
            next = node;
        }

    }
}

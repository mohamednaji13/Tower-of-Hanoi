package towerofhanoi;

/**
 * Sets the behavior for a stack to implement
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 * @param <T>
 *            generic type
 */
public interface StackInterface<T> {
    /**
     * Adds an object to the top of the stack
     * 
     * @param obj
     *            the object to be added
     */
    public abstract void push(T obj);


    /**
     * Removes the object at the top of the stack and returns it
     * 
     * @return
     *         the object at the top of the stack
     */

    public abstract T pop();


    /**
     * returns object at top of stack without removal
     * 
     * @return
     *         object at the top of the stack
     */

    public abstract T peek();


    /**
     * checks if the stack is empty
     * 
     * @return
     *         true if empty false if not empty
     */

    public abstract boolean isEmpty();


    /**
     * Clears the entire stack
     */
    public abstract void clear();

}

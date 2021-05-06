package towerofhanoi;

import java.util.EmptyStackException;

/**
 * This class tests all the methods of LinkedStack
 * and makes sure they work as expected
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 */
public class LinkedStackTest extends student.TestCase {

    private LinkedStack<Object> stack;
    private LinkedStack<Object> emptyStack; // declares test variables
    private LinkedStack<Integer> stringStack;
    private Object obj3;

    /**
     * Sets up
     */
    public void setUp() {
        stack = new LinkedStack<Object>();
        Object obj1 = new Object();
        Object obj2 = new Object();
        obj3 = new Object();
        stack.push(obj1);
        stack.push(obj2);
        stack.push(obj3);

        emptyStack = new LinkedStack<Object>();

        stringStack = new LinkedStack<Integer>();
        stringStack.push(1);
        stringStack.push(2);
        stringStack.push(3);
    }


    /**
     * Tests the size() method
     */
    public void testSize() {
        assertEquals(stack.size(), 3); // asserts the size of stack is 3
    }


    /**
     * tests the isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(emptyStack.isEmpty()); // asserts emptyStack is empty
        assertFalse(stack.isEmpty()); // asserts stack is not empty
    }


    /**
     * Tests the toString() method
     */
    public void testToString() {
        assertEquals(stringStack.toString(), "[3, 2, 1]");
        // asserts the output is correct
    }


    /**
     * tests the push() method
     */
    public void testPush() {
        Object nullObj = null;
        Exception exceptionNull = null;
        try {
            emptyStack.push(nullObj);
        }
        catch (IllegalArgumentException eNull) {
            exceptionNull = eNull;
        }

        assertNotNull(exceptionNull); // asserts an IllegalArgumentException is
                                      // throw when a null object is added
        Object obj4 = new Object();
        stack.push(obj4);
        assertEquals(stack.peek(), obj4);
        // asserts that obj4 is added to the stack
    }


    /**
     * tests the pop() method
     */
    public void testPop() {
        Exception exception = null;
        try {
            emptyStack.pop();
        }
        catch (EmptyStackException e) {
            exception = e;
        }

        assertNotNull(exception);
        // asserts an EmptyStackException is thrown if
        // an empty stack is popped

        assertEquals(stack.pop(), obj3);
        // asserts obj3 is popped from the stack
    }


    /**
     * Tests the peek() method
     */
    public void testPeek() {
        Exception exception = null;
        try {
            emptyStack.peek();
        }
        catch (EmptyStackException e) {
            exception = e;
        }

        assertNotNull(exception); // asserts an EmptyStackException is thrown if
                                  // an empty stack is peeked

        assertEquals(stack.peek(), obj3); // asserts obj3 is returned when stack
                                          // is
                                          // peeked

    }


    /**
     * tests the clear() method
     */

    public void testClear() {
        stack.clear();
        assertTrue(stack.isEmpty()); // asserts that the stack has been cleared
    }

}

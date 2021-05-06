package towerofhanoi;

/**
 * This class tests all the methods of Tower
 * and makes sure they work as expected
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 */

public class TowerTest extends student.TestCase {
    private Tower tower;
    private Disk disk1; // declares test variables
    private Disk disk2;

    /**
     * Sets up
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
        disk1 = new Disk(1);
        disk2 = new Disk(2);

        tower.push(disk1);
    }


    /**
     * tests the position() method
     */
    public void testPosition() {
        assertEquals(tower.position(), Position.LEFT); // asserts the towers
                                                       // position is left

    }


    /**
     * tests the push() method
     */
    public void testPush() {
        Disk diskNull = null;
        Exception exceptionNull = null;
        try {
            tower.push(diskNull);
        }
        catch (IllegalArgumentException eNull) {
            exceptionNull = eNull;
        }

        assertNotNull(exceptionNull); // asserts IllegalArgumentException is
                                      // thrown if disk is null

        Exception exceptionState = null;
        try {

            tower.push(disk2);
        }
        catch (IllegalStateException eState) {
            exceptionState = eState;
        }

        assertNotNull(exceptionState); // asserts IllegalStateException is
                                       // thrown if width is too large

        tower.pop();
        tower.push(disk2);
        tower.push(disk1);
        assertEquals(tower.peek(), disk1); // asserts the disks were added

    }

}

package towerofhanoi;

/**
 * This class tests all the methods of Disk
 * and makes sure they work as expected
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 */

public class DiskTest extends student.TestCase {
    private Disk disk1;
    private Disk disk2; // Creates disks to test
    private Disk nullDisk;

    /**
     * Sets up
     */
    public void setUp() {
        disk1 = new Disk(5);
        disk2 = new Disk(10);
    }


    /**
     * Tests the toString() method
     */
    public void testToString() {
        assertEquals(disk1.toString(), "5"); // asserts that 5 is returned
    }


    /**
     * Tests the compareTo() method
     */

    public void testCompareTo() {

        Exception exceptionNull = null;
        try {
            disk1.compareTo(nullDisk);
        }
        catch (IllegalArgumentException eNull) {
            exceptionNull = eNull;
        }

        assertNotNull(exceptionNull); // asserts an IllegalArgumentException is
                                      // thrown when compared to null object

        assertTrue(disk1.compareTo(disk2) < 0); // asserts that disk 1 is
                                                // smaller than disk2
    }
}

package towerofhanoi;

/**
 * This class tests all the methods of HanoiSolver
 * and makes sure they work as expected
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 */
public class HanoiSolverTest extends student.TestCase {
    private HanoiSolver solver; // declarees the solver

    private int disks = 5;
/**
 * Sets up
 */
    public void setUp() {
        solver = new HanoiSolver(disks); // creates a HanoiSolver with 5 disks
        for (int i = 0; i < this.solver.disks(); i++) {
            this.solver.getTower(Position.RIGHT).push(new Disk(5 * (solver
                .disks() + 1 - i))); // fills the tower with disks
        }

    }


    /**
     * Tests the getDisks() method
     */
    public void testGetDisks() {
        assertEquals(solver.disks(), 5); // asserts there are 5 disks in solver
    }


    /**
     * Tests the getTower() method
     */
    public void testGetTower() {
        assertEquals(solver.getTower(Position.LEFT).position(), Position.LEFT);
        assertEquals(solver.getTower(Position.RIGHT).position(),
            Position.RIGHT); // asserts the method returns the tower at the
                             // correct position
        assertEquals(solver.getTower(Position.MIDDLE).position(),
            Position.MIDDLE);
        assertEquals(solver.getTower(Position.DEFAULT).position(),
            Position.MIDDLE);
    }


    /**
     * Tests the toString() method
     */
    public void testToString() {
        assertEquals(solver.toString(), "[][][10, 15, 20, 25, 30]"); // asserts
                                                                     // the
                                                                     // methods
                                                                     // output
                                                                     // is
                                                                     // correct
    }


    /**
     * Tests the solve() method
     */

    public void testSolve() {
        solver.solve();
        assertEquals(solver.getTower(Position.LEFT).peek().toString(), "10");
        // asserts all disks have been moved to the left tower and that the top
        // disk has a width of 10

    }
}

package towerofhanoi;

/**
 * This class extends LinkedStack and is specific
 * for type disk. Disks with larger widths cannot be stacked
 * onto disks of smaller widths
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 */

public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * Creates a tower at a certain position
     * 
     * @param p
     *            towers position;
     */
    public Tower(Position p) {
        super(); // calls super constructor
        position = p; // sets position
    }


    /**
     * Returns the tower's position
     * 
     * @return
     *         the towers position
     */
    public Position position() {
        return position; // returns position
    }


    /**
     * Overrides the LinkedStack push method to
     * make it so that disks with larger widths cannot be stacked onto disks
     * with smaller widths
     * 
     * @param d
     *            the disk to be added
     */
    @Override
    public void push(Disk d) {
        if (d == null) {
            throw new IllegalArgumentException(); // throws
                                                  // IllegalArgumentException d
                                                  // is null
        }
        if (this.size() > 0 && this.peek().compareTo(d) <= 0) {
            throw new IllegalStateException(); // Throws IllegalStateException
                                               // if width is larger than this
        }

        super.push(d); // otherwise d is added to the stack

    }

}

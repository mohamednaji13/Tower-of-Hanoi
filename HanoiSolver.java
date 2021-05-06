package towerofhanoi;

import java.util.Observable;

/**
 * This class will solver the Hanoi puzzle
 * using recursion and create the three towers or
 * rods
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 */

@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle; // declares HanoiSolver's variables
    private Tower right;
    private int numDisks;

    /**
     * Creates a new HanoiSolver object
     * 
     * @param num
     *            the number of disks to be added
     */
    public HanoiSolver(int num) {
        numDisks = num; // sets numDisks to the passed paramter
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE); // sets the position of the towers
        right = new Tower(Position.RIGHT);

    }


    /**
     * Returns the number of disks in the puzzle
     * 
     * @return
     *         the number of disks
     */
    public int disks() {
        return numDisks;
    }


    /**
     * Acceses a certain tower based on position
     * 
     * @param pos
     *            the towers position from the enumerator
     * @return
     *         the tower at that position
     */

    public Tower getTower(Position pos) {
        if (pos == Position.LEFT) {
            return left; // returns the left tower if Position.LEFT is passed
        }
        else if (pos == Position.RIGHT) {
            return right; // Returns the right tower if Position.RIGHT is passed
        }
        else {
            return middle; // returns the middle tower if Position.MIDDLE or
                           // Position.DEFAULT is passed
        }
    }


    /**
     * Displays each tower and the widths of the disks inside them in the order
     * left, middle, right
     * 
     * @return
     *         the string of towers
     */

    public String toString() {

        StringBuilder str = new StringBuilder(); // creates a new StringBuilder
                                                 // object
        str.append(this.left.toString()); // adds the left tower
        str.append(this.middle.toString()); // adds the middle tower
        str.append(this.right.toString()); // adds the right tower
        return str.toString(); // returns the final string

    }


    /**
     * moves a disk from a source tower to it's destination
     * 
     * @param source
     *            the tower the disk was initially in
     * @param destination
     *            the tower the disk will be moved to
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop()); // moves the disk on top of the
                                        // destination tower
        setChanged();
        notifyObservers(destination.position());

    }


    /**
     * Solves the Hanoi Tower puzzle using recurrsion
     * 
     * @param currentDisks
     *            the current amount of disks
     * @param startPole
     *            the pole the disks start on
     * @param tempPole
     *            the pole the disks will bve stored on to solve the puzzle
     * @param endPole
     *            the pole the disks are being moved to
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole); // moves the disk to the end pole if there
                                      // is only one

        }
        if (currentDisks > 1) {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            solveTowers(1, startPole, tempPole, endPole); // uses recursion to
                                                          // solve the puzzle by
                                                          // calling the method
                                                          // repeatidly with
                                                          // slightly different
                                                          // parameters
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Solves the puzzle
     */

    public void solve() {
        solveTowers(numDisks, right, middle, left); // solves the puzzle for our
                                                    // certain case being the
                                                    // right pole being the
                                                    // start pole and the left
                                                    // pole beinf the end pole
    }

}

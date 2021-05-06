package towerofhanoi;

import student.TestableRandom;
import java.awt.Color;
import CS2114.Shape;

/**
 * This class implements Comparable and extends
 * Shape and will create a the disks that will be added
 * to the rods.
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 */
public class Disk extends Shape implements Comparable<Disk> {
    /**
     * Creates a disk object with the specified width
     * and a random color.
     * 
     * @param width
     *            specified width
     */
    public Disk(int width) {
        super(0, 0, width, 10); // Calls shapes constructor but uses the width
                                // parameter
        TestableRandom generator = new TestableRandom();
        int color1 = generator.nextInt(255);
        int color2 = generator.nextInt(255);
        int color3 = generator.nextInt(255);
        Color diskColor = new Color(color1, color2, color3); // Chooses a random
                                                             // color for the
                                                             // disk
        setBackgroundColor(diskColor); // sets the disk as that color
    }


    /**
     * Overrides shapes toString() method to display only the disks width
     */
    @Override
    public String toString() {
        return Integer.toString(getWidth()); // returns the disk's width
    }


/*
 * Implements the compareTo() method which must be implemented since the class
 * implements comparable
 */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException("Disk is null"); 
            // throws
            // IllegalArgument
            // Exception if
            // disk is null
        }
        return this.getWidth() - otherDisk.getWidth(); // returns the difference
                                                       // in widths. positive
                                                       // number if this is
                                                       // bigger, negative if
                                                       // otherDisk is bigger,
                                                       // and 0 if they are the
                                                       // same
    }

}

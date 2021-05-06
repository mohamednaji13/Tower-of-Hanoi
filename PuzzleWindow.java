package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;
/**
 * This class will display the rods and disks in a window
 * and solve the puzzle
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle; //declares variables
    private Window window;
    static final int WIDTH_FACTOR =10;
    static final int DISK_GAP= 2;
    static final int DISK_HEIGHT = 10;

    /**
     * Creates a new PuzzleWindow object
     * @param solver
     *        the HanoiSolver object that will solve the puzzle
     */
    public PuzzleWindow(HanoiSolver solver) {
this.game = solver; //sets game to the passed parameter
this.game.addObserver(this);
this.window=new Window("Tower of Hanoi"); //creates the window
this.left=   new Shape(100, 75,10, 200,new Color(100,100,100));
this.middle=new Shape(300, 75,10, 200,new Color(100,100,100)); //creates the 3 rods
this.right=  new Shape(500, 75,10, 200,new Color(100,100,100));

for (int i=0;i<this.game.disks();i++){
    this.game.getTower(Position.RIGHT).push(new Disk(WIDTH_FACTOR*(game.disks()+1-i))); //adds the disks to the right tower
    this.window.addShape(this.game.getTower(Position.RIGHT).peek()); //adds the shape to the rod in the window
    moveDisk(Position.RIGHT); //moves disk to the right
}

this.window.addShape(this.left);
this.window.addShape(this.middle); //adds the 3 rods
this.window.addShape(this.right);

Button solve = new Button("Solve"); //creates the solve button
this.window.addButton(solve, WindowSide.SOUTH); //adds the button
solve.onClick(this); //sets the button to solve the puzzle



    }
/**
 * Moves the disk in the window    
 * @param p
 *        the position to move the disk to
 */
    private void moveDisk(Position p) {
        Disk currentDisk = game.getTower(p).peek();
        Shape currentPole = new Shape(0, 0);
        game.getTower(p);
        if (p == Position.LEFT) {
            currentPole =  this.left;
        }
        if (p == Position.MIDDLE) {
            currentPole = this.middle; //sets the current pole
        }
        if (p == Position.RIGHT) {
            currentPole = this.right;
        }
        if (p == Position.DEFAULT) {
            currentPole = this.middle;
        }
        int x = currentPole.getX(); //gets the x coordinate
        int y=currentPole.getY()+200-(this.game.getTower(p).size()*(DISK_HEIGHT+DISK_GAP)); //gets the y coordinate
        currentDisk.moveTo(x-(currentDisk.getWidth()-10)/2, y); //adds the correct sized disk

    }


/**
 * Updates the program
 */

    public void update(Observable o, Object obj) {
        if(obj.getClass()==Position.class){
            moveDisk((Position)obj);
           
        }
        sleep();
       
    }

/**
 * Shows the individual steps 
 */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }

/**
 * Solves the puzzle when the solve button is clicked
 * @param button
 *        the solveButton
 */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
}

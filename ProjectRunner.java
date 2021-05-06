package towerofhanoi;
/**
 * This class when run my project
 * 
 * @author <Mohamed Naji> 
 * @version <6/24/2020>
 */
public class ProjectRunner {
    public static void main(String[] args){
        int disks = 15;
        if(args.length==1){
            disks=Integer.parseInt(args[0]);
        }
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow window = new PuzzleWindow(solver);
}
}
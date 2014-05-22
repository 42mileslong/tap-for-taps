/**
 * Waits for a period of time, making sure each command is run in a certain period of time
 *
 * See README for documentation
 * @author Rafi Long
 */
public class GameTime {
    /**
     * The amount of time between runs in milliseconds
     */
    private long runTime;

    /**
     * The time in milliseconds when the run starts
     */
    private long startTime;

    /**
     * Time constructor
     * @param runTime the amount of time in a run in milliseconds
     */
    public GameTime(long runTime) {
        this.runTime = runTime;
        Game.consolePrint("Runtime is " + runTime);
    }

    /**
     * Sets the start of the run
     */
    public void setStart() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Starts the wait until the end of the run
     */
    public void startWait() {
        long currentTime = System.currentTimeMillis();

        if (runTime < (currentTime - startTime)) {
            Game.consolePrint("Game is behind by " + (runTime - (currentTime - startTime)));
            return;
        }

        try {
            Thread.sleep(runTime - (currentTime - startTime));
        } catch (InterruptedException e) {
            Game.consolePrint("Sleep failed");
            e.printStackTrace();
        }
    }

    /**
     * Sets the run time to a new number
     * @param runTime a new run time in milliseconds
     */
    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    /**
     * Changes the run time by a multiplier
     * @param percentChange
     */
    public void decreaseRunTime(double percentChange) {
        this.runTime *= percentChange;
    }
}

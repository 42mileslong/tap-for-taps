import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * See README for documentation
 * @author Rafi Long
 */
public class Game {
    /**
     * Whether the game is on or not
     */
    private static boolean gameStatus = false;

    /**
     * Runs commands
     * @param args unused parameter
     */
    public static void main(String args[]) {
        Init.init();
        consolePrint("Starting game");
        startContinuousTap();
    }

    private static void startContinuousTap() {
        gameStatus = true;
        continuousTap.play();
    }

    /**
     * Specialized console print messages with timestamps
     * @param message the message to be printed
     */
    public static void consolePrint(String message) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdf.format(date);
        System.out.println("[System @ " + formattedDate +"] " + message);
    }

    public static class continuousTap {
        /**
         * The mode the game is in: whether the player should click or not
         */
        public enum Mode {READY, OFF};

        /**
         * What mode the game is in
         */
        public static Mode mode = Mode.OFF;

        /**
         * Whether the game has changed or not
         */
        private static boolean changed = false;

        /**
         * Runs the commands for the game
         */
        private static void play() {
            GameTime gameTime = new GameTime(1000);
            while (gameStatus) {
                gameTime.setStart();
                gameTime.startWait();
//                gameTime.decreaseRunTime(4/5);

//                if (mode == Mode.READY && !changed) {
//                    gameStatus = false;
//                }
            }
        }

        /**
         * Switches the mode
         */
        private static void switchMode() {
            if (mode == Mode.OFF) mode = Mode.READY;
            if (mode == Mode.READY) mode = Mode.OFF;
        }
    }
}

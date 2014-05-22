import javax.swing.*;
import java.awt.*;

/**
 * See README for documentation
 * @author Rafi Long
 */
public class Init {
    /**
     * The width of the game (pixels)
     */
    private static int width = 320;

    /**
     * The height of the game (pixels)
     */
    private static int height = 480;

    /**
     * The display
     */
    private static Display display = new Display();

    /**
     * Runs all commands
     */
    public static void init() {
        initDisplay();
    }

    private static void initDisplay() {
        // makes the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // adds display to the frame
        frame.add(display);

        // starts the display loop
        Display.threadPaintStart();
    }

    /**
     * The display class
     */
    public static class Display extends JComponent implements Runnable {
        /**
         * The thread for repainting continuously
         */
        static Thread paint;

        /**
         * Continuously repaints the frame
         */
        private static void threadPaintStart() {
            paint = new Thread(new Display());
            paint.start();
        }

        /**
         * Runs the thread paint, continuously repaints
         */
        @Override
        public void run() {
            Game.consolePrint("Paint thread created");
            while (true) {
                repaint();
            }
        }

        /**
         * Display constructor
         */
        public Display() {
            setSize (width, height);
        }

        /**
         * Paints the game
         * @param g paint variable
         */
        public void paint(Graphics g) {
            super.paint(g);
            paintGame(g);
        }

        //TODO route this to Game.java
        /**
         * Paints the game
         */
        public void paintGame(Graphics g) {
            System.out.println("problem?");
            if (Game.continuousTap.mode == Game.continuousTap.Mode.READY) {
                Game.consolePrint("Painitng colors");
                g.setColor(new Color(0xAFE8BD));
                g.drawRect(0, 0, width, height);
            }
            if (Game.continuousTap.mode == Game.continuousTap.Mode.OFF) {
                g.setColor(new Color(0xE8AFAF));
                g.drawRect(0, 0, width, height);
            }
        }
    }
}
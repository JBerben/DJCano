import ui.GridCanvas;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static int rows = 16;
    public static int cols = 16;

    public static void main(String[] args) {
        // Create an instance of our GridCanvas object and draw invoke Swing to draw.
        SwingUtilities.invokeLater(() -> new GridCanvas(rows, cols));
    }
}

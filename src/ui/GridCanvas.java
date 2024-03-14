package ui;


import javax.swing.*;
import java.awt.*;

/**
 * GridCanvas is a JFrame with extended functions and variables.
 * It takes
 */
public class GridCanvas extends JFrame {

    final String APPLICATION_TITLE = "DJCano";
    final int WINDOW_HEIGHT = 512;
    final int WINDOW_WIDTH = 512;

    private int rows;
    private int cols;

    // Creates a new GridCanvas object, given an amount of rows and cols.
    public GridCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        setTitle(APPLICATION_TITLE);
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // This is where we draw a grid to the canvas.
                drawGrid(g);
            }
        };
        getContentPane().add(panel);

        // Add a component listener to track resizing of the window
        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panel.repaint(); // Repaint the panel when resized
            }
        });

        setVisible(true);
    }

    private void drawGrid(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        int rowHeight = height / rows;
        int colWidth = width / cols;

        // Draw horizontal lines
        for (int i = 0; i < rows; i++) {
            g.drawLine(0, i * rowHeight, width, i * rowHeight);
        }

        // Draw vertical lines
        for (int i = 0; i < cols; i++) {
            g.drawLine(i * colWidth, 0, i * colWidth, height);
        }
    }

}

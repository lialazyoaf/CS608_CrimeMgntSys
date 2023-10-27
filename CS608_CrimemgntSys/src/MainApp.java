package src;
import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        // Create a JFrame (the main window)
        JFrame frame = new JFrame("Swing Application");

        // Create a JLabel (a text label)
        JLabel label = new JLabel("Hello, Swing!");

        // Add the label to the frame's content pane
        frame.getContentPane().add(label);

        // Set the frame size and close operation
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);
    }
}


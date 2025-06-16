import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class GridExample {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;

        JFrame frame = new JFrame("Grid Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.setLayout(new GridLayout(rows, columns));

        for (int i = 1; i <= rows * columns; i++) {
            frame.add(new JButton("Button " + i));
        }
        frame.setVisible(true);
    }
}
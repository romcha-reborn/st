import java.awt.*; import javax.swing.*;
public class DiagonalLines extends JFrame {

    public static void main (String[] args){

        new makeGraphics();

    }
    public static class makeGraphics extends JFrame {
        makeGraphics() {
            createEmptyFrame(500,500);
        }
        public void paintComponent(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.drawLine(10,10,300,300);
        }
    }
    public static JFrame createEmptyFrame(int x, int y) { // Создаём фрейм заданных размеров
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(x,y);
        // frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        frame.setVisible(true);
        return frame;
    }
}

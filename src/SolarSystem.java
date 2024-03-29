import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolarSystem {
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Square Movement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel() {
            private int s1 = 210;
            private int s2 = 200;
            private int x = 0;
            private int y = 0;
            private double dx;
            private double dy;
            private int angle = 0;
            private int radius = 30;
            private double anRad;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.YELLOW);
                g.fillOval(s1, s2, 60, 60);
                g.setColor(Color.GRAY);
                g.fillOval(x,y,20,20);
            }

            private void moveMoon() {
                while(angle < 360) {
                    anRad = Math.toRadians(angle);
                    dx = radius * Math.cos(anRad);
                    dy = radius * Math.sin(anRad);
                    x = (int) dx + s1;
                    y = (int) dy + s2;
                    repaint();
                    angle++;
                    System.out.println(x + " " + y);

                    try {
                        Thread.sleep(20); // Добавляем задержку для анимации
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        }
                    }
            }
            {
                Thread animationThread = new Thread(this::moveMoon);
                animationThread.start();
            }
        };
        frame.add(panel);
        frame.setVisible(true);
        });
    }
}
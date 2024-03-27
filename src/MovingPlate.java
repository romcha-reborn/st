import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingPlate {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Square Movement");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            JPanel panel = new JPanel() {
                private int x = 0;
                private int y = 0;
                private int step = 5;
                private int direction = 0; // 0: right, 1: down, 2: left, 3: up

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, 50, 50);
                }

                private void moveSquare() {
                    switch (direction) {
                        case 0:
                            x += step;
                            if (x >= getWidth() - 50) {
                                direction = 1;
                            }
                            break;
                        case 1:
                            y += step;
                            if (y >= getHeight() - 50) {
                                direction = 2;
                            }
                            break;
                        case 2:
                            x -= step;
                            if (x <= 0) {
                                direction = 3;
                            }
                            break;
                        case 3:
                            y -= step;
                            if (y <= 0) {
                                direction = 0;
                            }
                            break;
                    }
                    repaint();
                }

                {
                    Timer timer = new Timer(100, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            moveSquare();
                        }
                    });
                    timer.start();
                }
            };

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingPlate extends JFrame {
    private JLabel imageLabel;
    private int x;
    private int y;

    public MovingPlate() {
        setTitle("Движущееся изображение");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon("brig.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setSize(200, 200);
        imageLabel.setLocation(0, 0);
        add(imageLabel);
        revalidate();
        setVisible(true);

        x = 0;
        y = 0;

        ActionListener moveAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveImage();
            }
        };

        Timer timer = new Timer(10, moveAction);
        timer.start();
        }

    private void moveImage() {
        x += 1;
        y += 1;
        if (x > getWidth() || y > getHeight()) {
            x = 0;
            y = 0;
            }
        imageLabel.setLocation(x, y);
    }

    public static void main(String[] args) {
        MovingPlate frame = new MovingPlate();
        frame.revalidate();
    }
}
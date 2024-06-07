import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class GrassField {
    GrassField() {}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BufferedImage grass;

            JFrame frame = new JFrame("Поле");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800,600);
            // frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            JPanel panel = new JPanel(new GridLayout(12,16, 0, 0));
            // panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            // Выровнять по центру, горизонтальный промежуток - 50px, вертикальный - 30px
            // FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER, 50, 30);
            // panel.setLayout(flowlayout);

            for (int i = 0; i < 192; i++) {
                try {grass = ImageIO.read(new File("grass.png"));}
                catch (IOException e) {throw new RuntimeException(e);}
                JLabel jg = new JLabel(new ImageIcon(grass));
                jg.setOpaque(true);
                panel.add(jg);
                }
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
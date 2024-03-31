import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarGame {
    public static int randomInt () {
        int rand = (int) (Math.random() * 5);
        return rand;
        }
    public static void raceStart() {
//        try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
        {
            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {raceStart();
                }
            });
            timer.start();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Square Movement");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 700);
            frame.setLayout(new BorderLayout());

            BufferedImage carg = null;
            BufferedImage carv = null;
            BufferedImage caro = null;
            try {
                carg = ImageIO.read(new File("carg.png"));
                carv = ImageIO.read(new File("carv.png"));
                caro = ImageIO.read(new File("caro.png"));
                } catch (IOException e) {throw new RuntimeException(e);}

            JLabel cargl = new JLabel(new ImageIcon(carg));
            JLabel carvl = new JLabel(new ImageIcon(carv));
            JLabel carol = new JLabel(new ImageIcon(caro));

            JLabel label = new JLabel("Race about to begin");
            label.setFont(new Font("Impact", Font.BOLD, 20));

            JPanel panelB = new JPanel();
            panelB.setPreferredSize(new Dimension(700,100));
            panelB.setBackground(Color.gray);
            frame.add(panelB, BorderLayout.NORTH);

            JPanel panelC = new JPanel();
                panelC.setPreferredSize(new Dimension(700, 550));
                panelC.setBackground(Color.GREEN);
                panelC.setLayout(null);

                JPanel car1 = new JPanel();
                car1.add(cargl);
                car1.setBounds(10, 10, 100, 40);
                car1.setOpaque(false);

                JPanel car2 = new JPanel();
                car2.add(carvl);
                car2.setBounds(10, 60, 100, 40);
                car2.setOpaque(false);

                JPanel car3 = new JPanel();
                car3.add(carol);
                car3.setBounds(10, 110, 100, 40);
                car3.setOpaque(false);

                frame.add(panelC, BorderLayout.SOUTH);
                panelC.add(car1);
                panelC.add(car2);
                panelC.add(car3);

            ActionListener raceBegin = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int finish = 670;
                    int car1pos = car1.getX();
                    int car2pos = car2.getX();
                    int car3pos = car3.getX();
                    System.out.println(car1pos);
                    if (car1pos < finish || car2pos < finish || car3pos < finish) {
                        car1pos += randomInt();
                        car2pos += randomInt();
                        car3pos += randomInt();
                        car1.setBounds(car1pos, 10, 100, 40);
                        car2.setBounds(car2pos, 60, 100, 40);
                        car3.setBounds(car3pos, 110, 100, 40);
                        if (car1pos >= finish) {
                            label.setForeground(Color.red);
                            label.setText("Car 1 win the race!");
                        };

                        if (car2pos >= finish) {
                            label.setForeground(Color.red);
                            label.setText("Car 2 win the race!");
                        };
                        if (car3pos >= finish) {
                            label.setForeground(Color.red);
                            label.setText("Car 3 win the race!");
                        };

                        }
                }
            };

            JButton but = new JButton();
            but.setText("Start!");
            panelB.add(but);
            panelB.add(label);

            but.addActionListener(e -> {
                Timer myTimer = new Timer(10, raceBegin);
                myTimer.start();
                label.setForeground(Color.GREEN);
                label.setText("Race!");
                });


            frame.setVisible(true);

        });
    }
}

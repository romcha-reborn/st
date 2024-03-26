import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*; import java.awt.geom.*;

public class TrafficLight extends JFrame {

    public TrafficLight() {
        super("TestWindow"); // Устанавливаем заголовок окна

        setSize(350, 800); // Устанавливаем размер окна
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Устанавливаем действие при закрытии окна
        setLocationRelativeTo(null); // Центрируем окно на экране
        add(new MyDraw());
        setVisible(true); // Делаем окно видимым
        }

    public static void main(String[] args) {
        // JFrame.setDefaultLookAndFeelDecorated(true); // Включаем java-style оформление
        new TrafficLight(); // Создаем и запускаем объект класса TrafficLight
        }
    }

class MyDraw extends JPanel { // Класс рисования интерфейса
    private static final long serialVersionUID = 1L;
    public void paintComponent(Graphics g) { // Переопределение метода paintComponent
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GeneralPath path = new GeneralPath();
        path.moveTo(140, 50);
        path.quadTo(130, 40, 170, 30);
        path.quadTo(210, 40, 200, 50);
        path.closePath();
        g2d.setColor(Color.BLACK); // Закрашиваем фигуру
        g2d.fill(path);

        double cornerRadius = 20;
        RoundRectangle2D rs = new RoundRectangle2D.Double(120, 60, 100, 300, cornerRadius, cornerRadius);
        g2d.fill(rs);

        GeneralPath s1 = new GeneralPath();
        s1.moveTo(110, 130);
        s1.quadTo(105, 135, 100, 130);
        s1.lineTo(60, 90);
        s1.quadTo(55, 85, 60, 80);
        s1.lineTo(100, 80);
        s1.quadTo(110, 80, 110, 90);
        s1.closePath();
        g2d.fill(s1);

        GeneralPath s2 = new GeneralPath();
        s2.moveTo(110, 210);
        s2.quadTo(105, 215, 100, 210);
        s2.lineTo(60, 170);
        s2.quadTo(55, 165, 60, 160);
        s2.lineTo(100, 160);
        s2.quadTo(110, 160, 110, 170);
        s2.closePath();
        g2d.fill(s2);

        GeneralPath s3 = new GeneralPath();
        s3.moveTo(110, 290);
        s3.quadTo(105, 295, 100, 290);
        s3.lineTo(60, 250);
        s3.quadTo(55, 245, 60, 240);
        s3.lineTo(100, 240);
        s3.quadTo(110, 240, 110, 250);
        s3.closePath();
        g2d.fill(s3);

        GeneralPath s4 = new GeneralPath();
        s4.moveTo(230, 90);
        s4.quadTo(230, 80, 240, 80);
        s4.lineTo(280, 80);
        s4.quadTo(285, 85, 280, 90);
        s4.lineTo(240, 130);
        s4.quadTo(235, 135, 230, 130);
        s4.closePath();
        g2d.fill(s4);

        GeneralPath s5 = new GeneralPath();
        s5.moveTo(230, 170);
        s5.quadTo(230, 160, 240, 160);
        s5.lineTo(280, 160);
        s5.quadTo(285, 165, 280, 170);
        s5.lineTo(240, 210);
        s5.quadTo(235, 215, 230, 210);
        s5.closePath();
        g2d.fill(s5);

        GeneralPath s6 = new GeneralPath();
        s6.moveTo(230, 250);
        s6.quadTo(230, 240, 240, 240);
        s6.lineTo(280, 240);
        s6.quadTo(285, 245, 280, 250);
        s6.lineTo(240, 290);
        s6.quadTo(235, 295, 230, 290);
        s6.closePath();
        g2d.fill(s6);

        g2d.setColor(Color.RED);
        g2d.fillOval(140, 90, 60, 60);
        g2d.setColor(Color.yellow);
        g2d.fillOval(140, 180, 60, 60);
        g2d.setColor(Color.green);
        g2d.fillOval(140, 270, 60, 60);

        g2d.setColor(Color.white);
        // Arc2D crescent = new Arc2D.Double(130, 80, 80, 80, 0, 160, Arc2D.CHORD);
        // g2d.fill(crescent);
        GeneralPath s7 = new GeneralPath();
        s7.moveTo(135, 95);
        s7.quadTo(170, 50, 205, 95);
        s7.quadTo(170, 70, 135, 95);
        g2d.fill(s7);


        /* Graphics2D g2 = (Graphics2D) g; // Приведение объекта к Graphics2D для большего функционала
        super.paintComponent(g); 
        g2.setStroke (new BasicStroke (5)); // Задаём текущую толщину обводки в пикселях
        g2.drawRoundRect (50, 20, 200, 100, 20, 20); // Рисуем прямоугольник со скруглёнными краями
        g.fillRect(50, 130, 200, 100); // Рисуем прямоугольник
        g2.drawArc (50, 240, 100, 100, -80, 90);  // Рисуем дугу с заданным углом
        g2d.drawArc (50, 240, 100, 100, -80, 90);
        g2.setColor (Color.YELLOW);
        int[] xPoints = {150, 250, 200}; // Массив x-координат вершин
        int[] yPoints = {300, 300, 350}; // Массив y-координат вершин
        int nPoints = 3; // Количество вершин
        g2.fillPolygon (xPoints, yPoints, nPoints);  // Рисования полигона (здесь треугольник)

        g2.setColor (Color.MAGENTA);  // Цветная надпись
        g2.setFont (new Font ("Arial", Font.BOLD, 20)); // Установка шрифта Arial, жирный, 20
        g2.drawString ("Это сложная фигура", 50, 400); */
        }
    }

class Crescent extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        Arc2D crescent = new Arc2D.Double(50, 50, 100, 100, 45, 270, Arc2D.PIE);
        g2d.fill(crescent);
        }
    }

class TrafficLightPanel extends JPanel {

    private Color red = Color.gray; // Цвет красного сигнала (изначально серый)
    private Color yellow = Color.gray; // Цвет желтого сигнала (изначально серый)
    private Color green = Color.green; // Цвет зеленого сигнала (изначально зеленый)

    public TrafficLightPanel() { // Создаем таймер, который меняет цвета каждую секунду
        Timer timer = new Timer(1000, e -> changeColor()); 
        timer.start(); // Запускаем таймер
        }

    public void changeColor() {
        if (red.equals(Color.red)) { // Если красный сигнал горит
            red = Color.gray; // То делаем его серым
            yellow = Color.yellow; // И делаем желтый сигнал желтым
        } else if (yellow.equals(Color.yellow) && green.equals(Color.gray)) { // Если желтый сигнал горит, а зеленый нет
            yellow = Color.gray; // То делаем желтый сигнал серым
            green = Color.green; // И делаем зеленый сигнал зеленым
        } else if (green.equals(Color.green)) { // Если зеленый сигнал горит
            green = Color.gray; // То делаем его серым
            yellow = Color.yellow; // И делаем желтый сигнал желтым
        } else if (yellow.equals(Color.yellow) && red.equals(Color.gray)) { // Если желтый сигнал горит, а красный нет
            yellow = Color.gray; // То делаем желтый сигнал серым
            red = Color.red; // И делаем красный сигнал красным
        }
        repaint(); // Перерисовываем панель
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Вызываем метод родительского класса
        g.setColor(Color.black); // Устанавливаем цвет графики в черный
        g.fillRect(100, 50, 100, 250); // Рисуем прямоугольник - основу светофора
        g.setColor(red); // Устанавливаем цвет графики в красный
        g.fillOval(125, 75, 50, 50); // Рисуем круг - красный сигнал
        g.setColor(yellow); // Устанавливаем цвет графики в желтый
        g.fillOval(125, 150, 50, 50); // Рисуем круг - желтый сигнал
        g.setColor(green); // Устанавливаем цвет графики в зеленый
        g.fillOval(125, 225, 50, 50); // Рисуем круг - зеленый сигнал
    }
}
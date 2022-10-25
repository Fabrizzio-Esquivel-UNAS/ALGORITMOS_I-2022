package TEMP;
import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {

    public DrawCircle(){
        setTitle("Drawing a Circle");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.drawOval(50, 50, 50, 50);
        g2d.fillOval(50,50,50,50);
        g2d.drawOval(150, 150, 50, 50);
        g2d.fillOval(150,150,50,50);
        g2d.setColor(Color.blue);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawLine(75, 75,175,175);
    }

    public static void main(String[] args) {
       new DrawCircle();
    }
}
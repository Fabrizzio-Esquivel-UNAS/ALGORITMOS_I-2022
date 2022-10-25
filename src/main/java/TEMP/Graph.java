package TEMP;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

class NodesComponent extends JComponent{
    private static class Node{
        final int x;
        final int y;
        final int w;
        final int h;
        final Color color;
        public Node(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.color = Color.BLUE;
        }
    }
    private LinkedList<Node> nodes = new LinkedList<>();
    public void addNode(int src, int dest, int weight, int x, int y){
        nodes.add(new Node(src,dest,weight,x,y));
    }
    public void clearNodes(){
        nodes.clear();
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        for (int i=0; i<nodes.size(); i++){
            Node node = nodes.get(i);
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(4));
            if (nodes.get(node.src)!=nodes.get(i))
                g.drawLine(
                        node.x + (node.w/2), 
                        node.y + (node.h/2),
                        nodes.get(node.src).x + (nodes.get(node.src).w/2),
                        nodes.get(node.src).y + (nodes.get(node.src).h/2)
                );
            if (nodes.get(node.dest)!=nodes.get(i)) 
                g.drawLine(
                        node.x + (node.w/2),
                        node.y + (node.h/2),
                        nodes.get(node.dest).x + (nodes.get(node.dest).w/2), 
                        nodes.get(node.dest).y + (nodes.get(node.dest).h/2)
                );
        }
        for (Node node : nodes){
            g.setColor(Color.BLACK);
            g.drawOval(node.x, node.y, node.w, node.h);
            g.setColor(node.color);
            g2d.fillOval(node.x, node.y, node.w, node.h);
        }
    }
}

public class Graph{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        //Crear componentes
        final NodesComponent comp = new NodesComponent();
        comp.setPreferredSize(new Dimension(800, 600));
        //Crear botones
        JButton newLineButton = new JButton("New Line");
        JButton clearButton = new JButton("Clear");
        //Crear panel de botones
        JPanel buttonsPanel = new JPanel(new MigLayout());
        buttonsPanel.add(newLineButton);
        buttonsPanel.add(clearButton);
        //Crear panel principal
        JPanel contentPane = new JPanel(new MigLayout());
        contentPane.add(comp,"wrap");
        contentPane.add(buttonsPanel, BorderLayout.CENTER);
        //Mostrar frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);

        comp.addNode(0,1,4,25,25);
        comp.addNode(0,2,4,150,75);
        comp.addNode(1,2,2,25,150);
        comp.addNode(2,3,3,275,25);
        comp.addNode(2,5,2,275,150);
        comp.addNode(2,4,4,400,75);
        comp.addNode(3,4,3,525,25);
        comp.addNode(5,4,3,525,150);
        comp.repaint();
    }
}
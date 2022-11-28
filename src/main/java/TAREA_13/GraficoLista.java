package TAREA_13;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GraficoLista extends JPanel{
    GraficoLista(){
        setPreferredSize(new Dimension(800,200));
    }
    private static class Grafico{
        private Color color;
        public Color getColor() {
            return color;
        }
        public void setColor(Color color) {
            this.color = color;
        }
    }
    static class Vertice extends Grafico{
        final int x,y,w,h;
        String nombre;
        public Vertice(int x, int y, Color c, String n) {
            this.x = x;
            this.y = y;
            this.w = 80;
            this.h = 80;
            this.nombre = n;
            super.color = c;
        }
    }
    static class Arista extends Grafico{
        final int origen;
        final int destino;
        public Arista(int origen, int destino) {
            this.origen = origen;
            this.destino = destino;
            super.color = Color.BLACK;
        }
    }
    
    public void agregarVertice(int x, int y, Color c, String n){
        vertices.add(new Vertice(x, y, c, n));
    }
    public void agregarArista(int src, int dest){
        aristas.add(new Arista(src, dest));
    }
    LinkedList<Vertice> vertices = new LinkedList<>();
    LinkedList<Arista> aristas = new LinkedList<>();
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        //Dibujar aristas
        for (Arista a : aristas){
            //Dibujar linea>
            g2d.setStroke(new BasicStroke(8));
            g.setColor(a.getColor());
            Vertice aOrigen = vertices.get(a.origen);
            Vertice aDestino = vertices.get(a.destino);
            int x1 = aOrigen.x + aOrigen.w/2;
            int y1 = aOrigen.y + aOrigen.h/2;
            int x2 = aDestino.x + aDestino.w/2;
            int y2 = aDestino.y + aDestino.h/2;
            g.drawLine(x1,y1,x2,y2);
        }
        //Dibujar vertices
        for (Vertice v : vertices){
            //Dibujar borde
            g.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(8));
            g.drawOval(v.x, v.y, v.w, v.h);
            //Dibujar relleno
            g.setColor(v.getColor());
            g2d.fillOval(v.x, v.y, v.w, v.h);
            //Dibujar letra
            Font f = new Font("TimesRoman", Font.BOLD, 16);
            FontMetrics m = g.getFontMetrics(f);
            g.setFont(f);
            g.setColor(Color.BLACK);
            g.drawString(v.nombre, v.x+(v.w/2)-(m.stringWidth(v.nombre)/2), v.y+6+(v.h/2));
        }        
    }
}
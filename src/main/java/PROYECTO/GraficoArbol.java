package PROYECTO;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GraficoArbol extends JPanel{
    GraficoArbol(){
        setPreferredSize(new Dimension(420,420));
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
        public Vertice(int x, int y) {
            this.x = x;
            this.y = y;
            this.w = 50;
            this.h = 50;
            super.color = Color.BLUE;
        }
    }
    static class Arista extends Grafico{
        final int origen;
        final int destino;
        private int peso;
        public Arista(int origen, int destino, int peso) {
            this.origen = origen;
            this.destino = destino;
            this.peso = peso;
            super.color = Color.BLACK;
        }
        public int getPeso() {
            return peso;
        }
        public void setPeso(int peso) {
            this.peso = peso;
        }
    }
    
    public void agregarVertice(int x, int y){
        vertices.add(new Vertice(x, y));
    }
    public void agregarArista(int src, int dest, int p){
        aristas.add(new Arista(src, dest, p));
    }
    LinkedList<Vertice> vertices = new LinkedList<>();
    LinkedList<Arista> aristas = new LinkedList<>();
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        //Dibujar aristas
        for (Arista a : aristas){
            g2d.setStroke(new BasicStroke(4));
            g.setColor(a.getColor());
            g.drawLine(
                    vertices.get(a.origen).x + vertices.get(a.origen).w/2,
                    vertices.get(a.origen).y + vertices.get(a.origen).h/2,
                    vertices.get(a.destino).x + vertices.get(a.destino).w/2,
                    vertices.get(a.destino).y + vertices.get(a.destino).h/2                    
            );
        }
        //Dibujar vertices
        for (Vertice v : vertices){
            //Dibujar borde
            g.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(4));
            g.drawOval(v.x, v.y, v.w, v.h);
            //Dibujar relleno
            g.setColor(v.getColor());
            g2d.fillOval(v.x, v.y, v.w, v.h);
        }        
    }
}
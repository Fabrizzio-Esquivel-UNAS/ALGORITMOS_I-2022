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
            super.color = Color.WHITE;
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
            //Dibujar peso
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.BOLD, 16));
            g.drawString(Integer.toString(a.peso), (x1+x2-8)/2, (y1+y2+10)/2);
        }
        //Dibujar vertices
        int i=0;
        for (Vertice v : vertices){
            //Dibujar borde
            g.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(8));
            g.drawOval(v.x, v.y, v.w, v.h);
            //Dibujar relleno
            g.setColor(v.getColor());
            g2d.fillOval(v.x, v.y, v.w, v.h);
            //Dibujar letra
            g.setColor(Color.WHITE);
            g.setFont(new Font("TimesRoman", Font.BOLD, 16));
            g.drawChars(Character.toChars(65+i++), 0, 1, v.x-6+(v.w/2), v.y+6+(v.h/2));
        }        
    }
}
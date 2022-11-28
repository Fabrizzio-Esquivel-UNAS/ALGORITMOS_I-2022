package PROYECTO;
import javax.swing.*;
import java.awt.*;

public final class GraficoArbol extends JPanel{
    int V,A,WH,Algoritmo;
    final Color primSelec = new Color(255, 0, 0);
    final Color secSelec = new Color(255, 122, 122);
    final Color bg = new Color(214, 217, 223);
    Font F;
    BasicStroke BS;
    GraficoArbol(int algo){
        //setPreferredSize(new Dimension(420,420));
        this.Algoritmo = algo;
        this.cambiarGrafico(1);
    }
    static class Vertice{
        Color color = Color.BLACK;
        final int x,y;
        public Vertice(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Arista{
        Color color = Color.WHITE;
        final int origen;
        final int destino;
        int peso;
        public Arista(int origen, int destino, int peso) {
            this.origen = origen;
            this.destino = destino;
            this.peso = peso;
        }
    }
    
    public void agregarVertice(int x, int y){
        vertices[V++] = new Vertice(x, y);
    }
    public void agregarArista(int src, int dest, int p){
        aristas[A++] = new Arista(src, dest, p);
    }
    
    public String obtenerParametros(){
        StringBuilder p = new StringBuilder(V+","+A+"\n");
        for (Arista a : aristas){
            p.append(a.origen);
            p.append(",");
            p.append(a.destino);
            p.append(",");
            p.append(a.peso);
            p.append("\n");
        }
        return p.toString();
    }    
    
    public void nuevo(int maxV, int maxA, int wh, int fs){
        V = A = 0;
        WH = wh;
        F = new Font("TimesRoman", Font.BOLD, fs);
        BS = new BasicStroke(fs/2);
        aristas = new Arista[maxA];
        vertices = new Vertice[maxV];
    }
    Vertice[] vertices;
    Arista[] aristas;
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        //Dibujar aristas
        for (Arista a : aristas){
            //Dibujar linea
            g2d.setStroke(new BasicStroke(8));
            g.setColor(a.color);
            Vertice aOrigen = vertices[a.origen];
            Vertice aDestino = vertices[a.destino];
            int x1 = aOrigen.x + WH/2;
            int y1 = aOrigen.y + WH/2;
            int x2 = aDestino.x + WH/2;
            int y2 = aDestino.y + WH/2;
            g.drawLine(x1,y1,x2,y2);
            //Dibujar peso
            g.setColor(Color.BLACK);
            g.setFont(F);
            FontMetrics M = g.getFontMetrics(F);
            String S = Integer.toString(a.peso);
            g.drawString(S, (x1+x2)/2 - (M.stringWidth(S)/2), (y1+y2+10)/2);
        }
        //Dibujar vertices
        int i=0;
        for (Vertice v : vertices){
            //Dibujar borde
            g.setColor(v.color);
            g2d.setStroke(BS);
            g.drawOval(v.x, v.y, WH, WH);
            //Dibujar relleno
            g.setColor(Color.BLUE);
            g2d.fillOval(v.x, v.y, WH, WH);
            //Dibujar letra
            g.setColor(Color.WHITE);
            g.setFont(F);
            g.drawChars(Character.toChars(65+i++), 0, 1, v.x-6+(WH/2), v.y+6+(WH/2));
        }        
    }

    public void cambiarGrafico(int N){
        switch(N){                
            case 1 -> {
                this.nuevo(6,8,50,18);
                final int x0=35,x1=180, y0=20,y1=150;
                this.agregarVertice(x0, y0);
                this.agregarVertice(x0, y0+y1);
                this.agregarVertice(x0+(x1/2), y0+(y1/2));
                this.agregarVertice(x0+x1, y0);
                this.agregarVertice(x0+(x1/2)+x1, y0+(y1/2));
                this.agregarVertice(x0+x1, y0+y1);
                this.agregarArista(0, 1, 4);
                this.agregarArista(0, 2, 4);
                this.agregarArista(1, 2, 2);
                this.agregarArista(2, 3, 3);
                this.agregarArista(2, 5, 2);
                this.agregarArista(2, 4, 4);
                this.agregarArista(3, 4, 3);
                this.agregarArista(5, 4, 3);
            }
            case 2 -> {
                this.nuevo(9,14,40,16);
                final int x0=20,x1=300, y0=20,y1=170;
                this.agregarVertice(x0,        y0+(y1/2));
                this.agregarVertice(x0+(x1/4),   y0);
                this.agregarVertice(x0+(x1/4)*2, y0);
                this.agregarVertice(x0+(x1/4)*3, y0);
                this.agregarVertice(x0+x1,       y0+(y1/2));
                this.agregarVertice(x0+(x1/4)*3, y0+y1);
                this.agregarVertice(x0+(x1/4)*2, y0+y1);
                this.agregarVertice(x0+(x1/4),   y0+y1);
                this.agregarVertice(x0+(x1/4)*2, y0+(y1/2));
                this.agregarArista(0, 1, 4);
                this.agregarArista(0, 7, 8);
                this.agregarArista(1, 2, 8);
                this.agregarArista(1, 7, 11);
                this.agregarArista(2, 3, 7);
                this.agregarArista(2, 5, 4);
                this.agregarArista(2, 8, 2);
                this.agregarArista(3, 4, 9);
                this.agregarArista(3, 5, 14);
                this.agregarArista(4, 5, 10);
                this.agregarArista(5, 6, 2);
                this.agregarArista(6, 7, 1);
                this.agregarArista(6, 8, 6);
                this.agregarArista(7, 8, 7);
            }
            case 3 -> {
                this.nuevo(12,20,30,14);
                final int x0=80,x1=250,x2=15, y0=20,y1=180;
                this.agregarVertice(x0,        y0);
                this.agregarVertice(x0-(x1/4)*1, y0+(y1/3));
                this.agregarVertice(x0+(x1/4)*1, y0+(y1/3));
                this.agregarVertice(x0-(x1/4)*1, y0+(y1/3)*2);
                this.agregarVertice(x0+(x1/4)*1, y0+(y1/3)*2);
                this.agregarVertice(x0,        y0+y1);
                this.agregarVertice(x0+x2+(x1/4)*3,y0);
                this.agregarVertice(x0+x2+(x1/4)*2, y0+(y1/3));
                this.agregarVertice(x0+x2+(x1/4)*4, y0+(y1/3));
                this.agregarVertice(x0+x2+(x1/4)*2, y0+(y1/3)*2);
                this.agregarVertice(x0+x2+(x1/4)*4, y0+(y1/3)*2);
                this.agregarVertice(x0+x2+(x1/4)*3,y0+y1);
                this.agregarArista(0, 1, 13);
                this.agregarArista(0, 2, 6);
                this.agregarArista(1, 2, 7);
                this.agregarArista(1, 3, 1);
                this.agregarArista(2, 3, 14);
                this.agregarArista(2, 4, 8);
                this.agregarArista(2, 7, 20);
                this.agregarArista(3, 4, 9);
                this.agregarArista(3, 5, 3);
                this.agregarArista(4, 5, 2);
                this.agregarArista(4, 9, 18);
                this.agregarArista(6, 7, 15);               
                this.agregarArista(6, 8, 5);               
                this.agregarArista(6, 9, 19);               
                this.agregarArista(6, 10, 10);               
                this.agregarArista(7, 9, 17);               
                this.agregarArista(8, 10, 11);               
                this.agregarArista(9, 10, 16);               
                this.agregarArista(9, 11, 4);               
                this.agregarArista(10, 11, 12);               
            }
            case 4 -> {
                this.nuevo(16,24,20,12);
                final int x0=20,x1=320, y0=15,y1=200;
                this.agregarVertice(x0,y0);              
                this.agregarVertice(x0+(x1/3)*1,y0);            
                this.agregarVertice(x0+(x1/3)*2,y0);
                this.agregarVertice(x0+(x1/3)*3,y0);
                this.agregarVertice(x0,           y0+(y1/3)*1);            
                this.agregarVertice(x0+(x1/3)*1,    y0+(y1/3)*1);            
                this.agregarVertice(x0+(x1/3)*2,    y0+(y1/3)*1);
                this.agregarVertice(x0+(x1/3)*3,    y0+(y1/3)*1);                
                this.agregarVertice(x0,           y0+(y1/3)*2);            
                this.agregarVertice(x0+(x1/3)*1,    y0+(y1/3)*2);            
                this.agregarVertice(x0+(x1/3)*2,    y0+(y1/3)*2);
                this.agregarVertice(x0+(x1/3)*3,    y0+(y1/3)*2);
                this.agregarVertice(x0,           y0+y1);            
                this.agregarVertice(x0+(x1/3)*1,    y0+y1);            
                this.agregarVertice(x0+(x1/3)*2,    y0+y1);
                this.agregarVertice(x0+(x1/3)*3,    y0+y1);
                this.agregarArista(0, 1, 4);
                this.agregarArista(0, 4, 4);
                this.agregarArista(1, 2, 4);
                this.agregarArista(1, 5, 4);
                this.agregarArista(2, 3, 4);
                this.agregarArista(2, 6, 4);
                this.agregarArista(3, 7, 4);
                this.agregarArista(4, 5, 4);
                this.agregarArista(4, 8, 4);
                this.agregarArista(5, 6, 4);
                this.agregarArista(5, 9, 4);
                this.agregarArista(6, 7, 4);
                this.agregarArista(6, 10, 4);
                this.agregarArista(7, 11, 4);
                this.agregarArista(8, 9, 4);
                this.agregarArista(8, 12, 4);
                this.agregarArista(9, 10, 4);
                this.agregarArista(9, 13, 4);
                this.agregarArista(10, 11, 4);
                this.agregarArista(10, 14, 4);
                this.agregarArista(11, 15, 4);
                this.agregarArista(12, 13, 4);
                this.agregarArista(13, 14, 4);
                this.agregarArista(14, 15, 4);
            }
        }        
        //Visualizar el arbol de expansión minima de cada algoritmo
        switch(Algoritmo){
            case 1 -> {
                Kruskal algo = new Kruskal();
                algo.p = this.obtenerParametros();
                algo.Setup();
                algo.MST();
                for (Kruskal.Edge a : algo.MST()){
                    for (int i=0; i<this.A; i++){
                        if (a.src == this.aristas[i].destino && a.dest == this.aristas[i].origen){
                            this.aristas[i].color = primSelec;
                            this.vertices[this.aristas[i].origen].color = secSelec;
                            this.vertices[this.aristas[i].destino].color = secSelec;
                        }
                    }
                }
            }
            case 2 -> {
                Prim algo = new Prim();
                algo.p = this.obtenerParametros();
                algo.Setup();
                algo.MST();
                int parent[] = algo.MST();
                for (int i = 1; i < this.V; i++){                    
                    //System.out.println(parent[i] + " - " + i + "\t" + algo.graph[i][parent[i]]);
                    this.vertices[i].color = primSelec;
                    this.vertices[parent[i]].color = primSelec;
                    for (int j=0; j<this.A; j++){
                        if (
                                ((this.aristas[j].origen==parent[i] && this.aristas[j].destino==i)||(this.aristas[j].origen==i && this.aristas[j].destino==parent[i]))
                                && this.aristas[j].peso == algo.graph[i][parent[i]]
                            ){
                            this.aristas[j].color = secSelec;
                        }
                    }
                }
            }
        }
        this.repaint();
    }
}
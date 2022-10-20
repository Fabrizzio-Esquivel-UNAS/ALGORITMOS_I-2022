package PROYECTO;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Driver extends JFrame {
    Driver(){
        initComponents();
    }
    private void initComponents(){
        setLayout(new BorderLayout());
        /*
        JPanel grafico = new GraficoArbol();
        frame.add(grafico, BorderLayout.CENTER);
        */
        
        GraficoArbol grafico = new GraficoArbol();
        final int x0=20,x1=180, y0=20,y1=150;
        grafico.agregarVertice(x0, y0);
        grafico.agregarVertice(x0, y0+y1);
        grafico.agregarVertice(x0+(x1/2), y0+(y1/2));
        grafico.agregarVertice(x0+x1, y0);
        grafico.agregarVertice(x0+(x1/2)+x1, y0+(y1/2));
        grafico.agregarVertice(x0+x1, y0+y1);
        grafico.agregarArista(0, 1, 4);
        grafico.agregarArista(0, 2, 4);
        grafico.agregarArista(1, 2, 2);
        grafico.agregarArista(2, 3, 3);
        grafico.agregarArista(2, 5, 2);
        grafico.agregarArista(2, 4, 4);
        grafico.agregarArista(3, 4, 3);
        grafico.agregarArista(5, 4, 3);

        Kruskal algoritmoKruskal = new Kruskal(grafico);
        algoritmoKruskal.KruskalMST();
        add(algoritmoKruskal.grafico, BorderLayout.CENTER);
        
        //Frame inicialización
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Driver().setVisible(true);
        });
    }
}

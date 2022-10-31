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

        Kruskal algoritmoKruskal = new Kruskal();
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

package TAREA_13;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

class nodo{
    Color color;
    String fruta;
    int i;
    nodo ant;
    nodo sgte;
    public nodo(Color color, String fruta, int i){
        this.color = color;
        this.fruta = fruta;
        this.ant = this.sgte = null;
        this.i = i;
    }
    String informacion(){
        return this.fruta;
    }
}
class metodo{
    nodo origen, fin;
    int i=0;
    public metodo(){
        this.origen = null;
        this.fin = null;
    }
    void ingresar(Color c, String f){
        nodo newnodo = new nodo(c,f,i);
        if(origen==null){
            fin = origen = new nodo(c,f,i);
        }else{
            newnodo.sgte = origen;
            origen.ant = newnodo;
            origen = newnodo;            
        }
        i += 1;
    }
    GraficoLista mostrarp(){
        int x=25, y=50;
        GraficoLista grafico = new GraficoLista();        
        nodo temp=origen;
        while(temp!=null){

            grafico.agregarVertice(x, y, temp.color, temp.fruta);
            if (temp.ant!=null)
                grafico.agregarArista(temp.ant.i, temp.i);

            System.out.print(temp.informacion()+"\t");
            temp=temp.sgte;
            x += 125;
        }
        return grafico;
    }
    GraficoLista mostrarc(){
        int x=25, y=50;
        GraficoLista grafico = new GraficoLista();
        nodo temp=fin;
        while(temp!=null){
            grafico.agregarVertice(x, y, temp.color, temp.fruta);
            if (temp.sgte!=null)
                grafico.agregarArista(temp.i, temp.sgte.i);

            System.out.print(temp.informacion()+"\t");
            temp=temp.ant;

            x += 125;
        }
        return grafico;
    }
}
public class ListaEnlazada extends JFrame{
    ListaEnlazada(){
        initComponents();
    }
    private void initComponents(){
        setLayout(new BorderLayout());        
        
        metodo m=new metodo();
        m.ingresar(Color.RED, "Manzana");
        m.ingresar(Color.GREEN, "Limon");
        m.ingresar(Color.YELLOW, "Platano");
        m.ingresar(Color.ORANGE, "Naranja");
        m.ingresar(Color.BLUE, "Bayas");
        
        System.out.println("Por Pila");
        add(m.mostrarp(), BorderLayout.NORTH);
        System.out.println("\nPor cola");
        add(m.mostrarc(), BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); 
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ListaEnlazada().setVisible(true);
        });   
    }
}
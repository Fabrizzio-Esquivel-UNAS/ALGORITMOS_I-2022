package TEMP;

class nodo{
    String valor;
    nodo ante = null;
    nodo sgte = null;
    public nodo(String valor) {
        this.valor = valor;
    }
}

class lista{
    nodo inicio, fin;
    void agregar(String v){
        nodo nuevo = new nodo(v);
        if (inicio == null)
            inicio = fin = nuevo;
        else{
            fin.sgte = inicio.ante = nuevo;
            nuevo.ante = fin;
            nuevo.sgte = inicio;
            fin = nuevo;
        }
    }
    void mostrarC(){
        nodo actual = inicio;
        do{
            System.out.print(actual.valor);
            System.out.print(" -> ");
            actual = actual.sgte;            
        }while(actual!=inicio);
        System.out.println(actual.valor + " ...");
    }
    void mostrarP(){
        nodo actual = fin;
        do{
            System.out.print(actual.valor);
            System.out.print(" <- ");
            actual = actual.ante;            
        }while(actual!=fin);
        System.out.println(actual.valor + " ...");
    }
}

public class LISTAS {
    public static void main(String args[]){
        lista L = new lista();
        L.agregar("Hola");
        L.agregar("mundo");
        L.agregar("!");     
        L.mostrarC();
        L.mostrarP();
    }
}

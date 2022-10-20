package PARCIAL_02;

/**
 * CONTEXTO:
 * Se creara un programa para el manejo de venta de productos en una tienda de abarrotes.
 * El cliente pide que se pueda diferenciar los productos por sus caracteristicas de estado fisico y refrigeración.
 */

interface Liquidos{
    double obtenerLitros();
}
interface Solidos{
    double obtenerGramos();
}
interface Refrigerado{
    double obtenerTemperatura();
}
interface Dulce{
    double obtenerAzucar();
}

class Boleta{
    Producto[] productos;
    Boleta(Producto[] lista){
        productos = lista;
    }
    double total(){
        double sum=0;
        for (Producto producto : productos){
            sum+=producto.obtenerPrecio();
        }
        return sum;
    }
}
class Producto{
    String nombre,codigo;
    double precio;
    double obtenerPrecio(){
        return precio;
    };
}
class Leche extends Producto implements Liquidos,Refrigerado{
    String nombre = "Leche";
    String codigo = "23123";
    double precio = 5.0;
    @Override
    public double obtenerLitros(){
        return 0.5;
    }
    @Override
    public double obtenerTemperatura(){
        return 1.2;
    }
    @Override
    public double obtenerPrecio(){
        return this.precio;
    }
}
class Chocolate extends Producto implements Solidos,Dulce{
    String nombre = "Chocolate";
    String codigo = "39012";
    double precio = 3.0;
    @Override
    public double obtenerGramos(){
        return 100;
    }
    @Override
    public double obtenerAzucar(){
        return 500;
    }
    @Override
    public double obtenerPrecio(){
        return this.precio;
    }
}

public class Enunciado_01 {
    public static void main(String[] args){
        Producto[] array = new Producto[5];
        array[0] = new Leche();
        array[1] = new Leche();
        array[2] = new Chocolate();
        array[3] = new Leche();
        array[4] = new Chocolate();
        Boleta laBoleta = new Boleta(array);
        System.out.println(laBoleta.total());
    }
}
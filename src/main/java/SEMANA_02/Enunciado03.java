package SEMANA_02;

import java.util.Random;

class Productos{
    private final String codigo, descripcion;
    private final int cantidad;
    private final double precioUnit;
    Productos(String codigo,String descripcion,int cantidad,double precioUnit){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
    }
    public double precioTotal(){
        return this.cantidad*this.precioUnit;
    }
    public double igv(){
        return this.precioTotal()*0.18;
    }
    public double precioVenta(){
        return this.precioTotal()+this.igv();
    }
}

public class Enunciado03 {
    public static void main(String[] args){
        Random ran = new Random();
        Productos boleta = new Productos("123456","Descripcion",ran.nextInt(100),Math.floor(ran.nextDouble(100)*100)/100);
        System.out.println("El precio total es: "+boleta.precioTotal());
        System.out.println("El IGV es: "+boleta.igv());
        System.out.println("El total (precio de venta) es: "+boleta.precioVenta());
    }
}

package TAREA_06;

interface Rotable{
    abstract public void rotate();
}

abstract class Figura{
    abstract public void area();
}

interface Dibujable{
    abstract public void dibujar();
}

class Cuadrado extends Figura implements Rotable,Dibujable{
    @Override
    public void area(){};
    @Override
    public void rotate(){};
    @Override
    public void dibujar(){};
}

class Circulo extends Figura implements Dibujable{
    @Override
    public void area(){};
    @Override
    public void dibujar(){};
}

public class Enunciado06 {
    static public void main(String[] args){
        Cuadrado objeto1 = new Cuadrado();
        Circulo objeto2 = new Circulo();
        System.out.println(objeto1); //Silencia: "is never read"
        System.out.println(objeto2); //Silencia: "is never read"        
    }
}
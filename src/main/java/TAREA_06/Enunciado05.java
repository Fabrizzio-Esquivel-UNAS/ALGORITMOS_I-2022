package TAREA_06;

interface Figura{
    public double area();
}
class Cuadrado implements Figura{
    private double lado;
    @Override
    public double area(){
        return lado*lado;
    }
}
class Circulo implements Figura{
    private double radio;
    @Override
    public double area(){
        return Math.PI*Math.pow(radio,2);
    }
}
public class Enunciado05 {
    static public void main(String[] args){
        Cuadrado objeto1 = new Cuadrado();
        Circulo objeto2 = new Circulo();
        System.out.println(objeto1); //Silencia: "is never read"
        System.out.println(objeto2); //Silencia: "is never read"
    }
}
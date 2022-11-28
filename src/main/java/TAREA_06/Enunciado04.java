package TAREA_06;

public class Enunciado04 {
    static abstract class Figura{
        public static double x,y;
        public abstract double area();
    }

    static class Cuadrado extends Figura{
        private double lado;
        @Override
        public double area(){
            return lado*lado;
        }
    }

    static class Circulo extends Figura{
        private double radio;
        @Override
        public double area(){
            return Math.PI*radio;
        }
    }
    public static void main(String[] args){
        Cuadrado objeto1 = new Cuadrado();
        Circulo objeto2 = new Circulo();
        System.out.println(objeto1); //Silencia: "is never read"
        System.out.println(objeto2); //Silencia: "is never read"
    }
}
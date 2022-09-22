package TAREA_02;
import java.util.Scanner;

class Circle{
    private final double diameter;
    Circle(double diameter){
        this.diameter = diameter;
    }
    double radius(){
        return diameter/2;
    }
    double area(){
        double radius2 = Math.pow(this.radius(),2);
        return Math.PI*radius2;
    }
}

public class Enunciado02 {
   public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       System.out.println("Digite el diametro del Circulo: ");
       Circle circulo = new Circle(input.nextDouble());
       System.out.println("El area del Circulo es: "+circulo.area());
   }
}
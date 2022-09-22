package TAREA_02;
import java.util.Scanner;

class Triangle {
    private final double cat1,cat2;
    public Triangle(double cat1, double cat2){
        this.cat1 = cat1;
        this.cat2 = cat2;
    }
    public double hypotenuse(){
        double sum = Math.pow(cat1,2) + Math.pow(cat2,2);
        return Math.sqrt(sum);
    }
}

public class Enunciado01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite los (2) catetos del Triangulo: ");
        Triangle figure = new Triangle(input.nextDouble(),input.nextDouble());
        System.out.println("LA HIPOTENUSA DEL TRIANGULO ES: " + figure.hypotenuse());
    }
}

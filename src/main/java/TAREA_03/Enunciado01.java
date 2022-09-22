package TAREA_03;
import java.util.Scanner;

public class Enunciado01 {
    public static void main(String[] args){
        final int CANT = 3;
        Double prom=0.0, menor=null;
        Scanner input = new Scanner(System.in);
        for (int i=1; i<=CANT; i++){
            System.out.print("Ingrese el N°"+i+": ");
            double num = input.nextDouble();
            menor = menor==null?num:(num<menor?num:menor);
            prom += num/CANT;
        }
        System.out.println("\nMedia de todos los números: "+prom);
        System.out.println("El número más pequeño: "+menor);        
    }
}

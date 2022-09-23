package TAREA_06;

interface Interface1{};
interface Interface2{};
interface Interface3{};
class ClaseBase{}
class ClaseDerivada extends ClaseBase implements Interface1,Interface2,Interface3{}

public class Enunciado03 {
    public static void main(String[] args){
        ClaseDerivada objeto = new ClaseDerivada();
        System.out.println(objeto); //Silencia: "is never read"
    }
}

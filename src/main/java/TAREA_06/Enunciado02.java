package TAREA_06;

interface Nomina{};
class Object{};
class Empleado extends Object implements Nomina{};

public class Enunciado02 {
    public static void main(String main[]){
        Empleado objeto = new Empleado();
        System.out.println(objeto); //Silencia: "is never read"
    }
}
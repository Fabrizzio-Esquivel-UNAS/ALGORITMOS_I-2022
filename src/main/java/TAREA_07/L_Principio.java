package TAREA_07;
/**
 * 3° Principio de Sustitución de Liskov:
 * Toda superclase debe ser capaz de reemplazarse con sus subclases, sin
 * romper el programa; Con seguir este principio ya se está cumpliendo 
 * implicitamente el princpio Open-Closed.
 * EJEMPLO:
 * Siguiendo el ejemplo presentado en el principio Open-Closed, se va a 
 * reemplazar la superclase Pokemon con la subclase Pikachu y el programa aún 
 * deberia poder funcionar.
 */
public class L_Principio {
    static class Pikachu{
        public void atacar(){
            System.out.println("Pikachu ataca!");
        };
    }
    static class Pokemon extends Pikachu{
        @Override
        public void atacar(){
            System.out.println("Un pokemon ataca!");
        };
    }
    static public void main(String[] args){
        Pokemon pokemon1 = new Pokemon();
        pokemon1.atacar();
    }
}
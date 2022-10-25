package TAREA_07;
/**
 * 2° Principio de Abierto-Cerrado:
 * A todo modulo se le debe poder añadir más cosas, pero sin necesidad de 
 * modificar el codigo que ya existe.
 * EJEMPLO:
 * Tenemos la superclase Pokemon, de la cual se extienden las demás clases que 
 * representan a un pokemon distinto. Si necesitaramos añadir a un nuevo 
 * pokemon, se debe poder hacer sin alterar a la clase de otros pokemones.
 */
public class O_Principio {
    static public void main(String[] args){
        Pikachu pokemon1 = new Pikachu();
        Sprigatito pokemon2 = new Sprigatito();
        pokemon1.atacar();
        pokemon2.atacar();
    }
}

class Pokemon{
    public void atacar(){
        System.out.println("Un pokemon ataca!");
    };
}
class Pikachu extends Pokemon{
    @Override
    public void atacar(){
        System.out.println("Pikachu ataca!");
    };
}
//Nuevo pokemon: Sprigatito
class Sprigatito extends Pokemon{
    @Override
    public void atacar(){
        System.out.println("Sprigatito ataca!");
    };
}
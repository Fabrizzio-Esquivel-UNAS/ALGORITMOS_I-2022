package TAREA_07;

/**
 * 1° Principio de Responsabilidad Unica:
 * Una clase debe estar encargada de hacer un solo un tipo de trabajo.
 * POR EJEMPLO:
 * La clase Jugador representa a un personaje de un videojuego que un jugador
 * va a controlar, por lo que sus atributos y metodos SOLO deben ser aquello
 * que se supone que dicho personaje pueda tener o hacer.
 */
class Jugador{
    void mover(){
        System.out.println("Jugador se movió");
    }
    void saltar(){
        System.out.println("Jugador saltó");
    }
    //void cambiarMapa(){};
    /** 
     * El jugador NO DEBE estar encagado de cambiar el mapa, cada mapa puede que
     * cambie de manera distinta, por lo que es necesario separarlo en otra clase.
     */
}
class Mapa{
    void cambiar(){
        System.out.println("Mapa cambiado");
    };
}

public class S_Principio {
    static public void main(String[] args){
       Mapa mapa1 = new Mapa();
       Jugador jugador1 = new Jugador();
       jugador1.mover();
       jugador1.saltar();
       mapa1.cambiar();
    }
}

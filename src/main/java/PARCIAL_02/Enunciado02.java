package PARCIAL_02;

interface Arma{
    void disparar();
}
interface Trabajo{
    void trabajar();
}
interface Persona{
    void caminar();
}

/**
 * Interface Segregation Principle:
 * El trabajador no tiene que disparar por lo que no es necesario implementar un Arma.
 * El ladron no trabaja por lo que no se implementa trabajar pero sí puede disparar por lo que se le implementa un Arma.
 */
class Constructor implements Persona{
    @Override
    public void caminar(){
        System.out.println("El Constructor camina al trabajo");
    };
    public void trabajar(){
        System.out.println("El Constructor trabaja");
    };    
}
class Ladron implements Persona,Arma{
    @Override
    public void caminar(){
        System.out.println("El Ladron camina sospechosamente");
    };
    public void robar(){
        System.out.println("El Ladron roba a alguien");        
    };
    @Override
    public void disparar(){
        System.out.println("El Ladron dispara");
    }
}

/**
 * Dependency Inversion Principle :
 * La clase amigo no depende del oficio que tenga,
 * lo que permite que en cualquier momento pueda pasar de Constructor a Ladron.
 */
class Amigo{
    Persona oficio;
    Amigo(Persona oficio){
        this.oficio = oficio;
    }
    void cambiarOficio(Persona oficio){
        this.oficio = oficio;
    }
    void caminarOficio(){
        this.oficio.caminar();
    }
}

public class Enunciado02 {
    public static void main(String[] args){
        Amigo miAmigo = new Amigo(new Constructor());
        miAmigo.caminarOficio();
        miAmigo.cambiarOficio(new Ladron());
        miAmigo.caminarOficio();
    }
}

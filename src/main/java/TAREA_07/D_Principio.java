package TAREA_07;
/**
 * 5° Princpio de Inversión de Dependencias
 * Los modulos tanto de alto como de bajo nivel deben depender de interfaces 
 * y clases abstractas.
 * EJEMPLO:
 * Tenemos la clase Pokemon la cual tiene como atributo un Elemento. Pero debido 
 * a que existen diferentes tipos de elementos (normal, agua, fuego, etc.) 
 * entonces Elemento debe ser una interface la cual implementen los demás tipos
 * de Elementos en forma de clases.
 */
public class D_Principio {
    static public void main(String[] args){
        Pokemon charmander = new Pokemon(new Fuego());
        Pokemon squirtle = new Pokemon(new Agua());
        charmander.debilidad();
        squirtle.debilidad();
    }
}
interface Elemento{
    void debilidad();
}
class Fuego implements Elemento{
    @Override
    public void debilidad(){
        System.out.println("Pokemon tipo Fuego es debil contra Agua");
    }
}
class Agua implements Elemento{
    @Override
    public void debilidad(){
        System.out.println("Pokemon tipo Agua es debil contra Electricidad");
    }    
}
class Pokemon{
    private final Elemento tipo;
    Pokemon(Elemento t){
        this.tipo = t;
    }
    public void debilidad(){
        tipo.debilidad();
    }
}
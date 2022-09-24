package TAREA_07;

/**
 * 4° Principio de Segregación de Interfaces:
 * No se debe obligadar a utilizar metodos de interfaces que no se necesitan.
 * EJEMPLO:
 * En un videojuego tenemos 2 tipos de armas: Armas cuerpo a cuerpo y Armas a 
 * distancia, por lo tanto, debemos utilizar 2 interfaces distintas. De esa 
 * manera se estaran usando solo los metodos necesarios para cada tipo de arma.
*/
interface armaCuerpo{
    abstract public void atacar();
}
interface armaDistancia{
    abstract public void atacar();
    abstract public void recargar();
}
/**
 * Si utilizaramos la interface armaDistancia para la clase Cuchillo
 * entonces tendriamos no tendriamos que utilizar el metodo recargar(), 
 * ya que no tiene sentido que un Cuchillo se recarge.
*/
class Cuchillo implements armaCuerpo{
    @Override
    public void atacar(){
        System.out.println("El cuchillo apuñala");
    }
}
class Pistola implements armaDistancia{
    @Override
    public void atacar(){
        System.out.println("La pistola dispara");
    }
    @Override
    public void recargar(){
        System.out.println("La pistola recarga");
    }
}

public class I_Principio {
    static public void main(String[] args){
        Cuchillo arma1 = new Cuchillo();
        Pistola arma2 = new Pistola();
        arma1.atacar();
        arma2.atacar();
        arma2.recargar();
    }
}

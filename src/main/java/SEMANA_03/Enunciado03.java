package SEMANA_03;
import java.util.Random;
import java.util.ArrayList;

class Generator {
    Random ran = new Random();
    String abc = "abcdefghijklmnopqrstuvwxyz";
    public String nextName(){
        String name = "";
        for (int i=0; i<3+ran.nextInt(4); i++){
            char letter = abc.charAt(ran.nextInt(abc.length()));
            if (i==0) letter = Character.toUpperCase(letter);
            name += String.valueOf(letter);
        }
        return name;
    }
    public String nextGender(){
        String gender = ran.nextBoolean()==true?"Macho":"Hembra";
        return gender;
    }
}

class Perro{
    String nombre,sexo;
    Perro (String nombre, String sexo){
        this.nombre = nombre;
        this.sexo = sexo;
    }
}

public class Enunciado03 {
    public static void main(String[] args){
        Generator ranPet = new Generator();
        ArrayList<Perro> vector = new ArrayList<>();
        for (int i=0; i<10; i++){
            Perro mascota = new Perro(ranPet.nextName(),ranPet.nextGender());
            vector.add(mascota);
        }
        for (Perro mascota : vector){
            System.out.println("NOMBRE: "+mascota.nombre+"\tSEXO: "+mascota.sexo);
        }
    }
}

package TAREA_03;
import java.util.ArrayList;
import java.util.Random;

public class Enunciado02 {
    public static void main(String[] args){
        Random ran = new Random();
        ArrayList<Integer> vector = new ArrayList<>();
        for (int i=0; i<10; i++){
            vector.add(ran.nextInt(100));
        }
        System.out.print("\t\t\t\t  ANTES -> DESPUES");
        for (int num=0; num<vector.size()-1; num++){
            int mayor = num;
            boolean cambios = false;
            for (int i=num+1; i<vector.size(); i++){
                if (vector.get(i)>vector.get(mayor)) {
                    mayor = i;
                    cambios = true;
                }
            }
            if (cambios) System.out.print("\n"+vector+" -> ");
            Integer aux = vector.get(num);
            vector.set(num,vector.get(mayor));
            vector.set(mayor,aux);
            if (cambios) System.out.print(vector);
        }
        System.out.print("\n\nFINAL: "+vector);
    }
}

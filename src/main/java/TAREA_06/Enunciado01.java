package TAREA_06;

interface InterfaceA{}
interface InterfaceB{}
class ClassA{}
class ClassB extends ClassA implements InterfaceA,InterfaceB{}

public class Enunciado01 {
    public static void main(String[] args){
        ClassB objeto = new ClassB();
        System.out.println(objeto); //Silencia: "is never read"
    }
}

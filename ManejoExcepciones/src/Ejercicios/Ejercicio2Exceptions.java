package Ejercicios;

public class Ejercicio2Exceptions{
    void miMetodo(){
        int numero[]=new int[5];
        try{
            System.out.println("Accesando a una posicion fuera del vector");
            numero[7]=0;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println ("Terrible");
        }
    }
}

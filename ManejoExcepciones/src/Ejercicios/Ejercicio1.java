package Ejercicios;

public class Ejercicio1 {
    public static void main(String args[]) throws Ejercicio1Exceptions{
        try {
            int numero[] = new int[5];
            int indice = 7;
            if (indice > numero.length){
                throw new Ejercicio1Exceptions();
            }

        } catch (Ejercicio1Exceptions e) {
            e.printStackTrace();
        }
    }

}

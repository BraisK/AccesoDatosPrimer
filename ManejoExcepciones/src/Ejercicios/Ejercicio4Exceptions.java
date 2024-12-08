package Ejercicios;

import java.awt.*;

/*
En un mismo segmento de código se pueden generar más de una excepción por
diferentes motivos, por lo tanto dicho segmento puede tener un bloque catch para cada
excepción. Completa los dos bloques match, el primero captura la excepción que se
produce al dividir por cero y el segundo al acceder a una posición fuera del vector.
* */
public class Ejercicio4Exceptions {
    public static void main(String[] args) {
        divide();
        System.out.println("Finiquité");
    }

    static void divide() {
        int num[] = {4, 8, 16, 32, 64, 128, 256};


        int den[] = {2, 0, 4, 4, 0, 8};
        for (int i = 0; i < num.length + 1; i++) {
            try {
                System.out.println(num[i] + "/" + den[i] + "=" + num[i] / den[i]);
            } catch (ArithmeticException e) {
                System.out.println("Errorcito " + e.getMessage() + "  agora se entendo");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Sa matao paco");
            }
        }

    }
}

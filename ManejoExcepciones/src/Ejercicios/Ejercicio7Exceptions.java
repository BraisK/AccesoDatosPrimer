package Ejercicios;
/* 7.- Completa los dos bloques catch del ejemplo siguiente. El primero atrapa la
excepción que se produce cuando se divide entre cero, el segundo atrapa la excepción
que se produce cuando se accede a una posición fuera del vector.
Diseña el bloque finally que se ejecuta siempre tanto si se produce excepción como no.
Este bloque contiene la orden: System.out.println("Ejecutando código de limpieza");
*/

public class Ejercicio7Exceptions {
    public static void main(String[] args) {
        generaExcepcion(2);
    }
    public static void generaExcepcion(int i) {
        int t;
        int num[] = {2, 4, 6};
        System.out.println("Recibiendo " + i);
        try {
            switch (i) {
                case 0:
                    t = 10 / i; //division por cero
                    break;
                case 1:
                    num[4] = 4; //genera un error
                    break;
                case 2:
                    System.out.println("Ta bueno");
                    return;
            }
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre 0");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Te pasaste");
        } finally {
            System.out.println("Ejecutando código de limpieza");
        }
    }
}

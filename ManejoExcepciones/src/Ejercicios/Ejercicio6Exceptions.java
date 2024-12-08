package Ejercicios;

/*Los bloques try se pueden anidar y así permitir diferentes niveles de errores, que
serán manejados de diferentes formas. Algunos de estos errores son menores y pueden
arreglarse fácilmente, pero otros son catastróficos y no se pueden corregir. Un método
comúnmente empleado por los programadores es usar un bloque externo try para
atrapar los errores graves y bloques internos try para el control de los errores
sencillos. Prueba el programa siguiente que usa bloques try anidados:

 */
public class Ejercicio6Exceptions {
    public static void main(String args[]) {
        int num[] = {4, 8, 16, 32, 64, 128, 256, 512};
        int den[] = {2, 0, 4, 4, 0, 8};
        try {
            for (int i = 0; i < num.length; i++) {
                try {
                    System.out.println(num[i] + "/" + den[i] + "=" + num[i] / den[i]);
                } catch (ArithmeticException Excep) {
                    System.out.println("División por cero Posicion: " + i);
                }
            }
        } //try externo
        catch (Throwable Excep) {
            System.out.println("Ocurrio una excepcion fatal "+ Excep.getMessage());
        }
        System.out.println("El programa continu aqui");
    }
}

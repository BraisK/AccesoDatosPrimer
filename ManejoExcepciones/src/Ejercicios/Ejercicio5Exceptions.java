package Ejercicios;

/*En el ejemplo siguiente se deberán completar los dos bloques catch, el primero atrapa
específicamente la excepción que se produce cuando se accede fuera del límite del
vector, el segundo atrapa cualquier excepción que se produzca en la superclase
throwable.

 */
public class Ejercicio5Exceptions {
    public static void main(String args[]) {
        int num[] = {4, 8, 16, 32, 0, 128, 256, 512};
        int den[] = {2, 0, 4, 4, 0, 8};
        for (int i = 0; i < num.length; i++) {
            try {
                System.out.println(num[i] + "/" + den[i] + "=" + num[i] / den[i]);
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Te pasaste");
            }
            catch (Throwable e){
                System.out.println(e.getMessage());
            }

        }
    } // fin de main
}


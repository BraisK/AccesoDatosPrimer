package Ejercicios;

public class Ejercicio1Exceptions extends Exception {
    public Ejercicio1Exceptions() {
        super("Te has pasado");
    }
    public Ejercicio1Exceptions(String message) {
        super(message);
    }
    public Ejercicio1Exceptions(String message, Throwable cause) {
        super(message, cause);
    }

}

package src;

import java.io.File;

/**
 * Crear un programa en Java que borre el fichero cuya ruta ha sido introducida por el
 * usuario.
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        File crear = GestionFicheros.crearArchivo("borrar.txt");
        File borrar = GestionFicheros.seleccionFichero();
        if (borrar.exists()){
            try {
                borrar.delete();
            } catch (Exception e){
                System.out.println("Se ha producido un error");
            }
        }
    }
}

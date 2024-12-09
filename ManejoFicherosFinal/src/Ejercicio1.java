package src;

import java.io.File;

/**
 * Escribir un programa en Java que para cualquier ruta indicada por el usuario,
 * muestre:
 *  Si el fichero existe o no
 *  Si se trata de un directorio o de un fichero
 *  En caso de ser un fichero, debe mostrar los siguientes datos:
 * o Nombre
 * o Tamaño
 * o Permisos de lectura y escritura
 */
public class Ejercicio1 {
    public static void mostrarInformacionRuta(File ruta) {
        if (ruta.exists()) {
            System.out.println("El fichero/directorio existe.");
            if (ruta.isFile()) {
                System.out.println("Es un fichero.");
                System.out.println("Nombre: " + ruta.getName());
                System.out.println("Tamaño: " + ruta.length() + " bytes");
                System.out.println("Permiso de lectura: " + (ruta.canRead() ? "Sí" : "No"));
                System.out.println("Permiso de escritura: " + (ruta.canWrite() ? "Sí" : "No"));
            } else if (ruta.isDirectory()) {
                System.out.println("Es un directorio.");
            }
        } else {
            System.out.println("El fichero/directorio no existe.");
        }
    }

    public static void main(String[] args) {


        File ruta = GestionFicheros.seleccionFichero();

        if (ruta != null) {
            mostrarInformacionRuta(ruta);
        } else {
            System.out.println("No se seleccionó ninguna ruta.");
        }
    }
}

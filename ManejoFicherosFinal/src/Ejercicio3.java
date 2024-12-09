import javax.swing.*;
import java.io.File;

/**
 * Partiendo del fichero de csv de ejemplo, crear un programa de Java que permita al
 * usuario añadir datos nuevos a ese fichero, utilizando el mismo formato que los ya
 * existentes.
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        File ficheroRestaurantes=GestionFicheros.seleccionFicheroCSV();
        String nombre,direccion,ciudad,provincia,codigo;
        nombre= JOptionPane.showInputDialog(null, "Introduce nombre");
        direccion = JOptionPane.showInputDialog(null,"Introduce direccion");
        ciudad = JOptionPane.showInputDialog(null,"Introduce ciudad");
        provincia = JOptionPane.showInputDialog(null,"Introduce provincia");
        codigo = JOptionPane.showInputDialog(null,"Introduce codigo");
        String linea= nombre+";"+direccion+";"+ciudad+";"+provincia+";"+codigo;
        GestionFicheros.anhadirLineaCSV(ficheroRestaurantes, linea);


    }
}

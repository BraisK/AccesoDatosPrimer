import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Partiendo del fichero de csv de ejemplo, crear un programa de Java que muestre los
 * datos de todos aquellos restaurantes cuyo código postal empiece por 6.
 *
 */
public class Ejercicio2 {
    public static void main(String[] args) {

        File restaurantes = GestionFicheros.seleccionFicheroCSV();
        if (restaurantes.exists()) {
            try {
                FileReader fr = new FileReader(restaurantes);
                BufferedReader br = new BufferedReader(fr);
                String linea = null;
                while( (linea= br.readLine()) != null){
                    String[] datos = linea.split(";");
                    String zipcode = datos[4];

                    if (zipcode.startsWith("6")){
                         System.out.println(linea);
                    }
                }

            } catch (Exception e){
                System.out.println("Se ha producido un error al leer el fichero");
            }
        }
    }
}

package src;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Partiendo del fichero de csv de ejemplo, crear un programa de Java que cree una
 * copia de ese fichero llamada “Restaurants2.csv” que contenga los mismos datos
 * excepto aquellos correspondientes a los restaurantes cuyo código postal empieza por
 * 6.
 */

public class Ejercicio4 {
    public static void main(String[] args) {


        File ficheroRestaurantes=GestionFicheros.seleccionFicheroCSV();
        File ficheroSalida= GestionFicheros.crearFicheroCSV("restaurantesFiltados.csv");
        if (ficheroRestaurantes.exists()) {
            try {
                FileReader fr = new FileReader(ficheroRestaurantes);
                BufferedReader br = new BufferedReader(fr);
                String linea = null;

                while ( (linea=br.readLine()) != null) {
                    String[] datos = linea.split(";");
                    String zipcode = datos[4];
                    if (!zipcode.startsWith("6")) {
                        GestionFicheros.anhadirLineaCSV(ficheroSalida, linea);
                    }
                }

            } catch (Exception e){
                System.out.println("Se ha producido un error");
            }
        }
    }
}

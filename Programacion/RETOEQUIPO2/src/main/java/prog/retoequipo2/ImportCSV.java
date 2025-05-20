/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *Clase que se encarga de pasar datos de un CSV a objetos tipo ruta
 * 
 * @author Guille
 */
public class ImportCSV {
/**
 *El método se encarga de importar los datos de una ruta desde un archivo formato CSV
 * 
 * @author Guille
 * @param archivoCSV el archivo del que se extraen los datos
 * @param txtNomRuta el nombre del campo que recibe el nombre de la ruta que se debe rellenar
 * @param txtLatIni el nombre del campo que recibe la latitud inicial a rellenar
 * @param txtLongIni el nombre del campo que recibe la longitud inicial a rellenar
 * @param txtLatFin el nombre del campo que recibe la latitud final a rellenar
 * @param txtLongFinal el nombre del campo que recibe la longitud final a rellenar
 * @param txtDistancia el nombre del campo que recibe la distancia a rellenar
 * @param txtDuracion el nombre del campo que recibe la duracion de la ruta a rellenar
 * @param txtDesnivel el nombre del campo que recibe el desnivel total de la ruta
 * @param txtLatMax el nombre del campo que recibe la latitud máxima de la ruta
 * @param txtLonMax el nombre del campo que recibe la longitud máxima de la ruta
 * @param cmbTipoRuta el nombre del campo que recibe el tipo de ruta de la que se trata
 */
        public static void importar(File archivoCSV,JTextField txtNomRuta,JTextField txtLatIni,
                                JTextField txtLongIni,JTextField txtLatFin,JTextField txtLongFinal,
                                JTextField txtDistancia,JTextField txtDuracion,JTextField txtDesnivel,
                                JTextField txtLatMax,JTextField txtLonMax,JComboBox<String> cmbTipoRuta) {
        try {
            if (archivoCSV == null || !archivoCSV.exists()) {
                throw new IllegalArgumentException("El archivo no existe.");
            }

            BufferedReader reader = new BufferedReader(new FileReader(archivoCSV));
            String linea;

            String[] general = reader.readLine().split(",", -1);
            txtNomRuta.setText(general[0].trim());

            double latIni = 0, lonIni = 0;
            double latFin = 0, lonFin = 0;
            double latMax = -Double.MAX_VALUE, lonMax = -Double.MAX_VALUE;
            double distanciaTotal = 0;
            double desnivelPos = 0, desnivelNeg = 0;
            double altAnterior = 0;
            boolean primerPunto = true;
            LocalDateTime tiempoIni = null, tiempoFin = null;

            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

            double latAnterior = 0, lonAnterior = 0;

            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("TRK")) {
                    String[] partes = linea.split(",", -1);
                    double lat = Double.parseDouble(partes[2]);
                    double lon = Double.parseDouble(partes[3]);
                    double alt = Double.parseDouble(partes[4]);
                    LocalDateTime tiempo = LocalDateTime.parse(partes[5], formatter);

                    if (primerPunto) {
                        latIni = lat;
                        lonIni = lon;
                        tiempoIni = tiempo;
                        altAnterior = alt;
                        primerPunto = false;
                    } else {
                        distanciaTotal += calcularDistancia(latAnterior, lonAnterior, lat, lon);

                        double deltaAlt = alt - altAnterior;
                        if (deltaAlt > 0) desnivelPos += deltaAlt;
                        else desnivelNeg += Math.abs(deltaAlt);

                        altAnterior = alt;
                    }

                    latFin = lat;
                    lonFin = lon;
                    tiempoFin = tiempo;

                    if (lat > latMax) latMax = lat;
                    if (lon > lonMax) lonMax = lon;

                    latAnterior = lat;
                    lonAnterior = lon;
                }
            }

            reader.close();

            long duracionMin = Duration.between(tiempoIni, tiempoFin).toMinutes();

            txtLatIni.setText(String.format(Locale.US, "%.5f", latIni));
            txtLongIni.setText(String.format(Locale.US, "%.5f", lonIni));
            txtLatFin.setText(String.format(Locale.US, "%.5f", latFin));
            txtLongFinal.setText(String.format(Locale.US, "%.5f", lonFin));
            txtDistancia.setText(String.valueOf((int) distanciaTotal));
            txtDuracion.setText(String.valueOf(duracionMin));
            int desnivelTotal = (int) (desnivelPos + desnivelNeg);
            txtDesnivel.setText(String.valueOf(desnivelTotal));
            txtLatMax.setText(String.format(Locale.US, "%.5f", latMax));
            txtLonMax.setText(String.format(Locale.US, "%.5f", lonMax));

            boolean esCircular = calcularDistancia(latIni, lonIni, latFin, lonFin) < 0.05;
            cmbTipoRuta.setSelectedItem(esCircular ? "Circular" : "Lineal");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al importar el archivo CSV: " + e.getMessage());
        }
    }

/**
 *El método se encarga de calcular la distancia de la ruta
 * 
 * @author Guille
 * @param lat1 latitud inicial
 * @param lon1 longitud inicial
 * @param lat2 latitud final
 * @param lon2 longitud final
 */
    private static double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; 
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}


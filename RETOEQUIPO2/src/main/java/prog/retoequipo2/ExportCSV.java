/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DAM110
 */
public class ExportCSV {

    public static void exportarRuta(Ruta ruta, String archivoExport) {
        File archivo = new File(archivoExport);

        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoExport))){
                
                writer.write("TipoRegistro,NombreRuta,Autor,EnlaceWikiloc,FechaCreacion\n");
                writer.write("InfoGeneral," + ruta.getNombre() + "," + ruta.getCreador() + "," + ruta.getUrl_gpx() + "," + ruta.getFecha() + "\n");

                writer.write("\nTipoRegistro,Latitud,Longitud,Timestamp\n");
                for (Puntos_ruta punto : ruta.getPuntos_ruta()) {
                    if(punto instanceof Punto_peligro peligro){
                    writer.write("PuntoPeligro," + peligro.getLatitud() + "," + peligro.getLongitud() + "," + peligro.getTimestamp() 
                            + peligro.getKm() + "," + peligro.getNivel_gravedad() + "," + peligro.getDescripcion_gravedad() +"\n");
                    }
                    else if(punto instanceof Punto_interes interes){
                    writer.write("PuntoInteres," + interes.getLatitud() + "," + interes.getLongitud() + "," + interes.getTimestamp()
                            + interes.getTipo()+","+interes.getCaract_especiales()+"\n");
                    }
                
                }

            
            } catch (IOException e) {
                System.out.println(e.getMessage() + "\nError al escribir en el archivo");

            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + "\nError al crear el archivo");

        }
    }
}

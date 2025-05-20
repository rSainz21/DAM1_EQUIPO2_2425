/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *Clase que representa los puntos de Interes que se pueden encontrar en una ruta,
 * hereda de Puntos_ruta
 * 
 * @author Rubén
 */
public class Punto_interes extends Puntos_ruta{
private TIPO tipo;
private String caract_especiales;
/**
 *Constructor que instancia un punto de interes con todos sus atributos salvo el id
 * 
 * @param num_orden numero del punto en relacion a la ruta
 * @param nombre nombre del punto
 * @param timestamp el día y hora por la que se pasó por dicho punto
 * @param longitud longitud del punto
 * @param latitud latitud del punto
 * @param descripcion texto que describe el punto
 * @param tipo representa el tipo de punto de interés
 * @param caract_especiales texto que describe las características del punto
 * 
 */
    public Punto_interes(int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, TIPO tipo, String descripcion, String caract_especiales) {
super(num_orden, nombre, timestamp, longitud, latitud, descripcion);
this.imagen = new ArrayList<>();
        this.tipo = tipo;
        this.caract_especiales = caract_especiales;
    }
/**
 *Constructor que instancia un punto de interés con todos sus atributos
 * 
 * @param num_orden numero del punto en relacion a la ruta
 * @param nombre nombre del punto
 * @param timestamp el día y hora por la que se pasó por dicho punto
 * @param longitud longitud del punto
 * @param latitud latitud del punto
 * @param descripcion texto que describe el punto
 * @param tipo representa el tipo de punto de interés
 * @param caract_especiales texto que describe las características del punto
 * 
 */
    public Punto_interes(int id_pr, int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, TIPO tipo, String descripcion, String caract_especiales) {
        super(id_pr, num_orden, nombre, timestamp, longitud, latitud, descripcion);
this.imagen = new ArrayList<>();
        this.tipo = tipo;
        this.caract_especiales = caract_especiales;
    }

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }

    public String getCaract_especiales() {
        return caract_especiales;
    }

    public void setCaract_especiales(String caract_especiales) {
        this.caract_especiales = caract_especiales;
    }
    
}

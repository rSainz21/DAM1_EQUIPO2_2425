/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *Clase que representa los puntos de Peligro que se pueden encontrar en una ruta,
 * hereda de Puntos_ruta
 * 
 * @author Rubén
 */
public class Punto_peligro extends Puntos_ruta{
private double km;
private int nivel_gravedad;
private String descripcion_gravedad;

/**
 *Constructor que instancia un punto de peligro con todos sus atributos
 * 
 * @param id_pr representa el id del punto que se genera en la base de datos
 * @param num_orden numero del punto en relacion a la ruta
 * @param nombre nombre del punto
 * @param timestamp el día y hora por la que se pasó por dicho punto
 * @param longitud longitud del punto
 * @param latitud latitud del punto
 * @param descripcion texto que describe el punto
 * @param km kilómetro en el que se encuentra el punto
 * @param nivel_gravedad valoracion del 1-5 para calcular el peligro del punto
 * @param descripcion_gravedad texto que describe el peligro del punto
 * 
 */
    public Punto_peligro(int id_pr, int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, String descripcion, double km, int nivel_gravedad, String descripcion_gravedad) {
 super(id_pr, num_orden, nombre, timestamp, longitud, latitud, descripcion);       
        this.imagen = new ArrayList<>();
        this.km = km;
        this.nivel_gravedad = nivel_gravedad;
        this.descripcion_gravedad = descripcion_gravedad;
    }
/**
 *Constructor que instancia un punto de peligro con todos sus atributos salvo el id
 * 
 * @param num_orden numero del punto en relacion a la ruta
 * @param nombre nombre del punto
 * @param timestamp el día y hora por la que se pasó por dicho punto
 * @param longitud longitud del punto
 * @param latitud latitud del punto
 * @param descripcion texto que describe el punto
 * @param km kilómetro en el que se encuentra el punto
 * @param nivel_gravedad valoracion del 1-5 para calcular el peligro del punto
 * @param descripcion_gravedad texto que describe el peligro del punto
 * 
 */
    public Punto_peligro(int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, String descripcion, double km, int nivel_gravedad, String descripcion_gravedad) {
         super(num_orden, nombre, timestamp, longitud, latitud, descripcion); 
        this.imagen = new ArrayList<>();
        this.km = km;
        this.nivel_gravedad = nivel_gravedad;
        this.descripcion_gravedad = descripcion_gravedad;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public int getNivel_gravedad() {
        return nivel_gravedad;
    }

    public void setNivel_gravedad(int nivel_gravedad) {
        this.nivel_gravedad = nivel_gravedad;
    }

    public String getDescripcion_gravedad() {
        return descripcion_gravedad;
    }

    public void setDescripcion_gravedad(String descripcion_gravedad) {
        this.descripcion_gravedad = descripcion_gravedad;
    }

}

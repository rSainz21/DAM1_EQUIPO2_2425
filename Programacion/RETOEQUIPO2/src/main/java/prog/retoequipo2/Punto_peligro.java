/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author DAM126
 */
public class Punto_peligro extends Puntos_ruta{
private double km;
private int nivel_gravedad;
private String descripcion_gravedad;

    public Punto_peligro(int id_pr, int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, String descripcion, double km, int nivel_gravedad, String descripcion_gravedad) {
 super(id_pr, num_orden, nombre, timestamp, longitud, latitud, descripcion);       
        this.imagen = new ArrayList<Imagen>();
        this.km = km;
        this.nivel_gravedad = nivel_gravedad;
        this.descripcion_gravedad = descripcion_gravedad;
    }

    public Punto_peligro(int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, String descripcion, double km, int nivel_gravedad, String descripcion_gravedad) {
         super(num_orden, nombre, timestamp, longitud, latitud, descripcion); 
        this.imagen = new ArrayList<Imagen>();
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

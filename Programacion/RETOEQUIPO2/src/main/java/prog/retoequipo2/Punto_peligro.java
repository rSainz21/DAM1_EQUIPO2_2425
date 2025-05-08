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
public class Punto_peligro {
private int id_pp;
private int num_orden;
private String nombre;    
private LocalDateTime timestamp; 
private double longitud;
private double latitud;
private String descripcion;
private double km;
private int nivel_gravedad;
private String descripcion_gravedad;
private ArrayList<Imagen> imagen;

    public Punto_peligro(int id_pp, int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, String descripcion, double km, int nivel_gravedad, String descripcion_gravedad, ArrayList<Imagen> imagen) {
        this.id_pp = id_pp;
        this.num_orden = num_orden;
        this.nombre = nombre;
        this.timestamp = timestamp;
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
        this.km = km;
        this.nivel_gravedad = nivel_gravedad;
        this.descripcion_gravedad = descripcion_gravedad;
        this.imagen = imagen;
    }

    public Punto_peligro(int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, String descripcion, double km, int nivel_gravedad, String descripcion_gravedad, ArrayList<Imagen> imagen) {
        this.num_orden = num_orden;
        this.nombre = nombre;
        this.timestamp = timestamp;
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
        this.km = km;
        this.nivel_gravedad = nivel_gravedad;
        this.descripcion_gravedad = descripcion_gravedad;
        this.imagen = imagen;
    }

    public int getId_pp() {
        return id_pp;
    }

    public void setId_pp(int id_pp) {
        this.id_pp = id_pp;
    }

    public int getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(int num_orden) {
        this.num_orden = num_orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public ArrayList<Imagen> getImagen() {
        return imagen;
    }

    public void setImagen(ArrayList<Imagen> imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_pp;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Punto_peligro other = (Punto_peligro) obj;
        return this.id_pp == other.id_pp;
    }


}

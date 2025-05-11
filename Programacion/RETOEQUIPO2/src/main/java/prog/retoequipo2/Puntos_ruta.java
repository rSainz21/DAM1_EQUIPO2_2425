/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Rubéns
 */
public abstract class Puntos_ruta implements Comparable<Puntos_ruta>{
    protected int id_pr;
protected int num_orden;
protected String nombre;
protected LocalDateTime timestamp;
protected double longitud;
protected double latitud;
protected String descripcion;
protected ArrayList<Imagen> imagen;

    public Puntos_ruta(int id_pr, int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, String descripcion) {
        this.imagen = new ArrayList<Imagen>();
        this.id_pr = id_pr;
        this.num_orden = num_orden;
        this.nombre = nombre;
        this.timestamp = timestamp;
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
    }

    public Puntos_ruta(int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, String descripcion) {
        this.imagen = new ArrayList<Imagen>();
        this.num_orden = num_orden;
        this.nombre = nombre;
        this.timestamp = timestamp;
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
    }

    public int getId_pr() {
        return id_pr;
    }

    public void setId_pr(int id_pr) {
        this.id_pr = id_pr;
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

    public ArrayList<Imagen> getImagen() {
        return imagen;
    }

    public void setImagen(ArrayList<Imagen> imagen) {
        this.imagen = imagen;
    }

    @Override
    public int compareTo(Puntos_ruta pr) {
        return Integer.compare(this.num_orden, pr.num_orden);
    }


}

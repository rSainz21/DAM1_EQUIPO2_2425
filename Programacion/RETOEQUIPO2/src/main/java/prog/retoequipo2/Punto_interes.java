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
public class Punto_interes {
private int id_pi;
private int num_orden;
private String nombre;
private LocalDateTime timestamp;
private double longitud;
private double latitud;
private TIPO tipo;
private String descripcion;
private String caract_especiales;
private ArrayList<Imagen> imagen;

    public Punto_interes(int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, TIPO tipo, String descripcion, String caract_especiales, ArrayList<Imagen> imagen) {
        this.num_orden = num_orden;
        this.nombre = nombre;
        this.timestamp = timestamp;
        this.longitud = longitud;
        this.latitud = latitud;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.caract_especiales = caract_especiales;
        this.imagen = imagen;
    }

    public Punto_interes(int id_pi, int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, TIPO tipo, String descripcion, String caract_especiales, ArrayList<Imagen> imagen) {
        this.id_pi = id_pi;
        this.num_orden = num_orden;
        this.nombre = nombre;
        this.timestamp = timestamp;
        this.longitud = longitud;
        this.latitud = latitud;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.caract_especiales = caract_especiales;
        this.imagen = imagen;
    }
    

    public int getId_pi() {
        return id_pi;
    }

    public void setId_pi(int id_pi) {
        this.id_pi = id_pi;
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

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaract_especiales() {
        return caract_especiales;
    }

    public void setCaract_especiales(String caract_especiales) {
        this.caract_especiales = caract_especiales;
    }

    public ArrayList<Imagen> getImagen() {
        return imagen;
    }

    public void setImagen(ArrayList<Imagen> imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id_pi;
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
        final Punto_interes other = (Punto_interes) obj;
        return this.id_pi == other.id_pi;
    }

}

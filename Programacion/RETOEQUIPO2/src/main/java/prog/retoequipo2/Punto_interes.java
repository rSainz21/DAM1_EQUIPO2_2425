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
public class Punto_interes extends Puntos_ruta{
private TIPO tipo;
private String caract_especiales;

    public Punto_interes(int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, TIPO tipo, String descripcion, String caract_especiales) {
super(num_orden, nombre, timestamp, longitud, latitud, descripcion);
this.imagen = new ArrayList<Imagen>();
        this.tipo = tipo;
        this.caract_especiales = caract_especiales;
    }

    public Punto_interes(int id_pr, int num_orden, String nombre, LocalDateTime timestamp, double longitud, double latitud, TIPO tipo, String descripcion, String caract_especiales) {
        super(id_pr, num_orden, nombre, timestamp, longitud, latitud, descripcion);
this.imagen = new ArrayList<Imagen>();
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

/**
 *Clase que representa los periodos en los que se remocienda hacer una ruta
 * 
 * @author Rubén
 */
public class Periodo {
private int id_periodo;
private String nom_periodo;
private String descripcion;
        /**
 *Constructor que instancia un periodo con sus atributos
 * 
 * @param nom_periodo nombre del periodo
 * @param descripcion descripcion del periodo
 * 
 */ 
    public Periodo(String nom_periodo, String descripcion) {
        this.nom_periodo = nom_periodo;
        this.descripcion = descripcion;
    }
        /**
 *Constructor que instancia un periodo vacío
 * 
 * 
 */ 
    public Periodo() {
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getNom_periodo() {
        return nom_periodo;
    }

    public void setNom_periodo(String nom_periodo) {
        this.nom_periodo = nom_periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

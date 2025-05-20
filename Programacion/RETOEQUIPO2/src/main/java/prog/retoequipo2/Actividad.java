/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;
        /**
 *Clase que representa las Actividades que se pueden realizar en una ruta
 * 
 * @author Rubén
 * 
 */  
public class Actividad {
private int id_actividad;
private String nom_actividad;
private String descripcion;
        /**
 *Constructor que instancia una Actividad con sus atributos
 * 
 * @param nom_actividad nombre de la actividad 
 * @param descripcion descripcion de la actividad
 * 
 */  
    public Actividad(String nom_actividad, String descripcion) {
        this.nom_actividad = nom_actividad;
        this.descripcion = descripcion;
    }
        /**
 *Constructor que instancia una Actividad vacía
 * 
 * 
 */
    public Actividad() {
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getNom_actividad() {
        return nom_actividad;
    }

    public void setNom_actividad(String nom_actividad) {
        this.nom_actividad = nom_actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

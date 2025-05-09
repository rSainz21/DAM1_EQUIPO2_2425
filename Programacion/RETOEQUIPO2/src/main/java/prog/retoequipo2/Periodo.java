/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

/**
 *
 * @author DAM126
 */
public class Periodo {
private int id_periodo;
private String nom_periodo;
private String descripcion;

    public Periodo(String nom_periodo, String descripcion) {
        this.nom_periodo = nom_periodo;
        this.descripcion = descripcion;
    }

    public Periodo() {
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

}

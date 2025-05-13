/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

public class Imagen {
private int id_imagen;
private String url;
private String descripcion;

    public Imagen(int id_imagen, String url, String descripcion) {
        this.id_imagen = id_imagen;
        this.url = url;
        this.descripcion = descripcion;
    }

    public Imagen(String url, String descripcion) {
        this.url = url;
        this.descripcion = descripcion;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

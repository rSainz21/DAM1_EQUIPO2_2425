/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

public class Resena {
private int id_resena;
private Ruta ruta;
private Usuario usuario;
private String texto_resena;

    public Resena(Ruta ruta, Usuario usuario, String texto_resena) {
        this.ruta = ruta;
        this.usuario = usuario;
        this.texto_resena = texto_resena;
    }

    public Resena(int id_resena, Ruta ruta, Usuario usuario, String texto_resena) {
        this.id_resena = id_resena;
        this.ruta = ruta;
        this.usuario = usuario;
        this.texto_resena = texto_resena;
    }

    public int getId_resena() {
        return id_resena;
    }

    public void setId_resena(int id_resena) {
        this.id_resena = id_resena;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTexto_resena() {
        return texto_resena;
    }

    public void setTexto_resena(String texto_resena) {
        this.texto_resena = texto_resena;
    }


}

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id_resena;
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
        final Resena other = (Resena) obj;
        return this.id_resena == other.id_resena;
    }

}

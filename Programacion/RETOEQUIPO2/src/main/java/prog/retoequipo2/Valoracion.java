/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;

         /**
 *Clase que representa las Valoraciones que se pueden registrar en una ruta
 *
 *
 * @author Rubén
 */ 
public class Valoracion {
private int id_valoracion;
private Ruta ruta;
private Usuario usuario;
private int dificultad;
private int belleza;
private int interes_cultural;
private String texto_valo;
private LocalDate fecha_valoracion;
private boolean esTecnica;
private String valo_tecnica;

         /**
 *Crea una instancia de Valoracion con todos sus atributos.
 *
 *
 * @param id_valoracion el id de la Valoracion que se registra en la base de datos
 * @param ruta objeto de tipo {@link Ruta} que se corresponde con la ruta que se valora
 * @param usuario objeto de tipo {@link Usuario} que se corresponde con el usuario que deja la valoracion
 * @param dificultad valoracion del 1-5 para calcular la dificultad de la ruta
 * @param belleza valoracion del 1-5 para calcular la belleza de la ruta
 * @param interes_cultural valoracion del 1-5 para calcular el interes cultural de la ruta
 * @param fecha_valoracion fecha en la que se registra la valoracion
 * @param texto_valo el texto que se registra con la valoración
 * @param esTecnica indica si se trata de una valoración técnica o no
 * @param valo_tecnica en caso de que el anterior valor sea true, incluye la valoracion tecnica
 */ 
    public Valoracion(int id_valoracion, Ruta ruta, Usuario usuario, int dificultad, int belleza, int interes_cultural, String texto_valo, LocalDate fecha_valoracion, boolean esTecnica, String valo_tecnica) {
        this.id_valoracion = id_valoracion;
        this.ruta = ruta;
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.belleza = belleza;
        this.interes_cultural = interes_cultural;
        this.texto_valo = texto_valo;
        this.fecha_valoracion = fecha_valoracion;
        this.esTecnica = esTecnica;
        this.valo_tecnica = valo_tecnica;
    }
         /**
 *Crea una instancia de Valoracion con todos sus atributos menos el id.
 *
 *
 * @param ruta objeto de tipo {@link Ruta} que se corresponde con la ruta que se valora
 * @param usuario objeto de tipo {@link Usuario} que se corresponde con el usuario que deja la valoracion
 * @param dificultad valoracion del 1-5 para calcular la dificultad de la ruta
 * @param belleza valoracion del 1-5 para calcular la belleza de la ruta
 * @param interes_cultural valoracion del 1-5 para calcular el interes cultural de la ruta
 * @param fecha_valoracion fecha en la que se registra la valoracion
 * @param texto_valo el texto que se registra con la valoración
 * @param esTecnica indica si se trata de una valoración técnica o no
 * @param valo_tecnica en caso de que el anterior valor sea true, incluye la valoracion tecnica
 */ 
    public Valoracion(Ruta ruta, Usuario usuario, int dificultad, int belleza, int interes_cultural, String texto_valo, LocalDate fecha_valoracion, boolean esTecnica, String valo_tecnica) {
        this.ruta = ruta;
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.belleza = belleza;
        this.interes_cultural = interes_cultural;
        this.texto_valo = texto_valo;
        this.fecha_valoracion = fecha_valoracion;
        this.esTecnica = esTecnica;
        this.valo_tecnica = valo_tecnica;
    }



    public int getId_valoracion() {
        return id_valoracion;
    }

    public void setId_valoracion(int id_valoracion) {
        this.id_valoracion = id_valoracion;
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

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getBelleza() {
        return belleza;
    }

    public void setBelleza(int belleza) {
        this.belleza = belleza;
    }

    public int getInteres_cultural() {
        return interes_cultural;
    }

    public void setInteres_cultural(int interes_cultural) {
        this.interes_cultural = interes_cultural;
    }

    public String getTexto_valo() {
        return texto_valo;
    }

    public void setTexto_valo(String texto_valo) {
        this.texto_valo = texto_valo;
    }

    public LocalDate getFecha_valoracion() {
        return fecha_valoracion;
    }

    public void setFecha_valoracion(LocalDate fecha_valoracion) {
        this.fecha_valoracion = fecha_valoracion;
    }

    public boolean isEsTecnica() {
        return esTecnica;
    }

    public void setEsTecnica(boolean esTecnica) {
        this.esTecnica = esTecnica;
    }

    public String getValo_tecnica() {
        return valo_tecnica;
    }

    public void setValo_tecnica(String valo_tecnica) {
        this.valo_tecnica = valo_tecnica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id_valoracion;
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
        final Valoracion other = (Valoracion) obj;
        return this.id_valoracion == other.id_valoracion;
    }

}

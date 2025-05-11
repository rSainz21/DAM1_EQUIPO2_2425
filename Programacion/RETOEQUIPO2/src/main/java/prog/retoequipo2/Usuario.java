/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author DAM126
 */
public abstract class Usuario {
protected int id;
protected String email;
protected String nombre;
protected String apellidos;
protected String password;
protected LocalDate fecha_nac;
protected ROL rol;
protected boolean validado;

    public Usuario(String email, String nombre, String apellidos, String password, LocalDate fecha_nac) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.fecha_nac = fecha_nac;
        this.validado=false;   
    }

    public Usuario(int id, String email, String nombre, String apellidos, String password, LocalDate fecha_nac) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.fecha_nac = fecha_nac;
        this.validado = false;
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public ROL getRol() {
        return rol;
    }

    public void setRol(ROL rol) {
        this.rol = rol;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
    public abstract List<String> listarPermisos();
    public abstract void mostrarCatalogo();

    
    @Override
    public String toString() {
        return "Nombre de usuario: "+ nombre+" Apellidos: "+ apellidos+" Email: "+ email +" Fecha de nacimiento: " + fecha_nac + " ROL: " + rol+"\n";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;
import java.util.List;

         /**
 *Representa la estructura de datos básica que tienen todos los tipos de Usuarios, que heredarán de esta
 *
 *
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

         /**
 *Crea una instancia de Usuario con todos sus atributos salvo el id.
 *
 *
 * @param email el email del Usuario
 * @param nombre el nombre del Usuario
 * @param password la contraseña del Usuario
 * @param fecha_nac la fecha de nacimiento del Usuario
 */  
    public Usuario(String email, String nombre, String apellidos, String password, LocalDate fecha_nac) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.fecha_nac = fecha_nac;
        this.validado=false;   
    }
         /**
 *Crea una instancia de Usuario con todos sus atributos
 *
 *
 * @author Rubén
 * @param id el id del Usuario que se registra en la base de datos
 * @param email el email del Usuario
 * @param nombre el nombre del Usuario
 * @param password la contraseña del Usuario
 * @param fecha_nac la fecha de nacimiento del Usuario
 */ 
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
    @Override
    public String toString() {
        return "Nombre de usuario: "+ nombre+" Apellidos: "+ apellidos+" Email: "+ email +" Fecha de nacimiento: " + fecha_nac + " ROL: " + rol+"\n";
    }
    
}

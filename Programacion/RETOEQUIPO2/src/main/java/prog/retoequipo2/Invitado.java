/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;
/**
 *Clase que representa al usuario Invitado
 * 
 * @author Rubén
 */
public class Invitado extends Usuario{
private ROL rol=ROL.INVITADO;
        /**
 *Constructor que instancia un Usuario Invitado con sus atributos salvo id
 * 
 * @param email email del usuario
 * @param nombre nombre del Usuario
 * @param apellidos apellidos del Usuario
 * @param password contraseña del Usuario
 * @param fecha_nac fecha de nacimiento del Usuario
 * 
 */   
private boolean validado=false;
    public Invitado(String email, String nombre, String apellidos, String password, LocalDate fecha_nac) {
        super(email, nombre, apellidos, password, fecha_nac);
        
    }
       /**
 *Constructor que instancia un Usuario Invitado con sus atributos
 * 
 * @param id id que se genera en la base de datos
 * @param email email del usuario
 * @param nombre nombre del Usuario
 * @param apellidos apellidos del Usuario
 * @param password contraseña del Usuario
 * @param fecha_nac fecha de nacimiento del Usuario
 * 
 */     
    public Invitado(int id, String email, String nombre, String apellidos, String password, LocalDate fecha_nac) {
        super(id, email, nombre, apellidos, password, fecha_nac);
    }   
}

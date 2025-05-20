/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;

/**
 *Clase que representa al usuario Diseñador de rutas
 * 
 * @author Rubén
 */
public class Disenador_rutas extends Usuario{
    
            /**
 *Constructor que instancia un Usuario Profesor con sus atributos salvo el id
 * 
 * @param email email del usuario
 * @param nombre nombre del Usuario
 * @param apellidos apellidos del Usuario
 * @param password contraseña del Usuario
 * @param fecha_nac fecha de nacimiento del Usuario
 * 
 */  
    public Disenador_rutas(String email, String nombre, String apellidos, String password, LocalDate fecha_nac){
        super(email,nombre,apellidos,password,fecha_nac);
        this.rol=ROL.DISENADOR;
    }
            /**
 *Constructor que instancia un Usuario Diseñador con sus atributos
 * 
 * @param id id que se genera en la base de datos
 * @param email email del usuario
 * @param nombre nombre del Usuario
 * @param apellidos apellidos del Usuario
 * @param password contraseña del Usuario
 * @param fecha_nac fecha de nacimiento del Usuario
 * 
 */  
    public Disenador_rutas(int id,String email, String nombre, String apellidos, String password, LocalDate fecha_nac){
        super(id,email,nombre,apellidos,password,fecha_nac);
        this.rol=ROL.DISENADOR;
    }
}

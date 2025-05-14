/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;

public class Invitado extends Usuario{

    public Invitado(String email, String nombre, String apellidos, String password, LocalDate fecha_nac) {
        super(email, nombre, apellidos, password, fecha_nac);
    }
    
    public Invitado(int id, String email, String nombre, String apellidos, String password, LocalDate fecha_nac) {
        super(id, email, nombre, apellidos, password, fecha_nac);
    }
    
}

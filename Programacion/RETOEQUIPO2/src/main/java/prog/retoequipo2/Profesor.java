/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Profesor extends Usuario{
    
public Profesor(int id,String email, String nombre, String apellidos, String password, LocalDate fecha_nac){
    super(id,email,nombre,apellidos,password,fecha_nac);
    this.rol=ROL.PROFESOR;
}
public Profesor(String email, String nombre, String apellidos, String password, LocalDate fecha_nac){
    super(email,nombre,apellidos,password,fecha_nac);
    this.rol=ROL.PROFESOR;
}

    @Override
    public List<String> listarPermisos() {
List<String>permisos=Arrays.asList("VER_RUTAS","VALORAR_RUTAS","RESENAR_RUTAS","CREAR_RUTAS","DESCARGAR_FICHAS","CREAR_CALENDARIO");
        return permisos;
        }

    @Override
    public void mostrarCatalogo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void crearRuta(){
       
   }
   public void descargarFichas(Ruta ruta){
       
   }
    public void crearCalendario(){
        
    }
    public void modificarCalendario(){
        
    }
}

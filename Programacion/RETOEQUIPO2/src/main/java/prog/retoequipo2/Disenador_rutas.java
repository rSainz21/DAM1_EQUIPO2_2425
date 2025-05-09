/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author DAM126
 */
public class Disenador_rutas extends Usuario{
    public Disenador_rutas(String email, String nombre, String apellidos, String password, LocalDate fecha_nac, ROL rol){
        super(email,nombre,apellidos,password,fecha_nac,rol);
    }
    public Disenador_rutas(int id,String email, String nombre, String apellidos, String password, LocalDate fecha_nac, ROL rol){
        super(id,email,nombre,apellidos,password,fecha_nac,rol);
    }

    @Override
    public List<String> listarPermisos() {
     List<String>permisos=Arrays.asList("VER_RUTAS","VALORAR_RUTAS","RESENAR_RUTAS","CREAR_RUTAS","DESCARGAR_FICHAS");
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
}

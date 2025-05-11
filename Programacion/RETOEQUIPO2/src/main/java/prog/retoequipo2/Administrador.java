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
public class Administrador extends Usuario{
    public Administrador(int id,String email, String nombre, String apellidos, String password, LocalDate fecha_nac){
        super(id,email,nombre,apellidos,password,fecha_nac);
        this.rol=ROL.ADMINISTRADOR;
        this.validado=true;
    }
    
    public Administrador(String email, String nombre, String apellidos, String password, LocalDate fecha_nac){
        super(email,nombre,apellidos,password,fecha_nac);
        this.rol=ROL.ADMINISTRADOR;
        this.validado=true;
    }

    @Override
    public List<String> listarPermisos() {
        List<String> permisos = Arrays.asList("VER_RUTAS", "VALORAR_RUTAS", "RESENAR_RUTAS", "CREAR_RUTAS", "DESCARGAR_FICHAS", "CREAR_CALENDARIO", "MODIFICAR_RUTAS", "BORRAR_RUTAS"
                + "VALIDAR_RUTAS","GESTIONAR_APLICACION","VALIDAR_USUARIOS");
        return permisos;
    }

    @Override
    public void mostrarCatalogo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
public void crearRuta(){
       
   }
public void borrarRuta(){
    
}
public void modificarRuta(int id, Ruta ruta){
    
}
public void validarRuta(Ruta ruta){
        ruta.setValidada(true);
        }
public void validarUsuario(Usuario usu){
    usu.setValidado(true);
}

   public void descargarFichas(Ruta ruta){
       
   }
    public void crearCalendario(){
        
    }
    public void modificarCalendario(){
        
    }
}

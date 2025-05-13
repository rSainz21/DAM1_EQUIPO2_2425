/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package prog.retoequipo2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 *
 * @author DAM126
 */
public class RETOEQUIPO2 {

    public static void main(String[] args) {
        //hola ruben
        ConexionBD conexion = ConexionBD.getInstance();
        RutasDAO rutasss = new RutasDAO();
        UsuarioDAO usuariosss = new UsuarioDAO();
        MetodosDAO metodosss = new MetodosDAO();
        Alumno usu1 = new Alumno(3, "rubencio@gmail.com", "ruben", "cobo", "pass", LocalDate.parse("1994-02-24"));
        //if(usuariosss.insertaUsuario(usu1)){
        // System.out.println("Usuario insertado");
        //}
        Administrador usu2 = new Administrador(4, "hola@hola", "marco", "materazzi", "1234", LocalDate.parse("1994-02-24"));
        //if(usuariosss.insertaUsuario(usu2)){
        // System.out.println("Usuario insertado");
        //}
        Ruta ruta = new Ruta("El toral", LocalDate.parse("1998-12-12"), 22.22, 44.44, 44.44, 22.22, 345, 456, 55.65, 65.87, CLASIFICACION.circular, 300, 4, 3, true, true, "suputamadre.com",
                "lleva una rebequita por si refresca", "Sri lanka", usu1);
        if (rutasss.insertarRuta(ruta)) {
            System.out.println("Ruta insertada");
        }
        Ruta ruta1 = new Ruta("Los puentes", LocalDate.parse("1998-12-12"), 22.22, 44.44, 44.44, 22.22, 345, 456, 55.65, 65.87, CLASIFICACION.lineal, 300, 4, 3, true, true, "suputamadre.com",
                "lleva una rebequita por si refresca", "Sri lanka", usu1);
        if (rutasss.insertarRuta(ruta1)) {
            System.out.println("Ruta insertada");
        }
        Ruta ruta2 = rutasss.obtenerRutaPorId(8);
        Usuario usu3 = usuariosss.obtenerUsuarioCreador(1);
        System.out.println(usu2);
        Punto_peligro pi = new Punto_peligro(1, "puntoprueba", LocalDateTime.now(), 22, 33, "hola", 37264, 5, "mu peligrosu");
        if (metodosss.insertarPuntoPeligro(pi, ruta2)) {
            System.out.println("punto insertado");
        }
    }
}

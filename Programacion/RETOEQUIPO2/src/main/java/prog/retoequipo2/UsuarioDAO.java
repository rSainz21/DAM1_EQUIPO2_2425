/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *Clase que se encarga de gestionar los Usuarios en relacion a la base de datos, siguiendo el patron CRUD
 * @author Rubén
 */
public class UsuarioDAO {

    private Connection conn = ConexionBD.getInstance().getConn();
 /**
 *Inserta un usuario en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para insertar una fila
 * en la tabla "usuarios", con todos los atributos de un usuario a excepción del id que se autogenera
 *
 * @author Rubén
 * @param usu el objeto {@link Usuario} que contiene los datos del usuario que se va a insertar
 * @return {@code true} si el usuario fue insertado correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean insertaUsuario(Usuario usu) {
        boolean insertado = false;
        String sql = "INSERT INTO usuarios (email,nombre,apellidos,password,fecha_nac,rol,validado) VALUES (?,?,?,md5(?),?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, usu.getEmail());
            ps.setString(2, usu.getNombre());
            ps.setString(3, usu.getApellidos());
            ps.setString(4, usu.getPassword());
            ps.setDate(5, Date.valueOf(usu.getFecha_nac()));
            ps.setString(6, usu.getRol().toString());
            ps.setBoolean(7, usu.isValidado());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                insertado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return insertado;
    }
     /**
 *Recupera un usuario de la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para recoger los datos de un
 * usuario, buscándolo por su id
 *
 * @author Rubén
 * @param id de tipo int que se corresponde con el id del usuario a buscar
 * @return un objeto de tipo {@link Usuario} o null si no se encuentra
 */
    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usu = null;
        String sql = "SELECT * FROM usuarios WHERE cod_usu=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs != null && rs.next()) {
                    String rol = rs.getString("rol").toUpperCase();
                    switch (rol) {
                        case "ADMINISTRADOR" -> {
                            usu = new Administrador(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "DISENADOR" -> {
                            usu = new Disenador_rutas(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "PROFESOR" -> {
                            usu = new Profesor(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "ALUMNO" -> {
                            usu = new Alumno(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usu;
    }
     /**
 *Recupera un usuario de la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para recoger los datos de un
 * usuario, buscándolo por la id de la ruta que ha creado
 *
 * @author Rubén
 * @param id_ruta de tipo int que se corresponde con la ruta creada por el usuario a buscar
 * @return un objeto de tipo {@link Usuario} o null si no se encuentra
 */
    public Usuario obtenerUsuarioCreador(int id_ruta) {
        Usuario usu = null;
        String sql = "SELECT * FROM usuarios INNER JOIN rutas ON cod_usu=usuarios_cod_usu WHERE id_ruta=? AND cod_usu=usuarios_cod_usu";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id_ruta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs != null && rs.next()) {
                    String rol = rs.getString("rol").toUpperCase();
                    switch (rol) {
                        case "ADMINISTRADOR" -> {
                            usu = new Administrador(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "DISENADOR" -> {
                            usu = new Disenador_rutas(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "PROFESOR" -> {
                            usu = new Profesor(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "ALUMNO" -> {
                            usu = new Alumno(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usu;
    }
     /**
 *Borra un usuario de la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para borrar una fila
 * en la tabla "usuarios", utilizando para ello su id
 *
 * @author Rubén
 * @param id de tipo int que se corresponde con el id del usuario a borrar
 * @return {@code true} si el usuario fue borrado correctamente de la base de datos; {@code false} en caso contrario
 */
    public boolean borrarUsuario(int id){
        boolean borrado=false;
        String sql="DELETE FROM USUARIOS WHERE cod_usu=?";
        try(PreparedStatement ps=conn.prepareStatement(sql);){
            ps.setInt(1, id);
            int resultado=ps.executeUpdate();
            if(resultado==1){
                borrado=true;
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return borrado;
    }
         /**
 *Modifica un usuario en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para modificar una fila
 * en la tabla "usuarios", cambiando los datos de un usuario
 *
 * @author Rubén
 * @param usu objeto de tipo {@link Usuario} que representa el usuario ya modificado que se debe actualizar
 * @return {@code true} si el usuario fue actualizado correctamente de la base de datos; {@code false} en caso contrario
 */
    public boolean modificarUsuario(Usuario usu){
        boolean modificado=false;
        String sql="UPDATE USUARIOS SET email=?, nombre=?, apellidos=?, password=md5(?), fecha_nac=?, rol=?, validado=?";
        try(PreparedStatement ps=conn.prepareStatement(sql);){
            ps.setString(1, usu.getEmail());
            ps.setString(2, usu.getNombre());
            ps.setString(3, usu.getApellidos());
            ps.setString(4, usu.getPassword());
            ps.setDate(5, Date.valueOf(usu.getFecha_nac()));
            ps.setString(6, usu.getRol().toString());
            ps.setBoolean(7, usu.isValidado());
            int resultado=ps.executeUpdate();
            if(resultado==1){
                modificado=true;
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modificado;
    }
         /**
 *Recupera un usuario de la base de datos buscando su email y su clave.
 *
 * Este método utiliza una sentencia SQL preparada para recoger los datos de un
 * usuario, buscándolo por su email y contraseña
 *
 * @author Rubén
 * @param email de tipo {@link String} que se corresponde con el email del usuario utilizado para iniciar sesion
 * @param password de tipo {@link String} que se corresponde con la contraseña que utiliza el usuario para iniciar sesion
 * @return un objeto de tipo {@link Usuario} o null si no se encuentra
 */
    public Usuario buscarUsuPorEmailPassword(String email, String password){
            Usuario usu=null;
            String sql = "SELECT * FROM usuarios WHERE email=? AND password=md5(?)";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    String rol = rs.getString("rol").toUpperCase();
                    switch (rol) {
                        case "ADMINISTRADOR" -> {
                            usu = new Administrador(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "DISENADOR" -> {
                            usu = new Disenador_rutas(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "PROFESOR" -> {
                            usu = new Profesor(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "ALUMNO" -> {
                            usu = new Alumno(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usu;
    }
            /**
 * Genera una lista con todos los usuarios existentes en la base de datos cuyo estado está en "no validado".
 *
 * Este método utiliza una sentencia SQL devolver los datos de los usuarios existentes en la base de datos y no validados
 *
 * @author Rubén
 * @return una {@link java.util.ArrayList} con los objetos de tipo {@link Usuario} o vacía si no hay ninguno en la base de datos
 */ 
   public ArrayList<Usuario>listarUsuariosNoValidados(){
      ArrayList<Usuario>noValidados=new ArrayList<>();
      String sql="SELECT * FROM usuarios WHERE validado=false;";
      Usuario usu=null;
      try(Statement st=conn.createStatement();
              ResultSet rs=st.executeQuery(sql)){
          while(rs.next()){
              String rol = rs.getString("rol").toUpperCase();
                    switch (rol) {
                        case "ADMINISTRADOR" -> {
                            usu = new Administrador(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "DISENADOR" -> {
                            usu = new Disenador_rutas(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "PROFESOR" -> {
                            usu = new Profesor(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                        case "ALUMNO" -> {
                            usu = new Alumno(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate());
                        }
                    }
                    noValidados.add(usu);
          }
          
      }catch(SQLException ex){
          System.out.println(ex.getMessage());
      }
      return noValidados;
   }
          /**
 *Modifica un usuario en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para modificar una fila
 * en la tabla "usuarios", cambiando su estado a "validado"
 *
 * @author Rubén
 * @param usu objeto de tipo {@link Usuario} que representa el usuario al que se le quiere actualizar el estado de validación
 * @return {@code true} si el usuario fue actualizado correctamente de la base de datos; {@code false} en caso contrario
 */
   public boolean validarUsuario(Usuario usu){
       boolean validado=false;
       String sql="UPDATE USUARIOS SET validado=true WHERE cod_usu=?;";
       try(PreparedStatement ps=conn.prepareStatement(sql)){
           ps.setInt(1, usu.getId());
           int resultado=ps.executeUpdate();
           if(resultado==1){
               validado=true;
           }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return validado;
   }
}

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

/**
 *
 * @author DAM126
 */
public class UsuarioDAO {

    private Connection conn = ConexionBD.getInstance().getConn();

    public boolean insertaUsuario(Usuario usu) {
        boolean insertado = false;
        String sql = "INSERT INTO usuarios (email,nombre,apellidos,password,fecha_nac,rol,validado) VALUES (?,?,?,?,?,?,?)";
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
    public boolean modificarUsuario(Usuario usu){
        boolean modificado=false;
        String sql="UPDATE USUARIOS SET email=?, nombre=?, apellidos=?, password=?, fecha_nac=?, rol=?, validado=?";
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
    
}

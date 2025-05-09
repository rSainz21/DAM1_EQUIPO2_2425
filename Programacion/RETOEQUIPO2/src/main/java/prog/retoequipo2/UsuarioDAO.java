/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author DAM126
 */
public class UsuarioDAO {

    private Connection conn = ConexionBD.getInstance().getConn();

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
                            usu = new Administrador(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate(),
                                    ROL.valueOf(rol));
                        }
                        case "DISENADOR" -> {
                            usu = new Disenador_rutas(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate(),
                                    ROL.valueOf(rol));
                        }
                        case "PROFESOR" -> {
                            usu = new Profesor(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate(),
                                    ROL.valueOf(rol));
                        }
                        case "ALUMNO" -> {
                            usu = new Alumno(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate(),
                                    ROL.valueOf(rol));
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
                            usu = new Administrador(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate(),
                                    ROL.valueOf(rol));
                        }
                        case "DISENADOR" -> {
                            usu = new Disenador_rutas(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate(),
                                    ROL.valueOf(rol));
                        }
                        case "PROFESOR" -> {
                            usu = new Profesor(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate(),
                                    ROL.valueOf(rol));
                        }
                        case "ALUMNO" -> {
                            usu = new Alumno(rs.getInt("cod_usu"), rs.getString("email"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("password"), rs.getDate("fecha_nac").toLocalDate(),
                                    ROL.valueOf(rol));
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usu;
    }
}

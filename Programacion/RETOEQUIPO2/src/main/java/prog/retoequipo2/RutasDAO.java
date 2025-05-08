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
import java.util.LinkedList;

/**
 *
 * @author Rubéns
 */
public class RutasDAO {

    private Connection conn = ConexionBD.getInstance().getConn();

    public boolean insertarRuta(Ruta ruta) {
        boolean insertada = false;
        String sql = "INSERT INTO rutas (nombre,fecha,latitud_ini,longitud_ini,latitud_fin,longitud_fin,distancia,desnivel_acumulado,"
                + "latitud_max,longitud_max,duracion,clasificacion,tipo_terreno,nivel_riesgo,nivel_esfuerzo,indicaciones,accesib_inclusiv,"
                + "familiar,url_gpx,estado_ruta_validada,recomendaciones,zona_geografica,valo_media,usuarios_cod_usu)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, ruta.getNombre());
            ps.setDate(2, Date.valueOf(ruta.getFecha()));
            ps.setDouble(3, ruta.getLatitud_ini());
            ps.setDouble(4, ruta.getLongitud_ini());
            ps.setDouble(5, ruta.getLatitud_fin());
            ps.setDouble(6, ruta.getLongitud_fin());
            ps.setInt(7, ruta.getDistancia_total());
            ps.setInt(8, ruta.getDesnivel_acumulado());
            ps.setDouble(9, ruta.getLatitud_max());
            ps.setDouble(10, ruta.getLongitud_max());
            ps.setInt(11, ruta.getDuracion());
            ps.setString(12, ruta.getClasificacion().toString());
            ps.setInt(13, ruta.getTipo_terreno());
            ps.setInt(14, ruta.getNivel_riesgo());
            ps.setInt(15, ruta.getNivel_esfuerzo());
            ps.setInt(16, ruta.getIndicaciones());
            ps.setBoolean(17, ruta.isAccesible_inclusivo());
            ps.setBoolean(18, ruta.isFamiliar());
            ps.setString(19, ruta.getUrl_gpx());
            ps.setBoolean(20, ruta.isValidada());
            ps.setString(21, ruta.getRecomendaciones());
            ps.setString(22, ruta.getZona_geografica());
            ps.setDouble(23, ruta.getValoracion_media());
            ps.setInt(24, ruta.getCreador().getId());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                insertada = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    

    public Ruta obtenerRutaPorId(int id) {
        Ruta nuevaruta = null;
        String sql = "SELECT nombre,fecha,latitud_ini,longitud_ini,latitud_fin,longitud_fin,distancia,desnivel_acumulado,"
                + "latitud_max,longitud_max,duracion,clasificacion,tipo_terreno,nivel_riesgo,nivel_esfuerzo,indicaciones,accesib_inclusiv,"
                + "familiar,url_gpx,estado_ruta_validada,recomendaciones,zona_geografica,valo_media,usuarios_cod_usu FROM rutas WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs != null && rs.next()) {
                    nuevaruta.setId_ruta(id);
                    nuevaruta.setNombre(rs.getString("nombre"));
                    nuevaruta.setFecha(rs.getDate("fecha").toLocalDate());
                    nuevaruta.setLatitud_ini(rs.getDouble("latitud_ini"));
                    nuevaruta.setLongitud_ini(rs.getDouble("longitud_ini"));
                    nuevaruta.setLatitud_fin(rs.getDouble("latitud_fin"));
                    nuevaruta.setLongitud_ini(rs.getDouble("longitud_fin"));
                    nuevaruta.setDistancia_total(rs.getInt("distancia"));
                    nuevaruta.setDesnivel_acumulado(rs.getInt("desnivel_acumulado"));
                    nuevaruta.setLatitud_max(rs.getDouble("latitud_max"));
                    nuevaruta.setLongitud_max(rs.getDouble("longitud_max"));
                    nuevaruta.setDuracion(rs.getInt("duracion"));
                    nuevaruta.setClasificacion(CLASIFICACION.valueOf(rs.getString("clasificacion")));
                    nuevaruta.setTipo_terreno(rs.getInt("tipo_terreno"));
                    nuevaruta.setNivel_riesgo(rs.getInt("nivel_riesgo"));
                    nuevaruta.setNivel_esfuerzo(rs.getInt("nivel_esfuerzo"));
                    nuevaruta.setIndicaciones(rs.getInt("indicaciones"));
                    nuevaruta.setAccesible_inclusivo(rs.getBoolean("accesib_inclusiv"));
                    nuevaruta.setFamiliar(rs.getBoolean("familiar"));
                    nuevaruta.setUrl_gpx(rs.getString("url_gpx"));
                    nuevaruta.setValidada(rs.getBoolean("estado_ruta_validada"));
                    nuevaruta.setRecomendaciones(rs.getString("recomendaciones"));
                    nuevaruta.setZona_geografica(rs.getString("zona_geografica"));
                    nuevaruta.setValoracion_media(rs.getDouble("valo_media"));
                    nuevaruta.setCreador(obtenerUsuarioPorId());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nuevaruta;
    }

    public LinkedList<Ruta> muestraRutas() {
        LinkedList<Ruta> rutas = new LinkedList<>();
        String sql = "SELECT * FROM rutas";
        try (Statement st = conn.createStatement();) {
            try (ResultSet rs = st.executeQuery(sql)) {
                if (rs != null) {
                    while (rs.next()) {
                        Ruta ruta = new Ruta(rs.getInt("id_ruta"), rs.getString("nombre"), rs.getDate("fecha").toLocalDate(), rs.getDouble("latitud_ini"),
                                rs.getDouble("longitud_ini"), rs.getDouble("latitud_fin"), rs.getDouble("longitud_fin"), rs.getInt("distancia"),
                                rs.getInt("desnivel_acumulado"), rs.getDouble("latitud_max"), rs.getDouble("longitud_max"), rs.getInt("duracion"),
                                CLASIFICACION.valueOf(rs.getString("clasificacion")), rs.getInt("tipo_terreno"), rs.getInt("nivel_riesgo"),
                                rs.getInt("nivel_esfuerzo"), rs.getInt("indicaciones"), rs.getInt("indicaciones"), rs.getBoolean("accesib_inclusiv"),
                                rs.getBoolean("familiar"), rs.getString("url_gpx"), rs.getBoolean("estado_ruta_validada"), rs.getString("recomendaciones"),
                                rs.getString("zona_geografica"), rs.getDouble("valo_media"), obtenerUsuarioPorId();
                        if (!rutas.add(ruta)) {
                            throw new Exception("fallo al insertar ruta en la lista");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rutas;
    }

    public boolean modificaRuta(Ruta ruta) {
        boolean modificada = false;
        String sql = "UPDATE rutas SET nombre=?,fecha=?,latitud_ini=?,longitud_ini=?,latitud_fin=?,longitud_fin=?,distancia=?,desnivel_acumulado=?,"
                + "latitud_max=?,longitud_max=?,duracion=?,clasificacion=?,tipo_terreno=?,nivel_riesgo=?,nivel_esfuerzo=?,indicaciones=?,accesib_inclusiv=?,"
                + "familiar=?,url_gpx=?,estado_ruta_validada=?,recomendaciones=?,zona_geografica=?,valo_media=?,usuarios_cod_usu=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, ruta.getNombre());
            ps.setDate(2, Date.valueOf(ruta.getFecha()));
            ps.setDouble(3, ruta.getLatitud_ini());
            ps.setDouble(4, ruta.getLongitud_ini());
            ps.setDouble(5, ruta.getLatitud_fin());
            ps.setDouble(6, ruta.getLongitud_fin());
            ps.setInt(7, ruta.getDistancia_total());
            ps.setInt(8, ruta.getDesnivel_acumulado());
            ps.setDouble(9, ruta.getLatitud_max());
            ps.setDouble(10, ruta.getLongitud_max());
            ps.setInt(11, ruta.getDuracion());
            ps.setString(12, ruta.getClasificacion().toString());
            ps.setInt(13, ruta.getTipo_terreno());
            ps.setInt(14, ruta.getNivel_riesgo());
            ps.setInt(15, ruta.getNivel_esfuerzo());
            ps.setInt(16, ruta.getIndicaciones());
            ps.setBoolean(17, ruta.isAccesible_inclusivo());
            ps.setBoolean(18, ruta.isFamiliar());
            ps.setString(19, ruta.getUrl_gpx());
            ps.setBoolean(20, ruta.isValidada());
            ps.setString(21, ruta.getRecomendaciones());
            ps.setString(22, ruta.getZona_geografica());
            ps.setDouble(23, ruta.getValoracion_media());
            ps.setInt(24, ruta.getCreador().getId());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                modificada = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modificada;
    }

    public boolean borrarRuta(int id) {
        boolean borrada = false;
        String sql = "DELETE FROM rutas WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            int resultado=ps.executeUpdate();
            if(resultado==1){
                borrada=true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return borrada;
    }
}

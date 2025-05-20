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
import java.util.LinkedList;

/** 
 *Clase que se encarga de gestionar las Rutas en relacion a la base de datos, siguiendo el patron CRUD
 * @author Rubén
 */
public class RutasDAO {

    private Connection conn = ConexionBD.getInstance().getConn();
    private UsuarioDAO usuarioBD = new UsuarioDAO();
  /**
 *Inserta una ruta en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para insertar una fila
 * en la tabla "rutas", con todos los atributos de una ruta a excepción del id que se autogenera
 *
 * @author Rubén
 * @param ruta el objeto {@link Ruta} que contiene la ruta que se va a insertar
 * @return {@code true} si la ruta fue insertada correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean insertarRuta(Ruta ruta) {
        boolean insertada = false;
        String sql = "INSERT INTO rutas (nombre,fecha,latitud_ini,longitud_ini,latitud_fin,longitud_fin,distancia,desnivel_acumulado,"
                + "latitud_max,longitud_max,duracion,clasificacion,tipo_terreno,nivel_esfuerzo,indicaciones,accesib_inclusiv,"
                + "familiar,url_gpx,estado_ruta_validada,recomendaciones,zona_geografica,valo_media,usuarios_cod_usu)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(14, ruta.getNivel_esfuerzo());
            ps.setInt(15, ruta.getIndicaciones());
            ps.setBoolean(16, ruta.isAccesible_inclusivo());
            ps.setBoolean(17, ruta.isFamiliar());
            ps.setString(18, ruta.getUrl_gpx());
            ps.setBoolean(19, ruta.isValidada());
            ps.setString(20, ruta.getRecomendaciones());
            ps.setString(21, ruta.getZona_geografica());
            ps.setDouble(22, ruta.getValoracion_media());
            ps.setInt(23, ruta.getCreador().getId());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                insertada = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return insertada;
    }
  /**
 *Devuelve una ruta existente en la base de datos a través de su id.
 *
 * Este método utiliza una sentencia SQL preparada para devolver los datos de una ruta
 * buscada a partir de su id
 *
 * @author Rubén
 * @param id de tipo int que representa el id de la ruta que se busca
 * @return un objeto tipo {@link Ruta}; objeto null en caso de no existir el id
 */
    public Ruta obtenerRutaPorId(int id) {
        Ruta nuevaruta = null;
        String sql = "SELECT nombre, fecha, latitud_ini, longitud_ini, latitud_fin, longitud_fin, distancia, desnivel_acumulado, "
                + "latitud_max, longitud_max, duracion, clasificacion, tipo_terreno, indicaciones, accesib_inclusiv,"
                + "familiar, url_gpx, estado_ruta_validada, recomendaciones, zona_geografica, valo_media, usuarios_cod_usu"
                + " FROM rutas WHERE id_ruta=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs != null && rs.next()) {
                    Usuario usu = usuarioBD.obtenerUsuarioCreador(id);
                    nuevaruta = new Ruta(id, rs.getString("nombre"), rs.getDate("fecha").toLocalDate(), rs.getDouble("longitud_ini"), rs.getDouble("latitud_ini"),
                            rs.getDouble("longitud_fin"), rs.getDouble("latitud_fin"), rs.getInt("distancia"), rs.getInt("duracion"), rs.getDouble("latitud_max"), rs.getDouble("longitud_max"),
                            CLASIFICACION.valueOf(rs.getString("clasificacion")), rs.getInt("desnivel_acumulado"), rs.getInt("tipo_terreno"), rs.getInt("indicaciones"),
                            rs.getBoolean("accesib_inclusiv"), rs.getBoolean("familiar"), rs.getString("url_gpx"), rs.getString("recomendaciones"),
                            rs.getString("zona_geografica"), usu);
                    nuevaruta.setValoracion_media(rs.getDouble("valo_media"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nuevaruta;
    }
        /**
 * Genera una lista con todas las rutas existentes en la base de datos.
 *
 * Este método utiliza una sentencia SQL para devolver los datos de las rutas existentes en la base de datos
 *
 * @author Rubén
 * @return una {@link java.util.LinkedList} con los objetos de tipo {@link Ruta} o vacía si no hay ninguna en la base de datos
 */  
    public LinkedList<Ruta> muestraRutas() {
        LinkedList<Ruta> rutas = new LinkedList<>();
        String sql = "SELECT * FROM rutas";
        try (Statement st = conn.createStatement();) {
            try (ResultSet rs = st.executeQuery(sql)) {
                if (rs != null) {
                    while (rs.next()) {
                        Usuario usu = usuarioBD.obtenerUsuarioCreador(rs.getInt("id_ruta"));
                        Ruta ruta = new Ruta(rs.getInt("id_ruta"), rs.getString("nombre"), rs.getDate("fecha").toLocalDate(), rs.getDouble("longitud_ini"), rs.getDouble("latitud_ini"),
                                rs.getDouble("longitud_fin"), rs.getDouble("latitud_fin"), rs.getInt("distancia"), rs.getInt("duracion"), rs.getDouble("latitud_max"), rs.getDouble("longitud_max"),
                                CLASIFICACION.valueOf(rs.getString("clasificacion")), rs.getInt("desnivel_acumulado"), rs.getInt("tipo_terreno"), rs.getInt("indicaciones"),
                                rs.getBoolean("accesib_inclusiv"), rs.getBoolean("familiar"), rs.getString("url_gpx"), rs.getString("recomendaciones"),
                                rs.getString("zona_geografica"), usu);
                        ruta.setValoracion_media(rs.getDouble("valo_media"));
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
  /**
 * Modifica una ruta ya existente en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para modificar una fila
 * en la tabla "rutas", pudiendo cambiar sus atributos salvo el id
 *
 * @author Guille
 * @param ruta el objeto {@link Ruta} que contiene la ruta actualizada
 * @return {@code true} si la ruta fue modificada correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean modificaRuta(Ruta ruta) {
        boolean modificada = false;
        String sql = "UPDATE rutas SET nombre=?,fecha=?,latitud_ini=?,longitud_ini=?,latitud_fin=?,longitud_fin=?,distancia=?,desnivel_acumulado=?,"
                + "latitud_max=?,longitud_max=?,duracion=?,clasificacion=?,tipo_terreno=?,nivel_riesgo=?,nivel_esfuerzo=?,indicaciones=?,accesib_inclusiv=?,"
                + "familiar=?,url_gpx=?,estado_ruta_validada=?,recomendaciones=?,zona_geografica=?,valo_media=?,usuarios_cod_usu=? WHERE id_ruta=?";
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
            ps.setInt(25, ruta.getId_ruta());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                modificada = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modificada;
    }
  /**
 *Borra una ruta existente en la base de datos a través de su id.
 *
 * Este método utiliza una sentencia SQL preparada para eliminar una fila en la tabla "rutas"
 * buscando por su atributo id
 *
 * @author Rubén
 * @param id de tipo int que representa el id de la ruta que desea borrar
 * @return {@code true} si se lleva a cabo la eliminación exitosamente; {@code false} en caso contrario
 */
    public boolean borrarRuta(int id) {
        boolean borrada = false;
        String sql = "DELETE FROM rutas WHERE id_ruta=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                borrada = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return borrada;
    }
  /**
 *Cambia el estado de una ruta existente en la base de datos a "validado".
 *
 * Este método utiliza una sentencia SQL preparada para modificar una fila de la tabla
 * "rutas" y cambiar un atributo booleano a verdadero
 *
 * @author Rubén
 * @param ruta objeto de tipo {@link Ruta} que se quiere validar
 * @return {@code true} si se lleva a cabo el cambio de estado correctamente; {@code false} en caso contrario
 */
    public boolean validarRuta(Ruta ruta) {
        boolean validada = false;
        String sql = "UPDATE rutas SET estado_ruta_validada=TRUE WHERE id_ruta=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, ruta.getId_ruta());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                validada = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return validada;
    }
        /**
 * Genera una lista con todas las rutas existentes en la base de datos cuyo estado está en "no validada".
 *
 * Este método utiliza una sentencia SQL devolver los datos de las rutas existentes en la base de datos y no validadas
 *
 * @author Rubén
 * @return una {@link java.util.ArrayList} con los objetos de tipo {@link Ruta} o vacía si no hay ninguna en la base de datos
 */  
    public ArrayList<Ruta> rutasNoValidadas() {
        ArrayList<Ruta> noValidadas = new ArrayList<>();
        String sql = "SELECT * FROM rutas WHERE estado_ruta_validada=FALSE;";
        try (Statement stt = conn.createStatement(); ResultSet rs = stt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usu = usuarioBD.obtenerUsuarioCreador(rs.getInt("id_ruta"));
                Ruta ruta = new Ruta(rs.getInt("id_ruta"), rs.getString("nombre"), rs.getDate("fecha").toLocalDate(), rs.getDouble("longitud_ini"), rs.getDouble("latitud_ini"),
                        rs.getDouble("longitud_fin"), rs.getDouble("latitud_fin"), rs.getInt("distancia"), rs.getInt("duracion"), rs.getDouble("latitud_max"), rs.getDouble("longitud_max"),
                        CLASIFICACION.valueOf(rs.getString("clasificacion")), rs.getInt("desnivel_acumulado"), rs.getInt("tipo_terreno"), rs.getInt("indicaciones"),
                        rs.getBoolean("accesib_inclusiv"), rs.getBoolean("familiar"), rs.getString("url_gpx"), rs.getString("recomendaciones"),
                        rs.getString("zona_geografica"), usu);
                noValidadas.add(ruta);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return noValidadas;
    }
        /**
 * Genera una lista con todas las rutas existentes en la base de datos cuyo estado está en "validada".
 *
 * Este método utiliza una sentencia SQL devolver los datos de las rutas existentes en la base de datos y validadas
 *
 * @author Rubén
 * @return una {@link java.util.ArrayList} con los objetos de tipo {@link Ruta} o vacía si no hay ninguna en la base de datos
 */     
    public ArrayList<Ruta> rutasValidadas() {
        ArrayList<Ruta> validadas = new ArrayList<>();
        String sql = "SELECT * FROM rutas WHERE estado_ruta_validada=TRUE;";
        try (Statement stt = conn.createStatement(); ResultSet rs = stt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usu = usuarioBD.obtenerUsuarioCreador(rs.getInt("id_ruta"));
                Ruta ruta = new Ruta(rs.getInt("id_ruta"), rs.getString("nombre"), rs.getDate("fecha").toLocalDate(), rs.getDouble("longitud_ini"), rs.getDouble("latitud_ini"),
                        rs.getDouble("longitud_fin"), rs.getDouble("latitud_fin"), rs.getInt("distancia"), rs.getInt("duracion"), rs.getDouble("latitud_max"), rs.getDouble("longitud_max"),
                        CLASIFICACION.valueOf(rs.getString("clasificacion")), rs.getInt("desnivel_acumulado"), rs.getInt("tipo_terreno"), rs.getInt("indicaciones"),
                        rs.getBoolean("accesib_inclusiv"), rs.getBoolean("familiar"), rs.getString("url_gpx"), rs.getString("recomendaciones"),
                        rs.getString("zona_geografica"), usu);
                ruta.setValoracion_media(rs.getDouble("valo_media"));
                validadas.add(ruta);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return validadas;
    }

}

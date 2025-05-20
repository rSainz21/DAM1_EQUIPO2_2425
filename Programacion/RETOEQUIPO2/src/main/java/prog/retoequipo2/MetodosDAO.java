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
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 *Clase que se encarga de gestionar los métodos relacionados con la interacción de actividades, puntos de ruta, periodos y reseñas en relacion a la base de datos, siguiendo el patron CRUD
 * @author Rubén
 */
public class MetodosDAO {

    private Connection conn = ConexionBD.getInstance().getConn();
    private UsuarioDAO UsuarioBD = new UsuarioDAO();
    private RutasDAO RutaBD = new RutasDAO();

    /**
 * Inserta una nueva actividad asociada a una ruta en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para insertar una fila
 * en la tabla "actividades", con el nombre, la descripción de la actividad
 * y el ID de la ruta correspondiente.
 *
 * @author Rubén
 * @param actividad el objeto {@link Actividad} que contiene el nombre y la descripción de la actividad a insertar
 * @param ruta el objeto {@link Ruta} que representa la ruta asociada a la actividad
 * @return {@code true} si la actividad fue insertada correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean insertarActividad(Actividad actividad, Ruta ruta) {
        boolean insertada = false;
        String sql = "INSERT INTO actividades (nom_actividad,descripcion,rutas_id_ruta) VALUES (?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, actividad.getNom_actividad());
            ps.setString(2, actividad.getDescripcion());
            ps.setInt(3, ruta.getId_ruta());
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
 * Borra una actividad asociada a una ruta en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para borrar una fila
 * en la tabla "actividades", a través de su id.
 *
 * @author Rubén
 * @param id un valor int que se corresponde con el id de la actividad que se desea borrar
 * @return {@code true} si la actividad fue borrada correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean borrarActividad(int id) {
        boolean borrada = false;
        String sql = "DELETE FROM actividades WHERE id_actividad=?";
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
 * Inserta un nuevo periodo en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para insertar una fila
 * en la tabla "periodos", con el nombre, la descripción del periodo
 *
 * @author Rubén
 * @param periodo el objeto {@link Periodo} que contiene el nombre y la descripción del periodo a insertar
 * @return {@code true} si el periodo fue insertado correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean insertarPeriodo(Periodo periodo) {
        boolean insertada = false;
        String sql = "INSERT INTO periodos (nom_periodo, descrip) VALUES (?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, periodo.getNom_periodo());
            ps.setString(2, periodo.getDescripcion());
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
 * Borra un periodo en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para borrar una fila
 * en la tabla "periodos", a través de su id.
 *
 * @author Rubén
 * @param id un valor int que se corresponde con el id del periodo que se desea borrar
 * @return {@code true} si el periodo fue borrado correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean borrarPeriodo(int id) {
        boolean borrada = false;
        String sql = "DELETE FROM periodos WHERE id_periodo=?";
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
 * Genera una lista con todos los periodos añadidos en la base de datos.
 *
 * Este método utiliza una sentencia SQL para recoger los datos de los periodos existentes en la base de datos
 *
 * @author Rubén
 * @return una {@link java.util.LinkedList} con los Periodos o vacía si no hay ninguno registrado
 */        
    public LinkedList<Periodo> listaPeriodos(){
        LinkedList<Periodo>periodos=new LinkedList<>();
        String sql="SELECT * FROM periodos;";
        try(Statement stt=conn.createStatement();
                ResultSet rs=stt.executeQuery(sql)){
            while(rs.next()){
                Periodo periodo=new Periodo(rs.getString("nom_periodo"),rs.getString("descrip"));
                periodos.add(periodo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return periodos;
    }
  /**
 * Inserta un nuevo punto de interés en la base de datos, en una ruta específica.
 *
 * Este método utiliza una sentencia SQL preparada para insertar una fila
 * en la tabla "puntos_interes", con los datos de un nuevo punto de interés
 *
 * @author Rubén
 * @param pi el objeto {@link Punto_interes} que contiene el punto a insertar
 * @param ruta el objeto {@link Ruta} que se corresponde con la ruta a la que se le insertará el punto
 * @return {@code true} si el punto fue insertado correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean insertarPuntoInteres(Punto_interes pi, Ruta ruta) {
        boolean insertado = false;
        String sql = "INSERT INTO puntosinteres (nombre,num_orden,latitud,longitud,timestamp,tipo,descripcion,caract_especiales,rutas_id_ruta)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, pi.getNombre());
            ps.setInt(2, pi.getNum_orden());
            ps.setDouble(3, pi.getLatitud());
            ps.setDouble(4, pi.getLongitud());
            ps.setTimestamp(5, Timestamp.valueOf(pi.getTimestamp()));
            ps.setString(6, pi.getTipo().toString());
            ps.setString(7, pi.getDescripcion());
            ps.setString(8, pi.getCaract_especiales());
            ps.setInt(9, ruta.getId_ruta());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                insertado = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return insertado;
    }
  /**
 * Inserta un nuevo punto de peligro en la base de datos, en una ruta específica.
 *
 * Este método utiliza una sentencia SQL preparada para insertar una fila
 * en la tabla "puntos_peligro", con los datos de un nuevo punto de interés
 *
 * @author Rubén
 * @param pp el objeto {@link Punto_peligro} que contiene el punto a insertar
 * @param ruta el objeto {@link Ruta} que se corresponde con la ruta a la que se le insertará el punto
 * @return {@code true} si el punto fue insertado correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean insertarPuntoPeligro(Punto_peligro pp, Ruta ruta) {
        boolean insertado = false;
        String sql = "INSERT INTO puntospeligro (nombre,num_orden,latitud,longitud,timestamp,descripcion,km,nivel_gravedad,descripcion_gravedad,rutas_id_ruta)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, pp.getNombre());
            ps.setInt(2, pp.getNum_orden());
            ps.setDouble(3, pp.getLatitud());
            ps.setDouble(4, pp.getLongitud());
            ps.setTimestamp(5, Timestamp.valueOf(pp.getTimestamp()));
            ps.setString(6, pp.getDescripcion());
            ps.setDouble(7, pp.getKm());
            ps.setInt(8, pp.getNivel_gravedad());
            ps.setString(9, pp.getDescripcion_gravedad());
            ps.setInt(10, ruta.getId_ruta());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                insertado = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return insertado;
    }
  /**
 * Modifica un punto de interés en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para modificar una fila
 * en la tabla "puntos_interes", con el punto modificado 
 *
 * @author Rubén
 * @param pi el objeto {@link Punto_interes} que contiene el punto a modificar
 * @return {@code true} si el punto fue modificado correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean modificarPuntoInteres(Punto_interes pi) {
        boolean modificado = false;
        String sql = "UPDATE puntosinteres SET nombre=?,num_orden=?,latitud=?,longitud=?,timestamp=?"
                + ",tipo=?,descripcion=?,caract_especiales=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, pi.getNombre());
            ps.setInt(2, pi.getNum_orden());
            ps.setDouble(3, pi.getLatitud());
            ps.setDouble(4, pi.getLongitud());
            ps.setTimestamp(5, Timestamp.valueOf(pi.getTimestamp()));
            ps.setString(6, pi.getTipo().toString());
            ps.setString(7, pi.getDescripcion());
            ps.setString(8, pi.getCaract_especiales());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                modificado = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modificado;
    }
 /**
 * Modifica un punto de peligro en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para modificar una fila
 * en la tabla "puntos_peligro", con el punto modificado 
 *
 * @author Rubén
 * @param pp el objeto {@link Punto_peligro} que contiene el punto a modificar
 * @return {@code true} si el punto fue modificado correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean modificarPuntoPeligro(Punto_peligro pp) {
        boolean modificado = false;
        String sql = "UPDATE puntospeligro SET nombre=?,num_orden=?,latitud=?,longitud=?,timestamp=?,tipo=?,descripcion=?"
                + ",km=?,nivel_gravedad=?,descripcion_gravedad=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, pp.getNombre());
            ps.setInt(2, pp.getNum_orden());
            ps.setDouble(3, pp.getLatitud());
            ps.setDouble(4, pp.getLongitud());
            ps.setTimestamp(5, Timestamp.valueOf(pp.getTimestamp()));
            ps.setString(6, pp.getDescripcion());
            ps.setDouble(7, pp.getKm());
            ps.setInt(8, pp.getNivel_gravedad());
            ps.setString(9, pp.getDescripcion_gravedad());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                modificado = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return modificado;
    }
 /**
 * Borra un punto de interés en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para borrar una fila
 * en la tabla "puntos_interés", a través de su id
 *
 * @author Rubén
 * @param id de tipo int que representa el id del punto a borrar
 * @return {@code true} si el punto fue borrado correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean borrarPuntoInteres(int id) {
        boolean borrado = false;
        String sql = "DELETE from puntosinteres WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql);) {
            st.setInt(1, id);
            int resultado = st.executeUpdate();
            if (resultado == 1) {
                borrado = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return borrado;
    }
 /**
 * Borra un punto de peligro en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para borrar una fila
 * en la tabla "puntos_peligro", a través de su id
 *
 * @author Rubén
 * @param id de tipo int que representa el id del punto a borrar
 * @return {@code true} si el punto fue borrado correctamente en la base de datos; {@code false} en caso contrario
 */
    public boolean borrarPuntoPeligro(int id) {
        boolean borrado = false;
        String sql = "DELETE from puntospeligro WHERE id=?";
        try (PreparedStatement st = conn.prepareStatement(sql);) {
            st.setInt(1, id);
            int resultado = st.executeUpdate();
            if (resultado == 1) {
                borrado = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return borrado;
    }
        /**
 * Genera una lista con todos puntos de interés asociados a una ruta concreta en la base de datos.
 *
 * Este método utiliza una sentencia SQL para recuperar los objetos Punto_interes de una ruta en la base de datos
 *
 * @author Rubén
 * @param id de tipo int que representa la id de la ruta de la que se extraerán los puntos
 * @return una {@link java.util.LinkedList} con los Punto_interes o vacía si no hay ninguno registrado
 */  
    public LinkedList<Punto_interes> listarPuntosInteresRuta(int id) {
        LinkedList<Punto_interes> puntos_interes = new LinkedList<>();
        String sql = "SELECT * FROM puntosinteres WHERE rutas_id_ruta=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs != null) {
                    while (rs.next()) {
                        Punto_interes pi = new Punto_interes(rs.getInt("id_trackpoint"), rs.getInt("num_orden"), rs.getString("nombre"),
                                rs.getTimestamp("timestamp").toLocalDateTime(), rs.getDouble("longitud"),
                                rs.getDouble("latitud"), TIPO.valueOf(rs.getString("tipo")),
                                rs.getString("descripcion"), rs.getString("caract_especiales"));
                        if (!puntos_interes.add(pi)) {
                            System.out.println("error al insertar punto en la lista");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return puntos_interes;
    }
        /**
 * Genera una lista con todos puntos de peligro asociados a una ruta concreta en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para recuperar los objetos Punto_peligro de una ruta en la base de datos
 *
 * @author Rubén
 * @param id de tipo int que representa la id de la ruta de la que se extraerán los puntos
 * @return una {@link java.util.LinkedList} con los Punto_peligro o vacía si no hay ninguno registrado
 */ 
    public LinkedList<Punto_peligro> listarPuntosPeligroRuta(int id) {
        LinkedList<Punto_peligro> puntos_peligro = new LinkedList<>();
        String sql = "SELECT * FROM puntospeligro WHERE rutas_id_ruta=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs != null) {
                    while (rs.next()) {
                        Punto_peligro pp = new Punto_peligro(rs.getInt("id_trackpoint"), rs.getInt("num_orden"), rs.getString("nombre"),
                                rs.getTimestamp("timestamp").toLocalDateTime(), rs.getDouble("longitud"),
                                rs.getDouble("latitud"), rs.getString("descripcion"), rs.getDouble("km"), rs.getInt("nivel_gravedad"),
                                rs.getString("descripcion_gravedad"));
                        if (!puntos_peligro.add(pp)) {
                            System.out.println("error al insertar punto en la lista");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return puntos_peligro;
    }
        /**
 * Inserta una reseña en una ruta específica y por un usuario específico en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para añadir una fila en la tabla "reseñas" con el texto
 * de una reseña y el id de su ruta y usuario correspondientes
 *
 * @author Rubén
 * @param resena objeto {@link Resena} que se insertará en la base de datos
 * @return {@code true} si la inserción se lleva a cabo correctamente, {@code true} en caso contrario
 */ 
    public boolean insertaResena(Resena resena) {
        boolean insertada = false;
        String sql = "INSERT INTO resenas (text_resena, rutas_id_ruta, usuarios_cod_usu) VALUES (?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, resena.getTexto_resena());
            ps.setInt(2, resena.getRuta().getId_ruta());
            ps.setInt(3, resena.getUsuario().getId());
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
 * Inserta una valoración en una ruta específica y por un usuario específico.
 *
 * Este método utiliza una sentencia SQL preparada para insertar una fila en la tabla "valoraciones" con los datos de una valoracion
 * y el id de la ruta y usuario con los que se corresponden
 *
 * @author Rubén
 * @param valo objeto {@link Valoracion} que se insertará en la base de datos
 * @return {@code true} si la inserción se lleva a cabo correctamente, {@code true} en caso contrario
 */ 
    public boolean insertaValoracion(Valoracion valo) {
        boolean insertada = false;
        String sql = "INSERT INTO valoraciones (dificultad, belleza, interes_cultu, texto_valo, fecha, es_valo_tecnica, "
                + "texto_valo_tecnica, rutas_id_ruta, usuarios_cod_usu) VALUES (?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, valo.getDificultad());
            ps.setInt(2, valo.getBelleza());
            ps.setInt(3, valo.getInteres_cultural());
            ps.setString(4, valo.getTexto_valo());
            ps.setDate(5, Date.valueOf(valo.getFecha_valoracion()));
            ps.setBoolean(6, valo.isEsTecnica());
            if (valo.isEsTecnica()) {
                ps.setString(7, valo.getValo_tecnica());
            } else {
                ps.setString(7, "");
            }
            ps.setInt(8, valo.getRuta().getId_ruta());
            ps.setInt(9, valo.getUsuario().getId());
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
 * Borra una reseña en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para borrar una fila
 * en la tabla "resenas", a través de su id
 *
 * @author Rubén
 * @param id de tipo int que representa el id de la reseña a borrar
 * @return {@code true} si la reseña fue borrada correctamente en la base de datos; {@code false} en caso contrario
 */  
    public boolean borrarResena(int id) {
        boolean borrada = false;
        String sql = "DELETE FROM resenas WHERE id_resena=?";
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
 * Borra una valoracion en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para borrar una fila
 * en la tabla "valoraciones", a través de su id
 *
 * @author Rubén
 * @param id de tipo int que representa el id de la valoracion a borrar
 * @return {@code true} si la valoracion fue borrada correctamente en la base de datos; {@code false} en caso contrario
 */ 
    public boolean borrarValoracion(int id) {
        boolean borrada = false;
        String sql = "DELETE FROM valoraciones WHERE id_valo=?";
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
 * Genera una lista con todas las reseñas asociadas a una ruta concreta en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para recuperar los objetos {@link Resena} de una ruta en la base de datos
 *
 * @author Rubén
 * @param id de tipo int que representa la id de la ruta de la que se extraerán las reseñas
 * @return una {@link java.util.LinkedList} con las reseñas de la ruta o vacía si no tiene reseñas registradas
 */    
    public LinkedList<Resena> listarResenasPorRuta(int id) {
        LinkedList<Resena> resenas = new LinkedList<>();
        String sql = "SELECT * FROM resenas WHERE rutas_id_ruta=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs != null) {
                    while (rs.next()) {
                        Ruta ruta = RutaBD.obtenerRutaPorId(rs.getInt("rutas_id_ruta"));
                        Usuario usu = UsuarioBD.obtenerUsuarioPorId(rs.getInt("usuarios_cod_usu"));
                        Resena res = new Resena(rs.getInt("id_resena"), ruta, usu, rs.getString("text_resena"));
                        if (!resenas.add(res)) {
                            System.out.println("fallo al insertar resena");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resenas;
    }
        /**
 * Genera una lista con todas las valoraciones asociadas a una ruta concreta en la base de datos.
 *
 * Este método utiliza una sentencia SQL preparada para recuperar los objetos {@link Valoracion} de una ruta en la base de datos
 *
 * @author Rubén
 * @param id de tipo int que representa la id de la ruta de la que se extraerán las valoraciones
 * @return una {@link java.util.LinkedList} con las valoraciones de la ruta o vacía si no tiene valoraciones registradas
 */  
    public LinkedList<Valoracion> listarValoracionesPorRuta(int id) {
        LinkedList<Valoracion> valoraciones = new LinkedList<>();
        String sql = "SELECT * FROM valoraciones WHERE rutas_id_ruta=?";
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs != null) {
                    while (rs.next()) {
                        String texto_valo;
                        if (rs.getString("texto_valo") == null) {
                            texto_valo = "";
                        } else {
                            texto_valo = rs.getString("texto_valo");
                        }
                        Ruta ruta = RutaBD.obtenerRutaPorId(rs.getInt("rutas_id_ruta"));
                        Usuario usu = UsuarioBD.obtenerUsuarioPorId(rs.getInt("usuarios_cod_usu"));
                        Valoracion valo = new Valoracion(rs.getInt("id_valo"), ruta, usu, rs.getInt("dificultad"), rs.getInt("belleza"),
                                rs.getInt("interes_cultu"), rs.getString("texto_valo"), rs.getDate("fecha").toLocalDate(), rs.getBoolean("es_valo_tecnica"), texto_valo);
                        if (!valoraciones.add(valo)) {
                            System.out.println("fallo al insertar valoracion");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return valoraciones;
    }
        /**
 * Genera una lista con todos los puntos de ruta asociados a una ruta concreta en la base de datos y ordenados por el atributo num_orden.
 *
 * Este método utiliza una sentencia SQL preparada para recuperar los objetos {@link Puntos_ruta} de una ruta en la base de datos
 *
 * @author Rubén
 * @param ruta objeto de tipo {@link Ruta} que representa la ruta de la cual se extraerán los puntos asociados
 * @return una {@link java.util.TreeSet} con los Puntos_ruta ordenados o vacía si no tiene puntos asociados
 */ 
    public TreeSet<Puntos_ruta> listarPuntosRuta(Ruta ruta) {
        TreeSet<Puntos_ruta> puntos_ruta = new TreeSet<>();
        LinkedList<Punto_peligro> pp = this.listarPuntosPeligroRuta(ruta.getId_ruta());
        LinkedList<Punto_interes> pi = this.listarPuntosInteresRuta(ruta.getId_ruta());
        for (Punto_peligro puntop : pp) {
            if (!puntos_ruta.add(puntop)) {
                System.out.println("fallo al insertar punto peligro");
            }
        }
        for (Punto_interes puntoi : pi) {
            if (!puntos_ruta.add(puntoi)) {
                System.out.println("fallo al insertar punto de interes");
            }
        }
        return puntos_ruta;
    }

}

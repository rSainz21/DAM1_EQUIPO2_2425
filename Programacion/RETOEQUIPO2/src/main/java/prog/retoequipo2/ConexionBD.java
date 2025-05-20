/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Rubéns
 */
public class ConexionBD {

    private Connection conn = null;
    private static final String BD = "rutas_airelibre";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD;

    private ConexionBD() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("UseSSL", "false");
            properties.setProperty("AutoReconnect", "true");
            conn = DriverManager.getConnection(URL, properties);
            if(conn==null){
                System.out.println("fallo al conectar a la base de datos");
            }else{
                System.out.println("conectado a "+BD);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static class ConexionBDHolder{
     private static final ConexionBD INSTANCE=new ConexionBD();
    }
    public static ConexionBD getInstance(){
        return ConexionBDHolder.INSTANCE;
    }
    public Connection getConn(){
        return conn;
    }
    public boolean cerrarConn(){
        boolean cerrada=false;
        try{
            conn.close();
        if(!conn.isClosed()){
            System.out.println("fallo al cerrar la conexion");
        }else{
            cerrada=true;
        }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return cerrada;
    }
}


package conexionBD;


package org.xulescode.database;
 
import cruds.CrudEmpleado;
import java.sql.*;
 
/**
 * Basic connection to PostgreSQL database. 
 * Conexión básica a la base de datos PostgreSQL.
 *
 * @author Xules You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org).
 */
public class Conexion {
    static private Connection conexion;
    static private Conexion c;
    //String url = "jdbc:postgresql://bfmuoby0ve9qbx6g9mhs-postgresql.services.clever-cloud.com:5432/bfmuoby0ve9qbx6g9mhs";
    //String usuario = "uxnsqttro2jnolgfja56";
    //String password = "7UdeZKa7KkB2zzsqxP9E";
     static private String controlador = "org.postgresql.Driver";
     static private String url = "jdbc:postgresql://localhost:5432/employees";
     static private String usuario = "cesar1xd1";
     static private String password = "1234";

    public static Conexion getC() {
       if (c==null){
           System.out.println("1");
           c = new Conexion();
       }
       return c;
    }
    
    public static Connection getCon() {
        if(conexion==null ){
            System.out.println("11");
            conexion = c.connectDatabase();    
        }
           return conexion;
    }
    
    public static String getControlador() {
        return controlador;
    }
    
     
    public static String getUrl() {
        return url;
    }

    public static String getUsuario() {
        return usuario;
    }
    
    public static String getPassword() {
        return password;
    }
    
    
   public void cerrarConexion() throws SQLException{
       try{
           conexion.close();
       }catch(Exception e){
           conexion.close();
       }finally{
           conexion.close();
       }
       
   }
    public Connection connectDatabase() {
        try {
                Class.forName(controlador);
                conexion = DriverManager.getConnection(url,usuario, password);
            
               
            
 
            boolean valid = conexion.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
            return conexion;
            
        } catch (Exception sqle) {
            System.out.println("Error: " + sqle);
        }
        
        return conexion;
    } 
   
    
	
    
    
    public static void main(String[] args) { 
        new ventanas.Login().setVisible(true);
    }
}
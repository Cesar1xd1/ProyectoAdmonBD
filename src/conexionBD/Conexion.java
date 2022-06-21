
package conexionBD;


package org.xulescode.database;
 
import java.sql.*;
 
/**
 * Basic connection to PostgreSQL database. 
 * Conexión básica a la base de datos PostgreSQL.
 *
 * @author Xules You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org).
 */
public class Conexion {
    Connection con = null;
    String controlador = "org.postgresql.Driver";
    String url = "jdbc:postgresql://localhost:5432/employees";
    String usuario = "cesar1xd1";
    String password = "1234";

    public String getControlador() {
        return controlador;
    }

    public String getUrl() {
        return url;
    }
    
    
    
    
    public Connection connectDatabase() {
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try { 
                Class.forName(controlador);
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            con = null;
            // Database connect
            // Conectamos con la base de datos
            con = DriverManager.getConnection(
                    url,
                    usuario, password);
 
            boolean valid = con.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        return con;
    } 
   
    
	
    
    
    public static void main(String[] args) {
        Conexion javaPostgreSQLBasic = new Conexion();
        javaPostgreSQLBasic.connectDatabase(); 
    }
}
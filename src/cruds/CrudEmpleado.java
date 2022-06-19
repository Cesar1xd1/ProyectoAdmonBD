
package cruds;
import conexionBD.Conexion;
import java.sql.Connection;
import modelo.Empleado;

public class CrudEmpleado {
    Conexion con = new Conexion();
    
    
public boolean insert(Empleado em){
   boolean resultado = false;
   String sql = "INSERT INTO employees VALUES('"+em.getNoEmpleado()+"','"+em.getFechaNacimiento()+"','"+em.getNombre()+"','"+em.getApellido()+"','"+em.getGenero()+"','"+em.getFechaContrato()+"');";
   resultado = con.ejecutarInstruccion(sql);
   return resultado;
}//insert    
    
    
}

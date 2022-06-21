
package cruds;
import conexionBD.Conexion;
import java.sql.Connection;
import modelo.Departamento;
import modelo.Empleado;


public class CrudDepartamentos {
    Conexion con = new Conexion();
    
 public boolean insert(Departamento dep){
   boolean resultado = false;
    try{
   Connection conexion = con.connectDatabase();
   java.sql.Statement st = conexion.createStatement();
   String sql = "INSERT INTO departments (dept_no,dept_name) VALUES ('"+dep.getNoDepartamento()+"','"+dep.getNombreDepartamento()+"');";
   st.execute(sql);
   st.close();
   resultado = true;
   conexion.close();
   }catch (Exception e){ 
   }
   return resultado;
}//insert 
 public boolean delete(String de){
   boolean resultado = false;
    try{
   Connection conexion = con.connectDatabase();
   java.sql.Statement st = conexion.createStatement();
   String sql = "DELETE FROM departments WHERE dept_no = '"+de+"';";
   st.execute(sql);
   st.close();
   resultado = true;
   conexion.close();
   }catch (Exception e){ 
   }
   return resultado;
}//delete
 public boolean modificar(Departamento dep){
   boolean resultado = false;
    try{
   Connection conexion = con.connectDatabase();
   java.sql.Statement st = conexion.createStatement();
   String sql = "UPDATE departments SET dept_name= '"+dep.getNombreDepartamento()+ "' WHERE dept_no = '"+dep.getNoDepartamento()+"';";    
   st.execute(sql);
   st.close();
   resultado = true;
   conexion.close();
   }catch (Exception e){ 
   }
   return resultado;
}//modificar
    
    
    
    
    
    
    
}


package cruds;
import conexionBD.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empleado;
import ventanas.ResulSetTableModel;
import ventanas.VentanaPrincipal;

public class CrudEmpleado {
    Conexion c = Conexion.getC();
    Connection conn = c.getCon();

    
    
 public boolean beggin(){
   boolean resultado = false;
   try{
   Statement st = conn.createStatement();
   st.executeQuery("BEGIN TRANSACTION");
   st.close();
   resultado = true;
   }catch (Exception e){ 
   }
   return resultado;
}
  public boolean commit(){
   boolean resultado = false;
   try{
   Statement st = conn.createStatement();
   String sql = "COMMIT;";
   st.executeQuery(sql);
   st.close();
   resultado = true;
   }catch (Exception e){ 
   }
   return resultado;
}
  public boolean rollback(){
   boolean resultado = false;
   try{
   Statement st = conn.createStatement();
   String sql = "ROLLBACK;";
   st.executeQuery(sql);
   st.close();
   resultado = true;
   }catch (Exception e){ 
   }
   return resultado;
}   
public String confecha(String m){
   String [] x = m.split("/");
   String y = x[0]+"-"+x[1]+"-"+x[2];
   return y; 
}   

public boolean insert(Empleado em){
   boolean resultado = false;
   try{
   Statement st = conn.createStatement();
   String sql = "INSERT INTO employees (emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES ('"+em.getNoEmpleado()+"','"+em.getFechaNacimiento()+"','"+em.getNombre()+"','"+em.getApellido()+"','"+em.getGenero()+"','"+em.getFechaContrato()+"');";
       System.err.println(sql);
   st.execute(sql);
   st.close();
   resultado = true;
   }catch (Exception e){
       System.err.println(e);  
   }
   return resultado;
}//insert    
public boolean delete(String ne){
   boolean resultado = false;
   try{
   Statement st = conn.createStatement();
   String sql = "DELETE FROM employees WHERE emp_no = '"+ne+"';";
   st.execute(sql);
   st.close();
   resultado = true;
   }catch (Exception e){ 
   }
   return resultado;
}//delete

public boolean modificar(Empleado em){
   boolean resultado = false;
   try{
   Statement st = conn.createStatement();
   String sql = "UPDATE employees SET birth_date='"+em.getFechaNacimiento()+"', first_name='"+em.getNombre()+"', last_name='"+em.getApellido()+"'"+", gender='"+em.getGenero()+"', hire_date='"+em.getFechaContrato()+"' "+ " WHERE emp_no = '"+em.getNoEmpleado()+"';";    
   st.execute(sql);
   st.close();
   resultado = true;
  
   }catch (Exception e){ 
   }
   return resultado;
}//modificar

    
}

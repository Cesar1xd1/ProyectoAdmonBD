
package cruds;
import conexionBD.Conexion;
import java.sql.Connection;
import modelo.Empleado;

public class CrudEmpleado {
    Conexion con = new Conexion();

    
    
public boolean insert(Empleado em){
   boolean resultado = false;
   try{
   Connection conexion = con.connectDatabase();
   java.sql.Statement st = conexion.createStatement();
   String sql = "INSERT INTO employees (emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES ('"+em.getNoEmpleado()+"','"+em.getFechaNacimiento()+"','"+em.getNombre()+"','"+em.getApellido()+"','"+em.getGenero()+"','"+em.getFechaContrato()+"');";
   st.execute(sql);
   st.close();
   resultado = true;
   conexion.close();
   }catch (Exception e){ 
   }
   return resultado;
}//insert    
public boolean delete(String ne){
   boolean resultado = false;
    try{
   Connection conexion = con.connectDatabase();
   java.sql.Statement st = conexion.createStatement();
   String sql = "DELETE FROM employees WHERE emp_no = '"+ne+"';";
   st.execute(sql);
   st.close();
   resultado = true;
   conexion.close();
   }catch (Exception e){ 
   }
   return resultado;
}//delete

public boolean modificar(Empleado em){
   boolean resultado = false;
    try{
   Connection conexion = con.connectDatabase();
   java.sql.Statement st = conexion.createStatement();
   String sql = "UPDATE employees SET birth_date='"+em.getFechaNacimiento()+"', first_name='"+em.getNombre()+"', last_name='"+em.getApellido()+"'"+", gender='"+em.getGenero()+"', hire_date='"+em.getFechaContrato()+"' "+ " WHERE emp_no = '"+em.getNoEmpleado()+"';";    
   st.execute(sql);
   st.close();
   resultado = true;
   conexion.close();
   }catch (Exception e){ 
   }
   return resultado;
}//modificar

    
}

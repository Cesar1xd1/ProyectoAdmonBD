
package cruds;
import conexionBD.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import modelo.Departamento;
import modelo.Empleado;


public class CrudDepartamentos {
    Conexion c = Conexion.getC();
    Connection conn =  c.getCon();
    
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
    
 public boolean insert(Departamento dep){
   boolean resultado = false;
   try{ 
   Statement st = conn.createStatement();
   String sql = "INSERT INTO departments (dept_no,dept_name) VALUES ('"+dep.getNoDepartamento()+"','"+dep.getNombreDepartamento()+"');";
   st.execute(sql);
   st.close();
   resultado = true;
   }catch (Exception e){ 
   }
   return resultado;
}//insert 
 public boolean delete(String de){
   boolean resultado = false;
    try{
   
   java.sql.Statement st = conn.createStatement();
   String sql = "DELETE FROM departments WHERE dept_no = '"+de+"';";
   st.execute(sql);
   st.close();
   resultado = true;
   //conexion.close();
   }catch (Exception e){ 
   }
   return resultado;
}//delete
 public boolean modificar(Departamento dep){
   boolean resultado = false;
    try{
   
   java.sql.Statement st = conn.createStatement();
   String sql = "UPDATE departments SET dept_name= '"+dep.getNombreDepartamento()+ "' WHERE dept_no = '"+dep.getNoDepartamento()+"';";    
   st.execute(sql);
   st.close();
   resultado = true;
   //conexion.close();
   }catch (Exception e){ 
   }
   return resultado;
}//modificar
    
    
    
    
    
    
    
}

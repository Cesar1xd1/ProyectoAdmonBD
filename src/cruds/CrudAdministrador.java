
package cruds;

import conexionBD.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import modelo.Administrador;
import modelo.Departamento;



public class CrudAdministrador {
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
    
    
    
    public boolean insert(Administrador adm){
   boolean resultado = false;
    try{
   Statement st = conn.createStatement();
   String sql = "INSERT INTO dept_manager (emp_no,dept_no,from_date,to_date) VALUES ('"+adm.getNoEmpleado()+"','"+adm.getNoDepartamento()+"','"+adm.getFechaFrom()+"','"+adm.getFechaTo()+"');";
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
   
   Statement st = conn.createStatement();
   String sql = "DELETE FROM dept_manager WHERE emp_no = '"+de+"';";
   st.execute(sql);
   st.close();
   resultado = true;
   
   }catch (Exception e){ 
   }
   return resultado;
}//delete
     public boolean modificar(Administrador adm){
   boolean resultado = false;
    try{
   
   java.sql.Statement st = conn.createStatement();
   String sql = "UPDATE dept_manager SET dept_no= '"+adm.getNoDepartamento()+"' ,from_date= '"+adm.getFechaFrom()+"' ,to_date= '" + adm.getFechaTo()
                + "' WHERE emp_no= '"+adm.getNoEmpleado()+"' AND dept_no = '"+adm.getNoDepartamento()+"' ;";
   st.execute(sql);
   st.close();
   resultado = true;
  
   }catch (Exception e){ 
   }
   return resultado;
}//modificar
}

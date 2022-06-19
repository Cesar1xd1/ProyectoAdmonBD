
package modelo;


public class Administrador {
    private int noEmpleado;
    private String noDepartamento;
    private String fechaFrom;
    private String fechaTo;

    public Administrador(int noEmpleado, String noDepartamento, String fechaFrom, String fechaTo) {
        this.noEmpleado = noEmpleado;
        this.noDepartamento = noDepartamento;
        this.fechaFrom = fechaFrom;
        this.fechaTo = fechaTo;
    }

    public int getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(int noEmpleado) {
        this.noEmpleado = noEmpleado;
    }

    public String getNoDepartamento() {
        return noDepartamento;
    }

    public void setNoDepartamento(String noDepartamento) {
        this.noDepartamento = noDepartamento;
    }

    public String getFechaFrom() {
        return fechaFrom;
    }

    public void setFechaFrom(String fechaFrom) {
        this.fechaFrom = fechaFrom;
    }

    public String getFechaTo() {
        return fechaTo;
    }

    public void setFechaTo(String fechaTo) {
        this.fechaTo = fechaTo;
    }
    
    
            
}

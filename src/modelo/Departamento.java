
package modelo;

public class Departamento {
    private String noDepartamento;
    private String nombreDepartamento;

    public Departamento(String noDepartamento, String nombreDepartamento) {
        this.noDepartamento = noDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNoDepartamento() {
        return noDepartamento;
    }

    public void setNoDepartamento(String noDepartamento) {
        this.noDepartamento = noDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
   
    
    
}

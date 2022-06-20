
package modelo;


public class Empleado {
        private int noEmpleado;
        private String fechaNacimiento;
        private String nombre;
        private String apellido;
        private String genero;
        private String fechaContrato;

    public Empleado(int noEmpleado, String fechaNacimiento, String nombre, String apellido, String genero, String fechaContrato) {
        this.noEmpleado = noEmpleado;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaContrato = fechaContrato;
    }

    public int getNoEmpleado() {
        return noEmpleado;
    }

    public void setNoEmpleado(int noEmpleado) {
        this.noEmpleado = noEmpleado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Empleado{" + "noEmpleado=" + noEmpleado + ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", fechaContrato=" + fechaContrato + '}';
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
    
        
}

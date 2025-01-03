package barberia.logica;

// Paquetes utilizados
import java.io.Serializable;

// Servicio: Clase que se encarga de las características de un servicio.
public class Servicio implements Serializable{
    // Variables utilizadas
    private String descripcion;
    
    // Constructor
    public Servicio(String descripcion){
        this.descripcion = descripcion;
    }
    
    // Getters & Setters
    
    // Método para obtener la descripción.
    public String getDescripcion() {
        return descripcion;
    }

    // Método para establecer la descripción.
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    // Método  para sobreescribir el toString de la clase.
    public String toString(){
        String servicioInfo = "Servicio (Descripcion = \'" + descripcion + "\' )";
        return servicioInfo;
    }
    
}

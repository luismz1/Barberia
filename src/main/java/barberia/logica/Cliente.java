package barberia.logica;

// Paquetes utilizados
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

// Cliente: Clase que se encarga de las características de un cliente.
public class Cliente implements Serializable {
    // Variables utilizados
    private Map<Integer, Cita> citasCliente;
    private String nombre;
    private String email;
    private String numeroTel;
    
    // Constructor
    public Cliente(String nombre, String email, String numeroTel){
        this.nombre = nombre;
        this.email = email;
        this.numeroTel = numeroTel;
        citasCliente = new TreeMap<>();
    }
    
    // Getters & Setters
    
    // Método para obtener el nombre de un cliente.
    public String getNombre() {
        return nombre;
    }
    
    // Método para establecer el nombre de un cliente.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el correo de un cliente.
    public String getEmail() {
        return email;
    }

    // Método para establecer el correo de un cliente.
    public void setEmail(String email) {
        this.email = email;
    }

    // Método para obtener el número de teléfono de un cliente.
    public String getNumeroTel() {
        return numeroTel;
    }
    
    // Método para establecer el número de teléfono de un cliente.
    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
    
    // Método para retornar las citas disponibles de un cliente.
    public ArrayList<String> getCitas(){
        ArrayList<String> infoCitas = new ArrayList<>();
        for (Cita cita: citasCliente.values()){
            infoCitas.add(cita.toString());
        }
        return infoCitas;
    }
    
    // Método para agregar una cita a un cliente según su identificador.
    public void addCita(int numeroCita, Cita cita){
        citasCliente.put(numeroCita, cita);
    }
    
    // Método para remplazar una cita a un cliente según su identificador.
    public void setCita(int numeroCita, Cita cita){
        if(!citasCliente.containsKey(numeroCita))
            addCita(numeroCita, cita);
        else
            // Dado un número de cita, se reemplaza la cita anterior con la que fue recibida como parámetro.
            citasCliente.replace(numeroCita, cita);
    }
    
    // Método para eliminar una cita según su identificador.
    public void removeCita(int numeroCita){
        citasCliente.remove(numeroCita);
    }
            
   @Override
   // Método  para sobreescribir el toString de la clase.
   public String toString(){
       String clienteInfo = "Cliente (Correo = \'" + email + "\' Nombre = \'" + nombre;
       clienteInfo += "\' Telefono: \'" + numeroTel + "\' )";
       return clienteInfo;
   }
    
}

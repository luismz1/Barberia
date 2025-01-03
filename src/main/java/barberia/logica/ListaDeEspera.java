package barberia.logica;

// Paquetes utilizados
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// ListaDeEspera: Clase que se encarga de las características de la lista de espera de clientes.
public class ListaDeEspera implements Serializable {
    // Variables utilizadas
    private Queue <Cliente> listaClientes;
    
    // Constructor
    public ListaDeEspera(){
        listaClientes = new LinkedList<>();
    }
        
    // Método para agregarr un cliente a la lista de espera.
    public void agregarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    // Método para eliminar un cliente de la lista de espera.
    public void eliminarCliente(Cliente cliente){
        listaClientes.remove(cliente);
    }
    
    // Método para eliminar un cliente de la lista de espera.
    public boolean clienteEspera(String email){
        for (Cliente cliente: listaClientes){
            if (cliente.getEmail().equals(email))
                return true;
        }
        return false;
    }
     
    // Método para obtener la información de la lista de espera.
    public ArrayList<String> informacionListaDeEspera(){
        ArrayList<String> infoListaDeEspera = new ArrayList <>();
        for (Cliente cliente : listaClientes){
            infoListaDeEspera.add(cliente.toString());
        }
       return infoListaDeEspera;
    }
    
}

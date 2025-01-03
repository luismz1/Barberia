package barberia.logica;

// Paquetes  utilizados
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

// Cita: Clase que se encarga de las características de una cita.
public class Cita implements Serializable {
    // Variables utilizadas
    public static int consecutivo = 1;
    private int identificador;
    private boolean confirmada;
    private Cliente cliente;
    private Servicio servicio;
    private LocalDate fecha;
    private int hora;
    
    // Constructor.
    public Cita(Cliente cliente, Servicio servicio, LocalDate fecha, int hora){
        this.cliente = cliente;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
        confirmada = false;
        identificador = consecutivo++;
    }
    
     // Getters & Setters
    
    // Método para obtener el identificador de la cita.
    public int getIdentificador() {
        return identificador;
    }
    
    // Método para obtener la fecha de la cita.
    public LocalDate getFecha() {
        return fecha;
    }
    
    // Método para establecer la fecha de la cita.
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    // Método para obtener la obtener la cita.
    public int getHora() {
        return hora;
    }
    
    // Método para obtener la hora de la cita como un String.
    public String getHoraToString(){
        String horaValue = String.valueOf(hora);
        if (horaValue.length() == 1)
            horaValue = "0" + horaValue;
        // Si la hora es menor que doce, se le hace un ajuste para que sea AM.
        if (hora < 12)
            horaValue += ":00 am";
        //  Si la hora es mayor o igual que doce, entonces se le hace un ajuste para que sea PM.
        else
            horaValue += ":00 pm";
        return horaValue;
    }
    
    // Método para obtener el estado de la cita como un String.
    public String getConfirmadaToString(){
        String confirmadaValue;
        // Si la cita está confirmada, se pasa el valor de confmada value como "Sí".
        if (confirmada == true)
            confirmadaValue = "Si";
        // En caso de que esta no se encuentre confirmada, se pasa el valor de confirmada como "No".
        else
            confirmadaValue = "No";
        return confirmadaValue;
    }
    
    // Método para establecer la hora dentro de la cita.
    public void setHora(int hora) {
        this.hora = hora;
    }
    
    // Método para obtener el cliente dentro de la cita.
    public Cliente getCliente(){
        return cliente;
    }
    
    // Método para establecer el cliente dentro de la cita.
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    // Método para obtener el servicio dentro de la cita.
    public Servicio getServicio(){
        return servicio;
    }
    
    // Método para establecer el servicio dentro de la cita.
    public void setServicio(Servicio servicio){
        this.servicio = servicio;
    }
    
    // Método para retornar el estado de la cita.
    public boolean estadoConfirmar(){
        return confirmada;
    }
    
    // Método para confirmar la cita.
    public void confirmarCita(){
        confirmada = true;
    }
    
    // Método para obtener la información de la cita.
    public ArrayList<String> informacionCita(){
        ArrayList<String> infoCita = new ArrayList<>();
        // Se obtiene el valor en formato String para la hora y se le aplican cambios si son necesarios.
        infoCita.add(Integer.toString(identificador));
        infoCita.add(cliente.getEmail());
        infoCita.add(servicio.getDescripcion());
        infoCita.add(fecha.toString());
        infoCita.add(getHoraToString());
        infoCita.add(getConfirmadaToString());
        
        return infoCita;
    }
    
    @Override
    // Método  para sobreescribir el toString de la clase.
    public String toString(){
        String citaInfo = "Cita (Identificador = \'" + identificador + "\' Cliente = \'" + cliente.getEmail() + "\' Servicio = \'" + servicio.getDescripcion();
        citaInfo += "\' Fecha = \'" + fecha + "\' Hora = \'" + getHoraToString() + "\' Confirmada \'"+ getConfirmadaToString() +"\' )";
        return citaInfo;
    }


    
    
}

package barberia.logica;

// Paquetes utilizados
import barberia.control.DataVerification;
import java.io.Serializable;

// HorarioDia: Clase que se encarga de las características del horario de un día.
public class HorarioDia implements Serializable{
    // Variables utilizadas
    private int dia;
    private int horaApertura;
    private int horaClausura;
    
    // Constructor
    public HorarioDia(int dia){
        this.horaApertura = 0;
        this.horaClausura = 0;
        this.dia = dia;
    }
    
    // Getters & Setters
    
    // Método para obtener la hora de apertura.
    public int getHoraApertura(){
       return horaApertura;
    }

    // Método para obtener la hora de clausura.
    public int getHoraClausura(){
       return horaClausura;
    }
    
    // Método para obtener el día.
    public int getDia(){
        return dia;
    }
    
    // Método para establecer la hora de apertura.
    public void setHoraApertura(int hora){
        horaApertura = hora;
    }
    
    // Método para establecer la hora de clausura.
    public void setHoraClausura(int hora){
        horaClausura = hora;
    }
    
    // Método para determinar si una hora está disponible dentro del horario.
    public boolean diaTrabajable(int hora){
        return hora >= horaApertura && hora < horaClausura;
    }
    
    @Override
    // Método  para sobreescribir el toString de la clase.
    public String toString(){
        String horarioInfo;
        String aperturaInfo;
        String clausuraInfo;
        if (horaApertura == horaClausura){
           horarioInfo = "Dia: " + DataVerification.IntToStringDay(dia) + "  No hay trabajo";
        }else{
            // Se determina si es AM o PM para la hora de apertura.
            if (horaApertura < 12)
                aperturaInfo = ":00 am";
            else
                aperturaInfo = ":00 pm";
             // Se determina si es AM o PM para la hora de clausura.
            if (horaClausura < 12)
                clausuraInfo = ":00 am";
            else
                clausuraInfo = ":00 pm";
            horarioInfo = "Dia: " + DataVerification.IntToStringDay(dia) + "  " +horaApertura+  aperturaInfo + " - " 
                                + horaClausura +  clausuraInfo;
        }
        return horarioInfo;
    }
    
}

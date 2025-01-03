/*Elaborado por:
Daniel Alemán Ruiz (2023051957)
Luis Meza Chavarría (2023800023)
David Matamoros Jiménez (2023800039)*/
package barberia.control;

// Paquetes utilizados
import barberia.logica.Cliente;
import barberia.logica.Cita;
import barberia.logica.Servicio;
import java.util.Map;
import java.util.TreeMap;
import barberia.logica.HorarioDia;
import barberia.logica.ListaDeEspera;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Control: Clase encargada de llevar a cabo los procesos que son necesarios para el funcionamiento de la interfaz del programa.
public class Control implements Serializable{
    // Variables utilizadas
    private static Control instance = null;
    private Map<String, Cliente> clientes;
    private Map<Integer, Cita> citas;
    private Map<String, Servicio> servicios;
    private List<HorarioDia> horarios;
    private ListaDeEspera clientesEspera;
    // La palabra reservada transient permite que cuando se guardan los datos este sea ignorado.
    private MailSender mailSender;
    
    // Constructor
    private Control(){
        clientes = new TreeMap();
        citas = new TreeMap();
        servicios = new TreeMap();
        horarios = new ArrayList<>();
        clientesEspera = new ListaDeEspera();
        mailSender = new MailSender();
        for (int i = 0; i < 7; i++){
            horarios.add(new HorarioDia(i));
        }
    }
    
    // Método que permite obtener una instancia de control, si esta no se puede obtener entonces crea una.
    public static Control getInstance(){
        if (instance == null){
            try{
                instance = cargarDatos();
            }catch (Exception e){
                System.out.println("Error: " + e.toString());
                System.out.println("Se creará un nuevo control.");
                instance = new Control();
            }
        }
        return instance;
    }
    
    // Método utilizado para re asignar los consecutivos de las citas.
    private void reasignarConsecutivoCitas(){
        Set <Integer> set;
        set = citas.keySet();
        Iterator<Integer> i = set.iterator();
        int mayor = 0;
        while (i.hasNext()){
            int actual = i.next();
            if (actual > mayor)
                mayor = actual;
        }
       Cita.consecutivo = mayor + 1;
    }
    
    // Método para obtener un cliente según su identificador (correo electrónico).
    private Cliente obtenerCliente(String emailCliente){
        for (Cliente cliente: clientes.values()){
                if (cliente.getEmail().equals(emailCliente))
                    return cliente;
        }
        throw new IllegalArgumentException("Error: El cliente solicitado no se encuentra disponible.");
    }
    
    // Método para obtener una cita según su identificador (número de cita).
    private Cita obtenerCita(int identificador){
        for (Cita cita: citas.values()){
            if (cita.getIdentificador() == identificador)
                return cita;
        }
        throw new IllegalArgumentException("Error: La cita solicitada no se encuentra disponible.");        
    }
    
    // Método para obtener un servicio según su identificador (descripción del servicio).
    private Servicio obtenerServicio(String descripcionServicio){
        for (Servicio servicio : servicios.values()){
            if (servicio.getDescripcion().equals(descripcionServicio))
                return servicio;
        }
        throw new IllegalArgumentException("Error: El servicio solicitado no se encuentra disponible.");
    }
    
    // Método para obtener el horario de un día según el número de día.
    private HorarioDia obtenerHorarioDia (int dia){
        for (HorarioDia horario : horarios){
           if (horario.getDia() == dia)
               return horario;
        }
        throw new IllegalArgumentException("Error: El horario solicitado no se encuentra disponible.");
    }
    
    // Método para ver la información de los clientes disponibles.
    public ArrayList<String> verClientes(){
        ArrayList<String> clientesInfo = new ArrayList<>();
        for (Cliente cliente : clientes.values()){
            clientesInfo.add(cliente.toString());
        }
        return clientesInfo;
    }
    
    // Método para ver la información de los servicios disponibles.
    public ArrayList<String> verServicios(){
        ArrayList<String> serviciosInfo = new ArrayList<>();
        for (Servicio servicio : servicios.values()){
            serviciosInfo.add(servicio.toString());
        }
        return serviciosInfo;
    }
    
    // Método para ver la información de los horarios disponibles.
    public ArrayList<String> verHorario(){
        ArrayList<String> horarioInfo = new ArrayList<>();
        for (HorarioDia horario : horarios){
            horarioInfo.add(horario.toString());
        }
        return horarioInfo;
    }
    
    // Método para ver las citas pendientes para el día de mañana.
    public ArrayList<String> verCitasPendientesCorreo(){
        ArrayList<String> infoCitas = new ArrayList<>();
        for (Cita cita : citas.values()){
                if (cita.estadoConfirmar() == false && cita.getFecha().equals(LocalDate.now().plusDays(1)))
                    infoCitas.add(cita.toString());
        }
        return infoCitas;
    }
    
    // Método para ver la información de las citas disponibles.
    public ArrayList<ArrayList<String>> verCitas(){
        ArrayList<ArrayList<String>> infoCitas = new ArrayList<>();
        for (Cita cita : citas.values()){
              infoCitas.add(cita.informacionCita());
        }
        return infoCitas;
    }
    
    // Método para ver las citas filtradas por el tipo de busqueda y una fecha en específico.
    public ArrayList<ArrayList<String>> verCitasFiltradas(int tipoBusqueda, LocalDate fecha){
        /*Case 0: Filtrar por semanas.
          Case 1: Filtrar por meses.*/
        ArrayList<ArrayList<String>> infoCitas = new ArrayList<>();
        switch(tipoBusqueda){
            case 0:
                // Entre las citas filtre las que compartan el número de semana en el año, las que compartan el año y además
                // que la fecha que se consulta sea posterior o igual a la fecha que se busca.
                for (Cita cita: citas.values()){
                    if (DataVerification.getWeekNumber(fecha) == DataVerification.getWeekNumber(cita.getFecha()) && 
                            fecha.getYear() == cita.getFecha().getYear() && (cita.getFecha().isAfter(fecha) || cita.getFecha().equals(fecha)))
                                infoCitas.add(cita.informacionCita());
                }
                break;
            default:
                // Entre las citas filtre las que compartan el número de mes en el año, las que compartan el año y además
                // que la fecha que se consulta sea posterior o igual a la fecha que se busca.
                for (Cita cita: citas.values()){
                    if (fecha.getMonthValue() == cita.getFecha().getMonthValue() && 
                            fecha.getYear() == cita.getFecha().getYear() && (cita.getFecha().isAfter(fecha) || cita.getFecha().equals(fecha)))
                                infoCitas.add(cita.informacionCita());
                    }
                 break;
        }
        return infoCitas;
    }
    
    // Método para ver la información de los correos de los usuarios disponibles.
    public ArrayList<String> verEmails(){
        ArrayList<String> infoCorreos = new ArrayList<>();
        for (Cliente cliente : clientes.values()){
            infoCorreos.add(cliente.getEmail());
        }
        return infoCorreos;
    }
    
    // Método para ver la información de las descripciones disponibles.
    public ArrayList<String> verServiciosDescripciones(){
        ArrayList<String> infoServicios = new ArrayList<>();
        for (Servicio servicio: servicios.values()){
            infoServicios.add(servicio.getDescripcion());
        }
        return infoServicios;
    }
    
    // Método para ver la información de las citas que tiene un cliente.
    public ArrayList<String> verCitasCliente(String email){
        Cliente cliente = obtenerCliente(email);
        return cliente.getCitas();
    }

    // Método para ver la información de lista de espera.
    public ArrayList<String> verListaDeEspera(){
        return clientesEspera.informacionListaDeEspera();
    }
    
    // Método para obtener la información de un cliente en un formato de lista.
    public ArrayList<String> getInfoCliente(String email){
        Cliente cliente = obtenerCliente(email);
        return new ArrayList<>(Arrays.asList(cliente.getNombre(), cliente.getEmail(), cliente.getNumeroTel()));
    }
    
    // Método para agregar un cliente al sistema.
    public void agregarCliente(String nombre, String email, String numeroTel){
        Cliente cliente = new Cliente(nombre, email, numeroTel);
        clientes.put(email, cliente);
    }
    
    // Método para eliminar un cliente del sistema según su identificador (correo electrónico).
    public void eliminarCliente(String email){
        clientes.remove(email);
    }
    
    // Método para modificar un cliente del sistema según su identificador (correo electrónico).
    public void modificarCliente(String email, String nombre, String emailNuevo, String numeroTel){
        Cliente cliente = obtenerCliente(email);
        cliente.setNombre(nombre);
        cliente.setEmail(emailNuevo);
        cliente.setNumeroTel(numeroTel);
        // Se quita el anterior elemento y se reemplaza con su nueva llave y sus cambios efectuados.
        clientes.remove(email);
        clientes.put(emailNuevo, cliente);
    }
    
    // Método para verificar si un cliente existe dentro del sistema según su identificador.
    public boolean clienteExiste(String email){
        for (Cliente cliente: clientes.values()){
            if (email.equals(cliente.getEmail()))
                return true;
        }
        return false;
    }
    
    // Método para verificar si un cliente se encuentra en lista de espera dentro del sistema.
    public boolean clienteEspera(String email){
        return clientesEspera.clienteEspera(email);
    }
        
    // Método para agregar una cita al sistema según su identificador.
    public void agregarCita(String emailCliente, String descripcionServicio, LocalDate fecha, int hora){
        Cliente cliente = obtenerCliente(emailCliente);
        Servicio servicio = obtenerServicio(descripcionServicio);
        Cita cita = new Cita(cliente, servicio, fecha, hora);
        cliente.addCita(cita.getIdentificador(), cita);
        citas.put(cita.getIdentificador(), cita);
    }
    
    // Método para eliminar una cita del sistema según su identificador.
    public void eliminarCita(int identificador){
        Cita cita = obtenerCita(identificador);
        // Se elimina la cita a su respectivo cliente.
        cita.getCliente().removeCita(identificador);
        // Se elimina la cita de la colección de citas.
        citas.remove(identificador);
    }
    
    // Método para modificar una cita dentro del sistema según su identificador.
    public void modificarCita(int identificador, String emailCliente, String descripcionServicio, LocalDate fecha, int hora){
        // Se obtiene el cliente nuevo.
        Cliente clienteNuevo = obtenerCliente(emailCliente);
        // Se obtiene el servicio.
        Servicio servicio = obtenerServicio(descripcionServicio);
        // Se obtiene la cita según el identificador.
        Cita cita = obtenerCita(identificador);
        // Se obtiene el cliente que estaba asignado a la cita.
        Cliente clienteViejo = cita.getCliente();
        // Si ambos clientes tienen distinto correo, son distintos clientes, hay que eliminar del cliente viejo la cita.
        if (!clienteNuevo.getEmail().equals(clienteViejo.getEmail())){
            clienteViejo.removeCita(identificador);
        }
        // A la cita, se le cambia el cliente, servicio, fecha y hora.
        cita.setCliente(clienteNuevo);
        cita.setServicio(servicio);
        cita.setFecha(fecha);
        cita.setHora(hora);
        //Se cambian los elementos de la cita para el cliente y se reemplaza en el diccionario de citas.
        clienteNuevo.setCita(cita.getIdentificador(), cita);
        // Aprovechando que la llave no va a cambiar, se puede reasignar a la misma llave una distinta cita.
        citas.replace(cita.getIdentificador(), cita);
    }

    // Método para confirmar una cita según su identificador.
    public void confirmarCita(int identificador){
        // Se obtiene la cita según el identificador.
        Cita cita = obtenerCita(identificador);
        // Se cambia el estado de la cita para confirmarla.
        cita.confirmarCita();
    }
    
   // Método para verificar si una cita existe dentro del sistema según fecha y hora.
    public int citaExiste(LocalDate fecha, int hora){
        // Se abre un ciclo para iterar entre las fechas, si se encuentra entonces se retorna el identificador.
        for (Cita cita : citas.values()){
            if (fecha.equals(cita.getFecha()) && hora == cita.getHora())
                return cita.getIdentificador();
        }
        // Si la fecha no se encuentra disponible entonces se retorna un menos uno.
        return -1;
    }

    // Método para verificar si una cita se encuentra confirmada según su identificador.
    public boolean citaConfirmada(int identificador){
        // Se obtiene la cita según el identificador.
        Cita cita = obtenerCita(identificador);
        // Se retorna el valor de si la cita se encuentra confirmada.
        return cita.estadoConfirmar();
    }
        
    // Método para agregar un servicio al sistema según su identificador (descripción del servicio).
    public void agregarServicio(String descripcion){
        Servicio servicio = new Servicio(descripcion);
        servicios.put(descripcion, servicio);
    }
    
    // Método para eliminar un servicio del sistema según su identificador (descripción del servicio).
    public void eliminarServicio(String identificador){
        servicios.remove(identificador);
    }
    
    // Método para modificar un servicio según su identificador (descripción del sistema).
    public void modificarServicio(String identificador, String descripcion){
        Servicio servicio = obtenerServicio(identificador);
        servicio.setDescripcion(descripcion);
         // Se quita el anterior elemento y se reemplaza con su nueva llave y sus cambios efectuados.
        servicios.remove(identificador);
        servicios.put(descripcion, servicio);
    }

    // Método para verificar si un servicio existe dentro del sistema según su descripción.
    public boolean servicioExiste(String descripcion){
        for (Servicio servicio : servicios.values()){
            if (descripcion.equals(servicio.getDescripcion()))
                return true;
        }
        return false;
    }
    
    // Método para verificar si un servicio tiene asociado una cita.
    public boolean servicioConCita(String descripcion){
        for (Cita cita : citas.values()){
            if (descripcion.equals(cita.getServicio().getDescripcion()))
                return true;
        }
        return false;
    }
    
    // Método para asignar un horario con hora de apertura y clausura en un día específico.
    public void establecerHorario(int dia, int horaApertura, int horaClausura){
        HorarioDia horario = obtenerHorarioDia(dia);
        horario.setHoraApertura(horaApertura);
        horario.setHoraClausura(horaClausura);
    }
   
    // Método para asignar un horario con hora de apertura y clausura para todos los días.
    public void establecerHorarioTodos(int horaApertura, int horaClausura){
        for (HorarioDia horario : horarios){
            horario.setHoraApertura(horaApertura);
            horario.setHoraClausura(horaClausura);
        }
    }
    
    // Método que determina si un día es trabajable a partir de cierta hora.
    public boolean diaTrabajable(int dia, int hora){
        // Revisa si una hora es trabajable en ceierto día.
        return horarios.get(dia).diaTrabajable(hora);
    }
        
    // Método para agregar un cliente a lista de espera según su identificador.
    public void agregarClienteEspera(String email){
        // Se obtiene el cliente según su email y se agrega a la lista de espera.
        Cliente cliente = obtenerCliente(email);
        clientesEspera.agregarCliente(cliente);
    }
    
    // Método para eliminar un cliente de lista de espera según su identificador.
    public void eliminarClienteEspera(String email){
        // Se obtiene el cliente según su email y se elimina de la lista de espera.
        Cliente cliente = obtenerCliente(email);
        clientesEspera.eliminarCliente(cliente);
    }
    
    // Método para enviar un correo, recibe un correo y el cuerpo del correo.
    public void enviarCorreo(String email, String cuerpo){
        mailSender.createMail(email, "Confirmación de cita - Barberia", cuerpo);
        mailSender.sendMail();
    }
    
    // Método para enviar todos los correos a las citas seleccionadas.
    public boolean prepararCorreos(ArrayList<String> citasInfo){
        // Lista donde se obtienen los identificadores.
        ArrayList<Integer> identificadores = new ArrayList<>();
        // Variables utilizadas para enviar el correo.
        String correo;
        String nombre;
        String hora;
        String fecha;
        String servicioDescripcion;
        String cuerpoCorreo;
        
        // Se itera para cada una de las citas y se obtiene únicamente el valor del identificador de la cita.
        for (String citaInfo : citasInfo){
            identificadores.add(Integer.valueOf(citaInfo.substring(23, citaInfo.indexOf("\'", 23))));
        }
        // Se intenta enviar un correo a todos los usuarios de la lista, si el proceso se da con éxito se retorna true.
        try{
            // Se itera para cada uno de los identificadores para poder enviar un correo.
            for (Integer id : identificadores){
                Cita cita = obtenerCita(id);
                // Se obtienen atributos importantes para enviar por el correo.
                hora = cita.getHoraToString();
                correo = cita.getCliente().getEmail();
                nombre = cita.getCliente().getNombre();
                fecha = cita.getFecha().toString();
                servicioDescripcion = cita.getServicio().getDescripcion();
                cuerpoCorreo = "Estimad@  " + nombre+ ": <p/>" + "Se le recuerda confirmar su cita para el día " + fecha +
                        " a la hora " + hora + " para su cita de " + servicioDescripcion + ".<p/> Atentamente, Barberia Millenium.";
                enviarCorreo(correo, cuerpoCorreo);
            }
            return true;
        // En caso de que algo falle, se imprime en terminal el error y se retorna false.
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }  
    }
    
    // Método para guardar los datos, recibe como parámetro un control.
    public static void guardarDatos(Control control){
        try{
            FileOutputStream file = new FileOutputStream("ControlData.bin");
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(control);
            stream.close();
            file.close();
            System.out.println("Se han guardado los datos exitosamente.");
        }catch(Exception e){
                System.out.println("Error: " + e);
         }
    }
    
    // Método para cargar los datos, retorna un control.
    private static Control cargarDatos() throws FileNotFoundException, IOException, ClassNotFoundException{
        Control control = new Control();
        FileInputStream file = new FileInputStream("ControlData.bin");
        ObjectInputStream stream = new ObjectInputStream(file);
        control = (Control) stream.readObject();
        control.reasignarConsecutivoCitas();
        return control;
    }
    
}

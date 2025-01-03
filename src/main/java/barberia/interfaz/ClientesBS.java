package barberia.interfaz;

// Paquetes utilizados
import barberia.control.Control;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// ClientesBS: Clase que se encarga de la ventana para el funcionamiento del menú de clientes.
public class ClientesBS extends javax.swing.JFrame {
    // Variables utilizadas
    private Control control;
    private ArrayList<String> infoClientes;
    /**
     * Creates new form ClientesBS
     */
    
    // Constructor
    public ClientesBS() {
        control = Control.getInstance();
        infoClientes = control.verClientes();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addClientButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientesList = new javax.swing.JList(infoClientes.toArray(new String[infoClientes.size()]));
        modifyClientButton = new javax.swing.JButton();
        removeClientButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        showAppointmentsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Clientes");
        setResizable(false);

        addClientButton.setText("Agregar Cliente");
        addClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClientButtonActionPerformed(evt);
            }
        });

        clientesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(clientesList);

        modifyClientButton.setText("Modificar Cliente");
        modifyClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyClientButtonActionPerformed(evt);
            }
        });

        removeClientButton.setText("Eliminar Cliente");
        removeClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeClientButtonActionPerformed(evt);
            }
        });

        returnButton.setBackground(new java.awt.Color(32, 31, 31));
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setText("Regresar al menú");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        showAppointmentsButton.setText("Consultar Citas");
        showAppointmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAppointmentsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addClientButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(removeClientButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(showAppointmentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(addClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modifyClientButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeClientButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showAppointmentsButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
     // Método para agregar un cliente mediante un botón.
    private void addClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClientButtonActionPerformed
        // Se abre la venta para modificar el cliente, sin pasar como parámetro algún tipo de información.
        dispose();
        ModificarCliente clienteModify = new ModificarCliente();
        clienteModify.setVisible(true);
    }//GEN-LAST:event_addClientButtonActionPerformed
    
    // Método para modificar un cliente mediante un botón.
    private void modifyClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyClientButtonActionPerformed
       // Se intenta seleccionar un cliente.
        try{
          // Se obtiene el identificador del cliente.
         String identificadorMail = clientesList.getSelectedValue();
         identificadorMail = identificadorMail.substring(19, identificadorMail.indexOf("\'", 19));
         // Se obtienen los datos del cliente en formato Array List y se cierra la ventana actual.
         ArrayList<String> clienteDatos = control.getInfoCliente(identificadorMail);
         dispose();
         // Se abre la ventana para modificar el cliente.
         ModificarCliente clienteModify = new ModificarCliente(identificadorMail, clienteDatos.get(0),
                 clienteDatos.get(1), clienteDatos.get(2));
         clienteModify.setVisible(true);
       //  Si el usuario no ha seleccionado un cliente, entonces se le dice que por favor selecione un cliente.  
       }catch (NullPointerException ne){
         JOptionPane.showMessageDialog(this, "Seleccione el cliente que desea modificar.",
                 "Advertencia", JOptionPane.WARNING_MESSAGE);    
        // Cualquiera otro error, será atrapado en este bloque de código.
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido algún error, intente de nuevo más tarde. .",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
        }          
    }//GEN-LAST:event_modifyClientButtonActionPerformed

    // Método para regresar al menú principal mediante un botón.
    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
       // Se pregunta al usuario si desea volver al menú principal
        int result = JOptionPane.showConfirmDialog(this, "¿Desea volver al menú principal?",
               "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       // Si la respuesta es afirmativa entonces se cierra la ventana actual y se abre la ventana de menú principal.
        if (result == JOptionPane.YES_OPTION){
           dispose();
           Barberia barberia = new Barberia();
           barberia.setVisible(true);
       }
    }//GEN-LAST:event_returnButtonActionPerformed
    
     // Método para eliminar un cliente mediante un botón.
    private void removeClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeClientButtonActionPerformed
       // Se intenta seleccionar un cliente.
        try{
            // Se obtiene el identificador del cliente.
            String identificadorMail = clientesList.getSelectedValue();
            identificadorMail = identificadorMail.substring(19, identificadorMail.indexOf("\'", 19));
            // Si el cliente no tiene citas pendientes y tampoco se encuentra en lista de espera, entonces se pregunta al usuario
            // si desea eliminar al cliente.
            if (control.verCitasCliente(identificadorMail).isEmpty() == true && control.clienteEspera(identificadorMail) == false){
                int result = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el cliente solicitado ?",
                   "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                // En caso de que la respuesta sea afirmativa, entonces se elimina el cliente y se guardan los datos.
                if (result == JOptionPane.YES_OPTION){
                     control.eliminarCliente(identificadorMail);
                     Control.guardarDatos(control);
                     JOptionPane.showMessageDialog(this, "Se ha eliminado el cliente solicitado exitosamente.", 
                             "Notificación", JOptionPane.INFORMATION_MESSAGE);
                     // Se abre la venta para modificar el servicio.
                     dispose();
                     ClientesBS clientesMenu = new ClientesBS();
                     clientesMenu.setVisible(true);
                }
           // Si el cliente tiene alguna cita asociada o se encuentra en lista de espera, se le dará una advertencia al usuario.
            }else{
                JOptionPane.showMessageDialog(this, "El cliente tiene citas o está en lista de espera, intente de nuevo con otro.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);                    
                }
         //  Si el usuario no ha seleccionado un cliente, entonces se le dice que por favor selecione un cliente.    
        }catch(NullPointerException ne){
            JOptionPane.showMessageDialog(this, "Seleccione el cliente que desea eliminar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        // Cualquiera otro error, será atrapado en este bloque de código.
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido algún error, intente de nuevo más tarde. .",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
        }          
    }//GEN-LAST:event_removeClientButtonActionPerformed

    private void showAppointmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAppointmentsButtonActionPerformed
        // Se intenta seleccionar un cliente.
        try{
            // Se obtiene el identificador del cliente.
            String identificadorMail = clientesList.getSelectedValue();
            identificadorMail = identificadorMail.substring(19, identificadorMail.indexOf("\'", 19));
            // Si el usuairo no tiene citas, entonces se le dará una advertencia al usuario.
            if (control.verCitasCliente(identificadorMail).isEmpty() == true){
                    JOptionPane.showMessageDialog(this, "Este cliente no tiene citas asociadas por el momento.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);                
            // En caso de tener citas por visualizar, se cierra la ventana actual y se abre una venta con las citas
            // del cliente solicitado.
            }else{
                dispose();
                CitasCliente clienteAppointments = new CitasCliente(identificadorMail);
                clienteAppointments.setVisible(true);
            }
        //  Si el usuario no ha seleccionado un cliente, entonces se le dice que por favor selecione un cliente.  
        }catch(NullPointerException ne){
                    JOptionPane.showMessageDialog(this, "Seleccione el cliente al cual desea consultar las citas.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
        // Cualquiera otro error, será atrapado en este bloque de código.
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido algún error, intente de nuevo más tarde. .",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
        }                
    }//GEN-LAST:event_showAppointmentsButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientesBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesBS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClientButton;
    private javax.swing.JList<String> clientesList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyClientButton;
    private javax.swing.JButton removeClientButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton showAppointmentsButton;
    // End of variables declaration//GEN-END:variables
}
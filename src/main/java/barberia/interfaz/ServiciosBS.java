package barberia.interfaz;

import barberia.control.Control;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// ServiciosBS: Clase que se encarga de la ventana para el funcionamiento del menú de servicios.
public class ServiciosBS extends javax.swing.JFrame {
    private Control control;
    private ArrayList<String> infoServicios;
    /**
     * Creates new form ServiciosBS
     */
    public ServiciosBS() {
        control = Control.getInstance();
        infoServicios = control.verServicios();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        serviciosList = new javax.swing.JList(infoServicios.toArray(new String[infoServicios.size()]));
        addServiceButton = new javax.swing.JButton();
        modifyServiceButton = new javax.swing.JButton();
        removeServiceButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Servicios");
        setResizable(false);

        serviciosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(serviciosList);

        addServiceButton.setText("Agregar Servicio");
        addServiceButton.setPreferredSize(new java.awt.Dimension(125, 25));
        addServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addServiceButtonActionPerformed(evt);
            }
        });

        modifyServiceButton.setText("Modificar Servicio");
        modifyServiceButton.setPreferredSize(new java.awt.Dimension(125, 25));
        modifyServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyServiceButtonActionPerformed(evt);
            }
        });

        removeServiceButton.setText("Eliminar Servicio");
        removeServiceButton.setPreferredSize(new java.awt.Dimension(125, 25));
        removeServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeServiceButtonActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeServiceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifyServiceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addServiceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(addServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modifyServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(returnButton)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Método para establecer el mismo horario a todos los días.
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
    
    // Método para agregar un servicio mediante un botón.
    private void addServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServiceButtonActionPerformed
        // Se abre la venta para modificar el servicio, sin pasar como parámetro algún tipo de información.
        dispose();
        ModificarServicio servicioModify = new ModificarServicio();
        servicioModify.setVisible(true);
    }//GEN-LAST:event_addServiceButtonActionPerformed
    
    // Método para modificar un servicio mediante un botón.
    private void modifyServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyServiceButtonActionPerformed
       // Se intenta seleccionar un servicio.
        try{
            // Se obtiene el identificador del servicio.
            String identificadorDescripcion = serviciosList.getSelectedValue();
            identificadorDescripcion = identificadorDescripcion.substring(25, identificadorDescripcion.indexOf("\'", 25));
            // Se abre la venta para modificar el servicio.
            dispose();
            ModificarServicio servicioModify = new ModificarServicio(identificadorDescripcion);
            servicioModify.setVisible(true);
       // Si no se ha podido seleccionar un servicio entonces, se advierte al usuario.
        }catch (NullPointerException ne){
         JOptionPane.showMessageDialog(this, "Seleccione el servicio que desea modificar.",
                 "Advertencia", JOptionPane.WARNING_MESSAGE);    
        // Cualquiera otro error, será atrapado en este bloque de código.
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido algún error, intente de nuevo más tarde. .",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_modifyServiceButtonActionPerformed
    
    // Método para eliminar un servicio mediante un botón.
    private void removeServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeServiceButtonActionPerformed
        // Se intenta seleccionar un servicio.
        try{
            // Se obtiene el identificador del servicio.
            String identificadorDescripcion = serviciosList.getSelectedValue();
            identificadorDescripcion = identificadorDescripcion.substring(25, identificadorDescripcion.indexOf("\'", 25));
            // Si el servicio no está asociado con ninguna cita entonces se le pregunta al usuario si desea
            // eliminar el servicio.
            if (control.servicioConCita(identificadorDescripcion) == false){
                int result = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el servicio solicitado ?",
                   "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                // En caso de que la respuesta sea afirmatica entonces se elimina el servicio y se guarda en el sistema
                if (result == JOptionPane.YES_OPTION){
                     control.eliminarServicio(identificadorDescripcion);
                     Control.guardarDatos(control);
                     JOptionPane.showMessageDialog(this, "Se ha eliminado el servicio solicitado exitosamente.", 
                             "Notificación", JOptionPane.INFORMATION_MESSAGE);
                     // Se cierra la venta actual y se abre una nueva del mismo tipo.
                     dispose();
                     ServiciosBS serviciosMenu = new ServiciosBS();
                     serviciosMenu.setVisible(true);
                }
            // En caso de que el servicio tenga algina cita relacionada entoncés se avisará al usuario.
            }else{
                JOptionPane.showMessageDialog(this, "El servicio está asociado a alguna cita, intente de nuevo con otro.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);                
            }
        // Si no se ha podido seleccionar un servicio entonces, se advierte al usuario.
        }catch(NullPointerException ne){
            JOptionPane.showMessageDialog(this, "Seleccione el servicio que desea eliminar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        // Cualquiera otro error, será atrapado en este bloque de código.
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido algún error, intente de nuevo más tarde. .",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_removeServiceButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ServiciosBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiciosBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiciosBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiciosBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiciosBS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addServiceButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyServiceButton;
    private javax.swing.JButton removeServiceButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JList<String> serviciosList;
    // End of variables declaration//GEN-END:variables
}

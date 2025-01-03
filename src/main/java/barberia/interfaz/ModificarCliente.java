package barberia.interfaz;

// Paquetes utilizados
import barberia.control.Control;
import barberia.control.DataVerification;
import javax.swing.JOptionPane;

// ModificarCliente: Clase que se encarga de la ventana para agregar o modificar los atributos de un cliente.
public class ModificarCliente extends javax.swing.JFrame {
    // Variables utilizadas
    private Control control;
    private String identificador;
    private boolean includesData;
    /**
     * Creates new form CreateCliente
     */
    
    // Constructor #1
    public ModificarCliente(){
        control = Control.getInstance();
        includesData = false;
        initComponents();
    }
    
    // Constructor #2
    public ModificarCliente(String identificador, String nombre, String email, String phoneNum){
        this.identificador = identificador;
        includesData = true;
        control = Control.getInstance();
        initComponents();
        emailTextField.setText(email);
        nameTextField.setText(nombre);
        phoneTextField.setText(phoneNum);
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
        jTextArea1 = new javax.swing.JTextArea();
        nameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Cliente");
        setResizable(false);

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Email");

        jLabel3.setText("Teléfono");

        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneTextField)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton)
                    .addComponent(cancelButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed
    
     //  Método para aceptar los cambios modificados en un cliente mediante un botón.
    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
         // Se crea una variable para inicializar el menú de clientes.
        ClientesBS clientesMenu;        
        // Se obtienen los valores de los espacios de texto.
        String email = emailTextField.getText();
        String phoneNum = phoneTextField.getText();
        String name = nameTextField.getText();
        
        // Se intenta primero validar el número de teléfono, si el número no se logra validar, se advierte al usuario.
        if (DataVerification.validatePhoneNumber(phoneNum) == false){
                JOptionPane.showMessageDialog(this, "Por favor verifique el número de teléfono ingresado.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
        // Luego se intenta validar el correo, si el correo no se logra validar, se advierte al usuario.        
        }else if (DataVerification.validateEmail(email) == false){
                JOptionPane.showMessageDialog(this, "Por favor verifique el correo ingresado.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
        // Si las restricciones anteriores se cumplen, entonces se revisarán otras.      
        }else{
                 // Si no se incluye información, entonces se tiene que agregar la cita.
                if (includesData == false){
                    // Revisar que el cliente no se encuentre asociado a un correo existente.
                    if (control.clienteExiste(email) == true)
                        JOptionPane.showMessageDialog(this, "Este cliente ya se encuentra registrado, intente con otro correo.",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                   // En caso de que el cliente no tengo un correo relacionado en el sistema, entonces se crea el cliente y se almacena.
                    else{
                        control.agregarCliente(name, email, phoneNum);
                        Control.guardarDatos(control);
                        JOptionPane.showMessageDialog(this, "Se ha creado el cliente exitosamente.",
                                "Notificación", JOptionPane.INFORMATION_MESSAGE);
                        // Se cierra la ventana actual y se abre nuevamente el menú de clientes.
                        dispose();
                        clientesMenu = new ClientesBS();
                        clientesMenu.setVisible(true);
                    }
                // Si se incluye la información, entonces se tiene que modificar el cliente.    
                }else{
                    // Revisar que el correo no este relacionado con un cliente ya existente distinto al cliente que se modifica.
                    if (control.clienteExiste(email) == true && !email.equals(identificador))
                        JOptionPane.showMessageDialog(this, "Este cliente ya se encuentra registrado, intente con otro correo.",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                    // En caso de que el cliente no tengo un correo relacionado en el sistema o corresponda al mismo cliente,
                    // entonces se modifica el cliente y se almacena. 
                    else{
                        control.modificarCliente(identificador, name, email, phoneNum);
                        Control.guardarDatos(control);
                        JOptionPane.showMessageDialog(this, "Se ha modificado el cliente exitosamente.",
                                "Notificación", JOptionPane.INFORMATION_MESSAGE);
                        // Se cierra la ventana actual y se abre nuevamente el menú de clientes.
                        dispose();
                        clientesMenu = new ClientesBS();
                        clientesMenu.setVisible(true);
                   }
                }
        }
    }//GEN-LAST:event_acceptButtonActionPerformed
    
    // Método para cancelar los cambios y regresar al menú de clientes mediante un botón.
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
       // Se pregunta al usuario si desea volver al menú de clientes.
        int result = JOptionPane.showConfirmDialog(this, "¿Desea volver al menú de clientes?",
               "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       // Si la respuesta es afirmativa entonces se cierra la ventana actual y se abre la ventana del menu de clientes.
        if (result == JOptionPane.YES_OPTION){
           dispose();
           ClientesBS clientesMenu = new ClientesBS();
           clientesMenu.setVisible(true);
       }
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneTextField;
    // End of variables declaration//GEN-END:variables
}